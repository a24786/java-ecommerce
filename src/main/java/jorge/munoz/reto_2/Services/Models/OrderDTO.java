package jorge.munoz.reto_2.Services.Models;

public class OrderDTO {
    private Long id;
    private String fe_creacion;
    private String state;
    private String user_reto;


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
    

    public String getUser_reto() {
        return this.user_reto;
    }

    public void setUser_reto(String user_reto) {
        this.user_reto = user_reto;
    }
    
    
}