<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>해
    <title>쇼핑몰 첫페이지</title>
    <style>
        body {
            background-image: url('/maing.png');
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
        }
    </style>
</head>
<body>

<c:choose>
    <c:when test="${In == true}">
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
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Gaegu:wght@400&display=swap">
        <style>
            .fs-1 {
                font-family: 'Gaegu', cursive; /* 선택한 글씨체를 여기에 지정하세요 */
                /* 다른 스타일 속성들도 필요에 따라 추가할 수 있습니다 */
            }
        </style>
        <div style="text-align:center;" class="fs-1">${logIn.nickname}님의 방문을 환영합니다!</div>
        <!-- 여기에 로그인이 성공 했을 때 들어갈 수 있는 메뉴들을 만든다. -->
        <br>
        <br>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Gaegu:wght@400&display=swap');

            .cloud-button {
                background: url('https://example.com/cloud-image.jpg') no-repeat center center; /* 구름 이미지를 배경으로 설정 */
                background-size: cover; /* 배경 이미지를 커버로 조절 */
                border: none; /* 테두리 없음 */
                border-radius: 20px; /* 버튼을 둥근 형태로 만듭니다. */
                padding: 15px 25px; /* 내부 여백 설정 및 글자 크기 키우기 */
                font-size: 24px; /* 글자 크기 설정 */
                font-family: 'Gaegu', cursive; /* 구글 폰트에서 가져온 'Gaegu' 글씨체를 지정 */
                text-align: center; /* 텍스트 가운데 정렬 */
                text-decoration: none; /* 텍스트에 밑줄 제거 */
                display: inline-block; /* 인라인 블록 요소로 설정하여 여러 버튼을 한 줄에 나열할 수 있습니다. */
                cursor: pointer; /* 마우스 커서를 포인터로 변경하여 클릭 가능한 상태로 표시 */
                color: white; /* 글자 색상을 흰색으로 설정 */
            }
        </style>

        <div class="container text-center">
            <div class="row justify-content-md-center">
                <div class="col-md-4">
                    <a href="user/logout" class="btn btn-light w-75 p-3 cloud-button">로그아웃!</a>
                </div>
                <div class="col col-lg-4">
                    <a href="board/write" class="btn btn-light w-75 p-3 cloud-button">확인하러 가기!</a>
                </div>
                <div class="col col-lg-4">
                    <a href="board/showAll" class="btn btn-light w-75 p-3 cloud-button">게시판 가기!</a>
                </div>
            </div>
        </div>
        <div>
                <%--            <img src="uploads/${fileName}" alt="uploads/${fileName}">--%>
        </div>
        <br>
        <br>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Gaegu:wght@400&display=swap">
        <style>
            .fs-3 {
                font-family: 'Gaegu', cursive; /* 선택한 글씨체를 여기에 지정하세요 */
                /* 다른 스타일 속성들도 필요에 따라 추가할 수 있습니다 */
            }
        </style>
        <div style="text-align:center;" class="fs-3">당신이 검색한 강아지의 품종은??</div>
        <c:forEach var="item" items="${list}">
            <div style="text-align:center;" class="fs-3">${item.rank}위 < ${item.species}> (${item.probability}%)</div>
        </c:forEach>
        <%--        <div>${fileName}</div>--%>


    </c:when>
    <c:otherwise>
        <!--로그인 상태가 아닐 떄 실행 될 코드들 -->
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
        <form action="/user/auth" method="post">
            <div class="row justify-content-center" style="margin-bottom: 10px;">

                <div class="col-sm-3 text-center d-inline">
                    ID :
                    <input type="text" name="username" class="form-control  form-control-sm d-inline w-75"
                           id="username">
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-sm-3 text-center d-inline">
                    PW :
                    <input type="text" name="password" class="form-control  form-control-sm d-inline w-75">
                </div>
            </div>
            <br>
            <div class="row justify-content-center">
                <div class="col-1">
                    <input type="submit" value="log - in" class="btn btn-outline-success">
                </div>
            </div>

            <div class="row justify-content-center">
                <div class="col-1">
                    <a href="/user/register" class="link-secondary">join - us!</a>
                </div>
            </div>

        </form>
    </c:otherwise>
</c:choose>

</body>
</html>
