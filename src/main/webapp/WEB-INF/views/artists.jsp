<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fellépők</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<spring:url value="/resources/css/home.css"/>" type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>

	<jsp:include page="../views/fragments/header.jsp"></jsp:include>

	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Fellépők</h1>
				<p>Az összes rögzített fellépő.</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<c:forEach items="${artists}" var="a">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${a.name}</h3>
							<p>${a.description}</p>
							<strong>Stílus : </strong>
							<c:forEach items="${a.musicStyleList}" var="s">
								<span class="label label-warning">${s.style} </span>
							</c:forEach>
							<p>
								<a href=" <spring:url value=  "/artists/artist?id=${a.id}" /> "
									class="btn btn-primary"><span
									class="glyphicon-info-sign glyphicon" /></span> Részletek</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>

</body>
</html>