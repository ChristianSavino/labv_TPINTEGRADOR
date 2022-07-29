
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-1">
			<div class="btn btn-primary" onclick="location.href = 'nuevoAutor.html';">Agregar Autor</div>
			</div>
	<c:choose>
		<c:when test="${autores.size() eq 0}">
			<div class="row">
			<div class="col-md-3 offset-3">
			No hay autores para mostrar
			</div>
			
			</div>
		</c:when>
		<c:otherwise>
		<table class="table table-bordered table-hover">
			<tr>
				<td>Nombre</td>
				<td>Apellido</td>
				<td>Nacionalidad</td>
				<td>Email</td>
				
			</tr>
			<c:forEach var="obj" items="${autores}">
				<tr>
					<td>${obj[1]}</td>
					<td>${obj[2]}</td>
					<td>${obj[3]}</td>
					<td>${obj[4]}</td>
					<td><input type="button" value="Seleccionar"
						data-id-autor="${obj[0]}"
						class=" btn btn-success seleccionarAutor"></input></td>
				</tr>
			</c:forEach>
		</table>
		</c:otherwise>
	</c:choose>
					
	
	
	<script type="text/javascript">
			$(document).ready(function () {
				// onclick="location.href = 'obtenerClienteNuevoPrestamo.html?idCliente=${obj[0]}';"
				$(document).off('click', '.seleccionarAutor');
				$(document).on('click','.seleccionarAutor', function (e) {
					let idAutor = $(this).data('id-autor');
					$("#idAutor").val(idAutor);
					$.ajax({

					    type: "GET",
					    url: "obtenerAutorNuevoLibroFragment.html?idAutor="+idAutor,
					    success: function (data) {
					       $("#datosAutor").html(data);
					       $('#asignarAutor').modal('hide')
					    },
					    error: function (response) {
					    	
							$("#messageValidationError").html("Ocurrio un error interno al intentar seleccionar el autor.");
							$("#modalValidations").modal('show');
							
					    }
					});

				});
			
		
			});
		</script>
	
