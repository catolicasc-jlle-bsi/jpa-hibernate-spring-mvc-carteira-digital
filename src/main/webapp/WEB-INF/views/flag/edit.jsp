<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../header.jsp" />

<jsp:include page="../sidebar.jsp" />

<h1 class="page-header">Cadastro de Bandeira de Cartão</h1>
					
	<div class="panel panel-default">
		
		<div class="container">
			<div class="col-md-8" style="margin-top: 20px;">			
				<c:if test="${not empty param.errorMsg}">	
					<div class="alert alert-danger">${param.errorMsg}</div>
				</c:if>
				<form action="${pageContext.request.contextPath}/flag/save" class="form" method="post" role="form">
					
					<input value="${flag.id}" type="hidden" name="id" />
					
					<div class="row">
						<div class="form-group">
							<label> Nome: </label> <input type="text" class="form-control"
								id="description" name="description" placeholder="Exemplo: VISA"  value="${flag.description}" size="255" required>
						</div>
					</div>
										
					<div class="row">
						<div style="margin-bottom: 30px;">
							<input class="btn btn-primary" name="commit" type="submit"
								value="Salvar">
						</div>
					</div>
					
				</form>
			</div>
		</div>
	</div>
	
	
<jsp:include page="../footer.jsp" />