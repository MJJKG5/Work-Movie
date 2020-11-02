package com.gp.movie.controller;

import com.gp.movie.model.entity.ResApi;
import com.gp.movie.service.SeatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api")
public class SeatingController {
    @Autowired
    private SeatingService seatingService;

    /**
     * 查询座位
     *
     * @param screenId 场次id
     * @return
     */
    @RequestMapping(value = "seating", method = RequestMethod.GET)
    public ResApi<Map<String, Object>> querySeating(@RequestParam Integer screenId) {
        return seatingService.querySeating(screenId);
    }
}
