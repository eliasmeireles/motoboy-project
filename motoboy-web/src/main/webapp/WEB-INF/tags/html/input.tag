<%@ tag language="java" pageEncoding="UTF-8"%>

<%@	taglib prefix="html" tagdir="/WEB-INF/tags/html"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<%@ attribute name="name" required="true"%>
<%@ attribute name="label" required="true"%>
<%@ attribute name="mask" required="false"%>
<%@ attribute name="maskPlaceHolder" required="false"%>
<%@ attribute name="cssClass" required="false"%>
<%@ attribute name="cssErrorClass" required="false"%>

<form:input path="${name}" placeholder="${label}" data-mask="${mask}" cssClass="${cssClass}" />
<html:validation name="${name}" cssClass="${cssErrorClass}" />