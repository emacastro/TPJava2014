package Entidades;

public class ConsumoEnergetico {
	private static char[] tipos = {'A','B','C','D','E','F'};
	private char consumo;
	public static ConsumoEnergetico consumo_DEFAULT = new ConsumoEnergetico (tipos[5]);
	
	public ConsumoEnergetico(char consumoActual ){
		this.consumo = consumoActual;
	}
	
	public static char[] getTipos() {
		return tipos;
	}


	public static void setTipos(char[] tipos) {
		ConsumoEnergetico.tipos = tipos;
	}

	public char getConsumo() {
		return consumo;
	}

	public void setConsumo(char consumo) {
		this.consumo = consumo;
	}

	public double precioPorConsumo(){
		int valor = 0;
		switch (this.getConsumo()) {
		case 'A':
			valor = 100;
		case 'B':
			valor = 80;
		case 'C':
			valor = 60;
		case 'D':
			valor = 40;
		case 'E':
			valor = 20;
		case 'F':
			valor = 10;
		}
		return valor;
	}


	

}
