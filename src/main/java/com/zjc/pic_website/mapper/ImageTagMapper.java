package com.zjc.pic_website.mapper;

import com.zjc.pic_website.entity.Image;
import com.zjc.pic_website.entity.ImageTag;
import com.zjc.pic_website.entity.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ImageTagMapper {
    @Select("SELECT * FROM imagetags")
    List<ImageTag> queryAll();
    @Select("SELECT * FROM imagetags WHERE imageID=#{imageID}")
    List<ImageTag> queryByImageID(String imageID);
    @Select("SELECT * FROM imagetags ORDER BY imageTagID LIMIT #{limit} OFFSET #{offset}")
    List<ImageTag> queryTagsByPageAndLimit(Integer offset, Integer limit);
    @Select("SELECT COUNT(*) FROM imagetags")
    Integer getCount();
    @Insert("INSERT INTO imagetags (imageID,tagID) VALUES (#{imageID},#{tagID})")
    void add(ImageTag imageTag);
}
