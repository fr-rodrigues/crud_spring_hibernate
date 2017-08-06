<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fornecedor</title>
</head>
<body>
	<h1>DADOS DO FORNECEDOR</h1>
	<br />
	
	<form:form action="fornecedor.do" method="post" commandName="fornecedor">
		<table>
			<tr>
				<td>ID</td>
				<td><form:input path="id"/></td>
			</tr>
			<tr>
				<td>Descricao</td>
				<td><form:input path="descricao"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="action" value="Add">
					<input type="submit" name="action" value="Edit">
					<input type="submit" name="action" value="Search">
					<input type="submit" name="action" value="Delete">					
				</td>
			</tr>
		</table>
	</form:form>
	
	<br /><br />
	
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Descricao</th>
		</tr>
		<c:forEach items="${fornecedores}" var="f">
			<tr>
				<td>${f.id}</td>
				<td>${f.descricao}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>