<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar libro a Biblioteca</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="css/Main.css" />
        <script type="text/javascript">
           function buscarLibro() {
               isbn = document.getElementById("isbn").value;
               nombre = document.getElementById("nombre").value;
        	   location.href = "buscarLibroFiltro.html?isbn="+ isbn+"&nombre="+nombre;
            };

           function agregarBiblioteca() {
               isbn = document.getElementById("isbn").value;
               fechaAlta = document.getElementById("fechaAlta").value;
               location.href = "agregarBiblioteca.html?isbn="+ isbn+"&fechaAlta="+fechaAlta;
           };
        </script>
</head>

<body>
	<jsp:include page="Header.jsp" />
	<div class="container">
		<div class="card">
			<h1>Nueva Biblioteca</h1>
			<div class="card-body">
				<form action="#" method="post">

					<div class="row">
						<div class="col-md-5">
							<label>Libro: </label> 
							<input type="text" id="isbn" placeholder="isbn" value="${isbnLibro}"/>
							<input type="text" id="nombre" placeholder="nombre libro" value="${nombreLibro}"/>
							<input type="button" id="botonBusqueda" value="Buscar Libro" onclick="buscarLibro()" class="btn btn-primary"></input>
							<input type="button" id="botonAgregar" value="Nuevo Libro" onclick="location.href = 'nuevoLibro.html';" class="btn btn-primary"></input>
						</div>
						<div class="col-md-5">
							<label>Fecha de Alta: </label> <input type="date" id="fechaAlta">
						</div>
					</div>

					<div class="row">
						<input type="button" id="botonAgregarBiblio" value="Agregar Biblioteca" onclick="agregarBiblioteca()" class="btn btn-primary col-md-3 offset-4 ml-center"></input>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>