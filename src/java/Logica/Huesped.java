
package Logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Huesped extends Persona implements Serializable{
    
   
    String profesion;
    @OneToMany
    List <Reserva> listaReservas; 
    @OneToMany
    List <Pago> listaPagos;
    
    public Huesped() {
    }

    public Huesped(String profesion, List<Reserva> listaReservas, List<Pago> listaPagos) {
        this.profesion = profesion;
        this.listaReservas = listaReservas;
        this.listaPagos = listaPagos;
    }

    public Huesped(String profesion, List<Reserva> listaReservas, List<Pago> listaPagos, String dni, String apellido, String nombre, Date fecha_nac, String dirección, String eMail) {
        super(dni, apellido, nombre, fecha_nac, dirección, eMail);
        this.profesion = profesion;
        this.listaReservas = listaReservas;
        this.listaPagos = listaPagos;
    }


    


    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    @Override
    public String getDni() {
        return dni;
    }

    @Override
    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public Date getFecha_nac() {
        return fecha_nac;
    }

    @Override
    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    @Override
    public String getDirección() {
        return dirección;
    }

    @Override
    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    @Override
    public String geteMail() {
        return eMail;
    }

    @Override
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public List<Pago> getListaPagos() {
        return listaPagos;
    }

    public void setListaPagos(List<Pago> listaPagos) {
        this.listaPagos = listaPagos;
    }
    
    
    
}
