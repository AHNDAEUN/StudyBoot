<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List Page</h1>
	
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="vo">
				<tr>
					<td>${vo.num}</td>
					<td>${vo.title}</td>
					<td>${vo.contents}</td>
					<td>${vo.writer}</td>
					<td>${vo.hit}</td>
					<td>${vo.regDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>
	
	<form action="./list" method="get">
		<input name="search" value="${param.search}" type="text">
	</form>
	
	<!-- 페이지 -->
<%--     <div class="pagediv mt-3" style="display: flex; justify-content: center; ">
        <nav aria-label="Page navigation example">
            <ul class="pagination paginate_sm">

                <c:if test="${pager.pre}">
                    <li class="page-item"><a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">pre</a></li>
                </c:if>
                <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
                    <li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
                </c:forEach>
                <li class="page-item ${pager.next?'':'disabled'}"><a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">next</a></li>
            </ul>
        </nav>
    </div> --%>
		
	
</body>
</html>