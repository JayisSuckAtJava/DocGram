<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>작성페이지</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
    <link rel="stylesheet" href="../resources/css/board.css">
    <script src="../resources/js/board.js"></script>
  
  <!-- <style>
    
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style> -->
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Projects</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      
    </div>
    <div class="col-sm-8 text-left"> 
      
      <div class="all">

        <div class="writebody">
    
            <div class="titlename"> <!-- 제목 작성 부분-->

                <div>
                    <input class="title" type="text" name="제목" placeholder="제목을 입력해주세요">
                </div>
            </div>
            <hr>
            <div class="wirtearea"> <!-- 내용 작성 부분-->
                <textarea class="size" placeholder="내용을 입력하세요." ></textarea>
    
            </div>
            <hr>
            
            <div>
                <h3 class="upload">파일 업로드</h3> <!--파일 업로드-->
                <input type="file" name="file" id="imageFileOpenInput" accept=".pdf">
                <button>취소</button>
                <hr>
            </div>
    
            <div>
                <h3> 해시태그 지정</h3>
                <input type="text" placeholder="태그를 입력하세요">
                
            </div>
                <hr>
    
    
    
    
            <div> <!-- 관계 게시글 설정-->
                <h3>관계 게시글 설정</h3>
                <input type="text" id="boardList">
                <button class="">리셋</button>
            </div>
            <script src="../../js/board.js"></script>
          </div>
          <div>   <!-- 작성 완료, 뒤로가기-->
            <button class="">작성 완료</button> <button>뒤로가기</button>
          </div>
        </div>
        
      </div>
      <div class="col-sm-2 sidenav">
        
        
      </div>
    </div>
  </div>
  
  <footer class="container-fluid text-center">
    <p>Footer Text</p>
  </footer>
  
</body>
</html>
