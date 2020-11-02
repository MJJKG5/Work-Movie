package com.gp.movie.service.impl;

import cn.hutool.core.convert.Convert;
import com.gp.movie.common.utils.Check;
import com.gp.movie.model.Cinema;
import com.gp.movie.model.Screening;
import com.gp.movie.model.entity.Page;
import com.gp.movie.model.entity.ResApi;
import com.gp.movie.repository.ScreeningMapper;
import com.gp.movie.repository.CinemaMapper;
import com.gp.movie.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("cinemaService")
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    private CinemaMapper cinemaMapper;
    @Autowired
    private ScreeningMapper screeningMapper;

    /**
     * 查询影院
     *
     * @param name     影院名
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    @Override
    public ResApi<Map<String, Object>> queryCinema(String name, Integer pageNo, Integer pageSize) {
        Check.isNull(pageNo, "pageNo 参数为空");
        Check.isNull(pageSize, "pageSize 参数为空");
        // 查询数量
        Long total = cinemaMapper.count(name);
        // 分页
        Page page = new Page(pageNo, pageSize, total);
        // 查询影院
        List<Cinema> cinemas = cinemaMapper.queryByList(name, page);

        Map<String, Object> map = new HashMap<>();
        map.put("cinemas", cinemas);
        map.put("page", page);
        return new ResApi<>(map);
    }

    /**
     * 查询影院
     *
     * @param filmId   影片id
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    @Override
    public ResApi<Map<String, Object>> queryCinema(Long filmId, Integer pageNo, Integer pageSize) {
        Check.isNull(filmId, "filmId 参数为空");
        Check.isNull(pageNo, "pageNo 参数为空");
        Check.isNull(pageSize, "pageSize 参数为空");
        Map<String, Object> map = new HashMap<>();
        // 查询场次
        List<Screening> screenings = screeningMapper.queryByFilmId(filmId);
        if (!screenings.isEmpty()) {
            // 获取影院id
            List<Long> cinemaIds = screenings.stream().map(Screening::getCinemaId).collect(Collectors.toList());
            // 分页
            Page page = new Page(pageNo, pageSize, Convert.toLong(cinemaIds.size()));
            // 查询影院
            List<Cinema> cinemas = cinemaMapper.queryByIds(cinemaIds, page);

            map.put("cinemas", cinemas);
            map.put("page", page);
        }

        return new ResApi<>(map);
    }

    /**
     * 添加影院
     *
     * @param cinema 影院
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> addCinema(Cinema cinema) {
        Check.isNull(cinema.getName(), "name 参数为空");
        Check.isNull(cinema.getAddress(), "address 参数为空");
        // 添加影院
        cinemaMapper.add(cinema);

        return new ResApi<>();
    }

    /**
     * 修改影院
     *
     * @param cinema 影院
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> updateCinema(Cinema cinema) {
        Check.isNull(cinema.getId(), "id 参数为空");
        Check.isNull(cinema.getName(), "name 参数为空");
        Check.isNull(cinema.getAddress(), "address 参数为空");
        // 修改影院
        cinemaMapper.update(cinema);

        return new ResApi<>();
    }

    /**
     * 删除影院
     *
     * @param id 影院id
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> deleteCinema(Long id) {
        Check.isNull(id, "id 参数为空");
        // 删除影院
        cinemaMapper.delete(id);

        return new ResApi<>();
    }
}
