package jorge.munoz.reto_2.Repositories.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "Orderproducts")
@Entity(name="Orderproducts")
public class OrderProductEntity {
    
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @ManyToOne
    @JoinColumn(name = "Ordersreto_id")
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "Productsreto_id")
    private ProductEntity productEntity;

    //private Long idProduct;
    private int qty;
    //private Long idOrder;

    public OrderProductEntity(){}

    // public OrderProductEntity(Long idProduct, int qty, Long idOrder) {
    //     this.idProduct = idProduct;
    //     this.qty = qty;
    //     this.idOrder = idOrder;
    // }


    public OrderProductEntity(OrderEntity orderEntity, ProductEntity productEntity, int qty) {
        this.orderEntity = orderEntity;
        this.productEntity = productEntity;
        this.qty = qty;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    // public Long getIdProduct() {
    //     return this.idProduct;
    // }


    public OrderEntity getOrderEntity() {
        return this.orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public ProductEntity getProductEntity() {
        return this.productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }


    // public void setIdProduct(Long idProduct) {
    //     this.idProduct = idProduct;
    // }

    public int getQty() {
        return this.qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    // public Long getIdOrder() {
    //     return this.idOrder;
    // }

    // public void setIdOrder(Long idOrder) {
    //     this.idOrder = idOrder;
    // }

    
}
