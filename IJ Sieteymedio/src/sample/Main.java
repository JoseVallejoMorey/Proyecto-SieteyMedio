package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

    }


    public static void main(String[] args) {

        GameManager manager = new GameManager(5);
        Random rand = new Random();
        int decision;

        while(manager.status == true){

            Jugador current = manager.getPlayer(manager.getTurno());
            decision = (int) (rand.nextInt(2) + 1);

            //empezamos siempre con player 1
            switch (decision){
                case 1: manager.simuladorSigueJugando(current);
                    break;
                default:
                    System.out.println("jugador "+manager.getTurno()+" pasa");
                    current.jugadorPasa();
                    break;
            }

            manager.siguienteTurno();

        }





    }
}
