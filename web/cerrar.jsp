<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>SISTEMA DE GESTION DE PERSONAL - EMPRESA MINERA</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="google-signin-client_id" content="602955025460-ne0204gk3d5on3i4qftl2up41nb6lr1q.apps.googleusercontent.com">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
    <link rel="icon" type="img/logoblancod.ico" href="img/logoblancod.ico"/>
        <meta http-equiv="refresh" content="0;URL=index.jsp">
        <script type="text/javascript">
            function deshabilitaRetroceso() {
                window.location.hash = "no-back-button";
                window.location.hash = "Again-No-back-button"; //chrome
                window.onhashchange = function () {
                    window.location.hash = "no-back-button";
                };
            }
        </script>
    </head>
    <body onload="deshabilitaRetroceso()">
        <login1:login1></login1:login1>
        </body>
    <%request.getSession().invalidate();%>
</html>
