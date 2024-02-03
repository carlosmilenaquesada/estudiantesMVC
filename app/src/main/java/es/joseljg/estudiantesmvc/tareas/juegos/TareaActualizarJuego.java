package es.joseljg.estudiantesmvc.tareas.juegos;

import java.util.concurrent.Callable;

import es.joseljg.estudiantesmvc.clases.Juego;
import es.joseljg.estudiantesmvc.modeloDB.sentenciassql.JuegoDB;


public class TareaActualizarJuego implements Callable<Boolean> {
    private Juego juegoNew = null;
    private String idJuegoOld = null;

    public TareaActualizarJuego(Juego juegoNew, String idJuegoOld) {
        this.juegoNew = juegoNew;
        this.idJuegoOld = idJuegoOld;
    }

    @Override
    public Boolean call() throws Exception {
        try{
            boolean actualizadoOK = JuegoDB.actualizarJuego(juegoNew, idJuegoOld);
            return actualizadoOK;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
