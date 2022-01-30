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
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "SvModificar", urlPatterns = {"/SvModificar"})
public class SvModificar extends HttpServlet {
    
  
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


    
    @Override
      protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //traigo ID
        int id = Integer.parseInt(request.getParameter("id"));
        String piso = request.getParameter("piso");
        String nombre = request.getParameter("nombre");
        String tipo = request.getParameter("tipo");
        Double precio = Double.parseDouble(request.getParameter("precio"));
        
        Controladora control = new Controladora();
        
        Habitacion hab = control.buscarHabitaciones(id);
        hab.setPiso(piso);
        hab.setNombreHab(nombre);
        hab.setTipo(tipo);
        hab.setPrecio(precio);
        
        control.modificarHabitacion(hab);
       // control.traerHabitacionesDobles();
       /* List <Habitacion> listaCorta = new ArrayList<Habitacion>();
                
        for(Habitacion habb: control.traerHabitaciones())
         {
          if (habb.getId_habitacion() == 551  )
            {
            listaCorta.add(habb);
            }
         } */
                
        //actuaizo la lista de habitaciones
       // request.getSession().setAttribute("listaHabitaciones", control.traerHabitaciones());
        //request.getSession().setAttribute("listaCorta", listaCorta);
        request.getSession().setAttribute("listaCorta", control.traerHabitaciones());
        
        response.sendRedirect("HabitacionesListado.jsp");
        
        
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
        
        int id= Integer.parseInt(request.getParameter("id"));
        
        Controladora control = new Controladora();
        Habitacion hab = control.buscarHabitaciones(id);
        HttpSession misession = request.getSession();
        misession.setAttribute("hab", hab);
        response.sendRedirect("modificarHabitacion.jsp");
        
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

    private Controladora newControladora() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
