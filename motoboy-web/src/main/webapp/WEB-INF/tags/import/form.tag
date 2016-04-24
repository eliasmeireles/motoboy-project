<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="import" tagdir="/WEB-INF/tags/import" %>
<%@ taglib prefix="html" tagdir="/WEB-INF/tags/html" %>

	
		<div class="input">
			<html:input label="Nome" name="cliente.nome" cssClass="form-box font-primary background-secondary_dark " />
			</div>
			<div class="input">
				<html:input label="Sobrenome" name="cliente.sobrenome" cssClass="form-box font-primary background-secondary_dark " />
			</div>
			<div class="input">
				<html:input label="Email" name="cliente.email" cssClass="form-box font-primary background-secondary_dark " />
			</div>
			<div class="midle-input">
				<div class="input midle-input_container">
					<html:input label="Cpf" name="cliente.cpf" mask="000.000.000.00" cssClass="midle-form-box font-primary background-secondary_dark " />
				</div>
				<div class="input midle-input_container">
					<html:input label="Celular" name="cliente.celular" mask="(00)00000-0000" cssClass="midle-form-box font-primary background-secondary_dark " />
				</div>
			</div>
		
			<div class="midle-input">
				<div class="input midle-input_container">
					<html:password label="Senha" name="cliente.senha" cssClass="midle-form-box  font-primary background-secondary_dark " />
				</div>
				<div class="input midle-input_container">
					<input type="password" placeholder="A senha novamente" class="midle-form-box font-primary background-secondary_dark ">
				</div>
			</div>
			
			<div class="btn">	
				<button type="submit" class="btn-submit background-primary color-secondary_light font-primary-bold">Cadastrar</button>
			</div>
	
