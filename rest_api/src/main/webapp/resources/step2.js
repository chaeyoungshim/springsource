/**
 * 
 */
$(function(){
	//입력버튼 클릭 시 폼에 있는 데이터를 비동기식으로 전달
	$(".btn-primary").click(function(e){ 
		//전송 기능 막기
		e.preventDefault(); 
		
		let param = {
			  userid:$("#userid").val(),
			  password:$("#password").val(),
			  name:$("#name").val(),
			  gender:$("[type=radio]:checked").val(),
			  email:$("#email").val()
		}
		
		//ajax 통신
		$.ajax({
			url:'new',
			type:'post',
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