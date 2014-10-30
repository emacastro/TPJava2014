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
	/*
	
	public void eliminarElectrodomestico(int id)
	{
		electro.deleteOne(id);
	}*/
	
}
