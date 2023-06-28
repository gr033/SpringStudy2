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
		if(re){
			location.href = "deleteBook?bookid="+bookid;
		}
	}

</script>
</head>
<body>
<input type="hidden" value="${b.bookid }" class="bookid">
	<h2>도서 정보</h2>
	<hr>
	도서번호: ${b.bookid }<br>
	도서명: ${b.bookname }<br>
	출판사: ${b.publisher }<br>
	가격: ${b.price }
	<hr>
	<a href="updateBook?bookid=${b.bookid }">도서 수정</a><br>
	<a href="#" onclick="deleteBook(${b.bookid})">도서 삭제</a><br>
	<a href="listBook">도서 목록</a>
</body>
</html>