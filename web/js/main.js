$(document).ready(function()
{
   $("#PaginaMedi").click(function()
   {
        window.location.href = "./Asistencia.jsp?user="+document.getElementById("usuario").innerHTML;
       
   }); 
});



let modal = document.getElementById('miModal');
let flex = document.getElementById('flex');
let abrir = document.getElementById('abrir');
let cerrar = document.getElementById('close');

abrir.addEventListener('click', function(){
    modal.style.display = 'block';
});

cerrar.addEventListener('click', function(){
    modal.style.display = 'none';
});

window.addEventListener('click', function(e){
    console.log(e.target);
    if(e.target == flex){
        modal.style.display = 'none';
    }
});