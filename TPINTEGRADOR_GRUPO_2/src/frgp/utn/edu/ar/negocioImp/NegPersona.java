package frgp.utn.edu.ar.negocioImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.IdaoPersona;
import frgp.utn.edu.ar.entidad.Persona;
import frgp.utn.edu.ar.negocio.InegPersona;

@Service("servicioPersona")
public class NegPersona implements InegPersona {

	@Autowired
	private IdaoPersona daoPersona;
	
	@Override
	public List<Persona> listarPersonas() {
		return daoPersona.listarPersonas();
	}

	@Override
	public boolean agregarPersona(Persona p) {
		return daoPersona.agregarPersona(p);
	}

}
