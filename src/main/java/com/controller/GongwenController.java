
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 公文
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/gongwen")
public class GongwenController {
    private static final Logger logger = LoggerFactory.getLogger(GongwenController.class);

    @Autowired
    private GongwenService gongwenService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role)){
            YonghuEntity yonghuEntity = yonghuService.selectById((Integer) request.getSession().getAttribute("userId"));

            params.put("danweiTypes11",yonghuEntity.getDanweiTypes());

        }
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = gongwenService.queryPage(params);

        //字典表数据转换
        List<GongwenView> list =(List<GongwenView>)page.getList();
        for(GongwenView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GongwenEntity gongwen = gongwenService.selectById(id);
        if(gongwen !=null){
            //entity转view
            GongwenView view = new GongwenView();
            BeanUtils.copyProperties( gongwen , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(gongwen.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "danweiTypes"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                    view.setYonghuDanweiTypes(yonghu.getDanweiTypes());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody GongwenEntity gongwen, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gongwen:{}",this.getClass().getName(),gongwen.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            gongwen.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<GongwenEntity> queryWrapper = new EntityWrapper<GongwenEntity>()
            .eq("yonghu_id", gongwen.getYonghuId())
            .eq("gongwen_uuid_number", gongwen.getGongwenUuidNumber())
            .eq("nianhao_types", gongwen.getNianhaoTypes())
            .eq("gongwen_fenhao", gongwen.getGongwenFenhao())
            .eq("danwei_types", gongwen.getDanweiTypes())
            .eq("gongwen_name", gongwen.getGongwenName())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongwenEntity gongwenEntity = gongwenService.selectOne(queryWrapper);
        if(gongwenEntity==null){
            gongwen.setInsertTime(new Date());
            gongwen.setCreateTime(new Date());
            gongwenService.insert(gongwen);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GongwenEntity gongwen, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,gongwen:{}",this.getClass().getName(),gongwen.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            gongwen.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<GongwenEntity> queryWrapper = new EntityWrapper<GongwenEntity>()
            .notIn("id",gongwen.getId())
            .andNew()
            .eq("yonghu_id", gongwen.getYonghuId())
            .eq("gongwen_uuid_number", gongwen.getGongwenUuidNumber())
            .eq("nianhao_types", gongwen.getNianhaoTypes())
            .eq("gongwen_fenhao", gongwen.getGongwenFenhao())
            .eq("danwei_types", gongwen.getDanweiTypes())
            .eq("gongwen_name", gongwen.getGongwenName())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GongwenEntity gongwenEntity = gongwenService.selectOne(queryWrapper);
        if("".equals(gongwen.getGongwenFile()) || "null".equals(gongwen.getGongwenFile())){
                gongwen.setGongwenFile(null);
        }
        if(gongwenEntity==null){
            gongwenService.updateById(gongwen);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        gongwenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<GongwenEntity> gongwenList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            GongwenEntity gongwenEntity = new GongwenEntity();
//                            gongwenEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            gongwenEntity.setGongwenUuidNumber(data.get(0));                    //文号 要改的
//                            gongwenEntity.setNianhaoTypes(Integer.valueOf(data.get(0)));   //公文年号 要改的
//                            gongwenEntity.setGongwenFenhao(data.get(0));                    //份号 要改的
//                            gongwenEntity.setDanweiTypes(Integer.valueOf(data.get(0)));   //接收单位 要改的
//                            gongwenEntity.setGongwenName(data.get(0));                    //公文标题 要改的
//                            gongwenEntity.setGongwenFile(data.get(0));                    //公文附件 要改的
//                            gongwenEntity.setGongwenContent("");//详情和图片
//                            gongwenEntity.setInsertTime(date);//时间
//                            gongwenEntity.setCreateTime(date);//时间
                            gongwenList.add(gongwenEntity);


                            //把要查询是否重复的字段放入map中
                                //文号
                                if(seachFields.containsKey("gongwenUuidNumber")){
                                    List<String> gongwenUuidNumber = seachFields.get("gongwenUuidNumber");
                                    gongwenUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> gongwenUuidNumber = new ArrayList<>();
                                    gongwenUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("gongwenUuidNumber",gongwenUuidNumber);
                                }
                        }

                        //查询是否重复
                         //文号
                        List<GongwenEntity> gongwenEntities_gongwenUuidNumber = gongwenService.selectList(new EntityWrapper<GongwenEntity>().in("gongwen_uuid_number", seachFields.get("gongwenUuidNumber")));
                        if(gongwenEntities_gongwenUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GongwenEntity s:gongwenEntities_gongwenUuidNumber){
                                repeatFields.add(s.getGongwenUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [文号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        gongwenService.insertBatch(gongwenList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
