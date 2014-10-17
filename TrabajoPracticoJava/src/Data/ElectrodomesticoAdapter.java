package Data;
import Entidades.*;

import java.sql.*;
import java.util.ArrayList;

import Data.DataConnectionManager;

import com.mysql.jdbc.Driver;

public class ElectrodomesticoAdapter {

	public ArrayList<Electrodomestico> getAll(){
		ArrayList<Electrodomestico> elecs = new ArrayList<Electrodomestico>();
		String sql="select id_Electrodomestico, descripcion, precio, peso, carga, sintonizador, resolucion, color, consumo from electrodomestico";
		Statement sentencia=null;
		ResultSet rs=null;
		try {
			sentencia = DataConnectionManager.getInstancia().getConexion().createStatement();
			rs = sentencia.executeQuery(sql);
			while (rs.next()) {
				Electrodomestico el = new Electrodomestico();
				//Usar la propiedad set  del precio, el consumo y el color
				//Como hago para pasar lo demas?
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally
		{
			try{
				if(rs!=null){rs.close();}
				if(sentencia!=null && !sentencia.isClosed()){sentencia.close();}
				DataConnectionManager.getInstancia().closeConexion();
			}
			catch (SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return elecs;
	}
	
	
}
