<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../header.jsp" />

<jsp:include page="../sidebar.jsp" />

<h1 class="page-header">Cadastro de Bandeira de Cartão</h1>

<div class="panel panel-default">

	<div class="panel-heading">
		<a class="btn btn-primary btn-sm"
			href="${pageContext.request.contextPath}/flag/new">Nova Bandeira</a>
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
			<c:forEach var="flag" items="${flags}">
				<tr>
					<td>${flag.id}</td>
					<td>${flag.description}</td>
					<td><a class="btn btn-danger btn-sm"
						href="${pageContext.request.contextPath}/flag/read?id=${flag.id}">Editar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>


<jsp:include page="../footer.jsp" />