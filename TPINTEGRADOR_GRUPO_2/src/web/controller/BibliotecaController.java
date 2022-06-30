package web.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import web.entidades.Biblioteca;
import web.negocioImp.NegBiblioteca;

@Controller
public class BibliotecaController {

	@Autowired
	@Qualifier("servicioBiblioteca")
	private NegBiblioteca negBiblioteca;
	
	@RequestMapping("listarBiblioteca.html")
	@ResponseBody
	public Iterable<Biblioteca> ListarTodasBibliotecas() {
		Iterable<Biblioteca> biblo = negBiblioteca.listarBibliotecas();
		return biblo;
	}
}
