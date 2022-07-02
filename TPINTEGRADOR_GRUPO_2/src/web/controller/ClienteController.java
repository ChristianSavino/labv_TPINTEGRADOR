package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import web.entidades.Cliente;
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
}
