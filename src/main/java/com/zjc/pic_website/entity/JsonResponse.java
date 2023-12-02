package com.zjc.pic_website.entity;

import lombok.Data;

import java.util.List;

@Data
public class JsonResponse<T> {
    private int code;
    private String msg="成功";
    private int count;
    private List<T> data;
}
