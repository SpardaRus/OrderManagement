package com.spardarus.controller.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

    @GetMapping("/getOrders")
    public String getOrders() {
        return "This is orders";
    }

}
