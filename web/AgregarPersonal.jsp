<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="BD.conexion"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" > 
        <link href="css/Personal.css" rel="stylesheet" type="text/css"/> 
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>SISTEMA DE GESTION DE PERSONAL - EMPRESA MINERA </title>
    </head>
    <body onload="cargarProvincias()">
        <header id="header" style=" background: #007653 !important;"  >
            <nav class="nav-tp" ></nav>

            <a class="logo" id="ulUserData" href="index.html"></a>
        </header>
        <div class="div-head-tittle"><h2></h2></div>
        <!--javascript:sendmail()-->
        <!--/WebAPP/AddGaleno-->

        <form class="form1" action="/Sistemaminerogestion/AddPersonal">
            <section class="sec-main" >
                <div class="div-cont-main">
                    <table style='width: 100%; text-align: center; margin-left: 20px; margin-top: 30px'>
                        <thead >
                            <tr>
                                <th>Tipo de identificacion</th>
                                <th>Numero de identificacion</th>
                                <th>Primer Nombre</th>
                            </tr>
                        </thead> 
                        <tbody>
                            <tr>
                                <td><div class="div-cont-sel-dep-to-transf" ><select class="sel-dep-to-transf" name="TipoIden">
                                            <option>Tipo de identificacion</option>
                                            <option>Cedula</option><option>Pasaporte</option></select></div></td>
                                <td><div style='margin-top: -40px !important;'class="div-cont-ced"><input type="text" id="txt-ced" minlength="10" maxlength="10" class="inp-ced" placeholder="Numero de identificacion" name="Identificacion" required="" onkeypress='return validaNumericos(event)'/></div></td>
                                <td><div class="div-cont-name"><input type="text" id="txt-name" class="inp-name" placeholder="Primer Nombre" name="PrimerNombre" required=""  onkeypress="return soloLetras(event)" onkeyup="mayus(this);"/></div></td>
                            </tr>
                        </tbody>
                        <thead >
                            <tr>
                                <th>Segundo Nombre</th>
                                <th>Primer Apellido</th>
                                <th>Segundo Apellido</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><div class="div-cont-lname"><input type="text" id="txt-lname" class="inp-lname" placeholder="Segundo Nombre" name="SegundoNombre"required=""  onkeypress="return soloLetras(event)" onkeyup="mayus(this);"/></div></td>
                                <td><div class="div-cont-name"><input type="text" id="txt-name" class="inp-name" placeholder="Primer Apellido" name="PrimerApellido"required=""  onkeypress="return soloLetras(event)" onkeyup="mayus(this);"/></div></td>
                                <td><div class="div-cont-lname"><input type="text" id="txt-lname" class="inp-lname" placeholder="Segundo Apellido" name="SegundoApellido"required=""  onkeypress="return soloLetras(event)" onkeyup="mayus(this);"/></div></td>
                            </tr>
                        </tbody>
                        <thead >
                            <tr>
                                <th>Celular</th>
                                <th>Provincia</th>
                                <th>Canton</th>

                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><div class="div-cont-edad"><input type="text" id="txt-edad" class="inp-edad" placeholder="Celular" name="celular"required="" maxlength="10"  onkeypress='return validaNumericos(event)'/></div> </td>                      
                                <td><div class="div-cont-sel-dep-to-transf" ><select class="sel-dep-to-transf"required="" id="Provincia" name="Provincia" onchange="cargarPueblos();">
                                            <option>Seleccione una provincia</option>
                                        </select></div></td> 
                                <td><div class="div-cont-sel-dep-to-transf" ><select class="sel-dep-to-transf"required=""  name="canton" id="canton">
                                            <option>Seleccione un canton</option>
                                        </select></div></td> 
                            </tr> 
                        </tbody>
                        <thead >
                            <tr>                                
                                <th>Parroquia</th>
                                <th>Direccion</th>                               
                                <th>Correo Electronico</th> 
                            </tr>
                        </thead>
                        <tbody>
                            <tr> 

                                <td><div class="div-cont-lname"><input type="text" id="txt-lname" class="inp-lname" placeholder="Parroquia"required=""  name="parroquia" onkeypress="return soloLetras(event)" onkeyup="mayus(this);"/></div></td> 
                                <td><div class="div-cont-lname"><input type="text" id="txt-lname" class="inp-lname" placeholder="Direccion"required="" name="direccion" onkeyup="mayus(this);"/> </div></td> 
                                <td><div class="div-cont-lname"><input type="email" id="email" class="inp-lname" placeholder="correo electronico"required="" name="email"/> </div></td> 
                            </tr>
                        </tbody> 
                        <thead >
                        <thead >
                            <tr>
                                <th>Usuario</th>                               
                                <th>Contraseña</th> 
                                <th>Administracion</th> 
                            </tr>
                        </thead>
                        <tbody>
                            <tr> 
                                <td><div class="div-cont-lname"><input type="text" id="user" class="inp-lname" placeholder="Ingrese el usuario"required="" name="user"/> </div></td> 
                                <td><div class="div-cont-lname"><input type="password" id="pass" class="inp-lname" placeholder="Ingrese una Contraseña"required="" name="pass"/> </div></td> 
                                <td><div class="div-cont-sel-dep-to-transf"><select class="sel-dep-to-transf"required=""  name="departamento">
                                            <option>Seleccione el tipo de administracion</option>
                                            <option>ADMINISTRADOR 1</option> 
                                            <option>SECRETARIA</option> 
                                        </select></div></td> 
                            </tr>
                        </tbody>
                        <thead> 
                            
                        <td>
                            <input type="submit" class="btn-accept"  value="Guardar"/> 
                        </td> 
                        </thead>
                    </table> 
                </div>
            </section>
        </form> 
        <script src="https://smtpjs.com/v3/smtp.js"></script>

        <script
            src="https://code.jquery.com/jquery-2.2.4.min.js"
            integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
        crossorigin="anonymous"></script>
        <script>
                                    function cargarProvincias() {
                                        var array = ["Azuay", "Bolívar", "Cañar", "Carchi", "Chimborazo", "Cotopaxi", "Oro", "Esmeraldas", "Galápagos", "Guayas", "Imbabura", "Loja", "LosRíos",
                                            "Manabí", "MoronaSantiago", "Napo", "Orellana", "Pastaza", "Pichincha", "SantaElena", "SantoDomingo", "Sucumbíos", "Tungurahua", "ZamoraChinchipe"];
                                        array.sort();
                                        addOptions("Provincia", array);
                                    }

                                    function addOptions(domElement, array) {
                                        var selector = document.getElementsByName(domElement)[0];
                                        for (Provincia in array) {
                                            var opcion = document.createElement("option");
                                            opcion.text = array[Provincia];
                                            opcion.value = array[Provincia].toLowerCase()
                                            selector.add(opcion);
                                        }
                                    }
                                    function cargarPueblos() {
                                        // Objeto de provincias con pueblos
                                        var listaPueblos = {
                                            azuay: ["Cuenca", "camilo ponce Enriquez", "Chordeleg", "El pan", "Girón", "Guachapala", "Gualaceo", "Nabón", "Oña", "Paute", "Pucará", "San Fernando", "Santa Isabel", "Sevilla de oro", "Sígsig"],
                                            bolívar: ["Guaranda", "Caluma", "Chillanes", "Chimbo", "Echeandía", "Las naves", "San Miguel"],
                                            cañar: ["Azogues", "Biblián", "Cañar", "Déleg", "El Tambo", "La Troncal", "Suscal"],
                                            carchi: ["Tulcán", " Bolívar", "Espejo", "Mira", "Montúfar", "San Pedro de Huaca"],
                                            chimborazo: ["Riobamba", "Alausí", "Chambo", "Chunchi", "Colta", "Cumandá", "Guamote", "Guano", "Pallatanga", "Penipe"],
                                            cotopaxi: ["Latacunga", "La Maná", "Pangua", "Pujilí", "Salcedo", "Saquisilí", "Sigchos"],
                                            oro: ["Machala", "Arenillas", "Atahualpa", "Balsas", "Chilla", "El Guabo", "Huaquillas", "Las Lajas", "Marcabelí", "Pasaje", "Piñas", "Portovelo", "Santa Rosa", "Zaruma"],
                                            esmeraldas: ["Esmeraldas", "Atacames", "Eloy Alfaro", "Muisne", "Quinindé", "Rioverde", "San Lorenzo"],
                                            galápagos: ["San Cristóbal", "Isabela", "Santa Cruz"],
                                            guayas: ["Guayaquil", "Alfredo Baquerizo Moreno", "Balao", "Balzar", "Colimes", "Daule", "Durán", "El Empalme", "El Triunfo", "General Antonio Elizalde", "Isidro Ayora", "Lomas de Sargentillo", "Marcelino Maridueña", "Milagro", "Naranjal", "Naranjito", "Nobol", "Palestina", "Pedro Carbo", "Playas", "Salitre", "Samborondón", "Santa Lucía", "Simón Bolívar", "Yaguachi"],
                                            imbabura: ["Ibarra", " Antonio Ante", "Cotacachi", " Otavalo", "Pimampiro", "San Miguel de Urcuquí"],
                                            loja: ["Loja", "Calvas", "Catamayo", "Celica", "Chaguarpamba", "Espíndola", "Gonzanamá", "Macará", "Olmedo", "Paltas", "Pindal", "Puyango", "Quilanga", "Saraguro", "Sozoranga", "Zapotillo"],
                                            losríos: ["Babahoyo", "Baba", "Buena Fe", "Mocache", "Montalvo", "Palenque", "Puebloviejo", "Quevedo", " Quinsaloma", "Urdaneta", "Valencia", "Ventanas", "Vinces"],
                                            manabí: ["Portoviejo", "24 de Mayo", "Bolívar", "Chone", "El Carmen", " Flavio Alfaro", "Jama", "Jaramijó", "Jipijapa", "Junín", "Manta", "Montecristi", "Olmedo", "Paján", "Pedernales", "Pichincha", "Puerto López", " Rocafuerte", "San Vicente", "Santa Ana", "Sucre", " Tosagua"],
                                            moronasantiago: ["Morona", " Gualaquiza", "Huamboya", "Limón Indanza", "Logroño", "Pablo Sexto", "Palora", "San Juan Bosco", "Santiago de Méndez", "Sucúa", "Taisha", "Tiwintza"],
                                            napo: ["Tena", "Archidona", "Carlos Julio Arosemena Tola", "El Chaco", "Quijos"],
                                            orellana: ["Francisco de Orellana", "Aguarico", "La Joya de los Sachas", "Loreto"],
                                            pastaza: ["Pastaza", "Arajuno", "Mera", "Santa Clara"],
                                            pichincha: [" Quito", "Cayambe", "Mejía", "Pedro Moncayo", " Pedro Vicente Maldonado", "Puerto Quito", " Rumiñahui", "San Miguel de los Bancos"],
                                            santaElena: ["Santa Elena", "La Libertad", "Salinas"],
                                            santodomingo: ["Santo Domingo", "La Concordia"],
                                            sucumbíos: ["Lago Agrio", "Cascales", "Cuyabeno", "Gonzalo Pizarro", "Putumayo", "Shushufindi", "Sucumbíos"],
                                            tungurahua: ["Ambato", " Baños", "Cevallos", "Mocha", "Patate", "Pelileo", "Quero", "Santiago de Píllaro", "Tisaleo"],
                                            zamorachinchipe: ["Zamora", "Centinela del Cóndor", "Chinchipe", "El Pangui", "Nangaritza", "Palanda", " Paquisha", "Yacuambi", "Yantzaza"]

                                        }

                                        var provincias = document.getElementById('Provincia');
                                        var pueblos = document.getElementById('canton');
                                        var provinciaSeleccionada = provincias.value;

                                        // Se limpian los pueblos
                                        pueblos.innerHTML = '<option value="">Seleccione un canton...</option>'

                                        if (provinciaSeleccionada !== '') {
                                            // Se seleccionan los pueblos y se ordenan
                                            provinciaSeleccionada = listaPueblos[provinciaSeleccionada]
                                            provinciaSeleccionada.sort()

                                            // Insertamos los pueblos
                                            provinciaSeleccionada.forEach(function (pueblo) {
                                                let opcion = document.createElement('option');
                                                opcion.value = pueblo;
                                                opcion.text = pueblo;
                                                pueblos.add(opcion);
                                            });
                                        }

                                    }
                                    function validaNumericos(event) {
                                        if (event.charCode >= 48 && event.charCode <= 57) {
                                            return true;
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
                                    function validar() {
                                        var cad = document.getElementById("txt-ced").value.trim();
                                        var total = 0;
                                        var longitud = cad.length;
                                        var longcheck = longitud - 1;

                                        if (cad !== "" && longitud === 10) {
                                            for (i = 0; i < longcheck; i++) {
                                                if (i % 2 === 0) {
                                                    var aux = cad.charAt(i) * 2;
                                                    if (aux > 9)
                                                        aux -= 9;
                                                    total += aux;
                                                } else {
                                                    total += parseInt(cad.charAt(i)); // parseInt o concatenará en lugar de sumar
                                                }
                                            }

                                            total = total % 10 ? 10 - total % 10 : 0;

                                            if (cad.charAt(longitud - 1) == total) {
                                            } else {
                                                alert("LA CEDULA NO EXISTE O ES INCORRECTA");
                                                document.getElementById("txt-ced").value = "";
                                            }
                                        }
                                    }
                                    function mayus(e) {
                                        e.value = e.value.toUpperCase();
                                    }
                                    function sendmail() {

                                        var email = $('#email').val();
                                        var subject = $('#user').val();
                                        var message = $('#pass').val();
                                        var email1 = 'http://localhost:8084/WebAPP/index.jsp';
                                        // var body = $('#body').val();

                                        var Body = '<br>LINK DE LA APLICACION ' + email1 + '<br>El Usuario creado es: ' + subject + '<br>Su Password es:' + message;
                                        //console.log(name, phone, email, message);
                                        Email.send({
                                            SecureToken: "b8dcb77b-e238-4e7a-bab3-76f2bbb708c0",
                                            To: email,
                                            From: "sistemaminerogestion@gmail.com",
                                            Subject: "New message de Empresa Cruz Minera ",
                                            Body: Body
                                        }).then(
                                                message => {
                                                    //console.log (message);
                                                    if (message == 'OK') {
                                                        alert('Email enviado con datos del personal.');
                                                        location.href = "index.jsp"
                                                    } else {
                                                        console.error(message);
                                                        alert('Error. No se ha enviado. ')

                                                    }

                                                }
                                        );
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
    <script src="js/pais.js"></script>
    <script src="js/JQuery.js" type="text/javascript"></script>  
</html>
