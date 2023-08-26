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

$(function () {
    $('#btn-actionbusc').click(function (e) {
        buscador();
    });
    const buscador = () => {

        var dato = {
            apellido: document.getElementById("txt-lnamesega").value,
            nombre: document.getElementById("txt-namea").value
        };
        $.ajax({
            cache: false,
            type: "POST",
            url: "Controllerbuscarnew",
            data: dato,
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
        url: "./NewServle",
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
            // $("#txt-namep").val(data.nombrescompletos);
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


 