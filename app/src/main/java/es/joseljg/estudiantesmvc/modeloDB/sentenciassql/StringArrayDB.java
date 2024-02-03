package es.joseljg.estudiantesmvc.modeloDB.sentenciassql;

import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.joseljg.estudiantesmvc.modeloDB.conexion.ConfiguracionDB;

public class StringArrayDB{
	//ALGUNOS ELEMENTOS DE LA BASE DE DATOS, NO NECESITAN SER TRAIDOS Y TRATADOS COMO UNA CLASE, YA
	//QUE NO VAN A SUFRIR NINGÚN TIPO DE MODIFICACIÓN, INSERCIÓN O BORRADO, PARA ELLO HE CREADO
	//ESTA CLASE, PARA QUE SOLAMENTE ME TRAIGA UNA COLECCIÓN DE ELEMENTOS EN FORMA DE ARRAY DE
	// STRING.
	//POR EJEMPLO, PARA LAS CONSOLAS, GÉNEROS, ETC. CUYA EXISTENCIA SOLO SIRVE PARA RELLENAR UN
	// SPINNER
	//PARA DAR UN VALOR A UN ATRIBUTO DE LA CLASE JUEGO.
	public static ArrayList<String> obtenerStringArray(String tabla, String columna){
		Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
		if(conexion == null){
			return null;
		}
		ArrayList<String> elementos = new ArrayList<String>();
		try{
			Statement sentencia = conexion.createStatement();
			String ordenSQL =
					"SELECT '" + columna + "' FROM '" + tabla + "' ORDER BY '" + columna + "'";
			ResultSet resultado = sentencia.executeQuery(ordenSQL);
			while(resultado.next()){
				elementos.add(resultado.getString(columna));
			}
			resultado.close();
			sentencia.close();
			conexion.close();
			return elementos;
		}catch(SQLException e){
			Log.i("sql", "error sql");
			return elementos;
		}
	}
}
