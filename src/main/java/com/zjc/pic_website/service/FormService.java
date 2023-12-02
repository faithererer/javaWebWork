package com.zjc.pic_website.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FormService {
    List<String> strToTagList(String tags);

    void pushToDB(String username,List<String> tag_list,String file_name);
}
