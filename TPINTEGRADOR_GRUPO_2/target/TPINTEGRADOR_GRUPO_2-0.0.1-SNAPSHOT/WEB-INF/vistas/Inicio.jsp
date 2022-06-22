<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>Agregar persona</h3>

<form action="agregarPersona.html" method="get">
	Ingrese dni: <input type="text" name="txtDni">
	Ingrese nombre: <input type="text" name="txtNombre">
	Ingrese apellido:  <input type="text" name="txtApellido">
	<input type="submit" name="btnAgregarPersona" value="Aceptar">
</form>

${estadoAgregarPersona}

</body>
</html>