<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Document</title>

<style>
.calendarhead {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
}
</style>
<script>
	var backbtn = 0;
	var btncheckq = 0;
	var onemorethanweeks;
	var quotientdate;
	var quotientdatearray;
	var restdatearray;
	var restdate;
	var date = new Date();
	var constdate = new Date();
	var checkdate = date.getMonth();
	var choice;
	var w = 0;
	var arrayss = new Array();
	var iscontaintoday;
	var AMPM = new Array();
	var cols;
	var arrays;
	// var firstdate = new Date(date.getFullYear(), date.getMonth(), 1);
	// var lastdate = new Date(date.getFullYear(), date.getMonth() + 1, 0);

	window.onload = function() {
		$(".modalform").hide();

		// let startday=date.getDay();
		// if(startday%7==0){
		//     $(".am").append("<p>"+date.getMonth()+"월"+ date.getDate()+"일"+"("+"토"+")"+"</p>");}
		//     else{
		//         $(".am").append("<p>"+date.getMonth()+"월"+ date.getDate()+"일"+"("+"일"+")"+"</p>");
		//     }

		currentmonth(btncheckq);
		function currentmonth(btncheckq) {
			let choice = $(".sibal div[class='col']");
			console.log("checkdate" + checkdate);
			checkdate = checkdate + btncheckq
			console.log("호출된후 계산된 checkdate" + checkdate);

			let firstdate = new Date(date.getFullYear(), checkdate, 1);

			let lastdate = new Date(date.getFullYear(), date.getMonth() + 1, 0);
			$(".currentmonth").text(
					date.getFullYear() + "년" + (checkdate + 1) + "월");
			$(".backmonth>span").text((checkdate) + "월");
			$(".nextmonth>span").text((checkdate + 2) + "월");

			let days = $(".alendarbodyday>div");

			let firstdaynum = firstdate.getDay() + 1;

			let firstdates = firstdate.getDate();

			$("#firstrow").append("<div id='firstdate' ></div>");
			for (let i = 0; i <= days.length; i++) {
				// firstdates=firstdates+1;
				$("#firstweek div:nth-child(" + i + ")").text(firstdates);
				// console.log(firstdaynum);
				if (i < firstdaynum - 1) {

					$("#firstdate").append("<div class='col'>xx</div>");

				} else if (i >= firstdaynum) {

					$("#firstdate").append(
							"<div class='col'>" + firstdates + "</div>");
					firstdates = firstdates + 1;
				}

				$("#firstdate").css({
					'display' : 'flex'
				});
				onemorethanweeks = (lastdate.getDate() - (days.length - (firstdaynum - 1)));

				firstdates
			}

			firstdates = firstdates;
			quotient = onemorethanweeks / 7;
			console.log("목->>" + Math.floor(quotient));
			let quotientdatearray = new Array(Math.floor(quotient));

			restdate = onemorethanweeks % 7
			console.log("나머지->>" + Math.floor(restdate));
			let restdatearray = new Array(parseInt(restdate));

			if (quotient > 0) {
				for (let j = 0; j < quotientdatearray.length; j++) {

					$(".quotientweek").append(
							"<div id=th" + j + " class='quotientweeks'></div>");

					for (let i = 0; i < 7; i++) {

						$("#th" + j).append(
								"<div class='col'>" + firstdates + "</div>");
						$(".quotientweeks").css({
							'display' : 'flex'
						});
						firstdates = firstdates + 1;
					}
				}
			}

			console.log(restdatearray.length);
			$(".restweek").append("<div class='row'>&nbsp</div>");
			for (let k = 0; k < restdatearray.length; k++) {
				$(".restweek").children(".row").append(
						"<div class='col'>" + firstdates + "</div>");

				firstdates = firstdates + 1;

			}
			for (k = restdatearray.length + 1; k <= 7; k++) {

				$(".restweek").children(".row").append(
						"<div class='col'></div>");

			}

			onemorethanweeks;
			quotientdate;
			quotientdatearray;
			restdatearray;
			restdate;

			let cols = $(".sibal .col");
			console.log(cols != null);
			console.log(date.getMonth());
			console.log(checkdate);
			if (cols != null) {

				$.each(cols, function(index, items) {
					if ($(cols[index]).text() == date.getDate()
							&& date.getMonth() == checkdate) {
						$(cols[index]).css({
							"background-color" : "#03c75a",
							"color" : "#fff"
						});
						$(cols[index]).text("Today");
					} else if (checkdate < date.getMonth()) {
						$.each(cols, function(index, items) {
							// $(cols[index]).text("Today");
							$(cols[index]).css({
								"color" : "red",
								"opacity" : "0.235294"
							});
						})
					}
					if ($(cols[index]).text() < date.getDate()) {
						//  console.log("7의배수는?->>");
						$(cols[index]).css({
							"color" : "red",
							"opacity" : "0.235294"
						});
					}

					if (index % 7 == 0) {
						$(cols[index]).css({
							"color" : "black"
						});
						$(cols[index - 1]).css({
							"color" : "black"
						});
						// $(cols[index+1]).css({"color":"red","opacity": "0.235294"});
					}
					if (index % 7 != 0) {
						if ((index + 1) % 7 != 0) {
							$(cols[index]).css({
								"color" : "red",
								"opacity" : "0.235294"
							});
						}

					}
				})

			}
			choice = $(".sibal div[class='col']");

			let q = containtoday();
			console.log("q->>>>>>" + q);
			if (q.includes(true)) {
				console.log("if문만 되나 ->>" + q);
				console.log("if문속  AMPM ->>" + AMPM);
				let x = AMPM[q.indexOf(true)]
				$(".am").append(
						"<p>" + (+checkdate + 1) + "월" + x[6] + "일" + "(" + "토"
								+ ")" + "</p>");
				$(".amradion").attr("value", x[6]);
				arrayss.length = 0;

			} else if (checkdate + 1 > date.getMonth()) {

				let x = AMPM[0]
				console.log(x);
				$(".am").append(
						"<p>" + (+checkdate + 1) + "월" + x[6] + "일" + "(" + "토"
								+ ")" + "</p>");
				arrayss.length = 0;
			} else if (checkdate < date.getMonth()) {
				$(".am").empty();

			}

		}// 드이어 currentmonth 함수 종료

		function containtoday() {
			AMPM = ampm();

			console.log("containtoday 함수선언문속 AMPM->>" + AMPM);
			todaycheckarray = new Array();

			$.each(AMPM, function(index, obj) {

				if (AMPM[index].includes("Today")) {
					// console.log("투데이포함 참");
					todaycheckarray.push(true);
				} else {
					// console.log("투데이포함 거짓");
					todaycheckarray.push(false);

				}

			})
			//  arrayss.length=0;
			return todaycheckarray;
		}

		function ampm() {
			arrays = $(".sibal div[class='col']");
			// let arrayss= new Array();

			personalarrays = new Array();

			for (let j = 0; j <= 6; j++) {
				personalarrays[j] = new Array(0);

				for (w; w <= $(".sibal div[class='col']").length; w++) {

					personalarrays[j].push($($(".sibal div[class='col']")[w])
							.text());
					//   console.log(personalarrays[j]);
					//    console.log("w->"+personalarrays.length);
					if (personalarrays[j].length % 7 == 0) {
						console.log("7의배수 이프속->>" + arrayss)
						arrayss.push(personalarrays[j]);

						//console.log("이프속->>"+arrayss)

						personalarrays.length = 0;
						w = w + 1;
						break;
					}

				}
				//console.log(" ampm 첫 포문속>>"+arrayss)

			}

			console.log("let이 없다면->")
			console.log(arrayss);

			//  console.log(" ampm 함수 리턴전 >>"+arrayss);
			return arrayss;

		}

		$(".nextmonth").on("click", function() {
			let choice = $(".sibal div[class='col']");

			// $(".firstweek").empty();
			$("#firstdate").empty();
			$(".restweek").empty();
			$(".quotientweek").empty();
			$(".am").empty();
			$(".amradion").prop('checked', false);
			arrayss.length = 0;
			w = 0;
			btncheckq = $(".nextmonth").attr("value");
			console.log("마이너스가 난?" + btncheckq);

			btncheckq = parseInt(btncheckq);
			currentmonth(btncheckq);

		})

		$(".backmonth").on("click", function() {
			let choice = $(".sibal div[class='col']");
			// $(".firstweek").empty();
			$("#firstdate").empty();
			$(".restweek").empty();
			$(".quotientweek").empty();
			$(".am").empty();
			$(".amradion").prop('checked', false);
			arrayss.length = 0;
			w = 0;
			btncheckq = $(".backmonth").attr("value");
			// console.log("마이너스가 난?"+btncheckq);             
			btncheckq = parseInt(btncheckq);
			currentmonth(btncheckq);

		})

		$(document).on(
				"click",
				".sibal div[class='col']",
				function(e) {
					$(".amradion").prop('checked', false);
					$(".am").empty();

					// console.log(date.getDay()%7==0);

					if (checkdate == date.getMonth()
							|| checkdate > date.getMonth()) {

						let choice = $(".sibal div[class='col']");
						//console.log(e.currentTarget);//요건 자바스크립트 객체고
						//console.log($(choice).index(this));
						$(e.currentTarget).index(this);//e.currentTarget 를 제이쿼리로 객체만들고 제이쿼리 메소드 text() 사용하기
						if ($(choice).index(this) % 7 == 0) {

							console.log($(this).text());

							$(".amradion").attr("value", $(this).text());
							$(".am").append(
									"<p>" + (+checkdate + 1) + "월"
											+ $(this).text() + "일" + "(" + "토"
											+ ")" + "</p>");
						}
						for (let q = 0; q < choice.length; q++) {
							if ($(choice).index(this) == ((7 * q) - 1)) {
								$(".amradion").attr("value", $(this).text());
								$(".am").append(
										"<p>" + (+checkdate + 1) + "월"
												+ $(this).text() + "일" + "("
												+ "토" + ")" + "</p>");

							}
						}
					}

				});

		$(window).resize(function() {
			// width값을 가져오기
			var btnwidth = $("#th2").css("width");
			var widths = $("#th0>.col").css("width");
			$("#firstdate > .col").css({
				"width" : widths
			});
			$(".nextbtn").css({
				"width" : btnwidth
			});

		});

		$(".choicecomplete").on("click", function() {
			if ($(".amradion").prop("checked")) {
				//이제 로케이션 href로 넘기자.

			} else {

				console.log("확인버튼을 눌러주세요!!");
			}

		})

		let modalforwidth = $("#comeonmodal").width();
		let modalforheight = $("#comeonmodal").height();

/* 		$(window).resize(function() {
console.log("modalforwidth 확인->>"+modalforwidth);
			$(".modalform").css({
				"position" : "absolute",
				"top" : "0px",
				"left" : "0px",
				"width" : modalforwidth + "px",
				"height" : modalforheight + "px"
			});

		}) */

		//여기서부터는 모달 창만들기
		$(".goreserve").on("click", function() {
			
			
			$("#comeonmodal").css({
				"position" : "relative"
				  
			});
			
			$(".modalform").css({
				"position" : "absolute",
				"background-color" : "white",
				"z-index" : 1
			});
			$(".modalform").css({
				"position" : "absolute",
				"top" : "0px",		
				
				"height" : "100vh"
			 
				
			});
			
$(".forbottomheight").css({"height":(modalforheight*2/3)+"px"});
			$(".modalform").show();

		})

	}//window.onload 종료
