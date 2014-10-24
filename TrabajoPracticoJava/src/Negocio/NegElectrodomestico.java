package Negocio;
import Data.ElectrodomesticoAdapter;
import Entidades.Electrodomestico;

import java.util.ArrayList;

public class NegElectrodomestico {

	private ElectrodomesticoAdapter electro;
	
	public NegElectrodomestico()
	{
		electro = new ElectrodomesticoAdapter();
	}

	public ElectrodomesticoAdapter getElectro() {
		return electro;
	}
	
	public ArrayList<Electrodomestico> listarElectrodomesticos()
    {
        return electro.getAll();
    }
	
	/*public void nuevoElectrodomestico(double precio_base, double peso, String color, char consumo, double carga, int resolucion, boolean tdt)
	{
		electro.addOne(precio_base, peso, color, consumo, carga, resolucion, tdt);
	}
	
	public void modificarElectrodomestico(int id_e, double p_base, double p, String color, char consumo, double c, int r, boolean t)
	{
		electro.updateOne(id_e, p_base, p, color, consumo, c, r, t);
	}
	
	public void eliminarElectrodomestico(int id)
	{
		electro.deleteOne(id);
	}*/
}
