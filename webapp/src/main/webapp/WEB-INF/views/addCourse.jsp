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
			<h1><spring:message code= "label.courses.title"/></h1>
		</div>
	</div>
	<section class="container">
		<form:form modelAttribute="newCourse" class="form-horizontal">
			
			<fieldset>
				<legend><spring:message code="label.title"/></legend>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="courseId"><spring:message code= "label.productId"/></label>
					<div class="col-lg-10">
						<form:input id="courseId" path="courseId" type="text" class="form:input-large" />
						<form:errors path="courseId" cssClass="alert alert-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name"><spring:message code= "label.name"/></label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text" class="form:input-large" />
						<form:errors path="name" cssClass="alert alert-danger"/>
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
						<form:errors path="type" cssClass="alert alert-danger"/>
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
						<input type="submit" id="btnAdd" class="btn btn-primary" value="<spring:message code="label.buttonAdd"/>" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>