package es.joseljg.estudiantesmvc.tareas.imagenes;

import java.util.concurrent.Callable;

import es.joseljg.estudiantesmvc.clases.Imagen;
import es.joseljg.estudiantesmvc.modeloDB.sentenciassql.ImagenDB;

public class TareaActualizarImagen implements Callable<Boolean>{
	private Imagen imagenNew = null;
	private String idImagenOld = null;

	public TareaActualizarImagen(Imagen imagenNew, String idImagenOld) {
		this.imagenNew = imagenNew;
		this.idImagenOld = idImagenOld;
	}

	@Override
	public Boolean call() throws Exception {
		try{
			boolean actualizadoOK = ImagenDB.actualizarImagen(imagenNew, idImagenOld);
			return actualizadoOK;
		}
		catch (Exception e)
		{
			return false;
		}
	}
}
