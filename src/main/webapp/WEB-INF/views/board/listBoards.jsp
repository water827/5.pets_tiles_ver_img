<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />  
<c:set var="boardsList" value="${boardMap.boardsList }" />
<c:set var="totBoards" value="${boardMap.totBoards }" />
<c:set var="section" value="${boardMap.section }" />
<c:set var="pageNum" value="${boardMap.pageNum }" /> 
<%
	request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" >
	<link href="${pageContext.request.contextPath}/resources/css/kfonts2.css" rel="stylesheet" >
	<title>문의 사항</title>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<style type="text/css">
		.table{
		    width: 70%;
		    border-collapse: collapse;
		    line-height: 24px;
		}
		th {
		    border-top:1px solid black;
		    border-bottom:1px solid black;
		    border-collapse: collapse;
		    text-align: center;
		    padding: 13px;
		    background: rgb(221, 221, 221);
		}
		td{
			border-bottom: 1px solid gray;
			padding : 10px;
		}
	
	</style>
</head>
<body>

	<table class="table table-hover">
		<tr>
    			<td colspan="5" style="display:inline-block; align:right; border:white;">
    				<a href="${contextPath}/board/boardForm.do">문의 작성하기</a>
    			</td>
    		</tr>
		<tr>
			<th style="width:10%;"><b>번호</b></th>
			<th style="width:20%;"><b>아이디</b></th>
			<th style="width:50%;"><b>제목</b></th>
			<th style="width:10%;"><b>카테고리</b></th>
			<th style="width:10%;"><b>날짜</b></th>
		</tr>
		
		
		<c:choose>
			<c:when test="${empty boardsList }">
				<tr height="10">
					<td colspan="5">
						<p align="center">
							<b><span style="font-size: 9pt;">등록된 글이 없습니다.</span></b>
						</p>
					</td>
				</tr>
		</c:when>
		
		<c:when test="${!empty boardsList }">
		<c:set var="num" value="${boardMap.totBoards - ((boardMap.pageNum-1)*10) }" />
		<c:forEach var="board" items="${boardsList }" varStatus="boardNum" >
			<tr align="center">
				<td>${num }</td>
				<td>${board.user_id }</td>
				<td>
			<c:choose>
				<c:when test="${board.level > 1 }">
					<c:forEach begin="1" end="${board.level }" step="1">
						<span style="padding-left: 5px;"></span>
					</c:forEach>
					<span style="font-size: 12px; color: red">[답변]</span><a href="${contextPath}/board/viewBoard.do?qa_No=${board.qa_No}">${board.qa_title }</a>
			 </c:when>	
			 <c:otherwise>
			 	<a href="${contextPath}/board/viewBoard.do?qa_No=${board.qa_No}">${board.qa_title }</a>
			 </c:otherwise>
			</c:choose>	
			 </td>
				<td>${board.qa_category }</td>
				<td>${board.qa_date }</td>
			</tr>
			<c:set var="num" value="${num-1 }"></c:set>
		</c:forEach>
		</c:when>
		
		</c:choose>
	</table>

	<div class="class2">
		<c:if test="${totBoards != null }">
			<c:choose>
				<c:when test="${totBoards > 100 }">			<!-- 글 개수가 100 초과인 경우 -->
					<c:forEach var="page" begin="1" end="10" step="1">
						
						<c:if test="${section > 1 && page == 1 }">
							<a class="no-line"  href="${contextPath}/board/listBoards.do?section=${section-1}&pageNum=${(section-1)*10 +1}">&nbsp; pre </a>
						</c:if>
						
						<a style="font-size: 20px; color: black;" class="no-line" href="">${(section-1)*10 +page}</a>		<!-- 실제페이지 숫자표시 -->
						
						<c:if test="${page == 10 }">
							<a class="no-line" href="${contextPath}/board/listBoards.do?section=${section+1}&pageNum=${section*10 +1}">&nbsp; next </a>
						</c:if>						
						
					</c:forEach>
				</c:when>
				
				<c:when test="${totBoards == 100 }">			<!-- 등록된 글 개수가 100개인 경우 -->
					<c:forEach var="page" begin="1" end="10" step="1">
						<a class="no-line" href="#">${page}</a>
					</c:forEach>
				</c:when>
				
				<c:when test="${totBoards < 100}">			<!-- 글 개수가 100 미만인 경우 -->
					<c:forEach var="page" begin="1" end="${totBoards/10 +1}" step="1">
						<c:choose >
							<c:when test="${page == pageNum}">
								<a class="sel-page" href="${contextPath}/board/listBoards.do?section=${section}&pageNum=${page}">${page}</a>
							</c:when>
							<c:otherwise>
								<a class="no-line" href="${contextPath}/board/listBoards.do?section=${section}&pageNum=${page}">${page}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>				
				</c:when>
				
			</c:choose>
		</c:if>
	</div>

</body>
</html>