

<%@page import="Logica.Usuario"%>
<%@page import="java.time.ZonedDateTime"%>
<%@page import="java.time.temporal.ChronoUnit"%>
<%@page import="java.util.Date"%>
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
 
               <script type="text/javascript">
               function Habilitar(value)
               {

                  
                  if(value==="1" || value===true)
                    {
                   //habilitamos
                    document.getElementById("cuotas").disabled=false;
                    }
                   else if (value==="2" || value===false)
                    {
                      document.getElementById("cuotas").disabled=true;
                    }
                } 
               </script>    
    
    
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
    
    
    <form action = "SvConfirmar" method="POST">
        
        <h1>Completar y confirmar</h1>
        <br>
            <div>
            <table  style="margin: 0 auto;">
            <thead>
                <tr>
                    <th>id</th>
                    <th>piso</th>
                    <th>tipo</th>
                    <th>nombre</th>                    
                    <th>entrada</th>
                    <th>salida</th>
                    <th>precio por noche</th>
                    <th>precio total</th>

                </tr>  
            </thead>    
           

            
            
            
                <% 
                Controladora control = new Controladora();
                Habitacion hab = control.buscarHabitaciones(Integer.parseInt (request.getParameter("id")));
                Date entrada = new Date(request.getParameter("entrada"));
                Date salida = new Date (request.getParameter("salida")); 
                %>
                <tr>
                    <% int id = hab.getId_habitacion() ;%>
                    <th><%= id %></th>
                    <% String piso = hab.getPiso() ;%>
                    <th><%= id %></th>                    
                    <% String tipo = hab.getTipo(); %>
                    <th><%= tipo %></th>
                    <% String nombre = hab.getNombreHab();%>
                    <th><%= nombre %></th>
                    <% String entr = request.getParameter("entrada");%>
                    <th><%= entr %></th>
                    <% String sal = request.getParameter("salida") ;%>
                    <th><%= sal %></th>
                    <% double precio = hab.getPrecio(); %>
                    <th><%= precio%></th>
                    <% long total = (long) precio *(((long)( salida.getTime() - entrada.getTime())/86400000 /30 ) ) ;%>
                    <th><%=total%></th>

                                 </tr>     
        </table>
        </div>            
        <br>          
                    
                        <!-- guardamos strings-->
                        
                            <input class="input--style-1" type="text" placeholder="DNI" name="hDni" id="input">
                       
                            
                            <input class="input--style-1" type="text" placeholder="APELLIDO" name="hApellido"id="input">
                       
                         
                            <input class="input--style-1" type="text" placeholder="NOMBRE" name="hApellido"id="input">
                                               
                             <br>
                        <input class="input--style-1 js-datepicker" type="text" placeholder="NACIMIENTO" name="hNac"id="input">
                         <i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>                        
                                            
                        
                            <input class="input--style-1" type="text" placeholder="DIRECCIÓN" name="hDirecc"id="input">

                            
                            <input class="input--style-1" type="text" placeholder="E-MAIL" name="hMail"id="input">

                            
                            <input class="input--style-1" type="text" placeholder="PROFESIÓN" name="hProf"id="input">
                              

                        
                    <p>¿Es socio del Club Ciervo Blanco?</P>
                     <div class="input-group">
                            <div class="rs-select2 js-select-simple select--no-search">
                                <select name="club">
                                    <option>no</option>
                                    <option>sí</option>
                                </select>
                                <div class="select-dropdown"></div>
                            </div>
                        </div>
                    <p>Tipo de pago</p>
                        <div class="input-group"  onKeyUp="Habilitar">
                               <div class="rs-select2 js-select-simple select--no-search">
                                   <select name="tipoPago" id="tipoPago" onchange="Habilitar(this.value);">
                                       <option value="1">crédito</option>
                                       <option value="2">débito</option>
                                   </select>
                                   <div class="select-dropdown"></div>
                               </div>
                           </div>    
                    
                    <p>Cuotas</p>
                         <div class="input-group">
                               <div class="rs-select2 js-select-simple select--no-search">
                                   <select name="cuotas" id="cuotas">
                                       <option>1</option>
                                       <option>2</option>
                                       <option>6</option>
                                       <option>12</option>
                                   </select>
                                   <div class="select-dropdown"></div>
                               </div>
                           </div>                     
                             
                      
                        
                
                        <div class="p-t-20">
                            <input type="hidden" name="idd" value="<%=request.getParameter("id")%>">
                            <input type="hidden" name="entrr" value="<%= request.getParameter("entrada")%>">
                            <input type="hidden" name="sall" value="<%= request.getParameter("salida")%>">
                            <input type ="hidden" name="fecha" value <%=ZonedDateTime.now()%>>
                            <input type="hidden" name="total" value="<%=(long) precio *(((long)( salida.getTime() - entrada.getTime())/86400000 /30 ) )%>">
                            <button class="btn btn--radius btn--green" type="submit">Confirmar</button>
                        </div>  
                            
                                                       
                    
    </form> 
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
