package com.galvanize.datavalidation.data;

import com.galvanize.datavalidation.models.OrderModel;

import java.util.List;

public interface OrdersDataAccessInterface {

    OrderModel getById(Long id);
    List<OrderModel> getOrders();
    List<OrderModel> searchOrders(String search);
    long addOne(OrderModel order);
    boolean deleteOne(Long id);
    OrderModel updateOne(long idToUpdate, OrderModel order);

}
