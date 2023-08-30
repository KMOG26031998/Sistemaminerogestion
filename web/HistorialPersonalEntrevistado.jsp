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
        <link href="css/HistorialPersonalEntrevistado.css" rel="stylesheet" type="text/css"/> 
    </head>
    <body> 
        <header id="header" style=" background: #007653 !important;">
            <a class="logo" href="Principal.jsp">
            </a>
            <a class="logo" id="ulUserData" href="Reportes.jsp"></a>
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
                            //Empezamos Listando los Datos de la Tabla Usuario
                            Statement smt;
                            ResultSet rs;
                            smt = con.getConecction().createStatement();
                            rs = smt.executeQuery("select p.postulante_dni as Cedula, concat(p.postulante_primer_nombre,' ',p.postulante_segundo_nombre,' ',p.postulante_apellido_paterno,' ',p.postulante_apellido_materno) as nombre_Postulante, concat(pr.personal_primer_nombre,' ',pr.personal_segundo_nombre,' ',pr.personal_apellido_paterno,' ',pr.personal_apellido_materno) as Personal_Entrevistador,p.created_at as Fecha_Entrevista,p.postulante_cargo as Cargo_de_Trabajo_Postulacion, p.postulante_provincia as Provincia,p.postulante_canton as Canton,p.postulante_parroquia as Parroquia,p.postulante_direccion as Direccion,p.postulante_estado_civil as Estado_Civil,p.postulante_correoelectronico as Correo_Electronico,p.postulante_telefono as Numero_Celular,p.postulante_convencional as Numero_Convencional,p.postulante_fnacimiento as Fecha_de_Nacimiento,p.postulante_grupo as Discapacidad,pc.experiencialaboral as Experiencia_Laboral,pc.refenciapersonal  as Referencia_Personal,pc.referencialaboral as Referencia_Laboral, pc.estudioprimario as Estudio_Primario,pc.estudiosecundario as Estudio_Segundario,pc.estudiotercernivel as Estudio_Tercer_Nivel,pc.estudiaactual as Estudio_Actual from postulante p inner join personalcontratado pc on p.postulante_dni=pc.postulante_dni inner join personal pr on pr.personal_user= pc.personal_user ");
                            if (rs.next()) {
                                rs = smt.executeQuery("select p.postulante_dni as Cedula, concat(p.postulante_primer_nombre,' ',p.postulante_segundo_nombre,' ',p.postulante_apellido_paterno,' ',p.postulante_apellido_materno) as nombre_Postulante, concat(pr.personal_primer_nombre,' ',pr.personal_segundo_nombre,' ',pr.personal_apellido_paterno,' ',pr.personal_apellido_materno) as Personal_Entrevistador,p.created_at as Fecha_Entrevista,p.postulante_cargo as Cargo_de_Trabajo_Postulacion, p.postulante_provincia as Provincia,p.postulante_canton as Canton,p.postulante_parroquia as Parroquia,p.postulante_direccion as Direccion,p.postulante_estado_civil as Estado_Civil,p.postulante_correoelectronico as Correo_Electronico,p.postulante_telefono as Numero_Celular,p.postulante_convencional as Numero_Convencional,p.postulante_fnacimiento as Fecha_de_Nacimiento,p.postulante_grupo as Discapacidad,pc.experiencialaboral as Experiencia_Laboral,pc.refenciapersonal  as Referencia_Personal,pc.referencialaboral as Referencia_Laboral, pc.estudioprimario as Estudio_Primario,pc.estudiosecundario as Estudio_Segundario,pc.estudiotercernivel as Estudio_Tercer_Nivel,pc.estudiaactual as Estudio_Actual from postulante p inner join personalcontratado pc on p.postulante_dni=pc.postulante_dni inner join personal pr on pr.personal_user= pc.personal_user ");
                        %>
                        <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%"style="margin-top:70px ;">
                            <thead >
                                <tr>
                                    <th>Cedula</th>
                                    <th>Nombre del Postulante</th>
                                    <th>Nombre del Entrevistador</th>
                                    <th>Fecha Entrevista</th>
                                    <th>Cargo de Trabajo Postulacion</th>
                                    <th>Provincia</th>
                                    <th>Canton</th>
                                    <th>Parroquia</th>
                                    <th>Direccion</th>
                                    <th>Estado Civil</th>
                                    <th>Correo Electronico</th>
                                    <th>Numero Celular</th>
                                    <th>Numero Convencional</th>
                                    <th>Fecha de Nacimiento</th>
                                    <th>Discapacidad</th>
                                    <th>Experiencia Laboral</th> 
                                    <th>Referencia Personal</th> 
                                    <th>Referencia Laboral</th>  
                                    <th>Estudio Primario</th> 
                                    <th>Estudio Segundario</th>
                                    <th>Estudio Tercer Nivel</th>
                                    <th>Estudio Actual</th> 
                                     <!-- <th>Sueldo</th>  --> 
                                </tr>
                            </thead>
                            <tbody>
                                <%  while (rs.next()) {
                                %>
                                <tr>
                                    <td><%= rs.getString("Cedula")%></td>
                                    <td><%= rs.getString("Nombre_Postulante")%></td>
                                    <td><%= rs.getString("Personal_Entrevistador")%></td>
                                    <td><%= rs.getString("Fecha_Entrevista")%></td>
                                    <td><%= rs.getString("Cargo_de_Trabajo_Postulacion")%></td>
                                    <td><%= rs.getString("Provincia")%></td>
                                    <td><%= rs.getString("Canton")%></td>
                                    <td><%= rs.getString("Parroquia")%></td>
                                    <td><%= rs.getString("Direccion")%></td>
                                    <td><%= rs.getString("Estado_Civil")%></td>
                                    <td><%= rs.getString("Correo_Electronico")%></td>
                                    <td><%= rs.getString("Numero_Celular")%></td>
                                    <td><%= rs.getString("Numero_Convencional")%></td>
                                    <td><%= rs.getString("Fecha_de_Nacimiento")%></td>
                                    <td><%= rs.getString("Discapacidad")%></td>  
                                   <td><%= rs.getString("Experiencia_Laboral")%></td> 
                                   <td><%= rs.getString("Referencia_Personal")%></td> 
                                   <td><%= rs.getString("Referencia_Laboral")%></td> 
                                   <td><%= rs.getString("Estudio_Primario")%></td> 
                                   <td><%= rs.getString("Estudio_Segundario")%></td> 
                                   <td><%= rs.getString("Estudio_Tercer_Nivel")%></td> 
                                   <td><%= rs.getString("Estudio_Actual")%></td> 
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
