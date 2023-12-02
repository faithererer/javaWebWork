package com.zjc.pic_website.Utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileSaveUtil {
    public static void saveFile(MultipartFile photo, String path) throws IOException {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        System.out.println(path);
        File file = new File(path + photo.getOriginalFilename());
        System.out.println(file.getPath());

        // 检查文件是否已存在
        if (!file.exists()) {
            // 保存到指定文件
            photo.transferTo(file);
            System.out.println("File saved successfully!");
        } else {
            System.out.println("File already exists. Skipped saving.");
        }
    }

}
