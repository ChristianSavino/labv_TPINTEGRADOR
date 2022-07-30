package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import web.entidades.*;
import web.negocioImp.*;

@Controller
@SessionAttributes({"usuario"})
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
	@Qualifier("servicioPrestamo")
	private NegPrestamo iNegPrestamo;

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
	
	@RequestMapping("cerrarSesion.html")
	public ModelAndView CerrarSesion(SessionStatus status) {
		status.setComplete();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("listadoBiblioteca.html")
	public ModelAndView ListadoBiblioteca() {		
		ModelAndView mv = new ModelAndView();
		
		try {
			mv.addObject("bibliotecas",iNegBiblioteca.listarBibliotecasTabla("","","",""));
			mv.setViewName("ListadoBiblioteca");
		} catch (Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Listado Biblioteca", "Carga de Listado Biblioteca", e.toString(), 
					"Volver al Login", "cerrarSesion.html", AvisoController.TipoAviso.Error);
		}

		return mv;
	}

	

	@RequestMapping("listadoClientes.html")
	public ModelAndView PaginaClientes() {
		ModelAndView mv = new ModelAndView();
		
		try {			
			mv.addObject("clientes",iNegCliente.listarClienteTabla("","",""));
			mv.setViewName("ListadoClientes");
		} catch (Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Listado Clientes", "Carga de Listado Clientes", e.toString(), 
					"Volver a Listado Biblioteca", "listadoBiblioteca.html", AvisoController.TipoAviso.Error);
		}

		return mv;
	}

	@RequestMapping("nuevaBiblioteca.html")
	public ModelAndView PaginaNuevaBiblioteca() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("NuevaBiblioteca");
		return mv;
	}

	@RequestMapping("nuevoAutor.html")
	public ModelAndView PaginaAgregarAutor() {
		ModelAndView mv = new ModelAndView();
		
		try {
			List<Nacionalidad> nacionalidades = iNegComplementos.ListarNacionalidades();
			mv.addObject("nacionalidades",nacionalidades);
			mv.setViewName("NuevoAutor");
		} catch (Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Nuevo Autor", "Carga de Nuevo Autor", e.toString(), 
					"Volver a Listado Biblioteca", "listadoBiblioteca.html", AvisoController.TipoAviso.Error);
		}

		return mv;
	}
	
	@RequestMapping("nuevoLibro.html")
	public ModelAndView PaginaNuevoLibro() {
		ModelAndView mv = new ModelAndView();
		
		try {
			List<Genero> generos = iNegComplementos.ListarGeneros();
			mv.addObject("generos", generos);
			mv.setViewName("NuevoLibro");
		} catch (Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Nuevo Libro", "Carga de Nuevo Libro", e.toString(), 
					"Volver a Listado Biblioteca", "listadoBiblioteca.html", AvisoController.TipoAviso.Error);
		}

		return mv;
	}
	
	@RequestMapping("paginaModificarBiblioteca.html")
	public ModelAndView PaginaModificarBiblioteca(@RequestParam(value = "id", required = false) int id) {
		ModelAndView mv = new ModelAndView();
		
		try {
			Biblioteca biblioteca = iNegBiblioteca.obtenerBiblioteca(id);
			mv.addObject("biblioteca", biblioteca);
			mv.setViewName("ModificarBiblioteca");
		} catch (Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Modificar Biblioteca", "Carga de Modificar Biblioteca", e.toString(), 
					"Volver a Listado Biblioteca", "listadoBiblioteca.html", AvisoController.TipoAviso.Error);
		}

		return mv;
	}
	
	@RequestMapping(value="nuevoPrestamo.html")
	public ModelAndView PaginaNuevoPrestamo() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("NuevoPrestamo");
		return mv;
	}

	@RequestMapping("nuevoCliente.html")
	public ModelAndView PaginaNuevoCliente() {
		ModelAndView mv = new ModelAndView();
		
		try {
			List<Nacionalidad> nacionalidades = iNegComplementos.ListarNacionalidades();
			mv.addObject("nacionalidades",nacionalidades);
			mv.setViewName("NuevoCliente");
		} catch (Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Nuevo Cliente", "Carga de Nuevo Cliente", e.toString(), 
					"Volver a Listado Clientes", "listadoClientes.html", AvisoController.TipoAviso.Error);
		}

		return mv;
	}
	
	@RequestMapping("paginaModificarCliente.html")
	public ModelAndView PaginaModificarCliente(@RequestParam(value = "id", required = false) int id) {
		ModelAndView mv = new ModelAndView();
		
		try {
			Cliente cliente = iNegCliente.obtenerCliente(id);
			List<Nacionalidad> nacionalidades = iNegComplementos.ListarNacionalidades();
			mv.addObject("nacionalidades",nacionalidades);
			mv.addObject("cliente", cliente);
			mv.setViewName("ModificarCliente");
		} catch (Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Modificar Cliente", "Carga de Modificar Cliente", e.toString(), 
					"Volver a Listado Clientes", "listadoClientes.html", AvisoController.TipoAviso.Error);
		}

		return mv;
	}
	
}
