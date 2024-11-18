<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="preconnect" href="https://fonts.googleapis.com">

<link
	href="https://fonts.googleapis.com/css2?family=Orbit&family=Sunflower:wght@300&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<style>
p {
	background-color: rgb(119, 193, 61) font-family: 'Sunflower', sans-serif;
}

#carousel {
	margin: 0 auto;
	/* 메인사진 주석처리 해가며 어느게 가장 이쁜지 비교해보자*/
	/* 	background-image: url(./img/main.jpg); */
	background-image: url(./img/worklist.jpg);
	background-repeat: no-repeat;
	background-size: 1200px 500px;
	height: 500px;
}

* {
	margin: 0;
	padding: 0;
}

body {
	margin: 0 0 0 0px;
}

/* 배치도 생각으로 전체 wrapper 감싼후 마진 오토 */
#wrapper {
	max-width: 1020px;
	margin: 0 auto;
	padding: 0px;
}

header {
	position: relative;
	height: 70px;
	background: #fff;
	margin: 0;
}

#carousel {
	height: 450px;
	background-color: #BABABA;
	vertical-align: middle;
}

#carouselimg {
	text-align: center;
}

h2 {
	font-weight: 500;
	color: #333333;
	font-style: normal;
}

nav {
	position: absolute;
	top: 20px;
	width: 100%;
}

.myimg {
	background: transparent;
	font-size: 30px;
	border: none;
}

.myimg:focus {
	
}

.myimg:hover {
	background-color: black;
	color: white;
	transition: 0.7s;
}

.gologin {
	font-size: 30px;
}

.gologin:hover {
	background-color: black;
	color: white;
	transition: 0.7s;
}

.gologin:hover {
	background-color: black;
	color: white;
	transition: 0.7s;
}

ul {
	display: flex;
	list-style-type: none;
}

li {
	display: inline-block;
	width: 30%;
	text-align: center;
	color: #333333;
	letter-spacing: .01em;
	font-style: normal;
	font-weight: 300;
}

a {
	text-decoration: none;
	color: #333333;
}

.article1 {
	background: #fff;
	height: 100%;
	margin: 0 auto;
	padding: 40px 0 40px;
	display: flex;
}

#header1 {
	width: 100%;
	float: left;
	margin: 0px 0px 30px 50px;
	color: #333333;
}

p {
	display: block;
	width: 80%;
	margin: 0px 0px 0px 50px;
	font-weight: 300;
}

/* Section 2 */
#content1 {
	max-width: 1020px;
	margin: 20px auto;
}

#content2 {
	grid-gap: 10px;
	display: grid;
	grid-template-rows: 333px 333px 333px 333px 333px;
	grid-template-columns: 50% 50%;
	max-width: 1020px;
	margin: 20px auto;
}

.sameinfo {
	display: grid;
	grid-template-rows: 80% 20%;
	background: #fff;
}

.Section2_2 {
	box-shadow: 0 19px 38px rgba(0, 0, 0, 0.30), 0 15px 12px
		rgba(0, 0, 0, 0.22);
	height: 100%;
	display: grid;
	grid-template-rows: 50% 50%;
}

.Section2_2>.infoimg {
	width: 100%;
	height: 100%
}

.imgarea {
	background-size: 100% 100%;
	background-repeat: no-repeat;
}

.titleinfo {
	font-size: 25px;
	display: block;
	color: #333333;
}

.detailinof {
	display: block
}

.btnarea {
	
}

.addbtn {
	color: #333333;
	font-weight: 500;
	border: 0;
	background-color: transparent;
	padding: 10px 0px;
	font-size: 18px;
	display: block;
	margin-right: 0px;
	margin-left: auto;
	/*     border: 1px solid #03c75a; */
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
	border-radius: 3px;
}

}
#Section2_3 {
	float: right;
	margin: 0;
	width: 500px;
	overflow: hidden;
}

#info3 {
	width: 90%;
	float: left;
	margin: 0px 0px 30px 50px;
}

/* 미구현 footer영역 */
footer {
	text-align: center;
	display: block;
	height: 40px;
	background: #424141;
	margin: 20px 0 0 0;
}

/*  #modalContainer{
display:none
}  */
#modalContent {
	display: none
}

#modalContent {
	
}

.imgs {
	position: absolute;
	right: 0px;
	top: 25px;
	height: 200px;
	width: 200px;
}

.alldivwrapper {
	width: 1200px;
	position: relative;
}

.imgdiv {
	padding-top: 150px;
}

#loginformwrapper {
	background-color: white;
	height: 1300px;
	width: 1200px;
	border: 1px solid #ddd;
}

