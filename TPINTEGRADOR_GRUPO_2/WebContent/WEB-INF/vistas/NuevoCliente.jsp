<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
                <form action="#" method="post">

                        <div class="row">
                            
                            <label for="dni" class="col-md-3 offset-4 col-form-label">DNI: </label>
                            <div><input type="text" name="Dni" value=""></div>
                            <label for="nombre" class="col-md-3 offset-4 col-form-label">Nombre: </label>
                            <div><input type="text" name="Nombre" value=""></div>
                            <label for="apellido" class="col-md-3 offset-4 col-form-label">Apellido: </label>
                            <div><input type="text" name="Apellido" value=""></div>
                            <label for="sexo" class="col-md-3 offset-4 col-form-label">Sexo: </label>
                            <div><select name="Sexo" id="Sexo">
                            				<option value="">Seleccione Opción</option>
                            				<option value="F">Femenino</option>
                            				<option value="M">Masculino</option>
                            				</select></div>
                            <label for="nacionalidad" class="col-md-3 offset-4 col-form-label">Nacionalidad: </label>
                            <!--<div><select name="Nacionalidad" id="idNacionalidad">
                            				<option value="">Seleccione Opción</option>
                            				<option value="A">Argentina</option>
                            				<option value="C">Chile</option>
                            				<option value="P">Perú</option>
                            				<option value="O">...</option>
                            				</select></div>-->
                            				
                            <select field="{nacionalidad}">
                            
                            <option value="">--</option>
                            <option each="data :${ListadoNacionalidades}"
                            		value="${data.idNacionalidad}">${data.descripcion}</option>
                            		<!-- th:text="${data.descripcion}"-->
                            
                            </select>
                            				                            			
                            <label for="fnacimiento" class="col-md-3 offset-4 col-form-label">Fecha de Nacimiento: </label>
                            <div><input type="date" name="FNacimiento"></div>
                            <label for="localidad" class="col-md-3 offset-4 col-form-label">Localidad: </label>
                            <div><input type="text" name="Localidad" value=""></div>
                            <label for="direccion" class="col-md-3 offset-4 col-form-label">Dirección: </label>
                            <div><input type="text" name="Direccion" value=""></div>
                            <label for="correo" class="col-md-3 offset-4 col-form-label">Correo Electrónico: </label>
                            <div><input type="text" name="Correo" value=""></div>
                            <label for="telefono" class="col-md-3 offset-4 col-form-label">Telefono: </label>
                            <div><input type="text" name="Telefono" value=""></div>
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