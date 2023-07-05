<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 등록</h2>
	<hr>
 	<form action = "insertBoard" method="post" enctype="multipart/form-data">
		<input type="hidden" value="${no }" name="no">
		글제목: <input type="text" name="title"><br>
		작성자: <input type="text" name="writer" value="${id }" readonly="readonly"><br>
		글암호: <input type="password" name="pwd"><br>
		글내용: <br>
		<textarea rows="15" cols="60" name="content"></textarea><br>
		
		첨부파일: <input type="file" name="uploadFile"><br>
		<input type="submit" value="등록"><br>
		<input type="reset" value="재작성">
	</form>
</body>
</html>