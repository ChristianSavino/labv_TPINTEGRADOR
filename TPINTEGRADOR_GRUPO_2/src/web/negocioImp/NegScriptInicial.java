package web.negocioImp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.*;
import web.entidades.*;
import web.negocio.InegScriptInicial;

@Service("servicioScriptInicial")
public class NegScriptInicial implements InegScriptInicial {

	@Autowired
	DaoAutor iDaoAutor;

	@Autowired
	DaoNacionalidad iDaoNacionalidad;

	@Autowired
	DaoGenero iDaoGenero;

	@Autowired
	DaoLibro iDaoLibro;

	@Autowired
	DaoBiblioteca iDaoBiblioteca;

	@Autowired
	DaoUsuario iDaoUsuario;

	public void CheckearScriptInicial() throws Exception {
		ArrayList<Libro> libros = (ArrayList)iDaoLibro.listarLibros();

		if (libros != null && libros.size() > 0) 
			System.out.print("Datos existentes");
		else
			GenerarDatos();
	}

	void GenerarDatos() throws ParseException {
		GenerarUsuarios();
		List<Nacionalidad> nacionalidades = GenerarNacionalidades();
		List<Autor> autores = GenerarAutores(nacionalidades);
		List<Genero> generos = GenerarGeneros();
		List<Libro> libros = GenerarLibros(autores,generos);
		GenerarBibliotecas(libros);
	}

	void GenerarUsuarios() {
		Usuario u = new Usuario("Admin","12345");
		iDaoUsuario.agregarUsuario(u);
		
		u = new Usuario("Christian","Keru");
		iDaoUsuario.agregarUsuario(u);
		
		u = new Usuario("Test","Test");
		iDaoUsuario.agregarUsuario(u);
	}
	
	List<Nacionalidad> GenerarNacionalidades(){
		ArrayList<Nacionalidad> aux = new ArrayList<Nacionalidad>();
		Nacionalidad nacionalidad = new Nacionalidad("Argentina");
		aux.add(nacionalidad);

		nacionalidad = new Nacionalidad("Paraguay");
		aux.add(nacionalidad);

		nacionalidad = new Nacionalidad("Bolivia");
		aux.add(nacionalidad);

		nacionalidad = new Nacionalidad("Chile");
		aux.add(nacionalidad);

		nacionalidad = new Nacionalidad("Uruguay");
		aux.add(nacionalidad);

		nacionalidad = new Nacionalidad("Mexico");
		aux.add(nacionalidad);

		nacionalidad = new Nacionalidad("Costa Rica");
		aux.add(nacionalidad);

		nacionalidad = new Nacionalidad("Bahamas");
		aux.add(nacionalidad);

		nacionalidad = new Nacionalidad("Estados Unidos");
		aux.add(nacionalidad);

		nacionalidad = new Nacionalidad("Canada");
		aux.add(nacionalidad);

		nacionalidad = new Nacionalidad("Inglaterria");
		aux.add(nacionalidad);

		nacionalidad = new Nacionalidad("Rusia");
		aux.add(nacionalidad);

		nacionalidad = new Nacionalidad("Suecia");
		aux.add(nacionalidad);

		nacionalidad = new Nacionalidad("Australia");
		aux.add(nacionalidad);

		nacionalidad = new Nacionalidad("Japon");
		aux.add(nacionalidad);

		nacionalidad = new Nacionalidad("Nueva Zelanda");
		aux.add(nacionalidad);

		nacionalidad = new Nacionalidad("Brasil");
		aux.add(nacionalidad);

		nacionalidad = new Nacionalidad("Magadascar");
		aux.add(nacionalidad);

		nacionalidad = new Nacionalidad("Polonia");
		aux.add(nacionalidad);

		nacionalidad = new Nacionalidad("Ucrania");
		aux.add(nacionalidad);

		nacionalidad = new Nacionalidad("Armenia");
		aux.add(nacionalidad);

		nacionalidad = new Nacionalidad("Espa??a");
		aux.add(nacionalidad);

		for (Nacionalidad n : aux)
			iDaoNacionalidad.agregarNacionalidad(n);

		return aux;
	}

