
<%@page import="Logica.Usuario"%>
<%@page import="java.lang.Exception"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logica.Habitacion"%>
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
        
    </head>
    
    <script type ="text/javascript">
     function confirmDelete()
       {
           var respuesta = confirm("¿Está seguro de eliminar habitación?");
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
    
    <body>
        <h1>Habitaciones</h1>
        <br>
          <div class="vertical-menu">
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>tipo</th>
                    <th>precio</th>
                    <th>Eliminar</th>
                    <th>Modificar</th>
                </tr>  
            </thead>    
            <tbody>
                <% 
                Controladora control = new Controladora();
                List<Habitacion> listaHabitaciones = control.traerHabitaciones();
               
   
                if (listaHabitaciones != null){
                for(Habitacion hab : listaHabitaciones)
                {
                %>
                <tr>
                    <% int id = hab.getId_habitacion() ;%>
                    <th><%= id %></th>
                    <% String tipo = hab.getTipo(); %>
                    <th><%= tipo %></th>
                    <% double precio = hab.getPrecio(); %>
                    <th><%= precio%></th>
                   
                    
                   <!-- <th>Eliminar</th> -->
                      <th >
                       <form name="frmBorrarHab" action="SvEliminar" method="post" style="display:inline">
                         <input type="hidden" name="id" value="<%=id%>">
                         <button type="submit" class="btn2" data-title="Delete" style="display:inline" onclick="return confirmDelete()" >Eliminar</button>
                       </form> 
                         </th>      
                              
                    <th>         
                       <form name="frmModificarHab" action="SvModificar" method="post" style="display:inline">
                      <input type="hidden" name="id" value="<%=id%>">
                        <button type="submit" class="btn2" data-title="Edit" style="display:inline">Modificar</button>
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
