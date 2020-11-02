package com.gp.movie.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Screening implements Serializable {
    private static final long serialVersionUID = 1396518850296231196L;
    /**
     * 场次id
     */
    private Long id;
    /**
     * 影片id
     */
    private Long filmId;
    /**
     * 影厅id
     */
    private Long hallId;
    /**
     * 影厅名
     */
    private String hallName;
    /**
     * 影院id
     */
    private Long cinemaId;
    /**
     * 影院名
     */
    private String cinemaName;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 播放日期
     */
    private String playDate;
    /**
     * 播放时间
     */
    private String playTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 影片名
     */
    private String name;
    /**
     * 别名
     */
    private String alias;
    /**
     * 状态（0：下架；1：上架）
     */
    private String status;
    /**
     * 导演
     */
    private String director;
    /**
     * 主演
     */
    private String starring;
    /**
     * 评分
     */
    private Float score;
    /**
     * 类型
     */
    private String type;
    /**
     * 语言
     */
    private String language;
    /**
     * 国家/地区
     */
    private String country;
    /**
     * 时长（分钟/单位）
     */
    private Integer runTime;
    /**
     * 上映时间
     */
    private String releaseTime;
    /**
     * 封面
     */
    private String img;
    /**
     * 介绍
     */
    private String intro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPlayDate() {
        return playDate;
    }

    public void setPlayDate(String playDate) {
        this.playDate = playDate;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getRunTime() {
        return runTime;
    }

    public void setRunTime(Integer runTime) {
        this.runTime = runTime;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
