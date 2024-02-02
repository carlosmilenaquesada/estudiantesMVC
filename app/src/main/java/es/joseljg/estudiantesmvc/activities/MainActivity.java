package es.joseljg.estudiantesmvc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import es.joseljg.estudiantesmvc.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void gestionar_cursos(View view) {
        Intent intent = new Intent(this, GestionCursoActivity.class);
        startActivity(intent);
    }

    public void gestionar_estudiantes(View view) {
    }
}