<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
<link rel="stylesheet"	href="public/css/style.css">

</head>
<body>

	<nav class="navbar navbar-expand-lg  navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Gestion de crypto money</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item">
				<c:choose>
					<c:when test="${menu==\"acceuil\"}">
						<a class="nav-link active"	aria-current="page" href="index.html">Accueil</a>
					</c:when>
					<c:otherwise>
						<a class="nav-link active"	aria-current="page" href="index.html">Accueil</a>
					</c:otherwise>
				</c:choose>
					</li>
					<li class="nav-item">
					<c:choose>
					<c:when test="${menu==\"mymoney\"}">
						<a class="nav-link active"	aria-current="page" href="index.html">Mon
							compte</a>
					</c:when>
					<c:otherwise>
						<a class="nav-link active"	aria-current="page" href="index.html">Mon
							compte</a>
					</c:otherwise>
					</c:choose>
					</li>
					<li class="nav-item"><c:choose>
					<c:when test="${menu==\"money\"}">
						<a class="nav-link active"	aria-current="page" href="money">Crypeto
							money</a>
					</c:when>
					<c:otherwise>
						<a class="nav-link active"	aria-current="page" href="money">Crypeto
							money</a>
					</c:otherwise>
					</c:choose>					
					</li>

				</ul>
			</div>
		</div>
	</nav>