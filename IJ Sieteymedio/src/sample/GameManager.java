package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by web on 6/10/15.
 */
public class GameManager {

    public boolean status = true;   //estado del juego

    public int apuestaMinima = 5;   //minima apuesta
    public int bolsaTotal = 0;          //total de bote
    public int turno = 1;           //jugador que tiene que jugar
    public int dealer;              //es quien tiene la banca en este turno

    public int totalPlayers;        //total de jugadores
    public int totalPlayersNow;     //numero de jugadores actuales

    static ArrayList<Jugador> players= new ArrayList <Jugador> ();
    static ArrayList<Integer> playersActivos = new ArrayList<Integer>();

    /**
     * Constructor for objects of class GameManager
     */
    public GameManager(int jugadores){

        for (int i=1; i<jugadores+1; i++){
            this.players.add(new Jugador(i));
            this.playersActivos.add(i);
            System.out.println("Jugador " + i + " preparado.");
        }

        this.totalPlayers = this.players.size();
        this.totalPlayersNow = this.totalPlayers;
        //System.out.println("Jugadores segun totalPlayers " + this.totalPlayers);

    }


    //obtiene objeto de un jugador
    public Jugador getPlayer(int param){
        //el array si que empieza por 0
        param = param-1;
        Jugador actual = players.get(param);
        return actual;
    }


    public int getTurno(){
        return this.turno;
    }

    //comprobara los puntos del jugador
    public void checkPuntos(int param){
        getPlayer(param).puntosTotales();
        if(getPlayer(param).puntosFinal > (float) 7.5){
            eliminarJugador(param);
            System.out.println("jugador "+param+" eliminado");
        }
    }


    //el jugador que gana se lleva la banca
    public void jugadorGana(int param){
        Jugador player = getPlayer(param);
        player.cash = player.cash + this.bolsaTotal;

        System.out.println("The winner is :"+param );
        System.out.println("Jugador "+param+": has ganado "+this.bolsaTotal);
        System.out.println("Jugador "+param+": hahora tienes "+player.cash);
        this.bolsaTotal = 0;
    }

    //pasamos al siguiente turno
    public void siguienteTurno(){


        if(this.totalPlayersNow == 1){

            this.status = false;
            for (int winner : this.playersActivos){
                jugadorGana(winner);
            }

        }else{

            int tempTurno;
            int siguiente = this.turno+1;
            //System.out.println("segun siguiente "+siguiente);
            //System.out.println("segun totalPlayers Now "+this.totalPlayersNow);

            if( siguiente > this.totalPlayers ){
                tempTurno = Collections.min(this.playersActivos);
            }else{
                tempTurno = siguiente;
            }

            if(getPlayer(tempTurno).activo == false){
                //System.out.println("jugador "+tempTurno+" esta fuera");
                this.turno = tempTurno;
                siguienteTurno();
            }else{
                System.out.println("jugador "+tempTurno+" esta jugando");
                this.turno = tempTurno;
            }

        }

        //cambiamos tambien al dealer
        //setDealer();
    }

    //cambiamos el dealer al siguiente
    public void setDealer(){
        int tempDealer = this.turno;
        if(tempDealer == 0){
            this.dealer = this.totalPlayers;
        }else{
            this.dealer = tempDealer;
        }
    }


    //jugador actual pide carta
    public void partidaSacarCarta(){
        //TODO
        //checkPuntos();

    }

    //jugacor actual apuesta
    public void partidaApostar(){}

    //jugador actual pasa
    public void partidaPasar(){

        //TODO
        siguienteTurno();
    }

    //cada ronda le meten 5 a la bolsa del juego
    public void jugadorApuesta(Jugador param){

        param.cash = param.cash - this.apuestaMinima;
        this.bolsaTotal = this.bolsaTotal + this.apuestaMinima;
    }



    public void eliminarJugador(int param){
        //elimino al loser
        //this.players.remove(param);
        getPlayer(param).jugadorEliminado();
        int susodicho = this.playersActivos.indexOf(param);
        this.playersActivos.remove(susodicho);
        //this.totalPlayers = this.totalPlayers - 1;
        this.totalPlayersNow = this.totalPlayersNow - 1;
        //cuento los que me quedan
        //gameSize();
    }







    //alguna calse para el siulador

    public void simuladorSigueJugando(Jugador player){
        Random rand = new Random();

        jugadorApuesta(player);
        player.jugadorSacaCarta();

        System.out.println("jugador "+getTurno()+" - "+player.puntosActuales+" puntos");
        this.checkPuntos(this.getTurno());

        if( (player.puntosFinal <= (float) 7.5) && (player.cash > 0) ){
            //System.out.println("se supone que "+player.puntosFinal+" es menor o igual a 7.5");
            int decision = (int) (rand.nextInt(2) + 1);
            if(decision == 1){

                simuladorSigueJugando(player);
            }else{
                player.jugadorPasa();
            }
        }else{
            //System.out.println("se supone que "+player.puntosFinal+" es mayor a 7.5");
            //eliminarJugador(player.id);
            //siguienteTurno();
        }
    }


}
