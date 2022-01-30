
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author german
 */
@WebServlet(name = "SvConfirmar", urlPatterns = {"/SvConfirmar"})
public class SvConfirmar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    } */

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        Controladora control = new Controladora();
        
        String idH = request.getParameter("idd");
        int idHab = Integer.valueOf(idH);
        String fechaYa = request.getParameter("fecha");
        String dni = request.getParameter("hDni");       
        String apellido = request.getParameter("hApellido");
        String nombre = request.getParameter("hNombre");  
        String nacimiento = request.getParameter("hNac");
        String direccion = request.getParameter("hdirecc");
        String mail = request.getParameter ("hMail");
        String profesion = request.getParameter("hProf");
        String clubB = request.getParameter ("club");
        //Boolean clubB = Boolean.valueOf(request.getParameter("club"));
        String pago = request.getParameter("tipoPago");
        String cuota = request.getParameter("cuotas");
        String entrada = request.getParameter("entrr");
        String salida = request.getParameter("sall");
        String totall = request.getParameter("total");
        Double tot;
         tot = Double.valueOf(totall);
        /*try{
            tot = Double.valueOf(totall);
           } catch (Exception ex){
             tot=1.0;}  */
               
        Boolean pertenece = false;
        if (clubB.equals("sí"))
          {
          pertenece = true;
          }
        

        
        Habitacion habitac = control.buscarHabitaciones(idHab); 
        

        Double precioT= 0.0;
        
        
        switch (cuota)
          {
            case "1":
                precioT = tot;
                break;
            case "2":
                precioT = tot * (1.1);
                break;               
            case "6":
                precioT = tot * (1.3);
                break;     
            case "12":
                precioT = tot * (1.6);
                break;                     
          }
        
        if (pertenece == true)
          {
           precioT = precioT * (0.9);
          }
        
        
        HttpSession misession = request.getSession();
        Usuario usu = (Usuario) misession.getAttribute("usuarioO") ;
        
        
        control.crearPago(cuota, pago, pertenece);
        
        control.crearHuesped(dni, apellido, nombre, nacimiento, direccion, mail, profesion);
        Huesped h = control.buscarHuesped(dni);
        
       // SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
       // String fechaEntr = formatter.format(entrada);
       
        //OJO, SÓLO DE PUEBA
       // String entradax = "09/09/2021";
       // String salidax = "11/09/2021";
        String fechaYax = "11/11/2021";
        //                     |         |         |
        //                     V         V         V
        control.crearReserva(entrada, salida, fechaYax, precioT, habitac, h,usu.getEmple());
        
         response.sendRedirect("index.jsp");  
    }
    
     

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
