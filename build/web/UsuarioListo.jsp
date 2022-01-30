
<%@page import="Logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
         Usuario us = (Usuario) request.getAttribute("usuarioO") ;
         %>        
        <h1> Hola <%= us.getUsuario() %> bienvenido al sistema!</h1>
        <a href="Login.jsp">Listo</a>
    </body>
</html>
