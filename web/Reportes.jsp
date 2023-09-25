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
    
        <section class="wrapper" style ="margin-bottom: -30%!important; margin-top:-7%; " >
            <div class="inner" >
                <div class="highlights" >
                        <!-- PRIMER MODULO -->
                    <section class="animadoagregarinformacion">
                        <div class="content">
                            <header>
                                <a href="">
                                    <img src="img/counselor_96px.png" alt=""/> 
                                    <span class="label"></span></a>
                                <h3 style="color:#007653; font-weight: bold">REGISTRO DE ASISTENCIA</h3>

                            </header>
                            <p>Ingresar la entrada del personal a la empresa</p> 
                            <a href="Asistencia.jsp" class="button primary" style=" background: #007653 !important;" href="" >Acceder</a>
                        </div>
                    </section> 
                        
                        <!-- SEGUNDO MODULO -->
                    <section class="animadoagregarinformacion">
                        <div class="content">
                            <header>
                                <a href="">
                                    <img src="img/us_dollar_96px.png" alt=""/> 
                                    <span class="label"></span></a>
                                <h3 style="color:#007653; font-weight: bold">REGISTRO DE ANTICIPO DE SUELDO</h3>

                            </header>
                            <p>Almacenar los anticipos de sueldo que el personal solicito</p>
                            <a href="Anticiposueldo.jsp" class="button primary" style=" background: #007653 !important;" href="" >Acceder</a>
                        </div>
                    </section>
                    
                    <!-- TERCER MODULO -->
                    <section class="animadoagregarinformacion">
                        <div class="content">
                            <header>
                                <a href="">
                                    <img src="img/name_tag_96px.png" alt=""/> 
                                    <span class="label"></span></a>
                                <h3 style="color:#007653; font-weight: bold">POSTULANTES ENTREVISTADOS</h3>

                            </header>
                            <p>Descargar en XLS listado de los postulantes entrevistados</p> 
                            <a href="HistorialPersonalEntrevistado.jsp" class="button primary" style=" background: #007653 !important;" href="" >Acceder</a>
                        </div>
                    </section>

                    <!-- CUARTO MODULO -->
                    <section class="animadoagregarinformacion">
                        <div class="content">
                            <header>
                                <a href="" >
                                    <img src="img/business_building_96px.png" alt=""/> 
                                    <span class="label"></span></a>
                                <h3 style="color:#007653; font-weight: bold" class="textgrueso">Historial de Asistencias</h3>
                            </header>
                            <p>Descargar en XLS las asistencias</p> 
                            <a href="HistorialAsistencia.jsp" class="button primary" style=" background: #007653 !important;">Acceder</a>
                        </div>
                    </section>
                     <!-- QUINTO MODULO -->
                    <section class="animadoagregarinformacion">
                        <div class="content">
                            <header>
                                <a href="" >
                                    <img src="img/pos_terminal_96px.png" alt=""/> 
                                    <span class="label"></span></a>
                                <h3 style="color:#007653; font-weight: bold" class="textgrueso">Historial de Anticipos</h3>
                            </header>
                            <p>Descargar en XLS listado de anticipos dados al personal</p> 
                            <a href="HistorialAnticipoSueldo.jsp" class="button primary" style=" background: #007653 !important;">Acceder</a>
                        </div>
                    </section>
                </div>
            </div>
        </section>
    </body>
</html>