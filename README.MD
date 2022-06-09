# KDT _ HRD 풀스택 개발자 양성과정 프로젝트 ( JAVA )

## 프로젝트 Description

![header](https://capsule-render.vercel.app/api?type=waving&color=E3826C&height=250&section=header&text=Docgram%20&fontSize=90&animation=fadeIn&fontAlignY=38&desc=%20&descAlignY=62&descAlign=62)

공공문서 분류 시스템 

기존의 공문서 사이트 이용자 원하는 정보(공문서)를
보다 **빠르고 간편하게 얻기 위한 시스템적 기능을 구현**

-주요 기능

항목별 상세검색 기능, 문서 즐겨찾기, 유저 소속 즐겨찾기, 해시태그 기능 구현, 관련 문서 지정

1. 항목별 상세 검색을 세분화 – 기본 검색 / 항목 검색 / 태그 검색 / 기간 검색으로 세분화
2. 문서 즐겨찾기 - 유저 직접 즐겨찾기를 지정 가능
3. 소속 즐겨찾기 - 유저의 소속의 관리자가 직접 관련 문서 지정하여 소속 유저한테 전달 
4. 해시태그 기능 - 작성자가 직접 문서 관련 태그 지정하여 해시태그로 관련 문서 검색 가능
5. 관련문서 지정 - 작성자가 작성 문서와 관련된 문서 지정 가능하다.

## 프로젝트 Environment
#### 사용된 기술
![java](https://camo.githubusercontent.com/64fff471582dc0763edf9abaebaf343ba03c7a34021313b77c9b4cd00368caf8/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a6176612d3030364435433f7374796c653d666c61742d737175617265266c6f676f3d4a617661266c6f676f436f6c6f723d7768697465)
<img src="https://img.shields.io/badge/Tomcat-F8DC75?style=flat-square&logo=Apache Tomcat&logoColor=black"/></a>
<img src="https://img.shields.io/badge/MariaDB-003545?style=flat-square&logo=MariaDB&logoColor=white"/></a> 

<img src="https://img.shields.io/badge/Spring-6DB33F?style=flat-square&logo=Spring&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Bootstrap-7952B3?style=flat-square&logo=Bootstrap&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Amazon AWS-FF9900?style=flat-square&logo=Amazon AWS&logoColor=white"/></a>

개발 환경 OS - windows 

Spring Legacy (3.점 버전)

WAS 는 Tomcat을 사용

MyBatis를 통해 DB와 연결  

DataBase는 mariaDB로 구현

프론트 엔드 부트스트랩 사용

웹페이지는 JSP 로 제작 jsp - encoding = utf-8

개발 진행과정을 확인 후 상의 후 AWS의 E2C를 통한 배포

### Front-End

jsp 논리적 위치.
src\main\webapp\WEB-INF\views\[ dir 1 ][ dir 2 ]를 기본

[ dir 1 ][ dir 2 ]를 [ 객체 ][ 기능 ].jsp로 한다.

#### css

스타일은 css를 사용한rh 폼을 서버로 전송하는 방식은 get과 post를 사용한다.
해당 jsp file에서만 사용하는 java script를 제외하고는 java script 소스를 jsp에 작성하지 않고,
별도의 js파일에 작성하여 공유한다.



### back-End
 ${프로젝트 명} = 총괄 도메인명


### Prerequisite

Extends - 확장 프로그램

Eclipse web developer Tools 3.23
 
-- dependency--

	Spring frameWork 5.3.20
 
	Mybatis 3.5.9
 
	Apache Commons IO 2.11.0
 
	MariaDB java client 3.0.4
 
-- ENcoding 설정 ---

Window - Preferences

xml jsp css  - encoding = utf-8

workspace - text file encoding - other - utf-8

## features( 구현 기능들)

- 로그인 관련

	- 로그인을 통해서만 사이트 이용 가능
	- 회원가입 개인약관 페이지 표시
	- 회원가입 기능(아이디, 비번, 전화번호, 유저 소속기관 지정 - 모달 처리)

- 게시판 관련 
	- 공지사항 페이지
	 	- 모든 유저들이 공지사항 조회 가능
	- 유저 소속 페이지
		- 유저가 소속한 기관의 관리자가 직접 지정한 특정 게시물 알림 조회 가능
	
- 상세검색 
	- 검색 기능 
		- 기본검색: <elect> 을 통한 게시물 제목 / 내용 / 작성자 / 기관  검색 가능
		- 항목  검색: 직책별 / 파일명 / 문서번호 가능
		- 태그 검색: 태그를 지정 하여 동일한 태그 내용이 들어간 문서 검색 가능 예) #해시 #공공기관
		- 기간 검색: 금일부터  1,3,6개월 1년 검색 가능 
	
 - 문서 작성 
 	- 기본 문서 제목, 상세 내용 작성
	- 작성 시 태그 지정 가능 작성 방법 [ (예) #해시 #태그 #지정 ] 최대 5개
	- 문서 파일 업로드 가능
	- 작성자가 작성 완료된 관련 게시물 modal을 통하여 검색 후 지정 가능

 - 문서 조회 
 	- 작성자 정보 및 소속 확인 가능
 	- 작성자가 지정한 해쉬 조회 가능
 	- 문서 파일 다운로드 가능 
 	- 문서 파일 미리 보기 가능 - google  폼을 사용해서 관련 pdf,hwp.dox 미리 조회 가능
	- 유저가 필요시 개인 즐겨 찾기 지정 (별 모양 아이콘으로 지정 가능)
	- 관리자 소속의 유저들에게 소속 알림 지정 가능 ( 북마크 아이콘으로 지정 가능)
	- 작성자가 지정한 관련 문서 3가지 조회 가능 

 - Mypage 
 	- 작성글 확인
 		- 본인이 작성한 게시물 조회 기능
 	- 즐겨찾기 관리
 		- 유저 개인이 지정한 즐겨찾기 조회 및 취소 기능
 	- 개인정보 조회 및 수정
 		- 소속기관을 제외한 개인정보 수정 가능
 	- My 태그 수정
 		- My 태그 기능 - 메인 페이지에서 자신이 지정한 태그에 대한 상세 검색 바로 조회가능
 		- 유저별 자신의 지정한 태그 설정 추가 및 삭제 가능

 - admin 
 	- 유저별 개인정보 수정 
 		- 유저가 소속한 기관에 대한 수정 기능 (가입시 소속기간관 모달 처리와 동일)
	- 게시물 관리
		- 기본 항목 검색으로 게시물 조회 가능
		- 작성 게시물 삭제 가능 
		- 작성 게시물 별 지정된 해시태그 조회 및 수정 가능
		- 소속별 알림 지정 가능 
	
	

