package jorge.munoz.reto_2.Repositories.Interfaces;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jorge.munoz.reto_2.Repositories.Entities.OrderProductEntity;
import jorge.munoz.reto_2.Repositories.Entities.ProductEntity;

public interface OrderProductsRepository 
    extends JpaRepository<OrderProductEntity, Long> {

        // @Query(value = "SELECT m FROM Movies m WHERE m.title LIKE :title%")
        // Collection<ProductEntity> findMovieByTitle(@Param("title")String movieTitle);

        // @Query(value = "SELECT m FROM Movies m WHERE m.year = :year")
        // Collection<ProductEntity> findMovieByYear(@Param("year")int year);

        // @Query(value = "SELECT m FROM Movies m WHERE ((m.title LIKE :title%) AND (m.year = :year))")
        // Collection<ProductEntity> findMovieByTitleAndYear(@Param("title")String title, @Param("year")int year );

        @Query(value = "SELECT p FROM Products p JOIN OrderProducts op ON op.id_product = p.id WHERE op.id_order = :id")
        Collection<ProductEntity> findByOrderId(@Param("id")Long id);

}
