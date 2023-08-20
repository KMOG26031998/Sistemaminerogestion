<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SISTEMA DE GESTION DE PERSONAL - EMPRESA MINERA</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="img/logoblancod.ico" href="img/logoblancod.ico"/>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <link href="css/reportes.css" rel="stylesheet" type="text/css"/>
        <link href="css/animacionprincipal.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            HttpSession s = request.getSession();
            //variables de session
%>
        <label id="usuario" style="display:none;"><%= s.getAttribute("personal_user11")%> </label> 
        <label id="nombre" style="display:none;"></label> 
 
        <header id="header" style=" background: #007653 !important; ">
                <a class="logo" href="Principal.jsp" >
                </a>
                <a class="logo" id="ulUserData" href="Principal.jsp"></a> 
        </header>
 
        <div class="div-head-tittle"><h2></h2></div>
    
        <section class="wrapper">
            <div class="inner" >
                <div class="highlights">
                    <!-- PRIMER MODULO -->
                    <section class="animadoagregarinformacion">
                        <div class="content">
                            <header>
                                <a href="">
                                    <img src="img/device_manager_96px.png" alt=""/> 
                                    <span class="label"></span></a>
                                <h3 style="color:#007653; font-weight: bold">POSTULANTES ATENDIDOS</h3>

                            </header>
                            <p>Descargar en PDF las estadísticas de los postulantes atendidos</p>
                            <a href="formularioReporteHistorialPostulantes.jsp" class="button primary" style=" background: #007653 !important;" href="" >Acceder</a>
                        </div>
                    </section>

                    <!-- SEGUNDO MODULO -->
                    <section class="animadoagregarinformacion">
                        <div class="content">
                            <header>
                                <a href="" >
                                    <img src="img/business_building_96px.png" alt=""/> 
                                    <span class="label"></span></a>
                                <h3 style="color:#007653; font-weight: bold" class="textgrueso">Asistencias</h3>
                            </header>
                            <p>Descargar en PDF las asistencias</p>
                            <a href="formularioReporteAsistencia.jsp" class="button primary" style=" background: #007653 !important;">Acceder</a>
                        </div>
                    </section>
                </div>
            </div>
        </section>
    </body>
</html>