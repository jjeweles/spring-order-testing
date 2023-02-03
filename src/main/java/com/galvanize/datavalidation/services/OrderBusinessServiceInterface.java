package com.galvanize.datavalidation.services;

import com.galvanize.datavalidation.models.OrderModel;

import java.util.List;

public interface OrderBusinessServiceInterface {

    void test();

    List<OrderModel> getOrders();

    void init();

    void destroy();

    // TODO future methods
    // ! searchOrders(String search)

    // ! addOrder(OrderModel order)

    // ! deleteOrder(Long id)

    // ! updateOrder(OrderModel order)

    // ! getOrder(Long id)

}
