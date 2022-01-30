/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Reserva;
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author germa
 */
@WebServlet(name = "ReservasPorEmpl", urlPatterns = {"/ReservasPorEmpl"})
public class ReservasPorEmpl extends HttpServlet {

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
  /*  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    } /*

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
        
        String usuario = request.getParameter("usuario");
        
                Controladora control = new Controladora();
                List<Usuario> usuarios = control.traerUsuarios();
                Empleado empl = new Empleado();
                String emplId = new String();
                
                
                if (usuarios != null)
                 {
                 for(Usuario us: usuarios)
                   {
                   if (us.getUsuario().equals(usuario))
                     {
                      emplId = us.getEmple().getDni();
                     }
                   }
                 }
                    
                List<Reserva> listaReservas = control.traerReservas();
                List<Reserva> EmplReservas = new ArrayList<Reserva>();
   
                if (listaReservas != null)
                {
                   for(Reserva r : listaReservas)
                   {
                       if(emplId.equals (r.getEmpleado().getDni()))
                       {
                       EmplReservas.add(r);
                       }     
                   }
                }
                
                request.setAttribute("reser", EmplReservas);
               // response.sendRedirect("resPorEmpl.jsp");
                request.getRequestDispatcher("resPorEmpl.jsp").forward(request, response);
                response.sendRedirect("resPorEmpl.jsp");
                
        
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
