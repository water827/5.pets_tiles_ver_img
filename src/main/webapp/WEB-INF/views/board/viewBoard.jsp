<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("UTF-8");
%>      
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" >
	<link href="${pageContext.request.contextPath}/resources/css/kfonts2.css" rel="stylesheet" >
<title>상세조회 페이지</title>
<style type="text/css">
		#tr_btn_mod {
			display: none;
		}
		table{
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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
		
	
	function fn_enable(obj) {
		obj.action = "${contextPath}/board/updateForm.do"
		obj.submit();
	}
	
	function backToList(obj) {
		obj.action = "${contextPath}/board/listBoards.do"
		obj.submit();
	}
	function removeList(obj) {
		obj.action = "${contextPath}/board/removeBoard.do?qa_No=${vo.qa_No}"
		obj.submit();
	}
	
	
	function fn_reply_form(url, qa_No) {
		var form = document.createElement("form");
		form.setAttribute("method", "post");
		form.setAttribute("action", url);
		
		var parentNoInput = document.createElement("input");
		parentNoInput.setAttribute("type", "hidden");
		parentNoInput.setAttribute("name", "parentNo");
		parentNoInput.setAttribute("value", parentNo);
		
		form.appendChild(parentNoInput);
		document.body.appendChild(form);
		form.submit();
	}
</script>
</head>
<body>
<form action="${contextPath}" name="frmBoard" method="post" enctype="multipart/form-data">
	<h1 align="center">게시판 상세정보 출력</h1>
	<table border="1" align="center" width="80%" >
			
			<tr>
				<td width="200"><p align="center">문의번호</td>
				<td width="300"><input type="text" name="qa_No" value="${vo.qa_No}" disabled/></td>
			</tr>
				
			<tr>
				<td width="200"><p align="center">제목</td>
				<td width="300"><input type="text" id="qa_title_mod" name="qa_title" value="${vo.qa_title}" disabled /> </td>
			</tr>
			
			<tr>
				<td width="200"><p align="center">문의종류</td>
				<td width="300"><input type="text" id="qa_category_mod" name="qa_category" value="${vo.qa_category}" disabled  /> </td>
			</tr>
			
			<tr>
				<td width="200"><p align="center">내용</td>
				<td width="300"><textarea rows="4" id="qa_content_mod" cols="40" name="qa_content" disabled>${vo.qa_content}</textarea> </td>
			</tr>
			
			<tr>
				<td width="200"><p align="center">등록일</td>
				<td width="300"><input type="text" name="qa_date" value="${vo.qa_date}" disabled/> </td>
			</tr>
			
			<tr>
				<td width="200"><p align="center">등록자</td>
				<td width="300"><input type="text" name="user_id" value="${vo.user_id}" disabled/> </td>
			</tr>
			
			<tr id="tr_btn">
				<td colspan="2" align="center">
					<input type="button" value="수정하기" onclick="fn_enable(this.form)" />
					<input type="button" value="삭제하기" onclick="removeList(this.form)">
					<input type="button" value="게시글목록" onclick="backToList(this.form)">
					<input type="button" value="답급달기" onclick="fn_reply_form('${contextPath}/board/replyForm.do', ${board.qa_No})" />   <!-- 요청명과 글번호를 전달함  -->
				</td>
			</tr>
	</table>
	</form>
</body>
</html>