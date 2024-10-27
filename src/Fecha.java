
import java.util.ArrayList;

public class Fecha {

	// Propiedades
	private int dia;
	private int mes;
	private int año;
	private int pajasPorDia;
	private boolean bisiesto = (año % 4 == 0) && ((año % 100 != 0) || (año % 400 == 0));
	public ArrayList<Pajero> pajasEseMes = new ArrayList<Pajero>();
	
	// Constructor
	public Fecha(int dia, int mes, int año) {
		this.dia = dia;
		this.mes = mes;
		this.año = 2000 + año;
		pajasPorDia = 0;
	}
	
	// Metodos
	public int getDia() {
		return dia;
	}
	
	public int getMes() {
		return mes;
	}
	
	public int getAño() {
		return año;
	}
	
	public void añadirUnaPaja() {
		pajasPorDia++;
	}
	
	@Override
	public String toString() {
		return dia + "/" + mes + "/" + año; 
	}
}