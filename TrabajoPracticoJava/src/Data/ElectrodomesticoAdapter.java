package Data;
import Entidades.*;

import java.sql.*;
import java.util.ArrayList;

import Data.DataConnectionManager;


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
				String tipoAct = rs.getString("tipo_Electrodomestico");
				double pAct = rs.getDouble("precio");
				double pesoAct = rs.getFloat("peso");
				char cAct = (rs.getString("consumo")).charAt(0);
				String colAct = rs.getString("color");
				double cargaAct = rs.getDouble("carga");
				int resolAct = rs.getInt("resolucion");
				boolean sinAct = rs.getBoolean("sintonizador");
				
				Electrodomestico elec;
				if(tipoAct.equals("lavarropas")){
					//Si es de tipo lavarropas, se asignan los valores de un lavarropas
					Lavarropas lava = new Lavarropas(idAct,pAct,cAct,colAct,pesoAct,cargaAct);
					elec = lava;
				}
				else {
					//Si no lo es, se asignan los valores de television
					Television tele = new Television(idAct,pAct,cAct,colAct,pesoAct,resolAct,sinAct);
					elec = tele;
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
		String sql="insert into electrodomestico(tipo_Electrodomestico,precio,peso,carga,sintonizador,resolucion,color,consumo) values (?,?,?,?,?,?,?,?)";
		PreparedStatement sentencia= null;
		try {
			sentencia = DataConnectionManager.getInstancia().getConexion().prepareStatement(sql);
			//sentencia.setInt(1, elec.getId());
			
			sentencia.setDouble(2, elec.getPrecioBase());
			sentencia.setDouble(3, elec.getPeso());
			if (elec instanceof Lavarropas) {
				sentencia.setString(1, "lavarropas");
				sentencia.setDouble(4, ((Lavarropas)elec).getCarga());
			}
			else
			{
				sentencia.setObject(4, null);
			}
			if (elec instanceof Television) {
				sentencia.setString(1, "television");
				sentencia.setBoolean(5, ((Television)elec).isSintonizador());
				sentencia.setInt(6, ((Television)elec).getResolucion());
			}
			else
			{
				sentencia.setObject(5, null);
				sentencia.setObject(6, null);
			}
			sentencia.setString(7, elec.getColor().getColor());
			String consen = String.valueOf(elec.getConsumo().getConsumo());
			sentencia.setString(8, consen.substring(0,1));
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
	
	public void deleteOne(int id)
    {
    	String sql = "DELETE FROM electrodomestico WHERE id_Electrodomestico="+id;
		
		Statement sentencia = null;
		
		try 
		{			
			sentencia = DataConnectionManager.getInstancia().getConexion().createStatement();
			sentencia.executeUpdate(sql);	
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
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
	
	public void updateOne (Electrodomestico elec, String tipo)
	{
		String sql="UPDATE electrodomestico SET(precio=?,peso=?,carga=?,sintonizador=?,resolucion=?,color=?,consumo=?) WHERE id =?";
		PreparedStatement ps = null;
		try
		{
			//probar sacando el color, consumo e id fuera del if
			ps = DataConnectionManager.getInstancia().getConexion().prepareStatement(sql);
			if (elec instanceof Lavarropas) {
				ps.setDouble(1, elec.getPrecioBase());
				ps.setDouble(2, elec.getPeso());
				ps.setDouble(3, ((Lavarropas)elec).getCarga());
				ps.setObject(4, null);
				ps.setObject(5, null);
				ps.setString(6, elec.getColor().getColor());
				String consen = String.valueOf(elec.getConsumo().getConsumo());
				ps.setString(7, consen.substring(0,1));
				ps.setInt(8, elec.getId());
			}
			else 
			{
				ps.setDouble(1, elec.getPrecioBase());
				ps.setDouble(2, elec.getPeso());
				ps.setObject(3, null);
				ps.setBoolean(4, ((Television)elec).isSintonizador());
				ps.setInt(5, ((Television)elec).getResolucion());
				ps.setString(6, elec.getColor().getColor());
				String consen = String.valueOf(elec.getConsumo().getConsumo());
				ps.setString(7, consen.substring(0,1));
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
	
	public int ultimoID()
	{
		String sql="select * from electrodomestico";
		Statement sentencia=null;
		ResultSet rs=null;
		int cont=0;
		try {
			sentencia = DataConnectionManager.getInstancia().getConexion().createStatement();
			rs = sentencia.executeQuery(sql);
			while(rs.next()){
				cont++;
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
		return cont;
	}
	
}
