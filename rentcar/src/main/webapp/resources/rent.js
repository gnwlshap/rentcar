function submitTime(htmlForm) {
	
	htmlForm.submit();
}

function rent(htmlForm, vehicle_id) {
	
	htmlForm.vehicle_id.value = vehicle_id;
		if(confirm("렌트 ㄱㄱ"))
		htmlForm.submit();
}