package Negocio;
import java.util.ArrayList;

import Data.ColorAdapter;
import Entidades.Color;

public class NegColor {

	private ColorAdapter color;
	
	public NegColor()
	{
		color = new ColorAdapter();
	}
	
	public ArrayList<Color> listarColores ()
	{
		return color.getColores();
	}
	
	
}
