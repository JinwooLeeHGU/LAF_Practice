<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>

img, label {
	display: inline-block;
}

label {
	width: 130px;
}

#Lost {
	color: orange;
}

#Found {
	color: skyblue;
}

button {
	background-color: white;
	color: #6D6F74;
	font-size: 13.5px;
	padding: 12px 29px;
	border: 0;
	outline: 0;
	box-shadow: 0 2.5px 3px 0 rgba(0, 0, 0, 0.2);
}

.g-signin2 {
	width: 100%;
}

.g-signin2>div {
	margin: 0 auto;
}

</style>
<meta name="google-signin-client_id"
	content="60396027837-iev9qsg4ud3cb4plotgs65c6co5q9si9.apps.googleusercontent.com">
</head>
<script src="https://apis.google.com/js/platform.js?onload=init" async
	defer></script>


<body>
	<div
		style='width: 100%; text-align: center; padding-top: 100px; display: inline;'>
		<form method="post" action="loginOk" id="frm">
			<h1 id=headername style="font-size: 35px;">
				<span id="Lost" style="font-size: 35px;">Lost</span> & <span
					id="Found" style="font-size: 35px;">Found</span>
			</h1>
			
			<button type='submit'>회원 로그인</button>
			
		</form>

	</div>

	<br>

</body>

</html>