package sample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by web on 6/10/15.
 */
public class Jugador extends ArrayList {

    public int id;                  //id de jugador
    public int cash = 50;           //dinero total
    public boolean activo = true;   //el jugador esta activo o eliminado

    public float puntosActuales;    //puntuacion durante la partida
    public float puntosFinal;       //puntuacion total del jugador

    public List<Integer> cartasSacadas = new ArrayList<Integer>();


    /**
     * Constructor for objects of class Jugador
     */
    public Jugador( int param){
        // asignar un id al jugador
        this.id = param;
    }

    //saca una carta y se la guarda
    public void jugadorSacaCarta(){
        Baraja bar = new Baraja();
        this.cartasSacadas.add(bar.sacarCarta());
        puntosTotales();
        this.puntosFinal = this.puntosActuales;

    }

    public void jugadorPasa(){
        //puntos total es su puntuacion final
        this.puntosFinal = this.puntosActuales;
    }




    public void puntosTotales(){
        //suma los puntos que tengo segun las cartas del array
        float suma = (float) 0.0;
        int last = 0;
        for(int unaCarta : this.cartasSacadas){

            last = unaCarta%10;
            switch (last){
                case 0: suma = suma + (float)0.5;
                    break;
                case 9: suma = suma + (float)0.5;
                    break;
                case 8: suma = suma + (float)0.5;
                    break;
                default: suma = suma + last;
                    break;
            }

        }
        this.puntosActuales = suma;
    }


    public void jugadorEliminado(){

        this.activo = false;
    }
//int

}
