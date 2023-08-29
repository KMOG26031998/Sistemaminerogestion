<%@page import="BD.conexion"%>
<%@page import="java.sql.*"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="shortcut icon" href="#" />  
        <title>SISTEMA DE GESTION DE PERSONAL - EMPRESA MINERA </title> 
        <link rel="stylesheet" href="bootstrap1/css/bootstrap.min.css"> 
        <link rel="stylesheet" href="js/main1.js">  
        <link rel="stylesheet" type="text/css" href="datatables1/datatables.min.css"/>   
        <link rel="stylesheet"  type="text/css" href="datatables1/DataTables-1.10.18/css/dataTables.bootstrap4.min.css"> 
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">  
        <link href="css/Historial.css" rel="stylesheet" type="text/css"/>
    </head>
    <body> 
        <header id="header" style=" background: #007653 !important;">
            <a class="logo" href="Principal.jsp">
            </a>
            <a class="logo" id="ulUserData" href="Principal.jsp"></a>
           <nav class="nav-tp"></nav>
    </header>     
    <div class="div-head-tittle"><h2></h2></div> 
        
   
        <!--Ejemplo tabla con DataTables-->
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="table-responsive">    
                        <%
                            //CONECTANOD A LA BASE DE DATOS:
                            conexion con = new conexion();
                            PreparedStatement ps;
                            //Emnpezamos Listando los Datos de la Tabla Usuario
                            Statement smt;
                            ResultSet rs;
                            smt = con.getConecction().createStatement();
                            rs = smt.executeQuery("select pa.postulante_dni as cedula ,pa.postulante_primer_nombre as primerNombre,pa.postulante_segundo_nombre as segundoNombre,pa.postulante_apellido_paterno as apeliidoPaterno,pa.postulante_apellido_materno as apellidoMaterno,pa.postulante_direccion as direccion,pa.postulante_provincia as provincia, pa.postulante_canton as canton, pa.postulante_parroquia as parroquia,pa.postulante_estado_civil as estadoCivil,me.estudiosecundario as Estudiosecundario, me.estudiotercernivel as Estudiotercernivel,me.estudiaactual as Estudiaactual,me.fechaingreso as Fechaingreso, me.motivoingreso as motivoingreso,me.observacion as observacion,me.cargararchivocv as archivo  from personalcontratado me inner join postulante pa on me.postulante_dni = pa.postulante_dni where me.personal_user ='" + session.getAttribute("personal_user11") + "' ");
                            if (rs.next()) {
                                rs = smt.executeQuery("select pa.postulante_dni as cedula ,pa.postulante_primer_nombre as primerNombre,pa.postulante_segundo_nombre as segundoNombre,pa.postulante_apellido_paterno as apeliidoPaterno,pa.postulante_apellido_materno as apellidoMaterno,pa.postulante_direccion as direccion,pa.postulante_provincia as provincia, pa.postulante_canton as canton, pa.postulante_parroquia as parroquia,pa.postulante_estado_civil as estadoCivil,me.estudiosecundario as Estudiosecundario, me.estudiotercernivel as Estudiotercernivel,me.estudiaactual as Estudiaactual,me.fechaingreso as Fechaingreso, me.motivoingreso as motivoingreso,me.observacion as observacion,me.cargararchivocv as archivo  from personalcontratado me inner join postulante pa on me.postulante_dni = pa.postulante_dni where me.personal_user ='" + session.getAttribute("personal_user11") + "'");
                        %>
                        <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%"style="margin-top:70px ;">
                            <thead >
                                <tr>
                                    <th>Cedula</th>
                                    <th>Fecha de anticipo</th>
                                    <th>motivo de anticipo</th>
                                    <th>observacion</th>
                                    <th>primerNombre</th>
                                    <th>segundoNombre</th>
                                    <th>apeliidoPaterno</th>
                                    <th>apellidoMaterno</th>
                                    <th>direccion</th>
                                    <th>provincia</th>
                                    <th>canton</th>
                                    <th>parroquia</th>
                                    <th>estadoCivil</th>
                                    <th>Estudiosecundario</th>
                                    <th>Estudiotercernivel</th>
                                    <th>Estudiaactual</th>
                                    <th>Archivo</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%                    while (rs.next()) {
                                %>
                                <tr>
                                    <td><%= rs.getString("cedula")%></td>
                                    <td><%= rs.getString("Fechaingreso")%></td>
                                    <td><%= rs.getString("motivoingreso")%></td>
                                    <td><%= rs.getString("observacion")%></td>
                                    <td><%= rs.getString("primerNombre")%></td>
                                    <td><%= rs.getString("segundoNombre")%></td>
                                    <td><%= rs.getString("apeliidoPaterno")%></td>
                                    <td><%= rs.getString("apellidoMaterno")%></td>
                                    <td><%= rs.getString("direccion")%></td>
                                    <td><%= rs.getString("provincia")%></td>
                                    <td><%= rs.getString("canton")%></td>
                                    <td><%= rs.getString("parroquia")%></td>
                                    <td><%= rs.getString("estadoCivil")%></td>
                                    <td><%= rs.getString("Estudiosecundario")%></td>
                                    <td><%= rs.getString("Estudiotercernivel")%></td>
                                    <td><%= rs.getString("Estudiaactual")%></td>
                                    <td><a href="DownloadServlet?fileName=<%=rs.getString("archivo")%>">Download</a></td>
                                </tr>
                                <%}%>
                            </tbody>        
                        </table>  
                        <%}%>
                    </div>
                </div>
            </div>  
        </div> 
        <!-- jQuery, Popper.js, Bootstrap JS -->
        <script src="jquery1/jquery-3.3.1.min.js"></script>
        <script src="popper1/popper.min.js"></script>
        <script src="bootstrap1/js/bootstrap.min.js"></script>
        <!-- datatables JS -->
        <script type="text/javascript" src="datatables1/datatables.min.js"></script> 
        <!-- para usar botones en datatables JS -->  
        <script src="datatables1/Buttons-1.5.6/js/dataTables.buttons.min.js"></script>  
        <script src="datatables1/JSZip-2.5.0/jszip.min.js"></script>    
        <script src="datatables1/pdfmake-0.1.36/pdfmake.min.js"></script>    
        <script src="datatables1/pdfmake-0.1.36/vfs_fonts.js"></script>
        <script src="datatables1/Buttons-1.5.6/js/buttons.html5.min.js"></script>
        <!-- código JS propìo-->    
        <script type="text/javascript" src="js/main1.js"></script>  
    </body>
</html>