	List<Autor> GenerarAutores(List<Nacionalidad> nacionalidades) {
		ArrayList<Autor> aux = new ArrayList<Autor>();

		Autor a = new Autor("Miguel","De Cervantes",nacionalidades.get(0),"miguelitocervantes@gmail.com");
		aux.add(a);

		a = new Autor("Marques","De Sade",nacionalidades.get(1),"marquesitodesade@gmail.com");
		aux.add(a);

		a = new Autor("Goethe","",nacionalidades.get(2),"goethesito@gmail.com");
		aux.add(a);

		a = new Autor("Jane","Austen",nacionalidades.get(3),"janeausten@gmail.com");
		aux.add(a);

		a = new Autor("Mary","Shelley",nacionalidades.get(4),"maryshelley@gmail.com");
		aux.add(a);

		a = new Autor("Victor","Hugo",nacionalidades.get(5),"victorsitohugo@gmail.com");
		aux.add(a);

		a = new Autor("Charles","Dickens",nacionalidades.get(10),"charlesdickens@gmail.com");
		aux.add(a);

		a = new Autor("Herman","Melville",nacionalidades.get(9),"hermanmelville@gmail.com");
		aux.add(a);

		a = new Autor("Fiodor","Dostoyevski",nacionalidades.get(11),"fiodordosty@gmail.com");
		aux.add(a);

		a = new Autor("Julio","Verne",nacionalidades.get(6),"julitoverne@gmail.com");
		aux.add(a);

		a = new Autor("Leon","Tolstoi",nacionalidades.get(7),"leontolsti@gmail.com");
		aux.add(a);

		a = new Autor("Emile","Zola",nacionalidades.get(12),"emilitazola@gmail.com");
		aux.add(a);

		a = new Autor("Bram","Stoker",nacionalidades.get(13),"draculitaatrevido@gmail.com");
		aux.add(a);

		a = new Autor("Bram","Stoker",nacionalidades.get(14),"draculitaatrevido@gmail.com");
		aux.add(a);

		a = new Autor("Oscar","Wilde",nacionalidades.get(15),"oscarwilde@gmail.com");
		aux.add(a);

		a = new Autor("Marcel","Proust",nacionalidades.get(15),"marcelitoproust@gmail.com");
		aux.add(a);

		a = new Autor("James","Joyce",nacionalidades.get(16),"jamesjoyce@gmail.com");
		aux.add(a);

		a = new Autor("Franz","Kafka",nacionalidades.get(17),"franzkafka@gmail.com");
		aux.add(a);

		a = new Autor("Isak","Dinesen",nacionalidades.get(18),"isakdinesen@gmail.com");
		aux.add(a);

		a = new Autor("Vladimir","Nabokov",nacionalidades.get(19),"vladinabo@gmail.com");
		aux.add(a);

		a = new Autor("Marguerite","Duras",nacionalidades.get(20),"margaritadurasduras@gmail.com");
		aux.add(a);

		a = new Autor("Truman","Capote",nacionalidades.get(21),"margaritadurasduras@gmail.com");
		aux.add(a);

		for (Autor au : aux)
			iDaoAutor.agregarAutor(au);

		return aux;
	}

	List<Genero> GenerarGeneros() {
		ArrayList<Genero> aux = new ArrayList<Genero>();
		Genero g = new Genero("Narrativo");
		aux.add(g);
		
		g = new Genero("Lirico");
		aux.add(g);
		
		g = new Genero("Dramatico");
		aux.add(g);
		
		g = new Genero("Aventuras");
		aux.add(g);
		
		g = new Genero("Ciencia Ficcion");
		aux.add(g);
		
		g = new Genero("Cuento de hada");
		aux.add(g);
		
		g = new Genero("Gotico");
		aux.add(g);
		
		g = new Genero("Noire");
		aux.add(g);
		
		g = new Genero("Paranormal");
		aux.add(g);
		
		g = new Genero("Fantastico");
		aux.add(g);
		
		g = new Genero("Distopico");
		aux.add(g);

		for (Genero au : aux)
			iDaoGenero.agregarGenero(au);

		return aux;
	}
	
