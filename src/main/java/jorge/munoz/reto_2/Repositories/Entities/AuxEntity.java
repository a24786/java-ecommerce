package jorge.munoz.reto_2.Repositories.Entities;

/**
 * Auxentiity
 */
public class AuxEntity {
 
    private String name;
    private int qty;
    private double price;

    public AuxEntity() {
    }

    public AuxEntity(String name, int qty, double price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return this.qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}