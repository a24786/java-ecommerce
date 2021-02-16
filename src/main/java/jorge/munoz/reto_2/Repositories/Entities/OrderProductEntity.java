package jorge.munoz.reto_2.Repositories.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "OrderProducts")
@Entity(name="OrderProducts")
public class OrderProductEntity {
    
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private Long id_product;
    private Long id_order;

    public OrderProductEntity(){}

    public OrderProductEntity(Long id_product, Long id_order) {
        this.id_product = id_product;
        this.id_order = id_order;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_product() {
        return this.id_product;
    }

    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }

    public Long getId_order() {
        return this.id_order;
    }

    public void setId_order(Long id_order) {
        this.id_order = id_order;
    }

    
}
