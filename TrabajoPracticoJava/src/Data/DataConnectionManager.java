package Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataConnectionManager {
	
	private static DataConnectionManager instancia;
	private Connection conexion;
	
	private static String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static String URL_BASEDATOS = "jdbc:mysql://localhost:3306/DB_Electrodomesticos";
	
	
	public static DataConnectionManager getInstancia()
	{
		if(instancia==null)
		{
			instancia=new DataConnectionManager();
		}
		return instancia;
	}
	
	protected Connection getConexion() {
		try 
		{
			if(conexion==null || !conexion.isValid(3))
			{
				Class.forName(CONTROLADOR).newInstance();
				conexion = DriverManager.getConnection(URL_BASEDATOS, "root", "lemans123");		
			}
		} 
		catch (SQLException e) 
		{
			conexion=null;
		} 
		catch (Exception e) 
		{
			conexion=null;
		}
		return conexion;
	}
	
	private DataConnectionManager()
	{ 
	}
}