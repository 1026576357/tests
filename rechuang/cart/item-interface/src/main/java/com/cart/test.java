package com.cart;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cc")
public interface test {
    @RequestMapping("/cs")
    public void show();
}
