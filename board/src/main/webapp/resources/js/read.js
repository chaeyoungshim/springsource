/**
 * read.jsp 스크립트
 */
$(function(){
	
	//openForm 가져오기
	let operForm = $("#operForm");	
	
	//list 버튼 클릭 시 /board/list 보여주기
	$(".btn-info").click(function(){
		// operForm bno 태그 제거하기
		operForm.find("input[name='bno']").remove(); //name이 bno인거 찾아서 제거하기
		
		//operForm action 수정
		operForm.attr("action","/board/list"); //이동경로 바꿔주기
		
		//operForm 보내기(전송시켜주기)
		operForm.submit();
	})
	
	//modify 버튼 클릭 시
	$(".btn-default").click(function(){
		operForm.submit();
	})
	
	//첨부파일 가져오기 - 무조건 실행
	$.getJSON({
		url:'getAttachList',
		data:{
			bno:bno
		},
		success:function(data){
			console.log(data);
		}
	})
	
	
	
})