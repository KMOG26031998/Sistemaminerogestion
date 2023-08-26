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
  

        <form class="form1"> 
            <section class="sec-main">
                <div class="div-cont-main">
                    <table style='width: 100%; text-align: center; margin-left: 20px; margin-top: 30px'>
                        <thead >
                            <tr>
                                <th>Numero de identificacion</th>
                                <th>Nombres del Postulante</th>
                                <th>Nombres del Administrador</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td> <div class="div-cont-name"><input type="text"onkeypress='return validaNumericos(event)' id="txt-ced" class="inp-ced" placeholder="Numero de identificacion" name="Identificacion" onkeypress='return validaNumericosA(event)' maxlength="15"/></div></td>
                                <td><div class="div-cont-name"><input type="text" disabled="true" id="txt-namep"onkeypress="return soloLetras(event)" class="inp-ced" placeholder="Nombres del Postulante" name="nombres postulante" onkeypress="return soloLetras(event)"/></div></td>
                                <td><div class="div-cont-name"><input type="text" id="txt-nameme" class="inp-name" placeholder="Nombres del Administrador" name="nombres administrador" onkeypress="return soloLetras(event)"disabled="true"/></div></td>
                            </tr>
                        </tbody>

                        <thead >
                            <tr>                          
                                <th>Asistencia</th>
                                <th>Actividad/Observacion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                 <td><div class="div-cont-lname"><input type="date" id="txt-lname" class="inp-lname" placeholder="Asistencia"required=""  name="Asistencia"/></div></td> 
                                <td><div class="div-cont-name"><input type="text"onkeyup="mayus(this);" id="txt-namei" class="inp-name" placeholder="Observaciones" name="observaciones"/></div></td>
                                <td><div style='margin-top: -20px !important;'class="div-cont-lname"><input type="button" id="btn-action" class="btn-accept" value="+"> 
                                        <input type="button"  id="btn-addasistencia" class="btn-accept" value="GUARDAR"></div></td> 

                            </tr>
                        </tbody>                        
                    </table> 

                    <div style="width: 70%; height: auto; margin-left: auto; margin-right: auto" >
                        <div >
                            <table id="tabla" class="table table-bordered">
                                <thead>
                                    <tr> 

                                        <td>Nª</td>
                                        <td>Asistencia</td>
                                        <td>Actividad/Observacion</td>
                                        <td>Acciones</td>

                                    </tr>
                                </thead>
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
    <script src="js/Asistencia.js" type="text/javascript"></script>
    <script src="js/Buscadorpostulante.js" type="text/javascript"></script>
    <script src="js/newjavascript.js" type="text/javascript"></script>    
</html>
