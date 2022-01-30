
<%@page import="Logica.Usuario"%>
<%@page import="Logica.Habitacion"%>
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
                    <h1>Modificar habitación</h1>
                    <br>
        
                    <form action = "SvModificar" method="get">
                        <% HttpSession misession = request.getSession();
                        Habitacion hab = (Habitacion) misession.getAttribute("hab"); %>
                        
                        <!-- guardamos strings-->
                        
                       
                            <input class="input--style-1" type="text" name="id" placeholder="PISO" name="piso" id="input" value="<%=hab.getPiso()%>">
                             <br>                  
                        
                            <input class="input--style-1" type="text" name="id" placeholder="NOMBRE HABITACION" name="nombre" id="input" value="<%=hab.getNombreHab()%>">
                        


                       
                            <div class="rs-select2 js-select-simple select--no-search">
                                <select name="tipo" id="input">
                                    <option disabled="disabled" selected="selected">TIPO</option>
                                    <option>single</option>
                                    <option>doble</option>
                                    <option>triple</option>
                                    <option>multiple</option>                                    
                                </select>
                                <div class="select-dropdown"></div>
                            </div>
                           
                        
                        
                        
                            <input class="input--style-1" type="text" name="id" placeholder="PRECIO" name="precio" id="input" value="<%=hab.getPrecio()%>">
                        
                     
                        <input type="hidden" name="id" value="<%=hab.getId_habitacion()%>">
                
                       
                        <div class="p-t-20">
                            <button class="btn btn--radius btn--green" type="submit" id="input" >Enviar</button>
                        </div>
                        
                        
                    <br> 
                    <br>
                    <br>
                    <br>
                    <br>            
                    <br>
                    <br>
                    <img src="images/logoYnombre5.jpg" alt="Logo">
                    </form>        
        </div>
       </div>
    </body>
    
    <div id="log" >
       <ul>
        
    <div id="log" >
       <ul>
        <br>
        <%
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
    </div>
</html>