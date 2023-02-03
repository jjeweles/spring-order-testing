package com.galvanize.datavalidation.services;

import com.galvanize.datavalidation.models.OrderModel;

import java.util.ArrayList;
import java.util.List;

public class OrderBusinessService2 implements OrderBusinessServiceInterface {
    @Override
    public void test() {
        System.out.println("OrderBusinessService.test()");
    }

    @Override
    public List<OrderModel> getOrders() {
        List<OrderModel> orders = new ArrayList<>();
        // make a list of orders of fast food
        orders.add(new OrderModel(0L, "000", "BigMac", 3.99f, 1));
        orders.add(new OrderModel(1L, "001", "Fries", 1.99f, 2));
        orders.add(new OrderModel(2L, "002", "Coke", 1.99f, 4));
        orders.add(new OrderModel(3L, "003", "Chicken Nuggets", 3.99f, 3));
        orders.add(new OrderModel(4L, "004", "McFlurry", 1.99f, 2));
        orders.add(new OrderModel(5L, "005", "McChicken", 3.99f, 6));
        orders.add(new OrderModel(6L, "006", "McDouble", 1.99f, 10));
        orders.add(new OrderModel(7L, "007", "McRib", 3.99f, 4));

        return orders;
    }

    @Override
    public void init() {
        System.out.println("OrderBusinessService.init()");
    }

    @Override
    public void destroy() {
        System.out.println("OrderBusinessService.destroy()");
    }
}
