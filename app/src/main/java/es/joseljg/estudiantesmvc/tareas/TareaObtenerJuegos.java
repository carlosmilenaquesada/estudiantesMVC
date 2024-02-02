package es.joseljg.estudiantesmvc.tareas;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import es.joseljg.estudiantesmvc.clases.Juego;
import es.joseljg.estudiantesmvc.modelo.JuegoDB;

public class TareaObtenerJuegos implements Callable<ArrayList<Juego>>{
	@Override
	public ArrayList<Juego> call() throws Exception{
		ArrayList<Juego> juegos = JuegoDB.obtenerJuegos();
		return juegos;
	}
}
