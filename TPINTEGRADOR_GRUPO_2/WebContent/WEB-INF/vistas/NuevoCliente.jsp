<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Biblioteca - Agregar Cliente</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>

<body>
 <header>
      <div>
        <nav>
          <ul class="enlaces-menu">
            <li href="#" type="button"><a>Biblioteca</a></li>
            <li href="#" type="button"><a>Prestamos</a></li>
            <li href="#" type="button"><a>Clientes</a></li>		
          </ul>
          <ul class="enlaces-menu">
            <li>
              <button class="btnCerrarSesion">Cerrar Sesi�n</button>
            </li>
          </ul>
        </nav>
      </div>
    </header>

    <div class="container">
        <h1>Agregar Cliente</h1>
        <div class="card">
            <div class="card-body">
                <form action="#" method="post">

                        <div class="row">

                            <label for="dni" class="col-md-3 offset-4 col-form-label">DNI: </label>
                            <div class="col-md-5"><input type="text" name="Dni" value="12123123"></div>
                            <label for="nombre" class="col-md-3 offset-4 col-form-label">Nombre: </label>
                            <div class="col-md-5"><input type="text" name="Nombre" value="Lionel"></div>
                            <label for="apellido" class="col-md-3 offset-4 col-form-label">Apellido: </label>
                            <div class="col-md-5"><input type="text" name="Apellido" value="Messi"></div>
                            <label for="sexo" class="col-md-3 offset-4 col-form-label">Sexo: </label>
                            <div class="col-md-5"><select name="Sexo" id="Sexo">
                            						<option value="F">Femenino</option>
                            						<option value="M">Masculino</option>
                            						</select></div>
                            <label for="nacionalidad" class="col-md-3 offset-4 col-form-label">Nacionalidad: </label>
                            <div class="col-md-5"><select name="Nacionalidad" id="Nacionalidad">
                            						<option value="A">Argentina</option>
                            						<option value="C">Chile</option>
                            						<option value="P">Per�</option>
                            						<option value="O">...</option>
                            						</select></div>
                            <label for="fnacimiento" class="col-md-3 offset-4 col-form-label">Fecha de Nacimiento: </label>
                            <div class="col-md-5"><input type="date" name="FNacimiento"></div>
                            <label for="localidad" class="col-md-3 offset-4 col-form-label">Localidad: </label>
                            <div class="col-md-5"><input type="text" name="Localidad" value="Rosario"></div>
                            <label for="direccion" class="col-md-3 offset-4 col-form-label">Direcci�n: </label>
                            <div class="col-md-5"><input type="text" name="Direccion" value="Calle Falsa 123"></div>
                            <label for="correo" class="col-md-3 offset-4 col-form-label">Correo Electr�nico: </label>
                            <div class="col-md-5"><input type="text" name="Correo" value="LeoMessi@mail.com"></div>
                            <label for="telefono" class="col-md-3 offset-4 col-form-label">Telefono: </label>
                            <div class="col-md-5"><input type="text" name="Telefono" value="03034567899"></div>
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