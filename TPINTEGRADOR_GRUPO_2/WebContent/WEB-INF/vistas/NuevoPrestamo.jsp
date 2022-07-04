<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
				<form action="#" method="post">
					<input type="hidden" value="${idBiblioteca}" name="idBiblioteca"></input> 

					<div class="row">
						<div class="col-md-8 offset-2">
							<hr>
						</div>
					</div>
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
					<div class="row">
						<div class="col-md-8 offset-2">
							<hr>
						</div>
					</div>

					<div class="row">

						<button type="button" id="listadoClienteAjax"
							class="btn btn-primary col-md-3 offset-4" data-toggle="modal"
							data-target="#asignarCliente">Asignar cliente</button>
					</div>
					<div class="row">

						<label for="lastName" class="col-md-3 offset-4 col-form-label">DNI</label>
						<div class="col-md-3">dni cliente</div>
						<label for="lastName" class="col-md-3 offset-4 col-form-label">Nombre
						</label>
						<div class="col-md-3">nombre cliente</div>
						<label for="lastName" class="col-md-3 offset-4 col-form-label">Apellido
						</label>
						<div class="col-md-3">apellido cliente</div>
					</div>
					<div class="row">
						<div class="col-md-8 offset-2">
							<hr>
						</div>
					</div>

					<div class="row">
						<label for="lastName" class="col-md-3 offset-4 col-form-label">Fecha</label>
						<div class="col-md-2">
							<input type="text" id="datepicker" width="276"
								class="form-control" value="dd/mm/yyyy" />

						</div>
					</div>
					<div class="row">
						<label for="lastName" class="col-md-3 offset-4 col-form-label">Cantidad
							Dias Prestamo</label>
						<div class="col-md-2">
							<input type="number" min="1" class="form-control" name="username">
						</div>
					</div>
					<div class="row">
						<div class="col-md-8 offset-2 mt-5">
							<h3></h3>
						</div>
					</div>
					<div class="row">
						<button type="submit" class="btn btn-primary col-md-3 offset-4">Guardar
							nuevo prestamo</button>

					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog  modal-lg modal-dialog-centered"
			role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Seleccionar
						Libro de la biblioteca</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<div class=" form-group row">
						<label for="lastName" class="col-md-1 col-form-label ">ISBN</label>
						<input type="text" class="form-control col-md-3" name="username"
							placeholder="ISBN"> <label for="lastName"
							class="col-md-1 col-form-label ">Titulo</label> <input
							type="text" class="form-control col-md-6" name="username"
							placeholder="Titulo">
					</div>
					<div class=" form-group row">
						<label for="lastName" class="col-md-1 col-form-label ">Autor</label>

						<select name="" id="" class="form-control col-md-3">
							<option value="">Seleccionar Autor</option>
						</select> <label for="lastName" class="col-md-1 col-form-label">Genero</label>
						<select name="" id="" class="form-control col-md-3">
							<option value="">Seleccionar Genero</option>
						</select> <label for="lastName" class="col-md-1 col-form-label">Idioma</label>
						<select name="" id="" class="form-control col-md-3">
							<option value="">Seleccionar Idioma</option>
						</select>

					</div>

					<button type="button" class="btn btn-primary col-md-2 offset-5"
						data-toggle="modal" data-target="#exampleModalCenter">Buscar</button>
					<div class="text-divider">
						<span>Resultados de la busqueda, click para asignar</span>
					</div>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">ISBN</th>
								<th scope="col">Titulo</th>
								<th scope="col">Idioma</th>
								<th scope="col">Autor</th>
								<th scope="col">Genero</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1233</td>
								<td>titulo libro</td>
								<td>rusian</td>
								<td>isac asimov</td>
								<td>ficcion</td>
							</tr>

						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary">Save changes</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="asignarCliente" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog  modal-lg modal-dialog-centered"
			role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Seleccionar
						Cliente</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<div class=" form-group row">
						<label for="lastName" class="col-md-1 col-form-label offset-2 ">DNI</label>
						<input type="text" class="form-control col-md-3" name="username"
							placeholder="ISBN">




						<button type="button" class="btn btn-primary col-md-2 offset-1"
							data-toggle="modal" data-target="#exampleModalCenter">Buscar</button>
					</div>
					<div class="text-divider">
						<span>Resultados de la busqueda, click para asignar</span>
					</div>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">DNI</th>
								<th scope="col">Nombre</th>
								<th scope="col">Apellido</th>
								<th scope="col">Email</th>
								<th scope="col">Telefono</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1233</td>
								<td>cliente1</td>
								<td>appelido</td>
								<td>mail@mail.com</td>
								<td>18938848</td>
							</tr>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$(document)
									.on(
											'click',
											'#listadoClienteAjax',
											function() {
												console.log('click');
												$
														.ajax({
															url : 'listarClienteFiltroAjax.html?nacionalidad=1&nombre=&apellido=',
															type : 'GET',
															success : function(
																	data) {
																console
																		.log(data);
															}
														});
											});
						});
	</script>

</body>

</html>