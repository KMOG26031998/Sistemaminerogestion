<%-- 
    Document   : ListaPersonalContrato
    Created on : 22 ago. 2023, 23:41:40
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
                PERSONAL A CONTRATAR
            </h2>
        </div>
        <form class="form1" action="AddContrato" method="post">
            <section class="sec-main">
                <div class="div-cont-main">
                    <div class="container mt-5 ">
                        <div id="resultado"></div>
                        <table style='width: 100%;'>
                            <thead>
                                <tr>
                                    <th>Numero de identificacion</th>
                                    <th>Nombres</th>
                                    <th>Apellidos</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                            <input type="text" style="display: none" value="${usuario.postulanteid}" name="id" required/>                            <input type="text" style="display: none" value="${usuario.postulanteid}" name="id" required/>
                         

                            <td> <div class="div-cont-name"><input type="text" id="txt-cedi" class="inp-ced" placeholder="Numero de identificacion" value="${usuario.postulante_dni}" name="cedula" disabled="true" onkeypress='return validaNumericos(event)' maxlength="10" required/></div> </td>
                            <td> <div class="div-cont-name"  ><input type="text" id="txt-namen" class="inp-name" placeholder="Nombres" value="${usuario.postulante_primernombre} ${usuario.postulante_segundonombre}" name="Nombres" disabled="true" onkeyup="mayus(this);"/></div> </td>
                            <td> <div class="div-cont-lname"  ><input type="text" id="txt-lnamea" class="inp-lname" placeholder="Apellidos"  value="${usuario.postulante_primerapellido} ${usuario.postulante_segundoapellido}" name="Apellidos"disabled="true" onkeyup="mayus(this);"/></div> </td>
                            </tr>
                            </tbody>
                            <br/>
                        </table>
                        <hr/>
                        <div class="container">
                            <div class="row">
                                <div class="col">
                                    <div class="form-group">
                                        <label for="Motivo" ><b>Motivo:</b></label>
                                        <input type="text" class="form-control " id="Motivo"name="Motivo" required>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="Tiempo" ><b>Tiempo Meses:</b></label>
                                        <input type="number" class="form-control " id="Tiempo"name="Tiempo" min="1" required>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="Sueldo" ><b>Sueldo:</b></label>
                                        <input type="number" class="form-control " id="sueldo" name="Sueldo" min="1" required>
                                    </div>
                                </div>
                            </div>
                            <div class="row ">
                                <div class="col">
                                    <div class="form-group">
                                        <label for="Observacion" ><b>Observación</b></label>
                                        <textarea type="text" class="form-control" id="Observacion"name="Observacion" required rows="2"></textarea>
                                    </div>
                                </div>

                            </div> 
                            <hr/>
                            <div class="row justify-content-center">
                                <div style="width: 50%;" class="d-flex justify-content-around">
                                    <a href="./Principal.jsp" type="button" class="btn rounded-pill" style="background-color: #007653 !important; color: #ffffff;" >Cancelar</a>
                                    <input type="submit" id="btn-actiong" class="btn rounded-pill" value="Guardar" style="background-color: #007653 !important;color: #ffffff;"/>
                                </div>
                            </div> 

                        </div>
                    </div>
                </div>
            </section>
        </form>
    </body>
    <script type="text/javascript">
        $(document).ready(function () {








        });
    </script>
</html>
