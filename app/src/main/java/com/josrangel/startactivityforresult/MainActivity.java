package com.josrangel.startactivityforresult;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static String CLASE = MainActivity.class.getName();
    public static String EXTRA_NOMBRE = "MainActivity.nombre";
    private static int EXTRA_MESSAGE = 1;

    EditText editText;
    Button btn;
    TextView tvRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.etTexto1);
        btn = findViewById(R.id.button);
        tvRespuesta = findViewById(R.id.tvRespuesta);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarSegundaVista();
            }
        });
    }

    public void lanzarSegundaVista(){
        Log.i(CLASE,"Click en el button");
        Intent intent =  new Intent(this, SegundaActividad.class);
        String mensaje = editText.getText().toString();
        intent.putExtra(EXTRA_NOMBRE,mensaje);
        intent.putExtra("Titulo",mensaje);
        startActivityForResult(intent,EXTRA_MESSAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(CLASE,"onActivityResult");
        if (requestCode == EXTRA_MESSAGE){
            if( resultCode ==RESULT_OK){
                String respuesta = data.getStringExtra(SegundaActividad.EXTRA_NOMBRE);

                tvRespuesta.setText(respuesta);
            }
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String guardado = savedInstanceState.getString("mensaje","");
        tvRespuesta.setText(guardado);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("mensaje",tvRespuesta.getText().toString());
    }
}