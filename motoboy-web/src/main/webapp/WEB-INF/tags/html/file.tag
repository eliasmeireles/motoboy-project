<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="html" tagdir="/WEB-INF/tags/html"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ attribute name="name" required="false"%>
<%@ attribute name="label" required="true"%>
<%@ attribute name="cssErrorClass" required="false"%>

<form:label path="${name}" cssClass="label">${label}</form:label>
	<form:radiobuttons path="${name}" cssClass="file" />
