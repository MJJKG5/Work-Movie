package com.gp.movie.controller;

import com.gp.movie.model.Account;
import com.gp.movie.model.entity.ResApi;
import com.gp.movie.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api")
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * 查询账户
     *
     * @param request 请求
     * @return
     */
    @RequestMapping(value = "account", method = RequestMethod.GET)
    public ResApi<Map<String, Object>> queryAccount(HttpServletRequest request) {
        return accountService.queryAccount(request);
    }

    /**
     * 修改账户
     *
     * @param account 账户
     * @param request 请求
     * @return
     */
    @RequestMapping(value = "account", method = RequestMethod.PUT)
    public ResApi<String> updateAccount(@RequestBody Account account, HttpServletRequest request) {
        return accountService.updateAccount(account, request);
    }
}
