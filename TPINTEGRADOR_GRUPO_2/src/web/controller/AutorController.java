package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import web.entidades.Autor;
import web.entidades.Cliente;
import web.entidades.Nacionalidad;
import web.negocioImp.NegAutor;

@Controller
public class AutorController {
	
	@Autowired
	@Qualifier("servicioAutor")
	private NegAutor iNegAutor;	
	
	@ModelAttribute("autor")
	public Autor getAutor() {
		return new Autor();
	}
	
	@RequestMapping(value= "obtenerAutor.html",
			method=RequestMethod.POST)
	@ResponseBody
	public String obtenerAutor(int idAutor) {
		System.out.println(idAutor);
		Autor autor = iNegAutor.obtenerAutor(idAutor);
		return "{idCliente:"+autor.getIdAutor()+"}";
	}
	
	@RequestMapping("agregarAutor.html")
	public String AgregarAutor(ModelMap map,@ModelAttribute("autor") Autor autor ,String nombre, String apellido, String nacionalidad, String email) {
		boolean estado = iNegAutor.agregarAutor(nombre, apellido, Integer.parseInt(nacionalidad), email);
		
		String redirect = "";
		if(estado) {
			redirect = "redirect:/nuevoLibro.html";
			autor = iNegAutor.obtenerAutorNombreYApellido(nombre, apellido);
			map.put("autor",autor);
		}
		else
			redirect ="redirect:/avisoError.html?tituloPagina="+"Nueva Biblioteca"+"&tituloMensaje="+"Guardar Nueva Biblioteca"+"&mensaje=Error al Obtener Autor"
			+"&mensajeBoton="+"Volver a Listado Biblioteca"+"&paginaARedireccionar"+"listadoBiblioteca.html";
		return redirect;
	}
	
	@RequestMapping("buscarAutorNombreYApellido.html")
	public String ObtenerAutorNombreYApellido(ModelMap map,@ModelAttribute("autor") Autor autor,String nombre,String apellido) {
		try {
			autor = iNegAutor.obtenerAutorNombreYApellido(nombre, apellido);
			map.put("autor", autor);
			return "redirect:/nuevoLibro.html";
		} catch (Exception e) {
			return "redirect:/avisoError.html?tituloPagina="+"Nuevo Libro"+"&tituloMensaje="+"Obtener Autor"+"&mensaje="+e.toString()
			+"&mensajeBoton="+"Volver a Listado Biblioteca"+"&paginaARedireccionar"+"listadoBiblioteca.html";
		}

	}
	
	@RequestMapping("listarAutorFiltroAjax.html")
	@ResponseBody
	public ModelAndView ListarAutorFiltroAjax(String nacionalidad, String nombre,String apellido) {
		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("autores", iNegAutor.listarAutorTabla(nacionalidad, nombre, apellido));
			mv.setViewName("ListadoAutoresFragment");
		} catch (Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Obtener Autor", "Obtener Autor Ajax", e.toString(), 
					"Volver a Listado Biblioteca", "listadoBiblioteca.html", AvisoController.TipoAviso.Error);
		}

		return mv;
	}
	
	@RequestMapping("eliminarAutor.html")
	public String eliminarAutor(@RequestParam(value = "id", required = false) int id){
		try {
			Autor autor = iNegAutor.obtenerAutor(id);
			iNegAutor.eliminarAutor(autor);
		}
		catch(Exception e) {
			return "redirect:/avisoError.html?tituloPagina="+"Eliminar Autor"+"&tituloMensaje="+"Eliminar Autor"+"&mensaje="+e.toString()
			+"&mensajeBoton="+"Volver a Listado Biblioteca"+"&paginaARedireccionar"+"listadoBiblioteca.html";
		}
		return "redirect:/listadoBiblioteca.html";
	}
	
	@RequestMapping("obtenerAutorNuevoLibroFragment.html")
	public ModelAndView ObtenerAutorNuevoLibroFragment(int idAutor) {
		ModelAndView mv = new ModelAndView();
		
		try {
			Autor autor = iNegAutor.obtenerAutor(idAutor);
			
			mv.addObject("autorFragmentAjax", autor);
			mv.setViewName("AutorFragment");

		} catch (Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Obtener Autor", "Obtener Autor Ajax", e.toString(), 
					"Volver a Listado Biblioteca", "listadoBiblioteca.html", AvisoController.TipoAviso.Error);
		}	
		
		return mv;
	}
}
