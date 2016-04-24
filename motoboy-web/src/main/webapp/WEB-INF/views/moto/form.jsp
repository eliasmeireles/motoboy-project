<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="import" tagdir="/WEB-INF/tags/import" %>
<%@ taglib prefix="html" tagdir="/WEB-INF/tags/html" %>


<c:url value="/" var="contextPath" />
		
<import:header styles="form-style.css, pages/cadastro.css"/>

	<div class="container">
			<h3 class="cadastro-title">Seja bem vindo ao nosso site</h3>
			
			
			<form:form action="${contextPath}motoboy/cadastrar" method="post" commandName="moto" class="register-form">
				<div class="input">
					<html:input label="Nome" name="nome" cssClass="form-box font-primary background-secondary_dark " />
				</div>
				<div class="input">
					<html:input label="Modelo" name="modelo" cssClass="form-box font-primary background-secondary_dark " />
				</div>
				<div class="midle-input">
					<div class="input midle-input_container">
						<html:input label="Cor" name="cor" cssClass="midle-form-box font-primary background-secondary_dark " />
					</div>
					<div class="input midle-input_container">
						<html:input label="Placa" name="placa" mask="aaa-0000" cssClass="midle-form-box font-primary background-secondary_dark " />
					</div>
				</div>
				
				<div class="btn">	
					<button type="submit" class="btn-submit background-secondary color-secondary_light font-primary-bold">Adicionar</button>
				</div>		
	
			</form:form>

	</div>

<import:footer />