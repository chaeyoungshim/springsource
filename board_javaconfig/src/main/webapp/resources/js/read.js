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
	
	//첨부파일 --------------------------------------------------------------------------------------------
	
	//첨부파일 가져오기 - 무조건 실행
	$.getJSON({
		url:'getAttachList',
		data:{
			bno:bno
		},
		success:function(data){
			console.log(data);
			showUploadFile(data);
		}
	})
	
	
	function showUploadFile(result) {
		//업로드 결과 영역 가져오기
		let uploadResult = $(".uploadResult ul");
		
		let str = "";
		
		$(result).each(function(idx,obj){ //idx는 인덱스(지금은 필요없음)
		
			if(obj.fileType) {
	            //썸네일 이미지 보여주기
	            //썸네일 이미지 경로
	            let fileCallPath = encodeURIComponent(obj.uploadPath+"\\s_"+obj.uuid+"_"+obj.fileName);
				
				//원본 파일 이미지 경로
				let oriPath = obj.uploadPath+"\\"+obj.uuid+"_"+obj.fileName;		
				oriPath = oriPath.replace(new RegExp(/\\/g),"/");
				
	            //fileCallPath : 파라미터로 넘기는 방식, 인코딩 된 방식
	            str += "<li data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.fileType+"'>";
				str += "<a href=\"javascript:showImage(\'"+oriPath+"\')\">";
				str += "<img src='/display?fileName="+fileCallPath+"'></a>";
				str += "<div>"+obj.fileName;
				str += "</div></li>";
	        }else { //txt 파일

				//다운로드 경로
				let fileCallPath = encodeURIComponent(obj.uploadPath+"\\"+obj.uuid+"_"+obj.fileName);
				
	            str += "<li data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.fileType+"'>";
				str += "<a href='/download?fileName="+fileCallPath+"'>";
				str += "<img src='/resources/img/attach.png'></a>";
				str += "<div>"+obj.fileName;
				str += "</div></li>";
       	 	}
		
		});
		
		console.log("업로드 파일 경로");
		console.log(str);
		
		uploadResult.append(str);
	}//showUploadFile 종료
	
})

















