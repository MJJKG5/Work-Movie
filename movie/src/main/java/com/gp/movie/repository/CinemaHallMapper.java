package com.gp.movie.repository;

import com.gp.movie.model.CinemaHall;
import com.gp.movie.model.entity.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaHallMapper {
    /**
     * 查询
     *
     * @param name     影厅名
     * @param cinemaId 影院id
     * @param page     分页
     * @return
     */
    List<CinemaHall> queryByCinemaId(@Param("name") String name,
                                     @Param("cinemaId") Long cinemaId,
                                     @Param("page") Page page);

    /**
     * 查询
     *
     * @param id 影厅id
     * @return
     */
    CinemaHall queryById(Long id);

    /**
     * 查询
     *
     * @param cinemaId 影院id
     * @param name     影厅名
     * @return
     */
    CinemaHall queryByCinemaIdAndName(@Param("cinemaId") Long cinemaId,
                                      @Param("name") String name);

    /**
     * 添加
     *
     * @param cinemaHall 影厅
     */
    void add(@Param("hall") CinemaHall cinemaHall);

    /**
     * 修改
     *
     * @param cinemaHall 影厅
     */
    void update(@Param("hall") CinemaHall cinemaHall);

    /**
     * 删除
     *
     * @param id 影厅id
     */
    void delete(Long id);

    /**
     * 查询数量
     *
     * @param name     影厅名
     * @param cinemaId 影院id
     * @return
     */
    Long count(@Param("name") String name, @Param("cinemaId") Long cinemaId);
}
