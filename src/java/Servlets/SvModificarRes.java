/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
import Logica.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author germa
 */
@WebServlet(name = "SvModificarRes", urlPatterns = {"/SvModificarRes"})
public class SvModificarRes extends HttpServlet {

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
             //traigo ID
        int id = Integer.parseInt(request.getParameter("id"));
        String hab = request.getParameter("tipo");
        Double precio = Double.parseDouble (request.getParameter("precio"));
        String entr = request.getParameter("entrada");
        String sal = request.getParameter ("salida");
        String huesped = request.getParameter ("huesp");
        String usuario = request.getParameter ("usu");
        
        
        Controladora control = new Controladora();
        
        Reserva res = control.buscarReservas(id);
    
        
        control.modificarReserva(res);        
        
        request.getSession().setAttribute("listaCorta", control.traerReservas());
        
        response.sendRedirect("ListaReservas.jsp");
           
        
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
        Reserva res = control.buscarReservas(id);
        HttpSession misession = request.getSession();
        misession.setAttribute("res", res);
        response.sendRedirect("modificarReserva.jsp");
            

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
