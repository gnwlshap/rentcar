function update(htmlForm) {
	
	const client_id = document.getElementById("client_id");
	const client_pw = document.getElementById("client_pw");
	const client_pw2 = document.getElementById("client_pw2");
	const name = document.getElementById("name");
	const phone = document.getElementById("phone");
		
	if(client_id.value === ""){
		alert('아이디가 입력되지 않았습니다.');
	}
	else if(client_pw.value === ""){
		alert('비밀번호가 입력되지 않았습니다.');
		client_pw.setAttribute("autofocus","true");
	}
	else if(client_pw.value !== client_pw2.value){
		alert('비밀번호 확인이 필요합니다.');
	}
	else if(name.value === ""){
		alert('이름이 입력되지 않았습니다.');
	}
	else if(phone.value === ""){
		alert('전화번호가 입력되지 않았습니다.');
	}

	htmlForm.submit();
}