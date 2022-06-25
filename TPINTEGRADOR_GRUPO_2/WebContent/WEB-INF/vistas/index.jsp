<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Sistema de Biblioteca</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>

<body>
    <div class="container">
        <h1>Biblioteca</h1>
        <div class="card">
            <div class="card-body">
                <form action="login.html" method="get">

                    <div class=" form-group row">
                        <label for="lastName" class="col-sm-2 col-form-label">Usuario</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" name="username"
                                placeholder="Ingrese un nombre de usuario">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="lastName" class="col-sm-2 col-form-label">Contraseña</label>
                        <div class="col-sm-7">
                            <input type="password" class="form-control" name="password"
                                placeholder="Ingrese una contraseña">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Iniciar sesion</button>
                </form>
            </div>
        </div>
    </div>

</body>

</html>