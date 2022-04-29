/**
 * read.jsp 스크립트
 */
$(function(){
	
	//openForm 가져오기
	let openForm = $("#openForm");	
	
	//list 버튼 클릭 시 /board/list 보여주기
	$(".btn-info").click(function(){
		location.href = "/board/list";
	})
	
	//modify 버튼 클릭 시
	$(".btn-default").click(function(){
		openForm.submit();
	})
	
})