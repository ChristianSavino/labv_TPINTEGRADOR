<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Biblioteca - Agregar Cliente</title>
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
        <h1>Agregar Cliente</h1>
            <div class="card-body">
                <form action="agregarCliente.html" method="Post">
                        <div class="row">                            
                            <label for="dni" class="col-md-3 offset-4 col-form-label">DNI: </label>
                            <div><input type="text" name="dni" value=""></div>
                            <label for="nombre" class="col-md-3 offset-4 col-form-label">Nombre: </label>
                            <div><input type="text" name="nombre" value=""></div>
                            <label for="apellido" class="col-md-3 offset-4 col-form-label">Apellido: </label>
                            <div><input type="text" name="apellido" value=""></div>
                            <label for="sexo" class="col-md-3 offset-4 col-form-label">Sexo: </label>
                            <div><select name="sexo" id="sexo">
                            				<option value="">Seleccione Opci�n</option>
                            				<option value="F">Femenino</option>
                            				<option value="M">Masculino</option>
                            				</select></div>
                            <label for="nacionalidad" class="col-md-3 offset-4 col-form-label">Nacionalidad: </label>
                            <select name="nacionalidad">                    			
	                           <option value="">--</option>
	                            <c:forEach var="obj" items="${nacionalidades}">
		                            <option value="${obj.getIdNacionalidad()}">${obj.getDescripcion()}</option>
		                            console.log(${obj.getIdNacionalidad()})													
								</c:forEach>
							</select>
                            				                            			
                            <label for="fnacimiento" class="col-md-3 offset-4 col-form-label">Fecha de Nacimiento: </label>
                            <div><input type="date" name="fNacimiento"></div>
                            <label for="localidad" class="col-md-3 offset-4 col-form-label">Localidad: </label>
                            <div><input type="text" name="localidad" value=""></div>
                            <label for="direccion" class="col-md-3 offset-4 col-form-label">Direcci�n: </label>
                            <div><input type="text" name="direccion" value=""></div>
                            <label for="correo" class="col-md-3 offset-4 col-form-label">Correo Electr�nico: </label>
                            <div><input type="text" name="correo" value=""></div>
                            <label for="telefono" class="col-md-3 offset-4 col-form-label">Telefono: </label>
                            <div><input type="text" name="telefono" value=""></div>
                    </div>
                    
                    <div class="row">
                        <div class="col-md-8 offset-2">
                            <hr>
                        </div>
                    </div>
                    
                    <div class="row">
                        <button type="submit" class="btn btn-primary col-md-3 offset-4 ml-center">Guardar Cliente</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>