package com.galvanize.datavalidation;

import com.galvanize.datavalidation.services.OrderBusinessService;
import com.galvanize.datavalidation.services.OrderBusinessServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class SpringConfig {

    @Bean(name = "orderBusinessService", initMethod = "init", destroyMethod = "destroy")
    @RequestScope
    public OrderBusinessServiceInterface orderBusinessService() {
        return new OrderBusinessService();
    }

}
