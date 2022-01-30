
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
import Logica.Habitacion;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "consultaDispo", urlPatterns = {"/consultaDispo"})
public class consultaDispo extends HttpServlet {

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

        String tipo = request.getParameter("tipo");
        String llegada = request.getParameter("entrada");
        String ida = request.getParameter("salida");
        
      
        try{
        
       // List<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();

        
        Controladora control = new Controladora();

             List<Habitacion> listaHabitaciones = control.haDisponibilidad(tipo, llegada, ida) ;
              Habitacion habitacion;
        if(listaHabitaciones != null)
           {
           request.setAttribute("listaHabitaciones", listaHabitaciones);
           request.setAttribute("entrada", llegada);
           request.setAttribute("salida", ida);
           request.getRequestDispatcher("/HabitacionesDisp.jsp").forward(request, response);
           }
        
        else
           {
           request.getRequestDispatcher("/index.jsp").forward(request, response);
           }
        } finally{
            out.close();}
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */

    
}
