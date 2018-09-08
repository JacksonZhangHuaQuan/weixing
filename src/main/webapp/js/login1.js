
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



$(function () {

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

    jQuery.validator.addMethod("isPhone", function(value, element) {
        var length = value.length;
        var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "请填写正确的手机号码");//可以自定义默认提示信息


    $("#form2").validate({
        onsubmit:true,// 是否在提交时验证
        // onfocusout:false,// 是否在获取焦点时验证
        // onkeyup :false,// 是否在敲击键盘时验证
        onfocusout: function(element) { $(element).valid(); },
        onkeyup: function(element) { $(element).valid(); },

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
                minlength:4,
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
                minlength:"用户名长度不能小于4位",
                maxlength:"用户名长度不能超过20位",
            },
            confirm: {
                required: "请输输入一致密码",
                equalTo: "输入密码不一致"
            }




        }

    });

    $("#form1").validate({
        onsubmit:true,// 是否在提交时验证
        // onfocusout:false,// 是否在获取焦点时验证
        // onkeyup :false,// 是否在敲击键盘时验证
        onfocusout: function(element) { $(element).valid(); },
        onkeyup: function(element) { $(element).valid(); },


        rules: {　　　　//规则
            password: {
                required: true,
                minlength:6,
                maxlength:20,

            },
            username: {
                required: true,
                minlength:4,
                maxlength:20,
            }
        },
        messages:{　　　　//验证错误信息

            password: {
                required: "请输入密码",
                minlength:"密码长度不能小于4位",
                maxlength:"密码长度不能超过20位",
            },
            username: {
                required: "请输入用户名",
                minlength:"用户名长度不能小于4位",
                maxlength:"用户名长度不能超过20位",
            }

        }

    });

});

