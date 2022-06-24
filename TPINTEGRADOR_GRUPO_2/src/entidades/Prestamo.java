package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity(name = "Prestamo")
public class Prestamo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "idBiblioteca")
	private Biblioteca biblioteca;

	@Column(name = "fechaDePrestamo")
	private Date fechaPrestamo;

	@Column(name = "CantidadDias")
	private int cantDias;

	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "idCliente")
	private Cliente cliente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
