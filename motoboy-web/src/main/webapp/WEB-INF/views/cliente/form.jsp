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
			<import:form />
		</form:form>
	</div>

	
<import:footer />