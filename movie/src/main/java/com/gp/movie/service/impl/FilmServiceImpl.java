package com.gp.movie.service.impl;

import com.gp.movie.common.utils.Check;
import com.gp.movie.model.Film;
import com.gp.movie.model.entity.Page;
import com.gp.movie.model.entity.ResApi;
import com.gp.movie.repository.FilmMapper;
import com.gp.movie.repository.ScreeningMapper;
import com.gp.movie.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("filmService")
public class FilmServiceImpl implements FilmService {
    @Value("${img.path}")
    private String path;
    @Autowired
    private FilmMapper filmMapper;
    @Autowired
    private ScreeningMapper screeningMapper;

    /**
     * 查询影片
     *
     * @param name     影片名称
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    @Override
    public ResApi<Map<String, Object>> queryFilm(String name, Integer pageNo, Integer pageSize) {
        Check.isNull(pageNo, "pageNo 参数为空");
        Check.isNull(pageNo, "pageSize 参数为空");
        // 查询数量
        Long total = filmMapper.count(name);
        // 分页
        Page page = new Page(pageNo, pageSize, total);
        // 查询影片
        List<Film> films = filmMapper.queryByList(name, page);

        Map<String, Object> map = new HashMap<>();
        map.put("films", films);
        map.put("page", page);
        return new ResApi<>(map);
    }

    /**
     * 添加影片
     *
     * @param film 影片
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> addFilm(Film film) {
        Check.isNull(film.getName(), "name 参数为空");
        Check.isNull(film.getAlias(), "alias 参数为空");
        Check.isNull(film.getDirector(), "director 参数为空");
        Check.isNull(film.getStarring(), "starring 参数为空");
        Check.isNull(film.getScore(), "score 参数为空");
        Check.isNull(film.getType(), "type 参数为空");
        Check.isNull(film.getLanguage(), "language 参数为空");
        Check.isNull(film.getCountry(), "country 参数为空");
        Check.isNull(film.getRunTime(), "runTime 参数为空");
        Check.isNull(film.getReleaseTime(), "releaseTime 参数为空");
        Check.isNull(film.getImg(), "img 参数为空");
        Check.isNull(film.getIntro(), "intro 参数为空");
        // 添加影片
        filmMapper.add(film);

        return new ResApi<>();
    }

    /**
     * 修改影片
     *
     * @param film 影片
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> updateFilm(Film film) {
        Check.isNull(film.getId(), "id 参数为空");
        Check.isNull(film.getName(), "name 参数为空");
        Check.isNull(film.getAlias(), "alias 参数为空");
        Check.isNull(film.getStatus(), "status 参数为空");
        Check.isNull(film.getDirector(), "director 参数为空");
        Check.isNull(film.getStarring(), "starring 参数为空");
        Check.isNull(film.getScore(), "score 参数为空");
        Check.isNull(film.getType(), "type 参数为空");
        Check.isNull(film.getLanguage(), "language 参数为空");
        Check.isNull(film.getCountry(), "country 参数为空");
        Check.isNull(film.getRunTime(), "runTime 参数为空");
        Check.isNull(film.getReleaseTime(), "releaseTime 参数为空");
        Check.isNull(film.getImg(), "img 参数为空");
        Check.isNull(film.getIntro(), "intro 参数为空");
        // 修改影片
        filmMapper.update(film);

        return new ResApi<>();
    }

    /**
     * 删除影片
     *
     * @param id 影片id
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> deleteFilm(Long id) {
        Check.isNull(id, "id 参数为空");
        // 查询影片
        Film film = filmMapper.queryById(id);
        if (film != null) {
            // 删除影片
            filmMapper.delete(id);
            // 删除关联数据(影院中的影片)
            screeningMapper.deleteByFilmId(id);

            // 获取存储路径
            String img = film.getImg();
            int index = img.lastIndexOf("/") + 1;
            img = img.substring(index);
            // 删除封面
            File file = new File(path + img);
            file.delete();
        }
        return new ResApi<>();
    }
}
