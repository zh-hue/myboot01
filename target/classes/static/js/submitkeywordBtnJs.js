$(".submitkeywordBtn").on("click",function () {
    var keyword = $(this).prev("form:eq(0)").children("input").val();
    if (keyword!=null&&keyword.trim()!="") {
        $(this).prev("form:eq(0)").submit();
    }else {
        alert("请输入关键字查询!");
    }
})