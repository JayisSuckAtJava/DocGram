<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
 Class Name : Create.JavaScript
 Description : 작성 페이지 (업데이크)
 Author : 조윤구
 Since : 2022-05-25
--%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>수정페이지</title>
    
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="../resources/css/board.css">
<link rel="stylesheet" href="../resources/css/bootstrap.css">
<link rel="stylesheet" href="../resources/css/main.css">
<link rel="stylesheet" href="../resources/css/comp.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="../resources/js/board.js"></script>

</head>

<!-- 헤더 끝 -->

<!-- 바디 -->
<body>

	<!-- header -->
<header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4">
	<jsp:include page="../comp/header.jsp"></jsp:include>
</header>

<div class="all">

    <div class="writebody">
		<form action="" method="post" enctype="multipart/form-data">
        <div class="titlename"> <!-- 제목 작성 부분-->
            <div>
            	<input type="text" name="title" class="title" placeholder="제목을 입력해 주세요." value="${board.title}">
            </div>
        </div>
        <hr>
        <div class="wirtearea"> <!-- 내용 작성 부분-->
            <textarea class="size" placeholder="내용을 입력하세요." name="content">${board.content}</textarea>

        </div>
        <hr>
        
        <div>
            <h3 class="upload">파일 업로드</h3> <!--파일 업로드-->
            <input type="file" name="mFile" id="imageFileOpenInput" accept=".pdf" disabled="disabled">
            <button>취소</button>
            <hr>
        </div>

        <div>
            <h3> 해시태그 지정</h3>
            <input type="text" placeholder="태그를 입력하세요" name="hashtagList" value="${hashtagList}">
            
        </div>
            <hr>
        <div> <!-- 관계 게시글 설정-->
            <h3>관계 게시글 설정</h3>
            <input type="text" id="boardList" name="relatedBoardList" value="${relationList}">
            <button class="">리셋</button>
        </div>
    
    </div>
    <div>   <!-- 수정 완료, 뒤로가기-->
     <button onclick="location.href='board/id'">수정 완료</button> 
    
    <button onclick="location.href='read/search'">뒤로가기</button>

    </form>
    </div>
</div>
	
<!-- footer -->
<footer class="container-fluid text-center py-3" >
	<jsp:include page="../comp/footer.jsp"></jsp:include>
</footer>

</body>
</html>