package es.joseljg.estudiantesmvc.tareas.usuarios;

import java.util.concurrent.Callable;

import es.joseljg.estudiantesmvc.clases.Usuario;
import es.joseljg.estudiantesmvc.modeloDB.sentenciassql.UsuarioDB;

public class TareaInsertarUsuario implements Callable<Boolean>{
	private Usuario usuario = null;

	public TareaInsertarUsuario(Usuario usuario){
		this.usuario = usuario;
	}

	@Override
	public Boolean call() throws Exception{
		try{
			boolean insercionOK = UsuarioDB.crearUsuario(usuario);
			return insercionOK;
		}catch(Exception e){
			return false;
		}
	}
}
