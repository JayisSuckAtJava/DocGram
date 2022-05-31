
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>팝업</title>
    <link href="../resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="../resources/css/bootstrap.css" rel="stylesheet">
    <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../resources/js/bootstrap.min.js"></script>
   
     <style>
        /* 문서 목록 리스트 css */
    .document {
      border-radius: 5px;
      border: solid;
      height: 100px;
      background-color: #f8eff3;;
      margin-left: auto;
      margin-right: auto;
    }
    </style>
</head>
<body>
    <div>
        <form>
            <select name="sel" id="sel">
                <option value="title">제목</option>
                <option value="user">작성자</option>
                <option value="dept">기관</option>
            </select>
            <input type="text" placeholder="게시글 검색" id="text">
            <input type="button"  onclick="ajax()" value="검색">
            
            <hr>
            <input type="text" name="key" id="key">
            <input type="button" value="지정완료">

            <hr>

            <div>

                <!-- 목록 리스트 -->
    <table class="document">

        <thead id="list_title">
  
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>소속 기관</th>
            <th>작성자</th>
          </tr>
        </thead>
  
        <tbody class="list-body">
          <tr>
            <td>10</td>
            <td>공공문서 관련한 문서</td>
            <td>세종특별청사</td>
            <td>부서관</td>
          </tr>
          <c:forEach items="${boardList}" var="board">
          <tr>
             <td>${board.pk}</td>
               <td>${board.title}</td>
               <td>${board.deptDescription}</td>
               <td>${board.userName}</td>
           </tr>
          </c:forEach>
            
        </tbody>
      </table>
      <!-- 목록 리스트 -->
            
        </div>

      </div>

      <!-- 페이징 -->
      <div class="page">
        <nav aria-label="Page navigation example">
          <ul class="pagination justify-content-center">
            <li class="page-item disabled">
              <a class="page-link">Previous</a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">4</a></li>
            <li class="page-item"><a class="page-link" href="#">5</a></li>
            <li class="page-item">
              <a class="page-link" href="#">Next</a>
            </li>
          </ul>
        </nav>
      </div>
    
        </form>
       </div>
       
       
        <hr>
        
        <div  id="container">

        </div>

        <!-- js -->
        <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
        <script>
            function ajax() {
                const sel = document.querySelector("#sel").value
                const text = document.querySelector("#text").value
                const con = document.querySelector("#container")
                alert(`${text} , ${sel}`)

                let ajaxData;

                const data = axios({
                    url: '검색주소',
                    method: 'get',
                    params: {
                        '내가 주는 키': sel ,
                        '내가 주는 키': text
                    }
                });
                data.then(function (result) {
                    console.log(result.data);
                    ajaxData = reuslt.data;
                });

                //ajaxData.?

                con.innerHTML = ajaxData;
            }

    </script>
    

</body>

</html>