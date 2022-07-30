<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Autor - Agregar Autor</title>
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
	<jsp:include page="Header.jsp" />
	<div class="container">
		<div class="card">
			<div class="card-body">
				<div class="row">
					<div class="col-md-4 offset-4">
						<h1>Nuevo Autor</h1>
					</div>
				</div>
				<form action="agregarAutor.html" method="post" id="formNuevoAutor">
					
					<div class="form-group row">
						<label for="nombre" class="col-md-2 col-form-label">Nombre:</label>
						<div class="col-sm-7">
							<input type="text" name="nombre" class="form-control" required>
						</div>
					</div>

					<div class="form-group row">
						<label for="apellido" class="col-md-2 col-form-label">Apellido:</label>
						<div class="col-sm-7">
							<input type="text" name="apellido" class="form-control" required>
						</div>
					</div>

					<div class="form-group row">
						<label for="email" class="col-md-2 col-form-label">Email:</label>
						<div class="col-sm-7">
							<input type="email" name="email" class="form-control" required>
						</div>
					</div>

					<div class="form-group row">
						<label for="nacionalidad" class="col-md-2 col-form-label">Nacionalidad:</label> 
						<div class="col-sm-7">
							<select name="nacionalidad" id="selectNacionalidad">
								<option value="">--</option>
								<c:forEach var="obj" items="${nacionalidades}">
									<option value="${obj.getIdNacionalidad()}">${obj.getDescripcion()}</option>
			                            console.log(${obj.getIdNacionalidad()})													
									</c:forEach>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-md-8 offset-2">
							<hr>
						</div>
					</div>
					<div class="row">
						<input type="submit" class="btn btn-primary col-md-3 offset-4" id="submitNuevoAutor" value="Guardar	Nuevo Autor">
					</div>
					
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="ModalValidaciones.jsp" />


		<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>

		<script type="text/javascript">
			$(document).ready(function () {

				$(document).on("click", "#submitNuevoAutor", function(e) {
					let continuar = true;
					let mensaje = "";
					
					if($("#selectNacionalidad").val().length == 0){
						continuar = false;
						mensaje = "Se debe seleccionar una nacionalidad.";
					}
					
					if(!continuar){
						$("#messageValidationError").html(mensaje);
						$("#modalValidations").modal('show');
						return false;
					}

				});
				
			});
		

	
			
			
		</script>
</body>
</html>