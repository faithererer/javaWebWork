package com.zjc.pic_website.service.impl;

import com.zjc.pic_website.entity.Admin;
import com.zjc.pic_website.entity.User;
import com.zjc.pic_website.mapper.AdminMapper;
import com.zjc.pic_website.mapper.UserMapper;
import com.zjc.pic_website.service.LoginService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class LoginServiceImpl implements LoginService {
    @Resource
    private AdminMapper adminMapper;
    @Override
    public Boolean isAuth(Admin admin) {
        System.out.println(admin);
        Admin res_admin = adminMapper.queryAdmin(admin);
        System.out.println(res_admin);
        if (res_admin != null) {
            return true;
        } else {
            return false;
        }
    }
}
