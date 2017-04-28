<%-- 
    Document   : userpage
    Created on : 18-abr-2017, 16:15:57
    Author     : profesoraula
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Entities.Persona"%>
<%@page import="DBUtils.PersonasDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // Esta página es privada, por tanto, echaremos al usuario fuera si
    // intenta acceder sin loguearse primero.
    Object logged = request.getSession().getAttribute("loggedAs");
    if (logged != null) {
        // Tratamiento de paginación
        String paginaS = request.getParameter("page");
        int pagina = 0;
        if(paginaS != null){
            pagina = Integer.valueOf(paginaS);
        }
        
        // Extraemos datos de la BD para representarlos, pasándole la
        // página de datos que queremos recibir
        PersonasDAO dao = new PersonasDAO();
        ArrayList<Persona> lista = dao.readAll(pagina);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Te has loggeado correctamente</h3>
        <a href="login?action=logoff">Salir de la cuenta </a>
        
        <% if(lista != null){ // Comprobamos que la lista no sea nula%>
        
        <!-- Representamos la lista en la tabla !-->
        <table border style="margin-left:20px;">
            <tr>
                <th>
                    ID
                </th>
                <th>
                    Nombre
                </th>
                <th>
                    DNI
                </th>
                <th>
                    EDAD
                </th>
            </tr>
            <% // Replicaremos esta fila tantas veces como objetos recibamos
            for (Persona p : lista) {  %>
            <tr>
                <td>
                    <%=p.getId()%>
                </td>
                <td>
                    <%=p.getNombre()%>
                </td>
                <td>
                    <%=p.getDni()%>
                </td>
                <td>
                    <%=p.getEdad()%>
                </td>
            </tr>
            <% } %>
        </table>
        <% // Aquí podremos subir o bajar la página a recibir.
            if(pagina != 0){ %>
          <a href="userpage.jsp?page=<%=pagina-1%>" 
            <button> Elementos anteriores </button>
          </a>    
        <% } if(lista.size() == 10){   %>
          <a href="userpage.jsp?page=<%=pagina+1%>" 
            <button> Elementos siguientes </button>
          </a>  
       <% } 
        }else{
       %>
       <h3>No data found</h3>
       <% } %>
          
        
    </body>
</html>
<%
    } else { // ... si no está logueado, de vuelta a index.jsp
        RequestDispatcher dispatcher
                = getServletContext()
                .getRequestDispatcher("/index.jsp?err=notlogged");
        dispatcher.forward(request, response);
    }
%>