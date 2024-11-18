<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

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
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>

<!-- 제이쿼리 달력  -->
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!-- 달력 이벤트가 강제된게 많아 다운받운후 js폴더에 DatPickker-jquery-ui.js 파일을 집어 넣었다  -->
<!--DatPickker-jquery-ui.js 파일의 8113 라인 코드를 주석처리함 다른곳 클릭하면 달력 종료되는 스크립트를!!  -->
<script src="./js/DatPickker-jquery-ui.js"></script>
<!-- 제이쿼리 달력  종료-->

<style>
/*뒤로가기 */
.back{

width:100%;
position: absolute;
    display: flex;
    justify-content: space-between;
}

.backarea{
background-image: url(./img_icon/backicon.png);
width: 50px;
    height: 50px;
    background-size: 100% 100%;

}

.otherclassarea{

}

#onedayclass_name_btn{
margin-right: 5px;
    margin-top: 12px;
}



#onedayclass_name_btn {
	justify-content: space-between;
	width: 200px;
	border-radius: 5px 5px 5px 5px;
	/* border: 2px solid #ff5862; */
}

.open {
	background: #ff5862;
	color: white;
	width: 100px;
	border-bottom: 1px solid black;
	border-right: 1px solid black;
	border-left: 1px solid black;
	boder: 10px 10px;
	border-bottom-left-radius: 10px;
	border-bottom-right-radius: 10px;
}

.open li {
	padding: 10px 0px;
}

.onedayclass_name_btn {
    width: 100px;
text-align: right;
	background: transparent;
	border: none;
	color: #6A82EC;
    font-size: 15px;
    font-weight: 900;
        line-height: 5px;
}

h3, p {
	padding: 0px 0px;
	margin: 0px 0px;
}

ul {
	list-style: none;
	padding: 0px 0px;
	margin: 0px 0px;
}

.allwrapper {
	max-width: 480px;
	margin: 0 auto;
}

.mobilewrapper {
	display: none;
}

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
.pcboxwrapper {
position: relative;
	box-shadow: 0 0 17px 3px rgb(171 171 171/ 50%);
}

#onedayclass_name_btn {
	height: 22px;
	overflow: hidden;
	display: flex;	
	color: #6A82EC;
    font-size: 15px;
    font-weight: 900;
}


.onedayclass_name_list {
	
}

.choicename {
	
}

.contenttilewrapper {
	color: #343a40;
	font-size: 20px;
	font-weight: 700; //
	letter-spacing: -.4px;
	line-height: 1.25;
	margin: 0;
}

.contenttilewrapper h3 {
	margin: 0px 0px;
}

.contentimgtitlewrapper {
	margin: 10px 0px;
}

.contentimgtitlearea {
	width: 100%;
	height: 480px;
	background-size: 100% 100%;
	background-image: url('./img_onedayclass/manhwa.jpg');
}

.candidateimgwrapper {
	display: grid;
	grid-template-columns: 160px 160px 160px;
}

.candidateimgarea {
	width: 140px;
	height: 140px;
	background-size: 100% 100%;
	height: 140px;
}

.linecut1 {
	padding: 10px 0;
	margin: 10px 15px 0;
	display: flex;
	align-items: center;
	justify-content: center;
	/* border: 1px solid #ff5862; */
	background: #FFF0F1;
	border-radius: 5px;
	font-size: 13px;
	line-height: 15px;
	font-weight: 700;
}

.commentwrapper {
	
}

.reviewsize {
	
}

.reviewsize span {
	color: #ff5862;
}

.recentreviewwrapper {
	/* 	background-color: #F8F8F8; */
	border-top: 2px solid #F8F8F8;
	border-bottom: 2px solid #F8F8F8;
	margin: 10px 0px;
}

.recentreviewwrapper p {
	color: #343a40;
	font-size: 15px;
	letter-spacing: -.3px;
	line-height: 1.6;
}

.recentreview {
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	flex-direction: column;
	justify-content: space-between;
}

.recentreview p, .recentreview .reviewimg {
	padding: 10px 10px;
}

.reviewimg {
	border-radius: 20px 20px 20px 20px;
	width: 250px;
	height: 180px;
	background-size: 100% 100%;
}

.reviewcreate {
	display: flex;
	justify-content: space-between;
}

#calendarwrapper {
	
}

#iconrow {
	height: 150px;
	display: grid;
	grid-template-rows: 30px 30px 30px 30px;
}

