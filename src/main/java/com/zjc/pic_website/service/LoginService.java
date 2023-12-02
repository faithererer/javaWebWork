package com.zjc.pic_website.service;

import com.zjc.pic_website.entity.Admin;
import com.zjc.pic_website.entity.User;
import com.zjc.pic_website.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public interface LoginService {


    Boolean isAuth(Admin admin);
}
