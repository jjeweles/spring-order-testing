package com.galvanize.datavalidation.controllers;

import com.galvanize.datavalidation.models.OrderModel;
import com.galvanize.datavalidation.services.OrderBusinessServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    OrderBusinessServiceInterface service;

    public IndexController(OrderBusinessServiceInterface service) {
        this.service = service;
    }

    @RequestMapping("/")
    public String index(Model model) {

        List<OrderModel> orders = service.getOrders().subList(0, 6);
        model.addAttribute("orders", orders);

        return "index";
    }

}