.detail {
	margin: 5px 0px;

}

.detail img {
	width: 20px;
	height: 20px;
}

/* 나중에 몇글자 이상은 삽입 불가입니다. 기능도 넣자 그걸 감안한 500px이니깐... */
.commentcontent {
	width: 500px;
}

.createcontent {
	align-content: end;
}

.nextpage {
	display: flex;
	justify-content: center;
}

.nextpagebtn {
	font-size: 15px;
	background: #FFF0F1;
	color: #ff5862;
	width: 100px;
	border: none;
	height: 50px;
	border-radius: 20px 20px 20px 20px;
}

img {
	width: 100%;
	height: 230px;
}

.showrest span {
	background: #ff5862;
	color: white;
	font-weight: 600;
	border-radius: 5px;
}

.allwrapper {
	height: 100%;
	position: relative;
}

.menuediv {
	line-height: 4;
	margin-left: auto;
	margin-right: auto;
	width: 70%;
	display: flex;
	flex-direction: row;
}

.menueul {
	display: flex;
	justify-content: space-between;
}

.menueul>li {
	margin-right: 14px;
	display: inline-block;
}

.logimg>img {
	width: 130px;
	height: 65px;
}

.shortinfo {
	border: 1px solid #dddddd;
	border-radius: 4px;
}

.show {
	position: relative;
	height: 70px;
	background-color: #fdf7f7;
}

.show>h2 {
	position: absolute;
	top: 26%;
	width: 100%;
	color: #ccc;
	text-align: center;
}

#containerinfo {
	border: 1px solid #dddddd;
	border-radius: 4px;
}

#nth2row>div {
	margin-top: 10px;
}

.buttonwrapper {
	text-align: center;
}

.buttonwrapper>button {
	border: none;
	background-color: transparent;
	color: #888 !important;
}

/* 달력 데이트피커 css 수정 */
#ui-datepicker-div {
	border: none !important;
	width: 100%;
	padding: 0px 0px !important;
	position: relative !important;
	top: 0px !important;
	left: 0px !important;
	display: block;
}

.ui-datepicker-calendar {
	height: 300px
}

#ui-datepicker-div span {
	text-align: center;
}

#ui-datepicker-div td {
	border: none !important;
}

#ui-datepicker-div td a {
	text-align: center;
	border: none !important;
}

.ui-datepicker-header {
	background: transparent;
	border: none;
}

/* 달력 데이트피커 css 종료 */
@media screen and (max-width: 701px) {
	.allwrapper {
		max-width: 344px;
	}
	.reviewcreate {
		flex-direction: column;
	}
	.commentcontent {
		width: auto;
	}
	.candidateimgwrapper {
		grid-template-columns: 113px 113px 113px !important;
	}
	.candidateimgarea {
		width: 113px;
		height: 140px;
		background-size: 100% 100%;
		height: 113px;
	}
	.contentimgtitlearea {
		width: 344px !important;
		height: 300px !important;
	}
	.mobilewrapper {
		display: block;
	}
	.mobileheader {
		display: block;
	}
	#navebarwrapper {
		display: none;
	}

	#onedayclass_name_btn{
		
	height:14px;
	margin-top: 18px;
	
	}
	
	
}
</style>




<script>

var nextpage="${onedayclass.nextpage}";
var endPageFlag;
var onedayclass_name="${onedayclass.onedayclass_name}"





	window.onload = function() {
	$(".ui-datepicker-trigger").trigger("click");
	
	$(".ui-datepicker-trigger").hide();
	
	
	//선택한 날짜를 년-월-일 로 해주는 클릭 이벤트이다. 그리고 
	$(document).on("click",".ui-state-default",(e)=>{
		let day=$(e.target).text();
		let year=$(".ui-datepicker-year").text();
		//벨류값엔 실제 월보다 -1 작은 값이 들어가서 다시 1을 더해준다. 즉 표시로는 5월 인데 벨류값엔 4라 되어있음
		let month=Number($(".ui-datepicker-month option:selected").val())+Number(1);
		
		if(month.length==1){
			month="0"+month;
		}
		if(day.length==1){
			day="0"+day;
		}	
				
		let openday=year+'-'+month+"-"+day;
		console.log("openday->: "+openday)
		
		$("#openday").attr("data-openday",openday);
		$(".opendayinsert").val(openday);
		
		
		changeOpenday();
		
		
	})//클릭 종료
	
	
	//백단에 자리수가 있는지 물어보는 것임
	//SELECT  rest FROM reserverest WHERE onedayclass_num=1 and openday='2024-04-19'; 		
			let rest;
			
			function changeOpenday(){
				
				let onedayclass_num=$(".blackhole").children().val();			
				let openday=$(".blackhole").children().next().val();
				
				console.log("클래스 번호는 "+onedayclass_num+"개설강의 날짜는"+openday);
				
				$.ajax({
					url : "restOneDayClass.do",
					data : {
						onedayclass_num : onedayclass_num,
						openday         : openday
						
					},					
					method : "POST",
					success : function(val) {
						console.log(val);
						rest=val
						
						$(".showrest").children().remove;
						$(".showrest").children().text(val+"자리남음");	
						if(val==-1){
							alert("날짜를 다시 선택해주세요")
						}

					}
				})		
				
			}//체인지 함수 종료
			
			
			
	
	
	
	

}//윈도우 함수 종료
	
