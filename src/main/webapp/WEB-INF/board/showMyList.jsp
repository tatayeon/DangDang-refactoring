<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>나의 상품 등록 목록 보기</title>
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
<h1>나의 상품 목록 보기</h1>
<table border="1">
    <thead class="table-light" >
    <tr class="row-md-6">
        <th class="col-md-3">글 번호</th>
        <th class="col-md-3">제목</th>
<%--        <th class="col-md-3">상품가격</th>--%>
        <th class="col-md-3">등록일</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${lllist}" var="b">
        <tr class="row-md-6">
            <td>${b.id}</td>
            <td><a href="/board/showOne/${b.id}"> ${b.title}</a></td>
<%--            <td>${b.price}</td>--%>
            <td><fmt:formatDate value="${b.entryDate}" pattern="yyMMdd HH:mm:ss"/></td> <!--이건 날짜를 바꿔주기 위해서 추가해줌 -->
        </tr>
    </c:forEach>

    </tbody>
</table>

<a href="/">첫화면 가기</a>
<a href="/board/showAll">전체목록보기</a>
<a href="/board/write2">글쓰기</a>

</body>
</html>