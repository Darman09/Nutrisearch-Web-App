<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Evaluation - MongoDb</title>
<%@include file="/JSP/header.jsp"%>
</head>
<body>
	<form method="post" action="listFavoris" id="formHome">
		<nav>
			<%@include file="/JSP/menu.jsp"%>
		</nav>
		<div class="col s12 ">
				<table>
					<thead>
						<tr>
							<th>Nom</th>
							<th>Nutriscore</th>
							<th>Quantité</th>							
						</tr>
					</thead>
					<tbody id="bodyTable">
						<c:forEach var="element" items="${favorisList}">
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
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
	</form>
	<!--JavaScript at end of body for optimized loading-->
	<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>