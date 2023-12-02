package com.zjc.pic_website.mapper;

import com.zjc.pic_website.entity.Image;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ImageMapper {
    @Select("SELECT * FROM images WHERE imageID=#{imageID}")
    Image queryImageByID(Image image);
    @Select("SELECT * FROM images WHERE imageURL=#{file_name)}")
    Image queryImageByURL(String file_name);
    @Select("SELECT * FROM images")
    List<Image> queryAllImages();
    @Select("SELECT * FROM images ORDER BY imageID LIMIT #{limit} OFFSET #{offset}")
    List<Image> queryImagesByPageAndLimit(Integer offset,Integer limit);
    @Insert("INSERT INTO images (imageURL) VALUES (#{imageURL})")
    @Options(useGeneratedKeys = true, keyProperty = "imageID")
    void addImage(Image image);
    @Select("SELECT COUNT(*) FROM images")
    Integer getImageCount();
    @Update("UPDATE images SET imageURL=#{imageURL} WHERE imageID=#{imageID}")
    void updateImage(Image image);
    @Delete("DELETE FROM images WHERE imageID = #{imageID}")
    void delImageByID(Image image);
}
