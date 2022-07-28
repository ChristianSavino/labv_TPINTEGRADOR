package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import web.entidades.Autor;
import web.entidades.Biblioteca;
import web.entidades.Cliente;
import web.negocioImp.NegBiblioteca;

@Controller
public class BibliotecaController {

	@Autowired
	@Qualifier("servicioBiblioteca")
	private NegBiblioteca iNegBiblioteca;

	@ModelAttribute("biblioteca")
	public Biblioteca getBiblioteca() {
		return new Biblioteca();
	}

	@RequestMapping("listarBibliotecaFiltro.html")
	@ResponseBody
	public ModelAndView ListarTodasBibliotecasFiltro(String fechaAlta,String estado, String isbn,String titulo) {
		ModelAndView mv = new ModelAndView();

		try {
			mv.addObject("bibliotecas",iNegBiblioteca.listarBibliotecasTabla(fechaAlta,estado,isbn,titulo));
			mv.setViewName("ListadoBiblioteca");	
		} catch (Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Obtener Biblioteca", "Obtener Biblioteca Filtro", e.toString(), 
					"Volver a Listado Biblioteca", "listadoBiblioteca.html", AvisoController.TipoAviso.Error);
		}

		return mv;
	}

	@RequestMapping("guardarNuevaBiblioteca.html")
	public String GuardarNuevaBiblioteca(String isbn, String fechaAlta ) {

		try {
			boolean estado = iNegBiblioteca.agregarBiblioteca(Integer.parseInt(isbn), fechaAlta);
			if(!estado)
				return "redirect:/avisoError.html?tituloPagina="+"Nueva Biblioteca"+"&tituloMensaje="+"Guardar Nueva Biblioteca"+"&mensaje=No se guardo correctamente la biblioteca"
				+"&mensajeBoton="+"Volver a Listado Biblioteca"+"paginaARedireccionar="+"listadoBiblioteca.html";
		}catch(Exception e) {
			return "redirect:/avisoError.html?tituloPagina="+"Nueva Biblioteca"+"&tituloMensaje="+"Guardar Nueva Biblioteca"+"&mensaje="+e.toString()
			+"&mensajeBoton="+"Volver a Listado Biblioteca"+"paginaARedireccionar="+"listadoBiblioteca.html";
		}

		return  "redirect:/listadoBiblioteca.html";
	}

	@RequestMapping(value="obtenerBibliotecaDesdeLista.html")
	@ResponseBody
	public ModelAndView obtenerBibliotecaDesdeLista(@RequestParam(value = "idBiblioteca", required = false) int idBiblioteca) {
		ModelAndView mv = new ModelAndView();

		try {
			Biblioteca libro = iNegBiblioteca.obtenerBiblioteca(idBiblioteca);

			mv.addObject("libro", libro);
			mv.setViewName("NuevoPrestamo");


		} catch (Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Obtener Biblioteca", "Obtener Biblioteca Desde Lista", e.toString(), 
					"Volver a Listado Biblioteca", "listadoBiblioteca.html", AvisoController.TipoAviso.Error);
			return null;
		}

		return mv;
	}

	@RequestMapping("eliminarBiblioteca.html")
	public String eliminarBiblioteca(@RequestParam(value = "id", required = false) int id){
		try {
			Biblioteca biblioteca = iNegBiblioteca.obtenerBiblioteca(id);
			iNegBiblioteca.eliminarBiblioteca(biblioteca);
			return "redirect:/listadoBiblioteca.html";
		}
		catch(Exception e) {
			return "redirect:/avisoError.html?tituloPagina="+"Eliminar Biblioteca"+"&tituloMensaje="+"Eliminar Biblioteca"+"&mensaje="+e.toString()
			+"&mensajeBoton="+"Volver a Listado Biblioteca"+"paginaARedireccionar="+"listadoBiblioteca.html";
		}

	}

	@RequestMapping("modificarBiblioteca.html")
	public String modificarBiblioteca(@ModelAttribute("biblioteca") Biblioteca biblioteca, int id, int estado, String fechaAlta) {
		try {
			boolean est = iNegBiblioteca.modificarBiblioteca(id, estado,fechaAlta);
			if(est)
				return "redirect:/listadoBiblioteca.html";
			else
				return "redirect:/avisoError.html?tituloPagina="+"Modificar Biblioteca"+"&tituloMensaje="+"Modificar Biblioteca"+"&mensaje="+"Error al modificar Biblioteca"
				+"&mensajeBoton="+"Volver a Listado Biblioteca"+"paginaARedireccionar="+"listadoBiblioteca.html";
		} catch (Exception e) {
			return "redirect:/avisoError.html?tituloPagina="+"Modificar Biblioteca"+"&tituloMensaje="+"Modificar Biblioteca"+"&mensaje="+e.toString()
			+"&mensajeBoton="+"Volver a Listado Biblioteca"+"paginaARedireccionar="+"listadoBiblioteca.html";
		}


	}

	@RequestMapping("listarBibliotecaFiltroAjax.html")
	@ResponseBody
	public ModelAndView ListarBibliotecaFiltroAjax(String fechaAlta,String estado, String isbn,String titulo) {
		ModelAndView mv = new ModelAndView();

		try {
			mv.addObject("bibliotecas",iNegBiblioteca.listarBibliotecasTabla(fechaAlta,estado,isbn,titulo));
			mv.setViewName("ListadoBibliotecaFragment");
		} catch (Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Listar Biblioteca", "Listar Biblioteca Desde Filtro", e.toString(), 
					"Volver a Listado Biblioteca", "listadoBiblioteca.html", AvisoController.TipoAviso.Error);
		}

		return mv;
	}

	@RequestMapping(value="obtenerBibliotecaNuevoPrestamoFragment.html")
	@ResponseBody
	public ModelAndView ObtenerBibliotecaNuevoPrestamoFragment(ModelMap map,int idBiblioteca) {
		ModelAndView mv = new ModelAndView();

		try {
			Biblioteca libro = iNegBiblioteca.obtenerBiblioteca(idBiblioteca);
			map.put("biblioteca", libro);

			mv.addObject("bibliotecaFragmentAjax", libro);
			mv.setViewName("BibliotecaFragment");
		} catch (Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Obtener Biblioteca", "Obtener Biblioteca Desde Nuevo Prestamo", e.toString(), 
					"Volver a Listado Biblioteca", "listadoBiblioteca.html", AvisoController.TipoAviso.Error);
		}

		return mv;
	}
}
