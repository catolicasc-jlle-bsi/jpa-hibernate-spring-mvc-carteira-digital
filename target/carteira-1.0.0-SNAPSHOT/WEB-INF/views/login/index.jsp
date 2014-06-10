<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

<jsp:include page="../header.jsp" />

<jsp:include page="../sidebar.jsp" />

	<div class="container">
		<div class="signing-form" style="margin-top: 60px;">
			<c:if test="${not empty error}">
				<div class="alert alert-danger">Ocorreu um erro no seu acesso, tente novamente.<br /> Causa: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</div>			
			</c:if>
			<c:if test="${not empty param.succMsg}">
				<div class="alert alert-success">${param.succMsg}</div>
			</c:if>
			<c:if test="${not empty errorMsg}">
				<div class="alert alert-danger">${errorMsg}</div>
			</c:if>
			
			<form class="form-signin" role="form" action="<c:url value='j_spring_security_check' />" method='POST'>
				<h2 class="form-signin-heading"></h2>
				<input type="email" class="form-control" id="username" name="j_username" placeholder="E-mail" type="text" required autofocus>
				<input class="form-control" id="password" name="j_password" placeholder="Senha" type="password" required>
				<input class="btn btn-primary form-control" name="commit" type="submit" value="Entrar">
			</form>
		</div>
	</div>

<jsp:include page="../footer.jsp" />