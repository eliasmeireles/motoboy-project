<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../menu.jsp" %>
	<div class="informe-cadastro">
		<c:if test="${user.nome != null}">
			<h2>Bem vindo ao Fast Motoboy</h2>
			<span>Ola ${user.nome } ${user.sobrenome}</span>
			<p> O seu cadastro foi efetúado com susesso!</p>
		</c:if>
		<c:if test="${user.nome == null}">
		</c:if>
	</div>
	
</body>
</html>