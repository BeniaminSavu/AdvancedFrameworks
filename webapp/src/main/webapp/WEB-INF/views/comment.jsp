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
					<a href="?locale=en" >EN</a>|<a href="?locale=ro" >RO</a>
				</div>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form modelAttribute="newComment" class="form-horizontal">
			<fieldset>
				<legend><spring:message code="label.title"/></legend>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="title"><spring:message code= "label.comment.title"/></label>
					<div class="col-lg-10">
						<form:input id="title" path="title" type="text" class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="message"><spring:message code= "label.comment.message"/></label>
					<div class="col-lg-10">
						<form:textarea id="message" path="message" rows = "2"/>
					</div>
				</div>
				<div class="form-group"> 	
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value="<spring:message code="label.comment.send"/>" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>