package com.gp.movie.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Seating implements Serializable {
    private static final long serialVersionUID = -1989786171481099891L;
    /**
     * 座位id
     */
    private Long id;
    /**
     * 序列号
     */
    private Integer serialNo;
    /**
     * 座位名（1排1座）
     */
    private String name;
    /**
     * 是否占用（true：占用；false：未占用）
     */
    private Boolean isUse;
    /**
     * 影片id
     */
    private Long filmId;
    /**
     * 影厅id
     */
    private Long hallId;
    /**
     * 影院id
     */
    private Long cinemaId;
    /**
     * 场次id
     */
    private Long screenId;
    /**
     * 影院名
     */
    private String cinemaName;
    /**
     * 影厅名
     */
    private String hallName;
    /**
     * 影片名
     */
    private String filmName;
    /**
     * 时长
     */
    private Integer runTime;
    /**
     * 播放时间
     */
    private String playTime;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 影片封面
     */
    private String img;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getUse() {
        return isUse;
    }

    public void setUse(Boolean use) {
        isUse = use;
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

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Long getScreenId() {
        return screenId;
    }

    public void setScreenId(Long screenId) {
        this.screenId = screenId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Integer getRunTime() {
        return runTime;
    }

    public void setRunTime(Integer runTime) {
        this.runTime = runTime;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
