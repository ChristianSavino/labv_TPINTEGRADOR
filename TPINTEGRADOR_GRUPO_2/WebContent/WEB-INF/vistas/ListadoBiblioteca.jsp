<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Biblioteca</title>
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
				<div class="col-12">
					<h1>Biblioteca</h1>
					<input type="button" value="Agregar Libro" onclick="location.href = 'nuevaBiblioteca.html';" class="btn btn-primary"></input>
				</div>
				<div class="col-12">
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
								<td>
								<form method="GET">                              
									<input type="button" value="Eliminar"	onclick="location.href = 'eliminarBiblioteca.html?id=${obj[0]}';"	class="btn btn-danger"></input>
									<input type="button" value="Modificar"  onclick="location.href = 'modificarBiblioteca.html?id=${obj[0]}';"	class="btn btn-primary"></input>
									<input type="button" <c:choose><c:when test="${obj[4] == 'Prestado'}"><c:out value="value='Info. Prestamo'" escapeXml="false"/></c:when> <c:otherwise><c:out value="value='Nuevo Prestamo'" escapeXml="false"/></c:otherwise></c:choose>  onclick="location.href = 'obtenerBibliotecaDesdeLista.html?idBiblioteca=${obj[0]}';" class="btn btn-primary"></input>
									</form>
                              	</td>
							</tr>
						</c:forEach>
					</table>
					</div>
					<form class="col-9" action="listarBibliotecaFiltro.html" method="Get">			
							<div>
							<p>
							<h3>Filtrar por:</h3>
							</p>
							
								<p>Fecha de Alta:
								<input class="form-control" type="date" name="fechaAlta"></p>
								<p></p>							
								<p>
								Estado:
								<select name="estado">
  									<option value="">Todos</option>
  									<option value="Disponible">Disponible</option>
  									<option value="Prestado">Prestado</option>
								</select>
								</p>
								<p></p>						
								<p>ISBN:
								<input class="form-control" type="number" name="isbn">
								</p>
								<p></p>	
								<p>Titulo:
								<input class="form-control" type="text" name="titulo">
								</p>
								<p><input class="form-control" type="submit" value="Buscar"></p>
							</div>
					</form>
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
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>

</html>