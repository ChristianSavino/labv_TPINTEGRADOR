package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import web.entidades.Usuario;

@Controller
@SessionAttributes("usuario")
public class UserController {
	
	@RequestMapping("getUserName.html")
	@ResponseBody
	public String getUserName(@SessionAttribute("usuario") Usuario usuario) {
		return usuario.getUsername();
	}
}
