<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<script
src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js">
</script>
<script src="/resources/js/controllers.js"></script>
<title>Courses</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<c:url value="/j_spring_security_logout" var="logoutUrl"/>
			<a href="${logoutUrl}" class="btn btndangerbtn-mini pull-right">Log out</a>
			<div class="pull-right" style="padding-right:50px">
				<a href="?locale=en" >EN</a>|<a href="?locale=ro" >RO</a>
			</div>
			<h1><spring:message code= "label.course.details"/></h1>
		</div>
	</section>
	<div class="container">
		<h2>${isCourseAdded}</h2>
	</div>
	<section class="container">
		<div class="row">
		<div class="col-md-5">
			<img src="<c:url value="/resource/images/1.png">
			</c:url>" alt="image" style = "width:100%"/>
		</div>
			<div class="col-md-5">
				<h3>${course.name}</h3>
				<p>${course.description}</p>
				<p>
					<strong>Item Code : </strong>${course.courseId}
				</p>
				<p>
					<strong>type</strong> : ${course.type}
				</p>
				<h4>${course.price}USD</h4>
				<a href="<spring:url value="/courses" />" class="btn btn-default">
					<span class="glyphicon-hand-left glyphicon"></span> back
				</a>
				<p >
					<a href="<spring:url value="/cart/add/${course.courseId}"/>" class="btn btn-warning btn-large" > <span
						class="glyphicon-shopping-cart glyphicon"></span> Order Now
					</a>
					<a href="<spring:url value="/cart" />" class="btn btn-default">
						<span class="glyphicon-hand-right glyphicon"></span> View Cart
					</a>
				</p>
			</div>
		</div>
		<div class="row">
			<a href="<spring:url value="/comment/add/${course.courseId}" />" class="btn btn-success" style="margin:20px"><spring:message code= "label.comment.add"/></a>
		</div>
		<div class="row">
			<c:forEach items="${course.comments}" var="comment">
				<div class="caption">
					<h3>${comment.title}</h3>
					<p>${comment.message}</p>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>