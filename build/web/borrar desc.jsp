
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SISTEMA DE GESTION DE PERSONAL - EMPRESA MINERA</title>
    </head>
    <body>
        <script>
            function myFunction() {
                alert('Input validado');
            }
        </script>
        <form action="#" onsubmit="myFunction()">
            <label htmlFor="phone">Escriba un número de teléfono</label>
            <input id="phone" type="text" name="phone" pattern="\x2b[0-9]+" size="20" placeholder="+54976284353" required>
            <button type="submit">Validar</button>
        </form>
    </body>
</html>
