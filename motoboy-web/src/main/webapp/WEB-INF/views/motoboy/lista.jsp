<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
<%@ taglib prefix="import" tagdir="/WEB-INF/tags/import" %>
<%@ taglib prefix="html" tagdir="/WEB-INF/tags/html" %>


<c:url value="/" var="contextPath" />
		
<import:header styles="pages/lista-motoboy.css" />

		<h3 class="lista-title">Lista de motoboy cadastrados</h3>

		<table class="table-container">
			<thead>
				<tr class="table-titles">
					<th class="table-title">Imagem</th>
					<th class="table-title">Nome</th>
					<th class="table-title">Email</th>
					<th class="table-title">Celular</th>
					<th class="table-title">Data do cadastro</th>
					<th class="table-title">Solicitar serviço</th>
				</tr>
			</thead>
			<tbody class="table-body">
				<c:forEach items="${listaDeMotoboys}" var="motoboy">
					<tr class="table-values">
						<c:if test="${motoboy.fotoPerfil != null && motoboy.fotoPerfil != '' }">
							<td class="table-value"><img class="foto-perfil" alt="img" src="${contextPath}${motoboy.fotoPerfil}"></td>
						</c:if>
						<c:if test="${motoboy.fotoPerfil == null || motoboy.fotoPerfil == '' }">
							<td class="table-value"><img class="foto-perfil" alt="img" src="${contextPath}resources/img/sem-foto.jpg"></td>
						</c:if>
						<td class="table-value">${motoboy.nome} ${motoboy.sobrenome}</td>
						<td class="table-value">${motoboy.email}</td>
						<td class="table-value">${motoboy.celular}</td>
						<td class="table-value">
							<fmt:formatDate value="${motoboy.datacadastro}" pattern="dd/MM/yyyy" />
						</td>
						<td class="table-value solicitar"><button>Solicitar</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
<import:footer />