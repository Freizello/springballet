<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Role Detail</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/ballet/saveRole" modelAttribute="roleDto"  method="POST">
		<input type="button" value="Back" 
			onclick="javascript:location.href='${pageContext.request.contextPath}/ballet/add';">
		<input type="submit" value="Save"><br><br>
		<table>
			<tr>
				<td>Dancer</td>
				<td>
					:&nbsp;
					<form:select path="did">
						<c:forEach var="d" items="${listDancer}">
							<option value="${d.did}" <c:if test="${roleDto.did == d.did}">selected</c:if>>${d.name}</option>
						</c:forEach>		
					</form:select>			
				</td>
			</tr>
			<tr>
				<td>Role</td>
				<td>:&nbsp;
					<form:input path="role"/><form:errors path="role"/>
				</td>
			</tr>
			<tr>
				<td>Company Name</td>
				<td>
					:&nbsp;
					<form:select path="cname">
						<c:forEach var="c" items="${listCompany}">
							<option value="${c.cname}" <c:if test="${roleDto.cname == c.cname}">selected</c:if>>${c.cname}</option>
						</c:forEach>		
					</form:select>			
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>