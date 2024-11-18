<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>index페이지</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
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
.mobileheader {
	display: none;
}

/*pcNave의 속성을 재정의 페이지 마다 색깔이나 배경이다르니 pcNave.jsp 의 태그 css를 수정한다.   */
.naveulwrapper ul {
	color: #000 !important;
}

.naveulwrapper li {
	color: #000 !important;
}


.naveulwrapper a {
	color: #000 !important;
}

/*pcNave의 속성을 재정의 페이지 마다 색깔이나 배경이다르니 pcNave.jsp 의 태그 css를 종료  */




p {
	background-color: rgb(119, 193, 61) font-family: 'Sunflower', sans-serif;
}

.mobilecartwrapper, .nave {
	display: none;
}

#emptycarousel {
	position: relative;
	margin-top: 500px;
	margin: 0 auto;
	background-image: url(./img_cart/emptycart.png);
	background-repeat: no-repeat;
	background-size: 250px 250px;
}

#carousel {
	position: relative;
	margin-top: 600px;
	margin: 0 auto;
	background-repeat: no-repeat;
	background-size: 250px 250px;
}
/* jstl 조건문으로 가져올시 씹히니 스크립트로 걸어보자. */
#emptycart {
	margin: 0 auto;
	position: absolute;
	width: 100%;
	height: 300px;
	background: #f7f7f7;
	top: 230px;
	border-top: 2px solid #bdbdbd;
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
	margin-top: 80px;
	height: 230px;
	/*  background-color: #BABABA;  */
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

.article1 {
	background: #fff;
	height: 100%;
	margin: 0 auto;
	padding: 40px 0 40px;
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

img {
	display: block;
}

#content2 {
	margin: 20px auto;
}

.sameinfo {
	background: #fff;
	height: 100%;
	margin: 0px auto 0;
	padding: 20px 0 40px;
}

#Section2_2 {
	float: left;
	margin: 0;
	width: 500px;
	overflow: hidden;
}

#info2 {
	width: 90%;
	float: left;
	margin: 0px 0px 30px 50px;
	color: #333333;
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

.clearfix:after {
	content: ".";
	display: block;
	height: 0;
	clear: both;
}

footer {
	text-align: center;
	display: block;
	height: 40px;
	background: #424141;
	margin: 20px 0 0 0;
}

table {
	border-top: 1px solid black;
	width: 100%;
}

img {
	height: 70px;
}

.imgs {
	padding-top: 20px;
	padding-bottom: 20px;
}

.col1 {
	width: 20px;
}

.col1>img {
	width: 45px;
	height: 65px;
}

.col2 {
	width: 10%;
}

td {
	text-align: center;
}

input {
	border: none;
}

#finallsum {
	height: 90px;
	border-top: 1px solid black;
	border-bottom: 1px solid black;
	background-color: #F5F5F5;
}

.isorder {
	margin-top: 8px;
}

.isorder_1 {
	display: inline-block;
	width: 120px;
	text-align: center;
	color: white;
	background-color: #ed1c24;
	padding-top: 10px;
	padding-bottom: 10px;
}

.isorder_2 {
	display: inline-block;
	width: 120px;
	text-align: center;
	color: white;
	background-color: #232a32;
	padding-top: 10px;
	padding-bottom: 10px;
}

.finallpurchace {
	display: flex;
	width: 30%;
	height: 30px;
}

.subfinallpurchace {
	width: 50%;
	line-height: 2;
}

.wannadelete {
	height: 60px;
	background-color: #F5F5F5;
}

.deletebtn {
	padding-top: 10px;
}

.deletebtn>button {
	background-color: white;
	width: 120px;
	height: 40px;
}

#result>input {
	text-align: center
}

