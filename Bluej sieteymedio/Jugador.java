
/**
Por cada jugador un nuevo objeto jugador
 */
public class Jugador{

    public int id;                  //id de jugador
    public int cash;                //dinero total
    public int apuesta;             //dinero que apuesta
    
    public float puntosActuales;    //puntuacion durante la partida
    public float puntosFinal;       //puntuacion total del jugador
    
    public ArrayList CartasSacadas;

    /**
     * Constructor for objects of class Jugador
     */
    public Jugador( int param){
        // asignar un id al jugador
        this.id = param;
       
    }


    public void jugadorSacaCarta(){
        //y aqui necesito la clase baraja!!
    //saca una carta de la baraya y la resta se alli
    //guardar en cartasSacadas
    }
    
    public void jugadorPasa(){
        //puntos total es su puntuacion final
        this.puntosFinal = this.puntosActuales;
    }
    
    public void jugadorApuesta(int monto){
        //necesitamos clase banca!!
        this.apuesta = monto;
        this.cash = this.cash - monto;
        
        
    }
    
    
    private void puntosTotales(){
        //suma los puntos que tengo segun las cartas del array
    }
    
    
    
    
}
