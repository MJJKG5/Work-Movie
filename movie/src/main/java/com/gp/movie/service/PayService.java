package com.gp.movie.service;

import com.gp.movie.model.entity.ResApi;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface PayService {
    /**
     * 支付
     *
     * @param seatIds 座位id集合
     * @param request 请求
     * @return
     */
    ResApi<String> pay(List<Long> seatIds, HttpServletRequest request);
}