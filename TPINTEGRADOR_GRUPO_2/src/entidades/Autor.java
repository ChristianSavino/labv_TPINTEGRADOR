package entidades;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="Autor")
public class Autor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="idAutor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAutor;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@ManyToOne(cascade=(CascadeType.ALL))
	@JoinColumn(name="idNacionalidad")
	private List<Nacionalidad> nacionalidad = new ArrayList<Nacionalidad>();
	
	@Column(name="email")
	private String email;
		
	public Autor() {		
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<Nacionalidad> getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(List<Nacionalidad> nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Autor [idAutor=" + idAutor + ", nombre=" + nombre + ", apellido=" + apellido + ", nacionalidad="
				+ nacionalidad + ", email=" + email + "]";
	}
}