</script>
<style>
.calendarwrapper {
	display: flex;
	flex-direction: column;
	justify-content: center;
	height: 85vh;
}

.container {
	/* display: flex;
    flex-direction: column; */
	
}

.col {
	height: 60px;
	padding-top: 10px;
	padding-bottom: 10px;
	text-align: center;
	font-size: 17px;
	line-height: 140%;
	color: rgb(38, 38, 38);
	font-weight: 600;
}

.restweek>.row {
	/* width: 100px !important; */
	
}

.alendarbodydays {
	width: 100%;
}

.quotientweek {
	width: 100%;
}

.quotientweek {
	flex-direction: column;
}

.alendarbodyday {
	width: 100%;
	display: flex;
	justify-content: space-between;
}

.firstweek {
	width: 100%;
}

#firstrow {
	width: 100%;
	flex-direction: column;
}

.info {
	height: 80px;
	background-color: rgba(0, 0, 0, 0.03);
	margin-bottom: 10px;
}

.infoam .finallcheck {
	text-align: right;
	font-size: 50px;
}

.finallcheck>input {
	width: 50px;
	height: 50px;
}

p {
	margin-bottom: 5px;
}

@media ( min-width :800px) {
	.calendarwrapper>.row {
		width: 70%;
	}
	.alendarbodydays {
		width: 100%;
	}
	#firstrow {
		width: 100% !important;
	}
	.quotientweek {
		width: 100% !important;
	}
	.row {
		margin-left: auto;
		margin-right: auto;
	}
}

