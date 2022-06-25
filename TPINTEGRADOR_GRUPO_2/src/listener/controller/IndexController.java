package listener.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	
	@RequestMapping("index.html")
	public ModelAndView Login(String username, String password)
	{
		ModelAndView mv = new ModelAndView();
		String redirect = "";
		try {
			if(!username.equals("Admin"))
				throw new Exception();
			if(!password.equals("12345"))
				throw new Exception();
			redirect = "ListadoPrestamos";
		} catch (Exception e) {
			mv.addObject("loginFailed","Credenciales Incorrectas");
			redirect = "index";	
		}
		
		mv.setViewName(redirect);
		return mv;
	}
}
