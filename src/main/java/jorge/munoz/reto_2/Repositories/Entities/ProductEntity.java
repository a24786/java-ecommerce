package jorge.munoz.reto_2.Repositories.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Products")
@Entity(name="Products")
public class ProductEntity {
    
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String name;
    private double price;
    private String url_product;

    public ProductEntity(){}
    

    public ProductEntity( String name, double price, String url_product) {
        this.name = name;
        this.price = price;
        this.url_product = url_product;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrl_product() {
        return this.url_product;
    }

    public void setUrl_product(String url_product) {
        this.url_product = url_product;
    }


}
