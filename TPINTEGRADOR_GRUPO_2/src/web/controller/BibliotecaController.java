package web.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import web.entidades.Biblioteca;
import web.entidades.Libro;
import web.negocioImp.NegBiblioteca;

@Controller
public class BibliotecaController {
	
	@Autowired
	@Qualifier("servicioBiblioteca")
	private NegBiblioteca iNegBiblioteca;
	
	@RequestMapping("listarBibliotecaFiltro.html")
	@ResponseBody
	public ModelAndView ListarTodasBibliotecasFiltro(String fechaAlta,String estado, String isbn) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("bibliotecas",iNegBiblioteca.listarBibliotecasTabla(fechaAlta,estado,isbn));
		mv.setViewName("ListadoBiblioteca");
		return mv;
	}
	
	@RequestMapping("agregarBiblioteca.html")
	public ModelAndView AgregarBiblioteca(int isbn, String fechaAlta ) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	
	@RequestMapping("nuevoPrestamo.html")
	public ModelAndView PaginaNuevaBiblioteca(int idBiblioteca) {
		
		Biblioteca libro = iNegBiblioteca.obtenerLibro(idBiblioteca);
		System.out.println(libro.toString());
		ModelAndView mv = new ModelAndView();
		mv.addObject("libro", libro);
		mv.setViewName("NuevoPrestamo");
		return mv;
	}
}
