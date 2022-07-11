package web.negocioImp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.*;
import web.entidades.*;
import web.negocio.InegComplementos;

@Service("servicioComplementos")
public class NegComplementos implements InegComplementos {

	@Autowired
	private DaoNacionalidad daoNacionalidad;
	
	@Autowired
	private DaoGenero daoGenero;
	
	@Override
	public ArrayList<Nacionalidad> ListarNacionalidades() {
		return (ArrayList<Nacionalidad>)daoNacionalidad.listarNacionalidades();
	}

	@Override
	public ArrayList<Genero> ListarGeneros() {
		return (ArrayList<Genero>)daoGenero.listarGeneros();
	}

	@Override
	public Nacionalidad obtenerNacionalidad(int n) {
		return daoNacionalidad.obtenerNacionalidad(n);
	}

}
