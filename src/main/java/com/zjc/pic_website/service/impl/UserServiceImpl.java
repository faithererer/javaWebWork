package com.zjc.pic_website.service.impl;

import com.zjc.pic_website.entity.User;
import com.zjc.pic_website.mapper.UserMapper;
import com.zjc.pic_website.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;

@Component
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void delUser(ArrayList<User> users) {
        for (User item : users) {
            userMapper.delUserByID(item);
        }
        System.out.println("删除成功: "+users);
    }
}
