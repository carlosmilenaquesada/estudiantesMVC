package es.joseljg.estudiantesmvc.tareas.usuarios;

import java.util.concurrent.Callable;

import es.joseljg.estudiantesmvc.clases.Usuario;
import es.joseljg.estudiantesmvc.modeloDB.sentenciassql.UsuarioDB;

public class TareaObtenerUsuario implements Callable<Usuario>{
	private String email;
	private String password;

	public TareaObtenerUsuario(String email, String password){
		this.email = email;
		this.password = password;
	}

	@Override
	public Usuario call() throws Exception{
		Usuario usuario = UsuarioDB.obtenerUsuario(email, password);
		return usuario;
	}
}


