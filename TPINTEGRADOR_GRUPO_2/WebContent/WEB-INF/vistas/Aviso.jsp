<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>${titulo}</title>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
		crossorigin="anonymous">
	<link rel="stylesheet"
		href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
		integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
		crossorigin="anonymous">

	<link rel="stylesheet" type="text/css" href="css/Main.css" />
</head>

<body>
	<div class="form">
		<div class="container">
			<div class="card">
				<h1>${tituloMensaje}</h1>
				<div class="card-body">
					<form action="${paginaARedireccionar}" method="post">
						<div class=" form-group row">
							<label >${mensaje}</label>
						</div>
						<div class=" form-group row">
							<button type="submit" class="btn btn-primary">${mensajeBoton}</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>