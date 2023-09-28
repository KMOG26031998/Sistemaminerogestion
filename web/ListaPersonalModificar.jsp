<%-- 
    Document   : ListaPersonalModificar
    Created on : 21 ago. 2023, 22:30:52
    Author     : Luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SISTEMA DE GESTION DE PERSONAL - EMPRESA MINERA </title>
        <link href="css/Actualizardatospostulante.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    </head>
    <body>
        <div class="div-head-tittle">
            <h2 class="title">
                LISTADO DE POSTULANTES
            </h2>
        </div>

        <form class="form1" >

            <section class="sec-main">
                <div class="div-cont-main">

                    <div class="container mt-5 ">
                        <h1 class="text-center">Filtrar Postulantes</h1>


                        <div class="form-group row ">
                            <select class="custom-select w-25" id="selectConsulta">
                                <option value="1">Cedula Ciudadania:</option>
                                <option value="2">Nombre</option>
                            </select>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="staticEmail" >
                            </div>
                            <div class="col-sm-2">
                                <button id="botonCargar"type="submit" class="btn btn-primary">Buscar</button>
                            </div>
                        </div>

                        <div id="resultado"></div>
                        <table class="table mt-3">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>NOMBRE</th>
                                    <th>APELLIDO</th>
                                    <th>CÉDULA</th>             
                                    <th>NACIONALIDAD</th>
                                    <th>ACCIONES</th>
                                </tr>
                            </thead>
                            <tbody id="tabla-personas">
                            </tbody>
                        </table>
                        <div id="paginacion" class="mt-3">
                            <ul class="pagination justify-content-center">
                                <!-- Aquí irá la paginación generada por JavaScript -->
                            </ul>
                        </div>
                    </div>
                </div>
            </section>
        </form>
    </body>
</html>

<script>
    $(document).ready(function () {
        // Datos simulados para la tabla (reemplaza esto con tu lógica de obtención de datos)
        var paginaActual = 1;
        var personas = '';
        var elementosPorPagina = 7;
        var totalPaginas = Math.ceil(personas.length / elementosPorPagina);
        function mostrarPersonasEnPagina(pagina) {
            var inicio = (pagina - 1) * elementosPorPagina;
            var fin = inicio + elementosPorPagina;
            var html = "";
            for (var i = inicio; i < fin && i < personas.length; i++) {
                html += "<tr><td>" + personas[i].postulanteid + "</td><td>" + personas[i].postulante_primernombre + " " + personas[i].postulante_segundonombre
                        + "</td><td>" + personas[i].postulante_primerapellido + " " + personas[i].postulante_segundoapellido
                        + "</td><td>" + personas[i].postulante_dni + "</td><td>" + personas[i].postulante_nacionalidad + "</td><td>\n\
                           <a href=\"ActPostulante?id=" + personas[i].postulanteid + "&Tipo=mod\" class=\"btn btn-info btn-sm\">Editar</a>\n\
                           <a id=\"btn_eliminar" + i + "\" href=\"ActPostulante?id=" + personas[i].postulanteid + "&Tipo=delete\" class=\"btn btn-danger btn-sm eliminar-persona\" data-id=\"" + i + "\">Eliminar</a></td></tr>";
            }

            $("#tabla-personas").html(html);
        }

        function mostrarPaginacion() {
            var html = "";
            totalPaginas = Math.ceil(personas.length / elementosPorPagina);
            for (var i = 1; i <= totalPaginas; i++) {
                html += '<li class="page-item ' + (i === paginaActual ? "active" : "") + '"><a class="page-link" href="#">' + i + '</a></li>';
            }

            $("#paginacion ul").html(html);

            $("#paginacion a").click(function () {
                paginaActual = parseInt($(this).text());
                mostrarPersonasEnPagina(paginaActual);
                mostrarPaginacion();
            });
        }

        $(document).on("click", ".eliminar-persona", function () {
            var personaId = $(this).attr("data-id");

            if (window.confirm("¿Estás seguro de que deseas eliminar esta persona?")) {
                personas.splice(personaId, 1);
                totalPaginas = Math.ceil(personas.length / elementosPorPagina);

                if (paginaActual > totalPaginas) {
                    paginaActual = totalPaginas;
                }

                mostrarPersonasEnPagina(paginaActual);
                mostrarPaginacion();
            }
        });

        function llenaTabla() {
            $.ajax({
                url: "consultaPostulantes", // Reemplaza con la URL de tu servlet
                method: "POST",
                dataType: "text",
                success: function (data) {
                    personas = JSON.parse(data);
                    mostrarPersonasEnPagina(paginaActual);
                    mostrarPaginacion();
                },
                error: function (xhr, status, error) {
                    var errorMessage = "Error en la solicitud: " + xhr.status + " " + xhr.statusText;
                    $("#resultado").text(errorMessage);
                }
            });
        }
        $("#botonCargar").click(llenaTabla);
        llenaTabla();
        mostrarPersonasEnPagina(paginaActual);
        mostrarPaginacion();
    });
</script>

