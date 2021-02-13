package jorge.munoz.reto_2.Web.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jorge.munoz.reto_2.Repositories.Entities.ProductEntity;
import jorge.munoz.reto_2.Repositories.Interfaces.ProductsRepository;


@Configuration
public class InitDB {
    @Bean
    CommandLineRunner initDatabase(ProductsRepository productsRepository) {
        return args -> {
            for(int i = 1; i<=10; i++){   
                productsRepository.save(new ProductEntity("casa1", 100+i, "url_"+i));
            }
        };
    }
}