package com.zjc.pic_website.mapper;

import com.zjc.pic_website.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE username=#{username} AND pwd=#{pwd}")
    User queryUser(User user);
    @Select("SELECT * FROM users WHERE username=#{username}")
    User queryUserByUsername(String username);
    @Select("SELECT * FROM users")
    List<User> queryAllUser();
    @Select("SELECT * FROM users ORDER BY userID LIMIT #{limit} OFFSET #{offset}")
    List<User> queryUserByPageAndLimit(Integer offset,Integer limit);
    @Select("SELECT COUNT(*) FROM users")
    Integer getUserCount();

    @Insert("INSERT INTO users (username, pwd) VALUES (#{username}, #{pwd})")
    void addUser(User user);

    @Update("UPDATE users SET username=#{username}, pwd=#{pwd} WHERE userID=#{userID}")
    void updateUser(User user);
    @Delete("DELETE FROM users WHERE UserID = #{userID}")
    void delUserByID(User user);
}