/* 모바일 전용..후 */
@media screen and (max-width: 701px) {
	.mobileheader {
		display: block;
	}
	#navebarwrapper {
		display: none;
	}
	#wrapper {
		max-width: 344px !important;
		margin: 0 0 !important;
		padding: 0px 0px !important;
	}
	header {
		display: none;
	}
	#carousel {
		display: none;
	}
	.mobilecartwrapper {
		margin: 0 auto;
		background-color: rgb(171 171 171/ 50%);
		display: flex;
		max-width: 344px;
		flex-direction: column;
	}
	.productbox {
		background: white;
		border-radius: 10px;
		flex-direction: column;
		display: flex;
		width: 95%;
		margin: 10px auto;
	}
	.check1 {
		display: none;
	}
	.check1+label {
		display: inline-block;
		width: 30px;
		height: 30px;
		border: 1px solid #FF4DAB;
		position: relative;
		border-radius: 20px 20px 20px 20px;
	}
	.checks::after {
		color: white;
		background: #FF4DAB;
		border-radius: 20px 20px 20px 20px;
		content: '✔';
		font-size: 25px;
		width: 30px;
		height: 30px;
		text-align: center;
		position: absolute;
		left: 0;
		top: 0;
	}
	.productboxrow1, .productboxrow2 {
		display: flex;
	}
	.productboxrow1 {
		font-size: 15px;
	}
	.productboxrow2 {
		justify-content: space-between;
	}
	.colimg {
		width: 50%;
		height: 100%;
	}
	.colimg img {
		width: 100px;
		height: 100px;
	}
	.increasearea input {
		width: 10px;
	}
	.increasearea button {
		padding: 10px 10px;
		border: none;
		border-radius: 10px 10px 10px 10px;
	}
	.selectarea {
		border-radius: 10px;
		background: white;
		width: 95%;
		margin: 0 auto;
		gap: 25px;
		display: flex;
		flex-direction: column;
	}
	.totalpricearea {
		
	}
	.totalprice {
		
	}
	.allselect {
		display: flex;
		justify-content: space-around;
	}
	.allselect button {
		padding: 10px 10px;
		border: none;
		border-radius: 10px;
	}
	.payment {
		text-align: center;
		color: white;
		background: #FF4DAB;
		border-radius: 20px 20px 20px 20px;
		padding: 10px 0px;
	}
	.confirmpay button {
		color: white;
		border: none;
		background: transparent;
		font-size: 15px;
	}
	.submitinput {
		display: none;
	}
} /* 메디아 쿼리 종료 */
</style>
</head>
<body>

	<!-- 개판이긴 한데 결제나 취소후 다시 장바구니 들어가면 데이터가 뜨는걸 방지하려 계산하는거임  -->
	<c:set var="paycancel" value="0" />
	<c:forEach items="${mycart}" var="paycancelcheck">

		<c:if test="${paycancelcheck.afterpay eq 'yes'}">
			<c:set var="paycancel" value="${paycancel+1}" />
		</c:if>
	</c:forEach>


	<input type="hidden" class="come">
	<div id="wrapper">

		<%@ include file="/pcNave.jsp"%>

		<!-- header 끝 -->
		<c:choose>
			<c:when test="${userId eq null}">
				<button id="goback" data-val="goback"></button>
			</c:when>
			<c:when test="${checkmycart eq 0 or paycancel eq mycart.size()}">
				<div id="emptycarousel">
					<div id="carouselimg"></div>

					<div id="emptycart">
						<h3 style="text-align: center; margin-top: 100px;">장바구니가
							비어있어요</h3>
					</div>
				</div>
			</c:when>

			<c:otherwise>
				<div id="carousel">
					<div id="carouselimg">
						<div>
							<ul>
								<li>step1.장바구니</li>
								<li>step2.결제하기</li>
							</ul>
						</div>
					</div>

					<form action="pay2.jsp" class="comeonmodal" id="forminfo">
						<table>
							<tbody>
								<c:forEach var="my" items="${mycart}">
									<c:if test="${my.afterpay ne 'yes' }">
										<tr>
											<th colspan="2">상품정보</th>
											<th>수량</th>
											<th>개당가격</th>
											<th>수량대비가격</th>
											<th>확인</th>
										</tr>
										<tr>

											<td class="col1"><img
												src="./img_product/${my.product_img}"></td>
											<td class="col2" value="${my.product_cod}">

												<div>
													<input type="hidden" class="cart_id" name="cart_id"
														value="${my.cart_id}"> <input id="id"
														type="hidden" name="product_img" type="hidden"
														value="./img_product/${my.product_img}"> <input
														id="id" type="hidden" name="id" value="${my.id}">
													<input id="product_name" name="product_name" type="text"
														value="${my.product_name}"> <br> <input
														id="product_cod" name="receipt_product_cod" type="text"
														value="${my.product_cod}"> <br> <input
														type="hidden" class="user_code" name="user_code"
														value="${my.user_code}">

												</div>
											</td>
											<td><input class=pluss type='button' value='+'>

												<div id='result'>
													<input name="cart_quantity" value="${my.cart_quantity}">
												</div> <input class=pluss type='button' value='-' /></td>
											<td class="onetoonprice">${my.product_price}</td>

											<td class="quantityprice">${my.product_price*my.cart_quantity}</td>

											<td class="col5"><input type="checkbox"
												class="finalladd"></td>
										</tr>
									</c:if>
								</c:forEach>
								<td id="finallsum" colspan="6"><div class="finallpurchace">
										<div class="subfinallpurchace">합계금액:</div>
										<input id="ajaxfinallsum" type="text" name="finallsum"
											value="0">
									</div></td>
							</tbody>
						</table>
						<div class="isorder">
							<div class="wannadelete">
								<div class="deletebtn">
									<button type="button" class="allchoicebtn">전체선택</button>
									<button type="button" class="allclearbtn">전체선택해제</button>
									<button type="button" class="dropcart">장바구니비우기</button>
								</div>
							</div>
							<a href="productlist.do" class="isorder_1">계속 쇼핑하기</a> <input
								id="lastorder" class="isorder_2" type="submit" value="주문하기">
						</div>
					</form>
				</div>
			</c:otherwise>
		</c:choose>

		<div class="paymodal"></div>

		<!-- 		<button type="button" id="form">폼객체확인하기 버튼</button> -->


		<!-- ..모바일 디자인 후... -->
		<%-- 	<div class="mobileheader">
			<div class="nave">
			<a href="mainhome.jsp">
				<div class="homeicon"></div>
			</a>
			<div class="menudiv">
				<ul>
					<c:choose>
						<c:when test="${userId ne null || user_where=='finalluser'}">
							<li><c:if test="${user_where=='finalluser'}">
								<a class="nav-link" href="mypersonalinfo.do?id=${userId}">정보수정</a>
								</c:if></li>
							<li class="nav-item active"><a class="nav-link"
								href="generalcartlist.do?id=${userId}">장바구니</a></li>
							<li><a href="myreserveinfo.do?user_code=${user_code}">예약현황</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="mypayinfo.do?user_code=${user_code}&id=${userId}">결제현황</a></li>	
							<li><a href="logout.do">로그아웃</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="login.jsp">로그인</a></li>
							<li><a href="phonesms.jsp">가입</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
		</div>	 --%>
		<%@ include file="/mobileNave.jsp"%>

		<div class="mobilecartwrapper">

			<c:choose>
				<c:when test="${checkmycart eq 0 or paycancel eq mycart.size()}">
					<div id="emptycarousel">
						<div id="carouselimg"></div>

						<div id="emptycart"></div>
					</div>
				</c:when>

				<c:otherwise>
					<form action="pay2.jsp">
						<c:forEach var="my" items="${mycart}">
							<c:if test="${my.afterpay ne 'yes' }">
								<div class="productbox">
									<div>
										<input type="checkbox" class="check1"> <label
											class="checklabel" for="check1"></label>

									</div>
									<div class="productboxrow1">
										<div class="colimg">
											<img src="./img_product/${my.product_img}">
										</div>
										<h3>제품이름:${my.product_name}</h3>
									</div>
									<div class="productboxrow2">
										<div class="increasearea">
											<!-- 걍 input hidden 여기다 다 때려 받는다.  -->
											<div class="blackhole"
												data-product_price="${my.product_price}"
												data-cart_id="${my.cart_id}"
												data-cart_quantity="${my.cart_quantity}" data-id="${id}"
												data-user_code="${my.user_code}"
												data-product_cod="${my.product_cod}" data-confirmpay="0"
												data-confirmcancel="0"></div>
											<div class="confirmdnaemata" data-alreadydisbled="true">
												<input type="hidden" class="cart_id" name="cart_id"
													value="${my.cart_id}"> <input id="id" type="hidden"
													name="product_img" type="hidden"
													value="./img_product/${my.product_img}"> <input
													id="id" type="hidden" name="id" value="${my.id}"> <input
													id="product_name" name="product_name" type="hidden"
													value="${my.product_name}"> <input id="product_cod"
													name="receipt_product_cod" type="hidden"
													value="${my.product_cod}"> <input type="hidden"
													class="user_code" name="user_code" value="${my.user_code}">
												<input type="hidden" name="cart_quantity"
													value="${my.cart_quantity}"> <input
													class="isconfirmpaybtn" type="hidden" value="false">


											</div>
											<button class="increasebtn">-</button>
											<button name="cart_quantity" value="${my.cart_quantity}">${my.cart_quantity}</button>
											<button class="increasebtn">+</button>
										</div>
										<div>개당가격: ${my.product_price}</div>
									</div>

								</div>
							</c:if>
						</c:forEach>

						<!-- 총금액 모두선택 카트비우기 결제하기 자리 -->
						<div class="selectarea">
							<div class="totalpricearea">
								<h1 class="totalprice"></h1>
							</div>

							<div class="allselect" data-allselect="">
								<button class="allselectbtn">모두선택</button>
								<button class="clearcart">비우기</button>
							</div>
							<div class="payment">


								<h3 class="confirmpay">
									<button class="confirmpaybtn" type="button">결제하기</button>
									<input class="submitinput" type="submit">
								</h3>

							</div>

						</div>
					</form>
				</c:otherwise>
			</c:choose>
		</div>




	</div>

	<div>





		<script>
		//체크된 카트번호에만 대하여 결제하기(submit) 위해 기능을 잠시 끈다.
		//활성화는 결제하기 버튼에서 체크된 거에 한하여 열어준다.	
		
	let choicearray;
	
	//결제 활성화만 확인
	let confirmpay=0;
	//결제 비활성화만 확인
	let confirmcancel=0;	
	
	
	//결제하기 활성화 버튼만 판단하는 온체인지 함수
	$(document).on("click",".confirmpaybtn",()=>{		
		console.log("매핑확인");
	
		console.log("Number(confirmpay): "+Number(confirmpay)+" 그리고 Number(confirmcancel): "+Number(confirmcancel));
		console.log(" 둘다 0? : "+(Number(confirmpay)==Number(0)&&Number(confirmcancel)==Number(0)))
		console.log(">= : "+(Number(confirmpay)>=Number(confirmcancel)))
		console.log(" < : "+(Number(confirmpay)<Number(confirmcancel)))		
	if(confirmpay==0&&confirmcancel==0){
		console.log("수량 싹다 0  결제 불가능")	
		alert("상품을 선택해주세요")
		}
	else if(Number(confirmpay)>=Number(confirmcancel)){
		
		console.log(" 결제 가능");		
		let confirmpayarray=$("label");
		let alreadydisbled=$("div[class=confirmdnaemata]");
		console.log(alreadydisbled);
		
		
		let confirmdata;
		for(let k=0; k<confirmpayarray.length; k++){
			/* console.log($(confirmpayarray[k]).attr("class"));
			console.log("클래스에 이름이 포함되어있니:  "+($(confirmpayarray[k]).attr("class").includes("checks")));
			console.log("클래스에 이름이 포함되어있니 부정값:  "+(!$(confirmpayarray[k]).attr("class").includes("checks")));
			console.log("기본 디펄트값 장애인됬니?: "+$(alreadydisbled[k]).attr("data-alreadydisbled")); */
			
				confirmdata=$(confirmpayarray[k]).parent().next().next().children().children()[1];
			
			if(!$(confirmpayarray[k]).attr("class").includes("checks")){
				
				$(confirmdata).children("input").attr("disabled",true);	
				$(alreadydisbled[k]).attr("data-alreadydisbled",true);
				
			}else if($(confirmpayarray[k]).attr("class").includes("checks")){
				
				//console.log("체크는 되었으나 장애인이였엇니?"+($(alreadydisbled[k]).attr("data-alreadydisbled")))
						console.log("장애인값: "+$(alreadydisbled[k]).attr("data-alreadydisbled"))		
						console.log("장애인이니?: "+($(alreadydisbled[k]).attr("data-alreadydisbled")=="true"));		
						
				
				//console.log(	$(confirmdata).children("input"));
				//console.log(	$(alreadydisbled[k]));
				//체크는 했으니 이미 장애인이였던 경우
				if($(alreadydisbled[k]).attr("data-alreadydisbled")=="true"){	
					
				$(confirmdata).children("input").attr("disabled",false);
				}
	
				
				$(confirmdata).children("input").removeAttr("disabled");				
			
				$(alreadydisbled[k]).attr("data-alreadydisbled",false);
				
				
			}
				
		}
		
		//submit는 attr 않먹힘..
		
		$(".submitinput").trigger("click");
		
		
		
		
	}else if(Number(confirmpay)<Number(confirmcancel)){
		
		alert("상품을 선택해주세요")
		console.log(" 결제 불가능")
	}
		
		return false;
		
	})	
	


	
	console.log($("input[class=check1]").length)
	
	//모바일 개별 번색 함수
	$("label[class=checklabel]").on("click",(e)=>{	
		
		let blackhole=$(e.target).parent().next().next().children().children();		
		
		let checkprice=Number($(blackhole).attr("data-product_price"))*Number($(blackhole).attr("data-cart_quantity"));
		let alreadycheckprice;
		console.log(" 확인한 금액 " +checkprice);
		
		if($(e.target).prev().val()=="checked"){			
			$(e.target).prev().val("nochecked");
			alreadycheckprice=$(".totalprice").text();
			$(".isconfirmpaybtn").val("false");		
			$(".isconfirmpaybtn").load(location.href+" .isconfirmpaybtn");
			if(alreadycheckprice==""){
				
				
			}else{
				confirmpay=Number(confirmpay)-Number(1);
				confirmcancel=confirmpay;			
				$(".totalprice").text(Number(alreadycheckprice)-Number(checkprice));
			}
			
			
			
		}else{
			$(e.target).prev().val("checked");
			alreadycheckprice=$(".totalprice").text();
			//하 점점 중첩 if문이 많아지네 처음엔 깔끔했는데 ㅠ
			
			confirmpay=Number(confirmpay)+Number(1);
			confirmcancel=Number(0);
		
	//결제 비활성화만 확인
	//let confirmcancel=0;
			
			
			if(alreadycheckprice==""){
				$(".totalprice").text(checkprice);
			}else{
				$(".totalprice").text(Number(checkprice)+Number(alreadycheckprice));
			}
			
			
		}
	
		console.log("개별더하기: "+confirmpay+" 개별취소값: "+confirmcancel);
		
		
	
		$(e.target).toggleClass('checks');

	})
	
	//변수 위치 조심허자..어우 클릭 펑션 속에 있어서 계속 씹혓음
		let cheked=$("label[class=checklabel]");
		//체크를 한번 한뒤 전체선택하는 경우 역으로 기존 체크가 풀리는걸 방지하는 변수
		//let alreadycheck;
	
	
	//모바일 전체선택 전체선택해제 함수
	$(document).on("click",".allselect",(e)=>{
		
		
		let blackhole=$(".blackhole")
		
		let checkprice;
		let alreadycheckprice;	
		let confirmpayarray=$("label");
		let alreadydisbled=$("div[class=confirmdnaemata]");
		
		//버젼 바다 상이하나.
		// attr(data-이름) 으로 갑을 가져오며
		//신버전은 data(이름) 으로 가져온다.	
		
	 	if($(".allselect").attr("data-allselect")=="allselect"){			
			console.log("전체선택해제 누름");	
			alreadycheckprice=$(".totalprice").text();		
			let alreadycheck;
			
			for(let k=0; k<cheked.length; k++){
				confirmdata=$(confirmpayarray[k]).parent().next().next().children().children()[1];
				$(alreadydisbled[k]).attr("data-alreadydisbled",true);
				
				alreadycheck=$(cheked[k]).attr("class");		
			
				if(alreadycheck.includes("checks")){
					$(cheked[k]).toggleClass('checks');
					checkprice=Number($(blackhole[k]).attr("data-product_price"))*Number($(blackhole[k]).attr("data-cart_quantity"));
					console.log("선택되었던 애들");
					alreadycheckprice=Number(alreadycheckprice)-Number(checkprice);
					
				}else{
				
					console.log("애초에 선택되지 않았음");	
				}				
								
				$(cheked[k]).prev().val("nochecked")
			
				
			}
			
			console.log("alreadycheckprice->>"+alreadycheckprice);
			$(".allselect").attr("data-allselect","allclear")
				$(".allselectbtn").text("전체선택하기");
			$(".totalprice").text(alreadycheckprice);
			
			$(confirmdata).children("input").attr("disabled",true);
			//결제 활성화만 확인
			confirmpay=0;
			//결제 비활성화만 확인
			confirmcancel=0;
			
			
		}else{
			console.log("전체선택하기 누름")
			alreadycheckprice=$(".totalprice").text();
			let alreadycheck;
			
			for(let k=0; k<cheked.length; k++){	
				confirmdata=$(confirmpayarray[k]).parent().next().next().children().children()[1];
				$(alreadydisbled[k]).attr("data-alreadydisbled",false);
			//	alreadycheck=$($(cheked[k]).toggleClass()[0]).attr("class");				
				
			alreadycheck=$(cheked[k]).attr("class");			
			//	console.log("alreadycheck->  "+alreadycheck+" 이미 체크되어있어니?: "+alreadycheck.includes("checks"));			
				if(alreadycheck.includes("checks")){
					console.log("이미체크됨");					
					
				}else{
					console.log(Number($(blackhole[k]).attr("data-product_price")));
					console.log(" 체크된적없음");	
					checkprice=Number($(blackhole[k]).attr("data-product_price"))*Number($(blackhole[k]).attr("data-cart_quantity"));
					$(cheked[k]).toggleClass('checks');	
					console.log("Number(alreadycheckprice):  "+Number(alreadycheckprice));	
					console.log("Number(checkprice):  "+Number(checkprice));	
				alreadycheckprice=Number(alreadycheckprice)+Number(checkprice);
					
				}
				
				
				$(cheked[k]).prev().val("checked")
				
			}			
				//제이쿼리 버전 마다 상이한듯 하다.
				// 내가 있는 버전은 태그에 data-이름=값 심을 때는
				// attr(data-val,값)
				// 신버젼은 data(이름,값)
				console.log("alreadycheckprice->"+alreadycheckprice);
				
					$(".totalprice").text(alreadycheckprice);
			$(".allselect").attr("data-allselect","allselect");			
				$(".allselectbtn").text("전체선택해제");
				$(confirmdata).children("input").attr("disabled",false);
				
				confirmpay=cheked.length;
				confirmcancel=0;
		} 
		
	 	return false;
		
		
	}) //전체선택 전체선택해제 함수	종료

	//모바일 수량 1씩 증감하는 함수	
	$(document).on("click",".increasebtn",(e)=>{
		
		let signal=$(e.target).text();
		let plusminus;
		let user_code=$(e.target).parent().children().attr("data-user_code");
		let cart_id=$(e.target).parent().children().attr("data-cart_id");
		let product_cod=$(e.target).parent().children().attr("data-product_cod");
		let cart_quantity=$(e.target).parent().children().attr("data-cart_quantity");		
		//console.log($(e.target).parent().children().attr("data-user_code"));
		
		
		if(signal=="+"){
			plusminus=1;
		}else{
			plusminus=-1;
		}		
		console.log("plusminus: "+plusminus);	
		console.log("버튼부호 :"+signal+" 고객코드:"+user_code+" 고유 카트번호: "+cart_id+" 상품코드: "+product_cod+" 현재 카트 수량 :"+cart_quantity);
		
		  $.ajax({
				url:"plusminus.do",
				type:"POST",
				data:{"user_code":user_code,"cart_id":cart_id,"product_cod":product_cod,"plusminus":plusminus},
				success:(data)=>{
					if(data==1){
						//부분 로딩이기에 이벤트 를 새로 걸어준다..
						//스페이스바 공백 한칸 넣어야한다 " #carousel" 
						if(signal=="-" && cart_quantity==1 ){
							// 즉 상품 수량이 0 으로 보이기 때문에 다시 로케이션 객체로 갈아끼워넣는거임
							location.replace("generalcartlist.do?id=${userId}")
						}
						// 부분 로딩후 확인 체크 클릭이 안먹힘
						//$(".mobilecartwrapper").load(location.href+" .mobilecartwrapper");
						location.replace("generalcartlist.do?id=${userId}");
						
					}
					else if(data == -1){
						alert("잠시후 다시 시도해주세요");
						
					}
				}
				
			})// 아작스 통신종료	
		
			return false;
		  
	})//모바일 1씩 수량 증감 함수 종료
	
	
	//모바일 카트 비우기 함수
	$(".clearcart").on("click",()=>{
		
		let cart_idarry=[];
		let blackhole=$("div[class=blackhole]");
		
		 for(let k=0; k<blackhole.length; k++){
			cart_idarry[k]=$(blackhole[k]).attr("data-cart_id");
			}	
		 
		
		console.log(cart_idarry)
		  $.ajax({
			url:"dropgeneralcart.do",
			type:"POST",
			traditional : true,
			data:{"cart_idarry":cart_idarry},
			success:(data)=>{
				if(data==1){
					
					location.replace("generalcartlist.do?id=${userId}");
					
				}else{
					alert("잠시후 다시 시도해주세요")
				}
			}
			
		})
		
		//형제 모두선택 모두해제 버튼에게 클릭 전파 되지 않도록함. 단 제이쿼리 라이브러리 설치되어야함
		return false;
		
	})
	
	
