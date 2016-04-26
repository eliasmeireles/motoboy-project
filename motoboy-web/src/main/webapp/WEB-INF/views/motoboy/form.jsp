<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="import" tagdir="/WEB-INF/tags/import"%>
<%@ taglib prefix="html" tagdir="/WEB-INF/tags/html"%>


<c:url value="/" var="contextPath" />

<import:header styles="form-style.css, pages/cadastro.css" />

<div class="container">
	<h3 class="cadastro-title">Seja bem vindo ao nosso site</h3>
	<form:form action="${contextPath}motoboy/cadastrar" method="post"
		enctype="multipart/form-data" commandName="motoboy"
		cssClass="register-form">
		<import:form />
	</form:form>
</div>


<import:footer />