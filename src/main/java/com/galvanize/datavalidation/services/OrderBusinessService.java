package com.galvanize.datavalidation.services;

import com.galvanize.datavalidation.models.OrderModel;

import java.util.ArrayList;
import java.util.List;

public class OrderBusinessService implements OrderBusinessServiceInterface {

    List<OrderModel> orders;

    @Override
    public void test() {
        System.out.println("OrderBusinessService.test()");
    }

    @Override
    public List<OrderModel> getOrders() {
        orders.add(new OrderModel(0L, "000", "Sky diving experience", 1500.0f, 1));
        orders.add(new OrderModel(1L, "001", "Run with the bulls", 500.0f, 2));
        orders.add(new OrderModel(2L, "002", "Orbit the moon", 11500.0f, 4));
        orders.add(new OrderModel(3L, "003", "Shot from cannon", 1250.0f, 3));
        orders.add(new OrderModel(4L, "004", "Zipline the Grand Canyon", 750.0f, 2));
        orders.add(new OrderModel(5L, "005", "Wingsuit jumping in Norway", 3300.0f, 6));
        orders.add(new OrderModel(6L, "006", "Whole enchilada in Moab", 1245.0f, 10));
        orders.add(new OrderModel(7L, "007", "Backpacking Mt Kilimanjaro", 3245.0f, 4));
        orders.add(new OrderModel(8L, "008", "SCUBA drive in Palau", 7450.0f, 2));
        orders.add(new OrderModel(9L, "009", "Drive stock car around the track", 2750.0f, 3));

        return orders;
    }

    @Override
    public void init() {
        orders = new ArrayList<>();
        System.out.println("OrderBusinessService.init()");
    }

    @Override
    public void destroy() {
        System.out.println("OrderBusinessService.destroy()");
    }
}