.loginform {
	height: 900px;
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

textarea {
	width: 900px;
	height: 150px;
}

.passworddiv {
	text-align: center;
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

.login_membershipdivwrapper {
	text-align: center;
}

#examplecontainer {
	
}

#noimgitems {
	width: 350px;
	float: left;
	margin-right: 160px;
	margin-left: 140px;
}

#yesimgitems {
	width: 350px;
	float: left;
}

.yesorno {
	width: 400px;
	height: 600px;
}

.btnarea {
	display: flex;
}

.productgrouparea{
	max-width: 1020px;
    margin: 20px auto;
}

.productul{

}
.group{
 background-color: #cecece;
 width:100%;
}


.soldout{
color:red;
font-weight:900;
}




</style>

<script>

var media = window.matchMedia("screen and (max-width: 1026px)");

window.addEventListener("resize", function() {
	 if(media.matches){
		 console.log("900px 이하")
		 let selector=document.getElementsByClassName("Section2_2")
		 console.log(selector);
		 
		 
	 }else{
		 console.log("900px 이상")
	 }
		 
		 
		 
		 })




window.onload=()=>{

	
	
	
	$(".myimg").click(function(){
		$("#modalContainer.hidden").css({"display":"block"})
		$("#modalContent").css({"display":"block"})
	$("#modalContainer.hidden").css({
		"position":"absolute" ,"top":"50%",
	　"left":"50%",
	　"transform": "translate(-50%,-50%)",
	　"background-color":"white",
	 "z-index": "100",
	 "width":"1200px",
	"height": "600px"
	})
		
	})
	
	$(".cancelimginsert").click(function(){
	console.log("dd");
	$("modalContent").css({"display":"none"})
	$("#modalContainer.hidden").css({"display":"none"})
	})
	

	//고객노출 시 품절로 할 함수
$(".productstatus").on("click",()=>{	
	let key=localStorage.getItem("key");
	let product_cod=$(".product_cod").val();
	
console.log($(this).parent());

	let product_status=$(".productstatus").val();
/* 	$.ajax({
		url:"statuschange.do?product_cod="+product_cod+"&product_status="+product_status,
		 beforeSend: function (xhr) {
	            xhr.setRequestHeader("Content-type","application/json");
	            xhr.setRequestHeader("Authorization","Bearer "+key);	         
	            },
		type:"get",
		success:(dtaa)=>{
			console.log(data)
			
		}//석세스 함수 종료
		
	})//아작수 함수 종료 */
	
	
	
	
})//클릭함수 종료	


	
	//제이쿼리는 우선 배열로 받아온다.
	//게씨발 더럽게 복잡한다.
	//제이쿼리는 배열로 받아오고 이게 뭐 자바스크립트나 html 객체로 받아오는듯 따라서
	//한번더 제이쿼리로 감싸준후 제이쿼리 css 함수를 적용하자.
	//console.log($(".productul").children()[0]);
	//$($(".productul").children()[0]).css({"background-color":"red"});
	

	
//흠 또 눈치 밥인데, 클릭 대상 자체에 이벤트를 걸면 e 와 target 으로 접근 해야함.
//this를 못알아 처먹음
$("li[class=group]").on("click",(e)=>{
	
	console.log(e.target);
	let product_group=e.target.getAttribute("value")
	window.location.href="ajaxproductlist.do?product_group="+product_group;
	
	})		

	

if(window.location.search=="" ){
	$($("li[class=group]")[0]).css({"background-color":"white"});	
	
	
}else{
	//console.log(window.location.search)
	//console.log(window.location.search.split("=",2));
	//console.log(window.location.search.split("=",2)[0].replace("?",""));

let aftercss=window.location.search.split("=",2)[1].replace("?","");

let style_json={"background-color": "#fff"};

//게씨발 uri 쿼리스트링에 한글 되있으면 또 이상하게 깨짐.
console.log(aftercss);


//console.log($("li[value="+aftercss+"]"));

$("li[value="+aftercss+"]").css({"background-color":"white"});
	
}
	

	
	
	
	
	
}// 윈도우 온로드 함수 종료


</script>


</head>


