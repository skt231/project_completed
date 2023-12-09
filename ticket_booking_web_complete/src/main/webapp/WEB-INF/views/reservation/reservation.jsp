<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<head>
<meta charset="utf-8">
<title>예약</title>

<!-- mobile responsive meta -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- ** Plugins Needed for the Project ** -->
<!-- Bootstrap -->

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/bootstrap/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/fontawesome/css/all.css">

<!-- Main Stylesheet -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">


<!--Favicon-->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/images/favicon.png"
	type="image/x-icon">
<link rel="icon"
	href="${pageContext.request.contextPath}/resources/images/favicon.png"
	type="image/x-icon">
<!-- style -->

<style>
body {
	margin: 0;
	font-family: Arial, sans-serif;
	padding: 20px;
}

.top-right {
	position: absolute;
	top: 10px;
	right: 10px;
}

.quick-reserve {
	font-size: 13px;
	border: 1px solid #ddd;
	padding: 20px;
	width: 100%;
	display: flex;
	position: relative;
}

.option-box {
	flex: 1;
	padding: 10px;
	border-right: 1px solid #ddd;
}

.option-box:last-child {
	border-right: none;
}

.option-label {
	font-weight: bold;
	display: block;
	margin-bottom: 10px;
}

ul {
	list-style: none;
	padding-left: 0;
	margin: 0;
}

#movie {
	width: 100%;
	white-space: nowrap;
}

#movie li {
	margin-bottom: 10px;
	padding: 5px;
	border: 1px solid #ddd;
}

#movie li a {
	font-size: 5px;
}

.option-box ul:not (#movie ){
	display: flex;
}

.option-box ul:not (#movie ) li {
	margin-right: 10px;
	padding: 5px;
	border: 1px solid #ddd;
}

.calendar {
	text-align: center;
	margin-bottom: 20px;
	/* 간격을 늘리기 위한 마진 추가 */
}

#time {
	display: flex;
	flex-direction: column;
}

#time li {
	font-size: 20px;
	margin-bottom: 3px;
	padding: 3px;
	width: fit-content; /* 추가된 부분 */
}

button {
	padding: 8px 12px;
	background-color: #007BFF;
	color: white;
	border: none;
	cursor: pointer;
	transition: background-color 0.3s;
	position: absolute;
	bottom: 10px;
	right: 10px;
	font-size: 0.8rem;
}

button:hover {
	background-color: #0056b3;
}

#titleContainer div a, #time li a {
	font-size: 13px;
	text-decoration: none;
}

/* 마우스 오버 시 */
#titleContainer div a:hover {
	background-color: #e0e0e0;
	/* 라이트 그레이 */
	color: black;
	text-decoration: none;
}

/* 클릭 시 */
#titleContainer div a:active {
	background-color: #b0b0b0;
	/* 미디엄 그레이 */
	color: white;
}

/* 선택된 경우 */
#titleContainer div a.selected {
	background-color: #004F4D;
	/* 파란색 */
	color: #ffd6cd;
}

#time li a:hover {
	background-color: #e0e0e0;
	/* 라이트 그레이 */
	color: black;
	text-decoration: none;
}

#time li a:active {
	background-color: #b0b0b0;
	/* 미디엄 그레이 */
	color: white;
}

#time li a.selected {
	background-color: #004F4D;
	color: #ffd6cd;
}

.form-group {
	margin-bottom: 10px;
}

/* Prev 및 Next 버튼 크기 줄이기 */
.ui-datepicker-header .ui-datepicker-prev, .ui-datepicker-header .ui-datepicker-next
	{
	font-size: 12px;
	padding: 2px;
}

/* 월 및 년도 표시 부분 크기 줄이기 */
.ui-datepicker-title {
	font-size: 12px;
	line-height: 20px;
}

.ui-datepicker th span {
	font-size: 12px;
	padding: 2px;
}

#next {
	margin-right: 2em;
}
</style>
</head>
<!-- 소통페이지 -->
<!-- START preloader-wrapper -->
<div class="preloader-wrapper">
	<div class="preloader-inner">
		<div class="spinner-border text-red"></div>
	</div>
