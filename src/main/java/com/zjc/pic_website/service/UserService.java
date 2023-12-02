package com.zjc.pic_website.service;

import com.zjc.pic_website.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface UserService {
    void delUser(ArrayList<User> users);
}
