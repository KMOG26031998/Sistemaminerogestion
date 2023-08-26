$(document).ready(function () {
    $('#btn-action').click(function () {
        validar();
    });
});

var filaMetodo;
var aumento = 0;


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
    document.getElementById("txt-lnamem").value = "";
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
            /* aumento--;
             if (document.getElementById("tabla").rows.length === 0)
             {
             aumento = 0;
             alert("de nuevo");
             }*/
        }
    }
}

function modificar(id)
{
    for (var i = 0; i < document.getElementById("tabla").rows.length; i++)
    {
        if (document.getElementById("tabla").rows[i].cells[0].innerHTML.trim() === id.toString())
        {
            document.getElementById("txt-lnamem").value = document.getElementById("tabla").rows[i].cells[1].innerHTML;
            document.getElementById("txt-namei").value = document.getElementById("tabla").rows[i].cells[2].innerHTML;
            eliminar(id);
        }
    }
}