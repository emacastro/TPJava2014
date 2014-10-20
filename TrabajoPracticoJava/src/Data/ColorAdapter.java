package Data;

import java.util.ArrayList;

import Data.DataConnectionManager;
import Entidades.Color;

import java.sql.*;

public class ColorAdapter {

	public ArrayList<Color> getColores()
	{
		ArrayList<Color> colores = new ArrayList<Color>();
		String sql = "select * from color";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = DataConnectionManager.getInstancia().getConexion().createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				Color cl = new Color(rs.getString("nombre"));
				colores.add(cl);
			}
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
		finally
		{
			try{
				if(rs!=null){rs.close();}
				if(st!=null && !st.isClosed()){st.close();}
				DataConnectionManager.getInstancia().closeConexion();
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}
		return colores;
	}
	
	public Color getColorByNombre(String nombre)
	{
		String sql="select nombre from color where nombre=?";
		
		PreparedStatement st=null;
		ResultSet rs=null;
		Color cl=null;
		try {
			st = DataConnectionManager.getInstancia().getConexion().prepareStatement(sql);
			st.setString(1, nombre);
			rs = st.executeQuery();
			if (rs.next()) {
				cl = new Color(rs.getString("nombre"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try{
				if(rs!=null){rs.close();}
				if(st!=null && !st.isClosed()){st.close();}
				DataConnectionManager.getInstancia().closeConexion();
			}
			catch (SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return cl;
	}
	
	
}
