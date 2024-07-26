package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuiyishiYuyueEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 会议室预约 服务类
 */
public interface HuiyishiYuyueService extends IService<HuiyishiYuyueEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}