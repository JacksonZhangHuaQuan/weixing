// 评分
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
                setTimeout('parent.window.location="../login.html"',3000)
            } else {
                $("#user_id").val(ret[0].user_id);
            }
        }, error: function (a, b, c) {
            layer.alert(a.responseText);
        }
    });
});

var images = "";
layui.use('rate', function () {
    var rate = layui.rate;
    rate.render({
        elem: '#star'
        , value: 3
        , text: true
        , setText: function (value) { //自定义文本的回调
            var arrs = {
                '1': '再也不想去了'
                , '2': '差'
                , '3': '一般'
                , '4': '不错的旅行'
                , '5': '强烈推荐'
            };
            this.span.text(arrs[value] || (value + "星"));
        }, choose: function (value) {
            $("#star").next().val(value);
        }

    })

});
// 上传头图
layui.use('upload', function () {
    var upload = layui.upload;
    var uploadImg = upload.render({
        elem: '.uploadImg'
        , url: '/uploadFile'
        , done: function (res) {
            layer.msg('上传成功！');
            // $("#first_img").prop('disabled', true);
            var firstImg = res.data[0];
            $(".showFirstImg").show();
            $("#showFirstImg").attr("src", "../" + firstImg)
            $("input[name='first_img']").val(firstImg);
        }, error: function () {
            //请求异常回调
        }
    });
});
//上传图片
layui.use(['upload', 'laytpl', 'form'], function () {
    var $ = layui.jquery
        , upload = layui.upload
        , laytpl = layui.laytpl
    //批量删除 单击事件
    $('#dele_imgs').click(function () {
        $('#imgs input:checked').each(function (index, value) {
            var filename = $(this).parent().attr("filename");
            delete imgFiles[filename];
            $(this).parent().remove()
        });
    });


    var imgFiles;

    //多图片上传
    // 自定义
    var uploadInst = upload.render({
        elem: '#sele_imgs'  //开始
        , acceptMime: 'image/*'
        , url: '/uploadFile'
        , auto: false//不自动上传
        , bindAction: '#upload_imgs'//指定一个按钮触发上传
        , multiple: true
        , size: 1024 * 12//kb
        , number: 9
        , choose: function (obj) {  //选择图片后事件
            var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
            imgFiles = files;
            $('#upload_imgs').prop('disabled', false);
            //预览图片
            obj.preview(function (index, file, result) {
                var data = {
                    index: index,
                    name: file.name,
                    result: result
                };

                //将预览html 追加
                laytpl(img_template.innerHTML).render(data, function (html) {
                    $('#imgs').append(html);
                });

                //绑定单击事件
                $('#imgs div:last-child>img').click(function () {
                    var isChecked = $(this).siblings("input").prop("checked");
                    $(this).siblings("input").prop("checked", !isChecked);
                    return false;
                });


                $("#dele_imgs").click(function () {
                    if ($("#imgs").children().length == 0) {
                        $("#upload_imgs").prop("disabled", "disabled");
                    }
                })


            });
        }
        , before: function (obj) { //上传前回函数
            layer.load(); //上传loading
        }
        , done: function (res, index, upload) {    //上传完毕后事件
            layer.closeAll('loading'); //关闭loading
            //上传完毕
            layer.msg('上传成功！');
            images += res.data[0] + ",";
            $("input[name='images']").val(images);
            $("#showimg").text("已上传的图片：");
            $("#upload_imgs").hide();
            $("#dele_imgs").hide();
            $("#sele_imgs").hide();
            $("#imgs input[type='checkbox']").hide();
            return delete imgFiles[index]; //删除文件队列已经上传成功的文件
        }
        , error: function (index, upload) {
            layer.closeAll('loading');
        }
    });

});


$("body").on("click", ".closeMore", function () {
    $(this).closest("li").remove();
    layer.msg("删除成功！")
})
//时间线 添加更多描述
var $nodehtml = $(".layui-timeline-item").clone(true);
$('#addmore').on('click', function () {
    var $node = $nodehtml.clone(true);
    $(".layui-timeline").append($node);
});

//form
layui.use(['form', 'layedit', 'laydate'], function () {
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate;

    //日期
    laydate.render({
        elem: '#date'
    });
    laydate.render({
        elem: '#date1'
    });

    //创建一个编辑器
    var editIndex = layedit.build('LAY_demo_editor');

    //自定义验证规则
    form.verify({
        title: function (value) {
            if (value.length < 5) {
                return '标题至少得5个字符啊';
            }
            if (value.length > 20) {
                return "您输入的标题太长了吧"
            }
        },
        day: function (v) {
            if (v.length > 5) {
                return "您确定玩了这么多天吗？(不超过5位)";
            }
            if (v <= 0) {
                return '天数不能小于等于0';
            }
        },
        money: function (v) {
            if (v.length > 10) {
                return "您确定花了这么多钱吗？(不超过10位)";
            }
            if (v <= 0) {
                return '钱数不能小于等于0';
            }
        },
        address: function (v) {
            if (v.length > 20) {
                return "输入长度不超过20位";
            }
        }
        , content: function (value) {
            layedit.sync(editIndex);
        }
        , placeName: function (value) {
            if (value.length > 20) {
                return '输入长度不能超过20！';
            }
        }
        ,
        placeDescription: function (value) {
            if (value.length > 200) {
                return '输入长度不能超过200';
            }
        }, description : function (value) {
            if (value.length >200){
                return '上传字数不超过200！';
            }

        }
    });

    //添加表单的提交
    $('#strategy').submit(function (e) {
            e.preventDefault();
            console.log($('#strategy').serialize());
            layer.load();
            $.ajax({
                type: "POST",
                dataType: "text",
                url: "/Strategy",
                data: $('#strategy').serialize(),
                success: function (ret) {
                    layer.closeAll('loading'); //关闭loading
                    if (parseInt(ret) != 0) {
                        layer.alert('发表成功！');
                        setTimeout("window.location.href='playInfo.html'", 3000);
                    }
                    else {
                        layer.alert("发表失败！");
                    }
                },
                error: function (data) {
                    layer.closeAll('loading');
                    layer.alert("error:" + data.responseText);
                }
            });
        }
    );



});
