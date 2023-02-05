package com.galvanize.datavalidation.data;

import com.galvanize.datavalidation.models.OrderEntity;
import com.galvanize.datavalidation.models.OrderModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class OrdersDataServiceForRepository implements OrdersDataAccessInterface<OrderModel> {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    OrdersRepositoryInterface ordersRepository;

    private JdbcTemplate jdbcTemplate;

    public OrdersDataServiceForRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public OrderModel getById(Long id) {
        OrderEntity entity = ordersRepository.findById(id).orElse(null);
//        assert entity != null;
//        OrderModel model = new OrderModel(id, entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity());

        return modelMapper.map(entity, OrderModel.class);
    }

    @Override
    public List<OrderModel> getOrders() {
        Iterable<OrderEntity> ordersEntity = ordersRepository.findAll();
        List<OrderModel> models = new ArrayList<>();
        for (OrderEntity item : ordersEntity) {
            OrderModel orderModel = modelMapper.map(item, OrderModel.class);
            models.add(orderModel);
        }
        return models;
    }

    @Override
    public List<OrderModel> searchOrders(String search) {
        Iterable<OrderEntity> result = ordersRepository.findByProductNameContainingIgnoreCase(search);
        List<OrderModel> models = new ArrayList<>();
        for (OrderEntity item : result) {
            OrderModel orderModel = modelMapper.map(item, OrderModel.class);
            models.add(orderModel);
        }
        return models;
    }

    @Override
    public long addOne(OrderModel order) {
        OrderEntity orderEntity = modelMapper.map(order, OrderEntity.class);
        OrderEntity result = ordersRepository.save(orderEntity);
        return result.getId();
    }

    @Override
    public boolean deleteOne(Long id) {
        ordersRepository.deleteById(id);
        return true;
    }

    @Override
    public OrderModel updateOne(long idToUpdate, OrderModel order) {
        OrderEntity orderEntity = modelMapper.map(order, OrderEntity.class);
        orderEntity.setId(idToUpdate);
        OrderEntity result = ordersRepository.save(orderEntity);
        return modelMapper.map(result, OrderModel.class);
    }
}