<body>
	<div class="allwarpper">	
	
		<div id="wrappers">

			<header>
				<nav>
					<ul>
						<li><a href="onedayclass.jsp">원데이클래스</a></li>
						<li><a href="getworklist.do">참여자분들의 작품</a></li>

						<li><a href="firstgetboad.do?page=0">여러분의게시판</a></li>
						<c:choose>

							<c:when test="${userId ne null && user_where=='finalluser'}">

								<li>${userId}님<a href="myinfo.jsp"> 정보수정</li>
								<li><a href="cartlist.do?id=${userId}">장바구니</a></li>
								<li><a href="logout.do">로그아웃</a></li>
							</c:when>
							<c:when test="${user_where ne'finalluser' && userId ne null }">

								<li><a href="cartlist.do?id=${userId}">장바구니</a></li>
								<li><a href="logout.do">로그아웃</a></li>
							</c:when>

							<c:otherwise>


								<li><a href="login.jsp">로그인</a></li>
							</c:otherwise>
						</c:choose>
						<li><a href="productlist.do">팬시상품</a></li>
					</ul>
				</nav>
				<!-- nav -->
			</header>
			<!-- header -->

		</div>
		<div id="content1">

			<div class="article1">
				<h2 id="header1">수량한정 미술용품</h2>
				<p>합리적인 가격으로 미술용품을 판매하고 있습니다. 가장 기본적인 구성으로, 인물화에 필요한 연필과, 지우개
					그리고 색감을 표현하기 위한 파스텔과, 수성 색연필로 구성하였습니다.</p>



			</div>
		</div>		
		<div class="productgrouparea">
			<ul class="productul">		
				<li class="group" value="pencile">연필류</li>
				<li class="group" value="colorpencile">색연필류</li>
				<li class="group" value="groupdetermined">기타</li>
			</ul>
		</div>


		<div id="content2">
			<c:forEach var="p" items="${productService}" varStatus="i">
				<c:if test="${p.product_Registration_status eq 'open'}">
					<div class="Section2_2">

						<div class="imgarea"
							style="background-image:url('./img_product/${p.product_img}')"></div>
											<div class="sameinfo">
							<div class="infoarea">
								<span class="titleinfo">${p.product_name}</span> <span
									class="detailinof">${p.product_info}</span>
							</div>

							<c:choose>
								<c:when test="${userId ne null}">

									<input type="hidden" class="id" name="user_code"
										value="${user_code}">
									<input type="hidden" class="id" name="id" value="${userId}">
									<input type="hidden" class="product_cod" name="product_cod"
										value="${p.product_cod}">
									<input type="hidden" name="product_name"
										value="${p.product_name}">
									<input type="hidden" name="product_price"
										value="${p.product_price}">
									<input type="hidden" name="product_img"
										value="${p.product_img}">
									<!-- <input type="hidden" name="cart_quantity" value="1">  -->
									<div class="btnarea">
										<c:if test="${p.product_status eq '품절'}">
											<span class="soldout">품절</span>
										</c:if>
										<c:if test="${p.product_status ne '품절'}">
											<button class="addbtn" type=button value="카트에담기">카트에담기</button>
										</c:if>
									</div>

								</c:when>
								<c:otherwise>

								</c:otherwise>
							</c:choose>

						</div>
					</div>
				</c:if>
				<c:set var="even" value="even" />

			</c:forEach>

		</div>

		<script>
	$("button[class=addbtn]").on("click", function(e) {
		
		//click 이벤트시는 e.target 이나 this나 같다 내가 누른 객체가 뜬다.
	/* 	console.log(e.target);
		console.log(this)
		console.log($(this).parent().prev().prev().prev().prev().prev().prev().val()) */
		//상품담기를 아작스통신으로 바꾸어서.. 어쩔수없이 이렇게 name 값을 일일히 가져와야한다.
		/* console.log($(this).prev().prev().prev().prev().val());
		console.log($(this).prev().prev().prev().prev().prev().val()); 		
		console.log($(this).prev().prev().prev().val()); 
		*/		
		
		console.log($(this))
		console.log("유저코드는->> "+$(this).parent())
	 	console.log("유저코드는->> "+$(this).parent().prev().prev().prev().prev().prev().prev().val())
		console.log("유저 아이디느->>"+$(this).parent().prev().prev().prev().prev().prev().val())
	console.log("상품코드는->>"+$(this).parent().prev().prev().prev().prev().val())
	console.log("상품이름은->> "+$(this).parent().prev().prev().prev().val())
	console.log("상품가격은->>"+$(this).parent().prev().prev().val()) 
	
	
	//레디스 한정상품 아작스
	/* 	$.ajax({
			url : "addcart.do",
			method : "get",
			data : {
				"user_code":$(this).parent().prev().prev().prev().prev().prev().prev().val(),
				"id" : $(this).parent().prev().prev().prev().prev().prev().val(),
				"product_cod" : $(this).parent().prev().prev().prev().prev().val(),
				"product_name" : $(this).parent().prev().prev().prev().val(),
				"product_price" : $(this).parent().prev().prev().val(),
				"product_img" : $(this).parent().prev().val(),
				
			},
			success : function(data) {
				console.log(data);
				if (data == "0") {
					alert("품절된상품입니다.");
				} else if (data == "1") {
					alert("장바구니에 담았습니다.");
				} else {
					alert("수량한정 상품은 한사람당 한개씩담을 수 있습니다.");

				}
			},
			error : function() {

			}

		}) */		
		
 
	})
	
	
</script>


		<footer>
			<h1>미구현footer</h1>
		</footer>
</body>
</html>