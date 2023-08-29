<%@page import="java.sql.ResultSet"%>
<%@page import="BD.conexion"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <link href="css/General.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <title>SISTEMA DE GESTION DE PERSONAL - EMPRESA MINERA</title>
        <script>
            $(document).ready(function () {
                $("#botonMostrarOcultar").click(function () {
                    $("#contenido").toggle();
                    if ($("#contenido").is(":visible")) {
                        $(this).text("Ver menos");
                    } else {
                        $(this).text("Ver mas...");
                    }
                });
                $("#txt-cedi").keypress(function (event) {
                    if (event.which === 13) { // Código de tecla para "Enter"
                        event.preventDefault(); // Evita el comportamiento por defecto de "Enter"
                        consultarData();
                    }
                });
            });
        </script>
        <%
            HttpSession s = request.getSession();
            //variables de session
            if (s.getAttribute("personal_user11") == null) {
                // Si no hay una sesión activa, redireccionar a una página de inicio de sesión
                response.sendRedirect("./");
            }
        %> 
    </head>
    <body>
        <header id="header" style=" background: #007653 !important;">
            <a class="logo" href="Principal.jsp">
                Logo
            </a>

            <nav class="nav-tp"></nav>
        </header>     
        <div class="div-head-tittle">
            <h2>
            </h2>
        </div>

        <form id="form1" method="POST" action="/Sistemaminerogestion/AddPersonalContratado" enctype="multipart/form-data">
            <section class="sec-main">
                <div class="div-cont-main">
                    <div class="row justify-content-center pt-3"> 
                        <h3> Ingrese Numero de C&eacute;dula Postulante</h3>
                    </div>


                    <table style='width: 100%; text-align: center; margin-top: 10px'>
                        <thead>
                            <tr>
                                <th>Numero de identificacion</th>
                                <th>Nombres</th>
                                <th>Apellidos</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td> <div class="div-cont-name"><input type="text" id="txt-cedi" class="inp-ced" placeholder="Numero de identificacion" name="cedula" onkeypress='return validaNumericos(event)' maxlength="10" required/></div> </td>
                                <td> <div class="div-cont-name"  ><input type="text" id="txt-namen" class="inp-name" placeholder="Nombres" name="Nombres"disabled="true" onkeyup="mayus(this);"/></div> </td>
                                <td> <div class="div-cont-lname"  ><input type="text" id="txt-lnamea" class="inp-lname" placeholder="Apellidos" name="Apellidos"disabled="true" onkeyup="mayus(this);"/></div> </td>
                            </tr>
                        </tbody>
                    </table>
                    <div id="contenido" style="display: none;">
                        <table style='width: 100%; text-align: center; margin-top: 30px'>
                            <thead>
                                <tr>
                                    <td>Discapacidad</td>
                                    <td>Telefono convencional</td>
                                    <td>Celular</td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td> <div class="div-cont-name"><input type="text" id="txt-discapacidad" class="inp-name" placeholder="Discapacidad" name="Discapacidad"disabled="true" disabled="true" /></div> </td>
                                    <td> <div class="div-cont-name"><input type="text" id="txt-telConvencional" class="inp-lname" placeholder="Telefono Convencional" name="convencional" disabled="true"/></div> </td>
                                    <td> <div class="div-cont-name"><input type="text" id="txt-celular" class="inp-edad" placeholder="Celular" name="Celular" disabled="true"/></div>  </td>
                                </tr>
                            </tbody>
                            <thead>
                                <tr>
                                    <td>Provincia</td>
                                    <td>Direccion</td>
                                    <td>Genero</td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>  <div class="div-cont-lname"><input type="text" id="txt-provincia" class="inp-lname" placeholder="Provincia" name="Provincia" onkeypress="return soloLetras(event)"disabled="true"/></div>  </td>
                                    <td> <div class="div-cont-lname"><input type="text" id="txt-direccion" class="inp-lname" placeholder="Direccion" name="Direccion"disabled="true"/></div> </td>
                                    <td> <div class="div-cont-lname"><input type="text" id="txt-genero" class="inp-lname" placeholder="Genero" name="Genero" onkeypress="return soloLetras(event)"disabled="true"/></div> </td>
                                </tr> 
                            </tbody>
                            <thead>
                                <tr>
                                    <th>Carnet de discapacidad</th>
                                    <th>Nacionalidad</th>
                                    <th>Correo Electronico</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr> 
                                    <td><div class="div-cont-lname"><input type="text" id="txt-carDiscapacidad" class="inp-lname" placeholder="Carnet de discapacidad" name="Carnet de discapacidad" disabled="true"/></div></td>
                                    <td><div class="div-cont-lname"><input type="text" id="txt-nacionalidad" class="inp-lname" placeholder="Nacionalidad" name="Nacionalidad" "disabled="true"/></div></td>
                                    <td><div class="div-cont-lname"><input type="text" id="txt-correoElectronico" class="inp-lname" placeholder="Correo Electronico" name="Correo Electronico" disabled="true"/></div></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                    <div class="row justify-content-center">
                        <button type="button" id="botonMostrarOcultar" class="btn btn-secondary" >Ver mas...</button>
                    </div>
                    <hr />
                    <table style='width: 100%; text-align: center;  margin-top: 30px'>
                        <thead>
                            <tr>
                                <th>Estudio Primario</th> 
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><textarea type="text" id="txt-aalergic" class="inp-lname" placeholder="Estudio Primario" name="EstPrimario" onkeyup="mayus(this);"style='height: 50px;'/></textarea> </td>
                            </tr>
                        <thead>
                            <tr>
                                <th>Estudio Secundario</th> 
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><textarea type="text" id="txt-estSecuendaria" class="inp-lname" placeholder="Estudio Secundario" onkeyup="mayus(this);"name="EstSecundario"style='height: 50px;'/></textarea></td>
                            </tr> 
                        <thead>
                            <tr>
                                <th>Estudio Tercer Nivel</th> 
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><textarea type="text" id="txt-estTercerNivel" class="inp-lname" placeholder="Estudio Tercer Nivel" onkeyup="mayus(this);" name="EstTercerN"style='height: 50px;'/></textarea></td>
                            </tr>
                        <thead>
                            <tr>
                                <th>Estudios actuales</th> 
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><textarea type="text" id="txt-estActuales" class="inp-lname" placeholder="Estudios actuales" onkeyup="mayus(this);"name="EstActuales"style='height: 50px;'/></textarea></td>
                            </tr> 
                        </tbody>
                    </table>  
                    <hr/>
                    <table style='width: 100%; text-align: center;  margin-top: 30px'>
                        <thead>
                            <tr>
                                <th>Experiencia Laboral</th>
                                <th>Refencia personal</th>
                                <th>Referencia laboral</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><div class="div-cont-name" ><input type="text" id="txt-expLaboral" class="inp-ced" placeholder="Experiencia Laboral"onkeyup="mayus(this);" name="ExpLaboral"/></div></td>
                                <td><div class="div-cont-name" ><input type="text" id="txt-refPresonal" class="inp-name" placeholder="Refencia personal" name="Refenciapersonal"/></div></td>
                                <td><div class="div-cont-lname"><input type="text" id="txt-refLaboral" class="inp-lname" placeholder="Referencia laboral" name="Referencialaboral" onkeyup="mayus(this);"/></div></td>
                            </tr>
                        <thead>
                            <tr>
                                <th>Cursos Realizados</th>
                                <th>Habilidades</th>
                                <th>Actitudes</th> 
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><div class="div-cont-lname"><input type="text" id="txt-pc" class="inp-lname" placeholder="Cursos Realizados" name="cursosrealizados" onkeyup="mayus(this);"/></div></td>
                                <td><div class="div-cont-lname"><input type="text" id="txt-pt" class="inp-lname" placeholder="Habilidades" name="habilidades" onkeyup="mayus(this);"/></div></td>
                                <td><div class="div-cont-lname"><input type="text" id="txt-pa" class="inp-lname" placeholder="Actitudes" name="actitudes" onkeyup="mayus(this);"/></div></td>
                            </tr>

                        </tbody>
                    </table>
                    <hr />
                    <div class="row justify-content-center">
                        <div style="width: 50%;" class="d-flex justify-content-around">
                            <a href="./Principal.jsp" type="button" class="btn rounded-pill" style="background-color: #007653 !important; color: #ffffff;" >Cancelar</a>
                            <input type="submit" id="btn-actiong" class="btn rounded-pill" value="Guardar" style="background-color: #007653 !important;color: #ffffff;"/>
                        </div>
                    </div> 
                </div>
            </section>

        </form> 
        <script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
        <script src="js/newjavascript.js" type="text/javascript"></script>
    </body>
    <footer></footer>
    <script src="js/JQuery.js" type="text/javascript"></script> 
    <script src="js/Buscadorpostulante.js" type="text/javascript"></script> 
    <script type="text/javascript">

                                    var listaIDs = [
                                        "txt-namen",
                                        "txt-lnamea",
                                        "txt-discapacidad",
                                    ];
                                    function consultarData() {
                                        var txtCdiValue = $("#txt-cedi").val(); // Obtener el valor del input
                                        if (txtCdiValue.length === 10) {
                                            var dataToSend = {
                                                cdi: txtCdiValue
                                            };
                                            $.ajax({
                                                url: "consultaPostulantes", // Ruta a tu servlet
                                                method: "POST",
                                                data: dataToSend,
                                                dataType: "json", // Esperar una respuesta JSON
                                                success: function (response) {
                                                    if (response !== null) {
                                                        $("#txt-namen").val(response.postulante_primernombre + " " + response.postulante_segundonombre);
                                                        $("#txt-lnamea").val(response.postulante_primerapellido + " " + response.postulante_segundoapellido);
                                                        $("#txt-discapacidad").val();
                                                        $("#txt-telConvencional").val(response.postulante_convencional);
                                                        $("#txt-celular").val(response.postulante_telefono);
                                                        $("#txt-provincia").val(response.postulante_provincia);
                                                        $("#txt-direccion").val(response.postulante_direccion);
                                                        $("#txt-genero").val(response.postulante_genero);
                                                        $("#txt-carDiscapacidad").val();
                                                        $("#txt-nacionalidad").val(response.postulante_nacionalidad);
                                                        $("#txt-correoElectronico").val(response.postulante_correoelectronico);
                                                    }else{
                                                        alert("Personal no se encuentra ingresado");
                                                    }

                                                },
                                                error: function (request, status, error)
                                                {
                                                    console.log(request, status, error);
                                                },
                                            });
                                        } else {

                                            alert("Ingrese los digitos completos de un CI");
                                            console.log("Error en la solicitud");
                                        }
                                    }

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

                                    $(function () {

                                        $(":input[name = 'search' ]").keyup(function () {

                                            / * Cada vez que el usuario suelta la tecla, se borrará el último contenido del mensaje * /
                                            $("#list li").remove();
                                            var $val = $(this).val();
                                            var url = "${pageContext.request.contextPath}/searchservlet?content=" + $val;
                                            var args = {"time": new Date()};
                                            $.get(url, args, function (data) {

                                                / * La respuesta es una matriz de objetos json * /
                                                for (var i = 0; i < data.length; i++)
                                                    $("#list").append("<li><a>" + data[i].content + "</a></li>");
                                            }, "json");
                                        });
                                        $(":input[name = 'search' ]").keyup(function () {

                                            / * Cada vez que el usuario suelta la tecla, se borrará el último contenido del mensaje * /
                                            $("#list li").remove();
                                            var $val = $(this).val();
                                            var url = "${pageContext.request.contextPath}/searchservlet?content=" + $val;
                                            var args = {"time": new Date()};
                                            $.get(url, args, function (data) {

                                                / * La respuesta es una matriz de objetos json * /
                                                for (var i = 0; i < data.length; i++)
                                                    $("#list").append("<li><a>" + data[i].content + "</a></li>");
                                            }, "json");
                                        });
                                    })
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


</html> 
