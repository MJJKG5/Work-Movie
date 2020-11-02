package com.gp.movie.service;

import com.gp.movie.model.Screening;
import com.gp.movie.model.entity.ResApi;

import java.util.Map;

public interface ScreeningService {
    /**
     * 查询场次
     *
     * @param filmId     影片id
     * @param cinemaId   影院id
     * @param cinemaName 影院名
     * @param playDate   放映日期
     * @param pageNo     页码
     * @param pageSize   页大小
     * @return
     */
    ResApi<Map<String, Object>> queryScreening(Long filmId,
                                               Long cinemaId,
                                               String cinemaName,
                                               String playDate,
                                               Integer pageNo,
                                               Integer pageSize);

    /**
     * 添加场次
     *
     * @param screening 场次
     * @return
     */
    ResApi<String> addScreening(Screening screening);

    /**
     * 修改场次
     *
     * @param screening 场次
     * @return
     */
    ResApi<String> updateScreening(Screening screening);

    /**
     * 删除场次
     *
     * @param id 场次id
     * @return
     */
    ResApi<String> deleteScreening(Long id);
}
