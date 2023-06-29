<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function deleteBook(bookid){
		var re = confirm("정말 삭제하시겠습니까?");
		if(re == true){
			location.href="deleteBook?bookid="+bookid;
		}
	}
</script>
</head>
<body>
	도서번호: ${b.bookid }<br>
	도서명: ${b.bookname }<br>
	출판사: ${b.publisher }<br>
	가격: ${b.price }<br>
	<hr>
	<a href="updateBook?bookid=${b.bookid }">도서 수정</a><br>
	<a href="deleteBook?bookid=${b.bookid }" onclick="deleteBook(${b.bookid})">도서 삭제</a><br>
	<a href="listBook">목록으로</a>
</body>
</html>