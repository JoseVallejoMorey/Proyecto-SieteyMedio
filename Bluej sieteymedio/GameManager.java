
/**
Este creara la partida
-crear baraja
-iniciar cada jugador

 */
public class GameManager{

    public int apuestaMinima;   //minima apuesta
    public int bolsaTotal;      //total de bote
    public int turno;           //jugador que tiene que jugar
    public int dealer;          //es quien tiene la banca en este turno
    
    
    
    /**
     * Constructor for objects of class GameManager
     */
    public GameManager(int jugadores){
        //por cada jugador una clase y un punto en el indice
    }
    
    //comprobara los puntos del jugador
    public void checkPuntos(){}
    
    public void reparteGanancias(){
    
    //al jugador indicado le paso la pasta

    }
    
    public void laBancaGana(){
        //siempre gana la banca 
    }
    
    public void siguienteTurno(){
        //sabiendo el maximo de jugadores,
        //si turno mas 1 == maximo jugadores turno = 1
        
        //el dealer es 1 menos que turno, si turno es uno dealer es el maximo
    }
    
    
    //jugador actual pide carta
    public void partidaSacarCarta(){
    //TODO
        checkPuntos();

    }
    
    //jugacor actual apuesta
    public void partidaApostar(){}
    
    //jugador actual pasa
    public void partidaPasar(){
        
        //TODO
        siguienteTurno();
    }
    
    
    
    
    
    
    
}
