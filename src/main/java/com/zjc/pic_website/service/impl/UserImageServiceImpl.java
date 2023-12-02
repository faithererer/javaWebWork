package com.zjc.pic_website.service.impl;

import com.zjc.pic_website.entity.Image;
import com.zjc.pic_website.entity.UserImage;
import com.zjc.pic_website.mapper.UserImageMapper;
import com.zjc.pic_website.service.UserImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class UserImageServiceImpl implements UserImageService {
    @Resource
    private UserImageMapper userImageMapper;
    @Override
    public void del(ArrayList<UserImage> userImages) {
        for (UserImage item : userImages) {
            userImageMapper.delByID(item);
        }
        System.out.println("删除成功: "+userImages);
    }
}
