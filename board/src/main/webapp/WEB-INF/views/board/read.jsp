<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../includes/header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Read</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>            
            <div class="row">
                <div class="col-lg-12">
                	<div class="panel panel-default">
                        <div class="panel-heading">
                           Board Read Page
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                			<form action="" role="form">
                				<div class="form-group">
                					<label>Bno</label>
                					<input class="form-control" name="bno" readonly="readonly" value="${dto.bno}">                				
                				</div> 
                				<div class="form-group">
                					<label>Title</label>
                					<input class="form-control" name="title" readonly="readonly" value="${dto.title}">                				
                				</div>  
                				<div class="form-group">
                					<label>Content</label>
                					<textarea class="form-control" rows="3" name="content" readonly="readonly">${dto.content}</textarea>               				
                				</div> 
                				<div class="form-group">
                					<label>Writer</label>
                					<input class="form-control" name="writer" readonly="readonly" value="${dto.writer}">                				
                				</div>  
                				<button type="button" class="btn btn-default">Modify</button>     			
                				<button type="reset" class="btn btn-info">List</button>          			
                			</form>
                		</div>
                	</div>
                </div>
            </div>
<%-- 파일 첨부 영역 --%>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading"><i class="fa fas fa-file"></i> 첨부파일</div>
			<div class="panel-body">
				<div class="uploadResult">
					<ul><!-- 첨부파일 정보 --></ul>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="bigPictureWrapper">
	<div class="bigPicture"></div>
</div>
<%-- 댓글 리스트 영역 --%>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i>
				Reply
				<button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">New Reply</button>
			</div>
			<div class="panel-body">
				<ul class="chat">
					<li class="left clearfix" data-rno="12">
						<div>
							<div class="header">
								<strong class="primary-font">user00</strong>
								<small class="pull-right text-muted">2022-05-04 15:54</small>
							</div>
							<!-- 댓글 내용 -->
							<p>Godd Job!!!!</p>
						</div>
					</li>
				</ul>
			</div>
			<%-- 댓글 페이지 영역 --%>
			<div class="panel-footer"></div>
		</div>	
	</div>
</div>

<%-- 댓글 작성 모달 폼 --%>
<div class="modal" tabindex="-1" id="replyModal" data-rno="1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <h5 class="modal-title">Reply</h5>
      </div>
      <div class="modal-body">
		<div class="form-group">
			<label for="">내용</label>
			<input type="text" name="reply" id=""  class="form-control" placeholder="댓글 내용"/>
		</div>
		<div class="form-group">
			<label for="">작성자</label>
			<input type="text" name="replyer" id=""  class="form-control" placeholder="작성자"/>
		</div>
		<div class="form-group">
			<label for="">작성일</label>
			<input type="text" name="replydate" id=""  class="form-control" placeholder="작성일"/>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-warning" id="modalRegisterBtn">등록</button>
        <button type="button" class="btn btn-success" id="modalModBtn">수정</button>
        <button type="button" class="btn btn-danger" id="modalRemoveBtn">삭제</button>
        <button type="button" class="btn btn-primary" id="modalCloseBtn" data-dismiss="modal">종료</button>
      </div>
    </div>
  </div>
</div>
<!-- modify 버튼 클릭 시 이동할 폼 -->
<form action="/board/modify" id="operForm">
	<input type="hidden" value="${dto.bno}" name="bno" />
	<input type="hidden" value="${cri.pageNum}" name="pageNum" />
	<input type="hidden" value="${cri.amount}" name="amount" />
	<input type="hidden" value="${cri.type}" name="type" />
	<input type="hidden" value="${cri.keyword}" name="keyword" />
</form>
<script>
	//현재 글 번호
	let bno = ${dto.bno};
</script>
<script src="/resources/js/read.js"></script>
<script src="/resources/js/reply.js"></script>
<script src="/resources/js/upload.js"></script>

<%@include file="../includes/footer.jsp" %>   













    