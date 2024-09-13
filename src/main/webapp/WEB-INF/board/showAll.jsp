<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<style>
    body {
        background-image: url('/background.png');
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-size: cover;
    }
</style>
<html lang="en">
<br>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>강아지 게시판</title>

    <!-- Bootstrap CSS 파일을 불러옵니다. -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Gaegu:wght@400&display=swap">
    <style>
        body {
            text-align: center;
        }

        h1 {
            font-family: 'Gaegu', cursive; /* 'Gaegu' 글씨체를 적용합니다. */
        }

        table {
            border-collapse: collapse;
            width: 80%;
            margin: auto;
        }

        th, td {
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #f2f2f2; /* 헤더 배경색 설정 */
        }

        tr {
            border-bottom: 1px solid #ddd; /* 행의 아래쪽 선 설정 */
        }

        a {
            display: block;
            margin: 10px 0; /* 링크 사이의 간격 설정 */
        }
    </style>
</head>
<body>
<h1>강아지 게시판!</h1>
<br>
<table>
    <thead>
    <tr>
        <th>글 번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>등록일</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="b">
        <tr>
            <td>${b.id}</td>
            <td><a href="/board/showOne/${b.id}">${b.title}</a></td>
            <td>${b.nickname}</td>
            <td><fmt:formatDate value="${b.entryDate}" pattern="yyMMdd HH:mm:ss"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="/" style="font-family: 'Gaegu', cursive; font-size: 18px;">첫화면 가기</a>
<a href="/board/write2" class="btn btn-outline-info" style="font-family: 'Gaegu', cursive; font-size: 18px;">글쓰기</a>

<!-- Bootstrap JS 파일 및 Popper.js 파일을 불러옵니다. -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>