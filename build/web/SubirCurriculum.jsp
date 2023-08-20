<%@page import="java.sql.*"%>
<%@page import="BD.conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
          <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>      
          <link href="css/subircurriculum.css" rel="stylesheet" type="text/css"/>
        <title>SISTEMA DE GESTION DE PERSONAL - EMPRESA MINERA</title>
    </head>
    <body>
        <header id="header" style=" background: #007653 !important;">

            <a class="logo" href="ListarPersonal.jsp">
            </a>
            <a class="logo" id="ulUserData" href="index.html"></a>
          
        </header>
        <%
            //CONECTANOD A LA BASE DE DATOS:
            conexion c = new conexion();
            PreparedStatement ps;
            ResultSet rs;
            int id = Integer.parseInt(request.getParameter("codigo"));
            ps = c.getConecction().prepareStatement("select idpersonalcontratado as codigo, postulante_dni as cedula, fechaingreso as fecha, motivoingreso as motivo from personalcontratado where cargararchivocv is null and idpersonalcontratado =" + id);
            rs = ps.executeQuery();
            while (rs.next()) {
        %>
                       
            <form id="form1" action="subirCurriculum" method="POST" enctype="multipart/form-data" >
                <%-- <input type="text"  readonly="" name="codigo" class="form-control" style="visibility:hidden;" value="<%= rs.getInt("codigo")%>"/>
                CEDULA DEL POSTULANTE
                <input type="text" name="txtNom" class="form-control" value="<%= rs.getString("cedula")%>"/><br>
                FECHA DE LA ANTICIPO
                <input type="text" name="txtDNI" class="form-control" value="<%= rs.getString("fecha")%>"/>
                <br>
                MOTIVO DEL ANTICIPO
                <input type="text" name="txtDNI" class="form-control" value="<%= rs.getString("motivo")%>"/>
                <br>
                CARGAR CURRICULUM
                <input type="file" name="cargarArchivos"/>
                <br>
                <input type="submit" value="Guardar" class="btn btn-primary btn-lg"/>--%>
                <section class="sec-main">
                <div class="div-cont-main">
                    <table style='width: 100%; text-align: center; margin-left: 20px; margin-top: 30px'>
                        <thead>
                            <tr>
                                <input type="text"  readonly="" name="codigo" class="form-control" style="visibility:hidden;" value="<%= rs.getInt("codigo")%>"/>
                                
                                <th>Cedula del Postulante</th> 
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td> <div class="div-cont-ced" style='margin-top: 10px !important;'><input value="<%= rs.getString("cedula")%>" type="text" id="txt-cedi" readonly="" class="inp-ced" name="txtNom" /></div> </td>
                            </tr>
                        </tbody>
                        <thead>
                            <tr>
                                <th> <div style='margin-top: 10px !important;'>Fecha del anticipo</div></th> 
                            </tr>
                        </thead>
                        <tbody>
                            <tr> 
                                <td><div class="div-cont-ced" style='margin-top: 10px !important;'><input value="<%= rs.getString("fecha")%>" type="text" id="txt-cedi" readonly="" class="inp-ced" name="txtDNI" /></div> </td>
                            </tr>
                        </tbody>
                        <thead>
                            <tr>
                                <th><div style='margin-top: 10px !important;'>Motivo del anticipo</div></th> 
                            </tr>
                        </thead>
                        <tbody>
                            <tr>  
                                <td> <div class="div-cont-ced" style='margin-top: 10px !important;'><input value="<%= rs.getString("motivo")%>" type="text" id="txt-cedi" readonly="" class="inp-ced" name="txtDNI" /></div> </td>
                            </tr>
                        </tbody>
                        <thead>
                            <tr>
                                <th><div style='margin-top: 10px !important;'>Subir curriculum</div></th> 
                            </tr>
                        </thead>
                        <tbody>
                            <tr> 
                                <td> <div class="div-cont-ced" style='margin-top: 10px !important;'><input  type="file" id="txt-cedi" class="inp-ced" name="cargarArchivos"/></div> </td>
                            </tr>
                        </tbody>
                        <thead>
                            <tr> 
                                <th><div style='margin-top: 10px !important;'> <input type="submit" value="Guardar" class="btn-accept" id="btn-actionr"/></div></th> 
                            </tr>
                        </thead>
                    </table>
 
                </div>
            </section> 
            </form>
            <%}%>
      
    </body>
</html>

