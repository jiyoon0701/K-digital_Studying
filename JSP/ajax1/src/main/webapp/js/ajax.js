/**
 * /ajax1/src/main/webapp/js/ajax.js
 */
function ajax(url,params,callback,method) {
	const xhttp = new XMLHttpRequest()
	method = method.toUpperCase()  //대문자로 변환
	if(method != 'POST') {
		method = 'GET'
	}
	if(method == 'GET') { //요청url+파라미터정보
		url = url+"?"+params
	}
	//true : 비동기 방식 사용
	xhttp.open(method,url,true)
	//POST 방식 반드시 설정. GET방식은 상관 없음
	xhttp.setRequestHeader('Content-Type',
	'application/x-www-form-urlencoded;charset=UTF-8')
	xhttp.send(method == 'POST'?params : null)
	xhttp.onreadystatechange = callback  //콜백함수
} 