package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import web.controller.AvisoController.TipoAviso;
import web.entidades.Cliente;
import web.negocioImp.NegCliente;

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
	public ModelAndView eliminarCliente(@RequestParam(value = "id", required = false) int idCliente){
		ModelAndView mv = new ModelAndView();
		
		try {
			Cliente cliente = iNegCliente.obtenerCliente(idCliente);
			iNegCliente.eliminarCliente(cliente);
			mv = AvisoController.SeteoDeAviso(mv, "Eliminar Cliente", "Eliminar Cliente", "Se ha eliminado correctamente el cliente con id: " + idCliente,
					"Listado Cliente", "listadoClientes.html", AvisoController.TipoAviso.Correcto);
		}
		catch(Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Eliminar Cliente", "Eliminar Cliente", e.toString(), 
					"Listado Cliente", "listadoClientes.html", TipoAviso.Error);
		}
		
		return mv;
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
	public ModelAndView modificarCliente(@ModelAttribute("cliente") Cliente cliente, String id, String dni, String nombre, String apellido, String sexo, String nacionalidad,
			String fNacimiento, String localidad, String direccion, String correo, String telefono) {
		
		ModelAndView mv = new ModelAndView();
		
		try {
			boolean estado = iNegCliente.modificarCliente(Integer.parseInt(id), Integer.parseInt(dni), nombre, apellido, sexo, Integer.parseInt(nacionalidad), fNacimiento, localidad, direccion, correo, telefono);
			if(estado) 
				mv = AvisoController.SeteoDeAviso(mv, "Modificar Cliente", "Modificar Cliente", "Se ha modificado correctamente el cliente con id: " + id, 
						"Listado Cliente", "listadoClientes.html", TipoAviso.Correcto);
			else
				mv = AvisoController.SeteoDeAviso(mv, "Modificar Cliente", "Modificar Cliente", "Error interno al modificar cliente", 
						"Listado Cliente", "listadoClientes.html", TipoAviso.Error);
		} catch (Exception e) {
			mv = AvisoController.SeteoDeAviso(mv, "Modificar Cliente", "Modificar Cliente", e.toString(), 
					"Listado Cliente", "listadoClientes.html", TipoAviso.Error);
		}
		
		return mv;
	}
	
}
