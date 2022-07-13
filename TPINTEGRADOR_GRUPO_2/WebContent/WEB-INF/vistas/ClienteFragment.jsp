
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<input type="hidden" value="${clienteFragmentAjax.getId()}" name="idCliente"
	id="idCliente"></input>

<label for="lastName" class="col-md-3 offset-4 col-form-label">DNI</label>
<div class="col-md-3">${clienteFragmentAjax.getDni()}</div>
<label for="lastName" class="col-md-3 offset-4 col-form-label">Nombre
</label>
<div class="col-md-3">${clienteFragmentAjax.getNombre()}</div>
<label for="lastName" class="col-md-3 offset-4 col-form-label">Apellido
</label>
<div class="col-md-3">${clienteFragmentAjax.getApellido()}</div>
