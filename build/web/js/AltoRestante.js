$(document).ready(function () {    
    var height_win = $(window).height();    
    var header = $(".nav-tp").height();    
    var div_tittle = $(".div-head-tittle").height();        
    var AddHg = header + div_tittle;      
    var TotalHg = height_win - AddHg;                
    //alert(TotalHg);
    //$(".sec-main").height(T);
});