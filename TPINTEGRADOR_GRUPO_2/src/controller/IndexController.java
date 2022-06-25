package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	
	@RequestMapping("login.html")
	public ModelAndView Login()
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("ListadoPrestamos.jsp");
		return MV;
	}
}
