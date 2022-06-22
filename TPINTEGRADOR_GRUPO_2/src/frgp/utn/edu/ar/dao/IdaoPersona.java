package frgp.utn.edu.ar.dao;

import java.util.List;

import entidades.Persona;

public interface IdaoPersona {

	public List<Persona> listarPersonas();
	public boolean agregarPersona(Persona p);
}
