package com.rechuang.auth.authutil;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;
 
/**
 * 路径：com.example.demo.security.controller
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/9/26 14:30
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Controller
@SessionAttributes("authorizationRequest")
public class ErrorController {
 
    private static final Logger log = LoggerFactory.getLogger(ErrorController.class);
 
    @RequestMapping("/oauth/error")
    public String error(@RequestParam Map<String, String> parameters){
        String url = parameters.get("redirect_uri");
        log.info("重定向: {}", url);
        return "redirect:" + url;
    }
}