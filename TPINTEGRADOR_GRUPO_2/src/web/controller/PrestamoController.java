package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import web.entidades.Biblioteca;
import web.entidades.Cliente;
import web.negocioImp.NegBiblioteca;
import web.negocioImp.NegCliente;
import web.negocioImp.NegPrestamo;

@Controller
public class PrestamoController {
	
	@Autowired
	@Qualifier("servicioBiblioteca")
	private NegBiblioteca iNegBiblioteca;
	
	@Autowired
	@Qualifier("servicioCliente")
	private NegCliente iNegCliente;
	
	@Autowired
	@Qualifier("servicioPrestamo")
	private NegPrestamo iNegPrestamo;
	
	@RequestMapping(value="guardarNuevoPrestamo.html")
	public String GuardarNuevoPrestamo(int idBiblioteca, int idCliente, String fecha, int cantidadDias) {
		try {
			Cliente cliente = iNegCliente.obtenerCliente(idCliente);
			Biblioteca biblioteca = iNegBiblioteca.obtenerBiblioteca(idBiblioteca);
			boolean res = iNegPrestamo.agregarPrestamo(biblioteca,cliente,cantidadDias,fecha);
		
		} catch (Exception e) {
			 System.err.println(e.getMessage());
		}
		return "redirect:/listadoBiblioteca.html";
	}
}
