package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import web.entidades.Libro;
import web.negocioImp.NegLibro;

@Controller
public class LibroController {

	@Autowired
	@Qualifier("servicioLibro")
	private NegLibro iNegLibro;
	
	@RequestMapping("buscarLibroFiltro.html")
	public String BuscarLibroNuevaBiblioteca(ModelMap map, String isbn, String nombre) {	
		try {
			map.put("libro", null);
			if(isbn.length() > 0 || nombre.length() > 0) {
				Libro l = iNegLibro.BuscarLibroNuevaBiblioteca(isbn, nombre);
				map.put("libro",l);
			}
		} catch (Exception e) {
			return "redirect:/avisoError.html?tituloPagina="+"Buscar Libro Filtro"+"&tituloMensaje="+"Buscar Libro Filtro"+"&mensaje="+e.toString()
			+"&mensajeBoton="+"Volver a Listado Biblioteca"+"&paginaARedireccionar="+"listadoBiblioteca.html";
		}

		return "redirect:/nuevaBiblioteca.html";
	}
	
	
	@RequestMapping(value= "listarNuevosLibrosFiltroAjax.html",
			method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView ListarNuevosLibrosFiltroAjax(String isbn, String nombre) {
		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("libros", iNegLibro.listarNuevoLibroTabla(isbn.length() == 0 ? 0 : Integer.parseInt(isbn), nombre));
			mv.setViewName("ListadoLibrosFragment");
		} catch (Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Listar Libros", "Listar Libros Ajax", e.toString(), 
					"Volver a Listado Biblioteca", "listadoBiblioteca.html", AvisoController.TipoAviso.Error);
		}

		return mv;
	}
	
	@RequestMapping("obtenerLibroNuevaBibliotecaFragment.html")
	public ModelAndView ObtenerLibroNuevaBibliotecaFragment(int isbn) {
		ModelAndView mv = new ModelAndView();
	
		try {
			Libro l = iNegLibro.obtenerLibro(isbn);			
			mv.addObject("libroFragmentAjax", l);
			mv.setViewName("LibroFragment");
		} catch (Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Obtener Libro", "Obtener Libro Ajax", e.toString(), 
					"Volver a Listado Biblioteca", "listadoBiblioteca.html", AvisoController.TipoAviso.Error);
		}	
		
		return mv;
	}
	
	
	@RequestMapping("agregarLibro.html")
	@ResponseBody
	public ModelAndView AgregarNuevoLibro(String isbn, String titulo, String fechaLanzamiento, String idAutor, String descripcion,String idioma, String generos, String cantidadPaginas) {
		ModelAndView mv = new ModelAndView();
		
		try {
			System.out.println(isbn + "|" + titulo + "|" + fechaLanzamiento + "|" + idAutor + "|" + descripcion + "|" + idioma + "|" + generos + "|" + cantidadPaginas);
			boolean estado = iNegLibro.AgregarLibro(isbn,titulo,fechaLanzamiento,idAutor,descripcion,idioma,generos,cantidadPaginas);
			if (!estado) {
				throw new Exception("Error al intentar guardar el nuevo libro");
			}
			Libro l = iNegLibro.obtenerLibro(Integer.parseInt(isbn));
			
			if (l == null) {
				throw new Exception("Error al intentar recuperar el nuevo libro");

			}
			
			mv.addObject("libro", l);
			mv.setViewName("NuevaBiblioteca");
		} catch (Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Nuevo Libro", "Agregar Nuevo Libro", e.toString(), 
					"Volver a Listado Biblioteca", "listadoBiblioteca.html", AvisoController.TipoAviso.Error);
		}
		
		return mv;
	}
}
