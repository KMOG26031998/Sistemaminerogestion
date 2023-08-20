<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="BD.conexion"%>
<%@page import="BD.conexion"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/clave.css" rel="stylesheet" type="text/css"/>  
        <%-- <link rel="stylesheet" href="Principal/css/main.css" />
       <link rel="stylesheet" href="css/CSS_Transferir.css">--%>
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
        <title>SISTEMA DE GESTION DE PERSONAL - EMPRESA MINERA </title>  
    </head>
    <body>
        <header id="header" style=" background: #007653 !important;">
            <a class="logo" href="index.jsp">
            </a> 
        </header>     
        <div class="div-head-tittle"><h2></h2></div>

        <form id="form1" autocomplete="off">
            <section class="sec-main">
                <div class="div-cont-main">
                    <div class="div-cont-ced">
                        <table style='width: 100%; text-align: center; margin-left: 20px; margin-top: 30px'>
                            <thead>
                                <tr>
                                    <th><div style='margin-top: 20px !important;'>Ingresar nueva contraseña:  </div></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td> <div class="div-cont-ced" style='margin-top: 10px !important;'><input type="password" id="txtPassword" class="inp-ced" placeholder="" name="txtPassword" required=""/></div> </td>
                                <td> <button id="show_password" style='margin-left: -200px; margin-top: 12px; align-items: center !important; background-color: #007653;'class="btn btn-primary" type="button" onclick="mostrarPassword()"> <span class="fa fa-eye-slash icon"></span> </button> </td>   
                                                                    </tr>
                            </tbody>

                            <thead>
                                <tr>
                                    <th><div style='margin-top: 20px !important;'>Ingresar el usuario:  </div></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td> <div class="div-cont-ced" style='margin-top: 10px !important;' ><input type="text" id="Usuario" class="inp-ced" name="Usuario" required=""/></div> </td>
                                </tr>
                            </tbody>
                            <thead>
                                <tr>
                                    <th><div style='margin-top: 20px !important;'>Ingresar su cedula: </div></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td> <div class="div-cont-ced"  style='margin-top: 10px !important;'><input type="text" id="cedula" class="inp-ced" name="cedula" required=""/></div> </td>
                                </tr>
                            </tbody>
                            <thead>
                                <tr>
                                    <th> </th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>

                                    <td><div style='margin-top: 20px !important;'class="div-cont-lname"><input type="submit" id="btn-actiong" class="btn-accept" value="Cambiar contraseña"/></div></td>

                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </section>

            <%-- <section  class="form-register">
                 INGRESAR NUEVA CLAVE: 
                 <input class="controls" type="password" name="txtPassword" id="txtPassword" required="">
                 <div class="input-group-append">
                     <button id="show_password" class="btn btn-primary" type="button" onclick="mostrarPassword()"> <span class="fa fa-eye-slash icon"></span> </button>
                 </div>
                 Ingrese su usuario:
                 <input class="controls" type="text" name="Usuario" id="Usuario" required="">
                 <br><br>
                 Ingrese su cedula:
                 <input class="controls" type="text" name="cedula" id="cedula" required="">
                 <br><br>
                 <input class="botons" type="submit" value="Cambiar clave">
             </section>--%>
        </form>
        <script type="text/javascript">
            function mostrarPassword() {
                var cambio = document.getElementById("txtPassword");
                if (cambio.type == "password") {
                    cambio.type = "text";
                    $('.icon').removeClass('fa fa-eye-slash').addClass('fa fa-eye');
                } else {
                    cambio.type = "password";
                    $('.icon').removeClass('fa fa-eye').addClass('fa fa-eye-slash');
                }
            }

            function valida(e) {
                e.preventDefault();
            }
            document.getElementById('form').addEventListener('submit', valida);
            $(document).ready(function () {
                //CheckBox mostrar contraseña
                $('#ShowPassword').click(function () {
                    $('#Password').attr('type', $(this).is(':checked') ? 'text' : 'password');
                });
            });
        </script>
        <%
            PreparedStatement pst;
            conexion cn = new conexion();
            ResultSet rs;
            PreparedStatement ps;
            String dni, Cedula, usuario;
            dni = request.getParameter("txtPassword");
            usuario = request.getParameter("Usuario");
            Cedula = request.getParameter("cedula");
            if (dni != null) {
                ps = cn.getConecction().prepareStatement("update usuario set usuario_pass=md5('" + dni + "') where usuario_user='" + usuario + "' and usuario_dni = '" + Cedula + "'");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "LA CONTRASEÑA HA SIDO MODIFICADA CORRECTAMENTE.....");
                response.sendRedirect("index.jsp");

            }
        %>
    </body>
</html>
