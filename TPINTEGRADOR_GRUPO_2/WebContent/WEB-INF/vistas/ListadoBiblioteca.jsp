<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
        integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-12">
                <h1>Biblioteca</h1>
                
                <form action="../../form-result.php" method="post" target="_blank"></form>
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th scope="row">DATOS</th>
                            <th scope="col">ISBN</th>
                            <th scope="col">Fecha de Alta</th>
                            <th scope="col">Estado</th>
                            <th scope="col">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>0-7645-2641-3</td>
                            <td>21-07-2022</td>
                            <td>Prestado</td>
                            <td>
                              <button class="btn btn-danger" id="option2">Eliminar</button>
                              <button class="btn btn-primary modificar-biblioteca" data-id-biblioteca="uno">Modificar</button>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>0-1234-5678-3</td>
                            <td>22-12-2022</td>
                            <td>En Biblioteca</td>
                            <td>
                              <button class="btn btn-danger" id="option2">Eliminar</button>
                              <button class="btn btn-primary" id="option3">Modificar</button>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>0-9876-4321-3</td>
                            <td>14-07-2022</td>
                            <td>Prestado</td>
                            <td>
                              <button class="btn btn-danger" id="option2">Eliminar</button>
                              <button class="btn btn-primary" id="option3">Modificar</button>
                            </td>
                        </tr> 
                        <tr>
                            <th scope="row">4</th>
                            <td>0-1234-9876-3</td>
                            <td>06-11-2022</td>
                            <td>En Biblioteca</td>
                            <td>
                              <button class="btn btn-danger" id="option2">Eliminar</button>
                              <button class="btn btn-primary" id="option3">Modificar</button>
                            </td>
                        </tr> 
                        <tr>
                            <th scope="row">5</th>
                            <td>0-9876-1234-3</td>
                            <td>12-01-2022</td>
                            <td>Prestado</td>
                            <td>
                              <button class="btn btn-danger" id="option2">Eliminar</button>
                              <button class="btn btn-primary" id="option3">Modificar</button>
                            </td>
                        </tr> 
                    </tbody>
                </table>
                <div class="btn-group btn-group-toggle" data-toggle="buttons">
                    <label class="btn btn-secondary active">
                      <input type="radio" name="options" id="option1" autocomplete="off" checked> Lista completa.
                    </label>
                  </div>
                  <div class="btn-group">
                    <button type="radio" name="options" id="option3" autocomplete="off" class="btn btn-default dropdown-toggle"
                            data-toggle="dropdown">
                      Filtrar por <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                        <button type="button" class="btn btn-outline-secondary">Fecha de Alta</button>                    
                            <p>
                                <input type="search" name="busqueda">
                          
                              <input type="submit" value="Buscar">                     
                            </p>            
                      <li class="divider"></li>
                      <button type="button" class="btn btn-outline-secondary">Estado</button>
                      <p>
                        <input type="search" name="busqueda">
                  
                      <input type="submit" value="Buscar">             
                    </p>
                      <li class="divider"></li>
                      <button type="button" class="btn btn-outline-secondary">ISBN</button>
                      <p>
                        <input type="search" name="busqueda">
                  
                      <input type="submit" value="Buscar">       
                    </p>
                    </ul>
                  </div>
            </div>
        </div>
    </div>
</form>
    <!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLongTitle">Detalles del prestamo</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary">Save changes</button>
        </div>
      </div>
    </div>
  </div>


  <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
  $(document).ready(function() {
    $(document).on('click', ".modificar-biblioteca", function() {
      console.log($(this).data('id-biblioteca'));
      $.ajax({
        type: 'POST',
            url: 'modificarBiblioteca.html',
            success: function (data) {
               console.log(data);
            }
      });
    });

  });

</script>

</body>

</html>