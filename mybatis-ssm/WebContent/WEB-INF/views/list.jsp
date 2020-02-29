<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<td>ID</td>
			<td>LastName</td>
			<td>Email</td>
			<td>Gender</td>
		</tr>
	
		<c:forEach items="${emps }" var="e">
		
			<tr>
				<td>${e.id }</td>
				<td>${e.lastName }</td>
				<td>${e.email }</td>
				<td>${e.gender }</td>
			</tr>
			
		</c:forEach>
	
	</table>

</body>
</html>