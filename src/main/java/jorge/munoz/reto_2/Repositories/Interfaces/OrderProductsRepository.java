package jorge.munoz.reto_2.Repositories.Interfaces;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jorge.munoz.reto_2.Repositories.Entities.OrderProductEntity;
import jorge.munoz.reto_2.Repositories.Entities.ProductEntity;

public interface OrderProductsRepository 
    extends JpaRepository<OrderProductEntity, Long> {

        @Query(value = "SELECT SUM(p.price*op.qty) FROM Productsreto p JOIN Orderproducts op ON op.idProduct = p.id where op.idOrder =:idOrder")
        Collection<Long> countTotalPrice(@Param("idOrder")Long idOrder);

        @Query(value = "SELECT p.name, op.qty, p.price FROM Productsreto p JOIN Orderproducts op ON op.idProduct = p.id WHERE op.idOrder =:idOrder")
        Collection<Object[]> getCartData(@Param("idOrder")Long idOrder);

        @Query(value = "SELECT p FROM Productsreto p JOIN Orderproducts op ON op.idProduct = p.id WHERE op.idOrder = :id")
        Collection<ProductEntity> findByOrderId(@Param("id")Long id);

}
