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

import web.entidades.*;
import web.negocioImp.*;

@Controller
@SessionAttributes({"usuario","biblioteca","cliente","libro","autor"})
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

	@Autowired
	@Qualifier("servicioComplementos")
	private NegComplementos iNegComplementos;

	@ModelAttribute("usuario")
	public Usuario getUsername() {
		return new Usuario();
	}

	@RequestMapping("index.html")
	public String Login(SessionStatus status, ModelMap map, @ModelAttribute("usuario") Usuario u,String username, String password)	{		
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
		status.setComplete();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("nuevaBiblioteca.html")
	public ModelAndView PaginaNuevaBiblioteca(@SessionAttribute(name="libro",required=false) Libro libro) {
		ModelAndView mv = new ModelAndView();

		if(libro != null && libro.getIsbn() > 0) {
			mv.addObject("isbnLibro",libro.getIsbn());
			mv.addObject("nombreLibro",libro.getTitulo());
		}
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

	@RequestMapping("nuevoCliente.html")
	public ModelAndView PaginaNuevoCliente() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("NuevoCliente");
		return mv;
	}

	@RequestMapping("NuevoAutor.html")
	public ModelAndView PaginaAgregarAutor() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("nacionalidades",iNegComplementos.ListarNacionalidades());
		mv.setViewName("NuevoAutor");
		return mv;
	}
	
	@RequestMapping("NuevoLibro.html")
	public ModelAndView PaginaNuevoLibro(@SessionAttribute(name="autor",required=false) Autor autor) {
		ModelAndView mv = new ModelAndView();
		if (autor != null && autor.getIdAutor() != 0)
			mv.addObject("autor",autor);
		mv.setViewName("NuevoLibro");
		return mv;
	}
}
