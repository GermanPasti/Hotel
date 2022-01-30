<%-- 
    Document   : resPorEmpl
    Created on : 09/01/2022, 12:37:26
    Author     : germa
--%>

<%@page import="Logica.Usuario"%>
<%@page import="java.util.Date"%>
<%@page import="Logica.Reserva"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css">
    </head>

    
           <body>

       <style> body {  background-image: url("images/hotel.jpg");
               background-size: 100% 100%;
    background-attachment: fixed;} </style>    
           
<!---------sidebar--------------->


  <div id="sidebar" >
    <div class="toggle-btn">       
      <span>&#9776;</span>  
    </div>
      <ul>
         <li>
           <img src="images/logo.jpg" alt="Logotipo">
         </li> 
         <li><a href="index.jsp" class="href">Home</a></li>
         <li><a href="HabitacionesGestion.jsp" class="href">Crear y editar habitaciones</a></li>
         <li><a href="ReservasGestion.jsp" class="href">Crear y editar reservas</a></li>
         <li><a href="ListaReservas.jsp" class="href">Ver reservas</a></li>
         <li><a href="HabitacionesListado.jsp" class="href">Ver habitaciones</a></li>
      </ul>
   </div>
  
    <!puse el scrpt acá porque no me lo tomaba desde la carpeta js>    
    
       <script>
           const btnToggle = document.querySelector('.toggle-btn');

btnToggle.addEventListener('click', function(){
 document.getElementById('sidebar').classList.toggle('active');
});

       </script>    
       
     <!Acá está el llamado fallido>  
       <script scr="js/main.js" charset="utf 8"></script>           
 
     
       
 <!--------sidebar-end-------------->   
 

                <div id="principal"  > 
                  <div class="hijo" id="hijo">
                      
                    <img src="images/bg-head.jpg" alt="Head">  
                    <br>    
        
    
                    <h1>Reservas por Empleado</h1>
                    <br>
                    <div class="vertical-menu">
                    <table>
                        <thead>
                            <tr>
                                <th>id</th>
                                <th>Habitación</th>
                                <th>Monto</th>
                                <th>Check-in</th>
                                <th>Check-out</th>
                                <th>Huesped</th>
                                <th>Cargada por</th>


                            </tr>  
                        </thead>    
                        <tbody>
                            <% 

                            List<Reserva> reserv = (List<Reserva>)request.getAttribute("reser");    


                            if (reserv != null){
                            for(Reserva r : reserv)
                            {
                            %>
                            <tr>
                                <% int id = r.getId_reserva() ;%>
                                <th><%= id %></th>
                                <% String tipo = r.getHabitacion().getNombreHab(); %>
                                <th><%= tipo %></th>
                                <% double precio = r.getPrecioTotal(); %>
                                <th><%= precio%></th>
                                <% Date entrada = r.getEntrada(); %>
                                <th><%=entrada%></th>
                                <% Date salida = r.getSalida(); %>
                                <th><%= salida %></th>
                                <% String huesp = r.getHuesped().getApellido() +", "+ r.getHuesped().getNombre(); %>
                                <th><%= huesp%></th>
                                <% String usu = r.getEmpleado().getApellido() +", "+ r.getEmpleado().getNombre(); %>
                                <th><%= usu%></th>







                            </tr> 
                            <%}}%>



                        </tbody>   

                    </table>    
                   </div>

                                                
                    <br>
                    <br>
                    <br>            
                    <br>
                    <br>
                    <img src="images/logoYnombre5.jpg" alt="Logo">
                            
          </div>
         </div>                   
        
    </body>   
    
    <div id="log" >
       <ul>
        <br>
        <%
        HttpSession misession = request.getSession();
        Usuario usu = (Usuario) misession.getAttribute("usuarioO") ;
        String u = usu.getUsuario();
        %>
        <form action = "SvLogout" method="post">
           <div id="logDiv">
            <li><p><%= u%></p></li>
           </div> 
         <li><button type="submit" class="btn2">Cerrar sesión</button></li> 
        </form>
       </ul> 
    </div>   
    
</html>
