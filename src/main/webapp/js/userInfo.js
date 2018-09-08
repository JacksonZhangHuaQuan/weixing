


$(function () {
    //判断用户是否登录
    $.ajax({
        url: "/getSession",
        type: "post",
        data: {"sessionid": "sessionkey"},
        dataType: "json",
        success: function (ret) {
            if (ret[0] == null) {
                layer.alert("您没有登录，将自动跳转到登录页面！");
                $("#addStrategy").hide();
                setTimeout('parent.window.location="../login.html"',5000)
            } else {

            }
        }, error: function (a, b, c) {
            layer.alert(a.responseText);
        }
    });
});

$(function () {




    $(".message_left_Info").mouseover(function () {
        $(this).css("background","#A2526D");

    }).mouseout(function () {
        $(this).css("background","#8DA7C2");
    })
    $(".message_left_Info").click(function () {
        $("iframe").prop("src","AccountInfo.html");
        $(this).css("background","#8DA7C2");
    });



    $(".message_left_editInfo").mouseover(function () {
        $(this).css("background","#A2526D");
    }).mouseout(function () {
        $(this).css("background","#8DA7C2");
    })
    $(".message_left_editInfo").bind("click",function () {
        $("iframe").prop("src","editInfo.html");
        $(this).css("background","#A2526D");
    });


    $(".message_left_address").mouseover(function () {
        $(this).css("background","#A2526D");
    }).mouseout(function () {
        $(this).css("background","#8DA7C2");
    })
    $(".message_left_address").click(function () {
        $("iframe").prop("src","WhereInfo.html");
    }),

        $(".message_left_play").mouseover(function () {
            $(this).css("background","#A2526D");
        }).mouseout(function () {
            $(this).css("background","#8DA7C2");
        })
    $(".message_left_play").click(function () {
        $("iframe").prop("src","playInfo.html");
    }),


    $(".message_left_share").mouseover(function () {
        $(this).css("background","#A2526D");
    }).mouseout(function () {
        $(this).css("background","#8DA7C2");
    })
    $(".message_left_share").click(function () {
        $("iframe").prop("src","ShareInfo.html");

    }),
        $(".message_left_write").mouseover(function () {
            $(this).css("background","#A2526D");
        }).mouseout(function () {
            $(this).css("background","#8DA7C2");
        })
    $(".message_left_write").click(function () {
        $("iframe").prop("src","StrategyForm.html");

    });


    //当页面出现时，文本框颜色变为红色

    //表单验证
    $("#message_right_content_form").validate( {
        onsubmit:true,// 是否在提交时验证
        onfocusout: function(element) { $(element).valid(); },
        onkeyup: function(element) { $(element).valid(); },
        rules:{
          user_pet_name :{
              required:true,
              minlength:5,
              maxlength:10,
          },
            user_phone:{
              required:true,
                number:true,
                minlength:11,
                 isPhone:true,
            },
            introduce:{
              required:true,
            }
        },
        messages:{
            user_pet_name:{
                required:"请输入昵称",
                minlength:"最少五位",
                maxlength:"最多由10位组成",

            },
            user_phone:{
                required:"请输入电话号码",
                number:"请输入有效的电话号码",
                minlength:"由11位组成",
                isPhone:"请输入符合格式的电话号码"
            },
            introduce:{
                required:"请输入信息"
            },

        },


    });
});