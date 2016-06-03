<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="import" tagdir="/WEB-INF/tags/import"%>

<import:header styles="pages/home.css, pages/carousel.css"
	scripts="carousel.js, home.js" />

<div
	style="width: 100%; display: block; text-align: center; background: gray; padding-top: 3ch; padding-bottom: 3ch; font-size: 2em; color: #FFF;">
	<c:if test="${!empty sessionScope.connectedUser}">
		<span>${connectedUser.nome}</span> <span>${connectedUser.sobrenome}</span>
	</c:if>
	
	<c:if test="${empty sessionScope.connectedUser}">
		<span style="color: red;">Nada encontrado!</span>
	</c:if>
</div>

<import:footer />