</div>
<!-- END preloader-wrapper -->

<!-- START main-wrapper -->
<section class="d-flex">

	<!-- start of sidenav -->
	<aside>
		<div
			class="sidenav position-sticky d-flex flex-column justify-content-between">
			<a class="navbar-brand" href="/app/" class="logo"> <img
				src="${pageContext.request.contextPath}/resources/images/logo.png"
				alt="">
			</a>
			<!-- end of navbar-brand -->

			<div class="navbar navbar-dark my-4 p-0 font-primary">
					<ul class="navbar-nav w-100">
						<li class="nav-item active"><a
							class="nav-link text-white px-0 pt-0" href="/app/">Home</a></li>
						<li class="nav-item "><a class="nav-link text-white px-0"
							href="/app/introduction">소개</a></li>
						<li class="nav-item "><a class="nav-link text-white px-0"
							href="/app/board">소통공간</a></li>
						<li class="nav-item  accordion">
							<div id="drop-menu_1" class="drop-menu collapse">
								<a class="d-block " href="/app/reservation/rsv">예매하기</a> <a
									class="d-block " href="/app/playList">전체 공연</a> <a
									class="d-block "
									href="/app/reservation/readId?userid=${userses.id}">예매현황</a>
							</div> <a class="nav-link text-white" href="#!" role="button"
							data-toggle="collapse" data-target="#drop-menu_1"
							aria-expanded="false" aria-controls="drop-menu_1">예매하기</a>
						</li>
						<li class="nav-item "><a class="nav-link text-white px-0"
							href="/app/user/userDetailed?id=${userses.id}">MyPage</a></li>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<li class="nav-item  accordion">
								<div id="drop-menu_2" class="drop-menu collapse">
									<a class="d-block " href="/app/user//listAll">회원목록</a> <a
										class="d-block " href="###">###</a> <a class="d-block "
										href="###">###</a>
								</div> <a class="nav-link text-white" href="#!" role="button"
								data-toggle="collapse" data-target="#drop-menu_2"
								aria-expanded="false" aria-controls="drop-menu_2">관리메뉴</a>
							</li>
						</sec:authorize>
					</ul>
				</div>
			<!-- end of navbar -->
			<br>
		</div>
	</aside>
	<div class="top-right">
		<sec:authorize access="isAnonymous()">
				<p>

					<span><a href="/app/user/login">로그인</a></span> &nbsp; <span><a
						href="/app/user/linkRegister">등록</a></span>
				</p>
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">
	<%-- 			<span>${userses.username}!</span> &nbsp;
		<form:form action="${pageContext.request.contextPath}/user/logout"
					method="POST">
					<input type="submit" value="로그아웃" />
				</form:form> --%>
			</sec:authorize>
	</div>
	<!-- end of sidenav -->
	<!-- -------------------------------------------------------------------------------------------------------------------------------------- -->
	<div class="main-content">
		<!-- start of mobile-nav -->
		<header class="mobile-nav pt-4">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-6">
						<a href="/app/"> <img
							src="${pageContext.request.contextPath}/resources/images/logo.png"
							alt="">
						</a>
					</div>
					<div class="col-6 text-right">
						<button class="nav-toggle bg-transparent border text-white">
							<span class="fas fa-bars"></span>
						</button>
					</div>
				</div>
			</div>
		</header>
		<div class="nav-toggle-overlay"></div>
		<!-- end of mobile-nav -->
		<div class="container py-4 my-5">
			<form action="/app/reservation/seat" method="POST">
			 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				<input type="hidden" name="title" id="selectedTitle"> <input
					type="hidden" name="mt20id" id="mt20id"> <input
					type="hidden" name="date" id="selectedDate"> <input
					type="hidden" name="location" id="selectedLocation"> <input
					type="hidden" name="time" id="selectedTime">
				<div class="col-md-12 m-30">
					<div class="quick-reserve">

						<div class="option-box">
							<label class="option-label" for="movie">연극:</label>
							<ul id="movie" class="row">
								<div class="col-md-12">
									<li id="titleContainer"
										data-xmlurl="http://www.kopis.or.kr/openApi/restful/pblprfr?service=b0a82e699a254319bbe6decc02de2489&stdate=20230901&eddate=20230910&cpage=1&rows=5&prfstate=02&signgucode=11&signgucodesub=1111&kidstate=Y">
									</li>
								</div>
							</ul>
						</div>


						<div class="option-box">
							<label class="option-label" for="datepicker">날짜:</label>
							<div class="calendar">
								<input type="text" id="datepicker" placeholder="요일 선택">
							</div>
							<label class="option-label" for="location">장소:</label>
							<div id="location">
								<span id="defaultLocation"></span>
							</div>
						</div>

						<div class="option-box">
							<label class="option-label" for="time">시간:</label>
							<ul id="time">

							</ul>
						</div>

						<button type="button" id="next">다음으로</button>
					</div>
				</div>
			</form>

		</div>

	</div>
