/**
 * 
 */
$(function(){
	//입력버튼 클릭 시 폼에 있는 데이터를 비동기식으로 전달
	$(".btn-primary").click(function(e){ 
		//전송 기능 막기
		e.preventDefault(); 
		
		let param = {
			  userid:"hong123",
			  confirm_password:$("#confirm_password").val()
		}
		
		//ajax 통신
		$.ajax({
			url:'hong123',
			type:'put',
			contentType:'application/json',
			data:JSON.stringify(param),
			success:function(data){
				alert(data);
			},
			error:function(xhr,status,error){
				alert(xhr.responseText); //메세지 띄우기
			}
		})
		
		
	})
	
	
	
})