package jorge.munoz.reto_2.Repositories.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import jorge.munoz.reto_2.Repositories.Entities.OrderProductEntity;

public interface OrderProductsRepository 
    extends JpaRepository<OrderProductEntity, Long> {

        // @Query(value = "SELECT m FROM Movies m WHERE m.title LIKE :title%")
        // Collection<ProductEntity> findMovieByTitle(@Param("title")String movieTitle);

        // @Query(value = "SELECT m FROM Movies m WHERE m.year = :year")
        // Collection<ProductEntity> findMovieByYear(@Param("year")int year);

        // @Query(value = "SELECT m FROM Movies m WHERE ((m.title LIKE :title%) AND (m.year = :year))")
        // Collection<ProductEntity> findMovieByTitleAndYear(@Param("title")String title, @Param("year")int year );

}
