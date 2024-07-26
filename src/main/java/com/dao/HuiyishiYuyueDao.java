package com.dao;

import com.entity.HuiyishiYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HuiyishiYuyueView;

/**
 * 会议室预约 Dao 接口
 *
 * @author 
 */
public interface HuiyishiYuyueDao extends BaseMapper<HuiyishiYuyueEntity> {

   List<HuiyishiYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
