<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>
<%@ include file="../include/message.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글조회</title>
<script type="text/javascript">
	//document가 로딩 완료된후 함수 실행
	$(function() {
		//조회버튼 클릭
		$('#btnSearch').on('click', function(){
			var findKey = $('#findKey').val();
			var findValue = $('#findValue').val();
			console.log(findKey);
			console.log(findValue);
			$(location).attr('href',
					'${path}/board/list?findKey='+findKey+'&findValue='+findValue);
		});
		//추가 버튼 클릭
		$('#btnAdd').on('click', function() {
			$(location).attr('href','${path}/board/add');
		});
		//제목을 클릭
		$('.aSubject').on('click', function(e) {
			e.preventDefault(); //기본기능  소멸
			var bnum = $(this).attr('href');
			console.log(bnum);
			$(location).attr('href', '${path}/board/detail?bnum='+bnum);
		});
		
		//페이지를 클릭
		$('.aPage').on('click', function(e) {
			e.preventDefault(); //기본기능  소멸
			var curPage = $(this).attr('href');
			var findKey = $('#findKey').val();
			var findValue = $('#findValue').val();
			
			console.log(curPage);
			$(location).attr('href','${path}/board/list?curPage='+curPage+'&findKey='+findKey+'&findValue='+findValue);
		});
		
		//로그아웃 클릭
		$('#btnSessionDelete').on('click', function() {
			var result = confirm('로그아웃 하시겠습니까?');
			
			if(result){
				$(location).attr('href','${path}/board/sessionDelete');	
			}
			
		});
		
		//마이페이지 클릭
		$('#btnMypage').on('click', function() {
			var userid = $('#userid').val();
			$(location).attr('href','${path}/member/modify?userid='+userid);	
		});
	});

</script>
</head>
<body>
	<h2>게시글 조회</h2>
	${sessionScope.userid} 님 반갑습니다.
	<input id="userid" type="hidden" value="${sessionScope.userid}">
	<hr>
	<div>
		<select id ="findKey">
			<option value="writer" <c:out value="${pdto.findKey=='writer'?'selected':''}" />>작성자</option>
			<option value="subject" <c:out value="${pdto.findKey=='subject'?'selected':''}" />>제목</option>
			<option value="content" <c:out value="${pdto.findKey=='content'?'selected':''}" />>내용</option>
			<option value="subcon" <c:out value="${pdto.findKey=='subcon'?'selected':''}" />>제목+내용</option>
		</select>
		<input type="text" id="findValue" value="${pdto.findValue}">
		<input id="btnSearch" type="button" value="조회">
		<input id="btnAdd" type="button" value="글 작성">
		<input id="btnMypage" type="button" value="마이페이지">
		<input id="btnSessionDelete" type="button" value="로그아웃">

	</div>
	<!-- 리스트 출력 -->
	<div>
		<table border="1">
			<tr>
				<th>순번</th>
				<th>작성자</th>
				<th>이메일</th>
				<th>제목</th>
				<th>조회수</th>
				<th>댓글수</th>
			</tr>
		
			<c:forEach var="board" items="${blist}">
				<tr>
					<td>${board.bnum}</td>
					<td>${board.writer}</td>
					<td>${board.email}</td>
					<td><a class="aSubject" href="${board.bnum}" >${board.subject}</a></td>
					<td>${board.readcnt}</td>
					<td>${board.replycnt}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<!-- 페이징 처리 -->
	${pdto}
	<div>
		<c:if test="${pdto.startPage!=1}">
			<a class ="aPage" href="${pdto.startPage-1}">이전</a>
		</c:if> 
		<c:forEach var="i" begin="${pdto.startPage}" end="${pdto.endPage}">
			<a class ="aPage" href="${i}"> ${i}</a>
		</c:forEach>
		<c:if test="${pdto.endPage < pdto.totPage}">
			<a class ="aPage" href="${pdto.endPage+1}">다음</a>
		</c:if>
		
	</div>
	
</body>
</html>