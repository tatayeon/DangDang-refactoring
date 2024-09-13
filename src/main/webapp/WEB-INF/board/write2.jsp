<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>게시판 쓰기</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Gaegu:wght@400&display=swap">
    <style>
        body {
            background-color: #f8f9fa; /* Set a background color for the body */
            font-family: 'Gaegu', cursive;
        }

        .container {
            max-width: 600px; /* Adjust the maximum width of the container */
            margin: auto; /* Center the container on the page */
            padding: 20px; /* Add some padding inside the container */
        }

        .fs-1 {
            text-align: center; /* Center the text */
            font-size: 2rem; /* Increase the font size */
        }

        label {
            font-weight: bold; /* Make labels bold */
        }

        textarea {
            resize: vertical; /* Allow vertical resizing of the textarea */
        }

        input[type="submit"], a.btn {
            margin-top: 10px; /* Add some spacing above the buttons */
        }
    </style>
</head>
<body>
<div class="container">
    <div class="fs-1">게시글 작성하기!</div>
    <br>
    <br>
    <form action="/board/write2" method="POST">
        <div class="mb-3">
            <label class="form-label">제목</label>
            <input type="text" class="form-control" name="title">
        </div>
        <br>
        <div class="mb-3">
            <label class="form-label">내용:</label>
            <textarea class="form-control" name="content" rows="3"></textarea>
        </div>
        <div class="row justify-content-center">
            <div class="col-6">
                <input type="submit" value="글쓰기" class="btn btn-primary btn-block">
                <a href="/board/showAll" class="btn btn-secondary btn-block">전체목록</a>
            </div>
        </div>
    </form>
</div>
</body>
</html>