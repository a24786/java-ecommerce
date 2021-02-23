package jorge.munoz.reto_2.Repositories.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import jorge.munoz.reto_2.Repositories.Entities.ProductEntity;

public interface ProductsRepository
    extends JpaRepository<ProductEntity, Long>{

}
