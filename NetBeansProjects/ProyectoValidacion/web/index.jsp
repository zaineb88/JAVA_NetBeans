<%-- 
    Document   : index
    Created on : 21-abr-2017, 15:45:16
    Author     : profesoraula
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi tienda</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/main.js" type="text/javascript"></script>
    </head>
    <body>
        <a href="tabla-productos.jsp">
        <button>Acceder a lista productos y chat</button>
        </a>
        <h2 class="page-title">Formulario de registro de productos</h2>
        <div class="container">
            <div class="form-group">
                <% 
                String err = request.getParameter("err");
                
                if(err != null){ %>
                <p style="color:red;font-size:14px"><%=err%></p>
                <%  }  %>
                <form action="register" onsubmit="return validar()">
                    <label class="labelmargin">Nombre de la prenda</label>
                    <input onkeyup="checkValues('nombre')" id="nombre" name="nombre" type="text" class="form-control inputmargin">
                    <p class="error" id="nombre-error"></p>
                    <label class="labelmargin">Precio</label>
                    <input onkeyup="checkValues('precio')" id="precio" name="precio" type="text" class="form-control inputmargin">
                    <p class="error" id="precio-error"></p>
                    <label class="labelmargin">Género objetivo</label>
                    <select id="gender" class="form-control inputmargin" name="gender">
                        <option>Masculino</option>
                        <option>Femenino</option>
                        <option>Unisex</option>
                    </select>
                    <label class="labelmargin">Imagen</label>
                    <input onkeyup="checkValues('url')" id="url" type="text" name="url" class="form-control inputmargin">
                    <p class="error" id="url-error"></p>
                    <button class="form-control boton" id="boton">Registrar producto</button>
                </form>
            </div>
        </div>
    </body>
</html>
