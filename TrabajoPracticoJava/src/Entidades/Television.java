package Entidades;

public class Television extends Electrodomestico {
	private static int resolucion_DEFAULT = 20;
	private static boolean sintonizador_DEFAULT = false;
	
	private int resolucion;
	private boolean sintonizador;
	
	public int getResolucion() {
		return resolucion;
	}
	public void setResolucion(int resolucion) {
		this.resolucion = resolucion;
	}
	public boolean isSintonizador() {
		return sintonizador;
	}
	public void setSintonizador(boolean sintonizador) {
		this.sintonizador = sintonizador;
	}
	
	public Television(){
		super();
		this.setResolucion(resolucion_DEFAULT);
		this.setSintonizador(sintonizador_DEFAULT);
	}
	
	public Television (int precio, double peso){
		super (precio,peso);
		this.setResolucion(resolucion_DEFAULT);
		this.setSintonizador(sintonizador_DEFAULT);
	}
	
	public Television (double precio, char consumo, String color, double peso, int resolucion, boolean sintonizador){
		super(precio, consumo, color, peso);
		this.setResolucion(resolucion);
		this.setSintonizador(sintonizador);
	}
	
	public Television (int id, double precio, char consumo, String color, double peso, int resolucion, boolean sintonizador){
		super(id, precio, consumo, color, peso);
		this.setResolucion(resolucion);
		this.setSintonizador(sintonizador);
	}
	
	public double precioFinal(){
		double total = super.precioFinal();
		if (this.resolucion>40) {
			double porcentaje = total*30/100;
			total += porcentaje;
		}
		if (this.sintonizador){
			total+=50;
		}
		return total;
	}
}
