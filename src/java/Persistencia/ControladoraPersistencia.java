
package Persistencia;

import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Pago;
import Logica.Reserva;
import Logica.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

 


public class ControladoraPersistencia {
    
    EmpleadoJpaController empleJPA = new EmpleadoJpaController();
    HabitacionJpaController habitJPA = new HabitacionJpaController();
    HuespedJpaController HuespJPA = new HuespedJpaController();
    PagoJpaController pagoJPA = new PagoJpaController();
    ReservaJpaController reseJPA = new ReservaJpaController();
    UsuarioJpaController usJPA = new UsuarioJpaController();

    public void crearReserva(Reserva reser) {
        try {
            reseJPA.create(reser);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearHabitacion(Habitacion hab) {
        try {
            habitJPA.create(hab);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void crearUsuario(Usuario usu) {
     
        try {
            usJPA.create(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
    public void crearEmpleado(Empleado emple) {
   
        try {
            empleJPA.create(emple);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void crearPago (Pago pag){
       pagoJPA.create(pag);
    }
    
    public void crearHuesped(Huesped hu) {
        try {
            HuespJPA.create(hu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public List<Habitacion> traerHabitaciones() {

        return habitJPA.findHabitacionEntities();
    }

    public List<Usuario> traerUsuarios() {
        return usJPA.findUsuarioEntities();
    }
    
    public List<Reserva> traerReservas(){
        return reseJPA.findReservaEntities();
    }


    
    
    public void borrarReserva(int id) {
        
        try {
            reseJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    public void borrarHabitacion(int id) {
        
        try {
            habitJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    

    public Habitacion buscarHabitacion(int id) {

        return habitJPA.findHabitacion(id);
        
    }

    public void modificarHabitacion(Habitacion habitacion) {
        try {
            habitJPA.edit(habitacion);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Empleado> traerEmpleados() {
           return empleJPA.findEmpleadoEntities();
    }

    public Huesped buscarHuesped(String dni) {
      return HuespJPA.findHuesped(dni);
    }

    public Reserva buscarReservas(int id) {
      return reseJPA.findReserva(id);
    }

    public void modificarReserva(Reserva res) {
        try {
            reseJPA.edit(res);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Huesped> traerHuespedes() {
        return HuespJPA.findHuespedEntities();
    }


    
}
