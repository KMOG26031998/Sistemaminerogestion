
<%@page import="BD.conexion"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SISTEMA DE GESTION DE PERSONAL - EMPRESA MINERA </title>
    </head>
    <body>
        <%
            HttpSession s = request.getSession();
            //variables de session
        %>
        <label id="usuario" style="display:none;"><%= s.getAttribute("personal_user11")%> </label> 
        <label id="nombre"></label>
        
        <%
            conexion con;
            File reporfile = new File(application.getRealPath("Reportes"));
        %>
        
        
    </body>
</html>