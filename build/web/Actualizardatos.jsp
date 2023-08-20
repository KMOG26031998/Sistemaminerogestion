<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" > 
        <link href="css/Actualizardatospostulante.css" rel="stylesheet" type="text/css"/>
    <a href="../src/java/DAO/Buscadorpostulantecontr.java"></a>
    <title>SISTEMA DE GESTION DE PERSONAL - EMPRESA MINERA </title>
</head>
<body onload="cargarProvincias()">
    <header id="header" style=" background: #007653 !important;">
        <a class="logo" href="Principal.jsp">
            
        </a>
        <a class="logo" id="ulUserData" href="index.html"></a> 
    </header>  
    <div class="div-head-tittle"><h2></h2></div>
    <form class="form1" action="ActPostulante " method="POST" style="margin-top:30px">
        <section class="sec-main">
            <div class="div-cont-main">
                <div class="div-cont-ced">
                    <input type="button" id="btn-actionbu" class="inp-search" value="Buscar"/>
                    <input type="text" id="txt-cedee" class="inp-ced" onkeypress='return validaNumericos(event)' placeholder="Cédula" name="cedula" maxlength="15"/>
                </div>  
                <hr />
                <div class="div-cont-ced">
                    <input type="button" id="btn-actionbusc" class="inp-search" value="Buscar"/></th>
                    <input style='width: 40%' type="text" id="txt-nameaz" class="inp-name" placeholder="Nombres" name="PrimerNombre"   onkeypress="return soloLetras(event)" onkeyup="mayus(this);"/>
                    <p></p>
                    <input style='width: 40%; margin-left:5%;'  type="text" id="txt-lnamesegaz" class="inp-lname" placeholder="Apellidos" name="SegundoNombre" onkeypress="return soloLetras(event)" onkeyup="mayus(this);"/>
                </div> 
                <hr />
                <table style='width: 100%; text-align: center; margin-left: 20px; margin-top: 30px'>
                    <thead >
                        <tr>
                            <th>Primer Nombre</th>
                            <th>Segundo Nombre</th>
                            <th>Primer Apellido</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><div class="div-cont-name"><input type="text" id="txt-namea" class="inp-name" placeholder="Primer Nombre" name="PrimerNombres" required=""  onkeypress="return soloLetras(event)" onkeyup="mayus(this);"/></div></td>
                            <td><div class="div-cont-lname"><input type="text" id="txt-lnamesega" class="inp-lname" placeholder="Segundo Nombre" name="SegundoNombres"required=""  onkeypress="return soloLetras(event)" onkeyup="mayus(this);"/></div></td>
                            <td><div class="div-cont-name"><input type="text" id="txt-nameapa" class="inp-name" placeholder="Primer Apellido" name="PrimerApellidos"required=""  onkeypress="return soloLetras(event)" onkeyup="mayus(this);"/></div></td>
                        </tr>
                    </tbody>
                    <thead >
                        <tr>
                            <th>Segundo Apellido</th>
                            <th>Fecha de Nacimiento</th> 
                            <th>Telefono Convencional</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>

                            <td><div class="div-cont-lname"><input type="text" id="txt-lnamesp2" class="inp-lname" placeholder="Segundo Apellido" name="SegundoApellidos"required=""  onkeypress="return soloLetras(event)" onkeyup="mayus(this);"/></div></td>
                            <td><div class="div-cont-lname"><input type="date" id="txt-lnamefa" class="inp-lname" placeholder="Fecha de nacimiento"required=""  name="Fechadenacimiento"/></div></td> 
                            <td><div class="div-cont-lname"><input type="text" id="txt-lnametca" class="inp-lname" placeholder="Telefono Convencional" name="convencional"required=""  onkeypress='return validaNumericos(event)'/></div></td>
                        </tr>
                    </tbody>
                    <thead >
                        <tr>
                            <th>Celular</th>
                            <th>Provincia</th>
                            <th>Parroquia</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><div class="div-cont-edad"><input type="text" id="txt-celua" class="inp-edad" placeholder="Celular" name="celular"required=""  onkeypress='return validaNumericos(event)'/></div> </td>                      
                            <td><div class="div-cont-sel-dep-to-transf" ><select class="sel-dep-to-transf"  name="Provincia" onchange="cargarPueblos();" id="txt-provinciaa" >
                                        <option>Seleccione una provincia</option>
                                    </select></div></td> 
                            <td><div class="div-cont-lname"><input type="text" id="txt-lnamepara" class="inp-lname" placeholder="Parroquia"required=""  name="parroquia" onkeypress="return soloLetras(event)" onkeyup="mayus(this);"/></div></td> 
                        </tr> 
                    </tbody>
                    <thead >
                        <tr>                                
                            <th>Direccion</th>                               
                            <th>Genero</th>
                            <th>Estado Civil</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr> 
                            <td><div class="div-cont-lname"><input type="text" id="txt-lnamedi" class="inp-lname" placeholder="Direccion"required=""  name="Direccion" onkeyup="mayus(this);"/></div></td> 
                            <td><div class="div-cont-sel-dep-to-transf"  ><select class="sel-dep-to-transf" name="genero"id="txt-lnamege">   
                                        <option>Seleccione genero</option>
                                        <option>Masculino</option>
                                        <option>Femenino</option></select></div></td> 
                            <td><div class="div-cont-sel-dep-to-transf"  ><select class="sel-dep-to-transf"required=""  name="estadoCivil"id="txt-lnamediec">
                                        <option>Seleccione el estado civil</option>
                                        <option>Soltero</option>
                                        <option>Casado</option>
                                        <option>Union libre</option>
                                        <option>Viudo</option>
                                        <option>Divorciado</option>
                                    </select></div></td>    
                        </tr>
                    </tbody>
                    <thead >
                        <tr>
                            <th>Carnet de Discapacidad</th>
                            <th>Nacionalidad</th>
                            <th>Discapacidad</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr> 

                            <td><div class="div-cont-sel-dep-to-transf"  ><select class="sel-dep-to-transf"required=""  name="Ayuda" id="txt-lnameayu">
                                        <option>Tiene carnet de discapacidad</option>
                                        <option>Si</option>
                                        <option>No</option>
                                    </select></div></td>
                            <td><div class="div-cont-lname" ><input type="text" id="nacionalidad" class="inp-lname" placeholder="nacionalidad" required="" value="Ecuatoriana" name="nacionalidad" onkeyup="mayus(this);"/></div></td>
                            <td><div class="div-cont-lname"><input type="text" id="txt-lnamedis" class="inp-lname" placeholder="Discapacidad"required=""  name="discapacidad" onkeyup="mayus(this);"/></div></td>
                        </tr>
                    </tbody>
                    <thead >
                        <tr>
                            <th>Cargo</th>
                            <th>Correo Electronico</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><div class="div-cont-lname"><input type="text" id="txt-lnametiposangre" class="inp-lname" placeholder="cargo"required="" name="cargo" onkeyup="mayus(this);"/> </div></td> 
                            <td><div class="div-cont-lname"><input type="email" id="txt-lnamecorreo" class="inp-lname" placeholder="correo electronico"required="" name="email"/> </div></td> 
                            <td><div style='margin-top: -20px !important;'class="div-cont-lname"><input type="submit" id="btn-action" class="btn-accept" value="Guardar"/> </div></td>
                        </tr>
                    </tbody>
                </table>          
            </div>
        </section>
    </form>        
