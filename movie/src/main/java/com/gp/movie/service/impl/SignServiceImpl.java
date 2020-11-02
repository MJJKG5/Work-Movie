package com.gp.movie.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.gp.movie.common.exception.LogicException;
import com.gp.movie.common.utils.Check;
import com.gp.movie.common.utils.Session;
import com.gp.movie.model.Account;
import com.gp.movie.model.entity.ResApi;
import com.gp.movie.repository.AccountMapper;
import com.gp.movie.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service("signService")
public class SignServiceImpl implements SignService {
    @Autowired
    private AccountMapper accountMapper;

    /**
     * 注册
     *
     * @param account 账户
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> signUp(Account account) {
        Check.isNull(account.getNickname(), "nickname 参数为空");
        Check.isNull(account.getUsername(), "username 参数为空");
        Check.isNull(account.getPassword(), "password 参数为空");
        // 验证账户
        Account result = accountMapper.queryByUsername(account.getUsername());
        if (result != null) {
            throw new LogicException("用户名已被注册");
        }
        // 密码加密(MD5)
        String password = SecureUtil.md5(account.getUsername() + account.getPassword());
        // 设置密码
        account.setPassword(password);
        // 添加账户
        accountMapper.add(account);

        return new ResApi<>();
    }

    /**
     * 登录
     *
     * @param account 账户
     * @return
     */
    @Override
    public ResApi<Map<String, Object>> signIn(Account account, HttpServletRequest request) {
        Check.isNull(account.getUsername(), "username 参数为空");
        Check.isNull(account.getPassword(), "password 参数为空");
        // 查询账户
        Account result = accountMapper.queryByUsername(account.getUsername());
        // 检查用户名和密码
        if (result == null) {
            throw new LogicException("用户名或密码错误");
        }
        // 密码加密(MD5)
        String password = SecureUtil.md5(account.getUsername() + account.getPassword());
        // 检查密码是否正确
        if (!password.equals(result.getPassword())) {
            throw new LogicException("用户名或密码错误");
        }
        // 存储账户id
        new Session(request).set(request.getSession().getId(), result.getId());

        Map<String, Object> map = new HashMap<>();
        map.put("id", result.getId());
        map.put("nickname", result.getNickname());
        return new ResApi<>(map);
    }

    /**
     * 注销
     *
     * @param request 请求
     * @return
     */
    @Override
    public ResApi<String> signOut(HttpServletRequest request) {
        // 注销
        new Session(request).del(request.getSession().getId());

        return new ResApi<>();
    }
}
