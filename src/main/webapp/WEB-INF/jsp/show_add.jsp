<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Add</title>
</head>
<body>
	<script language="javascript">
		function addRole(){
			document.forms[0].action = '${pageContext.request.contextPath}/ballet/addRole';
			document.forms[0].submit();
		}
	</script>
	<form:form method="post" action="${pageContext.request.contextPath}/ballet/save" modelAttribute="showDto">
		<input type="button" value="Back" 
			onclick="javascript:location.href='${pageContext.request.contextPath}/ballet/show';">&nbsp;
		<input type="submit" value="Save"><br><br>	
		<table>
			<tr>
				<td>Show Id</td>
				<td>:&nbsp;<form:input path="sid"/><form:errors path="sid"/></td>
			</tr>
			<tr>
				<td>Title</td>
				<td>:&nbsp;<form:input path="title"/><form:errors path="title"/></td>
			</tr>
			<tr>
				<td>Choreo</td>
				<td>:&nbsp;<form:input path="choreo"/><form:errors path="choreo"/></td>
			</tr>
			<tr>
				<td>Composer</td>
				<td>:&nbsp;<form:input path="composer"/><form:errors path="composer"/></td>
			</tr>
			<tr>
				<td>Year</td>
				<td>:&nbsp;<form:input path="year"/><form:errors path="year"/></td>
			</tr>
		</table>
		<br>
		<br>
		Roles :<br>
		<input type="button" value="Add Role" onclick="javascript:addRole();">&nbsp;<form:errors path="roleDtos"/>
		<br><br>
		<table border="1">
			<tr>
				<td><b>Dancer Name</b></td>
				<td><b>Role</b></td>
				<td><b>Company Name</b></td>
				<td><b>Action</b></td>
			</tr>
			<c:forEach var="r" items="${showDto.roleDtos}" varStatus="loop">
				<tr>
					<td><form:input path="roleDtos[${loop.index}].name" value="${r.name}" readonly="true"/></td>
					<td><form:input path="roleDtos[${loop.index}].role" value="${r.role}" readonly="true"/></td>
					<td><form:input path="roleDtos[${loop.index}].cname" value="${r.cname}" readonly="true"/></td>
					<td>
						<form:hidden path="roleDtos[${loop.index}].did" value="${r.did}" readonly="true"/>
						<a href="${pageContext.request.contextPath}/ballet/deleteRole/${loop.index}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
</body>
</html>