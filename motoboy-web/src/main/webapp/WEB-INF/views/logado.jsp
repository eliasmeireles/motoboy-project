<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.user-data {
		position: absolute;
	    right: 0;
	    left: 0;
	    width: 340px;
	    margin: 0 auto;
	    padding: 2ch;
	    background: gray;
	    text-align: center;
	    color: white;
	    font-size: 1em;
	    border-radius: 10px;
	    top: 102px;
	    font-family: 'Roboto Condensed', 'Arial', 'sans-serif';
		font-weight: bold;
		color: black;
	}
</style>
</head>
<body>
	<%@include file="menu.jsp" %>
	<div class="user-data">
	 	<span>${user.nome}</span>
	  	<span>${user.sobrenome}</span>
	</div>
</body>
</html>