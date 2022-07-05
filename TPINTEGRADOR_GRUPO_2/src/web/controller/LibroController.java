package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import web.entidades.Libro;
import web.negocioImp.NegLibro;

@Controller
@SessionAttributes({"libro"})
public class LibroController {

	@Autowired
	@Qualifier("servicioLibro")
	private NegLibro iNegLibro;
	
	@RequestMapping("buscarLibroFiltro.html")
	public String BuscarLibroNuevaBiblioteca(ModelMap map, String isbn, String nombre) {	
		map.put("libro", null);
		if(isbn.length() > 0 || nombre.length() > 0) {
			Libro l = iNegLibro.BuscarLibroNuevaBiblioteca(isbn, nombre);
			map.put("libro",l);
		}
		return "redirect:/nuevaBiblioteca.html";
	}
	
}
