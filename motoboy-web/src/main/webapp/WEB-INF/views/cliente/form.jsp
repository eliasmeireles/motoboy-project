<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="import" tagdir="/WEB-INF/tags/import" %>
<%@ taglib prefix="html" tagdir="/WEB-INF/tags/html" %>


<c:url value="/" var="contextPath" />
		
<import:header />

	<div class="container">
	
		<form:form action="${contextPath}cliente/cadastrar" method="post" commandName="cliente" cssClass="register-form">
			<div class="input">
			<html:input label="Nome" name="nome" cssClass="form-box font-primary background-secondary_dark " />
			</div>
			<div class="input">
				<html:input label="Sobrenome" name="sobrenome" cssClass="form-box font-primary background-secondary_dark " />
			</div>
			<div class="input">
				<html:input label="Email" name="email" cssClass="form-box font-primary background-secondary_dark " />
			</div>
			<div class="midle-input">
				<div class="input midle-input_container">
					<html:input label="Cpf" name="cpf" mask="000.000.000-00" cssClass="midle-form-box font-primary background-secondary_dark " />
				</div>
				<div class="input midle-input_container">
					<html:input label="Celular" name="celular" mask="(00)00000-0000" cssClass="midle-form-box font-primary background-secondary_dark " />
				</div>
			</div>
		
			<div class="midle-input">
				<div class="input midle-input_container">
					<html:password label="Senha" name="senha" cssClass="midle-form-box  font-primary background-secondary_dark " />
				</div>
				<div class="input midle-input_container">
					<input type="password" name="senhaVerificador" placeholder="A senha novamente" class="midle-form-box font-primary background-secondary_dark ">
				</div>
			</div>
			
			<div class="btn">	
				<button type="submit" class="btn-submit background-primary color-secondary_light font-primary-bold">Cadastrar</button>
			</div>
		</form:form>
	</div>

	
<import:footer />