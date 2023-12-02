package com.zjc.pic_website.service;
import com.zjc.pic_website.entity.ImageTag;
import com.zjc.pic_website.entity.Tag;
import com.zjc.pic_website.mapper.ImageTagMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public interface TagService {
    void delUser(ArrayList<Tag> tags);
    List<String> getTagByImg(String imageURL);
}
