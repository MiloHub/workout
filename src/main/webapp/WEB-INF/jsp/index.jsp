<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="en">
<head>
<meta charset="utf-8">
<title>Code Challenge</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css"
	rel="stylesheet">
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>

</head>

<body>
	<script>
		$(document)
				.ready(
						function() {
							$("#get")
									.click(
											function() {
												$
														.getJSON(
																"http://localhost:8080/codechallenge/rest/samplerest/get",
																function(result) {
																	var items = [];
																	$(
																			"<ul/>",
																			{
																				"class" : "my-new-list",
																				"id" : "my-new-list",
																				html : JSON
																						.stringify(result)
																			})
																			.appendTo(
																					"body");
																});
											});

							$("#delete")
									.click(
											function() {
												$("#my-new-list").remove();

												$
														.ajax({
															url : 'http://localhost:8080/codechallenge/rest/samplerest/delete',
															type : 'DELETE',
															success : function(
																	result) {
																var items = [];
																$(
																		"<ul/>",
																		{
																			"class" : "my-new-list",
																			html : JSON
																					.stringify(result)
																		})
																		.appendTo(
																				"body");

															}
														});
											});
						});
	</script>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>
				<a id="homePage" class="brand" href="#">Code Challenge</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a id="home" href="/codechallenge/sample">Home</a></li>

					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">
		<p>
			Sample Application web based application power by Jquery, JSON ,
			Jersey.<br />
		</p>
		<div>
			<input type="button" id="get" value="get example">
		</div>
		<div>
			<input type="button" id="delete" value="delete persons example">
		</div>
	</div>
	<!-- /container -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
</body>
</html>
