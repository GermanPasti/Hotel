
package Logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pago implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)       
    int id_pago;
    String tipo;
    int cuotas;
    Boolean club;

    public Pago() {
    }

    public Pago(int id_pago, String tipo, int cuotas, Boolean club) {
        this.id_pago = id_pago;
        this.tipo = tipo;
        this.cuotas = cuotas;
        this.club = club;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public Boolean getClub() {
        return club;
    }

    public void setClub(Boolean club) {
        this.club = club;
    }
    
    
    
}
