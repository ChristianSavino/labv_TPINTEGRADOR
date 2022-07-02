package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import web.entidades.Usuario;
import web.negocioImp.NegBiblioteca;
import web.negocioImp.NegScriptInicial;
import web.negocioImp.NegUsuario;

@Controller
public class PaginaController {
	
	@Autowired
	@Qualifier("servicioUsuario")
	private NegUsuario iNegUsuario;
	
	@Autowired
	@Qualifier("servicioScriptInicial")
	private NegScriptInicial iNegScriptInicial;
	
	@Autowired
	@Qualifier("servicioBiblioteca")
	private NegBiblioteca iNegBiblioteca;
	
	@RequestMapping("index.html")
	public String Login(String username, String password)	{		
		String redirect = "";
		try {
			iNegScriptInicial.CheckearScriptInicial();
			Usuario u = iNegUsuario.obtenerUsuarioConPass(username, password);
			if (u.getId() != 0)
			{
				redirect = "redirect:/listadoBiblioteca.html";
			}	
		} catch (Exception e) {
			redirect = "redirect:/loginFailed.html";	
		}
		return redirect;
	}
	
	@RequestMapping("loginFailed.html")
	public ModelAndView LoginFailed()	{		
		ModelAndView mv = new ModelAndView();
		mv.addObject("loginFailed","Credenciales Incorrectas");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("listadoBiblioteca.html")
	public ModelAndView ListadoBiblioteca() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("bibliotecas",iNegBiblioteca.listarBibliotecasTabla("","",""));
		mv.setViewName("ListadoBiblioteca");
		return mv;
	}
	
	@RequestMapping("listadoPrestamos.html")
	public ModelAndView PaginaPrestamos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ListadoPrestamos");
		return mv;
	}
	
	@RequestMapping("cerrarSesion.html")
	public ModelAndView CerrarSesion() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("nuevaBiblioteca.html")
	public ModelAndView PaginaNuevaBiblioteca() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("NuevaBiblioteca");
		return mv;
	}
}
