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
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="/resources/images/favicon.png">

<link rel="stylesheet" href="/resources/css/board.css">
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<link rel="stylesheet" href="/resources/css/main.css">
<link rel="stylesheet" href="/resources/css/comp.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="/resources/js/board.js"></script>
<script type="text/javascript">
function typeRel(e) {
	const keyCode = e.keyCode;
	if(keyCode == 13) {
		ajax();
	}
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
    <div class="col-sm-8"> 
      
      <div class="all">
              <!-- 타이틀 부분 -->

        <h3 class="title-article">문서작성</h3>

        <div class="writebody">    
       <form action="" method="post" enctype="multipart/form-data">
            <div class="titlename writing"> <!-- 제목 작성 부분-->
                <div>
                    <input class="size" type="text" name="title" placeholder="제목을 입력해주세요" required>
                </div>
            </div>
            <hr>
            <div class="wirtearea writing"> <!-- 내용 작성 부분-->
                <textarea class="size" placeholder="내용을 입력하세요." name="content"></textarea>
    
            </div>
            <hr>
            
            <div class="writing">
                <h5 class="upload">파일 업로드 </h5> <!--파일 업로드-->
                <input type="file" name="mFile" id="imageFileOpenInput" accept=".pdf">
                <hr>
            </div>
    
            <div class="writing">
                <h5> 해시태그 지정</h5>
                <input class="size" type="text" placeholder="태그를 입력하세요 예시:) #해시 #태그" id="tagInput">
                <input type="hidden" name="hashtagList" id="hashtagList">
                
            </div>
                <hr>
    
    
    
    			
            <div class="writing"> <!-- 관계 게시글 설정-->
                <h5>관계문서 지정</h5>
                 <button type="button" class="btn btn-outline-secondary size" data-toggle="modal" data-target="#modalCart" id="modal-block">
                <input class="size" class="tt" type="text" placeholder="관련 문서들" name="relatedBoardList" id="inputRelList" disabled>
                <input type="hidden" name="relatedBoardList" id="inputRelListReal" >
                </button>
                </div>
            

          	<div class="writing mm">
            <button type="submit"class="btn btn-outline-dark">작성 완료</button> 
            <button onclick="history.back()" type="button" class="btn btn-outline-dark">뒤로가기</button>
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
  </div>
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
			       <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" id="search-text" onkeydown="typeRel(event)" >
			       <button class="btn btn-outline-success" type="submit" style="height: 38px;" onclick="ajax()"><i class="bi bi-search"></i></button>
                        
                        
                        <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
                        <script>
                        
                        
                        let relSum = 0;
                function ajax() {          	
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
                		const board_list = result.data;
                		
                		const body = document.querySelector("#board_list_search_body");
                		let html ="";
                		
                		board_list.forEach((v)=>{
                			
                			html = html + "<tr id='rel_list'>";
                			html = html + `<td>\${v.id}</td>`;
                			html = html + `<td>\${v.title}</td>`;
                			html = html + `<td>\${v.user.dept.name}</td>`;
                			html = html + `<td>\${v.user.name}</td>`;
                			html = html + "</tr>";
                		})
                		body.innerHTML = html;
                		const relList = document.querySelectorAll("#rel_list");
       	             	const relListSum = document.querySelector("#rel_list_sum");
       	                
       	            	 relList.forEach((v)=>{
       	            		 let id = v.firstElementChild.innerHTML
       	            		 let checkArray = new Array();
       	            		 v.addEventListener("click",()=>{
       	            			 
       	            			 if(relSum != 3){
       	            				if(checkArray.includes(id)){      	            			 		
       	            			 	}else {
       	            					checkArray.push(id);  
       	            					if(relListSum.value == "") {
       	       	            				relListSum.value = relListSum.value + `\${id}`;
       	       	            				relSum++;
       	       	            			 }else {
       	       	            				relListSum.value = relListSum.value + ',' +`\${id}`;
       	       	            				relSum++;
       	       	            			 }
       	            			 	}
       	            			 }else {
       	            				 alert("관계 문서는 3개만 지정 가능합니다.")
       	            			 }
       	            			 
       	            		 })
       	            	 })
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
                
               
                function checkRelation() {
                	const relListSum = document.querySelector("#rel_list_sum");
                	const relList = document.querySelector("#inputRelList");
                	const relListReal = document.querySelector("#inputRelListReal");
                	
                	relList.value = relListSum.value;
                	relListReal.value = relListSum.value;
                }
                
                function cancel() {
                	const relListSum = document.querySelector("#rel_list_sum");
                	const relList = document.querySelector("#inputRelList");
                	const relListReal = document.querySelector("#inputRelListReal");
                	relListSum.value = "";
                	relList.value = "";
                	relListReal.value = "";
                }
                </script>
                      
                    </div>
                    <!--Modal Body-->
                    <div class="modal-body">
					<input type="text" disabled id="rel_list_sum"/>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="checkRelation()">
                        <span aria-hidden="true"><i class="bi bi-check-square"></i></span>
                      </button>
                    

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
              			<button type="button" class="btn btn-outline-primary" data-dismiss="modal" onclick="cancel()">취소</button>
           			 </div>
                  </div>
                </div>
              </div>
  
   
</body>
</html>
