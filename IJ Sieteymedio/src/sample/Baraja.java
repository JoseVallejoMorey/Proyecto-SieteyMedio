package sample;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by web on 5/10/15.
 */
public class Baraja {

    public Random random;

    public int carta;

    public List<Integer> descartes = new ArrayList<Integer>();


    //constructor
    public Baraja(){
        this.random = new Random();
    }

    public int sacarCarta(){
        //devolvera una carta y la borrara de la baraja
        int cartaTemporal;
        cartaTemporal = (int) (this.random.nextInt(40) + 1);

        //confirmo que no este, si esta saca otra
        for (int existente : this.descartes){
            if(existente == cartaTemporal){
                sacarCarta();
            }
        }
        //guardo y añado a descartadas
        this.carta = cartaTemporal;
        this.descartes.add(this.carta);

        return this.carta;
    }

    //borrara una carta que se ha sacado
    public void borrarCarta(){}





}
