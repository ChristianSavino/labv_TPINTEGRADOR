<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prestamos</title>
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
		<div class="row">
			<div class="col-12">
				<h1>Listado de prestamos</h1>

			</div>
		</div>
		<div class="row">
			<div class="col-12 offset-10">
				<a href="NuevoPrestamo.html" class="btn btn-success">Nuevo
					Prestamo</a>
			</div>
		</div>
		<h3></h3>
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th scope="col">Nro. Prestamo</th>
							<th scope="col">Libro</th>
							<th scope="col">Cliente</th>
							<th scope="col">Fecha prestamo</th>
							<th scope="col">Dias</th>
							<th scope="col">Estado</th>
							<th scope="col">Acciones</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">1</th>
							<td>Nombre del libro</td>
							<td>DNI Cliente</td>
							<td>Fecha Prestamo</td>
							<td>Cantida dias prestamo</td>
							<td>Atrasado</td>
							<td>
								<button type="button" class="btn btn-primary"
									data-toggle="modal" data-target="#exampleModalCenter" data-id-prestamo="1">
									<i class="far fa-eye"></i>
								</button> <a href="NuevoPrestamo.html" class="btn btn-warning"><i
									class="fas fa-edit"></i></a>
								<button type="button" class="btn btn-success"
									data-toggle="modal" data-target="#exampleModalCenter2">
									<i class="fas fa-check"></i>
								</button>



							</td>
						</tr>

					</tbody>
				</table>
				<div class="btn-group btn-group-toggle" data-toggle="buttons">
					<label class="btn btn-secondary active"> <input
						type="radio" name="options" id="option1" autocomplete="off"
						checked> Lista completa.
					</label> <label class="btn btn-secondary"> <input type="radio"
						name="options" id="option2" autocomplete="off"> Eliminar
					</label>
				</div>
				<div class="btn-group">
					<button type="radio" name="options" id="option3" autocomplete="off"
						class="btn btn-default dropdown-toggle" data-toggle="dropdown">
						Filtrar por <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<button type="button" class="btn btn-outline-secondary">DNI</button>

						<p>
							<input type="search" name="busqueda"> <input
								type="submit" value="Buscar">

						</p>

						<li class="divider"></li>
						<button type="button" class="btn btn-outline-secondary">ISBN</button>
						<p>
							<input type="search" name="busqueda"> <input
								type="submit" value="Buscar">

						</p>
						<li class="divider"></li>
						<button type="button" class="btn btn-outline-secondary">Estado</button>
						<p>
							<input type="search" name="busqueda"> <input
								type="submit" value="Buscar">

						</p>
					</ul>
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
	<div class="modal fade" id="exampleModalCenter2" tabindex="-1"
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

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	  $(document).ready(function() {
		$(document).on('click', ".modificar-biblioteca", function() {
		  console.log($(this).data('id-prestamo'));
		  let idPrestamo = $(this).data('id-prestamo');
		  $.ajax({
			type: 'POST',
				url: 'obtenerPrestamo.html',
				data: {idPrestamo: idPrestamo},
				success: function (data) {
				   console.log(data);
				}
		  });
		});
	
	  });
	
	</script>
</body>

</html>