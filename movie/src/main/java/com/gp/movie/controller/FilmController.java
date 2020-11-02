package com.gp.movie.controller;

import com.gp.movie.model.Film;
import com.gp.movie.model.entity.ResApi;
import com.gp.movie.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api")
public class FilmController {
    @Autowired
    private FilmService filmService;

    /**
     * 查询影片
     *
     * @param name     影片名
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    @RequestMapping(value = "film", method = RequestMethod.GET)
    public ResApi<Map<String, Object>> queryFilm(@RequestParam(required = false) String name,
                                                 @RequestParam Integer pageNo,
                                                 @RequestParam Integer pageSize) {
        return filmService.queryFilm(name, pageNo, pageSize);
    }

    /**
     * 添加影片
     *
     * @param film 影片
     * @return
     */
    @RequestMapping(value = "film", method = RequestMethod.POST)
    public ResApi<String> addFilm(@RequestBody Film film) {
        return filmService.addFilm(film);
    }

    /**
     * 修改影片
     *
     * @param film 影片
     * @return
     */
    @RequestMapping(value = "film", method = RequestMethod.PUT)
    public ResApi<String> updateFilm(@RequestBody Film film) {
        return filmService.updateFilm(film);
    }

    /**
     * 删除影片
     *
     * @param id 影片id
     * @return
     */
    @RequestMapping(value = "film", method = RequestMethod.DELETE)
    public ResApi<String> deleteFilm(@RequestParam Long id) {
        return filmService.deleteFilm(id);
    }
}
