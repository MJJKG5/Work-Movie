package com.gp.movie.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Order implements Serializable {
    private static final long serialVersionUID = -2839745799716138579L;
    /**
     * 订单id
     */
    private Long id;
    /**
     * 账户id
     */
    private Long accountId;
    /**
     * 影院id
     */
    private Long cinemaId;
    /**
     * 影院名
     */
    private String cinemaName;
    /**
     * 影厅id
     */
    private Long hallId;
    /**
     * 影厅名
     */
    private String hallName;
    /**
     * 场次id
     */
    private Long screenId;
    /**
     * 影片id
     */
    private Long filmId;
    /**
     * 影片名
     */
    private String filmName;
    /**
     * 座位名
     */
    private String seatName;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 数量
     */
    private Integer number;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 影院地址
     */
    private String address;
    /**
     * 播放时间
     */
    private String playTime;
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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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

    public Long getScreenId() {
        return screenId;
    }

    public void setScreenId(Long screenId) {
        this.screenId = screenId;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