/*달력시작  */	
	$(function() {

		$("#onedayclass_name").change(function() {
			
			console.log("값이 변하면 떠야하는디???")
			console.log($(this).val());

			$.ajax({
				url : "selectOneDayClass.do",
				data : {
					onedayclass_name : $(this).val()
				},
				method : "POST",
				success : function(val) {
					console.log(val);

					$.each(val, function(index, obj) {
						console.log("클래스정보 "+obj.onedayclass_info);
						console.log("클래스 이름"+obj.onedayclass_name);
						console.log("클래스 비용 " +obj.onedayclass_price);
						console.log("클래스 대표이미지 "+obj.reserve_img);
						console.log("클래스 번호"+obj.onedayclass_num);
						let names = obj.onedayclass_name
						$(".reserve_img").attr("src", obj.reserve_img)
						$(".onedayclass_name").text(names);
						$(".onedayclass_info").text(obj.onedayclass_info);
						$(".onedayclass_num").val(obj.onedayclass_num)			
					

					});

				}

			})

			/* if($(this).val()=="취미만화반"){
				console.log("ddd");
			$(".reserve_img").attr("src",'./img_onedayclass/manhwa.jpg');
			}                    	 */

		})	 
						 
						
					$(".reservebtn2").on( "click",
						function() {
					
					let count=$(".restcount").text().split("자리남음");
					/* console.log(count[0])
					console.log(count[0]=="0")
					console.log(count[0]==0) */					
					user_code = $("#user_code").val(),
				    openday=$("#opendayinsert").val(),
					onedayclass_num=$("#onedayclass_num").val()
										
					console.log("유저코드: "+user_code+"개설강의 날짜: "+openday+"클래스번호: "+onedayclass_num);					
					if(	count[0]==0){
						alert("마감된 날짜입니다. 날짜를 다시 선택해주세요")
					}else{
				 		$.ajax({
							url : "checkreserveinfo.do",
							data : {
								//백단
								user_code : $("#user_code").val(),
							    openday:$("#opendayinsert").val(),
								onedayclass_num: $("#onedayclass_num").val()
								
							},
							method : "POST",
							success : function(val) {
								
								console.log("중복확인후 값");
								console.log(val);
						
								if (val == "true") {
									
									reserve_img=$("#reserve_img").val();
									onedayclass_name=$("#onedayclass_name").val();
									onedayclass_info=$("#onedayclass_info").val();
									onedayclass_price=$("#onedayclass_price").val();
									rest=count[0];									
			console.log("예약이미지: "+reserve_img+"클래스이름: "+onedayclass_name+"클래스정보소개: "+onedayclass_info+"가격: "+onedayclass_price+"남은자리수: "+rest);
	
			
   window.location.replace("/finall/onedayclasspay.jsp?onedayclass_num="+onedayclass_num+"&openday="+openday
		+"&reserve_img="+reserve_img
		+"&onedayclass_name="+onedayclass_name
		+"&onedayclass_info="+onedayclass_info
		+"&onedayclass_price="+onedayclass_price
		+"&rest="+rest
		)							
		
								} else if(val == "false") {
									alert("죄송합니다. 저희 원데이 클래스는 소규모로, 같은시간에 모든 수업이 일괄적으로 진행되기에 동일한 날짜에 다른 수업을 예약할 수 없습니다.");
								} else if(val == "needjoin"){
									alert("로그인이 필요합니다. 로그인 페이지로 이동합니다.");
									window.location.href="/finall2/login.jsp";
									
								}

							}

						}) 
					}
					})//클릭함수종료			
						

					//<input id="datepicker">을 datepicker로 선언해야 달련 버튼이 자동으로 생긴다.
					//클릭시 그냥 자동으로 달력이 뜸
		$.datepicker
				.setDefaults({
					dateFormat : 'yy-mm-dd' //Input Display Format 변경= 달력선택시 인풋창에 뜬느 값 형식을 지정
					,
					showOtherMonths : true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
					,
					showMonthAfterYear : true //년도 먼저 나오고, 뒤에 월 표시
					,
					changeYear : true //콤보박스에서 년 선택 가능
					,
					changeMonth : true //콤보박스에서 월 선택 가능                
					,
					showOn : "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
					,
				/* buttonImage : "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로 
					, */
				/* 	buttonImageOnly : true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
					, */
					buttonText : "날짜선택하기" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
					,
					yearSuffix : "년" //달력의 년도 부분 뒤에 붙는 텍스트
					,
					monthNamesShort : [ '1', '2', '3', '4', '5', '6', '7', '8',
							'9', '10', '11', '12' ] //달력의 월 부분 텍스트
					,
					monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
							'8월', '9월', '10월', '11월', '12월' ] //달력의 월 부분 Tooltip 텍스트
					,
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ] //달력의 요일 부분 텍스트
					,
					dayNames : [ '일요일', '월요일', '화요일', '수요일', '목요일', '금요일',
							'토요일' ] //달력의 요일 부분 Tooltip 텍스트
					,
					minDate : "-1M" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
					,
					maxDate : "+1M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)                    
				});

		

		
		
		
		//선택자명.datepicker 해야 달력 버튼이 생기는듯??
		$("#openday").datepicker({
			// beforeShowDay 는 datepicker 제공기능이자 키워드 인듯
			// before 는 사용자가 만드는 함수이고, 대충 원하는 요일 또는 일자 등 함수인듯
			beforeShowDay : before
			});

		//주말만 예약받자.
		function before(date) {
			var day = date.getDay();
			// 달력에 출력해줄 것을 배열로 리턴하는듯
			return [ (day != 1 && day != 2 && day != 3 && day != 4 && day != 5) ];
		}

		//From의 초기값을 오늘 날짜로 설정
		$('#reserve').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)



		$(".ui-datepicker-trigger").on("click",(e)=>{
			//제거해야 달력 날짜 선택시 새로고침안됨
			
			$(".ui-state-default").removeAttr("href");			
			$(".ui-datepicker-week-end").removeAttr("href");
			$(".ui-datepicker-week-end").removeAttr("data-event");
			$(".ui-datepicker-calendar")
			
			
			console.log($(".ui-widget-content"))			
			//ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all
			
			
			//제이쿼리 자체로 after 형식으로 들어가 태그형태로 재삽입하자.
			let uiDatepickerDiv=$("#ui-datepicker-div");
			 $("#ui-datepicker-div").removeClass("ui-widget-content")
				$("#ui-datepicker-div").removeClass("ui-helper-clearfix")		
				$("#ui-datepicker-div").removeClass("ui-corner-all")
				
				
				
			/*$("#ui-datepicker-div").remove(); */
			
			
			
			//제이쿼리 자체로 after 형식으로 들어가 태그형태로 재삽입하자.
			$("#insertDatePicker").html(uiDatepickerDiv);
			
			
			
			    
		})
		
		
	
		
		
	});
	
	
