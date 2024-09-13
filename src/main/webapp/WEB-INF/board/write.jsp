<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    `
    <title>강아지 확인하기</title>
    <style>
        body {
            background-image: url('/background.png');
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
        }
    </style>
</head>
<body>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Gaegu:wght@400&display=swap">
<style>
    .fs-1 {
        font-family: 'Gaegu', cursive; /* 선택한 글씨체를 여기에 지정하세요 */
        /* 다른 스타일 속성들도 필요에 따라 추가할 수 있습니다 */
    }
</style>
<div style="text-align:center;" class="fs-1">동물 사진 업로드하기</div>
<br>
<form action="/board/upload" method="POST" enctype="multipart/form-data">
    <div class="input-group mb-3">
        <input type="file" class="form-control w-75 p-3 " id="file" name="file">
        <label class="input-group-text" for="file">Upload</label>
        <input type="submit" value="등록하기">
    </div>
    <br>
</form>
<div style="text-align: center;">
    <a href="/" class="btn btn-primary" style="font-family: 'Gaegu', cursive;">첫화면 가기</a>
</div>
</body>
</html>