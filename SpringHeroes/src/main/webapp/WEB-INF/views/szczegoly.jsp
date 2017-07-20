<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href='<c:url value="/resources/style.css"/>'>
<title>Szczegóły bohatera</title>

<style>
@media (min-width: 768px) {
  .row.equal {
    display: flex;
    flex-wrap: wrap;
  }
}
    
/* add this for full height column content 
.equal > div[class*='col-'] {  
  display: flex;
  flex-direction: column;
}
*/

</style>
</head>
<body>
	
	
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-6">
			 
			<a href="lista.htm" class="btn btn-lg btn-block btn-detail" role="button">
				Powrót do listy bohaterów
			</a>
		</div>
		<div class="col-md-6">
			 	
			<a  href="admin/additem-${hero.id}.htm" role="button" class="btn btn-lg btn-block btn-detail">
				Dodaj przedmiot dla bohatera!
			</a>
		</div>
	</div>
	<div class="row equal">
		<div class="col-md-6">
			<h3 class="text-center">
				${hero.name}
			</h3><img alt="heroimg" src="data:image/jpeg;base64,${img}" class="img-circle center-block">
		</div>
		<div class="col-md-6 align-middle">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							#
						</th>
						<th>
							Atrybut
						</th>
						<th>
							Status
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							1
						</td>
						<td>
							Strength
						</td>
						<td>
							${hero.strength}
						</td>
					</tr>
					<tr class="active">
						<td>
							2
						</td>
						<td>
							Speed
						</td>
						<td>
							${hero.speed}
						</td>
					</tr>
					<tr class="success">
						<td>
							3
						</td>
						<td>
							Health
						</td>
						<td>
							${hero.health}
						</td>
						</tbody>
			</table>
		</div>
	</div>
	<div class="row">
		
			
			<div class="col-md-12">
					<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							#
						</th>
						<th>
							Name
						</th>
						<th>
							BodyPart
						</th>
						<th>
							Strength
						</th>
						<th>
							Speed
						</th>
						<th>
							Health
						</th>
						<th>
							Action
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${hero.items}" varStatus="status" var="item">
					<tr>
						<td>
							${status.index}
						</td>
						<td>
							${item.name}
						</td>
						<td>
							${item.bodyPart}
						</td>
						<td>
							${item.strength}
						</td>
						<td>
							${item.speed}
						</td>
						<td>
							${item.health}
						</td>
						<td>
						<a href="admin/deleteitem-${item.id}.htm" class="btn-primary btn-lg btn-block" role="button">
							Usuń
						</a>
						</td>
					</tr>
					</c:forEach>
					</tbody>
			</table>
					
						
					
			</div>
			
		
	</div>
</div>	
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>	
</body>
</html>