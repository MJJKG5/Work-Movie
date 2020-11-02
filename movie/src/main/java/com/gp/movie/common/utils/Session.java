package com.gp.movie.common.utils;

import cn.hutool.core.convert.Convert;
import com.gp.movie.common.exception.LogicException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Session {
    private final HttpSession session;

    public Session(HttpServletRequest request) {
        this.session = request.getSession();
    }

    /**
     * 获取值
     *
     * @param key 键
     * @return
     */
    public Object get(String key) {
        Object value = this.session.getAttribute(key);
        if (value == null) {
            throw new LogicException("请登录");
        }
        return value;
    }

    /**
     * 添加值
     *
     * @param key   键
     * @param value 值
     */
    public void set(String key, Object value) {
        this.session.setAttribute(key, value);
    }

    /**
     * 删除值
     *
     * @param key 键
     */
    public void del(String key) {
        this.session.removeAttribute(key);
    }

    /**
     * 获取账户id
     *
     * @return
     */
    public Long accountId() {
        Object accountId = this.session.getAttribute(session.getId());
        if (accountId == null) {
            throw new LogicException("请登录");
        }
        return Convert.toLong(accountId);
    }
}
