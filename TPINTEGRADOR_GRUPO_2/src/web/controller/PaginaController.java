package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import web.entidades.Biblioteca;
import web.entidades.Cliente;
import web.entidades.Usuario;
import web.negocioImp.NegBiblioteca;
import web.negocioImp.NegCliente;
import web.negocioImp.NegScriptInicial;
import web.negocioImp.NegUsuario;

@Controller
@SessionAttributes({"usuario","biblioteca","cliente"})
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
	
	@Autowired
	@Qualifier("servicioCliente")
	private NegCliente iNegCliente;
	
	@ModelAttribute("usuario")
	public Usuario getUsername() {
		return new Usuario();
	}
	
	@RequestMapping("index.html")
	public String Login(ModelMap map, @ModelAttribute("usuario") Usuario u,String username, String password)	{		
		String redirect = "";
		try {
			iNegScriptInicial.CheckearScriptInicial();
			Usuario usuario = iNegUsuario.obtenerUsuarioConPass(username, password);
			if (usuario.getId() != 0)
			{
				redirect = "redirect:/listadoBiblioteca.html";
				u = usuario;
				map.put("usuario", u);
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
		mv.addObject("bibliotecas",iNegBiblioteca.listarBibliotecasTabla("","","",""));
		mv.setViewName("ListadoBiblioteca");
		return mv;
	}
	
	@RequestMapping("listadoPrestamos.html")
	public ModelAndView PaginaPrestamos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ListadoPrestamos");
		return mv;
	}
	
	@RequestMapping("listadoClientes.html")
	public ModelAndView PaginaClientes() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("clientes",iNegCliente.listarClienteTabla("","",""));
		mv.setViewName("ListadoClientes");
		return mv;
	}
	
	@RequestMapping("cerrarSesion.html")
	public ModelAndView CerrarSesion(SessionStatus status) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		status.setComplete();
		return mv;
	}
	
	@RequestMapping("nuevaBiblioteca.html")
	public ModelAndView PaginaNuevaBiblioteca() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("NuevaBiblioteca");
		return mv;
	}
	
	@RequestMapping(value="nuevoPrestamo.html")
	public ModelAndView PaginaNuevoPrestamo(@SessionAttribute("biblioteca") Biblioteca biblioteca, @SessionAttribute(name="cliente",required=false) Cliente cliente) {
		ModelAndView mv = new ModelAndView();
		if(biblioteca != null && biblioteca.getId() != 0)
			mv.addObject("libro", biblioteca);
		if(cliente != null &&cliente.getId() != 0)
			mv.addObject("cliente", cliente);
		mv.setViewName("NuevoPrestamo");
		return mv;
	}
}
