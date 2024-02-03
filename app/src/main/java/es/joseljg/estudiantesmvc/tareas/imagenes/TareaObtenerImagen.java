package es.joseljg.estudiantesmvc.tareas.imagenes;

import java.util.concurrent.Callable;

import es.joseljg.estudiantesmvc.clases.Imagen;
import es.joseljg.estudiantesmvc.modelo.ImagenDB;

public class TareaObtenerImagen implements Callable<Imagen>{
	private String idImagen;

	public TareaObtenerImagen(String idImagen){
		this.idImagen = idImagen;
	}

	@Override
	public Imagen call() throws Exception{
		Imagen imagen = ImagenDB.obtenerImagen(idImagen);
		return imagen;
	}
}
