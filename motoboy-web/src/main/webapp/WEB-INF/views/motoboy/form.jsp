<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<%@ taglib prefix="import" tagdir="/WEB-INF/tags/import" %>
<%@ taglib prefix="html" tagdir="/WEB-INF/tags/html" %>


<c:url value="/" var="contextPath" />
		
<import:header styles="form-style.css, pages/cadastro.css"/>

	<div class="container">
		<h3 class="cadastro-title">Seja bem vindo ao nosso site</h3>
		<form:form action="${contextPath}motoboy/cadastrar" method="post" commandName="motoboy" class="register-form">
			<div class="input">
			<html:input label="Nome" name="motoboy.nome" cssClass="form-box font-primary background-secondary_dark " />
			</div>
			<div class="input">
				<html:input label="Sobrenome" name="motoboy.sobrenome" cssClass="form-box font-primary background-secondary_dark " />
			</div>
			<div class="input">
				<html:input label="Email" name="motoboy.email" cssClass="form-box font-primary background-secondary_dark " />
			</div>
			<div class="midle-input">
				<div class="input midle-input_container">
					<html:input label="Cpf" name="motoboy.cpf" mask="000.000.000.00" cssClass="midle-form-box font-primary background-secondary_dark " />
				</div>
				<div class="input midle-input_container">
					<html:input label="Celular" name="motoboy.celular" mask="(00)00000-0000" cssClass="midle-form-box font-primary background-secondary_dark " />
				</div>
			</div>
		
			<div class="midle-input">
				<div class="input midle-input_container">
					<html:password label="Senha" name="motoboy.senha" cssClass="midle-form-box  font-primary background-secondary_dark " />
				</div>
				<div class="input midle-input_container">
					<input type="password" placeholder="A senha novamente" class="midle-form-box font-primary background-secondary_dark ">
				</div>
			</div>
			
			<div class="btn">	
				<button type="submit" class="btn-submit background-primary color-secondary_light font-primary-bold">Cadastrar</button>
			</div>
		</form:form>
	</div>

	
<import:footer />