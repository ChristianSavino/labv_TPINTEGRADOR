
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<input type="hidden" value="${libroFragmentAjax.getIsbn()}" name="isbn"
	id="idLibro"></input>

<label for="lastName" class="col-md-3 offset-3 col-form-label">ISBN</label>
<div class="col-md-3">${libroFragmentAjax.getIsbn()}</div>
<label for="lastName" class="col-md-3 offset-3 col-form-label">Titulo
</label>
<div class="col-md-3">${libroFragmentAjax.getTitulo()}</div>
<label for="lastName" class="col-md-3 offset-3 col-form-label">Autor
</label>
<div class="col-md-3">${libroFragmentAjax.getAutor().getNombre()} ${libroFragmentAjax.getAutor().getApellido()}</div>
