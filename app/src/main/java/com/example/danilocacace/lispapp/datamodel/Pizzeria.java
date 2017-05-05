package com.example.danilocacace.lispapp.datamodel;

import java.io.Serializable;

/**
 * Created by Danilo Cacace on 04/05/2017.
 */

public class Pizzeria implements Serializable {

    private String nome;
    private String via;
    private int numero;

    /*
    Costruttore senza parametri, in quanto è possibile setarli con i metodi successivamente
     */
    public Pizzeria(){
    }

    /**
     * Costruttore con parametri:
     * @param nome nome della pizzeria
     * @param via indirizzo della pizzeria
     * @param numero numero telefonico della pizzeria
     */
    public Pizzeria(String nome, String via, int numero){
        this.nome = nome;
        this.via = via;
        this.numero = numero;
    }

    /*
    Mi creo i get and set per settare le variabili ecc. questa è un operazione che si può fare in maniera automatica
     */

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
