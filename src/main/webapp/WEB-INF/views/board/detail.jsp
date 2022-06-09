<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
 Class Name : Detail.JavaScript
 Description : 문서 상세 보기
 Author : 조윤구
 Since : 2022-05-20
--%>
<!DOCTYPE html>
<html>
<head>
  <title>문서상세보기</title>
  <meta charset="utf-8">  
  
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="../resources/css/board.css">
<link rel="stylesheet" href="../resources/css/bootstrap.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="../resources/js/board.js"></script>
<link rel="stylesheet" href="../resources/css/main.css">
<link rel="stylesheet" href="../resources/css/comp.css">
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript">
function starDelete(id) {
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
function starCreate(id) {
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
        <!-- 출력 문서 제목 -->
            <h3 class="title-article">${board.title}<h3>

    
        <!-- 문서 상세 정보 -->
        <div class="table-wrap">
            <table class="table table-response">
                <colgroup>
                    <col style="width:15%">
                    <col style="width:35%">
                    <col style="width:15%">
                    <col style="width:35%">
                </colgroup>
                <tbody>
    
                    <tr>
                        <th scope="row">작성자</th>
                        <td>${board.user.name}     ${board.user.position.name}</td>
                        <th scope="row" class="tline" itemprop="contributor">작성일</th>
                        <td class="tline">${board.date}</td>
                    </tr>
    
                    <tr>
                        <th scope="row" itemprop="accountablePerson">문서 관리 번호</th>
                        <td>${board.file.num}</td>
                        <th scope="row" itemprop="dateCreated">
                            전화번호
                        </th>
                        <td>${board.user.deptNumber}</td>
                    </tr>
    
                    <tr>
                        <th scope="row">소속기관</th>
                        <td colspan="3" style="flex-wrap: nowrap; font-size: large;"> ${dept.upperNdName} > ${dept.upperStName} > ${dept.name}</td>
                    </tr>
                </tbody>
            </table>
    
        </div> 
    
        <hr>
        <div class="btnlist">
        	<c:if test="${board.starmarkId != null}">
            <button class="btn" onclick="starDelete(${board.id})"><i class="bi bi-star-fill"></i></button>
            </c:if>
        	<c:if test="${board.starmarkId == null}">
            <button class="btn" onclick="starCreate(${board.id})"><i class="bi bi-star"></i></button>
            </c:if>
            <c:if test="${board.deptmarkId != null}"> 
            <button class="btn"><i class="bi bi-megaphone-fill"></i></button>
            </c:if> 
            <c:if test="${board.deptmarkId == null}"> 
            <button class="btn"><i class="bi bi-megaphone"></i></button>
            </c:if>
        </div>
        <hr>
    
        <!-- 해시태그 정보 -->
        <div class="hashlist">
            <div>
                <h4 class="hash"> 해시태그 정보 </h4>
            </div>
    
            <div class="hashdetail">
            <c:forEach items="${hashtagList}" var="hashtag">
            <tag>#${hashtag.name} </tag>
            </c:forEach>
            </div>
        </div>       
    
        <hr>
        <div>
            <!-- 문서내용  -->
            <div class="detaillsit">
                <h4 class="detailarea"> 문서 내용 </h4>
            </div>
                    <div class="detail">
                        <p>
                        ${board.content}
                        </p>
                    </div>
                    <hr>
            <div class="right">
                <a href="update/${board.id}"><button>수정</button></a>
                <button>삭제</button>
                <button onclick="history.back()">목록</button>
            </div>
        </div>
            
        <hr>
    
    
        <!-- 문서 다운 파트 -->
        <div>    
            <div>
                <h4 id="attachment">첨부된 문서 (다운로드)</h4>
            </div>
            <div class="comm-view-article print-no" tabindex="110" title="첨부된 문서">
                    
            </div>
            <div>
                <ul class="list-attachment">
                    <li>
                        <div class="comm-view-article print-no" tabindex="110" title="첨부된 문서">
                            <p class="title-down">${board.file.name}</p> 
                            <span class="btn-downset">
                                <!-- 문서 보기 버튼-->
                                 <button type="button" class="btn btn-view" onclick="showDocs()">문서보기</button>    
                                 <!-- 다운로드 a테그 -->
                                <a href="/download/${board.file.id}" class="btn btn-download btn-original" style='margin-left:5px'>
                                    <i class="icon-img icon-down"></i>
                                    <button class="element-invisible">다운로드</button>
                                </a> 
                            </span>
                    </li>
                </ul>
            </div>
        </div> 
        <hr>
       
        
        <!-- 관련 문서 파트 -->
    
        <div>
            <div>
                <h4 class="relation">관련 문서</h4> 
            </div>
            <div class="relationlist">
                <ul>
                <!--  첫번쨰 문서-->
                   
                    <c:if test="${relationList[0] != null}">
                    <c:forEach items="${relationList}" var="relatedBoard">
                    <c:if test="${relatedBoard != null}">
                    <li>
                        <div>
                        	<!-- 관련 문서 a 태그 -->
                            <a href="${relatedBoard.id}">${relatedBoard.title}</a>
                        </div>
                            <p>
                                <span class="date">${relatedBoard.date}</span>
                                <span>${relatedBoard.user.dept.name}</span>
                            </p>
                    </li>
                    </c:if>
                    </c:forEach>
                    </c:if>
                </ul>
            </div>
        </div>

    </div>
  </div>
</div>

<!-- footer -->
<footer class="container-fluid text-center py-3" >
	<jsp:include page="../comp/footer.jsp"></jsp:include>
</footer>

<script>
        const tds = document.querySelectorAll("tag");
        tds.forEach((v) => {
            let text = v.innerHTML;
            let tag = text.substring(1);
            v.addEventListener("click" , ()=>{
            	window.location.href = `../search/list?hashtagList=\${tag}`;     
            })
            })
            
        function showDocs() {
			const url = window.location.host
			window.open(`http://docs.google.com/viewer?url=http://\${url}/resources/static/pdf/${board.id}_${board.file.name}`);
		} 
  
</script>
</body>
</html>

