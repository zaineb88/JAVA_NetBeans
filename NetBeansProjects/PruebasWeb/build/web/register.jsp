<%-- 
    Document   : register
    Created on : 18-abr-2017, 19:58:13
    Author     : profesoraula
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Registro de usuario</h3>
        <form action="login?action=register" method="POST">
            <label>ID:</label>
            <input type="text" name="id"><br><br>
            <label>PW:</label>
            <input type="password" name="pw"><br><br>
            <input type="submit">
        </form>
    </body>
</html>
