<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<p>All the available courses in our store</p>
				<c:url value="j_spring_security_logout" var="logoutUrl" />
				<a href="${logoutUrl}" class="btn btndangerbtn-mini pull-right">Log
					out</a>
			</div>
		</div>
	</section>
	<a href="courses/add">Add Course</a>
	<section class="container">
		<div class="row">
			<c:forEach items="${courses}" var="course">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<img src="<c:url value="/resource/images/${course.id}.png">
						</c:url>" alt="image" style = "width:100%"/>
						<div class="caption">
							<h3>${course.name}</h3>
							<p>${course.description}</p>
							<p>${course.price}</p>
							<p>
								<a href=" <spring:url value= "/course?id=${course.id}" /> " class="btn btn-primary"> <span class="glyphicon-info-sign glyphicon" /></span> Details</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>