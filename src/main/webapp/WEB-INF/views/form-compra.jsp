<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Compra</title>
</head>
<body>
	<h1>DADOS DA COMPRA</h1>
	<br />
	
	<form:form action="compra.do" method="post" commandName="compra">
		<table>
			<tr>
				<td>ID</td>
				<td><form:input path="id"/></td>
			</tr>
			<tr>
				<td>Cliente</td>
				<td>
					<form:select path="cliente.id">
						<form:options items="${clientes}" itemLabel="nome" itemValue="id"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Produto</td>
				<td>
					<form:select path="produto.id">
						<form:options items="${produtos}" itemLabel="descricao" itemValue="id"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Data</td>
				<td><form:input path="data" /></td>
			</tr>
			<tr>
				<td>Hora</td>
				<td><form:input path="hora" /></td>
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
	<table>
		<tr>
			<th>ID</th>
			<th>Cliente</th>
			<th>Produto</th>
			<th>Data</th>
			<th>Hora</th>
		</tr>
		<c:forEach items="${compras}" var="c">
			<tr>
				<td>${c.id}</td>
				<td>${c.cliente.nome}</td>
				<td>${c.produto.descricao}</td>
				<td>${c.data}</td>
				<td>${c.hora}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>