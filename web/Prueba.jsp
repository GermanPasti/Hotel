<%@page import="Logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%  %>
        <%
          //BORRAR ESTA PÁGINA
 //Usuario us = session.getAttribute(usuarioO);
 Usuario us = (Usuario) session.getAttribute("usuarioO") ;
 %>
 <h1> Hola <%= us.getUsuario() %> bienvenido al sistema!</h1>
 <%= us.getPassword() %>
        
    </body>
</html>
