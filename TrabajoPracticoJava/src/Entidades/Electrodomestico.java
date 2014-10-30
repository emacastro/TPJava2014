package Entidades;

import Data.ElectrodomesticoAdapter;


public class Electrodomestico {
	private static double precio_DEFAULT = 100;
	private static double peso_DEFAULT = 5;
	private int id;
	private double precioBase;
	private ConsumoEnergetico consumo;
	private Color color;
	private double peso;
	
	private static int id_FINAL;
	
	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}


	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	

	public ConsumoEnergetico getConsumo() {
		return consumo;
	}

	public void setConsumo(ConsumoEnergetico consumo) {
		this.consumo = consumo;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int Id)
	{
		this.id = Id;
	}

	public Electrodomestico () {
		//aumentaID();
		this.setPrecioBase(precio_DEFAULT);
		this.setConsumo(ConsumoEnergetico.consumo_DEFAULT);
		this.setColor(Color.color_DEFAULT);
		this.setPeso(peso_DEFAULT);
	}
	
	public Electrodomestico(double precio, double peso ){
		//aumentaID();
		this.setPrecioBase(precio);
		this.setConsumo(ConsumoEnergetico.consumo_DEFAULT);
		this.setColor(Color.color_DEFAULT);
		this.setPeso(peso);
	}
	
	public Electrodomestico (double precio, char consumo, String color, double peso){
		//aumentaID();
		verificaDatos(precio, consumo, color, peso);
	}
	
	public Electrodomestico (int id, double precio, char consumo, String color, double peso){
		this.id = id;
		verificaDatos(precio, consumo, color, peso);
	}

	public void verificaDatos(double precio, char consumo, String color,double peso)
	{
		this.setPrecioBase(precio);
		if(comprobarConsumoEnergetico(consumo)){
			this.setConsumo(new ConsumoEnergetico(consumo));
		} else{
			this.setConsumo(ConsumoEnergetico.consumo_DEFAULT);
		}
		if(comprobarColor(color)){
			this.setColor(new Color(color));
		} else {
			this.setColor(Color.color_DEFAULT);
		}
		this.setPeso(peso);
	}
	
	
	
	public boolean comprobarConsumoEnergetico (char letra){
		boolean rta=false;
		for (int i = 0; i < ConsumoEnergetico.getTipos().length; i++) {
			if (letra == ConsumoEnergetico.getTipos()[i]) {
				return rta= true;
			}
		} 
		return rta;
	}

	public boolean comprobarColor(String color){
		boolean rta = false;
		for (int i = 0; i < Color.getColores().length; i++) {
			if (color.equals(Color.getColores()[i])) {
				return rta= true;
			} 
		} 
		return rta;
	}
	
	public int precioPorPeso(double peso){
		int valor = 0;
		if (peso >= 80){
			valor = 100;
		} else if(peso >= 50){
			valor = 80;
		} else if(peso >= 20){
			valor = 50;
		} else if(peso >= 0) {
			valor = 10;
		}
		return valor;
	} 
	
	public double precioFinal(){
		return this.getPrecioBase() + this.precioPorPeso(getPeso()) + this.getConsumo().precioPorConsumo();
	}
	
	public void aumentaID(){
		id_FINAL += 1;
		this.id = id_FINAL;
		
	}
}
