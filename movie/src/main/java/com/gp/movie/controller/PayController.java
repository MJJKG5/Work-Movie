package com.gp.movie.controller;

import com.gp.movie.model.entity.ResApi;
import com.gp.movie.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("api")
public class PayController {
    @Autowired
    private PayService payService;

    /**
     * 支付
     *
     * @param seatIds 座位id集合
     * @param request 请求
     * @return
     */
    @RequestMapping(value = "pay", method = RequestMethod.POST)
    public ResApi<String> pay(@RequestBody List<Long> seatIds, HttpServletRequest request) {
        return payService.pay(seatIds, request);
    }
}