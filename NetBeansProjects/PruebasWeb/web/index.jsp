<%-- 
    Document   : index
    Created on : 18-abr-2017, 16:08:22
    Author     : profesoraula
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    // Si el user está logueado, lo mandamos a su página de usuario.
   Cookie[]cookies = request.getCookies();
   if(cookies != null){
       for(Cookie c : cookies){
           if(c.getName().equals("user")){
                request.getSession().setAttribute("loggedAs", c.getValue());
                RequestDispatcher dispatcher = 
                getServletContext().getRequestDispatcher("/userpage.jsp");
                dispatcher.forward(request,response);
                response.setContentType("text/html;charset=UTF-8");
           }
       }
   } 
    %>


<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Mi página</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="inner">
                <div  class="formulario">
                    <%  
                        // Tratamiento de errores que recibimos a través de
                        // parámetros GET
                        String err = request.getParameter("err");
                        String msg = request.getParameter("msg");
                        
                        if(err != null){ 
                           if(err.equals("missingdata")){
                               err = "Faltan datos";
                           }else if(err.equals("invaliddata")){
                               err = "Datos incorrectos";
                           }else if(err.equals("notlogged")){
                               err = "No estás logueado";
                           }
                    %>
                         <p style="color:red"> ERROR: <%=err%></p>
                   <% // ... así como de otros mensajes.
                        } else if(msg != null){
                          if(msg.equals("registered")){
                              msg = "Registration succesful!";
                          }else if(msg.equals("loggedof")){
                              msg = "Te has deslogueado correctamente";
                          }
                   %>
                         <p style="color:green"><%=msg%></p>
                    <% } %>
                    
                    <!-- Formulario para loguearse y enviar info al servlet !-->
                    <fieldset>
                        <legend>Login:</legend>
                        
                        <form action="login" method="POST">
                            <label>ID:</label>
                            <input type="text" name="id"><br><br>
                            <label>PW:</label>
                            <input type="password" name="pw"><br><br>
                            <input type="checkbox" name="recordar"> Recuérdame <br><br>
                            <input hidden name="action" value="log"> 
                            <button>Enviar!</button>
                        </form>
                    </fieldset>
                    <a href="register.jsp">
                    <button class="register-btn">Registrarse</button>
                    </a>
                </div>
            </div>
        </div>
    </body>
</html>