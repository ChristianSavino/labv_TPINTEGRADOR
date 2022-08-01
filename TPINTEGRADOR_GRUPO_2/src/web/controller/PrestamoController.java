package web.controller;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import web.controller.AvisoController.TipoAviso;
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
	public ModelAndView GuardarNuevoPrestamo(int idBiblioteca, int idCliente, String fecha, int cantidadDias) {
		ModelAndView mv = new ModelAndView();
		
		try {
			Cliente cliente = iNegCliente.obtenerCliente(idCliente);
			Biblioteca biblioteca = iNegBiblioteca.obtenerBiblioteca(idBiblioteca);
			boolean res = iNegPrestamo.agregarPrestamo(biblioteca,cliente,cantidadDias,fecha);
			
			//Fecha devolucion
			Calendar c = Calendar.getInstance();
			c.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
			c.add(Calendar.DAY_OF_MONTH, cantidadDias);
			
			String date = new SimpleDateFormat("dd-MM-yyyy").format(c.getTime());
			
			if (res)
				mv = AvisoController.SeteoDeAviso(mv, "Nuevo Prestamo", "Alta Nuevo Prestamo", "Se ha dado de alta el prestamo correctamente - Fecha de devolucion: " + date, "Volver Listado Prestamo", 
						"listadoPrestamos.html", TipoAviso.Correcto);
			else
				mv = AvisoController.SeteoDeAviso(mv, "Nuevo Prestamo", "Alta Nuevo Prestamo", "Error interno al crear nuevo prestamo", "Volver Listado Prestamo", 
						"listadoPrestamos.html", TipoAviso.Error);
			c = null;
			
		} catch (Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Nuevo Prestamo", "Alta Nuevo Prestamo", e.toString(), "Volver Listado Prestamo", 
					"listadoPrestamos.html", TipoAviso.Error);
		}
		return mv;
	}
	
	@RequestMapping("listadoPrestamos.html")
	@ResponseBody
	public ModelAndView PaginaPrestamos(@RequestParam(defaultValue = "") String fechaAlta, @RequestParam(defaultValue = "") String isbn, @RequestParam(defaultValue = "") String titulo, @RequestParam(defaultValue = "") String nombreAutor, @RequestParam(defaultValue = "") String apellidoAutor, @RequestParam(defaultValue = "") String nombreCliente, @RequestParam(defaultValue = "") String apellidoCliente, @RequestParam(defaultValue = "") String dniCliente, @RequestParam(defaultValue = "") String estado) {
		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("prestamos",iNegPrestamo.listarPrestamosTabla(fechaAlta, isbn, titulo, nombreAutor, apellidoAutor, nombreCliente, apellidoCliente, dniCliente, estado));
			mv.setViewName("ListadoPrestamos");
		} catch (Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Listar Prestamos", "Listar Prestamos", e.toString(), 
					"Volver a Listado Biblioteca", "listadoBiblioteca.html", AvisoController.TipoAviso.Error);
		}
		
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
			return "redirect:/listadoPrestamos.html";
		} catch (Exception e) {
			return "redirect:/avisoError.html?tituloPagina="+"Finalizar Prestamo"+"&tituloMensaje="+"Finalizar Prestamo"+"&mensaje="+e.toString()
			+"&mensajeBoton="+"Volver a Listado Biblioteca"+"&paginaARedireccionar="+"listadoBiblioteca.html";
			
		}		
	}
}
