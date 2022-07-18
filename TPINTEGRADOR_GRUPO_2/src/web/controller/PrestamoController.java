package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import web.entidades.Biblioteca;
import web.entidades.Cliente;
import web.entidades.Libro;
import web.entidades.Prestamo;
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
	
	@RequestMapping("listadoPrestamos.html")
	@ResponseBody
	public ModelAndView PaginaPrestamos(
			@RequestParam(defaultValue = "") String fechaAlta, 
			@RequestParam(defaultValue = "") String isbn, 
			@RequestParam(defaultValue = "") String titulo, 
			@RequestParam(defaultValue = "") String nombreAutor, 
			@RequestParam(defaultValue = "") String apellidoAutor, 
			@RequestParam(defaultValue = "") String nombreCliente, 
			@RequestParam(defaultValue = "") String apellidoCliente, 
			@RequestParam(defaultValue = "") String dniCliente) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("prestamos",iNegPrestamo.listarPrestamosTabla(fechaAlta, isbn, titulo, nombreAutor, apellidoAutor, nombreCliente, apellidoCliente, dniCliente));

		mv.setViewName("ListadoPrestamos");
		return mv;
	}
	
	@RequestMapping("finalizarPrestamo.html")
	public String FinalizarPrestamo(int idPrestamo) {
		try {
			
			Prestamo p = iNegPrestamo.obtenerPrestamo(idPrestamo);
			iNegPrestamo.eliminarPrestamo(p);
			Biblioteca b = iNegBiblioteca.obtenerBiblioteca(p.getBiblioteca().getId());
			b.setEstado(1);
			iNegBiblioteca.modificarBiblioteca(b);
			
		} catch (Exception e) {
			System.out.println("<<MENSAJE ERROR>>" + e.getMessage());
			
		}		
		return "redirect:/listadoPrestamos.html";
	}
}
