<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Courses</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Courses</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
		<div class="col-md-5">
			<img src="<c:url value="/resource/images/${course.courseId}.png">
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
				<p>
					<a href="#" class="btn btn-warning btn-large"> <span
						class="glyphicon-shopping-cart glyphicon"></span> Order Now
					</a>
				</p>
			</div>
		</div>
	</section>
</body>
</html>