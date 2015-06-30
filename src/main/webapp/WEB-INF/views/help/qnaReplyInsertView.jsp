<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.js"></script>
<script>
	$(function(){
		//alert("${member.id}");
	});
</script>
<div class="col-md-12">
	<caption>
			<h2>Q&A</h2><br>
			Q&A 작성하기
			<hr><br>
		</caption>
	<form role="form" action="insertRefContent">
		<div class="form-group">
			<div class="input-group">
			<label for="Title">Title</label> 
			   <input type="text" class="form-control" name="title" value="RE:${insertReply.title }"><br>
			   <label for="pwd">Content</label>
				<textarea class="form-control custom-control" name="content" rows="10" cols="120" style="resize: none" placeholder="내용을 입력하세요"></textarea>
				<!--  <span class="input-group-btn">
        <button class="btn btn-primary">                            
            <span>Send</span>
        </button>
    </span> -->
			</div>
		</div>
		
		<div align="right">
		<input type="submit" class="btn btn-primary" value="등록">
		<input type="hidden" name="writer" value="${sessionScope.member.id }">
		 <input type="hidden" name="ref" value="${insertReply.ref }">
 <input type="hidden" name="restep" value="${insertReply.restep }">
 <input type="hidden" name="relevel" value="${insertReply.relevel }">
 <input type="hidden" name="no" value="${insertReply.articleNo }"> 
		</div>
	</form>
</div>