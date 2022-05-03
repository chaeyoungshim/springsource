<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h3>도서정보</h3>
		<button type="button" id="all" class="btn btn-secondary">도서 목록</button>
		<button type="button" id="get" class="btn btn-primary">특정 도서정보</button>
		<button type="button" id="delete" class="btn btn-danger">도서정보 삭제</button>
		<button type="button" id="update" class="btn btn-success">도서정보 수정</button>
	
		<div id="result">
			<table class="table">
				
			</table>
		</div>
		
		<div>
			<form method="post">
				<div>
					<label>코드</label>
					<input type="text" name="code" id="code" />
				</div>
				<div>
					<label>제목</label>
					<input type="text" name="title" id="title" />
				</div>
				<div>
					<label>저자</label>
					<input type="text" name="writer" id="writer" />
				</div>
				<div>
					<label>가격</label>
					<input type="text" name="price" id="price" />
				</div>
				<div>
					<button type="button" id="insert">입력</button>
				</div>
			</form>
		</div>
		
	</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>
$(function() {
	$("#all").click(function(){ //get 이 클릭이 되면 json 가져오기, 전체 목록 가지고 오기
		//ajax 방식으로 데이터 요청 
		/* $.ajax({ 
			url:'',
			method:'get',
			data:{
				
			},
			dataType:'json',
			success:function(){
				//서버의 응답코드가(HTTP 상태코드) 200 일 때(성공)
			}
		}) */
		
		//가져올 데이터가 json 이라면
		$.getJSON({ //get 방식 - 좀 더 단순하게 쓸 수 있음
			url:'list', // /list가 아닌 이유 : 현재 http://localhost:9090/book/index에서 버튼을 누르면 http://localhost:9090/book/list로 가야 하기 때문에 그냥 list로 해줘야함, 뒤에 index에서 list로만 바꿔주니까
			success:function(data){
				console.log(data);
				
				//본문 table 영역 변경하기
				let result = $("#result table");
				let str = "";
				$.each(data ,function(idx, item){ //data를 가지고 함수를 실행 => 반복문 돌릴 것, idx:인덱스, item:객체의 키값
					str += "<br><tr>";
					str += "<td>"+item.code + "</td>";
					str += "<td>"+item.title + "</td>";
					str += "<td>"+item.writer + "</td>";
					str += "<td>"+item.price + "</td>";
					str += "</tr>";
				})
				result.html(str); //브라우저에 내용 넣기 => jquery 는 .html(내용);
			}
		})
	})//all 종료
	
	// /book/1000 + GET  => 1000번 도서에 대한 정보 가져오기
	$("#get").click(function(){ //도서 정보 하나만 가지고 올 것
		$.getJSON({ //json으로 받을 것
			url:'1000',
			success:function(data){
				//본문 table 영역 변경하기
				let result = $("#result table");
				let str = "";
				//하나만 뽑을거기 때문에
				str += "<br><tr>";
				str += "<td>"+data.code + "</td>";
				str += "<td>"+data.title + "</td>";
				str += "<td>"+data.writer + "</td>";
				str += "<td>"+data.price + "</td>";
				str += "</tr>";
				
				result.html(str);
			}
		})
	})//get 종료
	
	$("#delete").click(function(){
		$.ajax({
			url:'3009',
			type:'delete', //@DeleteMapping() 과 연결
			success:function(data){
				alert(data);
			},
			error:function(xhr,status,error){
				alert(xhr.responseText);
			}
		})
	})//delete 종료
	
	$("#update").click(function(){
		
		let param = {
				price:100000
		};
		
		// application/x-www-form-urlencoded;charset=UTF-8' not supported => default 값
		// JSON.stringify : 자바스크립트 객체를 json 형태로 변환
		
		$.ajax({
			url:'1001',
			type:'put',
			contentType:'application/json',
			data:JSON.stringify(param), //이거 json이 아님, 자바스크립트 객체임
			success:function(data){
				alert(data);
			},
			error:function(xhr,status,error){
				alert(xhr.responseText);
			}
		})
	})//update 종료
	
	$("#insert").click(function(){
		let param = {
				code:$("#code").val(),
				title:$("#title").val(),
				writer:$("#writer").val(),
				price:$("#price").val()
		};
		
		//데이터를 json 형태로 넘길 때
		/* $.ajax({
			url:'new',
			type:'post',
			contentType:'application/json',
			data:JSON.stringify(param),
			success:function(data){
				alert(data);
			},
			error:function(xhr,status,error){
				alert(xhr.responseText);
			}
		}) */
		
		
		//데이터를 json 형태로 넘길 때
		$.ajax({
			url:'new2',
			type:'post',
			data:$("form").serialize(),
			success:function(data){
				alert(data);
			},
			error:function(xhr,status,error){
				alert(xhr.responseText);
			}
		})
	})
	
	
})
</script>
</body>
</html>

















