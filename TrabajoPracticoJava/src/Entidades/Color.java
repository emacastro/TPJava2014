package Entidades;

public class Color {
	private static String[] colores = {"blanco", "negro", "rojo", "azul", "gris"};
	
	private String color;
	public static Color color_DEFAULT = new Color (colores[1]);
	
	public Color (String colorActual){
		this.color = colorActual;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public static String[] getColores() {
		return colores;
	}

	public static void setColores(String[] colores) {
		Color.colores = colores;
	}
	

	
}