/*달력종료  */	
	console.log("페이지 최초 진입후 nextpage값 : "+nextpage);	
	console.log("페이지 최초 진입후 onedayclass_name값 :"+onedayclass_name);	
	console.log("페이지 최초 진입후 endPageFlag: "+endPageFlag);		
		
		
		$(document).on("click",".nextpagebtn",()=>{	
		
			console.log("다른페이지 들려다왔을시 nextpage: "+nextpage);	
			console.log("다른페이지 들려다왔을시 onedayclass_anme: "+onedayclass_name);	
			console.log("다른페이지 들렸다왔을시 endPageFlag: "+endPageFlag);
			
			
			$.ajax({
				url:"dynamicdrawinglist.do",
				type:"POST",
				data:{"nextpage":nextpage,"onedayclass_name":onedayclass_name},
				success:(data)=>{
					
					console.log("받은데이터 시작")
					
					 console.log(data);
					
					console.log("받은데이터 종료")
					nextpage=Number(nextpage)+Number(4);
					//console.log("초기화후 nextpage-> "+test);
					$('.update').before(data);	
					console.log("초기화후 nextpage-> "+nextpage)
					
				}
				
			})
			
			
			return false;
		})
		
		
		
	
		

		$("button[class=testbtn]").on("click", function() {
			location.href = "getpagingworkimg.do?pagebtn=2";
		})

		$("button[class=pagebtn]")
				.on(
						"click",
						function() {
							console.log($(this).text());
							$
									.ajax({
										/* contentType : "Application/json " , */
										url : "getpagingworkimg.do",
										data : {
											"pagebtn" : $(this).text()
										},
										type : "POST", //type=우리가보내는 타입,
										success : function(val) {
											console.log(val);

											let str = '';
											$
													.each(
															val,
															function(index, obj) {

																console
																		.log(val[index].worklist_img);

																str += ' <div class="col-md-3">';
																str += ' <div class="shortinfo">';
																str += " <img src='./img/"+val[index].worklist_img+"'"+">";
																str += '<p><span>작성일:'
																		+ val[index].worklist_regidate
																		+ '</span></p>';
																str += '<p><span>작성자:'
																		+ val[index].id
																		+ '</span></p>';
																str += '<p><span>소개글:'
																		+ val[index].worklist_comment
																		+ '</span></p>';
																str += '</div>';
																str += '</div>';

															});
											$("div#nth2row").html(str);

										}

									});

						})

		var mql3 = window.matchMedia("screen and (min-width: 768px)");
		var mql = window
				.matchMedia("screen and (min-width: 441px) and (max-width: 768px)");
		var mql2 = window.matchMedia("screen and (max-width: 440px)");

		mql.addListener(function(e) {
			if (e.matches) {

				$('div[class="col-md-3"]').attr('class', 'col-md-6'); //
				$('div[class="col-md-6"]').css({
					"width" : "50%"
				})

			} else {

			}
		});

		mql2.addListener(function(e) {
			if (e.matches) {

				$('div[class="col-md-6"]').css({
					"width" : "100%"
				});

			} else {
				/* 	$('div[class="col-md-6"]').css({"width":"100%"}); */
			}
		});

		mql3.addListener(function(e) {
			if (e.matches) {

				$('div[class="col-md-6"]').attr('class', 'col-md-3'); //

			} else {

			}
		});

	
