package com.gp.movie.controller;

import com.gp.movie.model.Cinema;
import com.gp.movie.model.entity.ResApi;
import com.gp.movie.service.CinemaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api")
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;

    /**
     * 查询影院
     *
     * @param name     影院名
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    @RequestMapping(value = "cinema", method = RequestMethod.GET)
    public ResApi<Map<String, Object>> queryCinema(@RequestParam(required = false) String name,
                                                   @RequestParam Integer pageNo,
                                                   @RequestParam Integer pageSize) {
        return cinemaService.queryCinema(name, pageNo, pageSize);
    }

    /**
     * 查询影院
     *
     * @param filmId   影片id
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    @RequestMapping(value = "cinema/{filmId}", method = RequestMethod.GET)
    public ResApi<Map<String, Object>> queryCinema(@PathVariable Long filmId,
                                                   @RequestParam Integer pageNo,
                                                   @RequestParam Integer pageSize) {
        return cinemaService.queryCinema(filmId, pageNo, pageSize);
    }

    /**
     * 添加影院
     *
     * @param cinema 影院
     * @return
     */
    @RequestMapping(value = "cinema", method = RequestMethod.POST)
    public ResApi<String> addCinema(@RequestBody Cinema cinema) {
        return cinemaService.addCinema(cinema);
    }

    /**
     * 修改影院
     *
     * @param cinema 影院
     * @return
     */
    @RequestMapping(value = "cinema", method = RequestMethod.PUT)
    public ResApi<String> updateCinema(@RequestBody Cinema cinema) {
        return cinemaService.updateCinema(cinema);
    }

    /**
     * 删除影院
     *
     * @param id 影院id
     * @return
     */
    @RequestMapping(value = "cinema", method = RequestMethod.DELETE)
    public ResApi<String> deleteCinema(@RequestParam Long id) {
        return cinemaService.deleteCinema(id);
    }
}
