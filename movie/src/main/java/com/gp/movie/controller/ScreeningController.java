package com.gp.movie.controller;

import com.gp.movie.model.Screening;
import com.gp.movie.model.entity.ResApi;
import com.gp.movie.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api")
public class ScreeningController {
    @Autowired
    private ScreeningService screeningService;

    /**
     * 查询场次
     *
     * @param filmId     影片id
     * @param cinemaId   影院id
     * @param cinemaName 影院名
     * @param playDate   放映日期
     * @param pageNo     页码
     * @param pageSize   页大小
     * @return
     */
    @RequestMapping(value = "screening", method = RequestMethod.GET)
    public ResApi<Map<String, Object>> queryScreening(@RequestParam(required = false) Long filmId,
                                                      @RequestParam(required = false) Long cinemaId,
                                                      @RequestParam(required = false) String cinemaName,
                                                      @RequestParam(required = false) String playDate,
                                                      @RequestParam Integer pageNo,
                                                      @RequestParam Integer pageSize) {
        return screeningService.queryScreening(filmId, cinemaId, cinemaName, playDate, pageNo, pageSize);
    }

    /**
     * 添加场次
     *
     * @param screening 场次
     * @return
     */
    @RequestMapping(value = "screening", method = RequestMethod.POST)
    public ResApi<String> addScreening(@RequestBody Screening screening) {
        return screeningService.addScreening(screening);
    }

    /**
     * 修改场次
     *
     * @param screening 场次
     * @return
     */
    @RequestMapping(value = "screening", method = RequestMethod.PUT)
    public ResApi<String> updateScreening(@RequestBody Screening screening) {
        return screeningService.updateScreening(screening);
    }

    /**
     * 删除场次
     *
     * @param id 场次id
     * @return
     */
    @RequestMapping(value = "screening", method = RequestMethod.DELETE)
    public ResApi<String> deleteScreening(@RequestParam Long id) {
        return screeningService.deleteScreening(id);
    }
}
