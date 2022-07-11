<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema de Biblioteca</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/Main.css" />
</head>

<style>
.form{
	margin-top: 150px;
}
</style>

<body>
	<div class="form">
		<div class="container">
			<div class="card">
				<h1>Sistema Biblioteca: Grupo 2</h1>
				<div class="card-body">
					<form action="index.html" method="post">
						<div class=" form-group row">
							<label for="username" class="col-sm-2 col-form-label">Usuario</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="username"
									placeholder="Ingrese un nombre de usuario">
							</div>
						</div>
						<div class="form-group row">
							<label for="password" class="col-sm-2 col-form-label">Contraseña</label>
							<div class="col-sm-7">
								<input type="password" class="form-control" name="password"
									placeholder="Ingrese una contraseña">
							</div>
						</div>
						<button type="submit" class="btn btn-primary">Iniciar
							sesion</button>
					</form>
				</div>
				<div class="card-body">
					<span>${loginFailed}</span>
				</div>
			</div>
		</div>
	</div>
</body>

</html>