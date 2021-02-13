package jorge.munoz.reto_2.Web.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jorge.munoz.reto_2.Services.ProductsService;

@Configuration
public class DI {
    @Bean
    ProductsService createUsersService(){
        return new ProductsService();
    }

    @Bean
    ModelMapper createModelMapper(){
        return new ModelMapper();
    }
}
