package Entidades;


public class Lavarropas extends Electrodomestico {
	private static double carga_DEFAULT = 5;
	private double carga;
	
	
	public double getCarga() {
		return carga;
	}


	public void setCarga(double carga) {
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
	
	public Lavarropas (double precio, char consumo, String color, double peso, double carga){
		super(precio, consumo, color, peso);
		this.setCarga(carga);
	}
	
	public Lavarropas(int id,double precio,char consumo,String color,double peso,double carga) {
		super(id,precio,consumo,color,peso);
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
