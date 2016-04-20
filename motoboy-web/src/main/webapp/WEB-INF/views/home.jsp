<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fast Motoboy</title>
<style>
	form {
		display: block;
		width: 20%;
		margin: 10% auto;
	}
	::-webkit-input-placeholder {
    	color: #7C7C7C;
	}
	.input {
		height: 35px;
		width: 100%;
		border-radius: 5px;
		margin: 0 auto;
		margin-bottom: 15px; 
		font-weight: bold;
	    overflow: hidden;
	}
	.input input {
	    display: block;
    	width: 100%;
		background: #B5B5B5;
		font-size: 1em;
    	border: none;
    	padding-left: 2ch;
    	outline: 0;
    	height: 100%;
	}
	.botao {
		width: 50%;
		margin: 0 auto;
	}
	
	.half-input {
		width: 100%;
		display: flex;
	}
	.half-input .input:not(:last-of-type) {
	margin-right: 2%;
	}
	button {
		width: 100%;
		display: block;
		font-weight: bold;
		border-radius: 5px;
		padding: 0.7em;
		outline: 0;
		font-size: 1.2em;
	    background: #B5B5B5;
	    color: #7C7C7C;
	    cursor: pointer;
    	border: none;
	}
	h1 {
		text-align: center;
	}
</style>
</head>
<body>
	<%@include file="menu.jsp" %>
	<h1>Fast Motoboy</h1>
	<div>
		<form action="logar" method="POST">
	
		
		<div class="input">
			<input type="text" name="email" placeholder="Email">
		</div>
		<div class="input">
			<input type="password" class="password" name="senha" placeholder="Senha">
		</div>
		
		<div class="botao">
			<button type="submit">Entrar</button>
		</div>	
	</form>
	</div>
</body>
</html>