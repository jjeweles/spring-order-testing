package com.galvanize.datavalidation.data;

import com.galvanize.datavalidation.models.OrderEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepositoryInterface extends CrudRepository<OrderEntity, Long> {

    // use the CrudRepository class in Spring Data JPA to implement this interface
    // already implies the following methods:
    // save, findAll, findById, deleteById, deleteAll, etc.

    List<OrderEntity> findByProductNameContainingIgnoreCase(String search);

}
