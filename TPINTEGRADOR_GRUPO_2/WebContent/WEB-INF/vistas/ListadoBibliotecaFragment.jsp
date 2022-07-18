
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<c:choose>
		<c:when test="${bibliotecas.size() eq 0}">
			<div class="row">
			<div class="col-md-3 offset-3">
			No hay autores para mostrar
			</div>
			<div class="col-md-1">
			<div class="btn btn-primary" onclick="location.href = 'nuevaBiblioteca.html';">Agregar Biblioteca</div>
			</div>
			</div>
		</c:when>
		<c:otherwise>
		<table class="table table-bordered table-hover">
						<tr>
							<td>Codigo</td>
							<td>ISBN</td>
							<td>Titulo</td>
							<td>Fecha Alta</td>
							<td>Estado</td>
							<td>Acciones</td>
						</tr>
						<c:forEach var="obj" items="${bibliotecas}">
							<tr>
								<td>${obj[0]}</td>
								<td>${obj[1]}</td>
								<td>${obj[2]}</td>
								<td>${obj[3]}</td>
								<td>${obj[4]}</td>
								<td><input type="button" value="Seleccionar"
						data-id-biblioteca="${obj[0]}"
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
					let idBiblioteca = $(this).data('id-biblioteca');
					$("#idBiblioteca").val(idBiblioteca);
					$.ajax({

					    type: "GET",
					    url: "obtenerBibliotecaNuevoPrestamoFragment.html?idBiblioteca="+idBiblioteca,
					    success: function (data) {
					       $("#datosLibro").html(data);
					       $('#asignarLibro').modal('hide')
					    },
					    error: function (response) {
					    	
							$("#messageValidationError").html("Ocurrio un error interno al intentar seleccionar el autor.");
							$("#modalValidations").modal('show');
							
					    }
					});

				});
			
		
			});
		</script>
	
