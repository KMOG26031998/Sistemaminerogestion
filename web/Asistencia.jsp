<%@page import="java.sql.*"%>
<%@page import="BD.conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link href="css/Asistencia_1.css" rel="stylesheet" type="text/css"/> 
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>SISTEMA DE GESTION DE PERSONAL - EMPRESA MINERA</title>
    </head>
    <body> 
        <header>
            <nav class="nav-tp"></nav>
        </header>      
        <div class="div-head-tittle"><h2></h2></div>
        <form class="form1" action="./Addasistencia" method="GET" enctype="multipart/form-data">
            <section class="sec-main">
                <div class="div-cont-main">

                    <table style='width: 100%; text-align: center; margin-left: 20px; margin-top: 30px'>
                        <thead >
                            <tr>
                                <th>Numero de identificacion</th> 
                                <th>Nombres del Personal</th> 
                                <th>Nombres del Administrador</th>  
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td> <div class="div-cont-name"><input type="text"onkeypress='return validaNumericos(event)' value="${usuario.postulante_dni}" id="txt-ced" class="inp-ced" placeholder="Numero de identificacion" name="Identificacion" onkeypress='return validaNumericosA(event)' maxlength="15"/> 
                                        <br>
                                        <input style='margin-left: 30px; ' type="button"  id="btn-buscarpostulante" class="btn-accept" value="Buscar"></div></td>
                                <td><div class="div-cont-name"><input type="text" disabled="true" value="${usuario.postulante_primernombre} ${usuario.postulante_primerapellido}" id="txt-namep"onkeypress="return soloLetras(event)" class="inp-ced" placeholder="Nombres del Personal" name="nombres personal" onkeypress="return soloLetras(event)"/></div></td>
                                <td><div class="div-cont-name"><input type="text" id="txt-nameme" class="inp-name" value="${userLogin}" placeholder="Nombres del Administrador" name="nombres administrador" onkeypress="return soloLetras(event)"disabled="true"/></div></td>

                        <input hidden value="${Asistencia.personal_id}" type="text" id="txt-personal-id" class="inp-name"  name="personal_id"/>
                        <input hidden value="${Asistencia.postulante_id}" type="text" id="txt-postulante-id" class="inp-name"  name="postulante_id"/>
                        <input hidden value="${modificar}" type="text" id="txt-modificar"  name="modificar"/>

                        </tr>
                        </tbody>
                        <thead >
                            <tr>                          
                                <th>Fecha de Asistencia</th>
                                <th>Actividad/Observacion</th>
                            </tr> 
                        </thead>
                        <tbody>
                            <tr>
                                <td><div class="div-cont-lname"><input type="date" value="${Asistencia.fecha}" id="txt-lname" class="inp-lname" placeholder="Fecha de Asistencia"required=""  name="fecha"/></div></td> 
                                <td><div class="div-cont-name"><input type="text" value="${Asistencia.actividadobservacion}" onkeyup="mayus(this);" id="txt-namei" class="inp-name" placeholder="Actividad/Observacion" name="actividadobservacion"/></div></td>
                                <td><div style='margin-top: -20px !important;'class="div-cont-lname">

                                        <input type="submit" id="btn-actiong" class="btn-accept" value="Guardar"/>
                                        <!--<input type="submit"  id="btn-addasistencia" class="btn-accept" value="GUARDAR"></div></td> -->
                            </tr>
                        </tbody>                        
                    </table> 

                    <div style="width: 70%; height: auto; margin-left: auto; margin-right: auto" >
                        <div >
                            <table id="tabla_asistencia" class="table table-bordered">
                                <thead> 
                                    <!--     <td>Nª</td>
                                        <td>Fecha de Asistencia</td>
                                        <td>Actividad / Observacion</td>
                                        <td>Acciones</td> -->
                                </thead> 
                                <tbody id="body_asistencias" align="center">

                                </tbody>
                            </table> 
                        </div>
                    </div>
                </div> 
            </section> 
        </form>
        <script>
            function mayus(e) {
                e.value = e.value.toUpperCase();
            }
            function validaNumericos(event) {
                if (event.charCode >= 48 && event.charCode <= 57) {
                    return true;
                }
                if (event.charCode == 13) {
                    console.log("unio");
                    buscador1();
                }
                return false;
            }
            function soloLetras(e) {
                key = e.keyCode || e.which;
                tecla = String.fromCharCode(key).toLowerCase();
                letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
                especiales = [8, 37, 39, 46];

                tecla_especial = false
                for (var i in especiales) {
                    if (key == especiales[i]) {
                        tecla_especial = true;
                        break;
                    }
                }

                if (letras.indexOf(tecla) == -1 && !tecla_especial)
                    return false;
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
    </body>
    <footer></footer>
    <script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>   
    <!--<script src="js/Asistencia.js" type="text/javascript"></script>-->
    <script src="js/Buscadorpostulante.js" type="text/javascript"></script>
    <script src="js/newjavascript.js" type="text/javascript"></script>    
</html>
