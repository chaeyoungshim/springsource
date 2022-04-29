/**
 * insert.jsp 유효성
 */
$(function(){
	//입력 버튼 클릭 시 
	$(".btn-primary").click(function(e) {
		//submit 기능 중지
		e.preventDefault(); 
		//code,price 입력값은 아니고 입력 요소만 가져옴
		let code = $("#code");
		let price = $("#price");
		
		//사용자 입력값 가져온 후 숫자가 맞다면 form submit 시키기
		//숫자가 아니라면 메세지 띄우고 되돌아가기
		if(!/^[0-9]{4}$/.test(code.val())) {
			alert('코드를 확인해 주세요');
			code.select(); //코드 요소 안에 있는 값을 블록으로 선택
			return;
		}
		
		if(!/^[0-9]+$/.test(price.val())) {
			alert('가격을 확인해 주세요');
			price.select(); //코드 요소 안에 있는 값을 블록으로 선택
			return;
		}
		//입력이 올바로 되었다면 form submit 시키기
		$("form").submit();
	})
	
})