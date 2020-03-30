package com.example.calculandoseupeso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NUMBER = "com.example.calculandoseupeso.PAR2";
    private EditText editPeso, editAltura;
    private TextView textResul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencias editPeso,editAltura,textResul.
        editPeso = (EditText)findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
        textResul = findViewById(R.id.textResul);
    }
    //Method
    public void calculoImc(View view){

        //Recuperando Valores
        String peso =  editPeso.getText().toString();
        String altura = editAltura.getText().toString();

        //Verificando se campos foram preenchidos.
        Boolean validandoCampo = ValidarCampos(peso, altura);
        if (validandoCampo) {
            Double valorPeso = Double.parseDouble(peso);
            Double valorAltura = Double.parseDouble(altura);
            Double resultado = valorPeso / (valorAltura * valorAltura);

            Intent intentObj = new Intent(MainActivity.this, Main2Activity.class);
            intentObj.putExtra(EXTRA_NUMBER, String.valueOf(resultado));
            startActivity(intentObj);
        }else {
            textResul.setText("Informe os Valores!");
        }
    }

    public Boolean ValidarCampos (String valorPeso, String valorAltura){

        Boolean validarCampo = true;
        if (valorPeso == null || valorPeso.equals("")){
            validarCampo = false;

        }else if (valorAltura == null || valorAltura.equals("")){
            validarCampo = false;
        }
        return validarCampo;
    }

}
