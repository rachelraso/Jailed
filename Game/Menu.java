import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.Group;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import java.util.TimerTask;
import java.util.Timer;
import java.lang.Math;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.concurrent.TimeUnit;

import javafx.scene.control.Label;
import javafx.geometry.Pos;

import java.awt.Rectangle;



public class Menu extends Application{

  private static String gameAudioFile = "sonic2.mp3";

  public static void main(String[] args){

      Media gameAudio = new Media(new File(gameAudioFile).toURI().toString());
      MediaPlayer mediaPlayer3 = new MediaPlayer(gameAudio);
      mediaPlayer3.play();

      launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception{

    Pane root = new Pane();
    Scene theScene = new Scene(root);
    stage.setTitle("Jailed");
    stage.setScene(theScene);
    Canvas canvas = new Canvas(1009,400);

    //Menu Background
    Image menu = new Image("menu1.png");
    ImageView menuNode = new ImageView();
    menuNode.setImage(menu);
    menuNode.setLayoutX(0);
    menuNode.setLayoutY(0);


    //uses esc button to exit and enter to play
    theScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
      public void handle(KeyEvent event){
        switch(event.getCode()){
          case ESCAPE:
            System.exit(0);
          case ENTER:
            try{
              Map.startGame(stage);
              break;
            }
            catch(FileNotFoundException e){
              System.out.println("File not found?");
            }

        }
      }
    });

    root.getChildren().addAll(menuNode, canvas);
    stage.show();

  }

}
