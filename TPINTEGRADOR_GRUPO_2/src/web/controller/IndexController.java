package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import web.entidades.Usuario;
import web.negocioImp.NegScriptInicial;
import web.negocioImp.NegUsuario;

@Controller
public class IndexController {
	
	@Autowired
	@Qualifier("servicioUsuario")
	private NegUsuario iNegUsuario;
	
	@Autowired
	@Qualifier("servicioScriptInicial")
	private NegScriptInicial iNegScriptInicial;
	
	@RequestMapping("index.html")
	public ModelAndView Login(String username, String password)	{		
		ModelAndView mv = new ModelAndView();
		String redirect = "";
		try {
			iNegScriptInicial.CheckearScriptInicial();
			Usuario u = iNegUsuario.obtenerUsuarioConPass(username, password);
			if (u.getId() != 0)
				redirect = "ListadoBiblioteca";			
		} catch (Exception e) {
			mv.addObject("loginFailed","Credenciales Incorrectas");
			redirect = "index";	
		}
		
		mv.setViewName(redirect);
		return mv;
	}
	
	@RequestMapping("listarPrestamos.html")
	public ModelAndView PaginaPrestamos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ListadoPrestamos.jsp");
		return mv;
	}
}
