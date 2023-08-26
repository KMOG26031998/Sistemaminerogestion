<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SISTEMA DE GESTION DE PERSONAL - EMPRESA MINERA </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="img/logoblancod.ico" href="img/logoblancod.ico"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <link rel="stylesheet" href="Principal/css/main.css" />
        <link href="css/animacionprincipal.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="is-preload">     
        <%
            HttpSession s = request.getSession();
            //variables de session
            if (s.getAttribute("personal_user11") == null) {
                // Si no hay una sesión activa, redireccionar a una página de inicio de sesión
                response.sendRedirect("./");
            }
        %>    
        <header id="header" style="">

            <header id="header" style=" background: #007653 !important;">
                <a class="logo" href="index.jsp">
                </a>
                <a class="logo" id="ulUserData" href="index.html"></a>
                <nav>
                    <a href="cambioclave.jsp" style="color:white" >Cambiar clave</a>
                    <a href="cerrar.jsp" style="color:white" >Cerrar sesión</a>
                </nav>
            </header>
        </header>
        <!-- container principal -->
        <section class="wrapper">
            <div class="inner" style = "margin-top:-7%;">
                <div class="highlights">
                    <!-- PRIMER MODULO -->
                    <section class="animadoagregarinformacion">
                        <div class="content">
                            <header>
                                <a href="">  
                                    <img alt=""src="img/add_user_group_woman_man_96px.png" alt=""/>
                                    <span class="label"></span></a>
                                <h3 style="color:#007653; font-weight: bold">Ingresar Nuevo Postulante</h3>
                            </header>
                            <p>Ingresar datos personales por primera vez</p>
                            <a href="ingreso.jsp" class="button primary" style=" background: #007653 !important;">Ingresar Nuevo Postulante</a>
                            <br>
                            <a href="ListaPersonalModificar.jsp" class="button primary" style=" background: #007653 !important; margin-top: 12px;">Actualizar Postulante</a>
                        </div>
                    </section>

                    <!-- SEGUNDO MODULO -->
                       <section class="animadoagregarinformacion">
                        <div class="content">
                            <header>
                                <a href="">
                                    <img alt="" src="svg/curriculum.svg" width="96" height="96">
                                    <span class="label"></span></a>
                                <h3 style="color:#007653; font-weight: bold">HOJA DE VIDA</h3>
                            </header>
                            <p>Ingresar o actualizar Hoja de vida de postulante</p>
                            <a href="Personalcontratado.jsp" class="button primary" style=" background: #007653 !important;" >Agregar Personal</a>
                            <%--<a href="ListarPersonal.jsp" class="button primary" style=" background: #007653 !important;">Ingreso de Datos</a>--%>
                        </div>
                    </section>
                    <!-- TERCER MODULO -->                 
                
                    
                    <section class="animadoagregarinformacion">
                        <div class="content">
                            <header>
                                <a href="">
                                    <img alt="" src="img/card_file_box_96px.png" alt=""/> 
                                    <span class="label"></span></a>
                                <h3 style="color:#007653; font-weight: bold">CONTRATAR PERSONAL</h3>
                            </header>
                            <p>Seleccione postulantes para contrartar</p>
                            <a href="ListaPersonalContrato.jsp" class="button primary" style=" background: #007653 !important;" >Contratar Personal</a>
                            <!-- <a id="PaginaPerso" class="button primary" style=" background: #007653 !important;" >Agregar consulta o anticipos</a>-->
                        </div>
                    </section>

                    <!-- CUARTO MODULO -->
                    <section class="animadoagregarinformacion">
                        <div class="content">
                            <header>
                                <a href="">   
                                    <img alt="" src="img/worker_96px.png" alt=""/>
                                    <span class="label"></span></a>
                                <h3 style="color:#007653; font-weight: bold">Actualizar datos personales</h3>
                            </header>
                            <p>Podrá hacer actualizaciones</p>
                            <a href="ActualizarDatosPersonales.jsp" class="button primary" style=" background: #007653 !important;">Actualizar</a>
                        </div>
                    </section>
                    <!-- Quinto MODULO -->
                    <section class="animadoagregarinformacion">
                        <div class="content">
                            <header>
                                <a href="" >
                                    <img src="img/combo_chart_96px.png" alt=""/> 
                                    <span class="label"></span></a>
                                <h3 style="color:#007653; font-weight: bold" class="textgrueso">Control de Asistencia, Anticipos y Reportes</h3>
                            </header>
                            <p>Registrar la asistencia del personal, los anticipos y descargar en PDF los reportes</p>
                            <a href="Reportes.jsp" class="button primary" style=" background: #007653 !important;">Ingresar</a>
                        </div>
                    </section>
                    <!-- Sexto MODULO -->
                 
                    
                        <section class="animadoagregarinformacion">
                        <div class="content">
                            <header>
                                <a href="">
                                    <img src="img/task_96px.png" alt=""/> 
                                    <span class="label"></span></a>
                                <h3 style="color:#007653; font-weight: bold">Historial</h3>
                            </header>
                            <p>Mostrar la información de las actividades del personal de trabajo</p>
                            <a href="HistorialPagos.jsp" class="button primary"style=" background: #007653 !important;">Ver historial</a>
                        </div>
                    </section>
                </div>
            </div>
        </section>
        <!-- Scripts -->
        <script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
        <script src="Principal/js/jquery.min.js"></script>
        <script src="Principal/js/browser.min.js"></script>
        <script src="Principal/js/breakpoints.min.js"></script>
        <script src="Principal/js/util.js"></script>
        <script src="Principal/js/main.js"></script>
        <script src="js/animacion.js" type="text/javascript"></script>
    </body>
</html>