$(document).ready(function () {
    $('#btn-addasistencia').click(function () {
        validar();
    });
});

var filaMetodo;
var aumento = 0; 

$(function () {
    $('#btn-buscarpostulante').click(function (e) {
        enlistarasistencia();
    });
    const enlistarasistencia = () => {

        var dato = {
            cedula: document.getElementById("txt-ced").value 
        };
        console.log(dato);
        $.ajax({
            cache: false,
            type: "POST",
            url: "./Addasistencia",
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
                
               postulante_id=data.postulante_id;
               personal_id=data.personal_id;
               personal_dni=data.personal_dni;
                
            }
        });
    };
});


function validar()
{
    if (document.getElementById("txt-lnamem").value.length > 0 && document.getElementById("txt-namei").value.length > 0) {
        tabla(document.getElementById("txt-lnamem").value, document.getElementById("txt-namei").value);
    } else {
        alert("LLENAR LOS CAMPOS");
    }
}
function tabla(parametroUno, parametroDos)
{
    filaMetodo = '<tr class="selected" id="fila' + aumento + '" onclick=""><td>' + aumento + '</td><td>'
            + parametroUno + '</td><td>' + parametroDos + '</td><td>' + "   \n\
<input type='button' class='agre' value='Modificar' onclick='modificar(" + aumento + ")'>" +
            '</td><td>' + "<button type=\"button\" class='elimar' onclick='eliminar(" + aumento + ")'>Eliminar</button>" + '</td></tr>';
    $('#tabla').append(filaMetodo);
    aumento++;
    limpiar();
}
function limpiar()
{
    document.getElementById("txt-lname").value = "";
    document.getElementById("txt-namei").value = "";
}
function eliminar(id)
{
    for (var i = 0; i < document.getElementById("tabla").rows.length; i++)
    {
        if (document.getElementById("tabla").rows[i].cells[0].innerHTML.trim() === id.toString())
        {
            var firstRow = document.getElementById("tabla");
            firstRow.deleteRow(i);
            
        }
    }
}

function modificar(id)
{
    for (var i = 0; i < document.getElementById("tabla").rows.length; i++)
    {
        if (document.getElementById("tabla").rows[i].cells[0].innerHTML.trim() === id.toString())
        {
            document.getElementById("txt-lname").value = document.getElementById("tabla").rows[i].cells[1].innerHTML;
            document.getElementById("txt-namei").value = document.getElementById("tabla").rows[i].cells[2].innerHTML;
            eliminar(id);
        }
    }
}