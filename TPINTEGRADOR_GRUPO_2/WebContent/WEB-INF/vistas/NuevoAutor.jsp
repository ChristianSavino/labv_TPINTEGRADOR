<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
               nombre = document.getElementById("nombreAutor").value;
        	   apellido = document.getElementById("apellidoAutor").value;
               nacionalidad = document.getElementByClassName("nacionalidad").value;
        	   email = document.getElementById("emailAutor").value;
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
                <form action="#" method="post">
                        <div class="row">                           
                            <label for="nombre" class="col-md-3 offset-4 col-form-label">Nombre: </label>
                            <div><input type="text" name="nombre" id="nombreAutor" value=""></div>
                            <label for="apellido" class="col-md-3 offset-4 col-form-label">Apellido: </label>
                            <div><input type="text" name="apellido" id="apellidoAutor" value=""></div>
                            <label for="email" class="col-md-3 offset-4 col-form-label">Email: </label>
                            <div><input type="text" name="email" id="emailAutor" value=""></div>
                            <label for="nacionalidad" class="col-md-3 offset-4 col-form-label">Nacionalidad: </label>
                            <select field="{nacionalidad}">                    			
	                            <c:forEach var="obj" items="${nacionalidad}">
		                            <option value="">--</option>
		                            <option class="nacionalidad" value="${obj[1]" id="${obj[1]">{obj[1]}</option>													
								</c:forEach>
							</select>
                    </div>                    
                    <div class="row">
                        <div class="col-md-8 offset-2">
                            <hr>
                        </div>
                    </div>                    
                    <div class="row">
                        <button type="submit" class="btn btn-primary col-md-3 offset-4 ml-center"  onclick="agregarAutor()">Guardar Autor</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>