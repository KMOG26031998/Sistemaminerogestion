<%@page import="java.sql.*"%>
<%@page import="BD.conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>     
        <link href="css/listarpostulante.css" rel="stylesheet" type="text/css"/>
        
        <title>SISTEMA DE GESTION DE PERSONAL - EMPRESA MINERA</title>
    </head>
    <body >      
        <%
            //CONECTANOD A LA BASE DE DATOS:
            conexion c = new conexion();
            PreparedStatement ps;
            //Emnpezamos Listando los Datos de la Tabla Usuario
            Statement smt;
            ResultSet rs;
            smt = c.getConecction().createStatement();
            rs = smt.executeQuery("select idpersonalcontratado as codigo, postulante_dni as cedula, fechaingreso as fecha, motivoingreso as motivo from personalcontratado where cargararchivocv is null and personal_user = '" + session.getAttribute("personal_user11") + "'");
            //Creamo la Tabla:     
        %>
       
        <header id="header" style=" background: #007653 !important;">
         
                <a class="logo" href="Principal.jsp">
                    
                </a>
                <a class="logo" id="ulUserData" href="index.html"></a>
              <nav class="nav-tp"> </nav>
        </header>

        <div class="div-head-tittle"><h2></h2></div>
        <form id="form1" >
        <section class="sec-main">
        <div class="container">               
            <!--<a  class="btn btn-success" href="Agregar.jsp">Nuevo Registro</a> Esto es Cuando se Crea un nuevo Archivo Agregar.jsp -->         
            <table class="table table-bordered"  id="tablaDatos"  style='width: 100%; text-align: center; margin-left: 20px; margin-top: 30px'>
                <thead>
                    <tr>
                        <th class="text-center">CODIGO</th>
                        <th>CEDULA DEL POSTULANTE</th>
                        <th class="text-center">FECHA DE ANTICIPO</th>
                        <th class="text-center">MOTIVO DE ANTICIPO</th>
                        <th class="text-center">ACCION</th>
                    </tr>
                </thead>
                <tbody id="tbodys">
                    <%
                        while (rs.next()) {
                    %>
                    <tr>
                        <td class="text-center"><%= rs.getInt("codigo")%></td>
                        <td><%= rs.getString("cedula")%></td>
                        <td class="text-center"><%= rs.getString("fecha")%></td>
                        <td class="text-center"><%= rs.getString("motivo")%></td>
                        <td class="text-center">
                            <a href="SubirCurriculum.jsp?codigo=<%= rs.getInt("codigo")%>" class="btn btn-primary">Seleccionar Postulante</a>
                        </td>
                    </tr>
                    <%}%>
            </table>
        </div>        
</section>
            
    </div>     
    </form>  
    <script src="js/jquery.js" type="text/javascript"></script>             
    <script src="js/bootstrap.min.js" type="text/javascript"></script>        
</body>
</html>
