$(function () {
    $('#btn-actionbu').click(function (e) {
        buscadoract();
    });
    const buscadoract = () => {

        var cedul = document.getElementById("txt-cedee").value;
        $.ajax({
            cache: false,
            type: "POST",
            url: "Buscadorpostulanteactualizar",
            data: {cedul: cedul},
            dataType: 'json',
            error: function (request, status, error)
            {
                alert(request, status, error);
            },
            success: function (data)
            {
                console.log(data);
                $("#txt-tipoca").val(data.postulante_tipo_dni);
                $("#txt-ceda").val(data.postulante_dni);               
                $("#txt-namea").val(data.postulante_primernombre);
                $("#txt-lnamesega").val(data.postulante_segundonombre);
                $("#txt-nameapa").val(data.postulante_primerapellido);
                $("#txt-lnamesp2").val(data.postulante_segundoapellido);
                $("#txt-lnamefa").val(data.postulante_fechanacimiento);
                $("#txt-lnametca").val(data.postulante_convencional);
                $("#txt-celua").val(data.postulante_telefono);
                $("#txt-provinciaa").val(data.postulante_provincia);
                $("#txt-cantonn").val(data.postulante_canton);
                $("#txt-lnamepara").val(data.postulante_parroquia);
                $("#txt-lnamedi").val(data.postulante_direccion);
                $("#txt-lnamege").val(data.postulante_genero);
                $("#txt-lnamediec").val(data.postulante_estadocivil);
                $("#txt-lnameayu").val(data.postulante_ayudasocial);
                $("#nacionalidad").val(data.postulante_nacionalidad);
                $("#txt-lnamedis").val(data.postulante_grupo);                
                $("#txt-lnametiposangre").val(data.postulante_tiposangre);
                $("#txt-lnamecorreo").val(data.postulante_correoelectronico);
            }

        });
    };
});

