  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
 Class Name : Mypage.JavaScript
 Description : 마이페이지
 Author : 문예빈
 Since : 2022-05-27
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Mypage</title>

	<link rel="stylesheet" href="../resources/css/mypage.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">

</head>
<body>
<header class="container-fluid text-center">
    <p>Header Text</p>
  </header>
    
  <div class="container-fluid text-center">    
    <div class="row content">
      <div class="col-sm-2 sidenav">
                <!--마이페이지 사이드바-->
                <div class="mypage-sidebar">
                  <div class="mypage-category">
                    <h2>My page</h2>
                    <div class="mypage-category-list">
                      <ul>
                        <li onclick="body_convert(mypage_mywriting)">나의 작성글</li>
                        <li onclick="body_convert(mypage_starmark)">즐겨찾기</li>
                        <li onclick="body_convert(mypage_personalInfo)">개인정보 조회</li>
                        <li onclick="body_convert(mypage_mytag)">마이태그 수정</li>
                      </ul>
                    </div>
                  </div>
                </div>
      </div>
      <div class="col-sm-8 text-left"> 
        <!--마이페이지 바디-->
              <!-- 목록 리스트 -->
              <span id="mypage_mywriting">
                <h2> 나의 작성 문서 <i class="bi bi-file-earmark-pdf"></i></h2>
                <table class="table table-hover">
                  <thead id="list_title">
                    <tr>
                      <th>번호</th>
                      <th>제목</th>
                      <th>다운로드</th>
                      <th>소속 기관</th>
                      <th>작성일</th>
                      <th>작성자</th>
                    </tr>
                  </thead>
                  <tbody class="list-body">
                    <tr>
                      <td>10</td>
                      <td>공공문서 관련한 문서 관리</td>
                      <td><a href="피일다운로드경로"><i class="bi bi-file-earmark-pdf"></i></a></td>
                      <td>세종특별청사</td>
                      <td>5/19</td>
                      <td>부서관</td>
                    </tr>
                    <tr>
                      <td>10</td>
                      <td>공공문서 관련한 문서 관리</td>
                      <td><a><i class="bi bi-file-earmark-pdf"></i></a></td>
                      <td>세종특별청사</td>
                      <td>5/19</td>
                      <td>부서관</td>
                    </tr>
                    <tr>
                      <td>10</td>
                      <td>공공문서 관련한 문서 관리</td>
                      <td><a><i class="bi bi-file-earmark-pdf"></i></a></td>
                      <td>세종특별청사</td>
                      <td>5/19</td>
                      <td>부서관</td>
                    </tr>
                    <tr>
                      <td>10</td>
                      <td>공공문서 관련한 문서 관리</td>
                      <td><a><i class="bi bi-file-earmark-pdf"></i></a></td>
                      <td>세종특별청사</td>
                      <td>5/19</td>
                      <td>부서관</td>
                    </tr>
                    <tr>
                      <td>10</td>
                      <td>공공문서 관련한 문서 관리</td>
                      <td><a><i class="bi bi-file-earmark-pdf"></i></a></td>
                      <td>세종특별청사</td>
                      <td>5/19</td>
                      <td>부서관</td>
                    </tr>
                    <c:forEach items="${boardList}" var="board">
                      <tr>
                        <td>${board.id}</td>
                        <td>${board.title}</td>
                        <td>${board.fileId}</td>
                        <td>${board.user.dept.name}</td>
                        <td>${board.date}</td>
                        <td>${board.user.name}</td>
                      </tr>
                    </c:forEach>
  
                  </tbody>
                </table>
  
              </span>
  
              <!-- 즐겨찾기 -->
              <span id="mypage_starmark">
                <h2> 즐겨찾기 <i class="bi bi-star-fill" style="color: yellow;"></i></h2>
                <table class="table table-hover">
                  <thead id="list_title">
  
                    <tr>
                      <th>번호</th>
                      <th>제목</th>
                      <th>다운로드</th>
                      <th>소속 기관</th>
                      <th>작성일</th>
                      <th>작성자</th>
                      <th>수 정</th>
                    </tr>
                  </thead>
                  <tbody class="list-body">
                    <tr>
                      <td>10</td>
                      <td>공공문서 관련한 문서 관리</td>
                      <td><a><i class="bi bi-file-earmark-pdf"></i></a></td>
                      <td>세종특별청사</td>
                      <td>5/19</td>
                      <td>부서관</td>
                      <td><button>수정</button></td>
                    </tr>
                    <c:forEach items="${boardList}" var="board">
                      <tr>
                        <td>${board.id}</td>
                        <td>${board.title}</td>
                        <td>${board.fileId}</td>
                        <td>${board.user.dept.name}</td>
                        <td>${board.date}</td>
                        <td>${board.user.name}</td>
                        <td><button>수정</button></td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
  
              </span>
  
              <!-- 개인정보 조회 및 수정 -->
              <span id="mypage_personalInfo">
                <h2>개인정보 조회</h2>
                <form action="" method="" class="form-example">
                  <div class="container">
                    <div class="input-form-backgroud row">
                      <div class="input-form col-md-12 mx-auto">
                        <h4 class="mb-4">회원가입</h4>
                        <form class="validation-form" novalidate>
          
                          <div class="col-md-10 mb-3">
                            <label for="name">이름</label>
                            <input type="text" name="name" class="form-control" id="name" placeholder="이름을 입력해주세요." value=""
                              required>
                            <div class="invalid-feedback">
                              이름을 입력해주세요.
                            </div>
                          </div>
          
                          <div class="col-md-10 mb-3">
                            <label for="email">이메일</label>
                            <input type="email" name="email" class="form-control" id="email" placeholder="you@example.com"
                              required>
                            <div class="invalid-feedback">
                              이메일을 입력해주세요.
                            </div>
                          </div>
          
                          <div class="col-md-10 mb-3">
                            <label for="inputPassword">비밀번호</label>
                            <input type="password" name="pwd1" id="pwd1" class="form-control" required></input>
                          </div>
          
                          <div class="col-md-10 mb-3">
                            <label for="inputPasswordCheck">비밀번호확인</label>
                            &nbsp;
                            <input type="password" name="pwd2" id="pwd2" class="form-control" placeholder="비밀번호 확인"
                              reaquired></input>
                            <div class="col-md-10 mb-3">
                              &nbsp;
                              <div class="alert alert-success" id="alert-success" style="display: none;">비밀번호가 일치합니다.</div>
                              <div class="alert alert-danger" id="alert-danger" style="display: none;">비밀번호가 일치하지 않습니다.</div>
                            </div>
                          </div>
                          
                                          <div class="col-md-10 mb-3">
                  <div class="department">
                    <label for="department">소속기관</label>
                    <input type="tel" class="form-control" id="inputdept" placeholder="소속기관 입력해 주세요"
                      required>
                    &nbsp;

                    <!-- Button trigger modal-->
                    <button type="button" class="btn btn-outline-secondary" data-toggle="modal" data-target="#modalCart">소속기관
                      찾기</button>
                    &nbsp;
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
                            <form class="d-flex" method="" action="" role="search">
                              <input class="form-control me-2" type="search" placeholder="Search" id="searchDept"
                                aria-label="Search">
                              <button class="btn btn-outline-success" type="submit" onclick="ajax()" style="height: 38px;"><i class="bi bi-search"></i></button>
                            </form>
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
                    
                      <!-- position Selection -->
                   <label for="position-select">직급 : </label>
                   <select id="position-select">
                      <option value="">== 직급을 선택해주세요 ==</option>
                      <option value="1">서기보</option>
                      <option value="2">서기</option>
                      <option value="3">주사보</option>
                      <option value="4">주사</option>
                      <option value="5">사무관</option>
                      <option value="6">서기관</option>
                      <option value="7">부이사관</option>
                      <option value="8">이사관</option>
                      <option value="9">관리관</option>
                   </select>
					<input type="hidden" name="deptCode" id="deptCode" />
                  </div>
                </div>

                          <div class="col-md-10 mb-3">
                            <label for="inputPhoneNum">휴대폰 번호</label>
                            <input type="tel" name="phone_num" class="form-control" id="inputPhoneNum"
                              placeholder="휴대폰번호를 입력해 주세요" required>
                          </div>
                          <div class="col-md-10 mb-3">
                            <label for="inputDeptNum">부서 번호</label>
                            <input type="tel" name="dept_num" class="form-control" id="inputDeptNum" placeholder="사무실번호를 입력해 주세요"
                              required>
                          </div>
          
                          <div class="mb-4">
                            <br>
                          <button class="btn btn-primary btn-lg btn-block" type="submit">수정 완료</button>
                        </div>
                        </form>
                      </div>
                    </div>
          
                  </div>


                 
  
  
              </span>
  
              <!-- 마이태그 수정 -->
              <span id="mypage_mytag">
                <h2> 마이태그 수정 </h2>
                <div style="margin-top:40px; margin-left:40px;" class="content">
                  <div style="display: flex;">
                    <input type="text" id="tag" size="20" placeholder="태그입력" disabled="" />
                  </div>
  
                  <ul id="tag-list">
                  </ul>
  
                </div>
  
              </span>
            </div>
          </div>
        </div>
      </div>
  
    </div>
  </div>
  
  <footer class="container-fluid text-center">
    <p>Footer Text</p>
  </footer>
