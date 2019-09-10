package com.example.user.controller;


import com.example.common.response.CodeMsg;
import com.example.user.client.CartClient;
import com.example.user.pojo.Admin;
import com.example.user.service.userinterface.UserInterface;
import com.example.user.service.userservice.UserService;
//import com.netflix.discovery.converters.Auto;
import com.sun.deploy.net.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {
//  @Autowired
//  private CartClient cartClient;
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  UserInterface userInterface;
    //测试
  @RequestMapping("/get_announcement")
  public ResponseEntity<CodeMsg> show(){
//  cartClient.show();
//        logger.error("success");
      CodeMsg codeMsg = new CodeMsg(1, "2");
      List<Admin> admin = userInterface.findAdmin();
      System.out.print(admin);
      return new ResponseEntity<CodeMsg>(HttpStatus.ACCEPTED);
    }

    //注册
    @PostMapping("/register")
    public Map register(String user_name,String password1,String password2,String email,@RequestParam(value = "0", required = false)String invitation_code){
        Map map=userInterface.register(user_name,password1,password2,email,invitation_code);
      return map;
    }


    //登录
    @PostMapping("/login")
    public Map login(HttpServletRequest res, HttpServletResponse rep, String user_name, String password, @RequestParam(value = "0", required = false)String son_user){
      Map map=userInterface.login(res,rep,user_name,password,son_user);
      return map;
    }


    //忘记密码
    @PostMapping("/retrieve_password")
    public  Map retrieve_password(String password1,String password2,String email,String code){
      Map map=userInterface.retrieve_password(password1,password2,email,code);
      return  map;
    }


    //获取个人信息
    @RequestMapping("/index")
    public Map index(HttpServletRequest res,HttpServletResponse rep,@CookieValue String rc_token){
      System.out.println(rc_token);
      Map ma=userInterface.index(res,rep,rc_token);
      return ma;
    }

    //查看子用户
  @RequestMapping("/son_user")
  public Map son_user(HttpServletRequest res,HttpServletResponse rep,String token){
    Map ma=userInterface.find_sonUser(res,rep,token);
    return null;
  }
}
