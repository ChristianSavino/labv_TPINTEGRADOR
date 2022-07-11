<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Autor - Agregar Autor</title>
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
           function agregarAutor() {
               var nombre = document.getElementById("nombreAutor").value;
        	   var apellido = document.getElementById("apellidoAutor").value;
               var nacionalidad = document.getElementById("nacionalidad").value;
        	   var email = document.getElementById("emailAutor").value;
               location.href = "agregarAutor.html?nombre="+ nombreAutor+"&apellido="+apellidoAutor+ "&nacionalidad="+nacionalidad+"&email="+email;
           };
        </script>
</head>
<body>
	<jsp:include page="Header.jsp" />
    <div class="container">
        <div class="card">
        <h1>Agregar Autor</h1>
            <div class="card-body">
                <form action="agregarAutor.html" method="Post">
                        <div class="row">                           
                            <label for="nombre" class="col-md-3 offset-4 col-form-label">Nombre: </label>
                            <div><input type="text" name="nombre"></div>
                            <label for="apellido" class="col-md-3 offset-4 col-form-label">Apellido: </label>
                            <div><input type="text" name="apellido"></div>
                            <label for="email" class="col-md-3 offset-4 col-form-label">Email: </label>
                            <div><input type="text" name="email"></div>
                            <label for="nacionalidad" class="col-md-3 offset-4 col-form-label">Nacionalidad: </label>
                            <select name="nacionalidad">                    			
	                           <option value="">--</option>
	                            <c:forEach var="obj" items="${nacionalidades}">
		                            <option value="${obj.getIdNacionalidad()}">${obj.getDescripcion()}</option>
		                            console.log(${obj.getIdNacionalidad()})													
								</c:forEach>
							</select>
                    </div>                    
                    <div class="row">
                        <div class="col-md-8 offset-2">
                            <hr>
                        </div>
                    </div>                    
                    <div class="row">
                        <button type="submit" class="btn btn-primary col-md-3 offset-4 ml-center" >Guardar Autor</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>