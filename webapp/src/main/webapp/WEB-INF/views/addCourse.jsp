<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Courses</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Courses</h1>
				<p>Add courses</p>
				<c:url value="/j_spring_security_logout" var="logoutUrl"/>
				<a href="${logoutUrl}" class="btn btndangerbtn-mini pull-right">Log out</a>
				<div class="pull-right" style="padding-right:50px">
					<a href="?locale=en" >English</a>|<a href="?locale=ro" >Romanian</a>
				</div>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form modelAttribute="newCourse" class="form-horizontal">
			<fieldset>
				<legend>Add new Course</legend>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId"><spring:message code= "label.productId"/></label>
					<div class="col-lg-10">
						<form:input id="courseId" path="courseId" type="text" class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name"><spring:message code= "label.name"/></label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text" class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="price"><spring:message code= "label.price"/></label>
					<div class="col-lg-10">
						<form:input id="price" path="price" type="text" class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="type"><spring:message code= "label.type"/></label>
					<div class="col-lg-10">
						<form:input id="type" path="type" type="text" class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="description"><spring:message code= "label.description"/></label>
					<div class="col-lg-10">
						<form:textarea id="description" path="description" rows = "2"/>
					</div>
				</div>
				<div class="form-group"> 	
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value="Add" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>