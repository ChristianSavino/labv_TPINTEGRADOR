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
	<script type="text/javascript">

		$( document ).ready(function() {
			document.getElementById("tabla").style.display = "none";
		});


		function QuitarGeneroLista(id) {
			var table = document.getElementById("tBody");

			for (var i = 0, row; row = table.rows[i]; i++) {
				if (id == row.cells[0].innerHTML) {
					row.remove();
				}
			};
		};
		
		function AgregarGenero() {
			document.getElementById("tabla").style.display = "block";

			var droplist = document.getElementById("genero");
			var id = droplist.value;
			var desc = droplist.options[droplist.selectedIndex].text;

			var tableBody = document.getElementById("tBody");

			try {
				for (var i = 0, row; row = tableBody.rows[i]; i++) {
					if (id == row.cells[0].innerHTML) {
						throw "myException";
					}
				};

				var row = document.createElement('tr');
				var data1 = document.createElement('td');
				data1.innerHTML = id;
				var data2 = document.createElement('td');
				data2.innerHTML = desc;
				var data3 = document.createElement('td');

				var input = document.createElement('button');
				input.type = 'button';
				input.className  = 'btn btn-danger';
				input.innerHTML = 'Eliminar';
				input.addEventListener("click", function() {
					QuitarGeneroLista(id);
			    });

				row.appendChild(data1);
				row.appendChild(data2);
				data3.appendChild(input);
				row.appendChild(data3);
				tableBody.appendChild(row);			
			}
			catch (error) {
				
			}
			
		};
	
		function buscarAutor() {
            nombre = document.getElementById("nombreAutor").value;
            apellido = document.getElementById("apellidoAutor").value;
     	   location.href = "buscarAutorNombreYApellido.html?nombre="+ nombre+"&apellido="+apellido;
         };
         
	</script>
</head>
<body>
	<jsp:include page="Header.jsp" />
    
		<div class="container">
			<div class="card">
				<h1>Nuevo Libro</h1>
				<div class="card-body">
					<form action="index.html" method="post">
						<div class=" form-group row">
							<label for="isbn" class="col-sm-2 col-form-label">ISBN:</label>
							<div class="col-sm-7">
								<input class="form-control" type="number" name="isbn">
							</div>
						</div>
						
						<div class="form-group row">
							<label for="titulo" class="col-sm-2 col-form-label">Titulo:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="titulo" placeholder="Ingrese un titulo">
							</div>
						</div>
						
						<div class="form-group row">
							<label for="lastName" class="col-sm-2 col-form-label">Fecha de Lanzamiento:</label>
							<div class="col-sm-7">
								<input type="date" class="form-control" id="fechaLanzamiento" name="fechaLanzamiento">
							</div>
						</div>
						
						<div class="form-group row">
							<h3>    Autor</h3>
						</div>
						
						<div class="form-group row">
							<label for="nombreAutor" class="col-sm-2 col-form-label">Nombre:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="nombreAutor" name="nombreAutor" value="${autor.getNombre()}">
							</div>
													
						</div>
						<div class="form-group row"><label for="apellidoAutor" class="col-sm-2 col-form-label">Apellido:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="apellidoAutor" name="apellidoAutor"  value="${autor.getApellido()}">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-7">
								<input type="button" value="Buscar Autor"  onclick="buscarAutor()"	class="btn btn-primary"></input>
								<input type="button" value="Agregar Autor"  onclick="location.href = 'nuevoAutor.html';"	class="btn btn-primary"></input>
							</div>
						</div>
						
						<div class="form-group row">
							<label for="lastName" class="col-sm-2 col-form-label">Idioma:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="idioma">
							</div>
						</div>
						
						<div class="form-group row">
							<label for="lastName" class="col-sm-2 col-form-label">Sinopsis:</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="descripcion">
							</div>
						</div>
						
						<div class="form-group row">
							<label for="lastName" class="col-sm-2 col-form-label">Genero:</label>
							<div class="col-sm-7">
								<select id="genero" name="genero">
									<c:forEach items="${generos}" var="obj" >
		                            	<option value="${obj.getIdGenero()}">${obj.getDescripcion()}</option>													
									</c:forEach>
								</select>
								<input type="button" value="Agregar Genero"  onclick="AgregarGenero()"	class="btn btn-primary"></input>
							</div>
						</div>
						
						<div class="form-group row">
							<table class="table table-bordered table-hover" id="tabla">
							<thead>
								<tr>
									<td>Id</td>
									<td>Descripcion</td>
									<td>Acciones</td>
								</tr>
							</thead>
							<tbody id="tBody">
							</tbody>
							</table>
						</div>
						
						<button type="submit" class="btn btn-primary">Crear Libro</button>
					</form>
				</div>
			</div>
		</div>
</body>
</html>