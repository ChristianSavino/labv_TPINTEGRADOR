package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import web.entidades.Biblioteca;
import web.negocioImp.NegBiblioteca;
import web.negocioImp.NegCliente;

@Controller
@SessionAttributes({"biblioteca"})
public class BibliotecaController {
	
	@Autowired
	@Qualifier("servicioBiblioteca")
	private NegBiblioteca iNegBiblioteca;
	
	@Autowired
	@Qualifier("servicioCliente")
	private NegCliente iNegCliente;
	
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
	
	@RequestMapping("agregarBiblioteca.html")
	public ModelAndView AgregarBiblioteca(int isbn, String fechaAlta ) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	
	@RequestMapping(value="obtenerBibliotecaDesdeLista.html",method = RequestMethod.GET)
	public String obtenerBibliotecaDesdeLista(ModelMap map, @ModelAttribute("biblioteca") Biblioteca biblioteca,int idBiblioteca) {
		String returnvalue="";
		try {
			Biblioteca libro = iNegBiblioteca.obtenerBiblioteca(idBiblioteca);
			biblioteca = libro;
			map.put("biblioteca", biblioteca);
			if(libro.isEstado() == 1)
				 returnvalue= "redirect:/nuevoPrestamo.html";
		} catch (Exception e) {
			 returnvalue="redirect:/ListadoBiblioteca.html";
		}
		return returnvalue;	
	}
}
