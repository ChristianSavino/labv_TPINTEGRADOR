package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrestamoController {

	
	
//	@RequestMapping(value = {"/nuevoPrestamo"}, method = RequestMethod.GET)
	@RequestMapping("nuevoPrestamo.html")
	public ModelAndView PaginaNuevaBiblioteca() {
		System.out.println("ESTOY ACA");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("NuevoPrestamo");
		return mv;
	}
}
