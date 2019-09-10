package com.test.cs;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cc")
@RestController
public class CartController  {
    @RequestMapping("/cs")
    public String show(){
        System.out.println("service");
        return  "show";
    }
}
