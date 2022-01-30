<%-- 
    Document   : ListaReservas
    Created on : 08/01/2022, 12:51:08
    Author     : germa
--%>

<%@page import="Logica.Usuario"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Logica.Reserva"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
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
       
 
       
    <script type ="text/javascript">
     function confirmDelete2()
       {
           var respuesta = confirm("¿Está seguro de eliminar reserva?");
           if (respuesta === true)
            {
                return true;
            }
            else
            {
                return false;
            }
       }
    
    </script>
    
           
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
    
                    <h1 class="title">Reservas</h1>
                    <br>
                    <div class="vertical-menu">
                    <table  style="margin: 0 auto;">
                        <thead>
                            <tr>
                                <th>id</th>
                                <th>Habitación</th>
                                <th>Monto</th>
                                <th>Check-in</th>
                                <th>Check-out</th>
                                <th>Huesped</th>
                                <th>Cargada por</th>
                                <th>Eliminar</th>

                            </tr>  
                        </thead>    
                        <tbody>
                            <% 
                            Controladora control = new Controladora();
                            List<Reserva> listaReservas = control.traerReservas();


                            if (listaReservas != null){
                            for(Reserva r : listaReservas)
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
                                <th><%= (new SimpleDateFormat("dd-MM-yyyy").format(entrada))%></th>
                                <% Date salida = r.getSalida(); %>
                                <th><%= (new SimpleDateFormat("dd-MM-yyyy").format(salida)) %></th>
                                <% String huesp = r.getHuesped().getApellido() +", "+ r.getHuesped().getNombre(); %>
                                <th><%= huesp%></th>
                                <% String usu = r.getEmpleado().getApellido() +", "+ r.getEmpleado().getNombre(); %>
                                <th><%= usu%></th>



                               <!-- <th>Eliminar</th> -->
                                  <th >
                                   <form name="frmBorrarHab" action="SvEliminarRes" method="post" style="display:inline">
                                     <input type="hidden" name="id" value="<%=id%>">
                                     <button type="submit" class="btn2" data-title="Delete" style="display:inline" onclick="return confirmDelete2()">Eliminar</button>
                                          </form> 
                                     </th>      



                            </tr> 
                            <%}}%>



                        </tbody>   

                    </table>    
                   </div>
                    
                      <br>

                    <form action = "ReservasPorEmpl" method="post">
                      
                           <input class="input--style-1" type="text" placeholder="RESERVAS POR USUARIO" name="usuario" id="input">

                      <button type="submit" class="btn btn-primary" data-title="resUs" style="display:inline" id="input">Consultar</button>
                             
                    </form> 





                    <form action = "ReservasPorHuesp" method="post">
                        <div class="input-group">
                           <input class="input--style-1" type="text" placeholder="RESERVAS POR HUESPED" name="huesped" id="input">
                           <button type="submit" class="btn btn-primary" data-title="resUs" style="display:inline" id="input">Consultar</button>
                        </div>         
                    </form>                 
        
                    
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
