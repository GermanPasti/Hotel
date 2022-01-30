
<%@page import="Logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css">
                
    </head>
    <body>
        
      <%
     HttpSession misession = request.getSession();
     Usuario usu = (Usuario) misession.getAttribute("usuarioO") ;
    
       if(usu.getUsuario() == null){
         response.sendRedirect("Login.jsp");
          }
       else{
        %>          
        
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
                    <h1 class="title">Bienvenidos-Welcome </h1>
                    <br>
                    
                     <p>En la barra lateral  podrá encontrar las diferentes 
                         opciones del menú para gestionar</p> <p>reservas y habitaciones. / 
                     In the sidebar you can find the different menu options 
                     to manage reservations and rooms.</p> 
                     
                     <br>
                    <img src="images/interior.jpg">                     
                    
                    <br>
                    <img src="images/logoYnombre5.jpg" alt="Logo">
                      
                  </div>
                </div>

  
       <% } %> 
    </body>
    
    <div id="log" >
       <ul>
        <br>
        <%
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
