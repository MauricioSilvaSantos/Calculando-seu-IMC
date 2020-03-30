package com.example.calculandoseupeso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Main2Activity extends AppCompatActivity {

    private TextView textView;
    double numero1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.txtResultado);

        Intent OriginIntent = getIntent();
        DecimalFormat bd = new DecimalFormat("0.00");

        numero1 = Double.parseDouble(OriginIntent.getStringExtra(MainActivity.EXTRA_NUMBER));

        if (numero1 < 17) {
            textView.setText("Muito abaixo do peso\nIMC =" + numero1 );

        } else if (numero1 <= 17 && numero1 >= 18.49) {
            textView.setText("Abaixo do peso\nIMC =" + numero1);

        } else if (numero1 >= 18.50 && numero1 <= 24.99) {
            textView.setText("Peso normal \nIMC =" +numero1);

        } else if (numero1 >= 25 && numero1 <= 29.99) {
            textView.setText("Acima do peso\nIMC =" + numero1);

        } else if (numero1 >= 30 && numero1 <= 34.49) {
            textView.setText("Obesidade 1 \nIMC =" + numero1);
        } else if(numero1 >= 35 && numero1 <= 39.99) {
            textView.setText("Obesidade 2\nIMC =" + numero1);

        }else {
            textView.setText("Obesidade 3\nIMC ="+numero1);
        }
    }

    public void ClickAqui (View view){

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.natue.com.br/natuelife/saiba-tudo-sobre-o-imc.html"));
        startActivity(intent);

    }

}
