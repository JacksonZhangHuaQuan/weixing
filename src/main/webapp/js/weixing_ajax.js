
$(function () {
        $(".choice_stategy").click(function () {
            alert("hello")
            var strategy_id = $(this).attr("name");
            $.ajax({
                // type: "post",
                url: "show.html",
                data: "id" + id ,
                dataType: "Text",
                success: function () {
                    window.location.href ='show.html';
                }
            });
        });


   $(".destination-list .name").click(function () {
      var $getAddress = $(this).text();
       console.log($getAddress);
       $.ajax({
           url : "http://localhost:8080/ShowAddressServlet",
           type : "post",
           dataType : "json",
           data: {
               "address": $getAddress,
           },
           success : function(result) {
               console.log(result);
           }
       });
   });
});