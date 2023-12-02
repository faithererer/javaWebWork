package com.zjc.pic_website.service;

import com.zjc.pic_website.entity.Tag;
import com.zjc.pic_website.entity.UserImage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface UserImageService {
    void del(ArrayList<UserImage> userImages);
}
