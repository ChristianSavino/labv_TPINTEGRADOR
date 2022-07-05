package web.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import web.entidades.Biblioteca;
import web.entidades.Cliente;
import web.negocioImp.NegBiblioteca;
import web.negocioImp.NegCliente;

@Controller
public class BibliotecaController {
	
	@Autowired
	@Qualifier("servicioBiblioteca")
	private NegBiblioteca iNegBiblioteca;
	
	@Autowired
	@Qualifier("servicioCliente")
	private NegCliente iNegCliente;
	
	@RequestMapping("listarBibliotecaFiltro.html")
	@ResponseBody
	public ModelAndView ListarTodasBibliotecasFiltro(String fechaAlta,String estado, String isbn,String titulo) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("bibliotecas",iNegBiblioteca.listarBibliotecasTabla(fechaAlta,estado,isbn,titulo));
		mv.setViewName("ListadoBiblioteca");
		return mv;
	}
	
	@RequestMapping("agregarBiblioteca.html")
	public ModelAndView AgregarBiblioteca(int isbn, String fechaAlta ) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	
	@RequestMapping("nuevoPrestamo.html")
	public ModelAndView nuevoPrestamo(int idBiblioteca) {
			
		Biblioteca libro = iNegBiblioteca.obtenerLibro(idBiblioteca);
		System.out.println(libro.toString());
		ModelAndView mv = new ModelAndView();
		mv.addObject("libro", libro);
		mv.addObject("idBiblioteca", idBiblioteca);
		mv.setViewName("NuevoPrestamo");
		return mv;
	}
	@RequestMapping("nuevoPrestamo2.html")
	public ModelAndView nuevoPrestamo2(int idBiblioteca, int idCliente) {
		
		Cliente cliente = iNegCliente.obtenerCliente(idCliente);
		Biblioteca libro = iNegBiblioteca.obtenerLibro(idBiblioteca);
		System.out.println(libro.toString());
		ModelAndView mv = new ModelAndView();
		mv.addObject("libro", libro);
		mv.addObject("cliente", cliente);
		mv.addObject("idBiblioteca", idBiblioteca);
		mv.setViewName("NuevoPrestamo");
		return mv;
	}
}
