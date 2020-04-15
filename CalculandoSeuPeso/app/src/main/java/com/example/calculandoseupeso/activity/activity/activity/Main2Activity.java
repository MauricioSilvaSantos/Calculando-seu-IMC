package com.example.calculandoseupeso.activity.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculandoseupeso.R;
import com.example.calculandoseupeso.activity.activity.adapter.AdapterImc;
import com.example.calculandoseupeso.activity.activity.model.RecycleViewCLickListener;
import com.example.calculandoseupeso.activity.activity.model.TabelaImc;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private TextView textView;
    double numero1;
    private RecyclerView recyclerView ;
    private List<TabelaImc> listaImc = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.txtResultado);
        recyclerView = findViewById(R.id.recyclerView);

        //Lista do IMC
        this.criarTabelaImc();

        //Configurar adapter
        AdapterImc adapterImc = new AdapterImc(listaImc);

        //Configurar RecycleView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapterImc);

        Intent OriginIntent = getIntent();
        DecimalFormat bd = new DecimalFormat("0.00");

        numero1 = Double.parseDouble(OriginIntent.getStringExtra(MainActivity.EXTRA_NUMBER));

        if (numero1 < 17) {
            textView.setText("Muito abaixo do peso\nIMC =" + numero1);

        } else if (numero1 <= 17 && numero1 >= 18.49) {
            textView.setText("Abaixo do peso\nIMC =" + numero1);

        } else if (numero1 >= 18.50 && numero1 <= 24.99) {
            textView.setText("Peso normal \nIMC =" + numero1);

        } else if (numero1 >= 25 && numero1 <= 29.99) {
            textView.setText("Sobrepeso\nIMC =" + numero1);

        } else if (numero1 >= 30 && numero1 <= 34.49) {
            textView.setText("Obesidade 1 \nIMC =" + numero1);
        } else if (numero1 >= 35 && numero1 <= 39.99) {
            textView.setText("Obesidade 2\nIMC =" + numero1);

        } else {
            textView.setText("Obesidade 3\nIMC =" + numero1);
        }


        //Evento de click
        recyclerView.addOnItemTouchListener(
                new RecycleViewCLickListener(getApplicationContext(), recyclerView, new RecycleViewCLickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                    @Override
                    public void onItemClick(View view, int position) {
                        TabelaImc lista = listaImc.get(position);
                        Toast.makeText(
                                getApplicationContext(),
                                "Item pressionado: " + lista.getTitulo(),
                                Toast.LENGTH_LONG
                        ).show();
                    }
                    @Override
                    public void onLongItemClick(View view, int position) {
                        TabelaImc lista = listaImc.get(position);
                        Toast.makeText(
                                getApplicationContext(),
                                "Click Longo: " + lista.getTitulo(),
                                Toast.LENGTH_LONG
                        ).show();
                    }

                }


                ));

    }
    public void  criarTabelaImc(){
        TabelaImc tabelaImc = new TabelaImc("IMC", "Resultado");
        this.listaImc.add(tabelaImc);
        tabelaImc = new TabelaImc("Menos do que 18.5", "Abaixo do peso");
        this.listaImc.add(tabelaImc);
        tabelaImc = new TabelaImc("Entre 18.5 e 24.9", "Peso normal");
        this.listaImc.add(tabelaImc);
        tabelaImc = new TabelaImc("Entre 25 e 29.9", "Sobrepeso");
        this.listaImc.add(tabelaImc);
        tabelaImc = new TabelaImc("Entre 30 e 34.9", "Obesidade grau 1");
        this.listaImc.add(tabelaImc);
        tabelaImc = new TabelaImc("Entre 35 e 39.9", "Obesidade grau 2");
        this.listaImc.add(tabelaImc);
        tabelaImc = new TabelaImc("Maior do que 40", "Obesidade grau 3");
        this.listaImc.add(tabelaImc);

    }

    public void ClickAqui (View view){

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.natue.com.br/natuelife/saiba-tudo-sobre-o-imc.html"));
        startActivity(intent);

    }



}
