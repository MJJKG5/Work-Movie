package com.gp.movie.controller;

import com.gp.movie.model.CinemaHall;
import com.gp.movie.model.entity.ResApi;
import com.gp.movie.service.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api")
public class CinemaHallController {
    @Autowired
    private CinemaHallService cinemaHallService;

    /**
     * 查询影厅
     *
     * @param name     影厅名
     * @param cinemaId 影院id
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    @RequestMapping(value = "cinema/hall", method = RequestMethod.GET)
    public ResApi<Map<String, Object>> queryCinemaHall(@RequestParam(required = false) String name,
                                                       @RequestParam(required = false) Long cinemaId,
                                                       @RequestParam Integer pageNo,
                                                       @RequestParam Integer pageSize) {
        return cinemaHallService.queryCinemaHall(name, cinemaId, pageNo, pageSize);
    }

    /**
     * 添加影厅
     *
     * @param cinemaHall 影厅
     * @return
     */
    @RequestMapping(value = "cinema/hall", method = RequestMethod.POST)
    public ResApi<String> addCinemaHall(@RequestBody CinemaHall cinemaHall) {
        return cinemaHallService.addCinemaHall(cinemaHall);
    }

    /**
     * 修改影厅
     *
     * @param cinemaHall 影厅
     * @return
     */
    @RequestMapping(value = "cinema/hall", method = RequestMethod.PUT)
    public ResApi<String> updateCinemaHall(@RequestBody CinemaHall cinemaHall) {
        return cinemaHallService.updateCinemaHall(cinemaHall);
    }

    /**
     * 删除影厅
     *
     * @param id 影厅id
     * @return
     */
    @RequestMapping(value = "cinema/hall", method = RequestMethod.DELETE)
    public ResApi<String> deleteCinemaHall(@RequestParam Long id) {
        return cinemaHallService.deleteCinemaHall(id);
    }
}