</body>
<!--script-->
  <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
  <script>
    // sidebar  
    function body_convert(id) {
      let var1 = document.querySelector("#mypage_mywriting")
      let var2 = document.querySelector("#mypage_starmark")
      let var3 = document.querySelector("#mypage_personalInfo")
      let var4 = document.querySelector("#mypage_mytag")
      let html
  
      if (id == mypage_mywriting) {
        var1.style.display = "block";
        var2.style.display = "none";
        var3.style.display = "none";
        var4.style.display = "none";
  
      } else if (id == mypage_starmark) {
        var1.style.display = "none";
        var2.style.display = "block";
        var3.style.display = "none";
        var4.style.display = "none";
  
      } else if (id == mypage_personalInfo) {
        var1.style.display = "none";
        var2.style.display = "none";
        var3.style.display = "block";
        var4.style.display = "none";
  
      } else {
        var1.style.display = "none";
        var2.style.display = "none";
        var3.style.display = "none";
        var4.style.display = "block";
  
      }
    }
  
  
    // mytag
    $(document)
      .ready(function () {
  
        var tag = {};
        var counter = 0;
        var test = document.querySelector("#tag")
  
        // 태그를 추가한다.
        function addTag(value) {
          if (tag != null) {
            // disabled 를 활용해 input 비활성화
            //test.setAttribute("disabled","true")
            $('.tag') = $('.tag').attr('disabled', true);
          } else {
            tag[counter] = value; // 태그를 Object 안에 추가
            counter++; // counter 증가 삭제를 위한 del-btn 의 고유 id 가 된다.
          }
  
        }
        // 최종적으로 서버에 넘길때 tag 안에 있는 값을 array type 으로 만들어서 넘긴다.
        function marginTag() {
          return Object.values(tag)
            .filter(function (word) {
              return word !== "";
            });
        }
  
        $("#tag").on("keyup", function (e) {
          var self = $(this);
          console.log("keypress");
  
          // input 에 focus 되있을 때 엔터 및 스페이스바 입력시 구동
          if (e.key === "Enter" || e.keyCode == 32) {
  
            var tagValue = self.val(); // 값 가져오기
  
            // 값이 없으면 동작 안합니다.
            if (tagValue !== "") {
              // 같은 태그가 있는지 검사한다. 있다면 해당값이 array 로 return 된다.
              var result = Object.values(tag)
                .filter(function (word) {
                  return word === tagValue;
                })
  
              // 태그 중복 검사
              if (result.length == 0) {
                $("#tag-list")
                  .append("<li class='tag-item'>" + tagValue + "<span class='del-btn' idx='" + counter + "'>x</span></li>");
                addTag(tagValue);
                self.val("");
              } else {
                alert("태그값이 중복됩니다.");
              }
            }
            e.preventDefault(); // SpaceBar 시 빈공간이 생기지 않도록 방지
  
          }
        });
  
  
  
  
        // 삭제 버튼
        // 삭제 버튼은 비동기적 생성이므로 document 최초 생성시가 아닌 검색을 통해 이벤트를 구현시킨다.
        $(document)
          .on("click", ".del-btn", function (e) {
            var index = $(this)
              .attr("idx");
            tag[index] = "";
            $(this)
              .parent()
              .remove();
          });
      });
  

  
  <!--비밀번호 동일성 확인-->

    function test() {
      var p1 = document.getElementById('pwd1').value;
      var p2 = document.getElementById('pwd2').value;
      if (p1 != p2) {
        alert("비밀번호가 일치 하지 않습니다");
        return false;
      } else {
        alert("비밀번호가 일치합니다");
        return true;
      }
  
    }
  
    var p1 = document.getElementById('pwd1');
    var p2 = document.getElementById('pwd2');
    let correct = document.getElementById('alert-success');
    let wrong = document.getElementById('alert-danger');
  
    p2.addEventListener("focusout", () => {
      let p1v = p1.value;
      let p2v = p2.value;
      if (p1v == p2v) {
        correct.style.display = "block";
        wrong.style.display = "none";
      } else {
        correct.style.display = "none";
        wrong.style.display = "block";
      }
    })

  
  
  <!--소속기관 찾는 팝업창-->

    function showPopup() {
      window.open("dept_popup.html",
        "a",
        "width=1000, height=1000, left=100, top=50"
      );
    }
  
    const dept = document.querySelector("#inputdept")
    dept.addEventListener("click",()=>{
      alert("hi")
    })
  </script>
</html>