package es.joseljg.estudiantesmvc.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import es.joseljg.estudiantesmvc.R;
import es.joseljg.estudiantesmvc.controladores.JuegoController;

public class Actualizar_curso_Activity2 extends AppCompatActivity {

    private Curso cseleccionado = null;
    EditText edt_actualizar_curso = null;
    EditText edt_actualizar_descripcion = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_curso2);
        edt_actualizar_curso = (EditText) findViewById(R.id.edt_actualizar_curso);
        edt_actualizar_descripcion = (EditText) findViewById(R.id.edt_actualizar_descripcionc);

        Intent intent = getIntent();
        if(intent != null)
        {
            cseleccionado = (Curso) intent.getParcelableExtra(Actualizar_Curso_Activity1.EXTRA_OBJETO_CURSO);
            if(cseleccionado!=null)
            {
                edt_actualizar_curso.setText(String.valueOf(cseleccionado.getCurso()));
               // edt_actualizar_curso.setEnabled(false);
                edt_actualizar_descripcion.setText(cseleccionado.getDescripcion());
            }
        }
    }

    public void actualizarCurso2(View view) {
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("actualizar el curso?");
        //alerta1.setMessage(" no -> cancelar, si-> actualizar");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //actualizar provincia
                String curso = String.valueOf(String.valueOf(edt_actualizar_curso.getText()));
                String descripcion = String.valueOf(edt_actualizar_descripcion.getText());
                Curso c = new Curso(curso, descripcion);
                boolean actualizarOK = JuegoController.actualizarJuego(c, cseleccionado.getCurso());
                // recargar combo (o desde la base de datos volver a solicitar todo, o quitar solamente el item borrado)
                if(actualizarOK)
                {
                    // actualizo el desplegable de la pantalla activity1 (como sería el livedata)
                    Actualizar_Curso_Activity1.adapter.clear();
                    Actualizar_Curso_Activity1.cursos = JuegoController.obtenerJuegosController();
                    Actualizar_Curso_Activity1.adapter.addAll(Actualizar_Curso_Activity1.cursos);
                   mostrarToast("curso actualizado correctamente");
                }
                else{
                    mostrarToast("el curso no se pudo actualizar");
                }
            }
        });
        alerta1.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alerta1.show();
    }

    public void mostrarToast(String mensaje)
    {
       Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}