	List<Libro> GenerarLibros(List<Autor> autores, List<Genero> generos) throws ParseException {
		ArrayList<Libro> aux = new ArrayList<Libro>();
		
		Libro libro = new Libro(16050101,"Don Quijote de la Mancha",new SimpleDateFormat("yyyy-MM-dd").parse("1605-01-01"),"Gallego",305,autores.get(0),new ArrayList<Genero>(Arrays.asList(generos.get(3),generos.get(0))),"El tema de la obra gira en torno a si es posible encontrar un ideal en lo real.");
		aux.add(libro);
		
		libro = new Libro(16130201,"Novelas ejemplares",new SimpleDateFormat("yyyy-MM-dd").parse("1613-01-01"),"Gallego",314,autores.get(0),new ArrayList<Genero>(Arrays.asList(generos.get(3),generos.get(7),generos.get(0))),"Contiene:La gitanilla, El amante liberal, Rinconete y Cortadillo, La espa??ola inglesa, El licenciado Vidriera, La fuerza de la sangre, El celoso extreme??o, La ilustre fregona, Las dos doncellas, La se??ora Cornelia, El casamiento enga??oso, El coloquio de los perros.");
		aux.add(libro);
		
		libro = new Libro(19040102,"Los 120 d??as de Sodoma",new SimpleDateFormat("yyyy-MM-dd").parse("1904-01-01"),"Frances",115,autores.get(1),new ArrayList<Genero>(Arrays.asList(generos.get(2),generos.get(7))),"Cuatro adinerados pervertidos se encierran en el castillo, junto con un grupo de v??ctimas y c??mplices. Su intenci??n es la de escuchar historias de depravaci??n de 4 veteranas prostitutas, las cuales les inspirar??n a cometer similares actos con sus v??ctimas.");
		aux.add(libro);
		
		libro = new Libro(19140202,"Justine",new SimpleDateFormat("yyyy-MM-dd").parse("1914-01-01"),"Frances",205,autores.get(1),new ArrayList<Genero>(Arrays.asList(generos.get(2),generos.get(7))),"Justine simboliza la virtud que con una escasa inteligencia debe enfrentarse a las a??agazas del vicio y, contrariamente a lo que cabr??a esperar, en lugar de ser recompensada por mantener su virtud, lo que recibe es toda clase de agravios. Por el contrario, los libertinos que abusan de ella se ven recompensados.");
		aux.add(libro);
		
		libro = new Libro(17820103,"Der Erlk??nig",new SimpleDateFormat("yyyy-MM-dd").parse("1782-01-01"),"Aleman",1,autores.get(2),new ArrayList<Genero>(Arrays.asList(generos.get(1),generos.get(7))),"Describe la lucha de un padre por la vida de su hijo, asediado por un ser sobrenatural, que representa la muerte.");
		aux.add(libro);
		
		libro = new Libro(17720203,"Prometeo",new SimpleDateFormat("yyyy-MM-dd").parse("1772-01-01"),"Aleman",2,autores.get(2),new ArrayList<Genero>(Arrays.asList(generos.get(1),generos.get(10))),"El yo po??tico del texto es el personaje m??tico Prometeo, quien se dirige de manera desafiante a Zeus, defendiendo la liberaci??n del ser humano frente al culto de lo divino.");
		aux.add(libro);
		
		libro = new Libro(18130104,"Orgullo y prejuicio",new SimpleDateFormat("yyyy-MM-dd").parse("1813-01-01"),"Ingles",215,autores.get(3),new ArrayList<Genero>(Arrays.asList(generos.get(0),generos.get(4))),"Es una novela de desarrollo personal, en la que las dos figuras principales, Elizabeth Bennet y Fitzwilliam Darcy, cada uno a su manera y, no obstante, de forma muy parecida, deben madurar para superar algunas crisis y aprender de sus errores para poder encarar el futuro en com??n, superando el orgullo de clase de Darcy y los prejuicios de Elizabeth hacia ??l.");
		aux.add(libro);
		
		libro = new Libro(18150204,"Emma",new SimpleDateFormat("yyyy-MM-dd").parse("1815-01-01"),"Ingles",157,autores.get(3),new ArrayList<Genero>(Arrays.asList(generos.get(0),generos.get(4))),"Emma Woodhouse es una joven en la Inglaterra de la Regencia. Vive con su padre, un hipocondr??aco caracterizado principalmente por su excesiva preocupaci??n por la salud y el bienestar de aquellos a los que ama. La se??orita Woodhouse est?? empe??ada en hacer de casamentera de sus amistades y relaciones. Pero al ocuparse de los asuntos de sus amigas se olvida de atender sus propios sentimientos. El amigo de Emma y la ??nica persona que la critica es el caballeroso se??or Knightley, su \"vecino\" y cu??ado (hermano del marido de su hermana), diecis??is a??os mayor que ella.");
		aux.add(libro);
		
		libro = new Libro(18260105,"El ??ltimo hombre",new SimpleDateFormat("yyyy-MM-dd").parse("1826-01-01"),"Ingles",389,autores.get(4),new ArrayList<Genero>(Arrays.asList(generos.get(0),generos.get(5))),"El libro narra la historia de un mundo futurista que ha sido arrasado por una plaga. La novela fue criticada duramente en su ??poca, y permaneci?? pr??cticamente en el anonimato hasta que los historiadores la resucitaron en la d??cada de 1960.");
		aux.add(libro);
		
		libro = new Libro(19590205,"Mathilda",new SimpleDateFormat("yyyy-MM-dd").parse("1959-01-01"),"Ingles",274,autores.get(4),new ArrayList<Genero>(Arrays.asList(generos.get(0),generos.get(9))),"Relatando la historia desde su lecho de muerte, Matilda cuenta la historia de la confesi??n de su padre sobre el amor que sent??a hacia ella, seguido por su suicidio mediante ahogamiento.");
		aux.add(libro);
		
		libro = new Libro(18620106,"Los miserables",new SimpleDateFormat("yyyy-MM-dd").parse("1862-01-01"),"Frances",404,autores.get(5),new ArrayList<Genero>(Arrays.asList(generos.get(0),generos.get(7))),"Jean Valjean es un ex-presidiario. Cuando llega al pueblo de D., rumbo a su pueblo natal y presenta su pasaporte -en el que figura como ex-reo y ''hombre peligroso''- en el ayuntamiento, nadie se digna a acogerle y a darle de comer, salvo don Bienvenido, el p??rroco.");
		aux.add(libro);
		
		libro = new Libro(18590206,"Les Contemplations",new SimpleDateFormat("yyyy-MM-dd").parse("1859-01-01"),"Frances",496,autores.get(5),new ArrayList<Genero>(Arrays.asList(generos.get(0),generos.get(7))),"Les Contemplations es una colecci??n de poemas, escrita por Victor Hugo , publicada en 1856 . Est?? compuesto por 158 poemas recogidos en seis libros. La mayor??a de estos poemas fueron escritos entre 1841 y 1855 , pero los poemas m??s antiguos de esta colecci??n datan de 1830.");
		aux.add(libro);
		
		libro = new Libro(18370107,"Oliver Twist",new SimpleDateFormat("yyyy-MM-dd").parse("1837-01-01"),"Ingles",298,autores.get(6),new ArrayList<Genero>(Arrays.asList(generos.get(0),generos.get(4))),"Oliver es un ni??o hu??rfano que pasa sus primeros a??os en el orfanato de la se??ora Mann. Al igual que el resto de los ni??os en el orfanato, Oliver sufre hambre continuamente. Los ni??os deciden entonces jugar a qui??n de ellos pedir?? un plato m??s de comida y Oliver resulta ser el elegido.");
		aux.add(libro);
		
		libro = new Libro(18430207,"A Christmas Carol",new SimpleDateFormat("yyyy-MM-dd").parse("1843-01-01"),"Ingles",298,autores.get(6),new ArrayList<Genero>(Arrays.asList(generos.get(0),generos.get(4))),"Su trama cuenta la historia de un hombre avaro y ego??sta llamado Ebenezer Scrooge y su conversi??n tras ser visitado por una serie de fantasmas en Nochebuena.");
		aux.add(libro);
		
		libro = new Libro(18510108,"Moby-Dick",new SimpleDateFormat("yyyy-MM-dd").parse("1851-01-01"),"Ingles",823,autores.get(7),new ArrayList<Genero>(Arrays.asList(generos.get(0),generos.get(5),generos.get(4))),"Ismael, un joven con experiencia en la marina mercante, decide que su siguiente viaje ser?? en un ballenero. De igual forma se convence de que su traves??a debe comenzar en Nantucket, Massachusetts, isla prestigiosa por su industria ballenera. Antes de alcanzar su destino, o el origen de su aventura, entabla una estrecha amistad con el experimentado arponero polinesio Queequeg, con quien acuerda compartir la empresa.");
		aux.add(libro);
		
		libro = new Libro(18660109,"Crimen y castigo",new SimpleDateFormat("yyyy-MM-dd").parse("1866-01-01"),"Ruso",451,autores.get(8),new ArrayList<Genero>(Arrays.asList(generos.get(0),generos.get(5),generos.get(4))),"La historia narra la vida de Rodi??n Rask??lnikov, un estudiante en la capital de la Rusia Imperial, San Petersburgo. Este joven se ve obligado a suspender sus estudios por la miseria en la cual se ve envuelto, a pesar de los esfuerzos realizados por su madre Pulqueria y su hermana Dunia para enviarle dinero. Necesitado de financiaci??n para pagar sus gastos, hab??a recurrido a una anciana prestamista vil y ego??sta, en cuya casa empe??a algunos objetos de valor.");
		aux.add(libro);
		
		libro = new Libro(18620110,"Viaje al centro de la Tierra",new SimpleDateFormat("yyyy-MM-dd").parse("1862-01-01"),"Frances",360,autores.get(9),new ArrayList<Genero>(Arrays.asList(generos.get(0),generos.get(5),generos.get(4))),"Axel reside en una vieja casa situada en la K??nigstrasse, en Hamburgo, junto a su t??o Otto Lidenbrock, un prestigioso profesor de mineralog??a a quien describe como un hombre temido por su fuerte car??cter pero muy original; su ahijada Gr??uben y su sirvienta, Marta. Un d??a el profesor lo llama a su despacho, donde le ense??a un manuscrito de gran valor del Heimskringla, de Snorri Sturluson. El profesor, euf??rico, decide ir al lugar indicado en el pergamino junto con su sobrino Axel.");
		aux.add(libro);
		
		libro = new Libro(18650111,"Guerra y paz",new SimpleDateFormat("yyyy-MM-dd").parse("1865-01-01"),"Ruso",541,autores.get(10),new ArrayList<Genero>(Arrays.asList(generos.get(0),generos.get(9))),"Guerra y paz alterna en su magn??fica trama historias familiares con las vicisitudes del ej??rcito napole??nico, la vida en la corte de Alejandro y las batallas de Austerlitz y Borodin??.");
		aux.add(libro);
		
		libro = new Libro(18850112,"Germinal",new SimpleDateFormat("yyyy-MM-dd").parse("1885-01-01"),"Frances",654,autores.get(11),new ArrayList<Genero>(Arrays.asList(generos.get(0),generos.get(7))),"La historia se desarrolla en Francia, en un pueblo donde la vida gira en torno a las minas de carb??n, lugar de donde la mayor parte de las familias obtiene sustento; cada miembro de las familias que ah?? trabajan se vuelve virtualmente esclavo de la mina, obteniendo salarios de miseria, desgast??ndose y corriendo el riesgo de no volver a casa en cada momento del d??a. Hartos de esta situaci??n, habiendo incluido en su estilo de vida el hambre y la enfermedad, indispuestos a continuar con esta ???vida??? que al haber perdido ya toda esperanza hab??a dejado de serlo, se organizan para iniciar una huelga, pidiendo un aumento que les permitiera por lo menos salir un poco del estado de hambre en el que viv??an.");
		aux.add(libro);
		
		libro = new Libro(18970113,"Dracula",new SimpleDateFormat("yyyy-MM-dd").parse("1897-01-01"),"Ingles",418,autores.get(12),new ArrayList<Genero>(Arrays.asList(generos.get(0),generos.get(5),generos.get(7))),"Jonathan Harker, un joven abogado londinense comprometido con Wilhemina Murray (Mina), el cual se encuentra en la ciudad de Bistritz como parte de una viaje de negocios, que continuar?? a trav??s del desfiladero del Borgo hasta el remoto castillo de su cliente, el conde Dr??cula, en una de las regiones m??s lejanas de la Rumania de la ??poca, los Montes C??rpatos de Transilvania, para cerrar unas ventas con ??l.");
		aux.add(libro);
		
		libro = new Libro(18900114,"El retrato de Dorian Gray",new SimpleDateFormat("yyyy-MM-dd").parse("1890-01-01"),"Irlandes",377,autores.get(13),new ArrayList<Genero>(Arrays.asList(generos.get(0),generos.get(5))),"Basil Hallward es un artista que queda fuertemente impresionado por la belleza est??tica de un joven llamado Dorian Gray y comienza a admirarlo. Basil pinta un retrato del joven. Charlando en el jard??n de Hallward, Dorian conoce a un amigo de Basil y empieza a cautivarse por la visi??n del mundo de Lord Henry. Exponiendo un nuevo tipo de hedonismo, Lord Henry indica que ??lo ??nico que vale la pena en la vida es la belleza, y la satisfacci??n de los sentidos??. Al darse cuenta de que un d??a su belleza se desvanecer??, Dorian desea tener siempre la edad de cuando Basil le pint?? en el cuadro. Mientras ??l mantiene para siempre la misma apariencia del cuadro, la figura retratada envejece por ??l. Su b??squeda del placer lo lleva a una serie de actos de lujuria; pero el retrato sirve como un recordatorio de los efectos de su alma, donde el retrato llevar?? la carga de su envejecimiento y sus pecados.");
		aux.add(libro);
		
		libro = new Libro(19130115,"En busca del tiempo perdido",new SimpleDateFormat("yyyy-MM-dd").parse("1913-01-01"),"Frances",345,autores.get(14),new ArrayList<Genero>(Arrays.asList(generos.get(0),generos.get(5),generos.get(7))),"El narrador, joven hipersensible perteneciente a una familia burguesa de Par??s de principios del siglo XX, quiere ser escritor. Sin embargo, las tentaciones mundanas le desv??an de su primer objetivo; atra??do por el brillo de la aristocracia o de los lugares de veraneo de moda (como Balbec, ciudad imaginaria de la costa normanda), crece a la vez que descubre el mundo, el amor, y la existencia de la homosexualidad. La enfermedad y la guerra, que le apartar??n del mundo, tambi??n propiciar??n que tome conciencia de la extrema vanidad de las tentaciones mundanas y de su aptitud para llegar a ser escritor y ser capaz de fijar el tiempo perdido.");
		aux.add(libro);
		
		libro = new Libro(19220116,"Ulises",new SimpleDateFormat("yyyy-MM-dd").parse("1922-01-01"),"Irlandes",654,autores.get(15),new ArrayList<Genero>(Arrays.asList(generos.get(0),generos.get(5),generos.get(7))),"El narrador, joven hipersensible perteneciente a una familia burguesa de Par??s de principios del siglo XX, quiere ser escritor. Sin embargo, las tentaciones mundanas le desv??an de su primer objetivo; atra??do por el brillo de la aristocracia o de los lugares de veraneo de moda (como Balbec, ciudad imaginaria de la costa normanda), crece a la vez que descubre el mundo, el amor, y la existencia de la homosexualidad. La enfermedad y la guerra, que le apartar??n del mundo, tambi??n propiciar??n que tome conciencia de la extrema vanidad de las tentaciones mundanas y de su aptitud para llegar a ser escritor y ser capaz de fijar el tiempo perdido.");
		aux.add(libro);
		
		libro = new Libro(19150117,"La metamorfosis",new SimpleDateFormat("yyyy-MM-dd").parse("1915-01-01"),"Aleman",548,autores.get(16),new ArrayList<Genero>(Arrays.asList(generos.get(0),generos.get(5),generos.get(7))),"Una ma??ana, despu??s de un sue??o intranquilo, Gregorio Samsa trata de levantarse para asistir a su trabajo, pero se da cuenta de que durante la noche se ha transformado en un insecto; al darse cuenta de lo tarde que es, intenta comenzar sus actividades diarias habituales, pero al estar acostado sobre su espalda, no logra levantarse de la cama.");
		aux.add(libro);
		
		libro = new Libro(19370118,"Memorias de Africa",new SimpleDateFormat("yyyy-MM-dd").parse("1937-01-01"),"Ingles",454,autores.get(17),new ArrayList<Genero>(Arrays.asList(generos.get(0),generos.get(4))),"El libro es una reflexi??n l??rica de la vida de Blixen en su plantaci??n de caf??, como as?? mismo un tributo a ciertas personas que causaron una impresi??n durante su vida en aquellas latitudes. Es tambi??n una v??vida fotograf??a de la vida colonial en ??frica durante las postrimer??as del Imperio brit??nico.");
		aux.add(libro);
		
		libro = new Libro(19550119,"Lolita",new SimpleDateFormat("yyyy-MM-dd").parse("1955-01-01"),"Frances",864,autores.get(18),new ArrayList<Genero>(Arrays.asList(generos.get(0),generos.get(5))),"El psic??logo ficticio John Ray, Jr.??? explica que recibi?? un manuscrito titulado Lolita, o La confesi??n de un viudo blanco que est?? firmado con el seud??nimo de Humbert Humbert, un autor que muri?? en la c??rcel por una trombosis coronaria.");
		aux.add(libro);
		
		libro = new Libro(19840120,"El amante",new SimpleDateFormat("yyyy-MM-dd").parse("1984-01-01"),"Frances",134,autores.get(19),new ArrayList<Genero>(Arrays.asList(generos.get(0),generos.get(7))),"Trata de una adolescente de origen franc??s que vive en Indochina y cuya familia est?? arruinada. Ella se hace amante de un chino adinerado y mantiene una relaci??n con ??l a lo largo de un a??o y medio.");
		aux.add(libro);
		
		libro = new Libro(19660121,"A sangre fria",new SimpleDateFormat("yyyy-MM-dd").parse("1966-01-01"),"Ingles",352,autores.get(20),new ArrayList<Genero>(Arrays.asList(generos.get(0),generos.get(8))),"Trata de una adolescente de origen franc??s que vive en Indochina y cuya familia est?? arruinada. Ella se hace amante de un chino adinerado y mantiene una relaci??n con ??l a lo largo de un a??o y medio.");
		aux.add(libro);
		
		for (Libro lr : aux)
			iDaoLibro.agregarLibro(lr);
		
		return aux;
	}

	void GenerarBibliotecas(List<Libro> libros) {
		for (Libro lr : libros) {
			Biblioteca b = new Biblioteca(lr, new Date(System.currentTimeMillis()),1);
			iDaoBiblioteca.agregarBiblioteca(b);
		}
	}
}

