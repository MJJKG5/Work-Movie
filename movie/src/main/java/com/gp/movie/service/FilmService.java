package com.gp.movie.service;

import com.gp.movie.model.Film;
import com.gp.movie.model.entity.ResApi;

import java.util.Map;

public interface FilmService {
    /**
     * 查询影片
     *
     * @param name     影片名称
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    ResApi<Map<String, Object>> queryFilm(String name, Integer pageNo, Integer pageSize);

    /**
     * 添加影片
     *
     * @param film 影片
     * @return
     */
    ResApi<String> addFilm(Film film);

    /**
     * 修改影片
     *
     * @param film 影片
     * @return
     */
    ResApi<String> updateFilm(Film film);

    /**
     * 删除影片
     *
     * @param id 影片id
     * @return
     */
    ResApi<String> deleteFilm(Long id);
}
