
$(document).ready(function ()
{
    getQueryVariable();
});


function getQueryVariable() {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");
    
    }
   
}



