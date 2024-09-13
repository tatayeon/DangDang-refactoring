<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>


<html>
<head>
    <title>회원가입 창</title>
    <style>
        body {
            background-image: url('/accountg.png');
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
        }
    </style>
</head>
<body>
<h1>${message}</h1> <!-- 우리가 만든(Usercontroller)에서 것을 가져온다-->
<form action="/user/register" method="POST">

<%--    아이디 <input type="text" name="username" value="${temp.username}"> <br>--%>
<%--    비밀번호 <input type="text" name="password"><br>--%>
<%--    닉네임 <input type="text" name="nickname" value="${temp.nickname}">--%>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>

    <div class="row justify-content-center">
        <div class="col-6">
            아이디 <input type="text" name="userName" class="form-control"> <br>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-6">
            비밀번호 <input type="text" name="password" class="form-control"><br>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-6">
            닉네임 <input type="text" name="nickName" class="form-control">
        </div>
    </div>
<%--    <input type="submit" value="회원가입">--%>
    <div class="row justify-content-center">
        <div class="col-1">
            <input type="submit" value="회원가입" class="btn btn-outline-info">
<%--            <a href="/user/register" class="btn btn-outline-info">회원가입</a>--%>
        </div>
    </div>
</form>

</body>
</html>
