package web.entidades;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Libro")
public class Libro implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		@Id
		@Column(name="id")
		//@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int isbn;
		
		@Column(name="titulo")
		private String titulo;
		
		@Column(name="fechaLanzamiento")
		private Date fechaLanzamiento;
		
		@Column(name="idioma")
		private String idioma;
		
		@Column(name="cantidadPaginas")
		private int cantidadPaginas;
		
		@ManyToOne(cascade=(CascadeType.ALL))
		@JoinColumn(name="idAutor")
		private Autor autor = new Autor();
		
		@Column(name="descripcion", columnDefinition = "nvarchar(1500)")
		private String descripcion;
		
		@ManyToMany(cascade=(CascadeType.ALL))
		@JoinColumn(name="idGenero")
		private List<Genero> generos = new ArrayList<Genero>();
		
		public Libro() {
		}
		
		public Libro(int id,String tit,String idi,int paginas,Autor au, ArrayList<Genero> gen, String sinopsis) {
			isbn = id;
			titulo = tit;
			idioma = idi;
			cantidadPaginas = paginas;
			autor = au;
			generos = gen;
			descripcion = sinopsis;
		}

		public int getIsbn() {
			return isbn;
		}

		public void setIsbn(int isbn) {
			this.isbn = isbn;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public Date getFechaLanzamiento() {
			return fechaLanzamiento;
		}

		public void setFechaLanzamiento(Date fechaLanzamiento) {
			this.fechaLanzamiento = fechaLanzamiento;
		}

		public String getIdioma() {
			return idioma;
		}

		public void setIdioma(String idioma) {
			this.idioma = idioma;
		}

		public int getCantidadPaginas() {
			return cantidadPaginas;
		}

		public void setCantidadPaginas(int cantidadPaginas) {
			this.cantidadPaginas = cantidadPaginas;
		}

		public Autor getAutor() {
			return autor;
		}

		public void setAutor(Autor autor) {
			this.autor = autor;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public List<Genero> getGeneros() {
			return generos;
		}

		public void setGeneros(List<Genero> generos) {
			this.generos = generos;
		}		
}

