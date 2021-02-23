package jorge.munoz.reto_2.Repositories.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import jorge.munoz.reto_2.Repositories.Entities.OrderEntity;

public interface OrdersRepository
    extends JpaRepository<OrderEntity, Long>{

}
