package web.daoImp;

import java.util.List;

import web.entidades.Nacionalidad;

public interface IdaoNacionalidad {
	public List<Nacionalidad> listarNacionalidades();
	public boolean agregarNacionalidad(Nacionalidad n);
	public boolean modificarNacionalidad(Nacionalidad n);
	public boolean eliminarNacionalidad(Nacionalidad n);
	public Nacionalidad obtenerNacionalidad(int idNacionalidad);
}
