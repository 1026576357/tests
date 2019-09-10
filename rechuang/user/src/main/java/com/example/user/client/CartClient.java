package com.example.user.client;


import com.cart.test;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;


//@FeignClient(value = "cart-server")
public interface CartClient extends test {
}
