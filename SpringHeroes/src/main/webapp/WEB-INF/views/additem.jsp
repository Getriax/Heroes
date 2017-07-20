<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dodaj przedmiot</title>
</head>
<body>
	<a href="/heroes/lista.htm"> Powrót do listy </a>
	<form:form method="POST" modelAttribute="item">
		<form:input type="text" placeholder="Nazwa" path="name" /><c:if test="${pageContext.request.method=='POST'}"><form:errors path="name" /></c:if> <br/>
		<form:input type="text" placeholder="BodyPart" path="bodyPart" /><c:if test="${pageContext.request.method=='POST'}"><form:errors path="bodyPart" /></c:if> <br/>		
		<form:input type="text" placeholder="Siła" path="strength"/><c:if test="${pageContext.request.method=='POST'}"><form:errors path="strength"></form:errors></c:if><br/>
		<form:input type="text" placeholder="Speed" path="speed"/><c:if test="${pageContext.request.method=='POST'}"><form:errors path="speed"></form:errors></c:if> <br/>
		<form:input type="text" placeholder="Health" path="health"/><c:if test="${ pageContext.request.method=='POST'}"><form:errors path="health"></form:errors></c:if> <br/>
		<input type="submit" value="Dodaj!"/> <br/>
	</form:form>
</body>
</html>