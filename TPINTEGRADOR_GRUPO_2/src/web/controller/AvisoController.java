package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AvisoController {

	public enum TipoAviso {
		Aviso,
		Error,
		Correcto
	}
	//Si el error se da en una función que devuelve un Model&View, esto setea los datos en el catch
	public static ModelAndView SeteoDeAviso(ModelAndView mv, String tituloPagina,String tituloMensaje,String mensaje, String mensajeBoton, String paginaARedireccionar,TipoAviso tipo) {
		String tipoString = "";
		switch(tipo) {
		case Aviso :
			tipoString = "Aviso - ";
			break;
		case Correcto:
			tipoString = "Operacion Realizada - ";
			break;
		case Error:
			tipoString = "Error - ";
			break;
		}
		
		mv.addObject("titulo",tipoString+tituloPagina);
		mv.addObject("tituloMensaje",tipoString+tituloMensaje);
		mv.addObject("mensaje",mensaje);
		mv.addObject("mensajeBoton",mensajeBoton);
		mv.addObject("paginaARedireccionar",paginaARedireccionar);
		mv.setViewName("Aviso");
		return mv;
	}
	
	@RequestMapping("avisoError.html")
	public ModelAndView SeteoErrorRedirect(String tituloPagina,String tituloMensaje,String mensaje, String mensajeBoton, String paginaARedireccionar) {
		return SeteoDeAviso(new ModelAndView(), tituloPagina, tituloMensaje, mensaje, mensajeBoton, paginaARedireccionar, TipoAviso.Error);
	}
	
	
}
