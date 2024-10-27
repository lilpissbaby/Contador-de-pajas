
import java.util.ArrayList;

public class Pajero {

	// Propiedades 
	private String nombre;
	private int total;
	private static int pajerosTotales;
	public static ArrayList<Pajero> arrayPajeros = new ArrayList<Pajero>();
	
	// Constructor 
	public Pajero (String nombre) {
		this.nombre = nombre.trim();
		total = 0;
		pajerosTotales++;
	}
	
	public Pajero (String nombre, int pajas) {
		this.nombre = nombre;
		total = pajas;
		pajerosTotales++;
	}
	
	// Métodos
	@Override
	public String toString() {
		return nombre;
	}
	
	public void actualizarPajas(int pajasAñadidas) {
		total += pajasAñadidas;
	}
	
	public void sumarUnaPaja() {
		total++;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getPajas() {
		return total;
	}
	

		// Pajas en un dia 
	
		// Pajas en un mes
	
		// Pajas en un año
	
		// Calcular promedio de pajas
	
		// Diferencia entre este mes y el anterior
	
		// 
}