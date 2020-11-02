package com.gp.movie.repository;

import com.gp.movie.model.Screening;
import com.gp.movie.model.entity.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreeningMapper {
    /**
     * 查询
     *
     * @param filmId     影片id
     * @param cinemaId   影院id
     * @param cinemaName 影院名
     * @param playDate   放映日期
     * @param page       分页
     * @return
     */
    List<Screening> queryByList(@Param("filmId") Long filmId,
                                @Param("cinemaId") Long cinemaId,
                                @Param("cinemaName") String cinemaName,
                                @Param("playDate") String playDate,
                                @Param("page") Page page);

    /**
     * 查询
     *
     * @param filmId 影片id
     * @return
     */
    List<Screening> queryByFilmId(Long filmId);

    /**
     * 查询
     *
     * @param id 场次id
     * @return
     */
    Screening queryById(Long id);

    /**
     * 添加
     *
     * @param screening 场次
     */
    void add(@Param("screening") Screening screening);

    /**
     * 修改
     *
     * @param screening 场次
     */
    void update(@Param("screening") Screening screening);

    /**
     * 删除
     *
     * @param id 场次id
     */
    void delete(Long id);

    /**
     * 删除
     *
     * @param filmId 影片id
     */
    void deleteByFilmId(Long filmId);

    /**
     * 查询
     *
     * @param filmId     影片id
     * @param cinemaId   影院id
     * @param cinemaName 影院名
     * @param playDate   放映日期
     * @return
     */
    Long count(@Param("filmId") Long filmId,
               @Param("cinemaId") Long cinemaId,
               @Param("cinemaName") String cinemaName,
               @Param("playDate") String playDate);
}
