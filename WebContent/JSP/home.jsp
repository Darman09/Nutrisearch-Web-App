<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Evaluation - MongoDb</title>
<%@include file="/JSP/header.jsp"%>
</head>
<body>
	<form method="post" action="home" id="formHome">
		<nav>
			<%@include file="/JSP/menu.jsp"%>
		</nav>
		<div class="row">
			<div class="col s12">
				<h1>Liste des produits Nutriscore</h1>
			</div>
			<div class="col s12">
				<h5>Recherche Complexe</h5>
			</div>
			<div class="col s6 input-field">
				<select class="browser-default" id="searchCat" name="grade">
					<option value="" disabled selected>Choisissez votre grade</option>
					<option onclick="$('#button').val('filter');$('#grade').val('A');">A</option>
					<option onclick="$('#button').val('filter');$('#grade').val('B');">B</option>
					<option onclick="$('#button').val('filter');$('#grade').val('C');">C</option>
					<option onclick="$('#button').val('filter');$('#grade').val('D');">D</option>
					<option onclick="$('#button').val('filter');$('#grade').val('E');">E</option>
				</select>
			</div>
			<div class="col s12 input-field">
				<a class="waves-effect waves-light btn"
					onclick="$('#formHome').submit();"><i
					class="material-icons right">search</i>Rechercher</a>
			</div>
			<div class="col s12">
				<hr class="grey-text text-lighten-2">
			</div>
			<div class="col s12">
				<h5>Recherche Rapide</h5>
			</div>
			<div class="col s6 input-field">
				<label for="searchProduct">Rechercher un produit</label> <input
					type="text" id="searchProduct">
			</div>
			<div class="col s12 ">
				<table>
					<thead>
						<tr>
							<th>Nom</th>
							<th>Nutriscore</th>
							<th>Quantité</th>
							<th>Consulter</th>
							<th>Supprimer</th>
						</tr>
					</thead>
					<tbody id="bodyTable">
						<c:forEach var="element" items="${result}">
							<tr class="rowElement">
								<td class="nameElement">${element.getNomProduit()}</td>
								<td class="gradeElement"><c:choose>
										<c:when
											test="${element.getNutritionGrade() eq fn:toUpperCase(a)}">
											<span class="green-text text-darken-4">${fn:toUpperCase(element.getNutritionGrade())}</span>
										</c:when>
										<c:when
											test="${element.getNutritionGrade() eq fn:toUpperCase(b)}">
											<span class="green-text">${fn:toUpperCase(element.getNutritionGrade())}</span>
										</c:when>
										<c:when
											test="${element.getNutritionGrade() eq fn:toUpperCase(c)}">
											<span class="green-yellow">${fn:toUpperCase(element.getNutritionGrade())}</span>
										</c:when>
										<c:when
											test="${element.getNutritionGrade() eq fn:toUpperCase(d)}">
											<span class="green-orange">${fn:toUpperCase(element.getNutritionGrade())}</span>
										</c:when>
										<c:when
											test="${element.getNutritionGrade() eq fn:toUpperCase(e)}">
											<span class="green-deep-orange">${fn:toUpperCase(element.getNutritionGrade())}</span>
										</c:when>
										<c:otherwise>
											<span>${fn:toUpperCase(element.getNutritionGrade())}</span>
										</c:otherwise>
									</c:choose></td>
								<td>${element.getQuantity()}</td>
								<td><a
									class="tiny btn-floating waves-effect waves-light dark-purple"><i
										class="tiny material-icons"
										onclick="$('#button').val('oneElement');$('#nutriId').val('${element.getId()}');$('#formHome').submit();">search</i></a></td>
								<td><a class="btn-floating waves-effect waves-light red"
									onclick="$('#nutriId').val('${element.getId()}');$('#nameToDelete').empty();$('#nameToDelete').append('${element.getNomProduit()}');"
									href="#delete"><i class="material-icons">close</i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</form>
	<!--JavaScript at end of body for optimized loading-->
	<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>