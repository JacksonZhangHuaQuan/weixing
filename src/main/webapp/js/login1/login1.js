
function cambiar_login() {
    document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";
    document.querySelector('.cont_form_login').style.display = "block";
    document.querySelector('.cont_form_sign_up').style.opacity = "0";

    setTimeout(function(){  document.querySelector('.cont_form_login').style.opacity = "1"; },400);

    setTimeout(function(){
        document.querySelector('.cont_form_sign_up').style.display = "none";
    },200);
}

function cambiar_sign_up(at) {
    document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_sign_up";
    document.querySelector('.cont_form_sign_up').style.display = "block";
    document.querySelector('.cont_form_login').style.opacity = "0";

    setTimeout(function(){  document.querySelector('.cont_form_sign_up').style.opacity = "1";
    },100);

    setTimeout(function(){   document.querySelector('.cont_form_login').style.display = "none";
    },400);


}



function ocultar_login_sign_up() {

    document.querySelector('.cont_forms').className = "cont_forms";
    document.querySelector('.cont_form_sign_up').style.opacity = "0";
    document.querySelector('.cont_form_login').style.opacity = "0";

    setTimeout(function(){
        document.querySelector('.cont_form_sign_up').style.display = "none";
        document.querySelector('.cont_form_login').style.display = "none";
    },500);

}

function changeImg() {
    var imgSrc = $("#imgObj");
    var src = imgSrc.attr("src");
    imgSrc.attr("src", chgUrl(src));
}
// 时间戳
// 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
function chgUrl(url) {
    var timestamp = (new Date()).valueOf();
    url = url.substring(0, 20);
    if ((url.indexOf("&") >= 0)) {
        url = url + "×tamp=" + timestamp;
    } else {
        url = url + "?timestamp=" + timestamp;
    }
    return url;
}


var  yz=0;//验证状态
//验证码
     function yanzheng() {
         $.ajax({
             url: "/checkCode",
             type: "get",
             data: {"code": $("#form3 input[name='code']").val()},
             dataType: "text",
             success: function (ret) {
                 if (ret == "0") {
                    yz=1;//验证通过

                 } else if (ret == "1") {
                    yz=2;//验证码输入错误
                     layer.msg("验证码输入错误");
                     // location.reload();
                 }
                 else if (ret == "2") {
                     yz=3;//未输入验证码
                    layer.msg("请输入验证码")
                 }
                 else {
                  alert(12);
                 }
             // }, error: function (a, b, c) {
             //     alert(a.status);
             //     alert(a.readyState);
             //     alert(a.responseText);
             //     alert(c);
             }
         })
     }

    // })

// })
$(function () {

    jQuery.validator.addMethod("isPhone", function(value, element) {
        var length = value.length;
        var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "请填写正确的手机号码");//可以自定义默认提示信息

    jQuery.validator.setDefaults({
        debug: true,
        errorElement: 'div',
        errorPlacement: function(error, element) {
            if ($(element).parent().hasClass('datetimepicker')) {
                error.css('font-family','正楷');
                error.css('color','red');
                error.css('font-size','10px');
                error.css('height','10px');
                error.insertAfter(element.parent());

            } else {
                error.css('font-family','正楷');
                error.css('color','red');
                error.css('font-size','10px');
                error.css('height','10px');
                error.insertAfter(element);
            }
        }
    });
    $("#form2").validate({
        // onsubmit:true,// 是否在提交时验证
        // onfocusout:false,// 是否在获取焦点时验证
        onkeyup :false,// 是否在敲击键盘时验证
        onfocusout: function(element) { $(element).valid(); },
        // onkeyup: function(element) { $(element).valid(); },

        rules: {　　　　//规则
            phone: {//手机号验证
                required: true,
                isPhone:true,
            },
            password2: {
                required: true,
                minlength:6,
                maxlength:20,

            },
            username: {
                required: true,
                minlength:2,
                maxlength:20,
            },
            confirm: {
                required: true,
                equalTo: "input[name='password2']"
            }
        },
        messages:{　　　　//验证错误信息
            phone: {
                required: "请输入手机号"
            },
            password2: {
                required: "请输入密码",
                minlength:"密码长度不能小于6位",
                maxlength:"密码长度不能超过20位",
            },
            username: {
                required: "请输入用户名",
                minlength:"用户名长度不能小于2位",
                maxlength:"用户名长度不能超过20位",
            },
            confirm: {
                required: "请输输入一致密码",
                equalTo: "输入密码不一致"
            }
        },
        submitHandler: function(form) { //通过之后回调
            // 进行ajax传值
            // $("#form2 input[type='submit']").click(function (e) {
            //     e.preventDefault();

                yanzheng();
                if (yz==1) {
                    $.ajax({
                        url:"/addNewUser",
                        async:"true",
                        type:"post",
                        data: {"phone":$("#form2 input[name='phone']").val(),"username":$("#form2 input[name='username']").val(),"password":$("#form2 input[name='password2']").val()},
                        dataType:"json",
                        success:function (ret) {
                            if(ret==-1){
                                layer.msg("该手机号已经注册", {time:2000});

                            }else if(ret==9){
                                layer.msg("注册成功，请登录", {time:2000});
                                setTimeout("window.location.reload()",2000);

                            }
                            else {
                                layer.msg("注册失败,请重试！",{time:2000});
                            }
                        }
                    })
                }
                else if(yz==2){

                } else if(yz==3){

                }

            // })

        },
        invalidHandler: function(form, validator) {return false;}

    });

    $("#form1").validate({
        onsubmit:true,// 是否在提交时验证
        // onfocusout:false,// 是否在获取焦点时验证
        onkeyup :false,// 是否在敲击键盘时验证
        onfocusout: function(element) { $(element).valid(); },
        // onkeyup: function(element) { $(element).valid(); },

        rules: {　　　　//规则
            password: {
                required: true,
                minlength:6,
                maxlength:20,

            },
            phone: {
                required: true,
                isPhone:true,
            }
        },
        messages:{　　　　//验证错误信息

            password: {
                required: "请输入密码",
                minlength:"密码长度不能小于6位",
                maxlength:"密码长度不能超过20位",
            },
            phone: {
                required: "请输入注册手机号",
            }

        },
        submitHandler: function(form1) { //通过之后回调
            //进行ajax传值
            // $("#form1 input[type='submit']").click(function (e) {
            //     e.preventDefault();
            // alert("开始验证");i8iu
            yanzheng();
            if(yz==1){
                $.ajax({
                    url:"/loginServlet",
                    type:"post",
                    data: {"phone":$("#form1 input[name='phone']").val(),"password":$("#form1 input[name='password']").val()},
                    dataType:"json",
                    success:function (ret) {
                        if(ret=="1"){
                            layer.msg("用户不存在或密码错误", {time:2000});

                        } else if(ret=="3"){
                            layer.msg("账户锁定中额喔");
                        } else if(ret){
                              // layer.msg("登录成功", {time:1000});
                            setTimeout("javascript:window.location.href='weixing.html'",1000);
                        }else{
                            layer.msg("服务器正忙，请稍后重试", {time:2000});
                        }
                    }
                    // ,error:function (a,b,c) {
                    //     alert(a.responseText);
                    //     alert(a.status);
                    //     alert(c);
                    // }
                })
            }else if(yz==2){
            }else if(yz==3){
            }


            // })

        },
        invalidHandler: function(form, validator) {return false;}

    });



})

