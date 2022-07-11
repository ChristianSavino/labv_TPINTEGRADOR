package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import web.entidades.Autor;
import web.entidades.Nacionalidad;
import web.negocioImp.NegAutor;

@Controller
@SessionAttributes("autor")
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
	public String AgregarAutor(ModelMap map,@ModelAttribute("autor") Autor autor ,String nombre, String apellido, Nacionalidad nacionalidad, String email) {
		boolean estado = iNegAutor.agregarAutor(nombre, apellido, nacionalidad, email);
		
		String redirect = "";
		if(estado) {
			redirect = "redirect:/listadoAutor.html";
			autor = iNegAutor.obtenerAutorNombreYApellido(nombre, apellido);
			map.put("autor",autor);
		}
		return redirect;
	}
	

	@RequestMapping("eliminarAutor.html")
	public String eliminarAutor(@RequestParam(value = "id", required = false) int id){
		try {
			Autor autor = iNegAutor.obtenerAutor(id);
			iNegAutor.eliminarAutor(autor);
		}
		catch(Exception e) {
		}
		return "redirect:/listadoAutores.html";
	}
}