@media ( max-width :500px) {
	.row {
		margin-left: 0px;
		margin-right: 0px;
	}
	#cols1 {
		padding-left: 0px;
		padding-right: 0px;
	}
	.calendarbody {
		padding-left: 0px;
		padding-right: 0px;
		margin-left: 0px;
		margin-right: 0px;
	}
	.calendarwrapper {
		padding-left: 0px;
		padding-right: 0px;
		margin-left: 0px;
		margin-right: 0px;
	}
}

.infodivwrapper {
	width: 80%;
	margin-left: auto;
	margin-right: auto;
}

.choicecomplete {
	padding-top: 20px;
	text-align: center;
}

.modalform {
	background-color: white;
	justify-content: center;
    flex-direction: column;
    display: flex;
}

.flexs{
display:flex;

}

form{
width:100%;
}

.row{
width:100%;

}
</style>
</head>

<body>
	<div class="calendarwrapper container">
		<div id="comeonmodal" class="row">
			<form class="modalform">
				<div class="iddiv">

					<div class="infomation">
						<div class="ingroduceclass container">
							<div class="row">
								<div class='btnwrapper  col-md-6'>
									<p>신청내용을 확인해주세요</p>
								</div>
							</div>
							<div class="row">
								<div class="onedayclass_info col-md-6">
									<p>jstl로전페이지에서"선택한클래스명"가져올것</p>
									<p>jstl로전페이지에서"수업비용"가져올것</p>
								</div>
							</div>
						</div>


					</div>
					
					<div class="reserveinfo containder">
					<div class="row">
					<div class='reserveinfo_col  col-md-12'>
					<p class="pclass">신청자명은 별도로 기입하지 않으시면 회원가입시 아이디로 확정됩니다.</p>
					<input type="hidden" id="id" name="id" value="${userId}">
					<div class="flexs"><div class="nameforreserve"><span>신청자명:</span></div><div class="inputdiv"><input type="text" id="reserve_info sameinput" name="reserve_info"></div></div>
					<br>
					<div class="flexs"><div class="reserve_dayforreserve"><span>선택날짜:</span></div><div class="inputdiv"><input type="text" id="reserve"  class="reserve_day sameinput" name="reserve_day" value="" required></div></div>
					<br>
					<div class="flexs"><div class="onedayclass_priceforreserve"><span>수업비용:</span></div><div class="inputdiv"><input type="text" id="onedayclass_price" class="sameinput" name="onedayclass_price" value="3000"></div> </div>
					<br>
					신청하기:<input id="reservebtn" type="button" value="신청하기">
					</div>
					</div>
					</div> 
				</div>
				
