package com.gp.movie.service;

import com.gp.movie.model.Account;
import com.gp.movie.model.entity.ResApi;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface AccountService {
    /**
     * 查询账户
     *
     * @param request 请求
     * @return
     */
    ResApi<Map<String, Object>> queryAccount(HttpServletRequest request);

    /**
     * 修改账户
     *
     * @param account 账户
     * @param request 请求
     * @return
     */
    ResApi<String> updateAccount(Account account, HttpServletRequest request);
}
