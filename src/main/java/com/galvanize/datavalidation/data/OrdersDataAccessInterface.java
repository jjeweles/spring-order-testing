package com.galvanize.datavalidation.data;

import com.galvanize.datavalidation.models.OrderModel;

import java.util.List;

public interface OrdersDataAccessInterface <T> {

    T getById(Long id);
    List<T> getOrders();
    List<T> searchOrders(String search);
    long addOne(T order);
    boolean deleteOne(Long id);
    T updateOne(long idToUpdate, T order);

}
