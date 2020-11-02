package com.gp.movie.service;

import com.gp.movie.model.CinemaHall;
import com.gp.movie.model.entity.ResApi;

import java.util.Map;

public interface CinemaHallService {
    /**
     * 查询影厅
     *
     * @param name     影厅名
     * @param cinemaId 影院id
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    ResApi<Map<String, Object>> queryCinemaHall(String name, Long cinemaId, Integer pageNo, Integer pageSize);

    /**
     * 添加影厅
     *
     * @param cinemaHall 影厅
     * @return
     */
    ResApi<String> addCinemaHall(CinemaHall cinemaHall);

    /**
     * 修改影厅
     *
     * @param cinemaHall 影厅
     * @return
     */
    ResApi<String> updateCinemaHall(CinemaHall cinemaHall);

    /**
     * 删除影厅
     *
     * @param id 影厅id
     * @return
     */
    ResApi<String> deleteCinemaHall(Long id);
}
