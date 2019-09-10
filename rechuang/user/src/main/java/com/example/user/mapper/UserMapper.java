package com.example.user.mapper;

import com.example.user.pojo.Admin;
import com.example.user.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserMapper {
    public List<Admin> findAdmin();

    int register(@Param("username") String user_name, @Param("password") String password1, @Param("email") String email, @Param("invitation_code") String invitation_code,@Param("dateTime") Date dateTime);

    User login(@Param("username") String user_name, @Param("password") String password);

    int updatePassword(@Param("password") String password1,@Param("email") String email);

    User loginByJwt(Long id);
}
