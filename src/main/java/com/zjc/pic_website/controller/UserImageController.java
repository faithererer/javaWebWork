package com.zjc.pic_website.controller;

import com.zjc.pic_website.entity.Image;
import com.zjc.pic_website.entity.JsonResponse;
import com.zjc.pic_website.entity.UserImage;
import com.zjc.pic_website.mapper.ImageMapper;
import com.zjc.pic_website.mapper.UserImageMapper;
import com.zjc.pic_website.service.UserImageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/table")
public class UserImageController {
    @Resource
    private UserImageMapper userImageMapper;
    @Resource
    private UserImageService userImageService;
    @GetMapping("/userimages/queryAll")
    JsonResponse<UserImage> queryAll(Integer page, Integer limit){
        List<UserImage> userImageList =  userImageMapper.queryByPageAndLimit((page-1)*limit, limit);
        JsonResponse<UserImage> response = new JsonResponse<>();
        response.setData(userImageList);
        response.setCode(0);
        response.setCount(userImageMapper.getCount());
        return response;
    }
    @PostMapping("/userimages/add")
    public void add(UserImage userImage){
        System.out.println("POST: /images/add"+userImage);
        userImageMapper.add(userImage);
    }
    @PostMapping("/userimages/update")
    public void update(UserImage userImage){
        System.out.println("GET: /images/updateImage "+userImage);
        userImageMapper.update(userImage);
    }
    @PostMapping("/userimages/delete")
    void del(@RequestBody ArrayList<UserImage> userImage){
        System.out.println("POST: /images/delete "+userImage);
        userImageService.del(userImage);
    }
}
