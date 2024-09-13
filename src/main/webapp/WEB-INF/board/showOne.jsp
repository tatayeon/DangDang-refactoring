<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Gaegu:wght@400&display=swap">
    <style>
        .fs-1 {
            font-family: 'Gaegu', cursive; /* 선택한 글씨체를 여기에 지정하세요 */
            /* 다른 스타일 속성들도 필요에 따라 추가할 수 있습니다 */
        }
    </style>
    <title>상품 등록 목록 보기</title>
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

<div style="text-align:center;" class="fs-1">동물 게시판!!</div>
    <h3 style="text-align:center;" class="fs-3 fs-1"> -${boardDTO.title} -  [작성자 :${boardDTO.nickname}]  </h3>
    <h4 style="text-align:center;" class="fs-5 fs-1">글 내용 : ${boardDTO.content}</h4>

<div class="row justify-content-center">
    <div style="text-align:center;" class="fs-4 fs-1">
        <div > <댓글 달기></div>
        <c:forEach items="${replyList}" var="b">
            <div class="row justify-content-center ">
                <div class="col-13">
                    <div>(${b.writerId})님||${b.content} /${b.entryDate}</div>
                    <p>------------------------------------</p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<form action="/board/reply/${boardDTO.id}" method="POST">
    <div class="row justify-content-center">
        <div class="col-3">
            <input type="text" name="content" class="form-control">
            <input type="submit" value="댓글" class="btn btn-outline-info">
        </div>
    </div>
</form>


<div class="col-8 d-flex justify-content-center">
    <a href="/" class="btn btn-outline-info m-1">첫화면 가기</a>
    <c:if test="${In == true}">
        <a href="/board/delete/${boardDTO.id}" class="btn btn-outline-info m-1">삭제하기</a>
    </c:if>
    <a href="/board/showAll" class="btn btn-outline-info m-1">전체목록</a>
</div>






</body>
</html>