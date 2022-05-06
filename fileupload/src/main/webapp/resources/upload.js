/**
 * uploadform_ajax 스크립트 
 */
$(function(){
	$("#uploadBtn").click(function(){
		console.log("ajax 파일 업로드 호출");
		
		//폼 객체 생성
		let formData = new FormData();
		//첨부파일 목록 가져오기
		let inputFile = $("[name='uploadFile']");
		console.log(inputFile);
		
		let files = inputFile[0].files;
		
		//폼 객체에 첨부파일들 추가
		for(let i=0;i<files.length;i++) {
			formData.append("uploadFile",files[i]);
		}
		
		//enctype="multipart/form-data" 와 같은 의미
		
		//processData:false => 데이터를 일반적인 쿼리 스트링 형태로 변환할 것인지 결정
		//						기본값은 true(application/x-www-form-urlencoded)
		//contentType:false => 기본값은 true()
		
		
		//폼 객체 ajax 전송
		$.ajax({
			url:'uploadAjax',
			type:"post",
			processData:false,
			contentType:false,
			data:formData,
			dataType:'json',
			success:function(result){
				//console.log(result);
				showUploadFile(result);
			}
		})
		
	})//uploadBtn 종료
	
	function showUploadFile(result) {
		//업로드 결과 영역 가져오기
		let uploadResult = $(".uploadResult ul");
		
		let str = "";
		
		$(result).each(function(idx,obj){ //idx는 인덱스(지금은 필요없음)
		
			if(obj.fileType){ //여기가 true면 이미지 파일인 경우(이미지 추가하기)
				str += "<li>"+obj.fileName+"</li>";
			}else { //false면 txt 파일인 경우
				str += "<li><img src='/resources/img/attach.png'><div>"+obj.fileName+"</div></li>";
			}
		
		})
		
		uploadResult.html(str);
	}//showUploadFile 종료
	
})











