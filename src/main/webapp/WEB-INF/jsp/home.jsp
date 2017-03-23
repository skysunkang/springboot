<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html  >
<head>
    <meta charset="UTF-8"/>
    <title>Title</title>

    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <script src="js/jquery-1.4.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="application/javascript" >
        function logout(){
            $.ajax({
                url:'logout',
                type:'POST',
                data:{'heh':''},
                success:function (data){

                }
            });
        }
    </script>
</head>
<body >
用户名：${username}
<br>

我就是首页，首页就是我
<%--从后台读取权限，制作类似菜单--%>
<sec:authorize access="hasRole('${menu}')" >
    我是ROLE_ADMIN的权限
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')" >
    我是普通用户的权限
</sec:authorize>

<form class="form-horizontal" role="form" action="logout" method="POST">
    <div class="form-group">
       <%--需要带上该验证，否则会报被禁止的访问，退出必须为post请求--%>
        <sec:csrfInput />
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">退出登录</button>
        </div>
    </div>
</form>
</body>
</html>