</body>
<footer></footer>
<script src="js/pais.js"></script>
<script src="js/JQuery.js" type="text/javascript"></script> 
<script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
<script src="js/JQuery.js" type="text/javascript"></script> 
<script src="js/Actualizarpaciente.js" type="text/javascript"></script> 
<script src="js/newjavascript.js" type="text/javascript"></script>
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

                                    tecla_especial = false;
                                    for (var i in especiales) {
                                        if (key === especiales[i]) {
                                            tecla_especial = true;
                                            break;
                                        }
                                    }

                                    if (letras.indexOf(tecla) === -1 && !tecla_especial)
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

                                        if (cad.charAt(longitud - 1) === total) {
                                        } else {
                                            alert("LA CEDULA NO EXISTE O ES INCORRECTA");
                                            document.getElementById("txt-ced").value = "";
                                        }
                                    }
                                }
                                function mayus(e) {
                                    e.value = e.value.toUpperCase();
                                }
                                function verificarCedula(cedula) {
                                    if (typeof (cedula) === 'string' && cedula.length === 10 && /^\d+$/.test(cedula)) {
                                        var digitos = cedula.split('').map(Number);
                                        var codigo_provincia = digitos[0] * 10 + digitos[1];

                                        //if (codigo_provincia >= 1 && (codigo_provincia <= 24 || codigo_provincia == 30) && digitos[2] < 6) {

                                        if (codigo_provincia >= 1 && (codigo_provincia <= 24 || codigo_provincia === 30)) {
                                            var digito_verificador = digitos.pop();

                                            var digito_calculado = digitos.reduce(
                                                    function (valorPrevio, valorActual, indice) {
                                                        return valorPrevio - (valorActual * (2 - indice % 2)) % 9 - (valorActual === 9) * 9;
                                                    }, 1000) % 10;
                                            return digito_calculado === digito_verificador;
                                        }
                                    }
                                    return false;
                                }
</script>
</html>