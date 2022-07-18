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
		mv.addObject("bibliotecas",iNegBiblioteca.listarBibliotecasTabla(fechaAlta,estado,isbn,titulo));
		mv.setViewName("ListadoBiblioteca");
		return mv;
	}
	
	@RequestMapping("guardarNuevaBiblioteca.html")
	public String GuardarNuevaBiblioteca(String isbn, String fechaAlta ) {
		
		try {
			boolean estado = iNegBiblioteca.agregarBiblioteca(Integer.parseInt(isbn), fechaAlta);
		
		}catch(Exception e) {
			 System.err.println(e.getMessage());
		}

		return  "redirect:/listadoBiblioteca.html";
	}
	
	@RequestMapping(value="obtenerBibliotecaDesdeLista.html")
	@ResponseBody
	public ModelAndView obtenerBibliotecaDesdeLista(@RequestParam(value = "idBiblioteca", required = false) int idBiblioteca) {
		try {
			Biblioteca libro = iNegBiblioteca.obtenerBiblioteca(idBiblioteca);
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("libro", libro);
			mv.setViewName("NuevoPrestamo");
			return mv;

		} catch (Exception e) {
			System.out.println("<<MENSAJE ERROR>>" + e.getMessage());
			return null;
		}
	}
	
	@RequestMapping("eliminarBiblioteca.html")
	public String eliminarBiblioteca(@RequestParam(value = "id", required = false) int id){
		try {
			Biblioteca biblioteca = iNegBiblioteca.obtenerBiblioteca(id);
			iNegBiblioteca.eliminarBiblioteca(biblioteca);
		}
		catch(Exception e) {
		}
		return "redirect:/listadoBiblioteca.html";
	}
	
	@RequestMapping("modificarBiblioteca.html")
	public String modificarBiblioteca(@ModelAttribute("biblioteca") Biblioteca biblioteca,
			int id, int estado, String fechaAlta) {
		boolean est = iNegBiblioteca.modificarBiblioteca(id, estado,fechaAlta);
		String redirect = "";
		if(est) {
			redirect = "redirect:/listadoBiblioteca.html";
		}
		return redirect;
	}

	@RequestMapping("listarBibliotecaFiltroAjax.html")
	@ResponseBody
	public ModelAndView ListarBibliotecaFiltroAjax(String fechaAlta,String estado, String isbn,String titulo) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("bibliotecas",iNegBiblioteca.listarBibliotecasTabla(fechaAlta,estado,isbn,titulo));
		mv.setViewName("ListadoBibliotecaFragment");
		return mv;
	}
	
	@RequestMapping(value="obtenerBibliotecaNuevoPrestamoFragment.html")
	@ResponseBody
	public ModelAndView ObtenerBibliotecaNuevoPrestamoFragment(ModelMap map,int idBiblioteca) {
		
		try {
			Biblioteca libro = iNegBiblioteca.obtenerBiblioteca(idBiblioteca);
			map.put("biblioteca", libro);
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("bibliotecaFragmentAjax", libro);
			mv.setViewName("BibliotecaFragment");
			return mv;
		} catch (Exception e) {
			System.out.println("<<MENSAJE ERROR>>" + e.getMessage());
			return null;
		}
	}
}
