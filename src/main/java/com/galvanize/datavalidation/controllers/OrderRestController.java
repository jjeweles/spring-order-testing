package com.galvanize.datavalidation.controllers;

import com.galvanize.datavalidation.models.OrderModel;
import com.galvanize.datavalidation.services.OrderBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderRestController {

    OrderBusinessServiceInterface service;

    @Autowired
    public OrderRestController(OrderBusinessServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<OrderModel> showAllOrders(Model model) {
        return service.getOrders();
    }

    @GetMapping("/search/{searchTerm}")
    public List<OrderModel> searchOrders(@PathVariable(name="searchTerm") String searchTerm) {
        return service.searchOrders(searchTerm);
    }

    @PostMapping("/")
    public long addOrder(@RequestBody OrderModel order) {
        return service.addOne(order);
    }

    @GetMapping("/{id}")
    public OrderModel getOrderById(@PathVariable(name="id") Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteOrderById(@PathVariable(name="id") Long id) {
        return service.deleteOne(id);
    }

    @PutMapping("/update/{id}")
    public OrderModel updateOrderById(@PathVariable(name="id") Long id, @RequestBody OrderModel order) {
        return service.updateOne(id, order);
    }
}
