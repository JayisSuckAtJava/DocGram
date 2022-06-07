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

<link rel="stylesheet" href="/resources/css/board.css">
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
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
                <hr>
            </div>
    
            <div>
                <h3> 해시태그 지정</h3>
                <input class="size" type="text" placeholder="태그를 입력하세요 예시:) #해시 #태그" id="tagInput">
                <input type="hidden" name="hashtagList" id="hashtagList">
                
            </div>
                <hr>
    
    
    
    			
            <div> <!-- 관계 게시글 설정-->
                <h3>관계문서 지정</h3>
                 <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#modalCart" id="modal-block">
                <input class="size" class="tt" type="text" placeholder="관련 문서들" name="relatedBoardList">
                </button>
                
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
                          관련문서검색
                        </a>
                      </h4>
                      <select id="search-sel">
                        <option value="title">제목</option>
                        <option value="context">내용</option>
                        <option value="name">이름</option>
                        <option value="dept">소속 부서</option>
                      </select>
                        <input class="form-control me-2" type="search" name="search" placeholder="Search"
                          aria-label="Search" id="search-text">
                        <button class="btn btn-outline-success" type="button" style="height: 38px;" onclick="ajax()"><i class="bi bi-search"></i></button>
                        <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
                        <script>
                function ajax() {
                	console.log("hi");
                	
                	let sel = document.querySelector("#search-sel").value
                	let text = document.querySelector("#search-text").value
                	
                	const data = axios({
                		url: '/rest/relation',
                		method: 'get',
                		params: {
                		'sel' : sel,
                		'text' : text
                		}
                		});
                		data.then(function (result) {
                		console.log(result.data);
                		const board_list = result.data;
                		
                		const body = document.querySelector("#board_list_search_body");
                		let html ="";
                		
                		board_list.forEach((v)=>{
                			
                			html = html + "<tr>";
                			html = html + `<td>\${v.id}</td>`;
                			html = html + `<td>\${v.title}</td>`;
                			html = html + `<td>\${v.user.dept.name}</td>`;
                			html = html + `<td>\${v.user.name}</td>`;
                			html = html + "</tr>";
                		})
                		body.innerHTML = html;
                		
                		});

                }
                
                const tagInput = document.querySelector("#tagInput");
                tagInput.addEventListener("blur",()=>{
                	let text = tagInput.value;
                	let tags = text.split(/(#[^\s]+)/g);
                	let tagIs = tags.filter((v)=>{
                		const result = v.includes('#');
                		return result;
                	})
                	let tagArray = new Array();
                	for(value of tagIs) {
                		tagArray.push(value.replace('#',''))
                	}
                	hashtagList = tagArray.join(",");
                	const hashtagListInput = document.querySelector("#hashtagList");
                	hashtagListInput.value = hashtagList;
                	
                })
                </script>
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
                        <tbody id="board_list_search_body">
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
</body>
</html>
