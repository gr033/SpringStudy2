<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h2>도서목록</h2>
	<hr>
	<table border="1" width="80%">
		<tr>
			<td>아이디</td>
			<td>이름</td>
		</tr>
		<tr th:each="m:${list }">
			<td th:text="${m.id }"></td>
			<td th:text="${m.name }"></td>
		</tr>
	</table>
</body>
</html>