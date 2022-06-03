<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>문서상세보기</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
  
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



<<<<<<< HEAD
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    </div>
    <div class="col-sm-8 text-left"> 
      
      <div class="all">
        <!-- 출력 문서 제목 -->
            <h3 class="title-article">${문서 제목}<h3>
    
    
    
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
                        <td> 윤구 </td>
                        <th scope="row" class="tline" itemprop="contributor">작성일</th>
                        <td class="tline">2022/5/5</td>
                    </tr>
    
                    <tr>
                        <th scope="row" itemprop="accountablePerson">문서 관리 번호</th>
                        <td>D2001245</td>
                        <th scope="row" itemprop="dateCreated">
                            전화번호
                        </th>
                        <td>010-4393-2445</td>
                    </tr>
    
                    <tr>
                        <th scope="row">소속기관</th>
                        <td colspan="3" style="flex-wrap: nowrap"> 세종청사 > 어저꾸저꾸부 > 무슨무슨팀 </td>
                    </tr>
                </tbody>
            </table>
    
        </div>
    
        <hr>
        <div class="btnlist">
            <button class="btn"><i class="bi bi-star-fill"></i></button> 
            <button class="btn"><i class="bi bi-megaphone-fill"></i></button> 
        </div>
        <hr>
    
        <!-- 해시태그 정보 -->
        <div class="hashlist">
            <div>
                <h4 class="hash"> 해시태그 정보 </h4>
            </div>
    
            <div>
                <ul class="hashdetail">
                    <li>
                        <a>
                            #윤구 #재범 #예빈
                        </a>
                    </li>
                </ul>
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
                        대충 문서 내용이 나와야하는 부분
                        </p>
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
                            <p class="file-down"> </p>
                            <p class="title-down">20220322142339618.hwp <span class="txt-gray">(185 KB)</span></p> <span
                                class="btn-downset"> <button type="button" onclick="docview('F0000090178239', 'hview');"
                                    class="btn btn-view">문서보기</button>
                                <a href="/og/com/download.php?uri=%2Ffiles%2Fdcdata%2F100049%2F20220322%2FF0000090178239.hwp&dname=20220322142339618.hwp"
                                    class="btn btn-download btn-original" style='margin-left:5px'><i class="icon-img icon-down"></i>
                                    <button class="element-invisible">다운로드</button></a> </span>
                            <p></p>
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
                    <!-- 문서 시작 -->
                    <li>
                        <div>
                            <a href="">
                                    세종 청사의 공공기관 관련한 보고서1
                            </a>
                        </div>
                            <p>
                                <span class="date">
                                    <strong>
                                        작성(등록일)
                                    </strong>
                                    2022-03-22
                                </span>
                                <span>
                                    <strong>
                                        기관
                                    </strong>
                                    시설부서
                                </span>
    
                            </p>
                    </li>
                    <!-- 문서 끝 -->
    
                    <li>
                        <div>
                            <a href="">
                                    <strong>문서 제목</strong>
                                    세종 청사의 공공기관 관련한 보고서1
                            </a>
                        </div>
                            <p>
                                <span class="date">
                                    <strong>
                                        등록일
                                    </strong>
                                    2022-03-22
                                </span>
                                <span>
                                    <strong>
                                        부서
                                    </strong>
                                    시설부서
                                    시설부서
                                </span>
    
                            </p>
                    </li>
    
                    <li>
                        <div>
                            <a href="">
                                    <strong>문서 제목</strong>
                                    세종 청사의 공공기관 관련한 보고서1
                            </a>
                        </div>
                            <p>
                                <span class="date">
                                    <strong>
                                        등록일
                                    </strong>
                                    2022-03-22
                                </span>
                                <span>
                                    <strong>
                                        부서
                                    </strong>
                                    시설부서
                                </span>
    
                            </p>
                    </li>
    
                </ul>
            </div>
        </div>
        <hr>
    
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
=======
</html>
>>>>>>> 737b6579f9fc0c5d04e9cd85323a62155a815251