<div class="forbottomheight"></div>
			
			</form>



			<div id="cols1" class="calendarheadbodywrapper col-12">
				<div class="calendarhead">
					<!-- class="backmonth" :이전달 가기 버튼으로 함수 만들자.  -->
					<div class="backmonth" value="-1">
						<span></span>
					</div>
					<div class="currentmonth"></div>
					<!-- class="nextmonth" :이전달 가기 버튼으로 함수 만들자.  -->
					<div class="nextmonth" value="1">
						<span></span>
					</div>
				</div>
				<!-- 각 월에 대한 요일과  일 을 담당 하는 class="calendarbody"  -->
				<div class="calendarbody container">
					<!-- 요일을 담당하는 클래스 -->
					<div class="alendarbodydays row">
						<!-- 이건 jstl로 돌리게 됨 -->
						<div class="alendarbodyday">
							<div id="day0" class="col">일</div>
							<div id="day0" class="col">월</div>
							<div id="day0" class="col">화</div>
							<div id="day0" class="col">수</div>
							<div id="day0" class="col">목</div>
							<div id="day0" class="col">금</div>
							<div id="day0" class="col">토</div>
						</div>
					</div>
					<!-- 첫주는 고정 row로 하나 빼둔다. -->
					<!-- 물론 여기도 jstl화 할것임 -->
					<div class="sibal">
						<div id="firstrow" class="row"></div>


						<!-- 물론 여기도 jstl화 할것임 -->
						<div class="quotientweek row"></div>
						<div class="restweek"></div>
					</div>
				</div>

				<div class="infodivwrapper">
					<h2>시간을 선택해주세요</h2>
					<div class="infoam info container">
						<div class="row">
							<div class="col-6">
								<div class="am"></div>
								<p class="">남은자리</p>
							</div>
							<div class="col-6 finallcheck">
								<input class="amradion" type="radio" name="reserve_reception"
									value="">
							</div>
						</div>



					</div>
					<div class="infopm info">
						<p>몇시 몇시 남은자리</p>
					</div>
					<div class="choicecomplete info">
						<h2 class="goreserve">다음</h2>
					</div>
				</div>




			</div>

		</div>
	</div>
















</body>

</html>