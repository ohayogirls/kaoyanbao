
function setCookie(key, value) {
    document.cookie = key + '=' + value;

}
function removeCookie(key) {
    setCookie(key, '', -1);//这里只需要把Cookie保质期退回一天便可以删除
}
function getCookie(key) {
    var cookieArr = document.cookie.split('; ');
    for(var i = 0; i < cookieArr.length; i++) {
        var arr = cookieArr[i].split('=');
        if(arr[0] === key) {
            return arr[1];
        }
    }
    return false;
}
function userShow() {
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/show/denglu",
        data:{UserName:$('#signin-username').val(), Password:$('#signin-password').val()},
        dataType:"text",
        success: logSuccess
    })
    // window.location.href = "http://localhost:8080/school";
    // var name = $('#signin-username').val();
    // setCookie("UserName",name);
}
function logSuccess(map) {
    var json = eval("("+map+")");
    var isPassword = json.flag2;
    var isName = json.flag1;
    var UserName = json.user.userName;
    if(isName){
        if(isPassword){
            setCookie("UserName",UserName);
            window.location.href = "http://localhost:8080/show";
        }
        else {
            window.location.href = "http://localhost:8080/show/denglu";
            alert("密码错误");
        }
    }else {
        window.location.href = "http://localhost:8080/show/denglu";
        alert("账户不存在");
    }
}