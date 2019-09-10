package com.example.user.service.userinterface;

import com.example.user.pojo.Admin;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface UserInterface {
    List<Admin> findAdmin();

    Map register(String user_name, String password1, String password2, String email, String invitation_code);

    Map login(HttpServletRequest res, HttpServletResponse rep, String user_name, String password, String son_user);

    Map retrieve_password(String password1, String password2, String email, String code);

    Map index(HttpServletRequest httpRequest, HttpServletResponse response, String token);

    Map find_sonUser(HttpServletRequest res, HttpServletResponse rep, String token);
}
