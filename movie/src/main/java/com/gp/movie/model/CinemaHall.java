package com.gp.movie.model;

import java.io.Serializable;

public class CinemaHall implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 影厅id
     */
    private Long id;
    /**
     * 影厅名
     */
    private String name;
    /**
     * 排数
     */
    private Integer row;
    /**
     * 列数
     */
    private Integer column;
    /**
     * 影院id
     */
    private Long cinemaId;
    /**
     * 影院名
     */
    private String cinemaName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
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
}
