function submitTime(htmlForm) {
	
	htmlForm.submit();
}

function rent(htmlForm, vehicle_id, vehicle_name) {
	
	const pickup_time = document.getElementById('pickup_time').value;
	const return_time = document.getElementById('return_time').value;
	const venue_name = document.getElementById('venue_name').value;
	
	htmlForm.vehicle_id.value = vehicle_id;
	
	if(confirm(`픽업 일자 : ${pickup_time}\n반납 일자 : ${return_time}\n차종 : ${vehicle_name}\n지점 : ${venue_name}`))
		htmlForm.submit();
}