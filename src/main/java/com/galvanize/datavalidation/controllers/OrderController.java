package com.galvanize.datavalidation.controllers;

import com.galvanize.datavalidation.models.OrderModel;
import com.galvanize.datavalidation.models.SearchModel;
import com.galvanize.datavalidation.services.OrderBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
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

        model.addAttribute("title", "Orders App");
        model.addAttribute("orders", orders);

        return "orders";
    }

    @GetMapping("/orderform")
    public String orderForm(Model model) {
        model.addAttribute("title", "Order Form");
        model.addAttribute("order", new OrderModel());

        return "orderform";
    }

    @PostMapping("/addNew")
    public String addNewOrder(@Valid OrderModel order, BindingResult bindingResult, Model model) {

        // set a new id --- NOT NECESSARY?
        order.setId(null);

        // add to database
        service.addOne(order);

        // get all orders from database
        List<OrderModel> orders = service.getOrders();

        // show all orders
        model.addAttribute("orders", orders);

        return "orders";
    }

    @GetMapping("/searchform")
    public String searchForm(Model model) {
        model.addAttribute("title", "Search Form");
        model.addAttribute("searchModel", new SearchModel());

        return "searchform";
    }

    @PostMapping("/search")
    public String search(@Valid SearchModel searchModel, BindingResult bindingResult, Model model) {

        String searchTerm = searchModel.getSearchTerm();

        List<OrderModel> orders = service.searchOrders(searchTerm);

        model.addAttribute("orders", orders);

        return "orders";
    }

    @GetMapping("/admin")
    public String showAdminPage(Model model) {

        List<OrderModel> orders = service.getOrders();

        model.addAttribute("title", "Admin Page");
        model.addAttribute("orders", orders);

        return "admin";
    }

    @PostMapping("/editForm")
    public String displayEditForm(OrderModel orderModel, Model model) {
        model.addAttribute("title", "Edit Order");
        model.addAttribute("orderModel", orderModel);

        return "editform";
    }

    @PostMapping("/processUpdate")
    public String updateOrder(@Valid OrderModel order, Model model) {
        // add the updated order to the database
        service.updateOne(order.getId(), order);

        // get all orders from database
        List<OrderModel> orders = service.getOrders();

        // display all orders
        model.addAttribute("orders", orders);

        return "admin";
    }

    @PostMapping("/delete")
    public String deleteOrder(OrderModel orderModel, Model model) {
        // delete the order from the database
        service.deleteOne(orderModel.getId());

        // get all orders from database
        List<OrderModel> orders = service.getOrders();

        // display all orders
        model.addAttribute("orders", orders);

        return "admin";
    }

 }
