function checkLoggedIn() {
	alert("로그인시 사용 가능합니다.")
	
}

function checkPost(htmlForm){
	
	const title = document.getElementById("title");
	const content = document.getElementById("content");

	if(title.value === ""){
		alert('제목을 입력하세요');
		title.focus();
	}
	else if(content.value === ""){
		alert('내용을 입력하세요');
		content.focus();
	}
	else if(confirm("등록하시겠습니까?"))
			htmlForm.submit();
}

function editPost(htmlForm) {
	
	const title = document.getElementById("title");
	const content = document.getElementById("content");

	if(title.value === ""){
		alert('제목을 입력하세요');
		title.focus();
	}
	else if(content.value === ""){
		alert('내용을 입력하세요');
		content.focus();
	}
	
	else if(confirm("수정하시겠습니까?"))
		htmlForm.submit();
}

function deletePost(htmlForm) {
	if(confirm("삭제하시겠습니까?"))
		htmlForm.submit();
}
