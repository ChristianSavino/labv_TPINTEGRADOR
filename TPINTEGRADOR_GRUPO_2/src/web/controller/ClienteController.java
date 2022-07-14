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
		return "{idCliente:"+cliente.getId()+"}";
	}
	
		
	@RequestMapping("obtenerClienteNuevoPrestamoFragment.html")
	public ModelAndView ObtenerClienteNuevoPrestamoFragment(int idCliente) {
		//lo que no se manejar todavia es cuando no encuentra el cliente, por algun motivo no devuelve null el obtenerCliente de iNegCliente.
		try {
			Cliente cl = iNegCliente.obtenerCliente(idCliente);
			ModelAndView mv = new ModelAndView();
			mv.addObject("clienteFragmentAjax", cl);
			mv.setViewName("ClienteFragment");
			return mv;
		} catch (Exception e) {
			System.out.println("<<MENSAJE ERROR>>" + e.getMessage());
			return null;
		}		
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

	@RequestMapping("agregarCliente.html")
	public String agregarCliente(String dni, String nombre, String apellido, String sexo, String nacionalidad,
	String fNacimiento, String localidad, String direccion, String correo, String telefono) {
		boolean estado = iNegCliente.agregarCliente(dni, nombre, apellido, sexo, Integer.parseInt(nacionalidad), fNacimiento, localidad, direccion, correo,telefono);
		
		String redirect = "";
		if(estado) {
			redirect = "redirect:/listadoClientes.html";
		}
		return redirect;
	}
}
