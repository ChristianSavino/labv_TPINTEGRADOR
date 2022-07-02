package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import web.entidades.Libro;
import web.negocioImp.NegLibro;

@Controller
public class LibroController {

	@Autowired
	@Qualifier("servicioLibro")
	private NegLibro iNegLibro;
	
	@RequestMapping("buscarLibroFiltro")
	public ModelAndView BuscarLibroNuevaBiblioteca(String isbn, String nombre) {
		ModelAndView mv = new ModelAndView();
		
		if(isbn.length() > 0 || nombre.length() > 0) {
			Libro l = iNegLibro.BuscarLibroNuevaBiblioteca(Integer.parseInt(isbn), nombre);
			mv.addObject("isbnLibro",l.getIsbn());
			mv.addObject("nombreLibro",l.getTitulo());
		}

		mv.setViewName("NuevaBiblioteca");
		return mv;
	}
	
}
