
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<input type="hidden" value="${bibliotecaFragmentAjax.getId()}" name="idBiblioteca" id="idBiblioteca"></input>


<label for="lastName" class="col-md-3 offset-3 col-form-label">ISBN</label>
<div class="col-md-3">${bibliotecaFragmentAjax.getLibro().getIsbn()}</div>
<label for="lastName" class="col-md-3 offset-3 col-form-label">Titulo
</label>
<div class="col-md-3">${bibliotecaFragmentAjax.getLibro().getTitulo()}</div>
<label for="lastName" class="col-md-3 offset-3 col-form-label">Autor
</label>
<div class="col-md-3">${bibliotecaFragmentAjax.getLibro().getAutor().getNombre()} ${bibliotecaFragmentAjax.getLibro().getAutor().getApellido()}</div>
