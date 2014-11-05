package Negocio;
import Data.ElectrodomesticoAdapter;
import Entidades.*;

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
	
	public void nuevoElectrodomestico(Electrodomestico elec)
	{
		electro.addOne(elec);
	}
	
	public int ultimoID()
	{
		return electro.ultimoID();
	}
	
	public void modificarElectrodomestico (Electrodomestico elec, String tipo)
	{
		electro.updateOne(elec, tipo);
	}
	
	
	public void eliminarElectrodomestico(int id)
	{
		electro.deleteOne(id);
	}
	
}
