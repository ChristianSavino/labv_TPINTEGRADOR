package entidades;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Genero")
public class Genero implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idGenero")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGenero;
	
	@Column(name="descripcion")
	private String descripcion;

	public int getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Genero() {	
	}
}
