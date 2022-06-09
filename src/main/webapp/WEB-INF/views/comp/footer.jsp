<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
 Class Name : Footer.JavaScript
 Description : footer
 Author : 조윤구
 Since : 2022-05-28
--%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="/resources/js/bootstrap.js"></script>
      <link rel="stylesheet" href="/resources/css/bootstrap.css">

        <ul class="nav justify-content-center pb-3" id="footer-ul">
          <li class="nav-item">
            <a href="/main" class="nav-link px-2">Home</a>
          </li>
          <li class="nav-item">
            <a href="https://github.com/JayisSuckAtJava/DocGram" target='_blank' class="nav-link px-2">github</a>
          </li>
          <li class="nav-item">
            <a class="nav-link px-2" data-toggle="modal" data-target="#modalCartfooter" style="cursor:pointer;">FAQs</a>
          </li>
        </ul>
        <hr>
        <p class="text-center">© 2022 G-cloud, Docgram</p>
        
        

                    <!-- Modal: modalCart -->
                    <div class="modal fade" id="modalCartfooter" tabindex="-1" role="dialog"
                      aria-labelledby="exampleModalLabel" aria-hidden="true">
                      <div class="modal-dialog" role="document">
                        <div class="modal-content">
                          <!--Modal Header-->
                          <div class="modal-header">

                            
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                              <span aria-hidden="true">×</span>
                            </button>
                          </div>
                          <!--Modal Body-->
                          <div class="modal-body faqs">

							<span>
							<h5>조 윤구 ( 조장 )</h5>
							<h6>담당 : </h6>
							<p>전화번호 : </p>
							<p>이메일 : </p>
							</span>
							<hr>
							<span>
							<h5>문 예빈</h5>
							<h6>담당 : </h6>
							<p>전화번호 : </p>
							<p>이메일 : </p>
							</span>
							<hr>
							<span>
							<h5>이 재범</h5>
							<h6>담당 : Backend</h6>
							<p>전화번호 : 010-6428-4222</p>
							<p>이메일 : ljb980811@gmail.com</p>
							</span>

                          </div>
                          <!--Footer-->
                          <div class="modal-footer">
                            <button type="button" class="btn btn-outline-primary" data-dismiss="modal">Close</button>
                          </div>
                        </div>
                      </div>
                    </div>
                    <!-- Modal: modalCart -->
