
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Asistencia.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>SISTEMA DE GESTION DE PERSONAL - EMPRESA MINERA </title>
    </head>
    <body>
        <form name="form1" method="post" action="REPORTEAsistencia.jsp">
            <%
                HttpSession s = request.getSession();
                //variables de session                          
            %>
            <table width="487" align="center">
                <tr>
                    <td colspan="2" align="center"><strong>REPORTES PDF ASISTENCIA </strong></td>
                </tr>
                <tr>
                    <td width="168">INGRESE CEDULA DEL PERSONAL:</td>
                    <td width="415"><label for="cedulacontratado"></label> 
                        <input type="text" name="cedulacontratado" id="cedulaCliente"></td>
                </tr>
                <tr>
                    <td width="168">INGRESE SU CEDULA:</td>
                    <td width="415"><label for="cedulaPersonal" name="cedulaPersonal" id="cedulaPersonal"></label>
                        <input type="text" name="cedulaPersonal" id="cedulaPersonal"></td>
                </tr>
                <tr>
                    <td width="168">INGRESE LA FECHA:</td>
                    <td width="415"><label for="fecha"></label>
                        <input type="date" name="fecha" id="fecha" onchange="myFunction(value)"></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="Registrar la Asistencia "></td>
                </tr>
            </table>
        </form>
        <script>
            var a;
            function myFunction(val) {
                a = val.split("-").reverse().join("/");
                document.getElementById("fecha").type = "text";
                document.getElementById("fecha").value = a;
            }
        </script>
    </body>
</html>
