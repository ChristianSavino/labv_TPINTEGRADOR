package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="Biblioteca")
public class Biblioteca  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="idLibro")
	private Libro libro;
	
	@Column(name="fechaDeAlta")
	private Date fechaLanzamiento;
	
	@Column(name="estado")
	private int estado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public int isEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public Biblioteca() {}
	
	@Override
	public String toString() {
		return "ID: " + this.getId() + " | Titulo: "  + this.getLibro().getTitulo() + " | Estado: " + this.isEstado();
	}
}

