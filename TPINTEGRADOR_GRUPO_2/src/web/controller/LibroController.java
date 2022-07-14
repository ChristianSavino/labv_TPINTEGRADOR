package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import web.entidades.Cliente;
import web.entidades.Libro;
import web.negocioImp.NegLibro;

@Controller
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
	
	
	@RequestMapping(value= "listarNuevosLibrosFiltroAjax.html",
			method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView ListarNuevosLibrosFiltroAjax(String isbn, String nombre) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("libros", iNegLibro.listarNuevoLibroTabla(isbn.length() == 0 ? 0 : Integer.parseInt(isbn), nombre));
		mv.setViewName("ListadoLibrosFragment");
		return mv;
	}
	
	@RequestMapping("obtenerLibroNuevaBibliotecaFragment.html")
	public ModelAndView ObtenerLibroNuevaBibliotecaFragment(int isbn) {
		try {
			Libro l = iNegLibro.obtenerLibro(isbn);
			ModelAndView mv = new ModelAndView();
			mv.addObject("libroFragmentAjax", l);
			mv.setViewName("LibroFragment");
			return mv;
		} catch (Exception e) {
			System.out.println("<<MENSAJE ERROR>>" + e.getMessage());
			return null;
		}		
	}
	
	
	@RequestMapping("agregarLibro.html")
	@ResponseBody
	public ModelAndView AgregarNuevoLibro(String isbn, String titulo, String fechaLanzamiento, String idAutor, String descripcion,String idioma, String generos, String cantidadPaginas) {
		iNegLibro.AgregarLibro(isbn,titulo,fechaLanzamiento,idAutor,descripcion,idioma,generos,cantidadPaginas);
		Libro l = iNegLibro.obtenerLibro(Integer.parseInt(isbn));
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("libro", l);
		mv.setViewName("NuevaBiblioteca");
		return mv;
	}
}
