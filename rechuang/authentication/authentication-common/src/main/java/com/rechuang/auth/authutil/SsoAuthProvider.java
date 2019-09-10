package com.rechuang.auth.authutil;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
 
import java.util.Collections;
 
/**
 * 路径：com.example.demo.security.config
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/9/26 14:33
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Component
public class SsoAuthProvider implements AuthenticationProvider{
 
    private static final Logger log = LoggerFactory.getLogger(SsoAuthProvider.class);
 
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("自定义provider调用");
        //// 返回一个Token对象表示登陆成功
        return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), Collections.<GrantedAuthority>emptyList());
    }
 
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
