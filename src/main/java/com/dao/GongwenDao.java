package com.dao;

import com.entity.GongwenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GongwenView;

/**
 * 公文 Dao 接口
 *
 * @author 
 */
public interface GongwenDao extends BaseMapper<GongwenEntity> {

   List<GongwenView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
