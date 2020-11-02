package com.gp.movie.controller;

import com.gp.movie.model.entity.ResApi;
import com.gp.movie.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 查询订单
     *
     * @param request  请求
     * @param id       订单id
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    @RequestMapping(value = "order", method = RequestMethod.GET)
    public ResApi<Map<String, Object>> queryOrder(@RequestParam(required = false) Long id,
                                                  @RequestParam Integer pageNo,
                                                  @RequestParam Integer pageSize,
                                                  HttpServletRequest request) {
        return orderService.queryOrder(id, pageNo, pageSize, request);
    }

    /**
     * 删除订单
     *
     * @param ids 订单id集合
     * @return
     */
    @RequestMapping(value = "order", method = RequestMethod.DELETE)
    public ResApi<String> deleteOrder(@RequestParam List<Long> ids) {
        return orderService.deleteOrder(ids);
    }
}
