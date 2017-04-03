<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Welcome</title>
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
			<p>Hello ${username}</p>
		</div>
		<div class="jumbotron">
			<c:url value="/j_spring_security_logout" var="logoutUrl"/>
			<a href="${logoutUrl}" class="btn btndangerbtn-mini pull-right">Log out</a>
			<div class="pull-right" style="padding-right:50px">
				<a href="?locale=en" >EN</a>|<a href="?locale=ro" >RO</a>
			</div>
			<h1><spring:message code= "label.greetings"/></h1>
			<p><spring:message code= "label.tagline"/></p>
		</div>
		<div class="row">
			<h1><spring:message code= "label.course.owned"/></h1>
			<c:forEach items="${courses}" var="course">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<img src="<c:url value="/resource/images/1.png">
						</c:url>" alt="image" style = "width:100%"/>
						<div class="caption">
							<h3>${course.name}</h3>
							<p>${course.description}</p>
							<p>${course.price}</p>
							<p>
								<a href=" <spring:url value= "/course?id=${course.courseId}" /> " class="btn btn-primary"> <span class="glyphicon-info-sign glyphicon" /></span> Details</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="footer">
			<p>&copy; Beniamin Savu</p>
		</div>
	</div>
</body>
</html>