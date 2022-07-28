package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.text.SimpleDateFormat;
import web.entidades.Cliente;
import web.negocioImp.NegCliente; 
import web.entidades.Nacionalidad;

@Controller
public class ClienteController {

	@Autowired
	@Qualifier("servicioCliente")
	private NegCliente iNegCliente;
	
	@ModelAttribute("cliente")
	public Cliente getCliente() {
		return new Cliente();
	}
	
	@RequestMapping("listarClienteFiltro.html")
	@ResponseBody
	public ModelAndView ListarTodosClientesFiltro(String nacionalidad,String nombre, String apellido) {
		ModelAndView mv = new ModelAndView();
		
		try {
			mv.addObject("clientes",iNegCliente.listarClienteTabla(nacionalidad, nombre, apellido));
			mv.setViewName("ListadoClientes");
		} catch (Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Obtener Cliente", "Obtener Cliente Filtro", e.toString(), 
					"Volver a Listado Cliente", "listadoCliente.html", AvisoController.TipoAviso.Error);
		}

		return mv;
	}	
	
	@RequestMapping(value= "listarClienteFiltroAjax.html",
			method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView ListarTodosClientesFiltroAjax(String nacionalidad, String nombre, String apellido) {
		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("clientes", iNegCliente.listarClienteTabla(nacionalidad, nombre, apellido));
			mv.setViewName("ListadoClientesFragment");
		} catch (Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Obtener Cliente", "Obtener Cliente Ajax", e.toString(), 
					"Volver a Listado Cliente", "listadoCliente.html", AvisoController.TipoAviso.Error);
		}

		return mv;
	}
	
	@RequestMapping(value= "obtenerCliente.html",
			method=RequestMethod.POST)
	@ResponseBody
	public String obtenerCliente(int idCliente) {
		System.out.println(idCliente);
		Cliente cliente = iNegCliente.obtenerCliente(idCliente);
		return "{idCliente:"+cliente.getId()+"}";
	}
	
		
	@RequestMapping("obtenerClienteNuevoPrestamoFragment.html")
	public ModelAndView ObtenerClienteNuevoPrestamoFragment(int idCliente) {
		ModelAndView mv = new ModelAndView();
		try {
			Cliente cl = iNegCliente.obtenerCliente(idCliente);
			
			mv.addObject("clienteFragmentAjax", cl);
			mv.setViewName("ClienteFragment");
			
		} catch (Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Obtener Cliente", "Obtener Cliente Ajax", e.toString(), 
					"Volver a Listado Cliente", "listadoCliente.html", AvisoController.TipoAviso.Error);
		}	
		
		return mv;
	}
	
	@RequestMapping("eliminarCliente.html")
	public String eliminarCliente(@RequestParam(value = "id", required = false) int id){
		try {
			Cliente cliente = iNegCliente.obtenerCliente(id);
			iNegCliente.eliminarCliente(cliente);
		}
		catch(Exception e) {
			return "redirect:/avisoError.html?tituloPagina="+"Eliminar Cliente"+"&tituloMensaje="+"Eliminar Cliente"+"&mensaje="+e.toString()
			+"&mensajeBoton="+"Volver a Listado Clientes"+"&paginaARedireccionar="+"listadoClientes.html";
		}
		return "redirect:/listadoClientes.html";
	}

	@RequestMapping("agregarCliente.html")
	public String agregarCliente(String dni, String nombre, String apellido, String sexo, String nacionalidad,
	String fNacimiento, String localidad, String direccion, String correo, String telefono) {
		try {
			boolean estado = iNegCliente.agregarCliente(dni, nombre, apellido, sexo, Integer.parseInt(nacionalidad), fNacimiento, localidad, direccion, correo,telefono);
			
			if(estado)
				return "redirect:/listadoClientes.html";
			else
				return "redirect:/avisoError.html?tituloPagina="+"Agregar Cliente"+"&tituloMensaje="+"Agregar Cliente"+"&mensaje=Error al Agregar Cliente"
				+"&mensajeBoton="+"Volver a Listado Clientes"+"&paginaARedireccionar="+"listadoClientes.html";
		} catch (Exception e) {
			return "redirect:/avisoError.html?tituloPagina="+"Agregar Cliente"+"&tituloMensaje="+"Agregar Cliente"+"&mensaje="+e.toString()
					+"&mensajeBoton="+"Volver a Listado Clientes"+"&paginaARedireccionar="+"listadoClientes.html";
		}
	}
	
	@RequestMapping("modificarCliente.html")
	public String modificarCliente(@ModelAttribute("cliente") Cliente cliente, String id, String dni, String nombre, String apellido, String sexo, String nacionalidad,
			String fNacimiento, String localidad, String direccion, String correo, String telefono) {
		try {
			boolean estado = iNegCliente.modificarCliente(Integer.parseInt(id), Integer.parseInt(dni), nombre, apellido, sexo, Integer.parseInt(nacionalidad), fNacimiento, localidad, direccion, correo, telefono);
			if(estado) 
				return "redirect:/listadoClientes.html";
			else
				return "redirect:/avisoError.html?tituloPagina="+"Modificar Cliente"+"&tituloMensaje="+"Modificar Cliente"+"&mensaje=Error al Modificar Cliente"
				+"&mensajeBoton="+"Volver a Listado Clientes"+"&paginaARedireccionar="+"listadoClientes.html";
		} catch (Exception e) {
			return "redirect:/avisoError.html?tituloPagina="+"Modificar Cliente"+"&tituloMensaje="+"Modificar Cliente"+"&mensaje="+e.toString()
			+"&mensajeBoton="+"Volver a Listado Clientes"+"&paginaARedireccionar="+"listadoClientes.html";
		}

	}
	
}
