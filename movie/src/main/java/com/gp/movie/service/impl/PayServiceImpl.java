package com.gp.movie.service.impl;

import com.gp.movie.common.exception.NullParamException;
import com.gp.movie.common.utils.Session;
import com.gp.movie.model.Order;
import com.gp.movie.model.Screening;
import com.gp.movie.model.Seating;
import com.gp.movie.model.entity.ResApi;
import com.gp.movie.repository.OrderMapper;
import com.gp.movie.repository.ScreeningMapper;
import com.gp.movie.repository.SeatingMapper;
import com.gp.movie.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("payService")
public class PayServiceImpl implements PayService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private SeatingMapper seatingMapper;
    @Autowired
    private ScreeningMapper screeningMapper;

    /**
     * 支付
     *
     * @param seatIds 座位id集合
     * @param request 请求
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> pay(List<Long> seatIds, HttpServletRequest request) {
        if (seatIds == null || seatIds.isEmpty()) {
            throw new NullParamException("seatIds 参数为空");
        }
        // 获取账户id
        Long accountId = new Session(request).accountId();
        // 查询座位
        List<Seating> seats = seatingMapper.queryByIds(seatIds);
        if (seats != null) {
            // 修改座位
            seatingMapper.updateByIds(seatIds);

            // 订单
            Order order = new Order();
            // 账户id
            order.setAccountId(accountId);
            // 座位名
            order.setSeatName(seats.get(0).getName());
            // 影片id
            order.setFilmId(seats.get(0).getFilmId());
            // 影厅id
            order.setHallId(seats.get(0).getHallId());
            // 场次id
            order.setScreenId(seats.get(0).getScreenId());
            // 影院id
            order.setCinemaId(seats.get(0).getCinemaId());
            // 数量
            order.setNumber(seats.size());
            // 查询场次
            Screening screen = screeningMapper.queryById(seats.get(0).getScreenId());
            if (screen != null) {
                // 单价
                order.setPrice(screen.getPrice());
            }

            // 添加订单
            orderMapper.add(order);
        }

        return new ResApi<>();
    }
}