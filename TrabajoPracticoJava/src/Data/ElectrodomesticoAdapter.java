package Data;
import Entidades.*;

import java.sql.*;
import java.util.ArrayList;

import Data.DataConnectionManager;

import com.mysql.jdbc.Driver;


public class ElectrodomesticoAdapter {

	public ArrayList<Electrodomestico> getAll(){
		ArrayList<Electrodomestico> elecs = new ArrayList<Electrodomestico>();
		String sql="select * from electrodomestico";
		Statement sentencia=null;
		ResultSet rs=null;
		try {
			sentencia = DataConnectionManager.getInstancia().getConexion().createStatement();
			rs = sentencia.executeQuery(sql);
			while (rs.next()) {
				int idAct = rs.getInt("id_Electrodomestico");
				double pesoAct = rs.getFloat("peso");
				double pAct = rs.getDouble("precio");
				char cAct = (char)rs.getString("consumo").charAt(0);
				String colAct = rs.getString("color");
				//descripcion
				double cargaAct = rs.getDouble("carga");
				int resolAct = rs.getInt("resolucion");
				boolean sinAct = rs.getBoolean("sintonizador");
				String tipoAct = rs.getString("tipo_Electrodomestico");

				Electrodomestico elec;
				if(tipoAct.equals("lavarropas")){
					//Si es de tipo lavarropas, se asignan los valores de un lavarropas
					elec = new Lavarropas(idAct,pAct,cAct,colAct,pesoAct,cargaAct);
				}
				else {
					//Si no lo es, se asignan los valores de television
					elec = new Television(idAct,pAct,cAct,colAct,pesoAct,resolAct,sinAct);
				}	
				elecs.add(elec);
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
	
	public Electrodomestico getOne(int id)
	{
		String sql = "select * from electrodomestico where id=?";
		PreparedStatement sentencia=null;
		ResultSet rs=null;
		Electrodomestico eActual = null;
		try {
			sentencia = DataConnectionManager.getInstancia().getConexion().prepareStatement(sql);
			sentencia.setInt(1, id);
			rs = sentencia.executeQuery();
			if(rs.next()){
				if (rs.getString("tipo_Electrodomestico").equals("lavarropas")) {
					//Datos del lavarropas
					eActual = new Lavarropas(rs.getInt("id_Electrodomestico"),rs.getDouble("precio"),(char)rs.getString("consumo").charAt(0),rs.getString("color"),rs.getFloat("peso"),rs.getDouble("carga"));
				}
				else {
					//Datos de television
					eActual = new Television(rs.getInt("id_Electrodomestico"),rs.getDouble("precio"),(char)rs.getString("consumo").charAt(0),rs.getString("color"),rs.getFloat("peso"),rs.getInt("resolucion"),rs.getBoolean("sintonizador"));
				}
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
		return eActual;
	}
	
	public void addOne(Electrodomestico elec){
		String sql="insert into electrodomestico(precio,peso,carga,sintonizador,resolucion,color,consumo) values (?,?,?,?,?,?,?)";
		PreparedStatement sentencia= null;
		try {
			sentencia = DataConnectionManager.getInstancia().getConexion().prepareStatement(sql);
			sentencia.setDouble(1, elec.getPrecioBase());
			sentencia.setDouble(2, elec.getPeso());
			if (elec instanceof Lavarropas) {
				sentencia.setDouble(3, ((Lavarropas)elec).getCarga());
			}
			else
			{
				sentencia.setObject(3, null);
			}
			if (elec instanceof Television) {
				sentencia.setBoolean(4, ((Television)elec).isSintonizador());
				sentencia.setInt(5, ((Television)elec).getResolucion());
			}
			else
			{
				sentencia.setObject(4, null);
				sentencia.setObject(5, null);
			}
			//Color
			//ConsumoEnergetico
			sentencia.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try{
				if(sentencia!=null){sentencia.close();}
				if(sentencia!=null && !sentencia.isClosed()){sentencia.close();}
				DataConnectionManager.getInstancia().closeConexion();
			}
			catch (SQLException sqle){
				sqle.printStackTrace();
			}
		}
	}
	
	public void deleteOne(Electrodomestico elec)
    {
    	String sql = "DELETE FROM electrodomesticos WHERE id=?";
		
		PreparedStatement sentencia = null;
		ResultSet rs = null;
		
		try 
		{			
			sentencia = DataConnectionManager.getInstancia().getConexion().prepareStatement(sql);
			sentencia.setInt(1, elec.getId());
			sentencia.executeUpdate();					
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (rs!=null){rs.close();}
				if (sentencia!=null && !sentencia.isClosed())
				{
					sentencia.close();
				}
				DataConnectionManager.getInstancia().closeConexion();
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}
		}
    }
	
	public void updateOne (Electrodomestico elec)
	{
		String sql="UPDATE electrodomestico SET(precio=?,peso=?,carga=?,sintonizador=?,resolucion=?,color=?,consumo=?) WHERE id =?";
		PreparedStatement ps = null;
		try
		{
			ps = DataConnectionManager.getInstancia().getConexion().prepareStatement(sql);
			if (elec instanceof Lavarropas) {
				ps.setDouble(1, elec.getPrecioBase());
				ps.setDouble(2, elec.getPeso());
				ps.setDouble(3, ((Lavarropas)elec).getCarga());
				ps.setObject(4, null);
				ps.setObject(5, null);
				//Color
				//Consumo
				ps.setInt(8, elec.getId());
			}
			else 
			{
				ps.setDouble(1, elec.getPrecioBase());
				ps.setDouble(2, elec.getPeso());
				ps.setObject(3, null);
				ps.setBoolean(4, ((Television)elec).isSintonizador());
				ps.setInt(5, ((Television)elec).getResolucion());
				//Color
				//Consumo
				ps.setInt(8, elec.getId());
			}
			ps.execute();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try{
				if(ps!=null){ps.close();}
				DataConnectionManager.getInstancia().closeConexion();
			}
			catch (SQLException sqle){
				sqle.printStackTrace();
			}
		}
	}
	
}
