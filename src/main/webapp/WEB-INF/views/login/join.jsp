<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%--
 Class Name : Join.JavaScript
 Description : 회원가입 페이지
 Author : 문예빈
 Since : 2022-05-30
--%>
    <!DOCTYPE html>
    <html lang="ko">

    <head>
      <meta charset="UTF-8">
      <meta http-equiv="Content-Type" content="text/html">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>회원가입 화면</title>

      <link href="../resources/css/login.css" rel="stylesheet">
      <link href="../resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="../resources/css/bootstrap.css" rel="stylesheet">
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
      <script src="../resources/js/bootstrap.min.js"></script>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>


    <body>
   <div class="all">
      <form action="" method="" class="sign-form">
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
                    <input type="tel" name="dept" class="form-control" id="inputdept" placeholder="소속기관 입력해 주세요"
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
                          <!--Header-->
                          <div class="modal-header">
                            <h4 class="modal-title" id="myModalLabel">
                              <a class="navbar-brand">
                                <i class="bi bi-patch-question"></i>
                                기관검색
                              </a>
                            </h4>
                            <form class="d-flex" method="" action="" role="search">
                              <input class="form-control me-2" type="search" name="search" placeholder="Search"
                                aria-label="Search">
                              <button class="btn btn-outline-success" type="submit" style="height: 38px;"><i class="bi bi-search"></i></button>
                            </form>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                              <span aria-hidden="true">×</span>
                            </button>
                          </div>
                          <!--Body-->
                          <div class="modal-body">

                            <table class="table table-hover">
                              <thead>
                                <tr>
                                  <th>#</th>
                                  <th>기 관 명</th>
                                </tr>
                              </thead>
                              <tbody>
                                <tr>
                                  <th scope="row">1</th>
                                  <td>${dept.name}</td>
                                </tr>
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
                   <select name="position" id="position-select">
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

                <hr class="mb-4">
                <div class="custom-control custom-checkbox">
                  <input type="checkbox" class="custom-control-input" id="aggrement" required>
                  <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
                </div>
                <div class="mb-4"></div>
                <button class="btn btn-primary btn-lg btn-block" type="submit">가입 완료</button>
              </form>
            </div>
          </div>

        </div>
      </form>
</div>
    </body>

    <!--비밀번호 동일성 확인-->
    <script type="text/javascript">
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
    </script>

    <!-- <script>

  // $('#btn').click(function(){
  //   $('#alert-success').removeClass('hidden');
  // })
  // $('alert-success').focusout(function(){
  //   $(this).addClass('hidden');
  // });

$(function(){
    $("btn").click(function(){
      var pwd1=$("#pwd1").val();
      var pwd2=$("#pwd2").val();
      if(pwd1 != "" || pwd2 != ""){
        if(pwd1 == pwd2){
          $("alert-success").show();
          $("alert-danger").hide();
          $("#submit").removeAttr("disabled");
        } else {
          $("alert-success").hide();
          $("alert-danger").show();
          $("#submit").removeAttr("disabled", "disabled");
        }
      }
    });
  });

</script> -->



    </html>