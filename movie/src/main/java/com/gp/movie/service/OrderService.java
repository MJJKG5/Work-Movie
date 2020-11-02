package com.gp.movie.service;

import com.gp.movie.model.entity.ResApi;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface OrderService {
    /**
     * 查询订单
     *
     * @param id       订单id
     * @param pageNo   页码
     * @param pageSize 页大小
     * @param request  请求
     * @return
     */
    ResApi<Map<String, Object>> queryOrder(Long id, Integer pageNo, Integer pageSize, HttpServletRequest request);

    /**
     * 删除订单
     *
     * @param ids 订单id集合
     * @return
     */
    ResApi<String> deleteOrder(List<Long> ids);
}
