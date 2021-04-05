<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성하기</title>
<link rel="stylesheet" href="${path}/resources/css/style.css">
<style>
#list {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#list td, #list th {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: center;
}

#list tr:nth-child(even) {
	background-color: #f2f2f2;
}

#list tr:hover {
	background-color: skyblue;
}

#list th, #definition   {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: center;
	background-color: darkslategray;
	color: white;
}

#editButton {
	width: 80px;
	margin: auto;
	border: 1px;
	background: lightgray;
	padding : 5px 5px;
	text-align: center;
	font-weight: bold;
}
#deleteButton {
	width: 80px;
	margin: auto;
	border: 1px;
	background: lightgray;
	padding : 5px 5px;
	text-align: center;
	font-weight: bold;
}
#addButton {
	width: 100px;
	margin: auto;
	border: 1px;  /*  #04B45F; */
	background: lightgray;
	padding : 5px 5px;
	text-align: center;
	font-weight: bold;
}
#cancelButton {
	width: 100px;
	margin: auto;
	border: 1px;
	background: lightgray;
	padding : 5px 5px;
	text-align: center;
	font-weight: bold;
}
#editOkButton {
	width: 100px;
	margin: auto;
	border: 1px; /*  #74a7f7; */
	background: lightgray;
	padding : 5px 5px;
	text-align: center;
	font-weight: bold;
}
#registerButton {
	width: 100px;
	margin: auto;
	border: 1px;
	background: lightgray;
	padding : 5px 5px;
	text-align: center;
	font-weight: bold;
}

#fontcolor {
	color : white;
}

#list th, #definition {
	background-color: skyblue;
}


</style>

</head>
<body>
<script>
function changeformat(){
  document.getElementById("customFile").files,
  
}
</script>
    <!-- <p>test</p> -->
	<h1>새 물품 등록하기</h1>
	<form:form commandName="vo" action="addok" method="post" enctype="multipart/form-data">
		<table id="list">
			<tr>
				<td id="definition">Lost/Found</td>
				<td><input type="radio" id="lost" name="lost" value="0" checked>
					<label for="lost">Lost</label> <input type="radio" id="found"
					name="lost" value="1"> <label for="found">Found</label></td>
			</tr>
			<tr>
				<td id="definition">제목</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td id="definition">상품명</td>
				<td><input type="text" name="category" /></td>
			</tr>
			<tr>
				<td id="definition">사진 첨부</td>
				<td><input name="photofile" type="file" class="form-control" id="photofile"></td>
			</tr>
			<tr>
				<td id="definition">분실/습득 날짜</td>
				<td><input type="date"
					id="lost_found_date" name="lost_found_date"></td>
			</tr>
			<tr>
				<td id="definition">글쓴이</td>
				<td><input type="text" name="writer" /></td>
			</tr>
			<tr>
				<td id="definition">내용</td>
				<td><textarea cols="50" rows="5" name="content"></textarea></td>
			</tr>
			<tr>
				<td id="definition">특징</td>
				<td><textarea cols="50" rows="5" name="feature"></textarea></td>
			</tr>

		</table>
		<br />
		<button type="button" id="cancelButton" onclick="history.back()">목록보기</button>
		<button type="submit" id="registerButton">등록하기</button>
	</form:form>

</body>
</html>