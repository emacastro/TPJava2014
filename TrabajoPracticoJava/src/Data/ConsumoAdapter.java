package Data;

import java.util.ArrayList;

import Data.DataConnectionManager;
import Entidades.ConsumoEnergetico;
import java.sql.*;

public class ConsumoAdapter {

	public ArrayList<ConsumoEnergetico> getConsumos ()
	{
		ArrayList<ConsumoEnergetico> consumos = new ArrayList<ConsumoEnergetico>();
		String sql = "select * from consumo";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = DataConnectionManager.getInstancia().getConexion().createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				ConsumoEnergetico ce = new ConsumoEnergetico((char)rs.getString("consumo").charAt(0));
				consumos.add(ce);
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
		return consumos;
	}
	
	public ConsumoEnergetico getConsumoByTipo(char tipo)
	{
		String sql="select tipo, precio from consumo where tipo=?";
		
		PreparedStatement st=null;
		ResultSet rs=null;
		ConsumoEnergetico ce=null;
		try {
			st = DataConnectionManager.getInstancia().getConexion().prepareStatement(sql);
			String tipoString = String.valueOf(tipo);
			st.setString(1, tipoString);
			rs = st.executeQuery();
			if (rs.next()) {
				ce = new ConsumoEnergetico((char)rs.getString("consumo").charAt(0));
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
		return ce;
	}
}
