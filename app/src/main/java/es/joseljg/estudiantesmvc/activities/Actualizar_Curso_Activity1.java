package es.joseljg.estudiantesmvc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import es.joseljg.estudiantesmvc.R;
import es.joseljg.estudiantesmvc.controladores.JuegoController;

public class Actualizar_Curso_Activity1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String EXTRA_OBJETO_CURSO = "es.joseljg.actualizarcurso1.objeto_curso";
    private Spinner sp_actualizarc = null;
    private Curso cseleccionado = null;
    static ArrayAdapter<Curso> adapter = null;
    static ArrayList<Curso> cursos = null;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_curso1);
        sp_actualizarc = (Spinner) findViewById(R.id.sp_actualizarc);
        sp_actualizarc.setOnItemSelectedListener(this);
        cursos = JuegoController.obtenerJuegosController();
        if(cursos != null) {
             asignarAdaptadorSpinnerCursos(cursos);
        }
        else{
             Toast.makeText(this, "no hay cursos", Toast.LENGTH_SHORT).show();
        }
        //-----------------------------------------------------------
    }

    public void mostrarToast(String mensaje)
    {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    private void asignarAdaptadorSpinnerCursos(ArrayList<Curso> cursos) {
        adapter = new ArrayAdapter<Curso>(this , R.layout.item_curso, cursos);
        sp_actualizarc.setAdapter(adapter);
    }

    public void siguienteactualizarcurso(View view) {
        if(cseleccionado == null)
        {
            mostrarToast("selecciona un curso");
            return;
        }

        Intent intent = new Intent(this, Actualizar_curso_Activity2.class);
        intent.putExtra(EXTRA_OBJETO_CURSO, cseleccionado);
        //  Toast.makeText(this,"el curso seleccionado es " +cseleccionado.getCurso(), Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Curso c = (Curso) sp_actualizarc.getItemAtPosition(position);
        cseleccionado = c;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}