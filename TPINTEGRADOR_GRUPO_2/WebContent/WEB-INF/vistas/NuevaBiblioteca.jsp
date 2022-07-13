<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar libro a Biblioteca</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="css/Main.css" />
<script type="text/javascript">
	function buscarLibro() {
		isbn = document.getElementById("isbn").value;
		nombre = document.getElementById("nombre").value;
		location.href = "buscarLibroFiltro.html?isbn=" + isbn + "&nombre="
				+ nombre;
	};

	function agregarBiblioteca() {
		isbn = document.getElementById("isbn").value;
		fechaAlta = document.getElementById("fechaAlta").value;
		location.href = "agregarBiblioteca.html?isbn=" + isbn + "&fechaAlta="
				+ fechaAlta;
	};
</script>
</head>

<body>
	<jsp:include page="Header.jsp" />
	<div class="container">
		<div class="card">
			<div class="card-body">
				<div class="row">
					<div class="col-md-6 offset-3">
						<h1>Nuevo Libro En Biblioteca</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-md-8 offset-2">
						<hr>
					</div>
				</div>
				<form action="guardarNuevaBiblioteca.html" method="post" id="formNuevaBiblioteca">
					<div class="row">
						<button type="button" id="listadoLibrosAjax" class="btn btn-primary col-md-3 offset-4" data-toggle="modal" data-target="#asignarLibro">Asignar Libro</button>
					</div>
					<div class="row" id="datosLibro">
					</div>
					<div class="row">
						<div class="col-md-8 offset-2">
							<hr>
						</div>
					</div>
					
					<div class="row">
						
							<label for="fechaAlta" class="col-md-3 offset-3 col-form-label">Fecha</label>
							<div class="col-md-2">
							
							<input type="date" id="fechaAlta" name="fechaAlta" class="form-control" step="1" value="01-07-2022" required>
							</div>
					</div>

					<div class="row">
						<input type="button" id="submitNuevaBiblioteca"
							value="Agregar Biblioteca" 
							class="btn btn-primary col-md-3 offset-4 ml-center"></input>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="asignarLibro" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog  modal-lg modal-dialog-centered"  style="max-width: 70%;" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">Buscar Libro, click para asignar</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
					<div class="container">
						<div class="row">
							<div class="col-12">
										
									    
										<div class="row">
											<label for="isbnLibro" class="col-md-1 col-form-label">ISBN</label>	
											<div class="col-md-2">				
												<input class="form-control" type="number" min="0" id="isbnLibro" name="isbn"></p>
											</div>		
									
											<label for="nombre" class="col-md-1 offset-1 col-form-label">Titulo</label>	
											<div class="col-md-2">				
												<input class="form-control" type="text" id="nombre" name="nombre"></p>
											</div>	
											<div class="col-md-1 offset-1 btn btn-primary mb-3" id="buscarLibrosAjax" >Buscar</div>	
											
										</div>	
										
										
			
								<hr>
								<div id="tablaLibros"></div>
									</div>
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="ModalValidaciones.jsp" />
				
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function () {
				$(document).on('click','#listadoLibrosAjax', function () {
					$("#isbnLibro").val('');
					$("#nombre").val('');
					$("#tablaLibros").html("cargando...");
					$("#buscarLibrosAjax").click();
				});
			
				$(document).on('click','#buscarLibrosAjax', function () {
					let isbn = $("#isbnLibro").val();
					let nombre = $("#nombre").val();
					$.ajax({
						url: "listarNuevosLibrosFiltroAjax.html?isbn="+isbn+"&nombre="+nombre,
						type: 'GET',
						success: function (data) {
							$("#tablaLibros").html(data);
						}
					});
				});
				
				$(document).on("click", "#submitNuevaBiblioteca", function(e) {
					let continuar = true;
					let mensaje = "";
					
					if($("#idLibro").val() === undefined){
						continuar = false;
						mensaje = "Se debe asignar un libro.";
					}
					
					if(!continuar){
						$("#messageValidationError").html(mensaje);
						$("#modalValidations").modal('show');
						return false;
					}
					
					
					$("#formNuevaBiblioteca").submit();
				});
				
			});
			
			document.getElementById("fechaAlta").value = getCurrentDate();
			
			function getCurrentDate(){
				var today = new Date();
				var dd = String(today.getDate()).padStart(2, '0');
				var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
				var yyyy = today.getFullYear();

				return yyyy + '-' + mm + '-' + dd;
			}
						
		</script>
</body>
</html>