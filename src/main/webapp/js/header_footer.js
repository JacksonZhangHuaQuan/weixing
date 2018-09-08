
$(function(){
    //滚动事件
    $(window).scroll(function(){
        headerInit();
    });

    function headerInit(){
        if($(this).scrollTop()>0){
            $("body").addClass("fiexed-header-on");
        }else{
            $("body").removeClass("fiexed-header-on");
        }
    }

    headerInit();

    $(".main_show_address").hover(function(){
        $("#menu_destination").show();
    },function(){
        $("#menu_destination").hide()
    });

    $(".main_show_season").hover(function(){
        $("#menu_product").show();
    },function(){
        $("#menu_product").hide()
    });

    $("#menu_destination").hover(function(){
        $("#menu_destination").show();
    },function(){
        $("#menu_destination").hide()
    });

    $("#menu_product").hover(function(){
        $("#menu_product").show();
    },function(){
        $("#menu_product").hide()
    });

});