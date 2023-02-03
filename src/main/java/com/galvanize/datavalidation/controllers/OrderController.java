package com.galvanize.datavalidation.controllers;

import com.galvanize.datavalidation.models.OrderModel;
import com.galvanize.datavalidation.services.OrderBusinessService;
import com.galvanize.datavalidation.services.OrderBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    OrderBusinessServiceInterface service;

    @Autowired
    public OrderController(OrderBusinessServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showAllOrders(Model model) {

        List<OrderModel> orders = service.getOrders();

        model.addAttribute("title", "Summer Vacation Packages");
        model.addAttribute("orders", orders);

        return "orders";
    }
}
