package jorge.munoz.reto_2.Repositories.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Orderproducts")
@Entity(name="Orderproducts")
public class OrderProductEntity {
    
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private Long idProduct;
    private Double qty;
    private Long idOrder;

    public OrderProductEntity(){}

    public OrderProductEntity(Long idProduct, Double qty, Long idOrder) {
        this.idProduct = idProduct;
        this.qty = qty;
        this.idOrder = idOrder;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getIdProduct() {
        return this.idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Double getQty() {
        return this.qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Long getIdOrder() {
        return this.idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    
}
