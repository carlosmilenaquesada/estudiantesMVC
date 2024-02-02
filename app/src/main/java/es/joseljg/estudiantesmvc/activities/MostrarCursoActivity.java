package es.joseljg.estudiantesmvc.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.joseljg.estudiantesmvc.R;
import es.joseljg.estudiantesmvc.controladores.JuegoController;

public class MostrarCursoActivity extends AppCompatActivity {

    private RecyclerView rv_cursos;
    private ListaCursosAdapter mAdapter;
    private List<Curso> cursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_curso);
        rv_cursos = findViewById(R.id.rv_cursos);

        mAdapter = new ListaCursosAdapter(this);
        ArrayList<Curso> cursos = JuegoController.obtenerJuegosController();
        if(cursos != null) {
                    mAdapter.setListaCursos(cursos);
        }
        //------------------------------------------------------------
        rv_cursos.setAdapter(mAdapter);
        rv_cursos.setLayoutManager(new LinearLayoutManager(this));
        //------------------------------------------------------------
/*
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(cursos, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                if(direction == ItemTouchHelper.LEFT)
                {
                    mostrarToast("ha pulsado izquierda");
                    // Curso c = curso.get(viewHolder.getAdapterPosition());
                    // JuegoController.borrarJuego(c);
                    cursos.remove(viewHolder.getAdapterPosition());
                    mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
                if(direction == ItemTouchHelper.RIGHT)
                {
                    mostrarToast("ha pulsado derecha");
                    cursos.remove(viewHolder.getAdapterPosition());
                    mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
            }
        });
        helper.attachToRecyclerView(rv_cursos);
*/

    }

    private void mostrarToast(String texto) {
        Toast.makeText(this,texto, Toast.LENGTH_SHORT).show();
    }

}