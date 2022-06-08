# KDT _ HRD 풀스택 개발자 양성과정 프로젝트 ( JAVA )

## 프로젝트 Description

### 프로젝트명 : Docgram

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
	 	- 모든 유저들이 공지사항 확인가능

- 상세검색 페이지
	
 - 문서 작성 페이지
 	
	- 작성 시 태그 지정 작성 방법 [ (예) #해시 #태그 #지정 ] 지정하여
	 

2. 문서 별 즐겨 찾기 및 부서별 즐겨 찾기 지정
문서별 별표시는 이용자 즐겨 찾기를 지정을 통하여 

3. 로그인 기능

5. 게시판 기능
6. 
7. 작성 기능

9. 상세 보기 기능

7. 마이페이지

8. 





# Readme 작성 예시.

## Readme 는 기능 설명 . 에 대한 내용을한다?
### 들어갈 내용들
Jung Hyun


