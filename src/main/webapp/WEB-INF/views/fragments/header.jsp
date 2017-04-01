<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<nav class="navbar navbar-default">
	<div class="container-fluid">

		<div class="navbar-header">
			<a class="navbar-brand" href="#">Fesztiválok</a>
		</div>

		<ul class="nav navbar-nav">

			<li><a href="#">Kezdőlap</a></li>

			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown" role="button" aria-expanded="false">Fesztiválok
					<span class="caret"></span>
			</a>

				<ul class="dropdown-menu" role="menu">
					<li><a href="<spring:url value="/project/add"/>">Hozzáad</a></li>
					<li><a href="<spring:url value="/project/find"/>">Listázás</a></li>
				</ul></li>

			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown" role="button" aria-expanded="false">Fellépők
					<span class="caret"></span>
			</a>

				<ul class="dropdown-menu" role="menu">
					<li><a href="<spring:url value="/artists/add"/>">Hozzáad</a></li>
					<li><a href="<spring:url value="/artists"/>">Listázás</a></li>
				</ul></li>

		</ul>

	</div>
</nav>