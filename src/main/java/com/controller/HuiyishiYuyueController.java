
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
 * 会议室预约
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/huiyishiYuyue")
public class HuiyishiYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(HuiyishiYuyueController.class);

    @Autowired
    private HuiyishiYuyueService huiyishiYuyueService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private HuiyishiService huiyishiService;
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
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = huiyishiYuyueService.queryPage(params);

        //字典表数据转换
        List<HuiyishiYuyueView> list =(List<HuiyishiYuyueView>)page.getList();
        for(HuiyishiYuyueView c:list){
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
        HuiyishiYuyueEntity huiyishiYuyue = huiyishiYuyueService.selectById(id);
        if(huiyishiYuyue !=null){
            //entity转view
            HuiyishiYuyueView view = new HuiyishiYuyueView();
            BeanUtils.copyProperties( huiyishiYuyue , view );//把实体数据重构到view中

                //级联表
                HuiyishiEntity huiyishi = huiyishiService.selectById(huiyishiYuyue.getHuiyishiId());
                if(huiyishi != null){
                    BeanUtils.copyProperties( huiyishi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setHuiyishiId(huiyishi.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(huiyishiYuyue.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody HuiyishiYuyueEntity huiyishiYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huiyishiYuyue:{}",this.getClass().getName(),huiyishiYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            huiyishiYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<HuiyishiYuyueEntity> queryWrapper = new EntityWrapper<HuiyishiYuyueEntity>()
            .eq("yonghu_id", huiyishiYuyue.getYonghuId())
            .eq("huiyishi_id", huiyishiYuyue.getHuiyishiId())
            .eq("huiyishi_yuyue_uuid_number", huiyishiYuyue.getHuiyishiYuyueUuidNumber())
            .eq("huiyishi_yuyue_mingcheng", huiyishiYuyue.getHuiyishiYuyueMingcheng())
            .eq("huiyishi_yuyue_types", huiyishiYuyue.getHuiyishiYuyueTypes())
            .eq("huiyishi_yuyue_yesno_types", huiyishiYuyue.getHuiyishiYuyueYesnoTypes())
            .eq("huiyishi_yuyue_yesno_text", huiyishiYuyue.getHuiyishiYuyueYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuiyishiYuyueEntity huiyishiYuyueEntity = huiyishiYuyueService.selectOne(queryWrapper);
        if(huiyishiYuyueEntity==null){
            huiyishiYuyue.setInsertTime(new Date());
            huiyishiYuyue.setHuiyishiYuyueYesnoTypes(1);
            huiyishiYuyue.setCreateTime(new Date());
            huiyishiYuyueService.insert(huiyishiYuyue);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuiyishiYuyueEntity huiyishiYuyue, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,huiyishiYuyue:{}",this.getClass().getName(),huiyishiYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            huiyishiYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<HuiyishiYuyueEntity> queryWrapper = new EntityWrapper<HuiyishiYuyueEntity>()
            .notIn("id",huiyishiYuyue.getId())
            .andNew()
            .eq("yonghu_id", huiyishiYuyue.getYonghuId())
            .eq("huiyishi_id", huiyishiYuyue.getHuiyishiId())
            .eq("huiyishi_yuyue_uuid_number", huiyishiYuyue.getHuiyishiYuyueUuidNumber())
            .eq("huiyishi_yuyue_mingcheng", huiyishiYuyue.getHuiyishiYuyueMingcheng())
            .eq("huiyishi_yuyue_types", huiyishiYuyue.getHuiyishiYuyueTypes())
            .eq("insert_time", huiyishiYuyue.getInsertTime())
            .eq("shiyong_kaishi_time", huiyishiYuyue.getShiyongKaishiTime())
            .eq("shiyong_jieshu_time", huiyishiYuyue.getShiyongJieshuTime())
            .eq("huiyishi_yuyue_yesno_types", huiyishiYuyue.getHuiyishiYuyueYesnoTypes())
            .eq("huiyishi_yuyue_yesno_text", huiyishiYuyue.getHuiyishiYuyueYesnoText())
            .eq("huiyishi_yuyue_shenhe_time", huiyishiYuyue.getHuiyishiYuyueShenheTime())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuiyishiYuyueEntity huiyishiYuyueEntity = huiyishiYuyueService.selectOne(queryWrapper);
        if(huiyishiYuyueEntity==null){
            huiyishiYuyueService.updateById(huiyishiYuyue);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody HuiyishiYuyueEntity huiyishiYuyue, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,huiyishiYuyue:{}",this.getClass().getName(),huiyishiYuyue.toString());

//        if(huiyishiYuyue.getHuiyishiYuyueYesnoTypes() == 2){//通过
//            huiyishiYuyue.setHuiyishiYuyueTypes();
//        }else if(huiyishiYuyue.getHuiyishiYuyueYesnoTypes() == 3){//拒绝
//            huiyishiYuyue.setHuiyishiYuyueTypes();
//        }
        huiyishiYuyue.setHuiyishiYuyueShenheTime(new Date());//审核时间
        huiyishiYuyueService.updateById(huiyishiYuyue);//审核
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        huiyishiYuyueService.deleteBatchIds(Arrays.asList(ids));
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
            List<HuiyishiYuyueEntity> huiyishiYuyueList = new ArrayList<>();//上传的东西
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
                            HuiyishiYuyueEntity huiyishiYuyueEntity = new HuiyishiYuyueEntity();
//                            huiyishiYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            huiyishiYuyueEntity.setHuiyishiId(Integer.valueOf(data.get(0)));   //会议室 要改的
//                            huiyishiYuyueEntity.setHuiyishiYuyueUuidNumber(data.get(0));                    //会议室预约编号 要改的
//                            huiyishiYuyueEntity.setHuiyishiYuyueMingcheng(data.get(0));                    //会议室预约名称 要改的
//                            huiyishiYuyueEntity.setHuiyishiYuyueTypes(Integer.valueOf(data.get(0)));   //会议室预约类型 要改的
//                            huiyishiYuyueEntity.setHuiyishiYuyueContent("");//详情和图片
//                            huiyishiYuyueEntity.setInsertTime(date);//时间
//                            huiyishiYuyueEntity.setShiyongKaishiTime(sdf.parse(data.get(0)));          //使用开始时间 要改的
//                            huiyishiYuyueEntity.setShiyongJieshuTime(sdf.parse(data.get(0)));          //使用结束时间 要改的
//                            huiyishiYuyueEntity.setHuiyishiYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            huiyishiYuyueEntity.setHuiyishiYuyueYesnoText(data.get(0));                    //审核意见 要改的
//                            huiyishiYuyueEntity.setHuiyishiYuyueShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            huiyishiYuyueEntity.setCreateTime(date);//时间
                            huiyishiYuyueList.add(huiyishiYuyueEntity);


                            //把要查询是否重复的字段放入map中
                                //会议室预约编号
                                if(seachFields.containsKey("huiyishiYuyueUuidNumber")){
                                    List<String> huiyishiYuyueUuidNumber = seachFields.get("huiyishiYuyueUuidNumber");
                                    huiyishiYuyueUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> huiyishiYuyueUuidNumber = new ArrayList<>();
                                    huiyishiYuyueUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("huiyishiYuyueUuidNumber",huiyishiYuyueUuidNumber);
                                }
                        }

                        //查询是否重复
                         //会议室预约编号
                        List<HuiyishiYuyueEntity> huiyishiYuyueEntities_huiyishiYuyueUuidNumber = huiyishiYuyueService.selectList(new EntityWrapper<HuiyishiYuyueEntity>().in("huiyishi_yuyue_uuid_number", seachFields.get("huiyishiYuyueUuidNumber")));
                        if(huiyishiYuyueEntities_huiyishiYuyueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuiyishiYuyueEntity s:huiyishiYuyueEntities_huiyishiYuyueUuidNumber){
                                repeatFields.add(s.getHuiyishiYuyueUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [会议室预约编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        huiyishiYuyueService.insertBatch(huiyishiYuyueList);
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
