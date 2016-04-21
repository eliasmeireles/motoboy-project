<%@ tag language="java" pageEncoding="UTF-8"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ attribute name="name" required="true"%>
<%@ attribute name="cssClass" required="false"%>

<span class="error">
	<form:errors path="${name}" cssClass="${cssErrorClass}" />
</span>