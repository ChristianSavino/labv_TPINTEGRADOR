package web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import web.entidades.Biblioteca;
import web.entidades.Cliente;
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
	public String GuardarNuevoPrestamo(@SessionAttribute("biblioteca") Biblioteca biblioteca, @SessionAttribute("cliente") Cliente cliente, int idBiblioteca, int idCliente, String fecha, int cantidadDias) {
		//esto funciona, me queda pendiente la forma de notificar el exito o el fallo a traves del listado de biblioteca
		try {
			
			biblioteca = null;
			cliente = null;
	
			
			Cliente _cliente = iNegCliente.obtenerCliente(idCliente);
			Biblioteca _biblioteca = iNegBiblioteca.obtenerBiblioteca(idBiblioteca);
			Date fechaFormateada = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
			
			System.out.println("idcliente" + _cliente.getId());

			Prestamo nuevoPrestamo = new Prestamo();
			nuevoPrestamo.setBiblioteca(_biblioteca);
			nuevoPrestamo.setCliente(_cliente);
			nuevoPrestamo.setCantDias(cantidadDias);
			nuevoPrestamo.setFechaPrestamo(fechaFormateada);
			
			boolean res = iNegPrestamo.agregarPrestamo(nuevoPrestamo);
			System.out.println(res ? "nuevo prestamo guardado con exito" : "error al guardar nuevo prestamo");

			if(res) {
				//actualizo estado de biblioteca
				_biblioteca.setEstado(2);
				res = iNegBiblioteca.modificarBiblioteca(_biblioteca);
			}
			
			System.out.println(res ? "biblioteca actualizada con extio" : "error al actualizar biblioteca");
			
		
		} catch (Exception e) {
			 System.err.println(e.getMessage());
		}
		return "redirect:/listadoBiblioteca.html";
	}
}
