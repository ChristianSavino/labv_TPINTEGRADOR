<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado Prestamos</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<link rel="stylesheet" href="../lib/css/Main.css">
<link rel="stylesheet" type="text/css" href="css/Main.css" />
</head>

<body>
	<jsp:include page="Header.jsp" />
	<div class="container">
		<div class="card">
			<div class="card-body">
				<div class="col-12">
					<h1>Prestamos</h1>
					<input type="button" value="Agregar Prestamo"
						onclick="location.href = 'nuevoPrestamo.html';"
						class="btn btn-primary"></input>
				</div>
				<br>
				<form class="col-12" action="listadoPrestamos.html" method="Get">
					<div>
						<h3>Filtrar por:</h3>
						<div class=" form-group row">
							<label for="isbn" class="col-sm-2 col-form-label">ISBN:</label>
							<div class="col-sm-7">
								<input class="form-control" min="1" type="number" id="isbn"
									name="isbn">
							</div>
						</div>
						<div class="form-group row">
							<label for="titulo" class="col-sm-2 col-form-label">Titulo:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="titulo"
									name="titulo" placeholder="Ingrese un titulo">
							</div>
						</div>
						<div class="form-group row">
							<label for="dniCliente" class="col-sm-2 col-form-label">DNI:</label>
							<div class="col-sm-7">
								<input type="number" class="form-control" id="dniCliente"
									name="dniCliente" min="1">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-7">
								<input class="col-sm-2 col-form-label" type="submit" value="Buscar">
							</div>
						</div>
					</div>
				</form>
				<div class="col-12">
					<table class="table table-bordered table-hover table-sm">
						<tr>
							<th scope="col">Nro. Prestamo</th>
							<th scope="col">ISBN</th>
							<th scope="col">Titulo</th>
							<th scope="col">Autor</th>
							<th scope="col">Fecha prestamo</th>
							<th scope="col">Dias prestamo</th>
							<th scope="col">Cliente</th>
							<th scope="col">DNI</th>
							<th scope="col">Acciones</th>
						</tr>
						<c:forEach var="obj" items="${prestamos}">
							<tr>
								<td>${obj[0]}</td>
								<td>${obj[1]}</td>
								<td>${obj[2]}</td>
								<td>${obj[3]}${obj[4]}</td>
								<td>${obj[6]}</td>
								<td>${obj[5]}</td>
								<td>${obj[7]}${obj[8]}</td>
								<td>${obj[9]}</td>
								<td><input type="button" value="Devolver Libro"
									data-id-prestamo="${obj[0]}"
									class="btn btn-success devolverLibro"></input></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>


	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Detalles
						del prestamo</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class=" form-group row">
						<label for="lastName" class="col-sm-5 col-form-label">Nro
							Prestamo</label>
						<div class="col-sm-7">1</div>
					</div>
					<div class=" form-group row">
						<label for="lastName" class="col-sm-5 col-form-label">ISBN</label>
						<div class="col-sm-7">12344567-2344</div>
					</div>
					<div class=" form-group row">
						<label for="lastName" class="col-sm-5 col-form-label">Nombre
							Libro</label>
						<div class="col-sm-7">Un libro mas</div>
					</div>
					<div class=" form-group row">
						<label for="lastName" class="col-sm-5 col-form-label">DNI
							Cliente</label>
						<div class="col-sm-7">39999999</div>
					</div>
					<div class=" form-group row">
						<label for="lastName" class="col-sm-5 col-form-label">Nombre
							Cliente</label>
						<div class="col-sm-7">Nomnre cliente</div>
					</div>
					<div class=" form-group row">
						<label for="lastName" class="col-sm-5 col-form-label">Apellido
							Cliente</label>
						<div class="col-sm-7">Apellido cliente</div>
					</div>
					<div class=" form-group row">
						<label for="lastName" class="col-sm-5 col-form-label">Fecha
							Prestamo</label>
						<div class="col-sm-7">39/02/2022</div>
					</div>
					<div class=" form-group row">
						<label for="lastName" class="col-sm-5 col-form-label">Cantidad
							Dias Prestamo</label>
						<div class="col-sm-7">9991992949</div>
					</div>
					<div class=" form-group row">
						<label for="lastName" class="col-sm-5 col-form-label">Estado</label>
						<div class="col-sm-7">Atrasado</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="devolverLibroModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Devolver
						libro</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class=" form-group row">
						<div class="col-lg-8 offset-2">¿Esta seguro que desea
							devolver el libro?</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary">SI</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">No</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="ModalValidaciones.jsp" />

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>

	<script type="text/javascript">
			$(document).ready(function () {
				$(document).off('click', '.devolverLibro');
				$(document).on('click','.devolverLibro', function (e) {
					let prestamo = $(this).data('id-prestamo');
					 $('#devolverLibroModal').modal('show');
					
					$('#devolverLibroModal').on('click', '.btn-primary', function(){
					    
					    $('#devolverLibroModal').modal('hide');
					    location.href = 'finalizarPrestamo.html?idPrestamo=' + prestamo;
// 					    $.ajax({

// 						    type: "POST",
// 						    url: "finalizarPrestamo.html?idPrestamo="+prestamo,
// 						    error: function (response) {
						    	
// 								$("#messageValidationError").html("Ocurrio un error interno al intentar seleccionar el libro.");
// 								$("#modalValidations").modal('show');
								
// 						    }});
					    
					});
					

				});
			});
			
			
		</script>
</body>

</html>