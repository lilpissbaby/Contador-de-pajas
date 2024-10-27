
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

	public static void main(String args[]) throws FileNotFoundException  {
		Scanner scan = new Scanner(System.in);
		Scanner ficheroEntrada = new Scanner(new File ("version.txt"));
		String nombreFichero = "";
		
		// Se repetirá hasta dar con un fichero correctaemtne escrito
		// Fichero paraprobar: 		_chat.txt
		nombreFichero = preguntarFichero() + ".txt";
		File fichero = new File (nombreFichero);
		
		while(!fichero.exists()) {
			System.out.println("Error en el fichero. Repite:");
			nombreFichero = preguntarFichero() + ".txt";
			fichero = new File (nombreFichero);
		}
		
		// Llegado aqui, el fihcero existe y es correcto, usaremos el nombre de éte para crear un scanner para él
		ficheroEntrada = new Scanner(new File (nombreFichero));
		
		
		// Fichero leído correctamente. Menu con opciones
		String opcion = menu();
		
		// Si se elige purgar archivo o una opción incorrecta
		while(!opcion.equalsIgnoreCase("1")) {
				switch(opcion) {
				case "2":
					// Tras purgar le archivo, ficheroEntrada adoptará el fichero purgado.
					ficheroEntrada = new Scanner(new File (purgar(nombreFichero) ));
					System.out.println("Archivo purgado correctamente\n");
				break;
				
				default:
					System.out.println("Opción incorrecta.");
				break;
				}
			
			opcion = menu();
		}
		
		// Si la opción es 1, se invoca la opciónpara leer el archivo. Partiendo de ahí, se podrá
		// hacer lo que se quiera.
		
		
		// Llegado aqui, el fichero es correcto. Se cargan los usuarios en el arraylist de Pajero.arraylist
		leerPajasTotales(ficheroEntrada);	
		
		// Menú de opciones una vez se sabe la información de todos los pajeros

		// Mostrar total de pajeros
		System.out.println("Total de pajeros: " + Pajero.arrayPajeros.size());
		
		for(Pajero amanteDeLaPaja : Pajero.arrayPajeros) {
			System.out.println(amanteDeLaPaja.getNombre() + " --> " + amanteDeLaPaja.getPajas());
		}
		
		
		
		// Ya leído el archivo, toca pedir las opciones que se harán a continuación
		System.out.println("""
				
				------------
				| MOD MENU |
				------------
				
				1 - RANKING
				2 - COMPARAR PAJEROS (pelea de pitos :3 )
				3 - LISTAR POR MES
				4 - PORCENTAJE DE DÍAS DONDE CAYÓ PAJA
				5 - CREDITOS
				 
				[ INSERTA UNA OPCIÓN ]
				
				""");
		
		String opcionModMenu = scan.next();
		
		// spin mai head around arooound
		while(true) {
			forkModMenu(opcionModMenu);
			System.out.println("[ INSERTA UNA OPCIÓN ]");
			opcionModMenu = scan.next();
			
		}

	}
	
	/** Menu para opciones una vez leído el archivo
	 * 
	 * @param opcion
	 */
	public static void forkModMenu(String opcion) {
		switch(opcion) {
		case "1":
			// Ranking de los pajeros según sus pajas
			ranking(Pajero.arrayPajeros);
			
			System.out.println("""
						------------------------------------------------
						| SALÓN DE LA FAMA DE LOS AMANTES DEL ONANISMO |
						------------------------------------------------""");
			
			for (Pajero pajeros : Pajero.arrayPajeros ) {
				System.out.println(pajeros.getNombre() + " --> " + pajeros.getPajas());
			}
		break;
		
		case "2": 
			// comparar(pajero1, pajero2)
			System.out.println("comparar");
		break;
		
		case "3":
			// listar(mes, año)
			System.out.println("listar");
		break;
		
		case "4":
			// porcentaje()
			System.out.println("porcentaje");
		break;
		
		case "5":
			creditos();
		break;
		
		default:
			System.out.println("NOOOO PUTISIMO ANORMAL, OPCION INCORRECTA");
		break;
		}
	}
	
	/** Modifica, por referencia, el ArrayList de Pajeros ordenando de más a menos pajeros
	 * 
	 * @param listaPajeros
	 */
	public static void ranking(ArrayList<Pajero> listaPajeros){
		 Collections.sort(listaPajeros, new Comparator<Pajero>() {
	            @Override
	            public int compare(Pajero p1, Pajero p2) {
	                return Integer.compare(p2.getPajas(), p1.getPajas());
	            }			
	        });
	}
	

	public static String preguntarFichero() {
		Scanner scan = new Scanner(System.in);
			
		System.out.println("Fichero a leer:");
		String fichero = scan.next();

		return fichero;
				
	}
	
	/** Función para crear instancias de fechas
	 * 
	 * @param tokenFecha
	 * @return Fecha fecha
	 */
	public static Fecha crearFecha(String tokenFecha) {
		
		tokenFecha = tokenFecha.replace('[', ' ');
		tokenFecha = tokenFecha.replace(',', ' ');
		tokenFecha = tokenFecha.trim();
		String[] partesFecha = tokenFecha.split("/");

		
		return new Fecha(
						Integer.parseInt(partesFecha[0]),
						Integer.parseInt(partesFecha[1]),
						Integer.parseInt(partesFecha[2])
						);
	}
	
	/** Función para ir guardando a amantes de la pallaringa
	 * 
	 * @param tokenNombre
	 * @return Pajero
	 */
	public static Pajero crearPajero(String tokenNombre) {
		tokenNombre = tokenNombre.replace('~', ' ');
		tokenNombre = tokenNombre.replace(':', ' ');
		tokenNombre = tokenNombre.trim();
		
		// Creamos una instancia de pajero. Si exista ya ese pajero,
		// lo borramos, si no existe, lo creamos
		return new Pajero(tokenNombre);

	}
	
	/** Función que dado un pajero y un token con ticks verdes, sumará los ticks al pajero en 
	 * 	cuestión
	 * 
	 * @param user
	 * @param ticks
	 */
	public static void verifPajas(Pajero user, String[] mensajeParaAnalizar) {
		
		for(String tokens : mensajeParaAnalizar) {
			
			if(tokens.equals("✅")) {
				//System.out.print(tokens);
				user.sumarUnaPaja();
			}	
		}
	}
	
	/** Función que preguntará al usuario si quiere leer o purgar un archivo.
	 * 	Purgar un archivo es crear un archivo nuevo donde no hay una sola línea que no 
	 * 	contenga ✅, para que las líneas a analizar no den erroer inseperados
	 * 
	 * @return opcion a elegir
	 */
	public static String menu() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("""
				Fichero encontrado correctamente.
				
				Elige la opción a continuación:
				1- LEER ARCHIVO (purgar primero para evitar errores)
				2- PURGAR ARCHIVO
				""");
		
		return scan.next();
	}
	
	/** Función que va a eliminar las líneas del archivo que no contengan ✅,
	 * 	para una lectura más facil.
	 * 
	 * @return nombre del fichero ya purgado
	 * @param nombreArchivo
	 * @throws FileNotFoundException 
	 */
	public static String purgar(String nombreArchivo) throws FileNotFoundException {
		
		//Leer archivo de orígen y preparar archivo de destino
		Scanner ficheroCrudo = new Scanner(new File (nombreArchivo));
		
		// Para dejarlo correctamente escrito, se busca dond eesta el '.', para que el fichero
		// se llama chat_purgado.txt, y no chat.txt_purgado.txt
		int posicionPunto = nombreArchivo.indexOf('.');
		
		// Se pilla desde el principio hasta que se halle el punto
		
		
		String nombreArchivoPurgado = nombreArchivo.substring(0, posicionPunto) + "_purgado.txt";
		PrintWriter archivoPurgado = new PrintWriter(new File (nombreArchivoPurgado));
		
		// Cada línea con ✅ se escribirá en un archivo nuevo
		while(ficheroCrudo.hasNextLine()) {
			
			String fraseActual = ficheroCrudo.nextLine();
			
			// Si encuentra el ✅ en la frase, lo escribirá en el archivo nuevo
			if(fraseActual.contains("✅") && !fraseActual.contains("Contador")) {
				archivoPurgado.println(fraseActual);
			}
		}
		
		archivoPurgado.close();
		
		// Devolverá el nombre del archivo nuevo, para poder ser usado en el Scanner ficheroEntrada
		return nombreArchivoPurgado;
	}
	
	/** Leerá todas las líneas del fichero purgado, y creará las instancias de los usuarios, sus pajas y las
	 * 	fechas necesarias.
	 * 
	 * @param nombreArchivo
	 */
	public static void leerPajasTotales(Scanner nombreArchivo) {
		while(nombreArchivo.hasNextLine()) {

		// EL PRIMER TOKEN DE CADA LINEA ES UNA FECHA
		Fecha primeraFecha = crearFecha(nombreArchivo.next());
	
		
		// SEGUNDO TOKEN ES LA HORA
		nombreArchivo.next();
		
		// TERCER TOKEN ES EL USER
		Pajero pajero = crearPajero(nombreArchivo.next());
		//System.out.println(pajero);
		
		Pajero seleccionarUltimo = pajero;
		
		//Con el pajero creado, si está en la lista de pajeros, lo borramos, si es un pajero nuevo, lo añadimor al arraylist y lo damops por bueno
		boolean seRepite = false;
		
		for (Pajero pajerosLista : Pajero.arrayPajeros){
			
			if(pajero.getNombre().equals(pajerosLista.getNombre())) {
				
				// Si ese pajero ya existe, lo seleccionamos para contar sus ticks
				seleccionarUltimo = pajerosLista;
				seRepite = true;
			}
		}
		
		if(!seRepite) {
			Pajero.arrayPajeros.add(seleccionarUltimo);
		}
		
		// TOKEN CON EL MENSAJE
		/*	Del mensaje que estamos mirando ahora mismo, lo convertimos en un array de strings,
		 * 	cada carácter siendo una casilla. Cada tick verde se sumará en la función que se está invocando,
		 * 	y sumará 1 por cada tick que encuentre al usuario seleccionado al final.
		 * 
		 */
		String[] mensaje = nombreArchivo.nextLine().split("");
		verifPajas(seleccionarUltimo, mensaje);
		
		//System.out.println(seleccionarUltimo.getNombre());
		//System.out.println(seleccionarUltimo.getPajas() + "\n");	
		}
	}
	
	
	/** ;)
	 * 
	 */
	public static void creditos() {
		System.out.println(""" 
				
				Creditos 
				yo XD 2024
				
				""");
	}
}