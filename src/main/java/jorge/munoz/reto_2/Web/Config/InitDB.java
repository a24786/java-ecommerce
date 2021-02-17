package jorge.munoz.reto_2.Web.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jorge.munoz.reto_2.Repositories.Entities.OrderEntity;
import jorge.munoz.reto_2.Repositories.Entities.OrderProductEntity;
import jorge.munoz.reto_2.Repositories.Entities.ProductEntity;
import jorge.munoz.reto_2.Repositories.Interfaces.OrderProductsRepository;
import jorge.munoz.reto_2.Repositories.Interfaces.OrdersRepository;
import jorge.munoz.reto_2.Repositories.Interfaces.ProductsRepository;


@Configuration
public class InitDB {
    @Bean
    CommandLineRunner initDatabase(ProductsRepository productsRepository, OrdersRepository ordersRepository, OrderProductsRepository orderProductsRepository) {
        return args -> {
            Long a = 1L;
            Long b = 1L;
            for(int i = 1; i<=10; i++){   
                productsRepository.save(new ProductEntity("casa"+i, 100+i, "https://picsum.photos/200/300"));
                ordersRepository.save(new OrderEntity("12/01/1998", "Jorge", "Enviado"));
                orderProductsRepository.save(new OrderProductEntity(a,123.4, b));
                a++;
                b++;
            }
            
        };
    }
}