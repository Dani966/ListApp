package com.example.danilocacace.lispapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.danilocacace.lispapp.datamodel.Pizzeria;


public class DettaglioPizzeria extends AppCompatActivity {

    private  final String PIZZA = "pizzeria";

    //Definisco i Widget
    private TextView mNome;
    private TextView mIndirizzo;
    private TextView mNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dettaglio_pizzeria);

        //imposto gli ID dei Widget
        mNome = (TextView)findViewById(R.id.textNome2);
        mIndirizzo = (TextView)findViewById(R.id.textIndirizzo2);
        mNumero = (TextView)findViewById(R.id.textNumero2);

        //Ottengo i dati passati e visualizzo lo studente se possibile
        Intent intent = getIntent();
        Pizzeria pizzeria = (Pizzeria)intent.getSerializableExtra(PIZZA);

        if (pizzeria!=null){
            mNome.setText(pizzeria.getNome());
            mIndirizzo.setText(pizzeria.getVia());
            mNumero.setText(Integer.toString(pizzeria.getNumero()));
        }
    }

}
