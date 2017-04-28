<%-- 
    Document   : tabla-productos
    Created on : 21-abr-2017, 18:49:50
    Author     : profesoraula
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Prenda"%>
<%@page import="DAO.PrendaDAO"%>
<%@page import="DB.Conector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    final String URL = "localhost";
    final String USER = "SYSTEM";
    final String PW = "root";
    final int PORT = 1521;
    final String SID = "orcl"; 
    Conector c = new Conector(USER, PW, URL, PORT, SID);
    PrendaDAO dao = new PrendaDAO(c);
    
    ArrayList<Prenda> lista = dao.readAll();
    %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/chat.js" type="text/javascript"></script>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div style="margin: 45px">
            <table border>
                <tr>          
                    <th>
                        NOMBRE
                    </th>
                    
                    <th>
                        GÉNERO
                    </th>
                    
                    <th>
                        PRECIO
                    </th>
                    
                    <th>
                        IMAGEN
                    </th>
                </tr>
                <%for(Prenda p : lista){ %>
                 <tr>
                    <td>
                       <%=p.getNombre()%>
                    </td>
                    
                    <td>
                       <%=p.getGeneroObjetivo()%>
                    </td>
                    
                    <td>
                       <%=p.getPrecio()%>
                    </td>
                    
                    <td >
                       <img style="max-height: 80px;max-width:80px" src="<%=p.getImagen()%>">
                    </td>
                </tr>
                
                <% } %>
            </table>
        </div>
        <div class="message">
            <label>Usuario:</label>
            <input type="text" id="user">
            <label>Mensaje:</label>
            <input type="text" id="message">
            <button onclick="sendMessage()">Send</button>
        </div>    
        <div class="chat" id="chat">
        </div>
    </body>
</html>
