<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../header.jsp" />

<jsp:include page="../sidebar.jsp" />

<h1 class="page-header">Cartão</h1>
					
	<div class="panel panel-default">
		
		<div class="container">
			<div class="col-md-8" style="margin-top: 20px;">			
				<c:if test="${not empty param.errorMsg}">	
					<div class="alert alert-danger">${param.errorMsg}</div>
				</c:if>
				<form action="${pageContext.request.contextPath}/card/save" class="form" method="post" role="form">
					
					<input value="${card.id}" type="hidden" name="id" />
					
					<div class="row">
						<div class="form-group">
							<label> Nome: </label> <input type="text" class="form-control"
								id="name" name="name" placeholder="Exemplo: VISA Crédito"  value="${card.name}" size="255" required>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group">
							<label for="bank">Banco</label>
							<select id="idBank" name="idBank" required class="form-control">
						        <c:forEach var="bank" items="${banks}">
						            <option value="${bank.id}" ${bank.id == card.bank.id ? 'selected="selected"' : ''}>${bank.description}</option>
						        </c:forEach>
						    </select>
				        </div>
					</div>
					
					<div class="row">
						<div class="form-group">
							<label for="flag">Bandeira do Cartão</label>
							<select id="idFlag" name="idFlag" required class="form-control">
						        <c:forEach var="flag" items="${flags}">
						            <option value="${flag.id}" ${flag.id == card.flag.id ? 'selected="selected"' : ''}>${flag.description}</option>
						        </c:forEach>
						    </select>
				        </div>
					</div>
								
								
					<div class="row">
						<div class="form-group">
							<label> Nome do titular (como está impresso): </label> <input
								type="text" class="form-control" id="cardName" name="cardName"
								placeholder="Exemplo: JOAO C M SILVA" value="${card.cardName}" size="255" required>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label> Número: </label> <input type="text" class="form-control"
								id="cardNumber" name="cardNumber"  value="${card.cardNumber}" size="255" required>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label> Vencimento: </label> <select class="form-control"
								id="dateValidatedMounth" name="dateValidatedMounth">
								<option value="01">Janeiro</option>
								<option value="02">Fevereiro</option>
								<option value="03">Março</option>
								<option value="04">Abril</option>
								<option value="05">Maio</option>
								<option value="06">Junho</option>
								<option value="07">Julho</option>
								<option value="08">Agosto</option>
								<option value="09">Setembro</option>
								<option value="10">Outubro</option>
								<option value="11">Novembro</option>
								<option value="12">Dezembro</option>
							</select>
							<div class="form-group">
								<select class="form-control" id="dateValidatedYear">
									<option value="2014">2014</option>
									<option value="2015">2015</option>
									<option value="2016">2016</option>
									<option value="2017">2017</option>
									<option value="2018">2018</option>
									<option value="2019">2019</option>
									<option value="2020">2020</option>
									<option value="2021">2021</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label> Código de Verificação: </label> 
							<input type="text" class="form-control" id="verifyCode" name="verifyCode" value="${card.verifyCode}" size="3" required>
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