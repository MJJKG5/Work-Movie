package com.gp.movie.service.impl;

import com.gp.movie.common.utils.Check;
import com.gp.movie.model.Seating;
import com.gp.movie.model.entity.ResApi;
import com.gp.movie.repository.SeatingMapper;
import com.gp.movie.service.SeatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("seatingService")
public class SeatingServiceImpl implements SeatingService {
    @Autowired
    private SeatingMapper seatingMapper;

    /**
     * 查询座位
     *
     * @param screenId 场次id
     * @return
     */
    @Override
    public ResApi<Map<String, Object>> querySeating(Integer screenId) {
        Check.isNull(screenId, "screenId 参数为空");
        // 查询座位
        List<Seating> seats = seatingMapper.queryByList(screenId);

        Map<String, Object> map = new HashMap<>();
        map.put("seats", seats);
        return new ResApi<>(map);
    }
}
