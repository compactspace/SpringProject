<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.security.SecureRandom"%>
<%@ page import="java.math.BigInteger"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
	charset="utf-8"></script>
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script> -->
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
</head>
<style>
@media ( max-width : 360px) {
	body {
		
	}
	.alldivwrapper {
		margin-left: 0px !important;
		margin-right: 0px !important;
		width: 100% !important;
	}
	#loginformwrappe {
		width: 100% !important;
	}
}

/* 이미지 태그의 직계 할머니 포지션을 타겟으로 해야해서
    포지션 릴레이티브 주자
    */
.divwrapper {
	min-height: 100vh;
	box-orient: vertical;
	width: 100%;
	display: flex;
	flex-direction: column;
	justify-content: center;
}

.alldivwrapper {
	width: 500px;
	position: relative;
	margin-left: auto;
	margin-right: auto;
}

.imgdiv {
	/* padding-top: 150px; */
	
}

#
r {
	height: 900px;
	width: 500px;
	border: 1px solid #ddd
}

#imgone {
	position: absolute;
	right: 0px;
	top: 25px;
	height: 200px;
	width: 200px;
}

.loginform {
	height: 100%;
	border: 1px solid #666;
	border-radius: 4px;
}

#loginformwrapper>span {
	color: #444;
	font-size: 35px;
	font-weight: 600;
	line-height: 90px;
}

.container {
	display: flex;
	flex-direction: column;
}

.passwordinput, .idinput {
	background-color: rgb(232, 240, 254);
	border: none;
	border-bottom: 1px solid #bdbdbd;
	width: 100%;
	height: 50px;
}

h3 {
	color: #797979;
}

.iddiv, .passworddiv {
	margin-left: auto;
	margin-right: auto;
	width: 95%;
}

.logindiv, .membershipdiv {
	padding-top: 10px;
	padding-bottom: 10px;
	margin-left: auto;
	margin-right: auto;
	width: 95%;
	height: 40px;
	border: none;
	background-color: #1a70dc;
	color: aliceblue;
	line-height: 35px;
}

.loginbtn {
	padding-top: 10px;
	padding-bottom: 50px;
	margin-left: auto;
	margin-right: auto;
	width: 95%;
	height: 40px;
	border: none;
	background-color: #1a70dc;
	color: aliceblue;
	line-height: 35px;
}

.kakaologindiv {
	padding-top: 10px;
	padding-bottom: 10px;
	margin-left: auto;
	margin-right: auto;
	width: 95%;
	height: 40px;
	border: none;
	background-color: #fee500;
	line-height: 35px;
}

.gohmoe {
	padding-top: 10px;
	padding-bottom: 40px;
	margin-left: auto;
	margin-right: auto;
	width: 95%;
	height: 40px;
	border: none;
	line-height: 35px;
}

#gohmoeicon {
	width: 110px;
}

#naver {
	border: none;
	background-color: transparent;
	color: aliceblue;
}

.naverlogindiv {
	padding-top: 10px;
	padding-bottom: 10px;
	margin-left: auto;
	margin-right: auto;
	width: 95%;
	height: 40px;
	border: none;
	color: aliceblue;
	background-color: #03c75a;
	line-height: 35px;
}

.login_membershipdivwrapper {
	text-align: center;
}
</style>
<body>
	<!--이제 아작스로 통신으로도 해보자.-->
	<p>
		사용자 권한 리스트 :
		<sec:authentication property="principal" />
	</p>
	<form action="logingo.do" method="post">
		<input type="text" id="user_id" name="user_id"> <input
			type="text" id="user_pwd" name="user_pwd">
		<button>로그인제출하기</button>
	</form>

	<button id="btn" type="button">아작스로 로그인 제출하기.</button>
	<button id="btn2" type="button">헤더 토큰 실어 테스트 하기</button>
	<script>
var Bearer;
$("#btn").on("click",()=>{
	console.log("클확인")
	console.log("아이디는->>"+$("#user_id").val()+" 비번은->>"+$("#user_pwd").val())

	$.ajax({
		url:"logingo.do",
		data:{"user_id":$("#user_id").val(),"user_pwd":$("#user_pwd").val()},
		success:(data,y,request)=>{
			//또 오개념 주의해라 현재 컨트롤러에서 response.addHeader로 응답중이라. 바디에 해당하는 data는 당연히 뭐 없음
			
			/* console.log("성공시 받아온 데이터는")
				console.log(data)
				console.log(typeof data)
				console.log("JSON형식 으로 바꾼후 ")
				let afterjson=JSON.stringify(data);
			console.log(typeof afterjson)
			console.log(afterjson) */
			console.log(y)
			console.log(request.getAllResponseHeaders());
			console.log(request.getResponseHeader("authorization"));
			Bearer=request.getResponseHeader("authorization");
			console.log("석세스속 다시 아작스 호출시 Bearer 값은")
			console.log(Bearer)
			console.log(Bearer.split(" ")[1])
			let token=Bearer.split(" ")[1];
			  localStorage.setItem("key", token);
			//이제 발급받은 jwt 토큰을 그냥 로컬스토리지에 저장을 해보도록 하자.			
			$.ajax({				
				url:"ResponseEx03.do",
				 beforeSend: function (xhr) {
			            xhr.setRequestHeader("Content-type","application/json");
			            xhr.setRequestHeader("Authorization","Bearer "+localStorage.getItem("key"));
			            xhr.setRequestHeader("sex","sexboji ");
			            },
			      
				success:(data)=>{
					console.log(data)
				}
				
			}) 			
		}
		
	})
	
})

$("#btn2").on("click",()=>{	
	console.log("Bearer "+localStorage.getItem("key"));
	$.ajax({
		url:"ResponseEx03.do",
		 beforeSend: function (xhr) {
	            xhr.setRequestHeader("Content-type","application/json");
	            xhr.setRequestHeader("Authorization","Bearer "+localStorage.getItem("key"));
	            xhr.setRequestHeader("아무거나보내기","아무거나값");
	            },	      
		success:(data)=>{
			console.log(data)			
		}
		
	}) 
})


		
			




</script>
</body>

</html>