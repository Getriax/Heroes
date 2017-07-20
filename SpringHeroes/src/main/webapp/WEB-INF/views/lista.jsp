<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href='<c:url value="/resources/style.css"/>'>
        <title>WebJars Demo</title>   
</head>
<body class="all">
	<div class="container"><br/>
            <div class="row">
	             
	             <a	class="btn btn-primary btn-lg col-md-12 col-sm-12 col-xs-12" href='admin/bdodaj.htm' role="button"> Dodaj bohatera </a>
			    
            </div>
            <div class="row">
            <c:forEach items="${heroes}" var="hero" varStatus="status">
            	<a class="col-md-6 col-md-offset-3 btn btn-blank btn-lg active" href='<c:url value="hero-${status.index + 1}.htm"/>' role="button">${hero.getShort()}</a> <br/>
			</c:forEach>
            </div>
            <div class="row hei">
            </div>
			
     </div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	
</body>
</html>