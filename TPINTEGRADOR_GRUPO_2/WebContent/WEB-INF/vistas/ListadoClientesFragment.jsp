
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<c:choose>
		<c:when test="${clientes.size() eq 0}">
			<div class="row">
			<div class="col-md-3 offset-3">
			No hay clientes para mostrar
			</div>
			<div class="col-md-1">
			<div class="btn btn-primary" onclick="location.href = 'nuevoCliente.html';">Agregar Cliente</div>
			</div>
			</div>
		</c:when>
		<c:otherwise>
		<table class="table table-bordered table-hover">
			<tr>
				<td>ID</td>
				<td>DNI</td>
				<td>Nombre</td>
				<td>Apellido</td>
				<td>Sexo</td>
				<td>Nacionalidad</td>
				<td>Email</td>
				<td>Dirección</td>
				<td>Localidad</td>
				<td>Teléfono</td>
				<td>Fecha Nacimiento</td>
			</tr>
			<c:forEach var="obj" items="${clientes}">
				<tr>
					<td>${obj[0]}</td>
					<td>${obj[1]}</td>
					<td>${obj[2]}</td>
					<td>${obj[3]}</td>
					<td>${obj[4]}</td>
					<td>${obj[5]}</td>
					<td>${obj[6]}</td>
					<td>${obj[7]}</td>
					<td>${obj[8]}</td>
					<td>${obj[9]}</td>
					<td>${obj[10]}</td>
					<td><input type="button" value="Seleccionar"
						data-id-cliente="${obj[0]}"
						class=" btn btn-success seleccionarCliente"></input></td>
				</tr>
			</c:forEach>
		</table>
		</c:otherwise>
	</c:choose>
					
	
	
	<script type="text/javascript">
			$(document).ready(function () {
				// onclick="location.href = 'obtenerClienteNuevoPrestamo.html?idCliente=${obj[0]}';"
				$(document).off('click', '.seleccionarCliente');
				$(document).on('click','.seleccionarCliente', function (e) {
					let idCliente = $(this).data('id-cliente');
					$("#idCliente").val(idCliente);
					$.ajax({

					    type: "GET",
					    url: "obtenerClienteNuevoPrestamoFragment.html?idCliente="+idCliente,
					    success: function (data) {
					       $("#datosCliente").html(data);
					       $('#asignarCliente').modal('hide')
					    },
					    error: function (response) {
					    	
							$("#messageValidationError").html("Ocurrio un error interno al intentar seleccionar el cliente.");
							$("#modalValidations").modal('show');
							
					    }
					});

				});
			
		
			});
		</script>
	
