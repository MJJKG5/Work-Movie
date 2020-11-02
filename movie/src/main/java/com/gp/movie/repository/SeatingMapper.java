package com.gp.movie.repository;

import com.gp.movie.model.Seating;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatingMapper {
    /**
     * 查询
     *
     * @param screenId 场次id
     * @return
     */
    List<Seating> queryByList(@Param("screenId") Integer screenId);

    /**
     * @param ids 座位id集合
     * @return
     */
    List<Seating> queryByIds(@Param("ids") List<Long> ids);

    /**
     * 添加
     *
     * @param seats 座位集合
     */
    void adds(@Param("seats") List<Seating> seats);

    /**
     * 修改
     *
     * @param ids 座位id集合
     */
    void updateByIds(@Param("ids") List<Long> ids);

    /**
     * 修改
     *
     * @param seating 座位
     */
    void updateByScreenId(@Param("seat") Seating seating);

    /**
     * 删除
     *
     * @param id 座位id
     */
    void delete(Long id);

    /**
     * 删除
     *
     * @param screenId 场次id
     */
    void deleteByScreenId(Long screenId);

    /**
     * 查询数量
     *
     * @return
     */
    Long count();
}
