<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<link rel="stylesheet" href="/resources/css/login.css" />
</head>
<%--
	커스텀 로그인 페이지 작성 규칙
	1) action="/login" 으로 작성
	2) userid를 입력받는 부분의 요소명은 username으로 반드시 지정(userid 이런거 말고)
	3) 비밀번호를 입력받는 부분의 요소명은 password으로 반드시 지정(pwd 이런거 하지 말고)
	4) post 방식으로 가는 폼은 CSRF 토큰 값을 반드시 포함해야 한다. 
 --%>
<body>
	<div class="container center-contents">
		<div class="row">
			<form action="/login" method="post" class="form-signin">
				<h1 class="h2 mb-3 font-weight-normal">로그인</h1>
				<label for="username" class="sr-only">로그인 아이디</label>
				<input type="text" id="username" name="username" class="form-control" placeholder="아이디를 입력해 주세요" required autofocus/>    
				<label for="password" class="sr-only">비밀번호</label>
				<input type="password" id="password" name="password" class="form-control" placeholder="비밀번호를 입력해 주세요" required/>    
				<div class="checkbox mb-3">
					<label>
						<input type="checkbox" name="remember-me"/>로그인 기억하기 <!-- 무조건 remember-me 로 해야됨 -->
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
				<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}"/>
				<div class="error-message">
					<span>${loginError}</span>
				</div>
			</form>
		</div>
	</div>
</body>
</html>













