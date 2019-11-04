<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Evaluation - MongoDb</title>
<%@include file="/JSP/header.jsp"%>
</head>
<body>
	<form method="post" action="oneElement" id="formHome">
		<nav>
			<%@include file="/JSP/menu.jsp"%>
		</nav>
		<div class="row">
			<div class="col s12">
				<h1>${element.getNomProduit()}</h1>
			</div>
			<div class="col s6">
				<h4>
					<c:choose>
						<c:when test="${getNutritionGrade eq a}">
							Grade :
				            <span class="green-text text-darken-4">${element.getNutritionGrade()}</span>
						</c:when>
						<c:when test="${getNutritionGrade eq b}">
							Grade :
				            <span class="green-text">${element.getNutritionGrade()}</span>
						</c:when>
						<c:when test="${getNutritionGrade eq c}">
							Grade :
				            <span class="green-yellow">${element.getNutritionGrade()}</span>
						</c:when>
						<c:when test="${getNutritionGrade eq d}">
							Grade :
				            <span class="green-orange">${element.getNutritionGrade()}</span>
						</c:when>
						<c:when test="${getNutritionGrade eq e}">
							Grade :
				            <span class="green-deep-orange">${element.getNutritionGrade()}</span>
						</c:when>
						<c:otherwise>
							Grade :
				            <span>${element.getNutritionGrade()}</span>
						</c:otherwise>
					</c:choose>
				</h4>
			</div>
			<div class="col s6">
				<h4>Emballage : ${element.getPackaging()}</h4>
			</div>
			<div class="col s6">
				<h4>Quantité : ${element.getQuantity()}</h4>
			</div>
			<div class="col s6">
				<h4>Categorie : ${element.getCategorie()}</h4>
			</div>
			<div class="col s6">
				<h4>Pays d'Origine : ${element.getPaysOrigine()}</h4>
			</div>
			<div class="col s6">
				<h4>Pays de vente : ${element.getPaysVente()}</h4>
			</div>
			<div class="col s12">
				<h4>Description: </h4>
				<h4>${element.getIngredientDescription()}</h4>
			</div>
		</div>
	</form>
	<!--JavaScript at end of body for optimized loading-->
	<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>