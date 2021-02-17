package jorge.munoz.reto_2.Services.Models;

public class OrderProductDTO {
    private Long id;
    private Long id_product;
    private Double qty;
    private Long id_order;

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


    public Double getQty() {
        return this.qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Long getId_order() {
        return this.id_order;
    }

    public void setId_order(Long id_order) {
        this.id_order = id_order;
    }

}