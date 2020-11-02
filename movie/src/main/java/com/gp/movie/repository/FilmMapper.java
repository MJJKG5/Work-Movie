package com.gp.movie.repository;

import com.gp.movie.model.Film;
import com.gp.movie.model.entity.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmMapper {
    /**
     * 查询
     *
     * @param page 分页
     * @return
     */
    List<Film> queryByList(@Param("name") String name, @Param("page") Page page);

    /**
     * 查询
     *
     * @param id 影片id
     * @return
     */
    Film queryById(Long id);

    /**
     * 添加
     *
     * @param film 影片
     */
    void add(@Param("film") Film film);

    /**
     * 修改
     *
     * @param film 影片
     */
    void update(@Param("film") Film film);

    /**
     * 删除
     *
     * @param id 影片id
     */
    void delete(Long id);

    /**
     * 查询数量
     *
     * @return
     */
    Long count(String name);
}