$("#form").on("click",()=>{
	
	let forminfo=document.getElementById("forminfo");
	console.log(forminfo);	
})

</script>





		<script>
		
		
		
		var arraycheck = [];
		var quantityprice = [];
		var total = 0;
		$(document)
				.ready(
						function() {

							$("#lastorder").attr("disabled", true);

							$("#lastorder").on("mouseenter", function() {
								/* alert("먼저 상품 확인 체크를 눌러주세요!"); */
							})
							
							$(document)
									.on(
											"click",".allchoicebtn",
											function() {

												$("input[class=finalladd]")
														.each(
																function(index) {
																	if ($(this)
																			.is(
																					":checked") == false) {
																		/* console.log("체크박스갯수는");
																		console.log($(this));
																		console.log("체크박스갯수 길이는");
																		console.log($(this).size()); */
																		arraycheck
																				.push(this);
																	}
																})

												console.log(arraycheck);
												$.each($(arraycheck), function(
														index) {

													$(arraycheck).prop(
															"checked", true);
													total += parseInt($(this)
															.parent().prev()
															.text());
													console.log("total");
													console.log(total);
												})
												let alreadytotal = parseInt($(
														"#ajaxfinallsum").val());
												total = total + alreadytotal
												$("#ajaxfinallsum").val(total);

												//	$("input[class=finalladd]").trigger("click");
												//obj가 자바스크립트 객체였네  그래서 제이쿼리 text() val() 인식을 못함
												/* 	$.each($("td[class=quantityprice]"),function(index,obj){
													           parseInt
														total+=parseInt(obj.innerText);
													
													})  */

												$("input[class=pluss]").attr(
														"disabled", true);
												$(".allchoicebtn").attr(
														"disabled", true);
												$("#lastorder").attr(
														"disabled", false);
											})
											
							$(document).on(
									"click",".allclearbtn",
									function() {
										//prop은 이미 반영된것을 인지 못하는듯
										//그래서 지금 attr 해보니 작동됨
										$("input[class=finalladd]").attr(
												"checked", false);
										arraycheck.length = 0;
										total = 0;
										$("#ajaxfinallsum").val(0);
										$(".allchoicebtn").attr("disabled",
												false);
										$("#lastorder").attr("disabled", true);
									})

							$(document)
									.on(
											"click",".dropcart",
											function() {
												let cart_idarry=[];
																						
									
												for(let k=0; k<$("input[class=cart_id]").length; k++){
													cart_idarry[k]=$("input[class=cart_id]")[k].getAttribute("value")
												}	
												
												console.log(cart_idarry)
												 $.ajax({
													url:"dropgeneralcart.do",
													type:"POST",
													traditional : true,
													data:{"cart_idarry":cart_idarry},
													success:(data)=>{
														if(data==1){
															
															location.replace("generalcartlist.do?id=${userId}");
															
														}else{
															alert("잠시후 다시 시도해주세요")
														}
													}
													
												})
												
												//location.href="/dropcart.do"

											})

							$("#phonesms").on("click", function() {
								location.href = "payforsms.jsp?smsfor=pay";

							})

							//////////////////////

							$(".paymodal").hide();
							$(".isorder_2").on("click", function() {
								$(".comeonmodal").css({
									"position" : "relative"
								});
								$(".paymodal").css({
									"position" : "absolute",
									"width" : "100%",
									"background-color" : "white",
									"top" : "0px"
								});
								$(".paymodal").show();

								$("#check_modules").trigger("click");
								$("#check_modules").hide();

							})

							if ($("#goback").attr("data-val") == 'goback') {
								location.href = "login.jsp"
							}

							$(document)
									.on(
											"click","input[class=pluss]",
											function() {
												var qunitity;
												
												//+ - 음수 버튼 위치에 따라 값이 달라 선언을 먼저함
												let cart_quantity;
											
												let plusminus;
												let that = $(this);
												let user_code = $(this).parents()
														.prevAll(".col2")
														.children()
														.children('.user_code')
														.val();
												let product_cod = $(this)
														.parents()
														.prevAll(".col2")
														.children()
														.children('#product_cod')
														.val();
												
												let cart_id=$(this)
												.parents()
												.prevAll(".col2")
												.children()
												.children('.cart_id')
												.val(); 
												
												let plusminusbtn=$(this).val();												
												console.log(plusminus+" 버튼클릭");
												console.log("고객코드:"+user_code+"고유 카트번호: "+cart_id+"상품코드: "+product_cod+" 현재 카트 수량 :"+cart_quantity);
																								
												if(plusminusbtn=="+"){
													 cart_quantity=$(this).next().children().val();
													plusminus=1;
												}else if(plusminusbtn=="-"){
													cart_quantity=$(this).prev().children().val();
													plusminus=-1
												}		
												
												
												console.log(plusminusbtn)
												console.log(cart_quantity)										
												
											 	 $.ajax({
													url:"plusminus.do",
													type:"POST",
													data:{"user_code":user_code,"cart_id":cart_id,"product_cod":product_cod,"plusminus":plusminus},
													success:(data)=>{
														if(data==1){
															//부분 로딩이기에 이벤트 를 새로 걸어준다..
															//스페이스바 공백 한칸 넣어야한다 " #carousel"
															if(plusminusbtn=="-" && cart_quantity==1 ){
																location.replace("generalcartlist.do?id=${userId}")
															}
															$("#carousel").load(location.href+" #carousel");
															
														}
														else if(data == -1){
															alert("잠시후 다시 시도해주세요");
															
														}
													}
													
												})											

											})

							$(document)
									.on(
											"click","input[class=finalladd]",
											function() {
												let ischecked = $(this).is(
														':checked');

												console.log("ischecked->>"
														+ ischecked);
												if (ischecked) {
													$("#lastorder").attr(
															"disabled", false);
													arraycheck.length = 0;
													total = 0;
													$(this).prop('checked',
															true);
													console.log("배열사이즈");
													console.log($(this).size());
													if ($(this).size() == 4) {

														$(".allchoicebtn")
																.attr(
																		"disabled",
																		true);
													}
													console.log($(this)
															.parents().prev()
															.prev().prev()
															.children());
													$(this).parents().prev()
															.prev().prev()
															.children().attr(
																	"disabled",
																	true);

													/* 		$("input[class=pluss]").attr("disabled", true) */
													let finalladd = $(this)
															.parent().prev()
															.text();
													let x = $("#finallsum")
															.children()
															.children(
																	"#ajaxfinallsum")
															.val();
													let xx = parseInt(finalladd)
															+ parseInt(x);
													console
															.log("finalladd->>>>>>>"
																	+ finalladd)
													console.log("xx->>>>>>>"
															+ xx)

													$("#finallsum")
															.children()
															.children(
																	"#ajaxfinallsum")
															.val(xx);
													$("#lastorder").attr(
															"disabled", false);
												} else {
													$(this).prop('checked',
															false);
													$(".allchoicebtn").attr(
															"disabled", false);
													$("input[class=pluss]")
															.attr("disabled",
																	false);
													let finalladd = $(this)
															.parent().prev()
															.text();
													console.log($(this)
															.parent().prev()
															.prev());
													let x = $("#finallsum")
															.children()
															.children(
																	"#ajaxfinallsum")
															.val();
													let xx = parseInt(x)
															- parseInt(finalladd);
													console.log("빼기에서 전체가:"
															+ finalladd);
													console.log("뺄가격:" + x);
													console.log("뺄가격:" + xx);
													$("#finallsum")
															.children()
															.children(
																	"#ajaxfinallsum")
															.val(xx);
													arraycheck.length = 0;
													total = 0;
													$("#lastorder").attr(
															"disabled", true);
												}

											})

						})
	</script>

		<script>
		
	</script>
</body>
</html>