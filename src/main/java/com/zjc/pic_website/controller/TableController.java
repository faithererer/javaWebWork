package com.zjc.pic_website.controller;

import com.zjc.pic_website.entity.Image;
import com.zjc.pic_website.entity.JsonResponse;
import com.zjc.pic_website.entity.Tag;
import com.zjc.pic_website.entity.User;
import com.zjc.pic_website.mapper.ImageMapper;
import com.zjc.pic_website.mapper.TagMapper;
import com.zjc.pic_website.mapper.UserMapper;
import com.zjc.pic_website.service.ImageService;
import com.zjc.pic_website.service.TagService;
import com.zjc.pic_website.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/table")
public class TableController {
    @Resource
    private UserMapper userMapper;
    @Resource
    private TagMapper tagMapper;
    @Resource
    private TagService tagService;
    @Resource
    private UserService userService;
    @Resource
    private ImageMapper imageMapper;
    @Resource
    private ImageService imageService;
    @GetMapping("/users/queryAllUser")
    JsonResponse<User> queryAllUser(Integer page,Integer limit){
        List<User> userList = userMapper.queryUserByPageAndLimit((page-1)*limit, limit);
        JsonResponse<User> response = new JsonResponse<>();
        response.setData(userList);
        response.setCode(0);
        response.setCount(userMapper.getUserCount());
        return response;
    }

    @PostMapping("/users/addUser")
    public void addUser(User user){
        System.out.println(user);
        userMapper.addUser(user);
    }
    @PostMapping("/users/updateUser")
    public void updateUser(User user){
        System.out.println("GET: /users/updateUser");
        userMapper.updateUser(user);
    }
    @PostMapping("/users/delete")
    void delUser(@RequestBody ArrayList<User> users){
        System.out.println("POST: /users/delete");
        System.out.println(users);
        userService.delUser(users);
    }
    @GetMapping("/tags/queryAllTag")
    JsonResponse<Tag> queryAllTags(Integer page,Integer limit){
        List<Tag> tagList = tagMapper.queryTagsByPageAndLimit((page-1)*limit, limit);
        JsonResponse<Tag> response = new JsonResponse<>();
        response.setData(tagList);
        response.setCode(0);
        response.setCount(tagMapper.getTagCount());
        return response;
    }
    @GetMapping("/tags/query")
    List<String> queryTags(String imageURL){
        return tagService.getTagByImg(imageURL);
    }
    @PostMapping("/tags/addTag")
    public void addTag(Tag tag){
        System.out.println("GET : "+tag);
        tagMapper.addTag(tag);
    }
    @PostMapping("/tags/updateTag")
    public void updateTag(Tag tag){
        System.out.println("GET: /users/updateUser");
        tagMapper.updateUser(tag);
    }
    @PostMapping("/tags/delete")
    void delTag(@RequestBody ArrayList<Tag> tags){
        System.out.println("POST: /tags/delete");
        System.out.println(tags);
        tagService.delUser(tags);
    }

    @GetMapping("/images/queryAllImage")
    JsonResponse<Image> queryAllImage(Integer page,Integer limit){
        List<Image> imagesList =imageMapper.queryImagesByPageAndLimit((page-1)*limit, limit);
        JsonResponse<Image> response = new JsonResponse<>();
        response.setData(imagesList);
        response.setCode(0);
        response.setCount(imageMapper.getImageCount());
        return response;
    }
    @PostMapping("/images/addImage")
    public void addImage(Image images){
        System.out.println("POST: /images/addImage"+images);
        imageMapper.addImage(images);
    }
    @PostMapping("/images/updateImage")
    public void updateTag(Image images){
        System.out.println("GET: /images/updateImage "+images);
        imageMapper.updateImage(images);
    }
    @PostMapping("/images/delete")
    void delImage(@RequestBody ArrayList<Image> images){
        System.out.println("POST: /images/delete");
        System.out.println(images);
        imageService.delImage(images);
    }
    @GetMapping("/a")
    List<String> getImg(){
        List<Image> images = imageMapper.queryAllImages();
        List<String> list = new ArrayList<>();
        for(Image image : images){
            list.add(image.getImageURL());
            Collections.shuffle(list);
        }
        return list;
    }


}
