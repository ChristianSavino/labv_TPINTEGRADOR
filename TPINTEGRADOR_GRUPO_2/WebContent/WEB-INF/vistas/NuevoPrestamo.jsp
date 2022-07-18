<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Biblioteca</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
			integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
			integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

		<style>
			.text-divider {
				margin: 2em 0;
				line-height: 0;
				text-align: center;
			}

			.text-divider span {
				background-color: #ffffff;
				padding: 1em;
			}

			.text-divider:before {
				content: " ";
				display: block;
				border-top: 1px solid #e3e3e3;
				border-bottom: 1px solid #f7f7f7;
			}
		</style>
		<link rel="stylesheet" type="text/css" href="css/Main.css" />
	</head>

	<body>
		<jsp:include page="Header.jsp" />
		<div class="container">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<div class="col-md-4 offset-4">
							<h1>Nuevo Prestamo</h1>
						</div>
					</div>
					<form action="guardarNuevoPrestamo.html" method="post" id="formNuevoPrestamo">
					<div class="row">
									<div class="col-md-8 offset-2">
										<hr>
									</div>
								</div>
						<c:choose>
							<c:when test="${libro eq null}">
								<div class="row">
	
									<button type="button" id="listadoLibrosAjax" class="btn btn-primary col-md-3 offset-4"
										data-toggle="modal" data-target="#asignarLibro">Asignar Libro</button>
								</div>
								<div class="row" id="datosLibro">
		
								</div>
							
							</c:when>
							
							<c:otherwise>
								<input type="hidden" value="${libro.getId()}" name="idBiblioteca" id="idBiblioteca"></input>
								
								<div class="row">
									<h3 class="col-md-3 offset-4">Libro</h3>
		
									<label for="lastName" class="col-md-3 offset-4 col-form-label">ISBN</label>
									<div class="col-md-3">${libro.getLibro().getIsbn()}</div>
									<label for="lastName" class="col-md-3 offset-4 col-form-label">Titulo
									</label>
									<div class="col-md-3">${libro.getLibro().getTitulo()}</div>
									<label for="lastName" class="col-md-3 offset-4 col-form-label">Autor
									</label>
									<div class="col-md-3">${libro.getLibro().getAutor().getNombre()}
										${libro.getLibro().getAutor().getApellido()}</div>
								</div>
							</c:otherwise>
						</c:choose>
					
						
					
						
						<div class="row">
							<div class="col-md-8 offset-2">
								<hr>
							</div>
						</div>

						<div class="row">

							<button type="button" id="listadoClienteAjax" class="btn btn-primary col-md-3 offset-4"
								data-toggle="modal" data-target="#asignarCliente">Asignar cliente</button>
						</div>
						<div class="row" id="datosCliente">
						</div>
						<div class="row">
							<div class="col-md-8 offset-2">
								<hr>
							</div>
						</div>

						<div class="row">
							<label for="selFecha" class="col-md-3 offset-4 col-form-label">Fecha</label>
							<div class="col-md-2">
								<input type="date" id="selFecha" name="fecha" class="form-control"
									step="1" min="01-07-2022" value="01-07-2022" required/>

							</div>
						</div>
						<div class="row">
							<label for="lastName" class="col-md-3 offset-4 col-form-label">Cantidad
								Dias Prestamo</label>
							<div class="col-md-2">
								<input type="number" min="1" class="form-control" name="cantidadDias" id="cantidadDias" value="1" required>
							</div>
						</div>
						<div class="row">
							<div class="col-md-8 offset-2 mt-5">
								<h3></h3>
							</div>
						</div>
						<div class="row">
							<input type="submit" class="btn btn-primary col-md-3 offset-4" id="submitNuevoPrestamo" value="Guardar nuevo prestamo">

						</div>
					</form>
				</div>
			</div>
		</div>
		
		<div class="modal fade" id="asignarCliente" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog  modal-lg modal-dialog-centered"  style="max-width: 70%;" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">Buscar cliente, click para asignar</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
					<div class="container">
						<div class="row">
							<div class="col-12">
										
									    
										<div class="row">
											<label for="nacionalidad" class="col-md-2 offset-1 col-form-label">Nacionalidad</label>	
											<div class="col-md-2">				
												<input class="form-control" type="search" id="nacionalidad" name="nacionalidad"></p>
											</div>		
										</div>	
										<div class="row">
											<label for="nombre" class="col-md-2 offset-1 col-form-label">Nombre</label>	
											<div class="col-md-2">				
												<input class="form-control" type="search" id="nombre" name="nombre"></p>
											</div>	
											<button class="col-md-1 offset-1 btn btn-primary" id="buscarClientesAjax" >Buscar</button>	
											
										</div>	
										<div class="row">
											<label for="apellido" class="col-md-2 offset-1 col-form-label">Apellido</label>	
											<div class="col-md-2">				
												<input class="form-control" type="search" id="apellido" name="apellido"></p>
											</div>		
										</div>	
										
			
								<hr>
								<div id="tablaClientes"></div>
									</div>
								</div>
							</div>
					</div>
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
									
											<label for="titulo" class="col-md-1 offset-1 col-form-label">Titulo</label>	
											<div class="col-md-2">				
												<input class="form-control" type="text" id="titulo" name="titulo"></p>
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
					let titulo = $("#titulo").val();
					let fechaAlta = '';
					let estado = 'Disponible';
					$.ajax({
						url: "listarBibliotecaFiltroAjax.html?fechaAlta="+fechaAlta+"&estado="+estado+"&isbn="+isbn+"&titulo="+titulo,
						type: 'GET',
						success: function (data) {
							$("#tablaLibros").html(data);
						}
					});
				});
				
				
				$(document).on('click','#listadoClienteAjax', function () {
					$("#nacionalidad").val('');
					$("#nombre").val('');
					$("#apellido").val('');
					$("#tablaClientes").html("cargando...");
					$("#buscarClientesAjax").click();
				});
			
				$(document).on('click','#buscarClientesAjax', function () {
					let nacionalidad = $("#nacionalidad").val();
					let nombre = $("#nombre").val();
					let apellido = $("#apellido").val();
					$.ajax({
						url: "listarClienteFiltroAjax.html?nacionalidad="+nacionalidad+"&nombre="+nombre+"&apellido="+apellido,
						type: 'GET',
						success: function (data) {
							$("#tablaClientes").html(data);
						}
					});
				});

				$(document).on("click", "#submitNuevoPrestamo", function(e) {
					let continuar = true;
					let mensaje = "";
					
					if($("#idCliente").val() === undefined){
						continuar = false;
						mensaje = "Se debe asignar un cliente.";
					}
					if($("#idBiblioteca").val() === undefined){
						continuar = false;
						mensaje = "Se debe asignar un libro.";
					}
					if($("#cantidadDias").val() < 1){
						continuar = false;
						mensaje = "La cantidad de dias debe ser mayor a uno.";
					}
					
					if(!continuar){
						$("#messageValidationError").html(mensaje);
						$("#modalValidations").modal('show');
						return false;
					}
					
					
					//$("#formNuevoPrestamo").submit();
				});
				
			});
			
			document.getElementById("selFecha").min = getCurrentDate();
			document.getElementById("selFecha").value = getCurrentDate();
			
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