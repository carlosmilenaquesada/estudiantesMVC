package es.joseljg.estudiantesmvc.tareas.juegos;

import java.util.concurrent.Callable;

import es.joseljg.estudiantesmvc.clases.Juego;
import es.joseljg.estudiantesmvc.modeloDB.sentenciassql.JuegoDB;


public class TareaInsertarJuego implements Callable<Boolean> {
    private Juego juego = null;

    public TareaInsertarJuego(Juego juego) {
        this.juego = juego;
    }

    @Override
    public Boolean call() throws Exception {
        try{
            boolean insercionOK = JuegoDB.guardarJuego(juego);
            return insercionOK;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
