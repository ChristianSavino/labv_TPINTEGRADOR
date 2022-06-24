package frgp.utn.edu.ar.controller;

import javax.servlet.ServletConfig;

import org.hibernate.service.config.spi.ConfigurationService.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import entidades.Cliente;
import frgp.utn.edu.ar.negocioImp.NegCliente;

@Controller
public class ControladorCliente {

	@Autowired
	@Qualifier("servicioPersona")
	private NegCliente negocioCliente;
	@Autowired
	private Cliente persona;
	
	
	@RequestMapping("agregarPersona.html")
	public ModelAndView eventoRedireccionarPag1(Integer txtDni,String txtNombre, String txtApellido)
	{
		ModelAndView MV = new ModelAndView();
		persona.setApellido(txtApellido);
		persona.setDni(txtDni);
		persona.setNombre(txtNombre);
		
		//boolean estado= negocioCliente.agre(persona);
		//String cartel="No se pudo agregar la persona";
		//if(estado)
		//{
		//	cartel="La persona ha sido agregada exitosamente";
		//}
		//MV.addObject("estadoAgregarPersona",cartel);
		MV.setViewName("Inicio");
		return MV;
	}
}