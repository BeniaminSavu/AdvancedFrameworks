<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Validation</title>
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
			<p>${message}</p>
			<a href=login>Log in</a>
		</div>
	</section>
</body>
</html>