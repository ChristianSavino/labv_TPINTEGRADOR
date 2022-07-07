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

import web.entidades.Biblioteca;
import web.negocioImp.NegBiblioteca;
import web.negocioImp.NegCliente;

@Controller
@SessionAttributes({"biblioteca"})
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
	
	@RequestMapping("agregarBiblioteca.html")
	public String AgregarBiblioteca(String isbn, String fechaAlta ) {
		boolean estado = iNegBiblioteca.agregarBiblioteca(Integer.parseInt(isbn), fechaAlta);
		String redirect = "";
		if(estado)
			redirect = "redirect:/listadoBiblioteca.html";
		
		return redirect;
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
	
	@RequestMapping("/eliminarBiblioteca.html")
	public String eliminarBiblioteca(@RequestParam(value = "id", required = false) int id){
		try {
			Biblioteca biblioteca = iNegBiblioteca.obtenerBiblioteca(id);
			iNegBiblioteca.eliminarBiblioteca(biblioteca);
		}
		catch(Exception e) {
		}
		return "redirect:/listadoBiblioteca.html";
	}
}
