package jorge.munoz.reto_2.Web.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jorge.munoz.reto_2.Services.OrderProductsService;
import jorge.munoz.reto_2.Services.OrdersService;
import jorge.munoz.reto_2.Services.ProductsService;

@Configuration
public class DI {
    @Bean
    ProductsService createProductService(){
        return new ProductsService();
    }

    @Bean
    OrdersService createOrdersService(){
        return new OrdersService();
    }

    @Bean
    OrderProductsService createOrderProductsService(){
        return new OrderProductsService();
    }

    @Bean
    ModelMapper createModelMapper(){
        return new ModelMapper();
    }
}
