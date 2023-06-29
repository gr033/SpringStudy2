<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#keyfield").change(function(){
		var col = $(this).val(); 
		if(col=="price"){
			$("#cal").css("display", "inline");
		}else{
			$("#cal").css("display", "none");
		}
	});
});
</script>
</head>
<body>
	<h2>도서목록</h2>
	<form action="listBook" method="post">
		<select name="keyfield" id="keyfield">
			<option value="bookname">도서명</option>
			<option value="publisher">출판사</option>
			<option value="price">가격</option>
		</select>
		<select name="cal" id="cal">
			<option value="<="><=</option>
			<option value="<"><</option>
			<option value=">=">>=</option>
			<option value=">">></option>
			<option value="=">=</option>
		</select>
		<input type="search" name="keyword">
		<input type="submit" value="검색">
	</form>
	<table border="1" width="80%">
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>출판사</th>
			<th>가격</th>
		</tr>
		<c:forEach var="b" items="${list }">
			<tr>
				<td>${b.bookid }</td>
				<td>
					<a href="detailBook?bookid=${b.bookid }">${b.bookname }</a>
				</td>
				<td>${b.publisher }</td>
				<td>${b.price }</td>
			</tr>
		</c:forEach>
	</table><br>
	<a href="insertBook">도서 등록</a>
</body>
</html>