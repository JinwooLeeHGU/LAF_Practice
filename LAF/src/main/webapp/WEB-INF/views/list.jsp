<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/uikit@3.5.16/dist/css/uikit.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="${path}/resouces/css/liststyle.css">

</head>
<body>
	<span id="name"> </span>

	<span class="username"> welcome <strong>
			${login.username} </strong>
	</span>

	<%@include file="./modules/header.jsp"%>
	<%@include file="./modules/navbar.jsp"%>

	<table id="list" width="90%">
		<c:forEach items="${list}" var="u">

			<div class="card">
				<div class="seq">${u.seq}</div>
				<div class="image">

					<img
						src="${pageContext.request.contextPath}/resources/upload/${u.photourl}"
						style="box-sizing: border-box; width: 100%; height: 230px" />
				</div>
				<div class="description">

					<script>
						var lf = $
						{
							u.lost
						};
						if (lf)
							document
									.write('<span style="background-color:#CBECBB; padding:1.5px 3px; border-radius: 3px;">Found</span>');
						else
							document
									.write('<span style="background-color:#F1CBC2; padding:1.5px 3px; border-radius: 3px;">Lost</span>');
					</script>

					<span class="title">${u.title}</span>

					<div class="name">카테고리 : ${u.category}</div>

					<div class="price">작성자 : ${u.writer}</div>

					<div class="other" style="box-sizing: border-box; height: 50px;">비고
						: ${u.content}</div>

					<div class="regdate">작성일자 : ${u.regdate}</div>

					<div id="buttonArea">
						<div id="editButton">
							<a id="fontcolor" href="editform/${u.seq}">Edit</a>
						</div>

						<div id="deleteButton">
							<a id="fontcolor" href="javascript:delete_ok('${u.seq}')">Delete</a>
						</div>

					</div>

				</div>


			</div>
		</c:forEach>
	</table>
	<br>
	<%@include file="./modules/footer.jsp"%>
</body>
</html>