package com.example.danilocacace.lispapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.danilocacace.lispapp.datamodel.Pizzeria;

import java.util.Collections;
import java.util.List;

/**
 * Created by Danilo Cacace on 05/05/2017.
 */

public class PizzerieAdapter extends BaseAdapter {

    //La empty list rispetto l'array list è generalmente più snella, ma sono intercambiabili
    private List<Pizzeria> pizzerie = Collections.emptyList();
    private Context context;

    public PizzerieAdapter(Context context){ this.context = context; }

    //Sono tutti metodi che vengono utilizzati dalla listView, questa chiede all'adapter quanti elemtni visualizzare
    //quale view visualizzare in quel punto, l'identificativo dell'elemento e getItem restituisce il dato corrispondente
    //a quella posizione.
    /*
    Quindi quando scorreremo nella schermata con get getcount sappiamo quanti elementi ci sono, con get item restituiamo l'oggetto che corrisponde
    a quella psozione
     */
    @Override
    public int getCount() {
        return pizzerie.size();
    }

    @Override
    public Pizzeria getItem(int position) {
        return pizzerie.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /*
    per poter scrivere la View dobbiamo prima disegnare il Layout della riga.
    Position sarà l'ordine delle View, ViewGroup è il contenitore
    ConvertView ci permette di riutilizzare delle View non più utili, questo è un meccanismo interno alla lista che permette
    di non appesantire troppo la nostra applicazione riempiendola di View, ma sostituendo quelle che non vengono più utilizzate
    Se però la view è vuota allora non possiamo usarla, per questo si mette l'if
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*
        Controllo se converView è nulla, se nulla allora lo creo usando layoutinflater, da context prendo la riga studente e la metto dentro
        Passandogli la posizione quindi, l'adapter crea un nuovo elemento da visualizzare se ce n'è bisogno, poi prende i dati in quella posizione
        e li scrive all'interno della View, restituendo la lista in maniera da poterla visualizzare.
        Va chiamato di volta in volta perchè ogni elemento della lsita è diverso.
         */
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.riga_pizzeria, parent, false);
        }

        //Ottengo gli id correnti
        TextView textNome = (TextView)convertView.findViewById(R.id.textNome);
        TextView textIndirizzo = (TextView)convertView.findViewById(R.id.textIndirizzo);
        TextView textNumero = (TextView)convertView.findViewById(R.id.textNumero);

        //Imposto i valori da visualizzare prendendoli dalle pizzerie
        Pizzeria pizzeria = pizzerie.get(position);
        textNome.setText(pizzeria.getNome());
        textIndirizzo.setText(pizzeria.getVia());
        textNumero.setText(Integer.toString(pizzeria.getNumero()));

        return convertView;
    }

    // /Fa la copia della lista in una nuova lista in maniera da avere una copia in locale
    public void update(List<Pizzeria> newList){
        pizzerie = newList;
    }
}
