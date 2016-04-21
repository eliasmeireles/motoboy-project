<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="html" tagdir="/WEB-INF/tags/html"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ attribute name="maskPlaceHolder" required="false"%>
<%@ attribute name="name" required="true"%>
<%@ attribute name="label" required="true"%>
<%@ attribute name="cssClass" required="false"%>
<%@ attribute name="cssErrorClass" required="false"%>

<form:password path="${name}" placeholder="${label}" data-mask="${mask}" cssClass="${cssClass}" />
<html:validation name="${name}" cssClass="${cssErrorClass}" />
