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
	    padding: 2ch;
	    background: gray;
	    text-align: center;
	    color: white;
	    font-size: 1.6em;
	    top: 0;
	}
</style>
</head>
<body>
	<div class="user-data">
	 	<span>${user.nome}</span>
	  	<span>${user.sobrenome}</span>
	  	<span>${user.id}</span>
	</div>
</body>
</html>