<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Biblioteca - Modificar Biblioteca</title>
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
			<h1>Modificar Biblioteca</h1>
			<div class="card-body">
				<form action="modificarBiblioteca.html" method="get">
					<h3>Biblioteca: </h3>
						<label class="col-md-2">ID Biblioteca: </label>
						<input type="text" name="id" value="${biblioteca.getId()}" name="idBiblioteca" id="idBiblioteca" readonly></input>
						<div class="row">
							<div class="col-md-11 offset-15">
								<hr>
							</div>
						</div>
							<h3>Libro: </h3>
							<br>
							<label>ISBN: </label>
							<input type="text" name=""isbn id="isbn" value="${biblioteca.getLibro().getIsbn()}" readonly/>
							<label>Titulo: </label>
							<input type="text" name="titulo" id="titulo" value="${biblioteca.getLibro().getTitulo()}" readonly/>
							<label>Estado: </label>
							<input type="text" name="estado" value="${biblioteca.isEstado()}" readonly/>
                            <label>Fecha de Alta: </label> <input type="text" name="fechaAlta" id="fechaAlta" value="${biblioteca.getFechaLanzamiento()}">
							<br><br>
						<div class="row">
                        <button type="submit" class="btn btn-primary col-md-3 offset-4 ml-center">Modificar Biblioteca</button>
                    </div>					
					</form>
				</div>
			</div>
		</div>		
	</body>
</html>