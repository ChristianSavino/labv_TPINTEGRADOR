package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.text.SimpleDateFormat;
import web.entidades.Cliente;
import web.negocioImp.NegCliente; 
import web.entidades.Nacionalidad;

@Controller
@SessionAttributes("cliente")
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
		mv.addObject("clientes",iNegCliente.listarClienteTabla(nacionalidad, nombre, apellido));
		mv.setViewName("ListadoClientes");
		return mv;
	}	
	
	@RequestMapping(value= "listarClienteFiltroAjax.html",
			method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView ListarTodosClientesFiltroAjax(String nacionalidad, String nombre, String apellido) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("clientes", iNegCliente.listarClienteTabla(nacionalidad, nombre, apellido));
		mv.setViewName("ListadoClientesFragment");
		return mv;
	}
	
	@RequestMapping(value= "obtenerCliente.html",
			method=RequestMethod.POST)
	@ResponseBody
	public String obtenerCliente(int idCliente) {
		System.out.println(idCliente);
		Cliente cliente = iNegCliente.obtenerCliente(idCliente);
		//falla cuando hace el obtener cliente porque trae null cuando deberia traer el cliente en cuestion
		return "{idCliente:"+cliente.getId()+"}";
	}
	
	@RequestMapping("obtenerClienteNuevoPrestamo.html")
	public String ObtenerClienteNuevoPrestamo(ModelMap map, @ModelAttribute("cliente")Cliente cliente, int idCliente) {
		try {
			Cliente cl = iNegCliente.obtenerCliente(idCliente);
			cliente = cl;
			map.put("cliente",cliente);
		} catch (Exception e) {
		}
		return "redirect:/nuevoPrestamo.html";
	}
	
	@RequestMapping("eliminarCliente.html")
	public String eliminarCliente(@RequestParam(value = "id", required = false) int id){
		try {
			Cliente cliente = iNegCliente.obtenerCliente(id);
			iNegCliente.eliminarCliente(cliente);
		}
		catch(Exception e) {
		}
		return "redirect:/listadoClientes.html";
	}
	
	@RequestMapping("modificarCliente.html")
	public String modificarCliente(int dni, String nombre, String apellido, Nacionalidad nacionalidad,
			String sexo, String fechaNacimiento, String direccion, String telefono, String localidad, String email) {
		try {
			Cliente cliente = iNegCliente.obtenerCliente(dni);
			cliente.setDni(dni);
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setNacionalidad(nacionalidad);
			cliente.setSexo(sexo);
			cliente.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimiento));
			cliente.setDireccion(direccion);
			cliente.setTelefono(telefono);
			cliente.setLocalidad(localidad);
			cliente.setEmail(email);
			iNegCliente.modificarCliente(cliente);
		}catch(Exception e){		
		}		
		return "redirect:/listadoClientes.html";
	}	
}
