<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>

</head>
<body>

<div class="container-fluid">
<div class="row col-8"> 
<form action="add" method="GET">

	<h1>List Page</h1>
	
	<div>
	<table class="table  table-hover">
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
   <h6><a href="../trade/detail?num=${item.itemNum}" class="item-name">${item.itemTitle}</a></h6>
		
			<c:forEach items="${list}" var="vo">
				<tr>
					<td>${vo.num}</td>
					<td> ${vo.title}</td>
					<td>${vo.contents}</td>
					<td>${vo.writer}</td>
					<td>${vo.hit}</td>
					<td>${vo.regDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>
	</div>
	
	</form>
	</div>
	</div>
	
	<div>
	<a href="./add"class="btn btn-secondary">write</a>
	</div>
		
		<script type="text/javascript">
			let result ='${result}';
			if(result !=""){
			   if (result == '1'){
				   alert('등록되었습니다.');
			   }else{
				   alert('등록이 실패되었습니다.');
			   }
			}
		</script>
	
</body>
</html>