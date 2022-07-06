
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
					
	<table class="table table-bordered table-hover">
		<tr>
			<td>DNI</td>
			<td>Nombre</td>
			<td>Apellido</td>
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
				<td>                              
					<input type="button" value="Seleccionar" onclick="location.href = 'obtenerClienteNuevoPrestamo.html?idCliente=${obj[9]}';" data-id-cliente="${obj[9]}" class=" btn btn-success"></input>
                </td>
			</tr>
		</c:forEach>
	</table>
	
	<script type="text/javascript">
			$(document).ready(function () {
				$(document).off('click', '.seleccionarCliente');
				$(document).on('click','.seleccionarCliente', function (e) {
					console.log("idCliente", $(this).data('id-cliente'));
					let idCliente = $(this).data('id-cliente');
					$("#idCliente").val(idCliente);
					$.ajax({

					    type: "GET",
					    url: "obtenerClienteNuevoPrestamo.html?idCliente="+idCliente,
					    contentType: "application/json",
					    dataType: 'json',
					    success: function (data) {
					       console.log(data);
					       data = JSON.parse(data);
					       console.log(data.idCliente);

					    },
					    failure: function (response) {
					        alert(response.d);
					    }
					});

				});
			
		
			});
		</script>
	
