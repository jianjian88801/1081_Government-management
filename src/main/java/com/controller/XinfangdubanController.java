
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
 * 信访督办
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xinfangduban")
public class XinfangdubanController {
    private static final Logger logger = LoggerFactory.getLogger(XinfangdubanController.class);

    @Autowired
    private XinfangdubanService xinfangdubanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private LaifangdengjiService laifangdengjiService;

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
        PageUtils page = xinfangdubanService.queryPage(params);

        //字典表数据转换
        List<XinfangdubanView> list =(List<XinfangdubanView>)page.getList();
        for(XinfangdubanView c:list){
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
        XinfangdubanEntity xinfangduban = xinfangdubanService.selectById(id);
        if(xinfangduban !=null){
            //entity转view
            XinfangdubanView view = new XinfangdubanView();
            BeanUtils.copyProperties( xinfangduban , view );//把实体数据重构到view中

                //级联表
                LaifangdengjiEntity laifangdengji = laifangdengjiService.selectById(xinfangduban.getLaifangdengjiId());
                if(laifangdengji != null){
                    BeanUtils.copyProperties( laifangdengji , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLaifangdengjiId(laifangdengji.getId());
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
    public R save(@RequestBody XinfangdubanEntity xinfangduban, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xinfangduban:{}",this.getClass().getName(),xinfangduban.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XinfangdubanEntity> queryWrapper = new EntityWrapper<XinfangdubanEntity>()
            .eq("laifangdengji_id", xinfangduban.getLaifangdengjiId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinfangdubanEntity xinfangdubanEntity = xinfangdubanService.selectOne(queryWrapper);
        if(xinfangdubanEntity==null){
            xinfangduban.setInsertTime(new Date());
            xinfangduban.setCreateTime(new Date());
            xinfangdubanService.insert(xinfangduban);
            return R.ok();
        }else {
            return R.error(511,"该信访已经督办过了");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XinfangdubanEntity xinfangduban, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xinfangduban:{}",this.getClass().getName(),xinfangduban.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<XinfangdubanEntity> queryWrapper = new EntityWrapper<XinfangdubanEntity>()
            .notIn("id",xinfangduban.getId())
            .andNew()
            .eq("laifangdengji_id", xinfangduban.getLaifangdengjiId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinfangdubanEntity xinfangdubanEntity = xinfangdubanService.selectOne(queryWrapper);
        if(xinfangdubanEntity==null){
            xinfangdubanService.updateById(xinfangduban);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该信访已经督办过了");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xinfangdubanService.deleteBatchIds(Arrays.asList(ids));
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
            List<XinfangdubanEntity> xinfangdubanList = new ArrayList<>();//上传的东西
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
                            XinfangdubanEntity xinfangdubanEntity = new XinfangdubanEntity();
//                            xinfangdubanEntity.setLaifangdengjiId(Integer.valueOf(data.get(0)));   //来访登记 要改的
//                            xinfangdubanEntity.setXinfangdubanUuidNumber(data.get(0));                    //督办编号 要改的
//                            xinfangdubanEntity.setXinfangdubanBiaoti(data.get(0));                    //督办标题 要改的
//                            xinfangdubanEntity.setXinfangdubanSuqiuContent("");//详情和图片
//                            xinfangdubanEntity.setInsertTime(date);//时间
//                            xinfangdubanEntity.setCreateTime(date);//时间
                            xinfangdubanList.add(xinfangdubanEntity);


                            //把要查询是否重复的字段放入map中
                                //督办编号
                                if(seachFields.containsKey("xinfangdubanUuidNumber")){
                                    List<String> xinfangdubanUuidNumber = seachFields.get("xinfangdubanUuidNumber");
                                    xinfangdubanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xinfangdubanUuidNumber = new ArrayList<>();
                                    xinfangdubanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xinfangdubanUuidNumber",xinfangdubanUuidNumber);
                                }
                        }

                        //查询是否重复
                         //督办编号
                        List<XinfangdubanEntity> xinfangdubanEntities_xinfangdubanUuidNumber = xinfangdubanService.selectList(new EntityWrapper<XinfangdubanEntity>().in("xinfangduban_uuid_number", seachFields.get("xinfangdubanUuidNumber")));
                        if(xinfangdubanEntities_xinfangdubanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XinfangdubanEntity s:xinfangdubanEntities_xinfangdubanUuidNumber){
                                repeatFields.add(s.getXinfangdubanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [督办编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xinfangdubanService.insertBatch(xinfangdubanList);
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
