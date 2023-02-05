package com.galvanize.datavalidation;

import com.galvanize.datavalidation.data.OrdersDataAccessInterface;
import com.galvanize.datavalidation.data.OrdersDataServiceForRepository;
import com.galvanize.datavalidation.services.OrderBusinessService;
import com.galvanize.datavalidation.services.OrderBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean(name = "orderBusinessService", initMethod = "init", destroyMethod = "destroy")
    @RequestScope
    public OrderBusinessServiceInterface orderBusinessService() {
        return new OrderBusinessService();
    }

    @Autowired
    DataSource dataSource;

   @Bean(name = "ordersDao")
    @RequestScope
    public OrdersDataAccessInterface getDataService() {
        return new OrdersDataServiceForRepository(dataSource);
        // return new OrderDataService();
    }

}
