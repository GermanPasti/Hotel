package Logica;

import Persistencia.ControladoraPersistencia;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Controladora {
    
    ControladoraPersistencia controlPersist = new ControladoraPersistencia();
   

 /*
   *********************************
              Habitación
   *********************************    
*/

    public void crearHabitacion(String piso, String nombreHab, String tipo, String precio) {
    
       Habitacion hab = new Habitacion();
       hab.setPiso(piso);
       hab.setNombreHab(nombreHab);
       hab.setTipo(tipo);
       double precioo = Double.valueOf(precio);
       hab.setPrecio(precioo);
       hab.setListaReservas(null);
       
       //llamamos a la ControladoraPersistencia
       controlPersist.crearHabitacion(hab);
         
    }

    
    
       
    public List<Habitacion> traerHabitaciones(){    
        return controlPersist.traerHabitaciones();
    }
    
    
    public void modificarHabitacion(Habitacion habitacion)
       {
       controlPersist.modificarHabitacion(habitacion);
       }    
    
       
    public void borrarHabitacion(int id) {
        controlPersist.borrarHabitacion(id);     
    }
    

    public Habitacion buscarHabitaciones(int id) 
     
       {
       return controlPersist.buscarHabitacion(id);
       
       }
    
    
        
      public List haDisponibilidad (String tipo, String llegada, String ida){
               
        Date entrada = new Date(llegada);
        Date salida = new Date (ida);  
          
        List<Reserva> listaReservas = controlPersist.traerReservas();  
        List<Habitacion> listaHab = controlPersist.traerHabitaciones(); 
        List<Habitacion> listaTipoHab= new ArrayList<Habitacion>(); 
        List<Habitacion> listaOcupadas= new ArrayList<Habitacion>(); 
        List<Habitacion> listaFinal=  new ArrayList<Habitacion>(); 
        
        for(Habitacion hab: listaHab)
            {
             if(hab.getTipo().equals(tipo))
              {
                listaTipoHab.add(hab);
              } 
            }  
        
        
        if(listaReservas.isEmpty())
        {
         for(Habitacion hab: listaTipoHab)
            {
              listaFinal.add(hab);  
            } 
          return  listaFinal;
          } 
        
        else {  
         for(Reserva res: listaReservas)
                    {    
                     if  (  !(   (  salida.before(res.getEntrada() ) )   ||
                             (entrada.after(res.getSalida()) ) )   )    
                      {
                      listaOcupadas.add(res.getHabitacion());
                      }
                    } 
            
        
         
            if(listaOcupadas.isEmpty()  || listaOcupadas==null)
            {
             for(Habitacion hb: listaTipoHab)
                {
                  listaFinal.add(hb);  
                } 
              return  listaFinal;
             } 
            
            else{
               for(Habitacion h: listaTipoHab)
                       {
                       
                        for(Habitacion o: listaOcupadas)
                          {
                             if(!((h.getId_habitacion()) == (o.getId_habitacion())))
                                   {
                                    listaFinal.add(h);   
                                   } 
                          } 
                       } 
                return listaFinal;
                 }
              }    
      }
    
 
      
    
 /*
   *********************************
               Usuario
   *********************************    
*/
      
    public void crearUsuario(String usuario, String contra, Empleado emple) {
        
        Usuario usu = new Usuario();
        usu.setUsuario(usuario);
        usu.setPassword(contra);
        usu.setEmple(emple);
        
        controlPersist.crearUsuario(usu);
        
    }
        
    
    
    public List<Usuario> traerUsuarios(){
        
        return controlPersist.traerUsuarios();
    }    
    
    
    
  
    public boolean verificarUsuario(String usuario, String contra) {
       
        List <Usuario> listaUsuarios = controlPersist.traerUsuarios();
        
        if(listaUsuarios != null)
        {
        
          for(Usuario usu: listaUsuarios)
          {
          if(usu.getUsuario().equals(usuario) && usu.getPassword().equals(contra))
             {
             return true;
             }
          
          }
        }
       return false;         
    }



 /*
   *********************************
               Pago
   *********************************    
*/   
    
    public void crearPago(String cuota, String pago, boolean clubB)
       {
       Pago pag =  new Pago();  
       int cCuota = Integer.valueOf(cuota);
       pag.setCuotas(cCuota);
       pag.setTipo(pago);
       pag.setClub(clubB);
       
       controlPersist.crearPago(pag);
       }
    
    
/*
   *********************************
               Reserva
   *********************************    
*/   
    
    public void crearReserva(String entrada, String salida, String fechaYa, double precioT, Habitacion habitac, Huesped hue, Empleado emple)
       {
         
           
        Reserva reser = new Reserva();
         Date entr = new Date(entrada);
         Date sal = new Date(salida);
         Date fechaCarga = new Date(fechaYa);

         reser.setEntrada(entr);
         reser.setSalida(sal);
         reser.setFechaCarga(fechaCarga);
         reser.setPrecioTotal(precioT);
         reser.setHabitacion(habitac);
         reser.setEmpleado(emple);
         reser.setHuesped(hue);
         reser.setEmpleado(emple);
         reser.setHabitacion(habitac);
         controlPersist.crearReserva(reser);
       }
    

    public List<Reserva> traerReservas()
      {
      return controlPersist.traerReservas();
      }
     
    
    
    
    
   public void borrarReserva(int id) {
         controlPersist.borrarReserva (id);
    }
   
   
    public void modificarReserva(Reserva res) {
      controlPersist.modificarReserva(res);  
    }        
    
  

    public Reserva buscarReservas(int id) {
        return controlPersist.buscarReservas (id);
    }
    
    
    
/*
   *********************************
               Huesped
   *********************************    
*/     
    
    
    public void crearHuesped(String dni, String apellido, String nombre, String nacimiento, String direccion, String mail, String profesion)
      {
      Huesped hu = new Huesped();
      hu.setDni(dni);
      hu.setApellido(apellido);
      hu.setNombre(nombre);
      Date nac = new Date(nacimiento);
      hu.setFecha_nac(nac);
      hu.setDirección(direccion);
      hu.seteMail(mail);
      hu.setProfesion(profesion);
      //hu.setListaReservas(null);
      //hu.setListaPagos(null);
         
      controlPersist.crearHuesped(hu);
      }
    
    
    public Huesped buscarHuesped (String dni)
      {
      return controlPersist.buscarHuesped(dni);
      }



    public List<Huesped> traerHuespedes() {
       return controlPersist.traerHuespedes();       
    }



    
/*
   *********************************
               Empleado
   *********************************    
*/     
       
    
    
    public void crearEmpleado(String dni, String apellido, String nombre, String fecha_nac, String direccion, String eMail, String cargo) {
      
        Empleado emple = new Empleado();
        
        emple.setDni(dni);
        emple.setApellido(apellido);
        emple.setNombre(nombre);
        Date fecha = new Date(fecha_nac);
        emple.setFecha_nac(fecha);
        emple.setDirección(direccion);
        emple.seteMail(eMail);
        emple.setCargo(cargo);
        emple.setListaReservas(null);
        
        controlPersist.crearEmpleado(emple);
        
    }



    
    public List<Empleado> traerEmpleados() {
       return controlPersist.traerEmpleados();
    }
    

      
               

/* ************************************** */


     
      
      
      
 
   
            public List habDisponibl (String tipo){
          
        List<Habitacion> listaHabitaciones = controlPersist.traerHabitaciones();  
        List<Habitacion> listaTipoHab = new ArrayList<Habitacion>();        
        if(listaHabitaciones!=null)
        {
                  for(Habitacion hab: listaHabitaciones)
                    {
                      if (hab.getTipo().equals(tipo))        
                      {
                      listaTipoHab.add(hab);
                      }
                    }
     
          }
      return listaTipoHab;
      
      }
       
      
            
   
            public List habFecha (String tipo){
          
        List<Habitacion> listaHabitaciones = controlPersist.traerHabitaciones();  
        List<Habitacion> listaTipoHab = new ArrayList<Habitacion>();   
        List<Habitacion> listaTipoFecha = new ArrayList<Habitacion>();  
        if(listaHabitaciones!=null)
        {
                  for(Habitacion hab: listaHabitaciones)
                    {
                      if (hab.getTipo().equals(tipo))        
                      {
                      listaTipoHab.add(hab);
                      }
                    }
                  
                  for(Habitacion habb:  listaTipoHab)
                    {
                    if(habb.getListaReservas()==null)
                       {
                        listaTipoFecha.add(habb);
                       }
                    }
                    return listaTipoHab;
     
          }
      return listaTipoHab;
      
      }  
  
      
      
      
    
  public List habPorFecha (String llegada, String ida)
  {
  Date entrada = new Date(llegada);
  Date salida = new Date(ida);
  
  List<Habitacion> listaHabitaciones = controlPersist.traerHabitaciones();
  List<Habitacion> listaPorFecha = new ArrayList<Habitacion>();
  
     
      
   return listaHabitaciones;
  }
 
     


    
}
