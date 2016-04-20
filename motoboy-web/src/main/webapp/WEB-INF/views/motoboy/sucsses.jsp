<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../menu.jsp" %>

	<div class="informe-cadastro">
		<h2>Bem vindo ao Fast Motoboy</h2>
		
		<span>Ola ${user.nome } ${user.sobrenome}</span>
		<p> O seu cadastro foi efetúado com susesso!</p>
	</div>
	
	
</body>
</html>