package com.zjc.pic_website.controller;

import com.zjc.pic_website.entity.Admin;
import com.zjc.pic_website.entity.User;
import com.zjc.pic_website.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@Controller
public class LoginController {

    @Resource
    LoginService loginService;

    @GetMapping("/login")
    public String returnLogin(){
        return "index";
    }


    @PostMapping("/login")
    public ResponseEntity<Boolean> auth(@RequestBody Admin admin){
        System.out.println(admin);
        System.out.println("触发");
        return ResponseEntity.ok(loginService.isAuth(admin));
    }
}
