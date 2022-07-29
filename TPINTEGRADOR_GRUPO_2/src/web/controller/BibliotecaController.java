package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import web.controller.AvisoController.TipoAviso;
import web.entidades.Biblioteca;
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
	public ModelAndView GuardarNuevaBiblioteca(String isbn, String fechaAlta ) {
		ModelAndView mv = new ModelAndView();

		try {
			boolean estado = iNegBiblioteca.agregarBiblioteca(Integer.parseInt(isbn), fechaAlta);
			if(estado)
				mv = AvisoController.SeteoDeAviso(mv, "Alta Biblioteca", "Alta Nueva Biblioteca", "Se ha generado correctamente una biblioteca para el libro: " + isbn, 
						"Listado Biblioteca", "listadoBiblioteca.html", TipoAviso.Correcto);
			else
				mv = AvisoController.SeteoDeAviso(mv, "Alta Biblioteca", "Alta Nueva Biblioteca", "Error interno al crear nueva biblioteca", 
						"Listado Biblioteca", "listadoBiblioteca.html", TipoAviso.Error);
		}catch(Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Alta Biblioteca", "Alta Nueva Biblioteca", e.toString(), 
					"Listado Biblioteca", "listadoBiblioteca.html", TipoAviso.Error);
		}

		return mv;
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
	public ModelAndView eliminarBiblioteca(@RequestParam(value = "id", required = false) int id){
		ModelAndView mv = new ModelAndView();

		try {
			Biblioteca biblioteca = iNegBiblioteca.obtenerBiblioteca(id);
			iNegBiblioteca.eliminarBiblioteca(biblioteca);
			mv = AvisoController.SeteoDeAviso(mv, "Eliminar Biblioteca", "Eliminar Biblioteca", "Se ha eliminado correctamente una biblioteca con id: " + id, 
					"Listado Biblioteca", "listadoBiblioteca.html", TipoAviso.Correcto);
		}
		catch(Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Eliminar Biblioteca", "Eliminar Biblioteca", e.toString(), 
					"Listado Biblioteca", "listadoBiblioteca.html", TipoAviso.Error);
		}

		return mv;
	}

	@RequestMapping("modificarBiblioteca.html")
	public ModelAndView modificarBiblioteca(@ModelAttribute("biblioteca") Biblioteca biblioteca, int id, int estado, String fechaAlta) {
		ModelAndView mv = new ModelAndView();

		try {
			boolean est = iNegBiblioteca.modificarBiblioteca(id, estado,fechaAlta);
			if(est)
				mv = AvisoController.SeteoDeAviso(mv, "Modificar Biblioteca", "Modificar Biblioteca", "Se ha modificado correctamente la biblioteca con id: " + id, 
						"Listado Biblioteca", "listadoBiblioteca.html", TipoAviso.Correcto);
			else
				mv = AvisoController.SeteoDeAviso(mv, "Modificar Biblioteca", "Modificar Biblioteca", "Error interno al modificar biblioteca", 
						"Listado Biblioteca", "listadoBiblioteca.html", TipoAviso.Error);
		}catch(Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Modificar Biblioteca", "Modificar Biblioteca", e.toString(), 
					"Listado Biblioteca", "listadoBiblioteca.html", TipoAviso.Error);
		}

		return mv;
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
