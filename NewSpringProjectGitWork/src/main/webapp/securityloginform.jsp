<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.security.SecureRandom"%>
<%@ page import="java.math.BigInteger"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
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

@media (max-width: 360px){
 body {
  
    
  }
 
 .alldivwrapper{
    margin-left:0px !important;
    margin-right:0px !important;
    width: 100% !important;
 }
 

 
 #loginformwrappe{
 width: 100%!important;
 }    
 
 }
    .divwrapper{
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

#	r {
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


           #loginformwrapper>span{
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

.gohmoe{
text-align: center;
    padding-top: 10px;
    padding-bottom: 40px;
    margin-left: auto;
    margin-right: auto;
    width: 95%;
    height: 40px;
    border: none;
    line-height: 35px;
}

#gohmoeicon{
    width: 110px;
}





#naver{

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

#securityloginbtn{
color: white;
    background: transparent;
    border: none;
    font-size: 20px;
    font-weight: 600;
}

</style>

<script>
	window.onload = function() {
		

		
		$("#gohmoeicon").hover(function(){
			$(".gohmoe").css({"background-color":"#72AEE3"})
			
			
		})
		
		
		$("#gohmoeicon").mouseout(function(){
			$(".gohmoe").css({"background-color":"transparent"})
			
			
		})
		
		
		
	}
</script>

<body>
<div class="all">
<div class="divwrapper">
	<div class="alldivwrapper">
		<div class="imgdiv">
			<h2>
				
			</h2>

		</div>
		<div id="loginformwrapper">
	<form action="logingo.do" method="post">
            <span>Login </span>
			<div class="loginform container">
				<div class="iddiv">
					<h3>아이디</h3>					
					<input type="text" class="idinput" placeholder="ID" id="user_id" name="user_id" value="">
				</div>
				<div class="passworddiv">
					<h3>비밀번호</h3>			
					<input type="password" class="passwordinput" placeholder="Password" id="user_pwd" name="user_pwd" value="">
				</div>
				<br> <br>
				<div class="login_membershipdivwrapper">				
					
					<div class="naverlogindiv">
					<button type="submit" id="securityloginbtn">시큐리티 로그인</button>
					
					<!--jtw는 버릴꺼리 주석처리  -->
						<!-- <button type="button" id="securityloginbtn">시큐리티 로그인</button> -->
					</div>
					<br>
				</div>					
<!-- 	<div class="gohmoe" onclick="javascript:location.href='mainhome.jsp'"><img id='gohmoeicon' src="./img_icon/homeicon.png"></div> -->

			</div>
			</form>
		</div>
	</div>
</div>
</div>

<script>
$("#securityloginbtn").on("click",()=>{
	console.log("클확인")
	console.log("아이디는->>"+$("#user_id").val()+" 비번은->>"+$("#user_pwd").val())

	$.ajax({
		url:"logingo.do",
		data:{"user_id":$("#user_id").val(),"user_pwd":$("#user_pwd").val()},
		success:(data,y,request)=>{
			//또 오개념 주의해라 현재 컨트롤러에서 response.addHeader로 응답중이라. 바디에 해당하는 data는 당연히 뭐 없음
					console.log("서버에서 받은 토큰 :   "+request.getResponseHeader("authorization"));
			Bearer=request.getResponseHeader("authorization");
			let token=Bearer.split(" ")[1];
			  localStorage.setItem("key", token);
		) 			
		}
		
	})
})




















/* var Bearer;
// jtw를 이제 버릴꺼라 주석처리 한다 계속 꼬인다.
$("#securityloginbtn").on("click",()=>{
	console.log("클확인")
	console.log("아이디는->>"+$("#user_id").val()+" 비번은->>"+$("#user_pwd").val())

	$.ajax({
		url:"logingo.do",
		data:{"user_id":$("#user_id").val(),"user_pwd":$("#user_pwd").val()},
		success:(data,y,request)=>{
			//또 오개념 주의해라 현재 컨트롤러에서 response.addHeader로 응답중이라. 바디에 해당하는 data는 당연히 뭐 없음
					console.log("서버에서 받은 토큰 :   "+request.getResponseHeader("authorization"));
			Bearer=request.getResponseHeader("authorization");
			let token=Bearer.split(" ")[1];
			  localStorage.setItem("key", token);
			//이제 발급받은 jwt 토큰을 그냥 로컬스토리지에 저장을 해보도록 하자.			
			$.ajax({				
				url:"ResponseEx03.do",
				 beforeSend: function (xhr) {
			            xhr.setRequestHeader("Content-type","application/json");
			            xhr.setRequestHeader("Authorization","Beare "+localStorage.getItem("key"));
			            xhr.setRequestHeader("걍아무키","걍아무값");
			            },
				success:(data,status,request)=>{
					console.log(data)
					console.log(status)
					console.log(request)
				location.replace("/finall/mainhome.jsp") 
				}
				
			}) 			
		}
		
	})
}) */
</script>
</body>
</html>