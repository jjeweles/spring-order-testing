package com.galvanize.datavalidation.services;

import com.galvanize.datavalidation.models.OrderModel;

import java.util.List;

public interface OrderBusinessServiceInterface {

    void test();
    void init();
    void destroy();

    OrderModel getById(Long id);
    List<OrderModel> getOrders();
    List<OrderModel> searchOrders(String search);
    long addOne(OrderModel order);
    boolean deleteOne(Long id);
    OrderModel updateOne(long idToUpdate, OrderModel order);

}
