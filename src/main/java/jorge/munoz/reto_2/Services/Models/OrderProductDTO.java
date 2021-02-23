package jorge.munoz.reto_2.Services.Models;

public class OrderProductDTO {
    private Long id;
    // private Long idProduct;
    // private Long idOrder;
    private OrderDTO orderDTO;
    private ProductDTO productDTO;
    private int qty;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    // public Long getIdProduct() {
    //     return this.idProduct;
    // }

    // public void setIdProduct(Long idProduct) {
    //     this.idProduct = idProduct;
    // }


    // public Double getQty() {
    //     return this.qty;
    // }

    // public void setQty(Double qty) {
    //     this.qty = qty;
    // }


    // public Long getIdOrder() {
    //     return this.idOrder;
    // }

    // public void setIdOrder(Long idOrder) {
    //     this.idOrder = idOrder;
    // }

    public OrderDTO getOrderDTO() {
        return this.orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

    public ProductDTO getProductDTO() {
        return this.productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public int getQty() {
        return this.qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    

}