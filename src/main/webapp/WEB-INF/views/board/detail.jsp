<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<!-- 헤더 부분 -->

<head>
    <meta charset="UTF-8">
        <link rel="stylesheet" href="css/mypage.css">
        <title>문서상세보기</title>
        <meta http-equiv="Content-Type" content="text/html;">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../css/main.css">
        <link href="../css/bootstrap.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>

    <!-- css 부분 -->
    <style>
    
    	<style>
        .all {
            margin-left: 15%;
            margin-right: 15%;
        }
    
        .title-article {
            display: block;
            max-width: 40%;
            margin: auto;
            border: solid;
            padding: 10px 0;
            font-size: 1.5em;
            font-weight: 700;
            text-align: center;
        }

        #attachment {
            display: inline-block;
            margin-block-start: 1.33em;
            margin-block-end: 1.33em;
            margin-inline-start: 0px;
            margin-inline-end: 0px;
        }

        /* 해쉬 팝업 */
        .hashdetail {
            border: 1px solid ;
        }

        /* 관련 문서 */

        .relationlist {
            padding: 33px 28px 40px;
            border-bottom: 1px solid #bbbcbf;
            line-height: 28px;
            background-color: #fafafa;
        }

        /* 첨부된 문서 */
        .list-attachment {
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #b5b5b5
        }

        .list-attachment li {
            overflow: hidden;
            padding: 5px;
            border-top: 1px dashed #b5b5b5;
            font-size: 0.8125em;
        }

        .list-attachment li:first-child {
            border-top: 0;
        }

        .list-attachment li .title-down {
            float: left;
            margin-top: 5px
        }

        .list-attachment li .title-down span {
            color: #757575;
        }

        .list-attachment li .btn-downset {
            float: right;
        }

        .list-attachment li .btn-downset .btn {
            padding: 0 10px
        }

        .list-attachment li .btn-downset .txt-notopen {
            position: relative;
            display: inline-block;
            margin-top: 5px;
            padding-left: 18px;
            color: #c72868;
        }

        .list-attachment li .btn-downset .txt-notopen:before {
            content: '';
            position: absolute;
            top: -1px;
            left: -1px;
            width: 20px;
            height: 20px;
            background: url(../images/common/ico-sub.png) no-repeat -80px 0;
        }

        .table-wrap {
            margin-bottom: 20px;
            border: 1px solid #b5b5b5;
            border-radius: 5px;
            overflow: hidden;
        }

        table {
            width: 100%;
            margin: 15px 0;
            border-spacing: 0;
        }

        .table-response {
            border-collapse: inherit;
            background: #f8eff3;
        }

        .table-response colgroup {
            display: none
        }

        .table-response tr {
            clear: both;
            overflow: hidden
        }

        .table-response th,
        .table-response td {
            position: relative;
            overflow: hidden;
            float: left;
            display: inline-block;
            border: 1px dashed #b5b5b5;
            border-left: 0;
            border-right: 0;
            border-bottom: 0;
            text-align: left
        }

        .table-response th {
            width: 33%;
            padding: 7px 0 0 10px;
            line-height: 1.1;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            text-align: left;
        }

        .table-response td {
            width: 67%;
            min-height: 40px;
            padding: 5px 10px 8px 10px;
            background: #fff;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box
        }

        .table-response tr th,
        .table-response tr td {
            padding: 0 10px;
            min-height: 55px;
            display: flex;
            flex-direction: column;
            align-items: stretch;
            justify-content: center;
        }

        .table-response tr td {
            flex-direction: row;
            align-items: center;
            justify-content: flex-start;
            flex-wrap: wrap;
        }

        /* 2021-12-16 */
        .table-response tr td a.btn {
            display: block;
            width: 100%;
            margin: 5px 0;
            text-align: center;
        }

        /* 문서 내용 */
        .detail {
            padding: 33px 28px 40px;
            border-bottom: 1px solid #bbbcbf;
            line-height: 28px;
            background-color: #fafafa;
        }
    </style>



</head>
<!-- 헤더 부분 -->


<!-- 바디 부분 -->

<body>
   
  <div class="all">
    <!-- 출력 문서 제목 -->
	
    <h3 class="title-article">${board.title}</h3>


    <!-- 문서 상세 정보 -->
    
    <div class="table-wrap">
        <table class="table table-response">
            <caption> 문서상세 정보 - 작성자 /작성일 / 문서 관리 번호 / 전화번호 /소속기관 </caption>
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
                    <td colspan="3" style="flex-wrap: nowrap"> ${dept.upperNdName} > ${dept.upperStName} > ${dept.name}</td>
                </tr>
            </tbody>
        </table>

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
                   <p>${board.content}</p>
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
                        <p class="title-down">${board.file.name}</p> 
                        <span class="btn-downset">
                            <!-- 문서 보기 버튼-->
                             <button type="button" class="btn btn-view" onclick="showDocs()">문서보기</button>

                            <a href="/download/${board.file.id}" class="btn btn-download btn-original" style='margin-left:5px'>
                                <i class="icon-img icon-down"></i>
                                <button class="element-invisible">다운로드</button>
                            </a> 
                        </span>
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
            <!--  첫번쨰 문서-->
               
                <c:if test="${relationList[0] != null}">
				<c:forEach items="${relationList}" var="relatedBoard">
				<c:if test="${relatedBoard != null}">
                <li>
                    <div>
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
    <hr>
   </div>
</body>

    <!-- script 부분 -->

        <script>
        const tds = document.querySelectorAll("tag");
        tds.forEach((v) => {
            let text = v.innerHTML;
            let tag = text.substring(1);
            v.addEventListener("click" , ()=>{
            	window.location.href = `../read?hashtagList=\${tag}`;     
            })
            })
            
        function showDocs() {
			const url = window.location.host
			window.open(`http://docs.google.com/viewer?url=http://\${url}/resources/static/pdf/${board.id}_${board.file.name}`);
		} 
  
</script>



</html>