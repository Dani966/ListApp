package com.example.danilocacace.lispapp;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.danilocacace.lispapp.datamodel.DataStore;
import com.example.danilocacace.lispapp.datamodel.Pizzeria;


public class MainActivity extends AppCompatActivity {

    private  final String PIZZA = "pizzeria";

    //Definisco il WIdget
    private ListView listaPizzerie;

    //Definisco l'Adapter
    private PizzerieAdapter adapter;

    //Definisco il DataStora
    private DataStore archivio = new DataStore();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Indico alla lista qual è il suo adapter, il resto lo fa in automatico
        listaPizzerie = (ListView) findViewById(R.id.listPizzerie);
        adapter = new PizzerieAdapter(this);

        //diciamo all'adapter dove sono i dati e chiamo l'adapter per aggiornare i dati dicendo
        adapter.update(archivio.elencoPizzerie());
        listaPizzerie.setAdapter(adapter);
        //Adesso dobbiamo fare in modo da visualizzare la singola pizzeria al click, usiamo quindi un setOnClickListner

        listaPizzerie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*
                Al click riceve i parametri, quello che c'interessa è la position, perchè con essa possiamo andare a recuperare la pizzeria
                Poi creiamo l'intent e passiamo come dati l'oggetto pizzeria, che verrà usato nella classe Dettaglio
                 */
                Pizzeria pizzeria = adapter.getItem(position);
                Intent intent = new Intent(view.getContext(), DettaglioPizzeria.class);
                intent.putExtra(PIZZA , pizzeria);
                startActivity(intent);
            }
        });
    }
}
