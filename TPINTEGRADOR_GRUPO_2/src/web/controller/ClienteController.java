package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import web.negocioImp.NegCliente; 

@Controller
public class ClienteController {

	@Autowired
	@Qualifier("servicioCliente")
	private NegCliente iNegCliente;
	
	@RequestMapping("listarClienteFiltro.html")
	@ResponseBody
	public ModelAndView ListarTodosClientesFiltro(String nacionalidad,String nombre, String apellido) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("clientes",iNegCliente.listarClienteTabla(nacionalidad, nombre, apellido));
		mv.setViewName("ListadoClientes");
		return mv;
	}	
	
	@RequestMapping(value= "listarClienteFiltroAjax.html",
			method=RequestMethod.GET)
	@ResponseBody
	public Object[] ListarTodosClientesFiltroAjax(String nacionalidad, String nombre, String apellido) {
		System.out.println(nombre+apellido+nacionalidad);
		List<Object[]> objetos = iNegCliente.listarClienteTabla(nacionalidad, nombre, apellido);
		
		
		
		return objetos.get(0);
		
	
	}	
}
