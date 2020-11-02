package com.gp.movie.repository;

import com.gp.movie.model.Cinema;
import com.gp.movie.model.entity.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaMapper {
    /**
     * 查询
     *
     * @param name 影院名
     * @param page 分页
     * @return
     */
    List<Cinema> queryByList(@Param("name") String name, @Param("page") Page page);

    /**
     * 查询
     *
     * @param ids  影院id集合
     * @param page 分页
     * @return
     */
    List<Cinema> queryByIds(@Param("ids") List<Long> ids, @Param("page") Page page);

    /**
     * 查询
     *
     * @param name 影院名
     * @return
     */
    List<Cinema> queryByName(String name);

    /**
     * 添加
     *
     * @param cinema 影院
     */
    void add(@Param("cinema") Cinema cinema);

    /**
     * 修改
     *
     * @param cinema 影院
     */
    void update(@Param("cinema") Cinema cinema);

    /**
     * 删除
     *
     * @param id 影院id
     */
    void delete(Long id);

    /**
     * 查询数量
     *
     * @param name 影院名
     * @return
     */
    Long count(String name);
}
