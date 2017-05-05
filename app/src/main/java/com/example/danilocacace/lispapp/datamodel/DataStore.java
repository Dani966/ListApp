package com.example.danilocacace.lispapp.datamodel;

import java.util.ArrayList;

/**
 * Il data store ci permette di modellare i dati della nostra applicazione, questo ci permette di fare tutte le funzioni di salvataggio
 * inserimento, ricerca ecc. tutte operazioni che si fanno sui dati e che vogliamo siano nascoste all'applicazione
 */

public class DataStore {
    /*
    Viene usata una lista di pizzerie per simulare i dati come se fossero su di un server, dicesi
    simulazione locale prototipale
    TODO: Da eliminare in futuro e sostituire con i dati reali
     */
    private ArrayList<Pizzeria> pizzerie;

    public DataStore(){
        pizzerie = new ArrayList<>();

        //Inserisco dei dati fittizzi per poter testare l'app e aggiungo alla lista
        Pizzeria A = new Pizzeria("ManiInFarina", "Via Alessandro", 3925580);
        Pizzeria B = new Pizzeria("HeraHora", "ViaBoh", 050456);
        Pizzeria C = new Pizzeria("A Nonn", "Via Nessuna", 55160);
        pizzerie.add(A);
        pizzerie.add(B);
        pizzerie.add(C);
    }

    public void AggiungiPizzeria(Pizzeria pizzeria){
        //Aggiunge alla lista usando il suo metodo add, una pizzeria
        pizzerie.add(pizzeria);
    }

    public void AggiornaPizzeria(Pizzeria pizzeria){
        //per ora vuoto
    }

    public void EliminaPizzeria(Pizzeria pizzeria){
        //per ora vuoto
    }
    /**
     * Metodo della lista, che restituisce tutta la lista
     * TODO: Questo metodo restituisce una grosse mole di dati se le nostre liste sono molto vaste, da usare con cautela.
     * @return Lista di pizzerie
     */
    public ArrayList<Pizzeria> elencoPizzerie() {
        return pizzerie;
    }
}
