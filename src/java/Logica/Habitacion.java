
package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Habitacion implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)      
    int id_habitacion;
    String piso;
    String nombreHab;
    String tipo;
    Double precio;
    @OneToMany //(fetch = FetchType.LAZY, mappedBy = "otherEntity")
    List <Reserva> listaReservas;

    public Habitacion() {
    }

    public Habitacion(int id_habitacion, String piso, String tipo, Double precio, List<Reserva> listaReservas) {
        this.id_habitacion = id_habitacion;
        this.piso = piso;
        this.tipo = tipo;
        this.precio = precio;
        this.listaReservas = listaReservas;
    }



    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getNombreHab() {
        return nombreHab;
    }

    public void setNombreHab(String nombreHab) {
        this.nombreHab = nombreHab;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }
    
    public List<Date> obtenerEntrada(List<Reserva> listaReservas)
    {
       List <Date> listaEntradas = new ArrayList<>();
        for(Reserva reserv: listaReservas)
                {
              reserv.getEntrada();
              listaEntradas.add(reserv.getEntrada());
                }
         return listaEntradas; 
    }   
    
      public List<Date> obtenerSalida(List<Reserva> listaReservas)
    {
       List <Date> listaSalidas = new ArrayList<>();
        for(Reserva reserv: listaReservas)
                {
              reserv.getEntrada();
              listaSalidas.add(reserv.getEntrada());
            
                }
         return listaSalidas; 
    }  
      
      
      

}
