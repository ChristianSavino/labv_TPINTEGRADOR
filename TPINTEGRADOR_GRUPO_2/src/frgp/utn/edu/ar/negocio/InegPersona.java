package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.entidad.Persona;

public interface InegPersona {

	public List<Persona> listarPersonas();
	public boolean agregarPersona(Persona p);
}
