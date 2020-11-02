package com.gp.movie.service;

import com.gp.movie.model.Account;
import com.gp.movie.model.entity.ResApi;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface SignService {
    /**
     * 注册
     *
     * @param account 账户
     * @return
     */
    ResApi<String> signUp(Account account);

    /**
     * 登录
     *
     * @param account 账户
     * @return
     */
    ResApi<Map<String, Object>> signIn(Account account, HttpServletRequest request);

    /**
     * 注销
     *
     * @param request 请求
     * @return
     */
    ResApi<String> signOut(HttpServletRequest request);
}
