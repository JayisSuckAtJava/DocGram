<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
 Class Name : User.JavaScript
 Description : 관리자 계정 소속 관리 페이지
 Author : 조윤구
 Since : 2022-06-01
--%>
<!DOCTYPE html>
<html>
<head>
  <title>소속 관리</title>
  <meta charset="utf-8">
  <!-- css 링크 -->
<link rel="stylesheet" href="../resources/css/admin.css">
<link rel="stylesheet" href="../resources/css/bootstrap.css">
<link rel="stylesheet" href="../resources/css/main.css">
<link rel="stylesheet" href="../resources/css/comp.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <!-- js 링크 -->
<script src="../resources/js/admin.js"></script>
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
    <div class="col-sm-8 text-left"> 
      
      <!-- 문서 검색부분 -->

      <h3 class="title-article">개인정보관리</h3>

 <div class="dl-table-wrap">
   <dl class="dl-table">
     <dt class="dt-keyword"><label for="searchKeyword">검색어</label></dt>
     <dd class="dd-keyword">
       <form action="" method="get"> <!-- form-->
       
       <input class="ss"  name="name" type="text" id="searchKeyword"
         placeholder="이름을 검색해주세요 (예 홍길동)"
         title="이름을 검색해주세요 (예 홍길동)" value="">
         <button class="btn btn-outline-success input-group-append" type="submit" style="height: 38px;"><i class="bi bi-search"></i></button>
        </form>
      
     </dd>
   </dl>

      
      <h3>목록</h3>
      <!-- 목록 리스트 -->
      <div class="col-8">
        <table class="table table-hover">


          <thead id="list_title">

            <tr>
              <th>이름</th>
              <th>Email</th>
              <th>전화 번호</th>
              <th>부서 번호</th>
              <th>소속 기관</th>
              <th>소속 수정</th>
            </tr>
          </thead>

          <tbody class="table table-hover">
            <tr>
              <td >김ㅇㅇ</td>
              <td>cho@gmail.com</td>
              <td>010-2345-342</td>
              <td>부서 번호</td>
              <td>물전환특별팀</td>
              <td>
                <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#modalCart">소속기관
                  이동</button>


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
                                기관검색
                              </a>
                            </h4>
                              <input class="form-control me-2" type="search" placeholder="Search" id="searchDept" onkeydown="typeRel(event)"
                                aria-label="Search">
                              <button class="btn btn-outline-success" type="submit" onclick="ajax()" style="height: 38px;"><i class="bi bi-search"></i></button>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                              <span aria-hidden="true">×</span>
                            </button>
                          </div>
                          <!--Modal Body-->
                          <div class="modal-body">

                            <table class="table table-hover">
                              <thead>
                                <tr>
                                  <th>기 관 명</th>
                                </tr>
                              </thead>
                              <tbody id="deptList">
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
                    <!-- Modal: modalCart -->
                

              </td>

            </tr>
            <c:forEach items="${userList}" var="user">
              <tr>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.phoneNumber}</td>
                <td>${user.deptNumber}</td>
                <td>${user.dept.name}</td>
                <td>
                  <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#modalCart" onclick="saveUserId(${user.id})">소속기관
                    이동</button>
                </td>
              </tr>
            </c:forEach>

          </tbody>
        </table>

        <!-- 페이징 -->
        <!-- 페이징 -->
        <div class="page">
          <nav aria-label="Page navigation example" style="text-align: center;" id="pagenation">
          </nav>
        </div>

        
      </div>
    </div>
    </div>
    <div class="col-sm-2 sidenav">
    							<!-- a 태그  -->
				<div class="well">
					<a href="user">개인정보관리</a>
				</div>
								<!-- a 태그  -->
				<div class="well">
					<a href="board">게시물 관리</a>
				</div>
			</div>
  </div>
</div>


<!-- footer -->
<footer class="container-fluid text-center py-3" >
	<jsp:include page="../comp/footer.jsp"></jsp:include>
</footer>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript">
function saveUserId(id) {
	sessionStorage.setItem("id", id);
}

function ajax() {
	  
    const search = document.querySelector("#searchDept");
    let text = searchDept.value;
    
    const data = axios({
    url: '../rest/dept',
    method: 'get',
    params: {
    'name': text
    }
    });
    data.then(function (result) {
    
    let deptList = result.data;
    const table = document.querySelector("#deptList")
    let html = "";
    
    deptList.forEach((v)=>{
        let id;
        let name;
    	id = v.id;
    	name = v.name; 

        html = html + "<tr id='deptTrs'>";
        html = html + `<td value=\${id} scope="row" id="deptValue" data-dismiss="modal">\${name}</td>`
	    html = html + "</tr>";
    })
    table.innerHTML = html;

			
		const trs = document.querySelectorAll("#deptTrs");
		trs.forEach((v)=>{
			let deptId = v.firstElementChild.getAttribute("value");
			
			v.addEventListener("click",()=>{
				let check = confirm("정말 수정하시겠습니까?");
				if(check) {
					
					const data = axios({
			        	url: '/admin/user/update',
			        	data : {
			        		'deptId' : `\${deptId}`,
			        		'userId' : `\${sessionStorage.getItem("id")}`
			        	},
			        	dataType : 'text',
			        	method: 'post'
			        	});
						data.then(function (result) {
							if(result.data == 1) {
							location.reload();
							}
						})
			        	}

			})
		})
        
})

}
</script>
<!-- pagenation -->
<script src="/resources/js/page.js"></script>
<script src="/resources/js/pageinget.js"></script>
<script type="text/javascript">
window.onload = function() {
	
	if(location.search == ""){
		page();			
	}else {
		pageinget();
	}
}
</script>
</body>
</html>
