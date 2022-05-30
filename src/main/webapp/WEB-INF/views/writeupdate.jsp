<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>작성페이지</title>
    <link href="../resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="../resources/css/bootstrap.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../resources/js/bootstrap.min.js"></script>

<!-- css 부분 -->
    <style>
        /* 전체 마진 */
        .all{
            margin-left: 15%;
            margin-right: 15%;
        }
        /* 작성 부분 전체 */
        .writebody{
            border: 1px solid;
        }
        /* 제목 부분 */
        .titlename {
            margin-bottom: 15px;
            
        }

        .title {
            width: 80%;
        }

        /* 내용 작성 부분 */

        .wirtearea {
            margin-bottom: 15px;
        }

        .size{
            width: 80%; height: 30%;
        }
    </style>

</head>

<!-- 헤더 끝 -->

<!-- 바디 -->
<body>
<div class="all">

    <div class="writebody">
		<form action="" method="post" enctype="multipart/form-data">
        <div class="titlename"> <!-- 제목 작성 부분-->
            <div>
            	<input type="text" name="title" class="title" placeholder="제목을 입력해 주세요.">
            </div>
        </div>
        <hr>
        <div class="wirtearea"> <!-- 내용 작성 부분-->
            <textarea class="size" placeholder="내용을 입력하세요." name="content"></textarea>

        </div>
        <hr>
        
        <div>
            <h3 class="upload">파일 업로드</h3> <!--파일 업로드-->
            <input type="file" name="mFile" id="imageFileOpenInput" accept=".pdf">
            <button>취소</button>
            <hr>
        </div>

        <div>
            <h3> 해시태그 지정</h3>
            <input type="text" placeholder="태그를 입력하세요" name="hashtagList">
            
        </div>
            <hr>
        <div> <!-- 관계 게시글 설정-->
            <h3>관계 게시글 설정</h3>
            <input type="text" id="boardList" name="relatedBoardList">
            <button class="">리셋</button>
        </div>
    
    </div>
    <div>   <!-- 작성 완료, 뒤로가기-->
    <button class="submit">수정완료</button> <button>뒤로가기</button>
    </form>
    </div>
</div>
<script>
    const hashinput = document.querySelector("#boardList");

    hashinput.addEventListener("focusin",()=>{
        let option = "width=500, height=600, top=30, left=30, resizable=no, scrollbar=no, loaction=no";

        window.open("./popup","해시태그 선택",option);
    })
</script>
</body>
</html>