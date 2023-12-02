package com.zjc.pic_website.service.impl;
import com.zjc.pic_website.entity.Image;
import com.zjc.pic_website.entity.ImageTag;
import com.zjc.pic_website.entity.Tag;
import com.zjc.pic_website.mapper.ImageMapper;
import com.zjc.pic_website.mapper.ImageTagMapper;
import com.zjc.pic_website.mapper.TagMapper;
import com.zjc.pic_website.service.TagService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class TagServiceImpl implements TagService {
    @Resource
    TagMapper tagMapper;
    @Resource
    ImageMapper imageMapper;
    @Resource
    ImageTagMapper imageTagMapper;
    @Override
    public void delUser(ArrayList<Tag> tags) {
        for (Tag item : tags) {
            tagMapper.delTagByID(item);
        }
        System.out.println("删除成功: "+tags);
    }

    @Override
    public List<String> getTagByImg(String imageURL) {
        //获得ImageID
        Image image = imageMapper.queryImageByURL(imageURL);
        List<ImageTag> imageTags = imageTagMapper.queryByImageID(image.getImageID());
         //获得tagID列表
        List<String> tagList = new ArrayList<>();
        for(ImageTag i : imageTags){
            //通过每个tagID来获取tagName
            tagList.add(tagMapper.queryTagByID(i.getTagID()).getTagName());
        }
        System.out.println(tagList);
        return tagList;
    }
}
