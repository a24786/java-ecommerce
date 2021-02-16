package jorge.munoz.reto_2.Repositories.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Orders")
@Entity(name="Orders")
public class OrderEntity {
    
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String fe_creacion;
    private String user;
    private String state;

    public OrderEntity(){}
    

    public OrderEntity(String fe_creacion, String user, String state) {
        this.fe_creacion = fe_creacion;
        this.user = user;
        this.state = state;
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

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String status) {
        this.state = status;
    }


}
