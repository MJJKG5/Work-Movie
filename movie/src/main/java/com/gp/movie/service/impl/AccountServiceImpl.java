package com.gp.movie.service.impl;

import com.gp.movie.common.utils.Check;
import com.gp.movie.common.utils.Session;
import com.gp.movie.model.Account;
import com.gp.movie.model.entity.ResApi;
import com.gp.movie.repository.AccountMapper;
import com.gp.movie.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    /**
     * 查询账户
     *
     * @param request 请求
     * @return
     */
    @Override
    public ResApi<Map<String, Object>> queryAccount(HttpServletRequest request) {
        // 获取账户id
        Long accountId = new Session(request).accountId();
        // 查询账户
        Account account = accountMapper.queryById(accountId);

        Map<String, Object> map = new HashMap<>();
        map.put("account", account);
        return new ResApi<>(map);
    }

    /**
     * 修改账户
     *
     * @param account 账户
     * @param request 请求
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> updateAccount(Account account, HttpServletRequest request) {
        Check.isNull(account.getNickname(), "nickname 参数为空");
        // 获取账户id
        Long accountId = new Session(request).accountId();
        // 设置账户id
        account.setId(accountId);
        // 修改账户
        accountMapper.update(account);

        return new ResApi<>();
    }
}
