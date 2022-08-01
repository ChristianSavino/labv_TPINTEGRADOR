<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Libro - Agregar Libro</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">

	<link rel="stylesheet" type="text/css" href="css/Main.css" />
	
	<script src="js/jQuery.js"></script>	
</head>
<body>
	<jsp:include page="Header.jsp" />
    
		<div class="container">
			<div class="card">
				<div class="card-body">
				<div class="row">
						<div class="col-md-4 offset-4">
							<h1>Nuevo Libro</h1>
						</div>
					</div>
					<form action="agregarLibro.html" method="post" id="formNuevoLibro">
					<input type="hidden" value="" name="generos" id="generosEnviar"></input>
						<div class=" form-group row">
							<label for="isbn" class="col-sm-2 col-form-label">ISBN:</label>
							<div class="col-sm-7">
								<input class="form-control" min="1" type="number" id="isbn" name="isbn" required>
							</div>
						</div>
						
						<div class="form-group row">
							<label for="titulo" class="col-sm-2 col-form-label">Titulo:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="titulo" name="titulo" required placeholder="Ingrese un titulo">
							</div>
						</div>
						
						<div class="form-group row">
							<label for="fechaLanzamiento" class="col-sm-2 col-form-label">Fecha de Lanzamiento:</label>
							<div class="col-sm-7">
								<input type="date" class="form-control" id="fechaLanzamiento" required name="fechaLanzamiento">
								
							</div>
						</div>
						
					
						<div class=" form-group row">
							<label for="cantidadPaginas" class="col-sm-2 col-form-label">Cantidad de paginas:</label>
							<div class="col-sm-7">
								<input class="form-control" type="number" id="cantidadPaginas" name="cantidadPaginas" min="1" required>
							</div>
						</div>
						
						<div class="form-group row">
							<label for="idioma" class="col-sm-2 col-form-label">Idioma:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="idioma" name="idioma" required>
							</div>
						</div>
						
						<div class="form-group row">
							<label for="descripcion" class="col-sm-2 col-form-label">Sinopsis:</label>
							<div class="col-sm-7">
								<textarea type="text" class="form-control" id="descripcion" rows="3" maxlength="200" name="descripcion" required></textarea>
							</div>
						</div>
						
						<div class="form-group row">
							<label for="lastName" class="col-sm-2 col-form-label">Genero:</label>
							<div class="col-sm-7">
								<select id="genero">
									<c:forEach items="${generos}" var="obj" >
		                            	<option value="${obj.getIdGenero()}">${obj.getDescripcion()}</option>													
									</c:forEach>
								</select>
								<input type="button" value="Agregar Genero" id="agregarGenero" class="btn btn-primary"></input>
							</div>
						</div>
						
						<div class="form-group row">
							<table class="table table-bordered table-hover d-none" id="tablaGeneros">
							<thead>
								<tr>
									<td>Id</td>
									<td>Descripcion</td>
									<td>Acciones</td>
								</tr>
							</thead>
							<tbody>
							</tbody>
							</table>
						</div>
						
						<div class="row">
							<div class="col-md-8 offset-2">
								<hr>
							</div>
						</div>

						<div class="row">

							<button type="button" id="listadoAutorAjax" class="btn btn-primary col-md-3 offset-4"
								data-toggle="modal" data-target="#asignarAutor">Asignar Autor</button>
						</div>
						<div class="row" id="datosAutor">

						</div>
						<div class="row">
							<div class="col-md-8 offset-2">
								<hr>
							</div>
						</div>
						

						<div class="row">
							<input type="submit" class="btn btn-primary col-md-3 offset-4" id="submitNuevoLibro" value="Guardar	nuevo libro">

						</div>
					</form>
				</div>
			</div>
		</div>
		
		<div class="modal fade" id="asignarAutor" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog  modal-lg modal-dialog-centered"  style="max-width: 70%;" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">Buscar autor, click para asignar</h5>
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
										<button class="col-md-1 offset-1 btn btn-primary" id="buscarAutoresAjax" >Buscar</button>	
										
									</div>	
									<div class="row">
										<label for="apellido" class="col-md-2 offset-1 col-form-label">Apellido</label>	
										<div class="col-md-2">				
											<input class="form-control" type="search" id="apellido" name="apellido"></p>
										</div>		
									</div>	
										
			
								<hr>
								<div id="tablaAutores"></div>
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
				$(document).on('click','#listadoAutorAjax', function () {
					$("#nacionalidad").val('');
					$("#nombre").val('');
					$("#apellido").val('');
					$("#tablaClientes").html("cargando...");
					$("#buscarAutoresAjax").click();
				});
			
				$(document).on('click','#buscarAutoresAjax', function () {
					let nacionalidad = $("#nacionalidad").val();
					let nombre = $("#nombre").val();
					let apellido = $("#apellido").val();
					$.ajax({
						url: "listarAutorFiltroAjax.html?nacionalidad="+nacionalidad+"&nombre="+nombre+"&apellido="+apellido,
						type: 'GET',
						success: function (data) {
							$("#tablaAutores").html(data);
						}
					});
				});
				
				$(document).on("click", "#submitNuevoLibro", function(e) {
					let continuar = true;
					let mensaje = "";
					
					if($("#idAutor").val() === undefined){
						continuar = false;
						mensaje = "Se debe asignar un autor.";
					}
					
					if($("#tablaGeneros tr").length == 1){
						continuar = false;
						mensaje = "Se debe agregar al menos un genero.";
					}
					
					if(!continuar){
						$("#messageValidationError").html(mensaje);
						$("#modalValidations").modal('show');
						return false;
					}
					
					let generos = "";
					$("#tablaGeneros  tr:gt(0) td:nth-child(1)").each(function(){
					       generos += $(this).html() + "-";
				    });
					
					$("#generosEnviar").val(generos);					
				});
				
			

				$(document).on("click", "#agregarGenero", function() {
					//muestro la tabla y agrego el genero
					$("#tablaGeneros").removeClass("d-none");
					let idGenero = $("#genero").val();
					let descripcion =  $("#genero option:selected").text();
					let existentes = $('#tablaGeneros td').filter(function () { return $.trim($(this).text()) == idGenero; }).length;
					
					if(existentes > 0){
						$("#messageValidationError").html("El genero seleccionado ya fue cargado.");
						$("#modalValidations").modal('show');
						return false;
					}
					$('#tablaGeneros > tbody:last-child').append('<tr><td>'+idGenero+'</td><td>'+descripcion+'</td><td><div class="btn btn-danger quitarGeneroLista">Eliminar</div></td></tr>');
					
				});
				$(document).on("click", ".quitarGeneroLista", function() {
					//remuevo el genero
					$(this).closest('tr').remove();
					
					//oculto la tabla
					if($("#tablaGeneros tr").length == 1){
						$("#tablaGeneros").addClass("d-none");
					}

				});

				
			});
			document.getElementById("fechaLanzamiento").value = getCurrentDate();
			
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