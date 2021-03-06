<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
 Class Name : Dept.JavaScript
 Description :  소속 알림 페이지
 Author : 조윤구
 Since : 2022-05-23
--%>
<!DOCTYPE html>
<html>
<head>
  <title>유저 소속 알림</title>
  <meta charset="utf-8">
    <link rel="icon" href="/resources/images/favicon.png">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="../resources/css/bootstrap.css">
  <link rel="stylesheet" href="../resources/css/main.css">
    <link rel="stylesheet" href="../resources/css/comp.css">
    <link rel="stylesheet" href="../resources/css/board.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  


    <link rel="stylesheet" href="../resources/css/board.css">
    
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

      <!--바디부분 -->

       <div class="all">
            <!-- 타이틀 부분 -->
    
            <h3 class="title-article">${sessionScope.user.dept.name}의 게시판  </h3>
    


              <!-- 소속 검색부분 -->

  <div class="dl-table-wrap">
    <dl class="dl-table">
      <dt class="dt-keyword"><label for="searchKeyword">검색어</label></dt>
      <dd class="dd-keyword">
        <form  action="" method=""> <!-- form-->
        <select class="ss" name="sel" id="searchCategory" title="검색어 분류 선택">
          <option value="title" selected="selected">제목</option>
          <option value="content">내용</option>
          <option value="name">작성자</option>
          <option value="dept">소속 부서</option>

        </select>
        <input class="ss" name="text" type="text" id="searchKeyword"
          placeholder="검색어를 입력하세요."
          title="검색어를 입력하세요." value="">
          <button class="btn btn-outline-success input-group-append" type="submit" style="height: 38px;"><i class="bi bi-search"></i></button>
        </form>
      </dd>
    </dl>
    </div>
    
             <!-- 목록 리스트 -->
        <div class="col-12">
          <table class="table table-hover">
          
      
            <thead id="list_title">
      
              <tr>
          <th style="width: 7%"><i class="bi bi-star"></i></th>
          <th style="width: 7%">번호</th>
          <th style="width: 38%">제목</th>
          <th style="width: 7%"></th>
          <th style="width: 15%">소속기관</th>
          <th style="width: 13%">작성일</th>
          <th style="width: 13%">작성자</th>
              </tr>
            </thead>
      
            <tbody class="list-body-star">
              <c:forEach items="${boardList}" var="board">
              <tr style="cursor:pointer;">
               <c:if test="${board.starmarkId == null}">
               <td id="emptyStar"><i class="bi bi-star"></i></td>
               </c:if>
               <c:if test="${board.starmarkId != null}">
               <td id="filledStar"><i class="bi bi-star-fill"></i></td>
               </c:if>
                <td>${board.id}</td>
                  <td>${board.title}</td>
                  <c:if test="${board.fileId != null}">
                  <td><a href="/download/${board.fileId}" ><i class="bi bi-file-earmark-pdf"></a></td>
                  </c:if>
                  <c:if test="${board.fileId == null}">
                  <td></td>
                  </c:if>
                  <td>${board.user.dept.name}</td>
              	  <td>${board.date}</td>
              	  <td>${board.user.name}</td>
               </tr>
               </c:forEach>
                   <script src="../resources/js/read.js"></script>
            </tbody>
          </table>
          
          <div class="bb">
          	<a href="create"><button type="button" class="btn btn-outline-dark">작성하기</button></a>
          </div>
    
          
          </div>
    
            <!-- 페이징 -->
            <div class="page">
              <nav aria-label="Page navigation example" style="text-align: center;" id="pagenation">
              </nav>
            </div>
                
    
    
          </div>

    </div>
    <div class="col-sm-2 sidenav">
      
      <!--  사이드 바 -->
    </div>
  </div>
</div>

  <!-- footer -->
<footer class="container-fluid text-center py-3" >
	<jsp:include page="../comp/footer.jsp"></jsp:include>
</footer>
<script src="/resources/js/page.js"></script>
<script src="/resources/js/pageinget.js"></script>
<script type="text/javascript">
window.onload = function() {
	
	if(location.search == ""){
		page(${listSize});			
	}else {
		pageinget(${listSize});
	}
}
</script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script type="text/javascript">
    
    const emptyStar = document.querySelectorAll("#emptyStar")
    emptyStar.forEach((v)=>{
        v.addEventListener("click",(e)=>{
            let boardId = v.nextElementSibling.innerHTML;
            starCreate(e, boardId);
        });
    });
    
    const filledStar = document.querySelectorAll("#filledStar")
    filledStar.forEach((v)=>{
        v.addEventListener("click",(e)=>{
            let boardId = v.nextElementSibling.innerHTML;
            starDelete(e, boardId);
        });
    });
    
function starDelete(e, id) {
	e.stopPropagation();
    	const data = axios({
			   url: '/starmark/delete',
			   data: {
			   'boardId': `\${id}`
			   },
			   dataType : 'text',
				   method: 'post'
			   });
        	data.then(function (result) {
        		location.reload();
    		});
}
function starCreate(e, id) {
	e.stopPropagation();
	const data = axios({
		   url: '/starmark/create',
		   data: {
		   'boardId': `\${id}`
		   },
		   dataType : 'text',
			   method: 'post'
		   });
 	data.then(function (result) {
			location.reload();
		});
}
</script>
</body>
</html>
