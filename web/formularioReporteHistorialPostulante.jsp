<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SISTEMA DE GESTION DE PERSONAL - EMPRESA MINERA </title>
    </head>
    <body>
        <form name="form1" method="post" action="REPORTEHistorialpostulante.jsp">
            <%
                HttpSession s = request.getSession();
                //variables de session
            %>
            <table width="487" align="center">
                <tr>
                    <td colspan="2" align="center"><strong>REPORTES PDF HISTORIAL POSTULANTES ENTREVISTADOS </strong></td>
                </tr>
                <tr>
                    <td width="168">SU USUARIO ES:</td>
                    <td width="415"><label for="usuario"></label> 
                        <input type="text" name="usuario" id="usuario"></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="Generar Reporte "></td>
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