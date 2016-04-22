<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="importPath" tagdir="/WEB-INF/tags/import" %>
		
<importPath:header  />
		
<style>
	form {
		display: block;
		width: 35%;
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
</style>


	<form action="${contextPath }moto/cadastrar" method="POST">
	
		<div class="input">
			<input type="email" name="email" placeholder="Email do motoboy">
		</div>
		
		<div class="input">
			<input type="text" name="nome" placeholder="Nome da moto">
		</div>
		
		<div class="input">
			<input type="text" name="modelo" placeholder="Modelo">
		</div>
		
		<div class="half-input">
			<div class="input">
				<input type="text" name="cor" placeholder="Cor">
			</div>
			<div class="input">
				<input type="text" name="placa" placeholder="Placa">
			</div>
		</div>
			
		<div class="botao">
			<button type="submit">Cadastrar</button>
		</div>	
	</form>
<importPath:footer />