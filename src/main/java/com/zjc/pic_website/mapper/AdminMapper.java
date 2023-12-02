package com.zjc.pic_website.mapper;

import com.zjc.pic_website.entity.Admin;
import com.zjc.pic_website.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {
    @Select("SELECT * FROM admin WHERE admin_name=#{admin_name} AND pwd=#{pwd}")
    Admin queryAdmin(Admin admin);
}
