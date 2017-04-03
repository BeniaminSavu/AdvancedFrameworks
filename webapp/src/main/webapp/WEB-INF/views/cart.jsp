<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Cart</title>
</head>
<body>
	<div class="container">
		<div class="header">
			<ul class="nav nav-pills pull-right">
				<li><a href="<spring:url value="/welcome"/>"><spring:message code= "label.home"/></a></li>
				<li><a href="<spring:url value="/courses/"/>"><spring:message code= "label.courses"/></a></li>
				<li><a href="<spring:url value="/courses/add"/>"><spring:message code= "label.addCourse"/></a></li>
				<li><a href="<spring:url value="/cart/"/>"><spring:message code= "label.cart"/></a></li>
			</ul>
			<h3 class="text-muted">iQuest</h3> 
		</div>
		<div class="jumbotron">
			<c:url value="/j_spring_security_logout" var="logoutUrl"/>
			<a href="${logoutUrl}" class="btn btndangerbtn-mini pull-right">Log out</a>
			<div class="pull-right" style="padding-right:50px">
				<a href="?locale=en" >EN</a>|<a href="?locale=ro" >RO</a>
			</div>
			<h1><spring:message code= "label.cart"/></h1>
		</div>
	<section class="container">
	<h1>${CheckoutMessage}</h1>
		<div>
			<div>
				<a href="<spring:url value="/cart/clear" />"class="btn btn-danger pull-left"> <span
					class="glyphicon glyphicon-remove-sign"></span> <spring:message code= "label.cart.clear"/>
				</a> <a href="<spring:url value="/cart/checkout" />" class="btn btn-success pull-right"> <span
					class="glyphicon-shopping-cart glyphicon"></span> <spring:message code= "label.cart.checkout"/>
				</a>
			</div>
			<table class="table table-hover">
				<tr>
					<th><spring:message code= "label.cart.course"/></th>
					<th><spring:message code= "label.cart.price"/></th>
					<th><spring:message code= "label.cart.action"/></th>
				</tr>
				<c:forEach items="${cart.courses}" var="course">
					<tr>
						<td>${course.name}</td>
						<td>${course.price}</td>
						<td><a href="<spring:url value="/cart/remove/${course.courseId}"/>" class="label label-danger"> <spanclass="glyphicon glyphicon-remove" /></span> <spring:message code= "label.cart.remove"/></a></td>
					</tr>
				</c:forEach>
				<tr>
					<th></th>
					<th></th>
					<th><spring:message code= "label.cart.grandTotal"/></th>
					<th>${cart.grandTotal}$</th>
					<th></th>
				</tr>
			</table>
			<a href="<spring:url value="/courses" />" class="btn btndefault">
				<span class="glyphicon-hand-left glyphicon"></span> Continue shopping
			</a>
		</div>
	</section>
</body>
</html>