<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
 Class Name : Create.JavaScript
 Description : 작성 페이지
 Author : 조윤구
 Since : 2022-05-24
--%>
<!DOCTYPE html>
<html>
<head>
  <title>작성페이지</title>
  <meta charset="utf-8">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="/resources/css/board.css">
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<link rel="stylesheet" href="/resources/css/main.css">
<link rel="stylesheet" href="/resources/css/comp.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="../resources/js/board.js"></script>

  
</head>

<body>
	
	<!-- header -->
<header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4">
	<jsp:include page="../comp/header.jsp"></jsp:include>
</header>

  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      
    </div>
    <div class="col-sm-8 text-left"> 
      
      <div class="all">

        <div class="writebody">    
       <form action="" method="post" enctype="multipart/form-data">
            <div class="titlename"> <!-- 제목 작성 부분-->
                <div>
                    <input class="size" type="text" name="title" placeholder="제목을 입력해주세요">
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
                <input class="size" type="text" placeholder="태그를 입력하세요" name="hashtagList">
                
            </div>
                <hr>
    
    
    
    			
            <div> <!-- 관계 게시글 설정-->
                <h3>관계문서 지정</h3>
                <input class="size" class="tt" type="text" placeholder="관련 문서들" name="relatedBoardList">
		
                <!-- 관련 문서 모달 -->
                <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#modalCart">관련문서 지정</button>


                <!-- Modal: modalCart -->
                <div class="modal fade" id="modalCart" tabindex="-1" role="dialog"
                aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                  <div class="modal-content">
                    <!--Modal Header-->
                    <div class="modal-header">
                      <h4 class="modal-title" id="myModalLabel">
                        <a class="navbar-brand">
                          <i class="bi bi-patch-question"></i>
                          관련문서
                        </a>
                      </h4>
                        <input class="form-control me-2" type="search" name="search" placeholder="Search"
                          aria-label="Search">
                        <button class="btn btn-outline-success" type="submit" style="height: 38px;"><i class="bi bi-search"></i></button>
                      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                      </button>
                    </div>
                    <!--Modal Body-->
                    <div class="modal-body">

                      <table class="table table-hover">
                        <thead>
                          <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>소속 기관</th>
                            <th>작성자</th>
                          </tr>
                        </thead>
                        <tbody>
                          <%-- <tr>
                            <th scope="row">${board.id}</th>
                            <td>${board.title}</td>
                            <td>${dept.name}</td>
                            <td>${user.name}</td>
                          </tr> --%>
                        </tbody>
                      </table>

                    </div>
                    <!--Footer-->
                    <div class="modal-footer">
                      <button type="button" class="btn btn-outline-primary" data-dismiss="modal">Close</button>
                    </div>
                  </div>
                </div>
              </div>
              



            </div>

          	<div>
            <button type="submit">작성 완료</button> 
            <button onclick="history.back()" >뒤로가기</button>
            </div>
          	</form>
          </div>
          
          						
        </div>
      </div>
      <div class="col-sm-2 sidenav">
        
        
      </div>
    </div>
  </div>
  
<!-- footer -->
<footer class="container-fluid text-center py-3" >
	<jsp:include page="../comp/footer.jsp"></jsp:include>
</footer>
  
</body>
</html>
