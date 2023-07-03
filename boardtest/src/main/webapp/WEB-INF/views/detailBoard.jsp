<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 상세</h2>
	글번호: ${b.no }<br> 
	글제목: ${b.title } <br>
	작성자: ${b.writer } <br>
	작성일: ${b.regdate } <br>
	<textarea rows="10" cols="60" readonly="readonly">${b.content }</textarea><br>
	조회수: ${b.hit }<br>
	<img src="upload/${b.fname }">
	<hr>
	<a href="insertBoard?no=${b.no }">답글 작성</a><br>
	<a href="updateBoard?no=${b.no }">수정</a><br>
	<a href="deleteBoard?no=${b.no }">삭제</a><br>
	<a href="listBoard">목록으로</a><br>
	
</body>
</html>