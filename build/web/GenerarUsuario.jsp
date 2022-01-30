
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
        
        
        
        
        
         <div id="principal"  > 
            <div class="hijo" id="hijo">
                      
           <img src="images/bg-head.jpg" alt="Head">  
           <br>    
        
	<h3 class="text-center mb-0">Generar Usuario</h3>
        <form action="SvGenerarUsuario"  method="POST">
        
            <p>Datos Usuario</p>
               <input type="text" name="EmplDni" placeholder="DNI" required id="input"> 
              
               <input type="text" name="EmplApellido" placeholder="Apellido" required id="input"> 
               
               <input type="text" name="EmplNombre" placeholder="Nombre" required id="input"> 
               <br>
               <!--div  class="input-group"--> <!--lo de la izq lo saqué de prueba-->
               <input class="input--style-1 js-datepicker" type="text" placeholder="Nacimiento   dd/mm//aaaa" name="EmplNac" id="input">
               <!--<i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i> --> <!--lo de la izq lo saqué de prueba-->
           
                      <!-- </div> -->
                
               <input type="text" name="EmplDirecc" placeholder="Dirección" required id="input"> 
                
               <input type="text" name="EmplMail" placeholder="E-Mail" required id="input">  
                        <div class="input-group">
                                <select name="EmplCargo" id="input">
                                    <option disabled="disabled" selected="selected">Cargo en el Hotel</option>
                                    <option>Recepcionista</option>
                                    <option>Gerente área</option>                                
                                </select>
                                <div class="select-dropdown"></div>
                        </div>
                <br>
        
            <p class="text-center">Por favor, digite su nombre y su contraseña</p>
               <input type="text" name="user" placeholder="Usuario" required id="input"> 
                <br>
               <input type="text" name="pass" placeholder="Contraseña" required id="input"> 
                <br>
               <button type="submit" class="btn form-control btn-primary rounded submit px-3" id="input">Envío</button>
        </form>
                     
                    <br>
                    <br>
                    <br>
                    <br>
                    <img src="images/logoYnombre5.jpg" alt="Logo">
              </div>
            </div>
    </body>
</html>
