function checkJoinValues(htmlForm) {
	
//	let url = "join?"
	
	const client_id = document.getElementById("client_id").value;
	const client_pw = document.getElementById("client_pw").value;
	const client_pw2 = document.getElementById("client_pw2").value;
	const name = document.getElementById("name").value;
	const phone = document.getElementById("phone").value;

//	let check = true;
	
//	if(client_id !== "")
//		url += "client_id=" + client_id + "&";
//	if(client_pw !== "")
//		url += "client_pw=" + client_pw + "&";
//	if(client_pw2 !== "")
//		url += "client_pw2=" + client_pw2 + "&";
//	if(name !== "")
//		url += "name=" + name + "&";
//	if(phone !== "")
//		url += "phone=" + phone + "&";
		
	// 항목의 값이 없으면 > 페이지 유지
	// 입력되지 않은 항목에 대한 alret() & focus 넘기기
	// 모든 항목이 입력되어 잇으면 submit
		
	if(client_id === ""){
		alert('아이디가 입력되지 않았습니다.');
		check = false;
	}
	else if(client_pw === ""){
		alert('비밀번호가 입력되지 않았습니다.');
		check = false;
	}
	else if(client_pw !== client_pw2){
		alert('비밀번호 확인이 필요합니다.');
		check = false;
	}
	else if(name === ""){
		alert('이름이 입력되지 않았습니다.');
		check = false;
	}
	else if(phone === ""){
		alert('전화번호가 입력되지 않았습니다.');
		check = false;
	}

//	if(check === false)
//		location.href = url;
	
	htmlForm.submit();
}

function checkLoginValues(htmlForm) {
	
	const client_id = document.getElementById("client_id").value;
	const client_pw = document.getElementById("client_pw").value;

	if(client_id === ""){
		alert('아이디가 입력되지 않았습니다.');
		check = false;
	}
	
	else if(client_pw === ""){
		alert('비밀번호가 입력되지 않았습니다.');
		check = false;
	}
	
	htmlForm.submit();
}

function checkLogIn() {
	
	alert('로그인 화면으로 이동합니다.');
	location.href = 'login';
	
}

function logout(htmlForm) {
	alert('로그아웃 되었습니다.');
	htmlForm.submit();
}