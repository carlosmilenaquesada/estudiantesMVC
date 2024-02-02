package es.joseljg.estudiantesmvc.modelo;

import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import es.joseljg.estudiantesmvc.clases.Usuario;

public class UsuarioDB{
	public static Usuario obtenerUsuario(String emailUsuario){
		Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
		if(conexion == null){
			return null;
		}
		Usuario usuario = new Usuario();
		try{
			Statement sentencia = conexion.createStatement();
			String ordenSQL = "SELECT * FROM carlosmilena_usuarios WHERE (`email` = ?);";
			PreparedStatement pst = conexion.prepareStatement(ordenSQL);
			pst.setString(1, emailUsuario);
			ResultSet resultado = sentencia.executeQuery(ordenSQL);
			if(resultado.next()){
				String email = resultado.getString("email");
				String password = resultado.getString("password");
				usuario = new Usuario(email, password);
			}
			resultado.close();
			sentencia.close();
			conexion.close();
			return usuario;
		}catch(SQLException e){
			Log.i("sql", "error sql");
			return usuario;
		}
	}

	public static boolean crearUsuario(Usuario usuario){
		Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
		if(conexion == null){
			return false;
		}
		try{
			String ordensql = "INSERT INTO carlosmilena_usuarios (email,password) values (?,?);";
			PreparedStatement pst = conexion.prepareStatement(ordensql);
			pst.setString(1, usuario.getEmail());
			pst.setString(2, usuario.getPassword());
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
}