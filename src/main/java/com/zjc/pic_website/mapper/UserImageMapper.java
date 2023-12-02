package com.zjc.pic_website.mapper;

import com.zjc.pic_website.entity.User;
import com.zjc.pic_website.entity.UserImage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserImageMapper {
    @Select("SELECT * FROM userimages WHERE userID=#{userID} AND imageID=#{imageID}")
    UserImage query(UserImage userImage);
    @Select("SELECT * FROM userimages")
    List<UserImage> queryAll();
    @Select("SELECT * FROM userimages ORDER BY userImageID LIMIT #{limit} OFFSET #{offset}")
    List<UserImage> queryByPageAndLimit(Integer offset,Integer limit);
    @Select("SELECT COUNT(*) FROM userimages")
    Integer getCount();

    @Insert("INSERT INTO userimages (userID, imageID) VALUES (#{userID}, #{imageID})")
    void add(UserImage userImage);

    @Update("UPDATE userimages SET userID=#{userID}, imageID=#{imageID} WHERE userImageID=#{userImageID}")
    void update(UserImage userImage);
    @Delete("DELETE FROM userimages WHERE userImageID = #{userImageID}")
    void delByID(UserImage userImage);
}
