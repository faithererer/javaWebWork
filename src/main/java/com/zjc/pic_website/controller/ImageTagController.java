package com.zjc.pic_website.controller;

import com.zjc.pic_website.entity.ImageTag;
import com.zjc.pic_website.entity.JsonResponse;
import com.zjc.pic_website.entity.UserImage;
import com.zjc.pic_website.mapper.ImageTagMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/table")
public class ImageTagController {
    @Resource
    private ImageTagMapper imageTagMapper;
    @GetMapping("/imagetags/queryAll")
    JsonResponse<ImageTag> queryAll(Integer page, Integer limit){
        List<ImageTag> imageTagList =  imageTagMapper.queryTagsByPageAndLimit((page-1)*limit, limit);
        JsonResponse<ImageTag> response = new JsonResponse<>();
        response.setData(imageTagList);
        response.setCode(0);
        response.setCount(imageTagMapper.getCount());
        return response;
    }
}
