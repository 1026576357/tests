package com.example.user.service.userservice;

import com.example.common.utils.CookieUtils;
import com.example.user.mapper.UserMapper;
import com.example.user.pojo.Admin;
import com.example.user.pojo.User;
import com.example.user.service.userinterface.UserInterface;
import com.example.user.util.JwtProperties;
import com.rechuang.auth.entity.UserInfo;

import com.rechuang.auth.utils.JwtUtils;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements UserInterface {
    @Autowired
    UserMapper userMapper;
    @Autowired
    private JwtProperties properties;
    @Override
    public List<Admin> findAdmin() {
        List<Admin> admin = userMapper.findAdmin();
        return admin;

    }

    @Override
    //注册
    public Map register(String user_name, String password1, String password2, String email,String invitation_code) {
        Map map=new HashMap();
        int status=400;
        String msg="注册失败";
        if(!password1.equals(password2)){
           map.put("status",400);
           map.put("msg","注册失败");
            return map;
        }
       int res= userMapper.register(user_name,password1,email,invitation_code,new Date());
        System.out.println(res);
        if(res>0){
            map.put("status",200);
            map.put("msg","注册成功");
        }else {
            map.put("status", 400);
            map.put("msg", "注册失败");
        }
        return map;
    }

    @Override
    //登录
    public Map login(HttpServletRequest res, HttpServletResponse rep, String user_name, String password, String son_user) {
        Map map=new HashMap();
        User us=userMapper.login(user_name,password);
        if(res!=null){
            try {
                String token = JwtUtils.generateToken(new UserInfo(us.getId(), us.getUserName()),
                        properties.getPrivateKey(), properties.getExpire());
                System.out.println(token);
                map.put("status",200);
                map.put("token_data",token);
                map.put("son_user",son_user);
                CookieUtils.setCookie(res,rep,"rc_token",token);
                return map;
            }catch (Exception e){
                e.printStackTrace();
                map.put("status",400);
                map.put("msg","登录失败");
                return  map;
            }
        }else {
            map.put("status", 400);
            map.put("msg", "登录失败");
        }
        return map;
    }

    @Override
    //改密
    public Map retrieve_password(String password1, String password2, String email, String code) {
        Map ma=new HashMap();
        if(password1.equals(password2)){
          int i= userMapper.updatePassword(password1,email);
          if(i>0){
              ma.put("status",200);
              ma.put("msg","修改成功");
          }else{
              ma.put("status",400);
              ma.put("msg","修改失败");
          }
        }else{
            ma.put("status",400);
            ma.put("msg","修改失败");
        }
        return ma;
    }

    @Override
    public Map index(HttpServletRequest request, HttpServletResponse response, @CookieValue("rc_token")String token)  {
        Map map=new HashMap();

        try {
            //1.从token中解析token信息
            UserInfo userInfo = JwtUtils.getInfoFromToken(token, this.properties.getPublicKey());
            if(userInfo!=null){

                //2.解析成功要重新刷新token
                token = JwtUtils.generateToken(userInfo, this.properties.getPrivateKey(), this.properties.getExpire());
                //3.更新Cookie中的token
                CookieUtils.setCookie(request, response, this.properties.getCookieName(), token, this.properties.getCookieMaxAge());
                //4.解析成功返回用户信息
                System.out.println(token);
                System.out.println(userInfo);
                map.put("status",200);
                map.put("msg","success");
                map.put("data",userMapper.loginByJwt(userInfo.getId()));
                return map;
            }else{
                map.put("status",400);
                map.put("msg","失败");

            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("123567");
        }
        return map;
    }

    @Override
    public Map find_sonUser(HttpServletRequest res, HttpServletResponse rep, String token) {
      Map map=new HashMap();

        return null;
    }


}
