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
        <link href="css/HistorialAsistencia.css" rel="stylesheet" type="text/css"/> 
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
                            rs = smt.executeQuery("select p.postulante_dni as Cedula, concat(p.postulante_primer_nombre,' ',p.postulante_segundo_nombre,' ',p.postulante_apellido_paterno,' ',p.postulante_apellido_materno) as Nombre_del_Personal,asi.fecha as Fecha_Asistencia,asi.actividadobservacion as Actividad_Observacion,concat(pr.personal_primer_nombre,' ',pr.personal_segundo_nombre,' ',pr.personal_apellido_paterno,' ',pr.personal_apellido_materno) as Encargado_del_Registro,asi.id_asistencia as id_asistencia from asistencia asi inner join personal pr on pr.personal_id=asi.personal_id inner join postulante p on p.postulante_id =asi.postulante_id ");
                            if (rs.next()) {
                        %>
                        <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%"style="margin-top:70px ;">
                            <thead >
                                <tr>
                                    <th>Cedula</th>
                                    <th>Nombre del Personal</th>                                    
                                    <th>Fecha de Asistencia</th>
                                    <th>Actividad o Observacion</th> 
                                    <th>Nombre del Entrevistador</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%  while (rs.next()) {
                                %>
                                <tr>
                                    <td><%= rs.getString("Cedula")%></td>
                                    <td><%= rs.getString("Nombre_del_Personal")%></td>
                                    <td><%= rs.getString("Fecha_Asistencia")%></td>
                                    <td><%= rs.getString("Actividad_Observacion")%></td>
                                    <td><%= rs.getString("Encargado_del_Registro")%></td> 
                                    
                                    <td class="d-flex justify-content-center">
                                        <a class="btn btn-success" style="color: #fff !important;"  >Editar</a>
                                        <a class="btn btn-danger" style="color: #fff !important;" href="EliminaAsistencia?id=<%=rs.getString("id_asistencia")%>">Eliminar</a>
                                    </td> 
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
