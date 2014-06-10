<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

<jsp:include page="../header.jsp" />

	<style>
		body {
			padding-top: 40px;
			padding-bottom: 40px;
			background-color: #eee;
		}
		
		.form-signup {
			max-width: 330px;
			padding: 15px;
			margin: 0 auto;
		}
		
		.form-signup .form-signup-heading,.form-signup .checkbox {
			margin-bottom: 10px;
		}
		
		.form-signup .checkbox {
			font-weight: normal;
		}
		
		.form-signup .form-control {
			position: relative;
			height: auto;
			-webkit-box-sizing: border-box;
			-moz-box-sizing: border-box;
			box-sizing: border-box;
			padding: 10px;
			font-size: 16px;
		}
		
		.form-signup .form-control:focus {
			z-index: 2;
		}
		
		.form-signup input[type="email"] {
			margin-bottom: -1px;
			border-bottom-right-radius: 0;
			border-bottom-left-radius: 0;
		}
		
		.form-signup input[type="password"] {
			margin-bottom: 10px;
			border-top-left-radius: 0;
			border-top-right-radius: 0;
		}
	</style>
	
	<style type="text/css">
	 * { font-family: Verdana; font-size: 96%; }
		label { width: 10em; float: left; }
		label.error { float: none; color: red; vertical-align: bottom;
	       padding:20px 0px 10px 0px; display:inline}
		p { clear: both; }
		.submit { margin-left: 12em; }
		em { font-weight: bold; padding-right: 1em; vertical-align: top; } 
	</style>
	
	<script>
		$(document).ready(function(){
			$("#signupForm").validate({
			   rules: {
			     name: "required",
			     password: "required",
			     email: {
			       required: true,
			       email: true
			     }
			   },
			   messages: {
			     name: "Por favor informe seu nome",
			     password: "Por favor informe sua senha",
			     email: {
			       required: "Por favor informe seu e-mail",
			       email: "Seu e-mail não é valido"
			     }
			   }
			});
		});
	</script>

	<div class="container">
		<div style="margin-top: 60px;">			
			<c:if test="${not empty param.errorMsg}">	
				<div class="alert alert-danger">${param.errorMsg}</div>
			</c:if>
			<form action="${pageContext.request.contextPath}/login/novo" class="form-signup" method="post" id="signupForm" role="form">				
				<div class="form-group">
					<label for="name">Nome</label>
					<input type="text" class="form-control" id="name" placeholder="Escreva seu nome aqui" name="name" required="required" size="30">
				</div>
				<div class="form-group">
					<label for="email">E-mail</label>
					<input type="email" class="form-control" id="email" placeholder="Escreva seu e-mail aqui" size="30" name="email" type="email" required="required">
				</div>
				<div class="form-group">
					<label for="password">Senha</label>
					<input class="form-control" id="password" name="password" placeholder="Escreva uma senha aqui" size="30" type="password" required="required">
				</div>
		
				<div>
					<input class="btn btn-primary form-control" name="commit" type="submit" value="Cadastre-se">
				</div>
			</form>
		</div>
	</div>

<jsp:include page="../sidebar.jsp" />