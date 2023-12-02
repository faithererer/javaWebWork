package com.zjc.pic_website.controller;

import com.zjc.pic_website.Utils.FileSaveUtil;
import com.zjc.pic_website.service.FormService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
public class FormController {

    @Resource
    private FormService formService;

    @PostMapping("/upload")
    @ResponseBody
    public Boolean upload(MultipartFile file) throws IOException {
        if(file.isEmpty()){
            System.out.println("上传失败");
        }
        // 打印一系列值
        System.out.println(file.getOriginalFilename()+","+file.getSize());
        System.out.println(file.getContentType());
        //获取/upload目录的物理路径
        FileSaveUtil.saveFile(file,"F:\\a\\");
        return Boolean.TRUE;
    }
    @PostMapping("/form")
    public String doForm(MultipartFile file, String username,String tags) throws IOException {
        // 打印一系列值
        System.out.println(file.getOriginalFilename() + "," + file.getSize());
        System.out.println(username);
        System.out.println(tags);
        List<String> tag_list = formService.strToTagList(tags);
        System.out.println(tag_list);
        formService.pushToDB(username,tag_list,file.getOriginalFilename());
        FileSaveUtil.saveFile(file,"F:\\pic_loc");
        return "ok";
    }
}
