package com.josrangel.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SegundaActividad extends AppCompatActivity {

    private static String CLASE = MainActivity.class.getName();
    public static String EXTRA_NOMBRE = "SegundaActividad.nombre";
    private static int EXTRA_MESSAGE = 1;

    EditText editText;
    Button btn;
    TextView tvRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);

        editText = findViewById(R.id.etTexto2);
        btn = findViewById(R.id.button2);
        tvRespuesta = findViewById(R.id.tvRespuesta2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresaRespuesta();
            }
        });

        Intent i = getIntent();

        if(i != null){
            tvRespuesta.setText(i.getStringExtra(MainActivity.EXTRA_NOMBRE));
        }
    }

    public void regresaRespuesta(){
        Log.i(CLASE,"Click en el button");
        Intent intent =  new Intent(this, SegundaActividad.class);
        String mensaje = editText.getText().toString();
        intent.putExtra(EXTRA_NOMBRE,mensaje);
        setResult(RESULT_OK, intent);
        finish();
    }
}