package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="Nacionalidad")
public class Nacionalidad implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idNacionalidad")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNacionalidad;
	
	@Column(name="descripcion")
	private String descripcion;
	
	public Nacionalidad() {
		
	}

	public int getIdNacionalidad() {
		return idNacionalidad;
	}

	public void setIdNacionalidad(int idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
