/**
 * list.jsp 스크립트
 */
$(function(){
	//regBtn 클릭 시  /board/register 로 움직이기
	$("#regBtn").click(function(){
		location.href = "/board/register"; //단순 이동이니까 주소만 걸어주기
	})
	
	
	//게시물 등록 시 모달 창 띄우기
	checkModal(result);
	
	history.replaceState({}, null, null);
	
	function checkModal(result) {
		if(result == '' || history.state) { //history.state : 히스토리 제일 상단에 있는거 가져오기
			return;
		}
		
		if(parseInt(result) > 0) {
			$(".modal-body").html("게시물"+result+"번이 등록되었습니다.");
		}
		
		$("#myModal").modal("show"); //'hide' => 모달 감추고 싶을 땐
	}//checkModal 종료
	
	
	
	//페이지 이동 버튼 클릭
	let actionForm = $("#actionForm");
	
	$(".paginate_button a").click(function(e){
		e.preventDefault(); //a 속성 중지
		
		//bno 가 있는 경우 제거
		actionForm.find("[name='bno']").remove();
		
		//action 수정
		actionForm.attr("action","/board/list");
		
		//사용자가 선택한 페이지 번호 가져오기
		let pageNum = $(this).attr("href");
		//가져온 번호를 actionForm 안의 pageNum 값으로 대체
		actionForm.find("[name='pageNum']").val(pageNum);
		
		//actionForm 보내기
		actionForm.submit();
		
	})//paginate_button 종료
	
	//페이지 목록 개수가 클릭
	$(".form-control").change(function(){
		//actionForm 안의 amount 값을 변경하기
		actionForm.find("[name='amount']").val($(this).val());
		//actionForm 보내기n
		actionForm.submit();
	})
	
	
	//타이틀 클릭시
	$(".move").click(function(e){
		e.preventDefault(); //a 태그 기능 막기
		
		//a가 가지고 있는 href 가지고 오기
		let href = $(this).attr("href"); //move 가 가지고 있는 a태그니까 this 사용
		
		//actionForm 안에 bno 태그를 추가하기(bno 값은 href가 가지고 있는 값으로)
		//내용 보기에 들어갔을 때 사용자가 리스트 버튼이 아닌 뒤로 가기 버튼을 눌러서
		//목록으로 돌아올 때 bno가 계속 추가되는 것 방지
		if(actionForm.find("[name='bno']").length!=0) {
			actionForm.find("[name='bno']").val(href);
		}else {
			actionForm.append("<input type='hidden' name='bno' value='"+href+"'>")
		}

		//actionForm action 변경(/board/read)
		actionForm.attr("action","/board/read");
		
		//actionForm 보내기
		actionForm.submit();
	})
	
	
	
	//검색 버튼 클릭시
	$(".btn-default").click(function(e){
		//submit 기능 중지
		e.preventDefault();
		
		let searchForm = $("#searchForm");
		
		//type 아무것도 선택이 되지 않으면 경고 메세지 주기
		if(searchForm.find("select[name='type']").val() == ''){
			alert("검색 기준을 선택해 주세요");
			return false; 
		}
		
		//keyword 값이 없으면 경고 메세지 주기
		if(searchForm.find("input[name='keyword']").val() == ''){
			alert("검색어를 입력해 주세요");
			return false;
		}
		
		//검색 폼 안에 pageNum 은 1로 변경
		searchForm.find("input[name='pageNum']").val("1"); //첫 번째 페이지 보여줘야 하니까 1로 초기화해주기
		
		//검색 폼 전송
		searchForm.submit();
		
	})
	
	
	
	
})























