package com.dao;

import com.entity.XinfangdubanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XinfangdubanView;

/**
 * 信访督办 Dao 接口
 *
 * @author 
 */
public interface XinfangdubanDao extends BaseMapper<XinfangdubanEntity> {

   List<XinfangdubanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
