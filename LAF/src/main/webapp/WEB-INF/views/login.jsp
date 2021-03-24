<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta charset="UTF-8" name="google-signin-client_id"
	content="1091952631277-n44a5kuq13om818ukiqur5o0q9jrluko.apps.googleusercontent.com">
<!-- 클라이언트 id -->

<script src="https://apis.google.com/js/platform.js" async defer></script>
<!-- 로그인 할 때 구글 api를 사용하겠다 -->

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<!-- 로그인 버튼 CSS 관련 -->



<title>Insert title here</title>
<style>
#Header {
	padding-top: 10%;
	text-align: center;
}

#Lost {
	color: orange;
}

#Found {
	color: skyblue;
}

#google {
	/* position: absolute;
	text-align: center;
	height: 300px;
	width: 400px; */
	text-align: center;
	position: relative;
	height: 300px;
	width: 400px;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	margin: auto;
	left: 0;
	right: 0;
}

</style>

</head>

<body>

	<div id="Header">
		<h1 id="LoginHeader">
			<span id="Lost">Lost</span> & <span id="Found">Found</span>
		</h1>

	</div>

	<div id="google">
		<button type="button" onclick="location.href='google'">
			<i class="fa fa-google" aria-hidden="true"></i> 구글 로그인
		</button>
	</div>




</body>
</html>