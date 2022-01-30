<%@page import="Logica.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.Exception"%>
<%@page import="Logica.Controladora"%>
<%@page import= "java.util.Vector"%>
<%@page import="Logica.Habitacion"%>
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
    
                    <h1 class="title">Habitaciones disponibles</h1>
                    <br>
                    <div class="vertical-menu">
                    <table  style="margin: 0 auto;">        
                        <table>
                            <thead>
                                <tr>
                                    <th>id</th>
                                    <th>tipo</th>
                                    <th>piso</th>
                                    <th>nombre</th>
                                    <th>precio</th>
                                    <th>entrada</th>
                                    <th>salida</th>
                                    <th>Seleccionar</th>

                                </tr>  
                            </thead>    
                            <tbody>
                                <% 

                        List<Habitacion> habitaciones = (List<Habitacion>)request.getAttribute("listaHabitaciones");

                                if (habitaciones != null){
                                for(Habitacion hab : habitaciones)
                                {
                                %>
                                <tr>
                                    <% int id = hab.getId_habitacion() ;%>
                                    <th><%= id %></th>
                                    <% String tipo = hab.getTipo(); %>
                                    <th><%= tipo %></th>
                                    <% String piso = hab.getPiso(); %>
                                    <th><%= piso %></th>
                                    <% String nombre = hab.getNombreHab(); %>
                                    <th><%= nombre%></th>                    
                                    <% double precio = hab.getPrecio(); %>
                                    <th><%= precio%></th>

                                    <% String entrada = (String)request.getAttribute("entrada"); %>
                                    <th><%= entrada%></th>
                                    <% String salida = (String)request.getAttribute("salida"); %>
                                    <th><%= salida%></th>                  

                                    <th >
                                       <form name="frmSeleccionarHab" action="DatosHuespedReserva.jsp" method="post" style="display:inline">
                                         <input type="hidden" name="id" value="<%=id%>">
                                         <input type="hidden" name="entrada" value="<%=entrada%>">
                                         <input type="hidden" name="salida" value="<%=salida%>">
                                         <button type="submit"  data-title="Seleccionar" style="display:inline">Seleccionar</button>
                                       </form> 
                                    </th>  



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
