package Entidades;


public class Lavarropas extends Electrodomestico {
	private static int carga_DEFAULT = 5;
	private int carga;
	
	
	public int getCarga() {
		return carga;
	}


	public void setCarga(int carga) {
		this.carga = carga;
	}


	public Lavarropas(){
		super();
		this.setCarga(carga_DEFAULT);
	}
	
	public Lavarropas(int precio, double peso){
		super (precio, peso);
		this.setCarga(carga_DEFAULT);
	}
	
	public Lavarropas (int precio, char consumo, String color, double peso, int carga){
		super(precio, consumo, color, peso);
		this.setCarga(carga);
	}
	
	public double precioFinal(){
		double total = super.precioFinal();
		if (this.carga>30) {
			total+=50;
		}
		return total;
	}
}
