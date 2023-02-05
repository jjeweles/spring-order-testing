package com.galvanize.datavalidation.data;

import com.galvanize.datavalidation.models.OrderModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class OrdersFakeDAO implements OrdersDataAccessInterface {

    List<OrderModel> orders = new ArrayList<>();

    public OrdersFakeDAO() {
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
    }

    @Override
    public OrderModel getById(Long id) {
        for (OrderModel order : orders) {
            if (Objects.equals(order.getId(), id)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<OrderModel> getOrders() {
        return orders;
    }

    @Override
    public List<OrderModel> searchOrders(String search) {

//        List<OrderModel> foundItems = new ArrayList<>();
//
//        for (int i = 0; i < orders.size(); i++) {
//            if (orders.get(i).getProductName().toLowerCase().contains(search.toLowerCase())) {
//                foundItems.add(orders.get(i));
//            }
//        }
//        return foundItems;

        return orders
                .stream()
                .filter(order -> order.getProductName().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public long addOne(OrderModel newOrder) {
        boolean added = orders.add(newOrder);
        if (added) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean deleteOne(Long id) {
        return orders.removeIf(order -> Objects.equals(order.getId(), id));
    }

    @Override
    public OrderModel updateOne(long idToUpdate, OrderModel order) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == idToUpdate) {
                orders.set(i, order);
                return order;
            }
        }
        return null;
    }
}
