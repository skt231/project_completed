function fetchXML(url) {
	return new Promise(function(resolve, reject) {
		fetch(url).then(function(response) {
			return response.text();
		}).then(function(xmlString) { // xmlString 변수명이 누락되었던 것을 수정
			resolve(new DOMParser().parseFromString(xmlString, 'text/xml'));
		}).catch(function(error) {
			console.error('XML 가져오기 오류:', error);
			reject(null);
		});
	});
}

function fetchAndDisplayPosters() {
	var posterContainer = document.getElementById('posterContainer');
	var xmlUrl = posterContainer.getAttribute('data-xmlurl');

	return fetchXML(xmlUrl).then(function(xmlDoc) {
		var jsonData = [];

		if (!xmlDoc) {
			return [];
		}

		var dbElements = xmlDoc.querySelectorAll('db');

		Array.prototype.forEach.call(dbElements, function(dbElement) {
			var posterElement = dbElement.querySelector('poster');
			var mt20idElement = dbElement.querySelector('mt20id');

			if (posterElement && mt20idElement) {
				jsonData.push({
					poster: posterElement.textContent,
					mt20id: mt20idElement.textContent
				});
			}
		});

		return jsonData;
	});
}

function fetchAndInfo() {
	return new Promise(function(resolve, reject) {
		var urlParams = new URLSearchParams(window.location.search);
		var data = urlParams.get('data');
		var xmlUrl = 'http://www.kopis.or.kr/openApi/restful/pblprfr/' + data + '?service=b0a82e699a254319bbe6decc02de2489';

		fetch(xmlUrl).then(function(response) {
			return response.text();
		}).then(function(responseText) {
			var parser = new DOMParser();
			var xmlDoc = parser.parseFromString(responseText, 'text/xml');

			// 데이터 파싱 부분
			var fields = {
				poster: xmlDoc.querySelector('poster').textContent,
				title: xmlDoc.querySelector('prfnm').textContent,
				prStart: xmlDoc.querySelector('prfpdfrom').textContent,
				prEnd: xmlDoc.querySelector('prfpdto').textContent,
				prDatetime: xmlDoc.querySelector('dtguidance').textContent,
				prtime: xmlDoc.querySelector('prfruntime').textContent,
				prloc: xmlDoc.querySelector('fcltynm').textContent,
				prcast: xmlDoc.querySelector('prfcast').textContent,
				prcrew: xmlDoc.querySelector('prfcrew').textContent,
				prprice: xmlDoc.querySelector('pcseguidance').textContent,
			};

			resolve(fields);
		}).catch(function(error) {
			console.error("오류:", error);
			reject(error);
		});
	});
}

//title,date,loc,time
function fetchAndReservation() {
	return new Promise(function(resolve, reject) {
		var titleContainer = document.getElementById('titleContainer');
		var xmlUrl = titleContainer.getAttribute('data-xmlurl');

		fetchXML(xmlUrl).then(function(xmlDoc) {
			var jsonData = [];

			if (!xmlDoc) {
				resolve([]);
				return;
			}

			var dbElements = xmlDoc.querySelectorAll('db');

			dbElements.forEach(function(dbElement) {
				var mt20idElement = dbElement.querySelector('mt20id');
				var titleElement = dbElement.querySelector('prfnm');
				// var dateFromElement = dbElement.querySelector('prfpdfrom');
				// var dateToElement = dbElement.querySelector('prfpdto');
				// var dateElement = dbElement.querySelector('dtguidance');
				// var locElement = dbElement.querySelector('prloc');

				jsonData.push({
					mt20id: mt20idElement.textContent,
					prfnm: titleElement.textContent
					// prfpdfrom: dateFromElement.textContent,
					// prfpdto: dateToElement.textContent,
					// dtguidance: dateElement.textContent,
					// fcltynm: locElement.textContent
				});
			});

			resolve(jsonData);
		}).catch(function(error) {
			console.error("오류:", error);
			reject(error);
		});
	});
}

function fetchAndDisplayTitle() {
	var titleContainer = document.getElementById('titleContainer');
	var xmlUrl = titleContainer.getAttribute('data-xmlurl');

	return fetchXML(xmlUrl).then(function(xmlDoc) {
		console.log(jsonData);
		var jsonData = [];

		if (!xmlDoc) {
			return [];
		}

		var dbElements = xmlDoc.querySelectorAll('db');

		Array.prototype.forEach.call(dbElements, function(dbElement) {
			var titleElement = dbElement.querySelector('prfnm');
			var mt20idElement = dbElement.querySelector('mt20id');

			if (titleElement && mt20idElement) {
				jsonData.push({
					title: titleElement.textContent,
					mt20id: mt20idElement.textContent
				});
			}
		});

		return jsonData;
	});
}

// 전역 범위에 함수 추가
window.fetchXML = fetchXML;
window.fetchAndDisplayPosters = fetchAndDisplayPosters;
window.fetchAndInfo = fetchAndInfo;
window.fetchAndReservation = fetchAndReservation;
window.fetchAndDisplayTitle = fetchAndDisplayTitle;
