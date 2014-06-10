<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../header.jsp" />

<jsp:include page="../sidebar.jsp" />

<h1 class="page-header">Cadastro de Cartão</h1>

<div class="panel panel-default">

	<div class="panel-heading">
		<a class="btn btn-primary btn-sm"
			href="${pageContext.request.contextPath}/card/new">Novo Cartão</a>
	</div>

	<!-- Table -->
	<table class="table">
		<thead>
			<tr>
				<th>#ID</th>
				<th>Nome</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="card" items="${cards}">
				<tr>
					<td>${card.id}</td>
					<td>${card.name}</td>
					<td><a class="btn btn-danger btn-sm"
						href="${pageContext.request.contextPath}/card/read?id=${card.id}">Editar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>


<jsp:include page="../footer.jsp" />