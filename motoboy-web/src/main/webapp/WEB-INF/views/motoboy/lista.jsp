<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<style>
		.table-container {
			width: 100%;
			border: 1px solid;
			font-size: 1em;
		}
		.table-title, .table-value {
			text-align: center;
			margin: 0;
			height: 50px;
			border: 1px solid;
			border-collapse: collapse;
		}
		button {
			height: 100%;
			width: 100%;
			font-size: 1em;
			background: transparent;
			cursor: pointer;
			border: none;
    		border-collapse: collapse;
		}
	
	</style>


</head>
<body>
	<%@include file="../menu.jsp" %>
	
	<main class="main">
		<table class="table-container">
			<thead>
				<tr class="table-titles">
					<th class="table-title">Nome</th>
					<th class="table-title">Contato</th>
					<th class="table-title">Data do cadastro</th>
					<th class="table-title">Solicitar serviço</th>
				</tr>
			</thead>
			<tbody class="table-body">
				<c:forEach items="${listaDeMotoboys}" var="motoboy">
					<tr class="table-values">
						<td class="table-value">${motoboy.nome} ${motoboy.sobrenome}</td>
						<td class="table-value">${motoboy.email}<br/><br/>${motoboy.celular}</td>
						<td class="table-value">
							<fmt:formatDate value="${motoboy.datacadastro}" pattern="dd/MM/yyyy" />
						</td>
						<td class="table-value solicitar"><button>Solicitar</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
	</main>
</body>
</html>