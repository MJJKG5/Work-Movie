package com.gp.movie.repository;

import com.gp.movie.model.Order;
import com.gp.movie.model.entity.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    /**
     * 查询
     *
     * @param id        订单id
     * @param accountId 账户id
     * @param page      分页
     * @return
     */
    List<Order> queryByList(@Param("id") Long id,
                            @Param("accountId") Long accountId,
                            @Param("page") Page page);

    /**
     * 添加
     *
     * @param order 订单
     */
    void add(@Param("order") Order order);

    /**
     * 修改
     *
     * @param order 订单
     */
    void update(@Param("order") Order order);

    /**
     * 删除
     *
     * @param ids 订单id集合
     */
    void delete(@Param("ids") List<Long> ids);

    /**
     * 查询数量
     *
     * @param id        订单id
     * @param accountId 账户id
     * @return
     */
    Long count(@Param("id") Long id, @Param("accountId") Long accountId);
}
