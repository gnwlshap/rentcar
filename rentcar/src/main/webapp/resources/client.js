function checkJoinValues(htmlForm) {
	
//	let url = "join?"
	
	const client_id = document.getElementById("client_id");
	const client_pw = document.getElementById("client_pw");
	const client_pw2 = document.getElementById("client_pw2");
	const name = document.getElementById("name");
	const phone = document.getElementById("phone");

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
		
	if(client_id.value === ""){
		alert('아이디가 입력되지 않았습니다.');
		client_id.focus();
//		check = false;
	}
	else if(client_pw.value === ""){
		alert('비밀번호가 입력되지 않았습니다.');
//		check = false;
		client_pw.focus();
	}
	else if(client_pw.value !== client_pw2.value){
		alert('비밀번호 확인이 필요합니다.');
//		check = false;
		client_pw2.focus();
	}
	else if(name.value === ""){
		alert('이름이 입력되지 않았습니다.');
//		check = false;
		name.focus();
	}
	else if(phone.value === ""){
		alert('전화번호가 입력되지 않았습니다.');
//		check = false;
		phone.focus();
	}

//	if(check === false)
//		location.href = url;
	
	else if(confirm("회원가입 하시겠습니까?"))
		htmlForm.submit();
}

function checkLoginValues(htmlForm) {
	
	const client_id = document.getElementById("client_id");
	const client_pw = document.getElementById("client_pw");

	if(client_id.value === ""){
		alert('아이디가 입력되지 않았습니다.');
		client_id.focus();
	}
	
	else if(client_pw.value === ""){
		alert('비밀번호가 입력되지 않았습니다.');
		client_pw.focus();
	}
	else
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

function checkUpdate(htmlForm) {
	
	const client_id = document.getElementById("client_id");
	const client_pw = document.getElementById("client_pw");
	const client_pw2 = document.getElementById("client_pw2");
	const name = document.getElementById("name");
	const phone = document.getElementById("phone");
		
	if(client_id.value === ""){
		alert('아이디가 입력되지 않았습니다.');
		client_id.focus();
	}
	else if(client_pw.value === ""){
		alert('비밀번호가 입력되지 않았습니다.');
		client_pw.focus();
	}
	else if(client_pw.value !== client_pw2.value){
		alert('비밀번호 확인이 필요합니다.');
		client_pw2.focus();
	}
	else if(name.value === ""){
		alert('이름이 입력되지 않았습니다.');
		name.focus();
	}
	else if(phone.value === ""){
		alert('전화번호가 입력되지 않았습니다.');
		phone.focus();
	}
	else
		htmlForm.submit();
}