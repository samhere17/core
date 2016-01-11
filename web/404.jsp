<!DOCTYPE html>

<html lang="en-IN">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<!-- Bootstrap -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">

		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">

		<!-- Custom Styles -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">

		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/nav.css">

		<title>Apartment Management System</title>
	</head>

	<body>
		<header>
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a href="index.html" class="navbar-brand hidden-xs hidden-sm">Apartment Management System</a>
						<a href="index.html" class="navbar-brand hidden-md hidden-lg">AMS</a>
					</div>

					<div class="collapse navbar-collapse" id="navbar">
						<ul class="nav navbar-nav navbar-right">
							<li>
								<a class="" href="${pageContext.request.contextPath}/index.html" id="home-anchor">
									<span class="fa fa-home"></span>
									Home
								</a>
							</li>

							<li>
								<a class="" href="${pageContext.request.contextPath}/index.html#contact" id="contact-anchor">
									<span class="fa fa-envelope"></span>
									Contact Us
								</a>
							</li>
						</ul>
					</div>
				</div>
			</nav>
		</header>

		<main class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="page-header text-center">
						<h1>
							<span class="fa fa-frown-o fa-5x"></span>
							<br>
							<strong>202 + 202 = 404</strong>
							<br>
							<small>The page you are looking for does not exist</small>
							<br>
						</h1>
					</div>
				</div>
			</div>
		</main>

		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

		<script src="${pageContext.request.contextPath}/js/height-and-margin.js"></script>
	</body>
</html>
