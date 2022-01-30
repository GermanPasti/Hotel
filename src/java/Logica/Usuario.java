
package Logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)           
    int id_usuario;
    String usuario;
    String password;
    @OneToOne
    Empleado emple;

    public Usuario() {
    }

    public Usuario(int id_usuario, String usuario,String password, Empleado emple) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.password = password;
        this.emple = emple;
        
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }



    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Empleado getEmple() {
        return emple;
    }

    public void setEmple(Empleado emple) {
        this.emple = emple;
    }
    
    
    
}