</script>
</head>
<body>
	<div class="allwrapper">

		<!-- pc 디자인 시작 -->

		<!-- 박스 음영추가 하려고 한번 더 감싸자. -->
		<div class="pcboxwrapper">
			<!-- 네이버 성님들도 예약 페이지 에선 네브바가 없으니 그냥 뒤로가기 아이콘을 하나 추가한다.
		<%-- 	<%@ include file="/pcNave.jsp"%>
			<%@ include file="/mobileNave.jsp"%> --%>
			 -->			 
			<div class="back">
			
			<a href="mainhome.jsp"><div class="backarea"></div></a>
						
			<div class="otherclassarea">	<ul id="onedayclass_name_btn">

						<div class="onedayclass_name_list">
							<li class="onedayclass_name" value="취미만화반">취미만화반</li>
							<li class="onedayclass_name" value="취미실사반">취미실사반</li>
							<li class="onedayclass_name" value="취미풍경화반">취미풍경화반</li>

						</div>


						<button class="onedayclass_name_btn" value="open">클래스선택</button>
					</ul></div>
			</div>
			
			
			<div class="pcwrapper">
				<div class="contenttilewrapper">							
					<%-- 	<h3>${onedayclass.onedayclass_info}</h3> --%>
				

				<!-- 	<ul id="onedayclass_name_btn">

						<div class="onedayclass_name_list">
							<li class="onedayclass_name" value="취미만화반">취미만화반</li>
							<li class="onedayclass_name" value="취미실사반">취미실사반</li>
							<li class="onedayclass_name" value="취미풍경화반">취미풍경화반</li>

						</div>


						<button class="onedayclass_name_btn" value="open">열기</button>
					</ul> -->

					<!-- <select id="onedayclass_name" name="onedayclass_name">
						<option value="취미만화반">취미만화반</option>
						<option value="취미실사반">취미실사반</option>
						<option value="취미풍경화반">취미풍경화반</option>
					</select> -->

					<script>					
					$(".onedayclass_name_btn").on("click",(e)=>{
						let clopen=$(e.target).val();
						let list=$(e.target).prev().children();				
						
						if(clopen=="open"){
							
							
							
							$(e.target).val("close")
							
							let str="";
							str+="<div class=open>"
								str+="<ul >"
							
							//list[k] 로 반복문 돌리며 추가 하려했는데 HTMLLIElement 을 문자열로 변환을 못하겟음...
							for(let k=0; k<list.length; k++){
								
								//HTMLLIElement 이다. 즉 출력시 html 태그형태로 표현됨
								console.log(list[k]);
								//str+=list[k].toString();								
							}
								
							str+='<li class="onedayclass_name" value="취미실사반">취미실사반</li>'
							str+='<li class="onedayclass_name" value="취미풍경화반">취미풍경화반</li>'							
							str+='<li class="onedayclass_name" value="취미만화반">취미만화반</li>'
							str+="</ul>"		
							str+="</div>"	
							
							$("#onedayclass_name_btn").after(str);							
							$(".onedayclass_name_btn").text("접기")
						}else{
							$(e.target).val("open")
							$(".open").remove();
							$(".onedayclass_name_btn").text("클래스선택")
			
						}
						
					
						
					return false;	
					})
					
					$(document).on("click",".onedayclass_name",(e)=>{
						
						let choicetitle=$(e.target).text();
						$(".onedayclass_name_list").children().text(choicetitle);
						
						let onedayclass_name=choicetitle;
						   
						let nextpage=0;
						console.log("아작스 호출 직전");
						
						$(".newpageinsert").empty();
						//다른리뷰						
						$.ajax({
							url:"getOtherReview.do",
							type:"POST",
							data:{"onedayclass_name":onedayclass_name,"nextpage":nextpage},
							
							success:(data)=>{
								$(".newpageinsert").append(data);							
							}							
							
						})
						
						
						
						
						return false;
						
					})
					
					
					
					
					</script>

				</div>
				<div class="newpageinsert">
					<div class="contentimgwrapper">
						<!-- ./img_onedayclass/manhwa.jpg -->
						<ul>
							<li class="contentimgtitlewrapper">
								<div class="contentimgtitlearea"></div>
							</li>

							<li class="candidateimgwrapper"><c:forEach
									items="${joinToReview}" var="candidateimg" begin="0" end="2">
									<div class="candidateimgarea"
										style="background-image: url('./img_review/${candidateimg.review_img}')">
									</div>
								</c:forEach></li>
						</ul>

					</div>
					<!-- 달력을추가 이자리체 추가하자잉-->

					<!-- Section2_3 시작 -->
					<div id="calendarwrapper">
						<div class="infowraper">
							<div id="iconrow" class="row ">
								<div class="detail">
									<img id="infoicon1" class="infoicon"
										src="./img_infoicon/check.png" /> <span>서울시</span>
								</div>

								<div class="detail">
									<img class="infoicon" src='./img_infoicon/time.png' /> <span>이용시간
										2시간</span>
								</div>


								<div class="detail">
									<img class="infoicon" src='./img_infoicon/warnning.png'>
									<span>주차불가</span>
								</div>

								<div class="detail">
									<img class="infoicon" src='./img_infoicon/headcount.png'>
									<span>최대이용인원 4명</span>
								</div>

								<input type="hidden" id="check" name="check">
								<!-- user_code 로 다 작동하면 userId는 지워라. -->
								<input type="hidden" id="id" name="id" value="${userId}">
								<input type="hidden" id="user_code" " name="user_code"
									value="${user_code}">


							</div>
							<div id="insertDatePicker"></div>

							<div class="dayandrest">
								<div class="showrest">
									<span class="restcount">달력날짜를클릭해주세요</span> <input type="text" id="openday"
										class="reserve_day" name="openday" style="display: none;">
								</div>							
							</div>

							<div class="blackhole">
								<input type="hidden" id="onedayclass_num" name="onedayclass_num"
									value="${onedayclass.onedayclass_num}">
									 <input
									type="hidden" id="opendayinsert" class="opendayinsert" name="openday" value>
									<input type="hidden" id="user_code" name="user_code" value="${user_code}">
									<input type="hidden" id="reserve_img" name="reserve_img" value="${onedayclass.reserve_img}">
									<input type="hidden" id="onedayclass_name" name="onedayclass_name" value="${onedayclass.onedayclass_name}">
									<input type="hidden" id="onedayclass_info" name="onedayclass_info" value="${onedayclass.onedayclass_info}">
									<input type="hidden" id="onedayclass_price" name="onedayclass_price" value="${onedayclass.onedayclass_price}">
									<input type="hidden" id="rest" name="rest" value="${onedayclass.onedayclass_price}">
								
									
									
									
									
									

							</div>



						</div>





					</div>
					<!-- Section2_3 종료 -->






					<div class="sinchung">
						<!-- <h3 class="reservebtn" >신청하기</h3> -->
						<h3 class="reservebtn2">신청하기</h3>

						<h3 class="attributebtn">버튼 속성값 가져오기 테스트</h3>

						<script>
