/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "SvGenerarUsuario", urlPatterns = {"/SvGenerarUsuario"})
public class SvGenerarUsuario extends HttpServlet {

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
  /* 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
*/
    
    
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
        
        String usuario = request.getParameter("user");
        String contra = request.getParameter("pass");  

        String EDni = request.getParameter("EmplDni");
        String EApellido = request.getParameter("EmplApellido");  
        String ENombre = request.getParameter("EmplNombre");
        String ENac = request.getParameter("EmplNac");  
        String EDirecc = request.getParameter("EmplDirecc");
        String EMail = request.getParameter("EmplMail");  
        String ECargo = request.getParameter("EmplCargo");   
        
        Controladora control = new Controladora();
        control.crearEmpleado(EDni, EApellido, ENombre, ENac, EDirecc, EMail, ECargo);
       
        Empleado empleE = new Empleado();
        List<Empleado> emple = control.traerEmpleados();
        
        for(Empleado e : emple)
          {
          if(e.getDni() == EDni)
             {
                 empleE = e;
             }
          }
         control.crearUsuario(usuario, contra, empleE);
         
         //// nuevo
         Usuario usuU = new Usuario();
         List<Usuario> usu = control.traerUsuarios();
         for(Usuario u: usu)
           {
           if(u.getUsuario() == usuario)
             {
                usuU = u;
             }
           }
           
              request.setAttribute("apellido", EApellido);  
              request.setAttribute("cargo", ECargo);
              
           //   HttpSession session = request.getSession();
           //session.setAttribute("usuarioO", usuU);
             request.setAttribute("usuarioO", usuU);
              request.getRequestDispatcher("LoginB.jsp").forward(request, response); 
          
          
             
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
