
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<c:choose>
		<c:when test="${libros.size() eq 0}">
			<div class="row">
			<div class="col-md-3 offset-3">
			No hay libros para mostrar
			</div>
			<div class="col-md-1">
			<div class="btn btn-primary" onclick="location.href = 'nuevoLibro.html';">Agregar Libro</div>
			</div>
			</div>
		</c:when>
		<c:otherwise>
		<table class="table table-bordered table-hover">
			<tr>
				<td>ISBN</td>
				<td>Cantidad de paginas</td>
				<td>Descripcion</td>
				<td>Fecha de lanzamiento</td>
				<td>Idioma</td>
				<td>Titulo</td>
				<td>Autor</td>
			</tr>
			<c:forEach var="obj" items="${libros}">
				<tr>
					<td>${obj[0]}</td>
					<td>${obj[1]}</td>
					<td>${obj[2]}</td>
					<td>${obj[3]}</td>
					<td>${obj[4]}</td>
					<td>${obj[5]}</td>
					<td>${obj[6]} ${obj[7]}</td>
					<td><input type="button" value="Seleccionar"
						data-isbn="${obj[0]}"
						class=" btn btn-success seleccionarLibro"></input></td>
				</tr>
			</c:forEach>
		</table>
		</c:otherwise>
	</c:choose>
					
	
	
	<script type="text/javascript">
			$(document).ready(function () {
				// onclick="location.href = 'obtenerClienteNuevoPrestamo.html?idCliente=${obj[0]}';"
				$(document).off('click', '.seleccionarLibro');
				$(document).on('click','.seleccionarLibro', function (e) {
					let idCliente = $(this).data('isbn');
					$("#idLibro").val(idCliente);
					$.ajax({

					    type: "GET",
					    url: "obtenerLibroNuevaBibliotecaFragment.html?isbn="+idCliente,
					    success: function (data) {
					       $("#datosLibro").html(data);
					       $('#asignarLibro').modal('hide')
					    },
					    error: function (response) {
					    	
							$("#messageValidationError").html("Ocurrio un error interno al intentar seleccionar el libro.");
							$("#modalValidations").modal('show');
							
					    }
					});

				});
			
		
			});
		</script>
	
