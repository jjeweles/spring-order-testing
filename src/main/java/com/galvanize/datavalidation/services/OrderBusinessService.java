package com.galvanize.datavalidation.services;

import com.galvanize.datavalidation.data.OrdersDataAccessInterface;
import com.galvanize.datavalidation.models.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderBusinessService implements OrderBusinessServiceInterface {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    OrdersDataAccessInterface<OrderModel> ordersDAO;

    @Override
    public void test() {
        System.out.println("OrderBusinessService.test()");
    }

    @Override
    public List<OrderModel> getOrders() {
        return ordersDAO.getOrders();
    }

    @Override
    public List<OrderModel> searchOrders(String search) {
        return ordersDAO.searchOrders(search);
    }

    @Override
    public long addOne(OrderModel newOrder) {
        return ordersDAO.addOne(newOrder);
    }

    @Override
    public boolean deleteOne(Long id) {
        return ordersDAO.deleteOne(id);
    }

    @Override
    public OrderModel updateOne(long idToUpdate, OrderModel order) {
        return ordersDAO.updateOne(idToUpdate, order);
    }

    @Override
    public OrderModel getById(Long id) {
        return ordersDAO.getById(id);
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
