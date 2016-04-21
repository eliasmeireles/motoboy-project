<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ attribute name="scripts" required="false"%>
<%@ attribute name="styles" required="false"%>

<c:url var="contextPath" value="/" />
<c:url var="jsPath" value="/resources/js/" />
<c:url var="cssPath" value="/resources/css/" />

<!DOCTYPE html>
<html>
<head>

<title>Motoboy</title>

<script>
	var contextPath = "${contextPath}";
</script>

<meta charset="UTF-8">
<meta name="viewport" content="initial-scale=1">

<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>

<link href="${cssPath}reset.css" rel="stylesheet">
<link href="${cssPath}base.css"  rel="stylesheet">
<link href="${cssPath}tema.css" rel="stylesheet">
<link href="${cssPath}menu.css" rel="stylesheet">
<link href="${cssPath}bottom.css" rel="stylesheet">

<script type="text/javascript" src="${jsPath}jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="${jsPath}login.js"></script>
<script type="text/javascript" src="${jsPath}mask.js"></script>
<script type="text/javascript" src="${jsPath}jquery.mask.min.js"></script>
<link href="<c:url value="/resources/css/menu.css" />" rel="stylesheet">

<c:forEach items="${scripts}" var="js">
	<script type="text/javascript" src="${jsPath}${fn:trim(js)}"></script>
</c:forEach>

<c:forEach items="${styles}" var="css">
	<link rel="stylesheet" type="text/css" href="${cssPath}${fn:trim(css)}" />
</c:forEach>

</head>
<body>

	<div class="wrapper">
	
		<%@include file="/WEB-INF/views/menu.jsp"%>
		
		<main class="main">