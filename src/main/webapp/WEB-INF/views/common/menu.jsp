<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% request.setCharacterEncoding("utf-8"); %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

		<!-- jquery연결시 필요한 태그 -->
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script type="text/javascript">
			
			  $(document).ready(function() {
				    $(".main").hover(
				      function() {
				        $(".submenu").stop().slideDown(400);
				      },
				      function() {
				        $(".submenu").stop().slideUp(600);
				      }
				    );
		
				    $(".submenu").hover(
				      function() {
				        $(".submenu").stop().slideDown(400);
				      },
				      function() {
				        $(".submenu").stop().slideUp(600);
				      }
				    )
		
				  
				  });
		
		</script>
		<style>
			* {margin: 0; padding: 0; }
			li {list-style: none; }
			body {width: 1200px; margin: 0 auto; }
			a{text-decoration:none; color: black;}
			           
			.logo {
				margin: 50px 20px;
				font-size: 30px; 
				text-align: left; 
				font-family: 'Nanum Gothic', sans-serif;
			}
			
			.main{
				width: 100%; 
				margin-bottom: 40px; 
				text-align: center; 
				height: 40px; 
			}
			
			
			
			.main:after {
				content: ""; 
				display: block; 
				clear: both; }
			
			.mainmenu>li {
				float: left; 
				width: 20%; 
				line-height: 40px; 
			}
			.mainmenu span {
				font-size: 15px; 
				font-weight: bold; 
			}
			
			.submenu {
				display: none; 
				padding: 10px 0; 
				border-bottom: 1px solid #ccc;
				/* background-color: #FFEDC3; */
				height:150px;
				position: absolute;
				align-content: center;
				}
				
				      
			#sub {
				float: none;
				height:40px;
			}
			
			
			            
			.none:after {content: ""; display: block; clear: both}
			
			.login{
				background-color: pink;
				list-style: none;
				text-align: right;
			}
			
		</style>
		
		
	<div class="container">
		<div style="text-align: right;">
			<c:choose>
					<c:when test="${isLogOn == true && member != null }">
						<h3>환영합니다. ${member.user_NAME}님</h3>
						<a href="${contextPath}/member/logout.do"><h3>로그아웃</h3></a>
					</c:when>
					<c:otherwise>
						<a href="${contextPath}/member/loginForm.do"><h3>로그인</h3></a>
					</c:otherwise>
				</c:choose>
		</div>
		
	<!-- 로고 -->
		<div class="logo">
			<span class="logo"><a href="${contextPath}/main.do">아마레 펫츠</a></span>
			
		</div>
		

		<div class="main">
			<ul class="mainmenu">
				
				<!--  About  -->
				<li><span>About</span>
					<ul class="submenu">
						<li id="sub"><a href="${contextPath}/about/about.do">소개</a></li>
					</ul>
				</li>
				
				<!-- Pets -->
				<li><span>Pets</span>
					<ul class="submenu">
						<li id="sub"><a href="${contextPath}/protect/listBoards.do">유기동물</a></li>
						<li id="sub"><a href="#">실종동물</a></li>
						<li id="sub"><a href="#">임시보호 요청</a></li>
						<li id="sub"><a href="#">애완용품</a></li>
					</ul>
				</li>
				
				<!-- Notice -->
				<li><span>Notice</span>
					<ul class="submenu">
						<li id="sub"><a href="${contextPath}/notice/listNotices.do">공지사항</a></li>
					</ul>
				</li>
				
				<!-- Info -->
				<li><span>Info</span>
					<ul class="submenu">
						<li id="sub"><a href="${contextPath}/board/faqPage.do">자주하는 질문</a></li>
						<li id="sub"><a href="${contextPath}/board/shelter_location.do">보호소 위치</a></li>
						<li id="sub"><a href="${contextPath}/board/listBoards.do">문의하기</a></li>
					</ul>
				</li>
				
				<!-- MyPage -->
				<li><span>MyPage</span>
					<ul class="submenu">
						<li id="sub"><a href="#">개인정보수정</a></li>
						<li id="sub"><a href="#">반려동물</a></li>
					</ul>
				</li>	
			</ul>
		</div>
	
	</div>














