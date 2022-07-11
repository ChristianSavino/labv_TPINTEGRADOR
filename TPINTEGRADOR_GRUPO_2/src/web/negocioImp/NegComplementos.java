package web.negocioImp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.DaoNacionalidad;
import web.entidades.Nacionalidad;
import web.negocio.InegComplementos;

@Service("servicioComplementos")
public class NegComplementos implements InegComplementos {

	@Autowired
	private DaoNacionalidad daoNacionalidad;
	
	@Override
	public ArrayList<Nacionalidad> ListarNacionalidades() {
		return (ArrayList<Nacionalidad>) daoNacionalidad.listarNacionalidades();
	}

}
