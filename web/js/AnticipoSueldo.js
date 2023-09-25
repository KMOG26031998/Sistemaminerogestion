$(document).ready(function () {

    $("#btn-actionr").click(function () {

        window.location.href = "./Asistencia.jsp?user=" + getQueryVariableRe();
    });
});

function getQueryVariableRe() {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");
        console.log(pair[1].toString());
        return pair[1].toString();
    }
}
var postulante_id;
var personal_id;
var personal_dni;

$(function () {
    $('#btn-buscarpostulante').click(function (e) {
        buscadorpostulantenew();
    });
  const buscadorpostulantenew = () => {

        var dato = {
            cedula: document.getElementById("txt-ced").value 
        };
        console.log(dato);
        $.ajax({
            cache: false,
            type: "POST",
            url: "./BckPersonal1",
            data: dato,
            dataType: 'json',
            error: function (request, status, error)
            { 
                  console.log(request, status, error);
            },
            success: function (data)
            {
                console.log(data);
                $("#txt-namep").val(data.postulante); 
                $("#txt-nameme").val(data.personal); 
                
                $("#txt-personal-id").val(data.personal_id); 
                $("#txt-postulante-id").val(data.postulante_id); 
                
                renderAsistencias(data.postulante_id);
                
               postulante_id=data.postulante_id;
               personal_id=data.personal_id;
               personal_dni=data.personal_dni;
                
            }
        });
    };
    
    const renderAsistencias = (postulante_id) => {
        $.ajax({
            cache: false,
            type: "POST",
            url: "./BuscadorAnticipoController",
            data: {postulante_id: postulante_id},
            dataType: 'json',
            error: function (request, status, error)
            {
                alert(request, status, error);
            },
            success: function (data)
            {
                console.log(data);
                
                $("#body_asistencias").html("");
                var output = ``;
                for(var i = 0; i < data.length; i++) {
                    //porc_div = porc_div + 15;
                    //divv.style.marginTop= porc_div + "px";
                    output += `
                        <tr>
                            <td>${i + 1}</th>
                            <td>${data[i].fecha}</th>
                            <td>${data[i].actividadobservacion}</th>
                            <td> <input type="button" class="agre" value="Modificar" onclick="modificar(` + i + `)"> </td>
                            <td> <button type="button" class="elimar" onclick="eliminar(` + i + `)">Eliminar</button> </td>
                        </tr>
                        `;
                }
                $("#body_asistencias").append(output);
                
            }
        });
    };
});

$(function () {
    $('#btn-actionb').click(function (e) {
        buscador();
    });
    const buscador = () => {

        var cedula = document.getElementById("txt-cede").value;
        $.ajax({
            cache: false,
            type: "POST",
            url: "Controllerbuscarpostulante",
            data: {cedula: cedula},
            dataType: 'json',
            error: function (request, status, error)
            {
                alert(request, status, error);
            },
            success: function (data)
            {
                console.log(data);
                $("#txt-cedi").val(data.postulante_dni);
                $("#txt-namen").val(data.postulante_primer_segundo_nombre);
                $("#txt-lnamea").val(data.postulante_primer_segundo_apellido);
                $("#txt-namef").val(data.postulante_grupo);
                $("#txt-lnamet").val(data.postulante_convencional);
                $("#txt-cel").val(data.postulante_telefono);
                $("#txt-provin").val(data.postulante_provincia);
                $("#txt-direccion").val(data.postulante_direccion);
                $("#txt-genero").val(data.postulante_genero);
                $("#txt-ayudaeconomica").val(data.postulante_ayudasocial);
                $("#txt-nacionalidad").val(data.postulante_nacionalidad);
                $("#txt-tiposangre").val(data.postulante_correoelectronico);
            }

        });
    };
});

//Datos del postulante
var ideusuario;
var ideadministrador;
function buscador1() {

    var cedu = document.getElementById("txt-ced").value;

    $.ajax({
        cache: false,
        type: "POST",
        url: "./BckPersonal1",
        data: {cedula: cedu, op: "1"},
        dataType: 'json',
        error: function (request, status, error)
        {
            console.log(request, status, error);
        },
        success: function (data)
        {
            console.log(data.nombrescompleto.toString());
            var cadena = data.nombrescompleto.split("-");
            document.getElementById("txt-namep").value = cadena[0];
            ideusuario = cadena[1];
        }

    });
}
function validaNumericosA(event)
{
    if (event.charCode >= 48 && event.charCode <= 57)
    {
        return true;
    }
    if (event.charCode === 13)
    {

        buscador1();
    }
    return false;
}
//datos personal
function useradministrador() {

    var user = getQueryVariableRe();
    $.ajax({
        cache: false,
        type: "POST",
        url: "./NewServle",
        data: {user: user, op: "2"},
        dataType: 'json',
        error: function (request, status, error)
        {
            console.log(request, status, error);
        },
        success: function (data)
        {
            console.log(data.nombrespersonal.toString()); 
            var cadena = data.nombrepersonal.split("-");
            document.getElementById("txt-nameme").value = cadena[0];
            idepersonal = cadena[1];

        }

    });
}
$("#btn-addasistencia").click(function (e) {
    e.preventDefault();
    var table = document.getElementById('tabla');
    var rowLength = table.rows.length;
    var jsonAll = [];
    for (var i = 1; i < rowLength; i += 1) {
        var row = table.rows[i];
        var jsoncell = {
            actividad: row.cells[1].innerHTML,
            observacion: row.cells[2].innerHTML
        };
        jsonAll[i - 1] = jsoncell;
    }
    $.ajax({
        cache: false,
        url: "./NewServle",
        data: {personalid: idepersonal, postulanteid: ideusuario, dt: JSON.stringify(jsonAll).toString(), op: "3"},
        type: "POST",
        error: function (request, status, error)
        {
            alert(request, status, error);
        },
        success: function (data)
        {
            console.log(data);
            limpiar1();
        }
    });
});
function limpiar1()
{
    document.getElementById("tabla").innerHTML = "";
}