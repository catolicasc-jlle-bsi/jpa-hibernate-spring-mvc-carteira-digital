<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../header.jsp" />

<jsp:include page="../sidebar.jsp" />

<h1 class="page-header">Cadastro de Bancos</h1>

<div class="panel panel-default">

	<div class="panel-heading">
		<a class="btn btn-primary btn-sm"
			href="${pageContext.request.contextPath}/bank/new">Novo Banco</a>
	</div>

	<!-- Table -->
	<table class="table">
		<thead>
			<tr>
				<th>#ID</th>
				<th>Código (Fenaban)</th>
				<th>Nome</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="bank" items="${banks}">
				<tr>
					<td>${bank.id}</td>
					<td>${bank.code}</td>
					<td>${bank.description}</td>
					<td><a class="btn btn-danger btn-sm"
						href="${pageContext.request.contextPath}/bank/read?id=${bank.id}">Editar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>


<jsp:include page="../footer.jsp" />