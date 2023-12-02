package com.zjc.pic_website.service.impl;

import com.zjc.pic_website.entity.Image;
import com.zjc.pic_website.entity.Tag;
import com.zjc.pic_website.mapper.ImageMapper;
import com.zjc.pic_website.service.ImageService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
@Component
public class ImageServiceImpl implements ImageService {
    @Resource
    private ImageMapper imageMapper;
    @Override
    public void delImage(ArrayList<Image> images) {
        for (Image item : images) {
             imageMapper.delImageByID(item);
        }
        System.out.println("删除成功: "+images);
    }
}
