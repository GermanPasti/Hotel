package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id_reserva;
    @Temporal(TemporalType.DATE)
    Date entrada;
    @Temporal(TemporalType.DATE)
    Date salida;
    @Temporal(TemporalType.DATE)
    Date fechaCarga;
    Double precioTotal;
    @ManyToOne
    Habitacion habitacion;
    @ManyToOne
    Huesped huesped;
    @ManyToOne
    Empleado empleado;
     
    public Reserva() {
    }

    public Reserva(int id_reserva, Date entrada, Date salida, Date fechaCarga, Double precioTotal, Habitacion habitacion, Huesped huesped, Empleado empleado) {
        this.id_reserva = id_reserva;
        this.entrada = entrada;
        this.salida = salida;
        this.fechaCarga = fechaCarga;
        this.precioTotal = precioTotal;
        this.habitacion = habitacion;
        this.huesped = huesped;
        this.empleado = empleado;
    }


    
    

    
    
    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }



    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    
    
}