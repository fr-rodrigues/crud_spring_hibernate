<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cliente</title>
</head>
<body>
	<h1>DADOS DO CLIENTE</h1>
	<br />
	
	<form:form action="cliente.do" method="POST" commandName="cliente">
		<table>
			<tr>
				<td>ID</td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td>Nome</td>
				<td><form:input path="nome" /></td>
			</tr>
			<tr>
				<td>Rg</td>
				<td><form:input path="rg" /></td>
			</tr>
			<tr>
				<td>Cpf</td>
				<td><form:input path="cpf" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
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
			<th>Id</th>
			<th>Nome</th>
			<th>Rg</th>
			<th>Cpf</th>
		</tr>
		<c:forEach items="${clientes}" var="c">
			<tr>
				<td>${c.id}</td>
				<td>${c.nome}</td>
				<td>${c.rg}</td>
				<td>${c.cpf}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>