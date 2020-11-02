package com.gp.movie.model;

import java.io.Serializable;

public class Cinema implements Serializable {
    private static final long serialVersionUID = 6866309827091591153L;
    /**
     * 影院id
     */
    private Long id;
    /**
     * 影院名
     */
    private String name;
    /**
     * 影院地址
     */
    private String address;
    /**
     * 创建时间
     */
    private String createTime;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
