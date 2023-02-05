package com.galvanize.datavalidation.data;

import com.galvanize.datavalidation.models.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepositoryInterface extends CrudRepository<OrderEntity, Long> {

    // use the CrudRepository class in Spring Data JPA to implement this interface

}
