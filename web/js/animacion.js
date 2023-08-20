$(document).ready(function () {
    $(".animadoagregarinformacion").hover(function () {
        $(".content",this).css({
             "transition": ".5s",
            "transform": "scale(1.1,1.1)"
        });
    },function(){
        $(".content",this).css({
             "transition": ".5s",
            "transform": "scale(1,1)"
        });
    });    
});