</section>
<!-- END main-wrapper -->
<!-- 	---------------------------------------------------------------------------------------------------------------------------------------------- -->
<!-- All JS Files -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/imageModule.js"
	defer></script>
<!-- Main Script -->
<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
//선택 가능한 날짜와 시간을 저장할 배열
var selectableDays = [];

// 최소 및 최대 선택 가능한 날짜 변수
var minSelectableDate = null;
var maxSelectableDate = null;

// 스케줄 정보 추출 함수
function extractSchedule(dtguidance) {
    var daysMapping = {
        '월요일': 1,
        '화요일': 2,
        '수요일': 3,
        '목요일': 4,
        '금요일': 5,
        '토요일': 6,
        '일요일': 0,
        'HOL': [6, 0]
    };

    var schedules = dtguidance.split(', ');
    var result = [];

    for (var i = 0; i < schedules.length; i++) {
        var schedule = schedules[i];
        var parts = schedule.split('(');
        var dayPart = parts[0];
        var timePart = parts[1] ? parts[1].replace(')', '').split(',').map(function (time) {
            return time.trim();
        }) : [];

        if (dayPart.indexOf('~') !== -1) {
            var startEnd = dayPart.split('~').map(function (part) {
                return part.trim();
            });
            var start = daysMapping[startEnd[0]];
            var end = daysMapping[startEnd[1]];
            var currentDay = start;

            while (currentDay !== end) {
                result.push({
                    day: currentDay,
                    times: timePart
                });
                currentDay = (currentDay + 1) % 7;
            }

            result.push({
                day: end,
                times: timePart
            });
        } else {
            result.push({
                day: daysMapping[dayPart.trim()],
                times: timePart
            });
        }
    }

    return result;
}

// datepicker 초기화
$("#datepicker").datepicker({
    dateFormat: "yy-mm-dd",
    beforeShowDay: function (date) {
        var day = date.getDay();
        return [selectableDays.some(function (schedule) {
            return Array.isArray(schedule.day) ? schedule.day.includes(day) : schedule.day === day;
        })];
    },
    beforeShow: function (input, inst) {
        inst.dpDiv.css({
            backgroundColor: 'white',
            color: 'black'
        });
    },
    onSelect: function (dateText, datePickerInstance) {
        var selectedDate = new Date(dateText);
        var dayOfWeek = selectedDate.getDay();

        var matchedSchedule = selectableDays.find(function (schedule) {
            return Array.isArray(schedule.day) ? schedule.day.includes(dayOfWeek) : schedule.day === dayOfWeek;
        });

        if (matchedSchedule) {
            var timeList = document.getElementById('time');
            timeList.innerHTML = "";

            matchedSchedule.times.forEach(function (time) {
                var timeItem = document.createElement('li');
                var timeLink = document.createElement('a');
                timeLink.href = "#";
                timeLink.textContent = time;
                timeItem.appendChild(timeLink);
                timeList.appendChild(timeItem);
            });

            var timeLinks = document.querySelectorAll("#time li a");
            timeLinks.forEach(function (link) {
                link.addEventListener("click", function (event) {
                    event.preventDefault();
                    timeLinks.forEach(function (innerLink) {
                        innerLink.classList.remove('selected');
                    });
                    this.classList.add('selected');
                    var mt20id = document.querySelector("#titleContainer div a.selected").getAttribute('data-mt20id');
                    console.log(mt20id);
                });
            });
        }
    }
});

