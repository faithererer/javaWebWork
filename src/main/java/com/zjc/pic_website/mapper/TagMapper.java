package com.zjc.pic_website.mapper;

import com.zjc.pic_website.entity.Tag;
import com.zjc.pic_website.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TagMapper {
    @Select("SELECT * FROM tags WHERE tagID=#{tagID}")
    Tag queryTagByID(String tagID);
    @Select("SELECT * FROM tags")
    List<Tag> queryAllTags();
    @Select("SELECT * FROM tags ORDER BY tagID LIMIT #{limit} OFFSET #{offset}")
    List<Tag> queryTagsByPageAndLimit(Integer offset,Integer limit);

    @Insert("INSERT INTO tags (tagName) VALUES (#{tagName})")
    @Options(useGeneratedKeys = true, keyProperty = "tagID")
    void addTag(Tag tag);
    @Select("SELECT COUNT(*) FROM tags")
    Integer getTagCount();
    @Update("UPDATE users SET tagName=#{tagName} WHERE tagID=#{tagID}")
    void updateUser(Tag tag);
    @Delete("DELETE FROM tags WHERE tagID = #{tagID}")
    void delTagByID(Tag tag);
}
