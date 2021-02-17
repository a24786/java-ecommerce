package jorge.munoz.reto_2.Repositories.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Ordersreto")
@Entity(name= "Ordersreto")
public class OrderEntity {
    
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String fe_creacion;
    private String state;
    private String user_reto;

    public OrderEntity(){}
    

    public OrderEntity(String fe_creacion, String state, String user_reto) {
        this.fe_creacion = fe_creacion;
        this.state = state;
        this.user_reto = user_reto;
    }
    

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFe_creacion() {
        return this.fe_creacion;
    }

    public void setFe_creacion(String fe_creacion) {
        this.fe_creacion = fe_creacion;
    }

    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getUser() {
        return this.user_reto;
    }

    public void setUser(String user_reto) {
        this.user_reto = user_reto;
    }

}
