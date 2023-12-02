package com.zjc.pic_website.service.impl;

import com.zjc.pic_website.entity.*;
import com.zjc.pic_website.mapper.*;
import com.zjc.pic_website.service.FormService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class FormServiceImpl implements FormService {
    @Override
    public List<String> strToTagList(String tags) {
        String[] strArray = tags.split(","); // 使用逗号分割字符串，生成字符串数组
        List<String> strList = Arrays.asList(strArray);
        return strList;
    }

    @Resource
    private UserMapper userMapper;
    @Resource
    private ImageMapper imageMapper;
    @Resource
    private TagMapper tagMapper;
    @Resource
    private UserImageMapper userImageMapper;
    @Resource
    private ImageTagMapper imageTagMapper;

    @Override
    @Transactional
    public void pushToDB(String username,List<String> tag_list,String file_name) {

        // 查到当前表单用户信息
        User user = userMapper.queryUserByUsername(username);
        System.out.println(user);
        //插入图片信息
        Image i = imageMapper.queryImageByURL(file_name);
        if(i!=null){//查询已存在图片返回
            System.out.println("查询已存在图片返回"+i);
            return;
        }
        //插入图片信息
        Image image = new Image();
        image.setImageURL(file_name);
        imageMapper.addImage(image); //自动注入id
        System.out.println(image);

        List<String> tag_id_list=new ArrayList<>();
        //插入标签信息
        for(String item_tag:tag_list){
            Tag tag = new Tag();
            tag.setTagName(item_tag);
            tagMapper.addTag(tag);
            tag_id_list.add(tag.getTagID());
        }
        //关联用户和图片
        UserImage userImage = new UserImage();
        userImage.setUserID(user.getUserID());
        userImage.setImageID(image.getImageID());
        userImageMapper.add(userImage);

        //关联图片和tag
        for(String tag_id:tag_id_list){
            ImageTag imageTag = new ImageTag();
            imageTag.setImageID(image.getImageID());
            imageTag.setTagID(tag_id);
            imageTagMapper.add(imageTag);
        }
    }
}
