
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
 * 来访登记
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/laifangdengji")
public class LaifangdengjiController {
    private static final Logger logger = LoggerFactory.getLogger(LaifangdengjiController.class);

    @Autowired
    private LaifangdengjiService laifangdengjiService;


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
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = laifangdengjiService.queryPage(params);

        //字典表数据转换
        List<LaifangdengjiView> list =(List<LaifangdengjiView>)page.getList();
        for(LaifangdengjiView c:list){
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
        LaifangdengjiEntity laifangdengji = laifangdengjiService.selectById(id);
        if(laifangdengji !=null){
            //entity转view
            LaifangdengjiView view = new LaifangdengjiView();
            BeanUtils.copyProperties( laifangdengji , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(laifangdengji.getYonghuId());
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
    public R save(@RequestBody LaifangdengjiEntity laifangdengji, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,laifangdengji:{}",this.getClass().getName(),laifangdengji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            laifangdengji.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<LaifangdengjiEntity> queryWrapper = new EntityWrapper<LaifangdengjiEntity>()
            .eq("yonghu_id", laifangdengji.getYonghuId())
            .eq("laifangdengji_uuid_number", laifangdengji.getLaifangdengjiUuidNumber())
            .eq("laifangdengji_xingming", laifangdengji.getLaifangdengjiXingming())
            .eq("laifangdengji_phone", laifangdengji.getLaifangdengjiPhone())
            .eq("laifangdengji_mudi_types", laifangdengji.getLaifangdengjiMudiTypes())
            .eq("laifangdengji_chuli_types", laifangdengji.getLaifangdengjiChuliTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LaifangdengjiEntity laifangdengjiEntity = laifangdengjiService.selectOne(queryWrapper);
        if(laifangdengjiEntity==null){
            laifangdengji.setInsertTime(new Date());
            laifangdengji.setCreateTime(new Date());
            laifangdengjiService.insert(laifangdengji);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LaifangdengjiEntity laifangdengji, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,laifangdengji:{}",this.getClass().getName(),laifangdengji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            laifangdengji.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<LaifangdengjiEntity> queryWrapper = new EntityWrapper<LaifangdengjiEntity>()
            .notIn("id",laifangdengji.getId())
            .andNew()
            .eq("yonghu_id", laifangdengji.getYonghuId())
            .eq("laifangdengji_uuid_number", laifangdengji.getLaifangdengjiUuidNumber())
            .eq("laifangdengji_xingming", laifangdengji.getLaifangdengjiXingming())
            .eq("laifangdengji_phone", laifangdengji.getLaifangdengjiPhone())
            .eq("laifangdengji_mudi_types", laifangdengji.getLaifangdengjiMudiTypes())
            .eq("laifangdengji_chuli_types", laifangdengji.getLaifangdengjiChuliTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LaifangdengjiEntity laifangdengjiEntity = laifangdengjiService.selectOne(queryWrapper);
        if(laifangdengjiEntity==null){
            laifangdengjiService.updateById(laifangdengji);//根据id更新
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
        laifangdengjiService.deleteBatchIds(Arrays.asList(ids));
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
            List<LaifangdengjiEntity> laifangdengjiList = new ArrayList<>();//上传的东西
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
                            LaifangdengjiEntity laifangdengjiEntity = new LaifangdengjiEntity();
//                            laifangdengjiEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            laifangdengjiEntity.setLaifangdengjiUuidNumber(data.get(0));                    //唯一编号 要改的
//                            laifangdengjiEntity.setLaifangdengjiXingming(data.get(0));                    //信访人姓名 要改的
//                            laifangdengjiEntity.setLaifangdengjiPhone(data.get(0));                    //信访人电话 要改的
//                            laifangdengjiEntity.setLaifangdengjiSuqiuContent("");//详情和图片
//                            laifangdengjiEntity.setLaifangdengjiShishiContent("");//详情和图片
//                            laifangdengjiEntity.setLaifangdengjiMudiTypes(Integer.valueOf(data.get(0)));   //信访目的 要改的
//                            laifangdengjiEntity.setInsertTime(date);//时间
//                            laifangdengjiEntity.setLaifangdengjiChuliTypes(Integer.valueOf(data.get(0)));   //是否处理 要改的
//                            laifangdengjiEntity.setLaifangdengjiChuliContent("");//详情和图片
//                            laifangdengjiEntity.setChuliTime(sdf.parse(data.get(0)));          //处理时间 要改的
//                            laifangdengjiEntity.setCreateTime(date);//时间
                            laifangdengjiList.add(laifangdengjiEntity);


                            //把要查询是否重复的字段放入map中
                                //唯一编号
                                if(seachFields.containsKey("laifangdengjiUuidNumber")){
                                    List<String> laifangdengjiUuidNumber = seachFields.get("laifangdengjiUuidNumber");
                                    laifangdengjiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> laifangdengjiUuidNumber = new ArrayList<>();
                                    laifangdengjiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("laifangdengjiUuidNumber",laifangdengjiUuidNumber);
                                }
                                //信访人电话
                                if(seachFields.containsKey("laifangdengjiPhone")){
                                    List<String> laifangdengjiPhone = seachFields.get("laifangdengjiPhone");
                                    laifangdengjiPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> laifangdengjiPhone = new ArrayList<>();
                                    laifangdengjiPhone.add(data.get(0));//要改的
                                    seachFields.put("laifangdengjiPhone",laifangdengjiPhone);
                                }
                        }

                        //查询是否重复
                         //唯一编号
                        List<LaifangdengjiEntity> laifangdengjiEntities_laifangdengjiUuidNumber = laifangdengjiService.selectList(new EntityWrapper<LaifangdengjiEntity>().in("laifangdengji_uuid_number", seachFields.get("laifangdengjiUuidNumber")));
                        if(laifangdengjiEntities_laifangdengjiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LaifangdengjiEntity s:laifangdengjiEntities_laifangdengjiUuidNumber){
                                repeatFields.add(s.getLaifangdengjiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [唯一编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //信访人电话
                        List<LaifangdengjiEntity> laifangdengjiEntities_laifangdengjiPhone = laifangdengjiService.selectList(new EntityWrapper<LaifangdengjiEntity>().in("laifangdengji_phone", seachFields.get("laifangdengjiPhone")));
                        if(laifangdengjiEntities_laifangdengjiPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LaifangdengjiEntity s:laifangdengjiEntities_laifangdengjiPhone){
                                repeatFields.add(s.getLaifangdengjiPhone());
                            }
                            return R.error(511,"数据库的该表中的 [信访人电话] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        laifangdengjiService.insertBatch(laifangdengjiList);
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