//"다음으로" 버튼 클릭 이벤트 처리
document.getElementById('next').addEventListener('click', function (event) {
    event.preventDefault(); // 기본 동작 방지

    var selectedMovieLink = document.querySelector("#titleContainer div a.selected");

    if (selectedMovieLink) {
        var mt20id = selectedMovieLink.getAttribute('data-mt20id');
        document.getElementById('mt20id').value = mt20id;

        var selectedDate = document.querySelector("#datepicker").value;
        document.getElementById('selectedDate').value = selectedDate;

        var selectedLocation = document.querySelector("#location span").textContent;
        document.getElementById('selectedLocation').value = selectedLocation;

        var selectedTime = document.querySelector("#time li a.selected").textContent;
        var regex = /(\d{2}:\d{2})/;
        var match = regex.exec(selectedTime);

        if (match) {
            var time = match[1];
            document.getElementById('selectedTime').value = time;
        }

        // 폼을 서버로 제출
        document.querySelector('form').submit();
    } else {
        alert("선택해주세요.");
    }
});

// 페이지 로드 시 실행할 코드
document.addEventListener("DOMContentLoaded", function () {
    var titleContainer = document.getElementById('titleContainer');
    var locationSpan = document.getElementById('defaultLocation');
    var url = titleContainer.getAttribute('data-xmlurl');

    // XML 데이터 가져오기
    fetchXML(url)
        .then(function (xmlData) {
            // 공연 정보 처리
            var items = xmlData.querySelectorAll('db');
            items.forEach(function (item) {
                var div = document.createElement('div');
                div.classList.add('col-md-4');
                var a = document.createElement('a');
                a.href = "#";
                a.textContent = item.querySelector('prfnm').textContent;
                a.setAttribute('data-mt20id', item.querySelector('mt20id').textContent);
                div.appendChild(a);
                titleContainer.appendChild(div);
            });

            // 각 영화 링크에 이벤트 리스너 추가
            var movieLinks = document.querySelectorAll("#titleContainer div a");
            movieLinks.forEach(function (link) {
                link.addEventListener("click", function (event) {
                    event.preventDefault();
                    movieLinks.forEach(function (innerLink) {
                        innerLink.classList.remove('selected');
                    });
                    this.classList.add('selected');

                    // 선택된 영화 정보 설정
                    var mt20id = this.getAttribute('data-mt20id');
                    var selectedMovieTitle = this.textContent;
                    document.getElementById('selectedTitle').value = selectedMovieTitle;

                    // 선택된 영화의 상세 정보 가져오기
                    fetchXML("http://www.kopis.or.kr/openApi/restful/pblprfr/" + mt20id + "?service=b0a82e699a254319bbe6decc02de2489")
                        .then(function (detailDataXML) {
                            // 장소 업데이트
                            var prloc = detailDataXML.querySelector('fcltynm').textContent;
                            locationSpan.textContent = prloc;

                            // 기간 설정
                            var prfpdfromNode = detailDataXML.querySelector('prfpdfrom');
                            var prfpdtoNode = detailDataXML.querySelector('prfpdto');

                            if (prfpdfromNode && prfpdtoNode) {
                                var fromDate = new Date(prfpdfromNode.textContent);
                                var toDate = new Date(prfpdtoNode.textContent);
                                $("#datepicker").datepicker("option", "minDate", fromDate);
                                $("#datepicker").datepicker("option", "maxDate", toDate);
                            }

                            // 스케줄 설정
                            var dtguidanceNode = detailDataXML.querySelector('dtguidance');
                            if (dtguidanceNode) {
                                var scheduleData = extractSchedule(dtguidanceNode.textContent);
                                selectableDays = scheduleData;
                            }
                        });
                });
            });
        });
});

// XML 데이터를 비동기적으로 가져오는 함수
async function fetchXML(url) {
    var response = await fetch(url);
    if (!response.ok) throw new Error("Network response was not ok");

    var text = await response.text();
    var parser = new DOMParser();
    return parser.parseFromString(text, "text/xml");
}

</script>

</body>
