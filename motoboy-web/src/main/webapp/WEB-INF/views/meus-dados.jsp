<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="import" tagdir="/WEB-INF/tags/import"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
<%@ taglib prefix="import" tagdir="/WEB-INF/tags/import" %>
		
<import:header styles="pages/home.css, pages/carousel.css"
	scripts="carousel.js, home.js" />

	<c:if test="${!empty sessionScope.connectedUser}">
		<div style="padding-top: 30px; width: 250px; margin:0 auto;">
			<img style="width: 100px; height: 100px; border-radius: 10px;" class="foto-perfil" alt="img" src="${contextPath}${connectedUser.fotoPerfil}">
			<p>${connectedUser.nome}</p><br>
			<p>${connectedUser.sobrenome}</p><br>
			<p>${connectedUser.email}</p><br>
			<p>${connectedUser.cpf}</p><br>
			<p>${connectedUser.celular}</p><br>
			
			<p><fmt:formatDate value="${connectedUser.datacadastro}" pattern="dd/MM/yyyy" /></p>
		</div>
	</c:if>

<import:footer />