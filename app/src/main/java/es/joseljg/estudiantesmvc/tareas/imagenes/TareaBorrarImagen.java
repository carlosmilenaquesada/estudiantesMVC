package es.joseljg.estudiantesmvc.tareas.imagenes;

import java.util.concurrent.Callable;

import es.joseljg.estudiantesmvc.modeloDB.sentenciassql.ImagenDB;

public class TareaBorrarImagen implements Callable<Boolean>{
	private String idImagen = null;

	public TareaBorrarImagen(String idImagen){
		this.idImagen = idImagen;
	}

	@Override
	public Boolean call() throws Exception{
		try{
			boolean borradoOK = ImagenDB.borrarImagen(idImagen);
			return borradoOK;
		}catch(Exception e){
			return false;
		}
	}
}

