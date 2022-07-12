package web.negocio;

import java.util.*;

import web.entidades.*;

public interface InegComplementos {
	public ArrayList<Nacionalidad> ListarNacionalidades();
	public ArrayList<Genero> ListarGeneros();
	public Nacionalidad obtenerNacionalidad(int n);
	public Genero obtenerGenero(int g);
}
