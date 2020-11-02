package com.gp.movie.service.impl;

import cn.hutool.core.date.DateUtil;
import com.gp.movie.common.exception.LogicException;
import com.gp.movie.common.utils.Check;
import com.gp.movie.model.CinemaHall;
import com.gp.movie.model.Film;
import com.gp.movie.model.Screening;
import com.gp.movie.model.Seating;
import com.gp.movie.model.entity.Page;
import com.gp.movie.model.entity.ResApi;
import com.gp.movie.repository.CinemaHallMapper;
import com.gp.movie.repository.FilmMapper;
import com.gp.movie.repository.ScreeningMapper;
import com.gp.movie.repository.SeatingMapper;
import com.gp.movie.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("screeningService")
public class ScreeningServiceImpl implements ScreeningService {
    @Autowired
    private FilmMapper filmMapper;
    @Autowired
    private SeatingMapper seatingMapper;
    @Autowired
    private ScreeningMapper screeningMapper;
    @Autowired
    private CinemaHallMapper cinemaHallMapper;

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
    @Override
    public ResApi<Map<String, Object>> queryScreening(Long filmId,
                                                      Long cinemaId,
                                                      String cinemaName,
                                                      String playDate,
                                                      Integer pageNo,
                                                      Integer pageSize) {
        Check.isNull(pageNo, "pageNo 参数为空");
        Check.isNull(pageSize, "pageSize 参数为空");
        // 查询数量
        Long total = screeningMapper.count(filmId, cinemaId, cinemaName, playDate);
        // 分页
        Page page = new Page(pageNo, pageSize, total);
        // 查询场次
        List<Screening> screenings = screeningMapper.queryByList(filmId, cinemaId, cinemaName, playDate, page);
        if (screenings != null) {
            // 设置影片
            for (Screening screen : screenings) {
                // 查询影片
                Film film = filmMapper.queryById(screen.getFilmId());
                if (film != null) {
                    // 影片名
                    screen.setName(film.getName());
                    // 别名
                    screen.setAlias(film.getAlias());
                    // 影片状态(0：下架；1：上架)
                    screen.setStatus(film.getStatus());
                    // 导演
                    screen.setDirector(film.getDirector());
                    // 主演
                    screen.setStarring(film.getStarring());
                    // 评分
                    screen.setScore(film.getScore());
                    // 类型
                    screen.setType(film.getType());
                    // 语言
                    screen.setLanguage(film.getLanguage());
                    // 国家/地区
                    screen.setCountry(film.getCountry());
                    // 播放时长(分钟/单位)
                    screen.setRunTime(film.getRunTime());
                    // 上映时间
                    screen.setReleaseTime(film.getReleaseTime());
                    // 封面
                    screen.setImg(film.getImg());
                    // 介绍
                    screen.setIntro(film.getIntro());
                }
            }
        }

        Map<String, Object> map = new HashMap<>();
        map.put("screenings", screenings);
        map.put("page", page);
        return new ResApi<>(map);
    }

    /**
     * 添加场次
     *
     * @param screening 场次
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> addScreening(Screening screening) {
        Check.isNull(screening.getFilmId(), "filmId 参数为空");
        Check.isNull(screening.getHallId(), "hallId 参数为空");
        Check.isNull(screening.getCinemaId(), "cinemaId 参数为空");
        Check.isNull(screening.getPrice(), "price 参数为空");
        Check.isNull(screening.getPlayDate(), "playDate 参数为空");
        Check.isNull(screening.getPlayTime(), "playTime 参数为空");
        // 查询影片
        Film film = filmMapper.queryById(screening.getFilmId());
        if (film == null) {
            throw new LogicException("影片不存在");
        }

        // 获取结束时间
        String endTime = getEndTime(screening.getPlayTime(), film.getRunTime());
        // 设置结束时间
        screening.setEndTime(endTime);
        // 添加场次
        screeningMapper.add(screening);

        // 查询影厅
        CinemaHall hall = cinemaHallMapper.queryById(screening.getHallId());
        if (hall == null) {
            throw new LogicException("影厅不存在");
        }

        // 获取座位
        List<Seating> seats = getSeat(screening, hall);
        // 新增座位
        seatingMapper.adds(seats);

        return new ResApi<>();
    }

    /**
     * 修改场次
     *
     * @param screening 场次
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> updateScreening(Screening screening) {
        Check.isNull(screening.getId(), "id 参数为空");
        Check.isNull(screening.getFilmId(), "filmId 参数为空");
        Check.isNull(screening.getHallId(), "hallId 参数为空");
        Check.isNull(screening.getCinemaId(), "cinemaId 参数为空");
        Check.isNull(screening.getPrice(), "price 参数为空");
        Check.isNull(screening.getPlayDate(), "playDate 参数为空");
        Check.isNull(screening.getPlayTime(), "playTime 参数为空");
        // 查询影片
        Film film = filmMapper.queryById(screening.getFilmId());
        if (film == null) {
            throw new LogicException("影片不存在");
        }

        // 获取结束时间
        String endTime = getEndTime(screening.getPlayTime(), film.getRunTime());
        // 设置结束时间
        screening.setEndTime(getEndTime(screening.getPlayTime(), film.getRunTime()));
        // 修改场次
        screeningMapper.update(screening);

        // 座位
        Seating seating = new Seating();
        // 场次id
        seating.setScreenId(screening.getId());
        // 影厅id
        seating.setHallId(screening.getHallId());
        // 影院id
        seating.setCinemaId(screening.getCinemaId());
        // 修改座位
        seatingMapper.updateByScreenId(seating);

        return new ResApi<>();
    }

    /**
     * 删除场次
     *
     * @param id 场次id
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> deleteScreening(Long id) {
        Check.isNull(id, "id 参数为空");
        // 删除场次
        screeningMapper.delete(id);
        // 删除座位
        seatingMapper.deleteByScreenId(id);

        return new ResApi<>();
    }

    /**
     * 获取座位
     *
     * @param screening 场次
     * @param hall      影院影厅
     * @return
     */
    private List<Seating> getSeat(Screening screening, CinemaHall hall) {
        List<Seating> seats = new ArrayList<>();
        int serialNo = 1;
        // 排
        for (int i = 1; i <= hall.getRow(); i++) {
            // 座
            for (int j = 1; j <= hall.getColumn(); j++) {
                // 座位
                Seating seat = new Seating();
                // 序列号
                seat.setSerialNo(serialNo++);
                // 名称
                seat.setName(i + "排" + j + "座");
                // 影片id
                seat.setFilmId(screening.getFilmId());
                // 影厅id
                seat.setHallId(screening.getHallId());
                // 影院id
                seat.setCinemaId(screening.getCinemaId());
                // 场次id
                seat.setScreenId(screening.getId());

                seats.add(seat);
            }
        }
        return seats;
    }

    /**
     * 获取结束时间
     *
     * @param playTime 播放时间
     * @param runTime  播放时长
     * @return
     */
    private String getEndTime(String playTime, Integer runTime) {
        // 开始时间
        Date startTime = DateUtil.parse(playTime);
        // 结束时间
        Date endTime = DateUtil.offsetMinute(startTime, runTime);
        // 转换为指定格式
        return DateUtil.format(endTime, "HH:mm:ss");
    }
}
