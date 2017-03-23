<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html  >
<head>
    <meta charset="UTF-8"/>
    <title>Title</title>

    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <script src="js/jquery-1.4.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<form class="form-horizontal" role="form" action="login" method="POST">
    <c:if test="${param.error!=null}" >
        用户名或密码错误
    </c:if>
    <c:if test="${param.logout!=null}" >
        您已注销成功
    </c:if>
    <div class="form-group">
        <label for="username" class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="username" id="username" placeholder="请输入用户名"/>
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" name="password" id="password" placeholder="请输入密码"/>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <div class="checkbox">
                <label>
                    <input type="checkbox"/> Remember me
                </label>
            </div>
        </div>
    </div>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">登录</button>
        </div>
    </div>
</form>

</body>
</html>