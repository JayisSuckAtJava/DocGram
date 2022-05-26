<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<!-- 헤더 부분 -->

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DocumentView</title>

    <!-- css 부분 -->
    <style>
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
    <!-- 출력 문서 제목 -->
        <h3 class="title-article">공공문서 관련한 문서 관리 (제목 )</h3>



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
</body>

    <!-- script 부분 -->

        <script>
  const trs = document.querySelectorAll(".list-body > tr");
  trs.forEach((v) => {
    console.log(v);
    let first = v.firstElementChild.getAttribute("key");
    console.log(first)
    v.addEventListener("click", () => {
      alert(`hi u are in ${first}`)
      window.location.href = `board/${first}`
    })
  })
</script>


</html>