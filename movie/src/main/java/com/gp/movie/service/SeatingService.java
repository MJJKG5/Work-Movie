package com.gp.movie.service;

import com.gp.movie.model.entity.ResApi;

import java.util.Map;

public interface SeatingService {
    /**
     * 查询座位
     *
     * @param screenId 场次id
     * @return
     */
    ResApi<Map<String, Object>> querySeating(Integer screenId);
}
