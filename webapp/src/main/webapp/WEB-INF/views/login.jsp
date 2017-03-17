<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please sign in</h3>
					</div>
					<div class="panel-body">
						<c:url value= "/j_spring_security_check" var="loginUrl"/>
						<form action="${loginUrl}" method="post">
							<c:if test="${param.error != null}">
								<div class="alert alert-error">
									Failed to login.
									<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
										<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
									</c:if>
								</div>
							</c:if>	
							<fieldset>
								<div class="form-group">
									<label class="control-label col-lg-3 col-lg-3" for="username">Username</label>
									<div class="col-lg-10">
										<input type="text" id="username" name="j_username" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-lg-3 col-lg-3" for="password">Password</label>
									<div class="col-lg-10">
										<input type="password" id="password" name="j_password"/>
									</div>
								</div>
								<div class="col-lg-10">
									<input class="btn btn-lg btn-success btn-block" type="submit" value="Login" />
								</div>
							</fieldset>
							<p>Don't have an account ? <a href="signup">sign up</a> now !</p>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>