$(".attributebtn").click((e)=>{
	
$(".reserve_img").attr("src");
$(".onedayclass_name").text();
$(".onedayclass_info").text();
console.log($(".reserve_img").attr("src"))
console.log($(".onedayclass_name").text())
console.log($(".onedayclass_info").text())
/* 
<h2 class="onedayclass_name">${first.onedayclass_name}</h2>
<p class="onedayclass_info">${first.onedayclass_info}</p>
	 */
	
})


</script>

					</div>


					<!-- wrapper -->
					<!-- Footer -->






					<!--달력 종료  -->
					<div class="linecut1">

						참여자들이<span style="color: #ff5862;">직접 체험하고</span>작성하는 후기입니다.
					</div>

					<div class="commentwrapper">
						<h3 class="reviewsize">
							후기:<span>${joinToReview.size()}건</span>
						</h3>

						<!--버튼에서 다른 클래스 후기 보기 할시 jsp돌림 당하고 올꺼라  class="onedayclasslist" 로 한번 감쌈. -->
						<div class="onedayclasslist">
							<c:forEach items="${joinToReview}" var="review">
								<div class="recentreviewwrapper"
									style="
						<c:if test="${review.review_img eq 'noimg'}">height: 150px;</c:if>">
									<!-- heigth 값을 주고 오버플로 친다음 자바스크립트로 계속 헤이트를 늘려주는 이벤트를 만들어보자. -->
									<div class="recentreview"
										style="						
					<c:if test="${review.review_img eq 'noimg'}">height: 100%;</c:if>">
										<p>${review.review_name}</p>
										<p>수업:${onedayclass.onedayclass_name}</p>
										<c:if test="${review.review_img ne 'noimg'}">
											<div class="reviewimg"
												style="background-image: url('./img_review/${review.review_img}');"></div>
										</c:if>
										<p class="reviewcreate">
											<span class="commentcontent">${review.review_comment}</span>
											<span class="createcontent" style="color: #ff5862;">작성일:
												${review.review_create_at}</span>
										</p>
									</div>
								</div>
							</c:forEach>
						</div>


						<div class="update"></div>


						<div class="nextpage">
							<button class="nextpagebtn">더보기</button>
						</div>



					</div>
				</div>


			</div>
		</div>
		<!-- pc 디자인 종료 -->

		<!-- 모바일 디자인 시작 -->
		<%-- 	<%@ include file="/mobileNave.jsp"%>
		<div class="mobilewrapper">
			<div class="show">
				<h2>참여자들의 갤러리</h2>
			</div>

			<c:choose>
				<c:when test="${worklist ne null}">
					<c:set var="total" value="0" />
					<div id="containerinfo" class="container ">
						<div class="row">
							<h2>갤러리</h2>
						</div>
						<div id="nth2row" class="row ">
							<c:forEach var="w" items="${worklist}" varStatus="i">

								<div class="col-md-3">
									<div class="shortinfo">
										<img src='./img/${w.worklist_img}'>
										<p>
											<span>작성일:${w.worklist_regidate}</span>
										</p>
										<p>
											<span>작성자:${w.id}</span>
										</p>
										<p>
											<span>소개글:${w.worklist_comment}</span>
										</p>
									</div>

								</div>
							</c:forEach>
						</div>
						<div class="buttonwrapper">
							<c:forEach var="i" begin="1" end="${fn:length(buttonnum)}"
								step="1" varStatus="status">

								<button class="pagebtn">${status.index}</button>
							</c:forEach>
						</div>
					</div>

				</c:when>
			</c:choose>


			<button class="testbtn">2</button>
		</div> --%>
	</div>

</body>
</html>