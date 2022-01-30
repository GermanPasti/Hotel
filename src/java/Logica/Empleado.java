package Logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Empleado extends Persona implements Serializable {
   
    String cargo;

    @OneToMany
    List <Reserva> listaReservas; 
    
    public Empleado() {
    }

    public Empleado(String cargo, List<Reserva> listaReservas) {
        this.cargo = cargo;
    
        this.listaReservas = listaReservas;
    }

    public Empleado(String cargo, List<Reserva> listaReservas, String dni, String apellido, String nombre, Date fecha_nac, String dirección, String eMail) {
        super(dni, apellido, nombre, fecha_nac, dirección, eMail);
        this.cargo = cargo;
        this.listaReservas = listaReservas;
    }


 

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    

   
    
    
    
}