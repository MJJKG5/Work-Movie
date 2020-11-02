package com.gp.movie.service;

import com.gp.movie.model.Cinema;
import com.gp.movie.model.entity.ResApi;

import java.util.Map;

public interface CinemaService {
    /**
     * 查询影院
     *
     * @param name     影院名
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    ResApi<Map<String, Object>> queryCinema(String name, Integer pageNo, Integer pageSize);

    /**
     * 查询影院
     *
     * @param filmId   影片id
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    ResApi<Map<String, Object>> queryCinema(Long filmId, Integer pageNo, Integer pageSize);

    /**
     * 添加影院
     *
     * @param cinema 影院
     * @return
     */
    ResApi<String> addCinema(Cinema cinema);

    /**
     * 修改影院
     *
     * @param cinema 影院
     * @return
     */
    ResApi<String> updateCinema(Cinema cinema);

    /**
     * 删除影院
     *
     * @param id 影院id
     * @return
     */
    ResApi<String> deleteCinema(Long id);
}
