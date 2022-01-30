
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
                <h2 class="heading-section">Login</h2>
                <h3>Bienvenido/Welcome</h3>
                <p class="text-center">Por favor, complete sus datos</p>
                <form action="SvUsuario" class="login-form" method="POST">

                   <input type="text" name="user" placeholder="Usuario" required id="input">
                   <br>
                   <input type="password" name="pass" placeholder="Contraseña" required id="input">
                   <br>
                   <br>
                   <button type="submit" class="btn form-control btn-primary rounded submit px-3" id="input">Envío</button>     

                </form>   
                    <br>                
                                <p class="mb-0">¿No tiene cuenta?</p>
                                  <a href="GenerarUsuario.jsp">Regístrese</a>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <img src="images/logoYnombre5.jpg" alt="Logo">
           </div>
          </div>   
    </body>	          
    
</html>
