<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="Controller.LoginController"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "Model.Constructor"%> 
<%@ page import = "DAO.LoginDAO"%> 
<%@ page import = "java.util.LinkedList"%>
<%@ page import = "BD.conexion"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
        <link href="css/ActualizarDatos.css" rel="stylesheet" type="text/css"/> 
        <title>SISTEMA DE GESTION DE PERSONAL - EMPRESA MINERA </title>
    </head>
    <body> 
        <header id="header" style=" background: #007653 !important;">
            <a class="logo" href="Principal.jsp">

            </a>
            <a class="logo" id="ulUserData" href="index.html"></a> 
        </header>  

        <%
            HttpSession s = request.getSession();
            PreparedStatement pst;
            conexion cn = new conexion();
            ResultSet rs;
            PreparedStatement ps;
            String sql;
            sql = "select * from personal where personal_user='" + session.getAttribute("personal_user11") + "'";
            pst = cn.getConecction().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
        %>         

        <div class="div-head-tittle"><h2></h2></div>
        <form id="form1" autocomplete="off">
            <section class="sec-main">
                <div class="div-cont-main">
                    <table style='width: 100%; text-align: center; margin-left: 20px; margin-top: 25px;'>
                        <thead >
                            <tr>
                                <th>Numero de identificacion</th>
                                <th>Primer Nombre</th>
                                <th>Segundo Nombre</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><div class="div-cont-name"><input class="inp-lname" type="text" name="cedula" id="Cedula" value="<%= rs.getInt("personal_dni")%>" disabled="true"></div> </td>
                                <td><div class="div-cont-name"><input class="inp-lname" type="text" name="PrimerNombre" id="PrimerNombre"value="<%= rs.getString("personal_primer_nombre")%>" required="" onkeypress="return soloLetras(event)"onkeyup="mayus(this);"></div></td>
                                <td><div class="div-cont-name"> <input class="inp-lname" type="text" name="SegundoNombre" id="SegundoNombre"value="<%= rs.getString("personal_segundo_nombre")%>"required="" onkeypress="return soloLetras(event)" onkeyup="mayus(this);"></div></td> 
                            </tr> 
                        </tbody>
                        <thead >
                            <tr>
                                <th>Primer Apellido</th>
                                <th>Segundo Apellido</th>
                                <th>Telefono o Celular</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><div class="div-cont-name"><input class="inp-lname" type="text" name="PrimerApellido" id="personal_telefono"value="<%= rs.getString("personal_apellido_paterno")%>" onkeypress="return soloLetras(event)"onkeyup="mayus(this);"required="" ></div></td>
                                <td><div class="div-cont-name"><input class="inp-lname" type="text" name="SegundoApellido" id="personal_provincia"value="<%= rs.getString("personal_apellido_materno")%>"required="" onkeypress="return soloLetras(event)"onkeyup="mayus(this);"></div></td>
                                <td><div class="div-cont-name"><input class="inp-lname" type="text" name="personal_telefono" id="personal_telefono"value="<%= rs.getString("personal_telefono")%>"required="" onkeypress='return validaNumericos(event)'></div></td>
                            </tr> 
                        </tbody>
                        <thead >
                            <tr>
                                <th>Provincia</th>
                                <th>Canton</th>
                                <th>Parroquia</th>

                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><div class="div-cont-name"><input class="inp-lname" type="text" name="personal_provincia" id="personal_provincia"value="<%= rs.getString("personal_provincia")%>"required="" onkeypress="return soloLetras(event)"onkeyup="mayus(this);"></div></td>
                                <td><div class="div-cont-name"><input class="inp-lname" type="text" name="personal_canton" id="personal_canton" value="<%= rs.getString("personal_canton")%>"required="" onkeypress="return soloLetras(event)"onkeyup="mayus(this);"></div></td> 
                                <td><div class="div-cont-name"><input class="inp-lname" type="text" name="personal_parroquia" id="personal_parroquia"value="<%= rs.getString("personal_parroquia")%>"required="" onkeypress="return soloLetras(event)"onkeyup="mayus(this);"></div></td>
                            </tr> 
                        </tbody>
                        <thead >
                            <tr>
                                <th>Direccion</th>
                                <th>Correo Electronico</th> 
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><div class="div-cont-name"><input class="inp-lname" type="text" name="personal_direccion" id="personal_direccion"value="<%= rs.getString("personal_direccion")%>"required=""></div></td>
                                <td><div class="div-cont-name"><input class="inp-lname" type="text" name="personal_correoelectronico" id="personalcorreoelectronico"value="<%= rs.getString("personal_correoelectronico")%>"required=""></div></td>
                                <td><div class="div-cont-name" style='margin-top: -20px !important;'>
                                        <input type="submit" id="btn-action" class="btn-accept" value="Guardar"/>
                                    </div> </td>
                            </tr>  
                        </tbody>                     
                    </table>
                </div>
            </section>
            <script>
                function validaNumericos(event) {
                    if (event.charCode >= 48 && event.charCode <= 57) {
                        return true;
                    }
                    return false;
                }
                function soloLetras(e) {
                    key = e.keyCode || e.which;
                    tecla = String.fromCharCode(key).toLowerCase();
                    letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
                    especiales = [8, 37, 39, 46];

                    tecla_especial = false;
                    for (var i in especiales) {
                        if (key === especiales[i]) {
                            tecla_especial = true;
                            break;
                        }
                    }

                    if (letras.indexOf(tecla) == -1 && !tecla_especial)
                        return false;
                }
                function mayus(e) {
                    e.value = e.value.toUpperCase();
                }
                function verificarCedula(cedula) {
                    if (typeof (cedula) == 'string' && cedula.length == 10 && /^\d+$/.test(cedula)) {
                        var digitos = cedula.split('').map(Number);
                        var codigo_provincia = digitos[0] * 10 + digitos[1];

                        //if (codigo_provincia >= 1 && (codigo_provincia <= 24 || codigo_provincia == 30) && digitos[2] < 6) {

                        if (codigo_provincia >= 1 && (codigo_provincia <= 24 || codigo_provincia == 30)) {
                            var digito_verificador = digitos.pop();

                            var digito_calculado = digitos.reduce(
                                    function (valorPrevio, valorActual, indice) {
                                        return valorPrevio - (valorActual * (2 - indice % 2)) % 9 - (valorActual == 9) * 9;
                                    }, 1000) % 10;
                            return digito_calculado === digito_verificador;
                        }
                    }
                    return false;
                }
            </script>
        </form>
        <%}%>
        <%
            String dni, Pnom, Snom, telefono, direccion, provincia, canton, parroquia, email, Papellido, Sapellido;
            dni = request.getParameter("Cedula");
            Pnom = request.getParameter("PrimerNombre");
            Snom = request.getParameter("SegundoNombre");
            telefono = request.getParameter("personal_telefono");
            direccion = request.getParameter("personal_direccion");
            provincia = request.getParameter("personal_provincia");
            canton = request.getParameter("personal_canton");
            parroquia = request.getParameter("personal_parroquia");
            email = request.getParameter("personal_correoelectronico");
            Papellido = request.getParameter("PrimerApellido");
            Sapellido = request.getParameter("SegundoApellido");
            if (Pnom != null && Snom != null && telefono != null && direccion != null && provincia != null && canton != null && parroquia != null && email != null && Papellido != null && Sapellido != null) {
                ps = cn.getConecction().prepareStatement("update personal set personal_primer_nombre='" + Pnom + "', personal_segundo_nombre='" + Snom + "', personal_telefono='" + telefono + "'"
                        + ",personal_direccion='" + direccion + "'"
                        + ",personal_provincia='" + provincia + "' "
                        + ",personal_canton='" + canton + "'"
                        + " ,personal_parroquia='" + parroquia + "'"
                        + ",personal_correoelectronico='" + email + "'"
                        + ",personal_apellido_paterno='" + Papellido + "'"
                        + ",personal_apellido_materno='" + Sapellido + "'"
                        + " where personal_user='" + session.getAttribute("personal_user11") + "'");
                ps.executeUpdate();
                //JOptionPane.showMessageDialog(null, "INFORMACION ACTUALIZADA CORECTAMENTE");
                response.sendRedirect("Principal.jsp");
            }
        %>
    </body>
</html>
