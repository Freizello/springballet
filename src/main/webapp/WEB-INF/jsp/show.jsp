<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show</title>
</head>
<body>
	<input type="button" value="Add" onClick="location.href='${pageContext.request.contextPath}/ballet/add';">&nbsp;
	<br><br>
	<table border="1">
		<tr>
			<td><b>Show id</b></td>
			<td><b>Title</b></td>
			<td><b>Choreo</b></td>
			<td><b>Composer</b></td>
			<td><b>Year</b></td>
			<td><b>Action</b></td>
		</tr>
		<c:forEach items="${dto}" var="show">
		<tr>
			<td>${show.sid}</td>
			<td>${show.title}</td>
			<td>${show.choreo}</td>
			<td>${show.composer}</td>
			<td>${show.year}</td>
			<td>
				<a href="${pageContext.request.contextPath}/ballet/${show.sid}">Edit</a>&nbsp;
				<a href="${pageContext.request.contextPath}/ballet/delete/${show.sid}" onClick="return confirm('Are you sure to delete : ${show.title}?');">Delete</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>