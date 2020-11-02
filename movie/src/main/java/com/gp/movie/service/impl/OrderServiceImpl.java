package com.gp.movie.service.impl;

import com.gp.movie.common.utils.Check;
import com.gp.movie.common.utils.Session;
import com.gp.movie.model.Order;
import com.gp.movie.model.entity.Page;
import com.gp.movie.model.entity.ResApi;
import com.gp.movie.repository.OrderMapper;
import com.gp.movie.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 查询订单
     *
     * @param id       订单id
     * @param pageNo   页码
     * @param pageSize 页大小
     * @param request  请求
     * @return
     */
    @Override
    public ResApi<Map<String, Object>> queryOrder(Long id, Integer pageNo, Integer pageSize, HttpServletRequest request) {
        Check.isNull(pageNo, "pageNo 参数为空");
        Check.isNull(pageSize, "pageSize 参数为空");
        // 获取账户id
        Long accountId = new Session(request).accountId();
        // 查询数量
        Long total = orderMapper.count(id, accountId);
        // 分页
        Page page = new Page(pageNo, pageSize, total);
        // 查询订单
        List<Order> orders = orderMapper.queryByList(id, accountId, page);

        Map<String, Object> map = new HashMap<>();
        map.put("orders", orders);
        map.put("page", page);
        return new ResApi<>(map);
    }

    /**
     * 删除订单
     *
     * @param ids 订单id集合
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> deleteOrder(List<Long> ids) {
        Check.isNull(ids, "ids 参数为空");
        // 删除订单
        orderMapper.delete(ids);

        return new ResApi<>();
    }
}
