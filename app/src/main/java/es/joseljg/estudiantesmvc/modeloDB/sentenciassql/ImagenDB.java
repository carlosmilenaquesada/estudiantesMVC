package es.joseljg.estudiantesmvc.modeloDB.sentenciassql;

import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import es.joseljg.estudiantesmvc.clases.Imagen;
import es.joseljg.estudiantesmvc.modeloDB.conexion.ConfiguracionDB;

public class ImagenDB{
	public static Imagen obtenerImagen(String idDeLaImagen){
		Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
		if(conexion == null){
			return null;
		}
		Imagen imagen =null;
		try{
			Statement sentencia = conexion.createStatement();
			String ordenSQL = "SELECT * FROM carlosmilena_imagenes WHERE (`idimagen` = ?);";
			PreparedStatement pst = conexion.prepareStatement(ordenSQL);
			pst.setString(1, idDeLaImagen);
			ResultSet resultado = sentencia.executeQuery(ordenSQL);
			if(resultado.next()){
				String idImagen = resultado.getString("idimagen");
				String imagenEnBlob = resultado.getString("imagen");
				imagen = new Imagen(idImagen, imagenEnBlob);
			}
			resultado.close();
			sentencia.close();
			conexion.close();
			return imagen;
		}catch(SQLException e){
			Log.i("sql", "error sql");
			return imagen;
		}
	}

	//-------------------------------------------------------------------------------
	public static boolean guardarImagen(Imagen imagen){
		Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
		if(conexion == null){
			return false;
		}
		try{
			String ordensql = "INSERT INTO carlosmilena_imagenes (idimagen,imagen) values (?,?);";
			PreparedStatement pst = conexion.prepareStatement(ordensql);
			pst.setString(1, imagen.getIdImagen());
			pst.setString(2, imagen.getImagenEnBlob());
			int filasafectadas = pst.executeUpdate();
			pst.close();
			conexion.close();
			if(filasafectadas > 0){
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			return false;
		}
	}

	//------------------------------------------------------------
	public static boolean borrarImagen(String idDeLaImagen){
		Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
		if(conexion == null){
			return false;
		}
		try{
			String ordensql = "DELETE FROM `carlosmilena_imagenes` WHERE (`idimagen` = ?);";
			PreparedStatement pst = conexion.prepareStatement(ordensql);
			pst.setString(1, idDeLaImagen);
			int filasafectadas = pst.executeUpdate();
			pst.close();
			conexion.close();
			if(filasafectadas > 0){
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			return false;
		}
	}

	//----------------------------------------------------------------------------------------------
	public static boolean actualizarImagen(Imagen imagenNew, String idImagenOld){
		Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
		if(conexion == null){
			return false;
		}
		try{
			String ordensql = "UPDATE carlosmilena_imagenes SET idimagen = ?, imagen = ? WHERE " +
							  "idimagen = ?";
			PreparedStatement pst = conexion.prepareStatement(ordensql);
			pst.setString(1, imagenNew.getIdImagen());
			pst.setString(2, imagenNew.getImagenEnBlob());
			pst.setString(3, idImagenOld);
			int filasAfectadas = pst.executeUpdate();
			pst.close();
			conexion.close();
			if(filasAfectadas > 0){
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			return false;
		}
	}
}
