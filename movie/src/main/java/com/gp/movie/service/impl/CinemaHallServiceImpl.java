package com.gp.movie.service.impl;

import com.gp.movie.common.exception.LogicException;
import com.gp.movie.common.utils.Check;
import com.gp.movie.model.CinemaHall;
import com.gp.movie.model.entity.Page;
import com.gp.movie.model.entity.ResApi;
import com.gp.movie.repository.CinemaHallMapper;
import com.gp.movie.service.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("cinemaHallService")
public class CinemaHallServiceImpl implements CinemaHallService {
    @Autowired
    private CinemaHallMapper cinemaHallMapper;

    /**
     * 查询影厅
     *
     * @param name     影厅名
     * @param cinemaId 影院id
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    @Override
    public ResApi<Map<String, Object>> queryCinemaHall(String name, Long cinemaId, Integer pageNo, Integer pageSize) {
        Check.isNull(pageNo, "pageNo 参数为空");
        Check.isNull(pageSize, "pageSize 参数为空");
        // 查询数量
        Long total = cinemaHallMapper.count(name, cinemaId);
        // 分页
        Page page = new Page(pageNo, pageSize, total);
        // 查询影厅
        List<CinemaHall> halls = cinemaHallMapper.queryByCinemaId(name, cinemaId, page);

        Map<String, Object> map = new HashMap<>();
        map.put("halls", halls);
        map.put("page", page);
        return new ResApi<>(map);
    }

    /**
     * 添加影厅
     *
     * @param cinemaHall 影厅
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> addCinemaHall(CinemaHall cinemaHall) {
        Check.isNull(cinemaHall.getName(), "name 参数为空");
        Check.isNull(cinemaHall.getRow(), "row 参数为空");
        Check.isNull(cinemaHall.getColumn(), "column 参数为空");
        Check.isNull(cinemaHall.getCinemaId(), "cinemaId 参数为空");
        // 查询影厅
        CinemaHall hall = cinemaHallMapper.queryByCinemaIdAndName(cinemaHall.getCinemaId(), cinemaHall.getName());
        // 检查影厅
        if (hall != null) {
            throw new LogicException("影厅已存在");
        }
        // 添加影厅
        cinemaHallMapper.add(cinemaHall);

        return new ResApi<>();
    }

    /**
     * 修改影厅
     *
     * @param cinemaHall 影厅
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> updateCinemaHall(CinemaHall cinemaHall) {
        Check.isNull(cinemaHall.getId(), "id 参数为空");
        Check.isNull(cinemaHall.getName(), "name 参数为空");
        Check.isNull(cinemaHall.getCinemaId(), "cinemaId 参数为空");
        // 查询影厅
        CinemaHall hall = cinemaHallMapper.queryByCinemaIdAndName(cinemaHall.getCinemaId(), cinemaHall.getName());
        // 检查影厅
        if (hall != null) {
            // id 如果不相同
            if (!hall.getId().equals(cinemaHall.getId())) {
                throw new LogicException("影厅已存在");
            }
        }
        // 修改影厅
        cinemaHallMapper.update(cinemaHall);

        return new ResApi<>();
    }

    /**
     * 删除影厅
     *
     * @param id 影厅id
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> deleteCinemaHall(Long id) {
        Check.isNull(id, "id 参数为空");
        // 删除影厅
        cinemaHallMapper.delete(id);

        return new ResApi<>();
    }
}
