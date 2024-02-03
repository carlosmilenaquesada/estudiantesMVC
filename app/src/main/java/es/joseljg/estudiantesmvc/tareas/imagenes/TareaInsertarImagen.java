package es.joseljg.estudiantesmvc.tareas.imagenes;

import java.util.concurrent.Callable;

import es.joseljg.estudiantesmvc.clases.Imagen;
import es.joseljg.estudiantesmvc.modelo.ImagenDB;

public class TareaInsertarImagen implements Callable<Boolean>{
	private Imagen imagen = null;

	public TareaInsertarImagen(Imagen imagen){
		this.imagen = imagen;
	}

	@Override
	public Boolean call() throws Exception{
		try{
			boolean insercionOK = ImagenDB.guardarImagen(imagen);
			return insercionOK;
		}catch(Exception e){
			return false;
		}
	}
}
