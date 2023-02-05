package com.galvanize.datavalidation.data;

import com.galvanize.datavalidation.models.OrderModel;
import com.galvanize.datavalidation.models.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Primary
public class OrderDataService implements OrdersDataAccessInterface {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public OrderModel getById(Long id) {
        List<OrderModel> result = jdbcTemplate.query("SELECT * FROM orders WHERE ID = ?", new OrdersMapper(), id);

        if (result.size() > 0) {
            return result.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<OrderModel> getOrders() {
        return jdbcTemplate.query("SELECT * FROM orders", new OrdersMapper());
    }

    @Override
    public List<OrderModel> searchOrders(String search) {
        return jdbcTemplate.query("SELECT * FROM orders WHERE PRODUCT_NAME LIKE ?", new OrdersMapper(), "%" + search + "%");
    }

    @Override
    public long addOne(OrderModel order) {
//        long result = jdbcTemplate.update("INSERT INTO orders (ORDER_NUMBER, PRODUCT_NAME, PRICE, QTY) VALUES (?,?,?,?)",
//                order.getOrderNo(),
//                order.getProductName(),
//                order.getPrice(),
//                order.getQuantity()
//                );
//
//        return result;
        SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(jdbcTemplate);

        simpleInsert.withTableName("orders").usingGeneratedKeyColumns("ID");

        Map<String, Object> params = new HashMap<>();
        params.put("ORDER_NUMBER", order.getOrderNo());
        params.put("PRODUCT_NAME", order.getProductName());
        params.put("PRICE", order.getPrice());
        params.put("QTY", order.getQuantity());

        Number result = simpleInsert.executeAndReturnKey(params);

        return result.longValue();
    }

    @Override
    public boolean deleteOne(Long id) {
        long result = jdbcTemplate.update("DELETE FROM orders WHERE ID = ?", id);
        return result > 0;
    }

    @Override
    public OrderModel updateOne(long idToUpdate, OrderModel order) {
        long result = jdbcTemplate.update("UPDATE orders SET ORDER_NUMBER = ?, PRODUCT_NAME = ?, PRICE = ?, QTY = ? WHERE ID = ?",
                order.getOrderNo(),
                order.getProductName(),
                order.getPrice(),
                order.getQuantity(),
                idToUpdate
        );

        if (result > 0) {
            return order;
        } else {
            return null;
        }
    }
}
