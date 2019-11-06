/*
* Updated Map class for Demo 3
*
* Code reference:
* Introduction to JavaFX for Game Development Tutorial
* by Lee Stemkoski, 2015
*/

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
import javafx.event.ActionEvent;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import java.util.TimerTask;
import java.util.Timer;
import java.lang.Math;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.*;
import java.util.concurrent.TimeUnit;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Alert;
import java.awt.Rectangle;
import javax.swing.*;



public abstract class Map extends Application {
//--------------------------- VARIABLES--------------------------------------------------
  private static boolean up, down, right, left;
  private static boolean allowBreakingDoors = false;
  private static Player escapist = new Player(500, 390);

  private static Enemy guardAI1 = new Enemy(0, 400);
  private static Enemy guardAI2 = new Enemy(140, 310);
  private static Enemy guardAI3 = new Enemy(600, 100);

  private static Collectibles parcelItem = new Collectibles(325, 232);
  private static Collectibles parcelItem2 = new Collectibles(500, 250);
  private static Collectibles parcelItem3 = new Collectibles(655, 270);
  private static Collectibles parcelItem4 = new Collectibles(750, 35);
  private static Collectibles parcelItem5 = new Collectibles(50, 25);

  private static Collectibles tool1 = new Collectibles (742, 506);
  private static Collectibles tool2 = new Collectibles (600, 376);
  private static Collectibles tool3 = new Collectibles (718, 223);
  private static Collectibles tool4 = new Collectibles (531, 0);
  private static Collectibles tool5 = new Collectibles (283, 172);
  private static Collectibles tool6 = new Collectibles (771, 52);

  private static Collectibles healthbar1 = new Collectibles(-100, -100);
  private static Collectibles healthbar2 = new Collectibles(-100, -100);
  private static Collectibles healthbar3 = new Collectibles(-100, -100);
  private static Collectibles healthbar4 = new Collectibles(-100, -100);
  private static Collectibles healthbar5 = new Collectibles(-100, -100);
  private static Collectibles escapeDoor = new Collectibles(0, 278);
  private static Collectibles switchItem = new Collectibles(200, 487);

  private static Enemy endScreen = new Enemy(-1000, -1000);

  private static String respawnSound = "megaman_soundEffect.mp3";
  private static String itemCollectSound = "swoosh.mp3";
  private static String gameAudioFile = "sonic2.mp3";
  private static int switchInventory = 0;

  private static final int startSeconds = 60;
  private static int seconds = startSeconds;
  private static final int startMinutes = 2;
  private static int minutes = startMinutes;
  private static Label label;
  private static Label label1;
  private static Label label2;

  private static int counter = 0;
  private static int switch_player_coll_counter = 0;
  private static int tool_counter = 0;
  private static int playerCollidedWithDoor = 0;
  private static boolean gameOver = false;
  private static Timeline time = new Timeline();

  // ------------------------------------------------STATIC SAVE AND LOAD METHODS-----------------------------

  /**
   * Static Method that saves all objects in the game
   * @param p - the Player that needs to be saved
   * @param e1 - One of three enemies being saved
   * @param e2 - Second of the three enemies being saved
   * @param e3 - Last of the three enemies being saved
   * @param co - the Codes that needs to be saved
   * @param col - the Collectibles that needs to be saved
   */
  //If we have to add a fourth enemy or another collectible or code object we'll just have to make a few more save methods in their respective classes
  public static void saveGame(Player p, Enemy e1, Enemy e2, Enemy e3, Codes co, Collectibles col){
    p.savePlayer();
    e1.saveEnemy1();
    e2.saveEnemy2();
    e3.saveEnemy3();
    co.saveCodes();
    col.saveCollectibles();
    System.out.println("Attempted to save game");
  }

  /**
   * Static Method that loads classes from their respective text files
   * Makes a FileInputStream and ObjectInputStream for each then reads the object contained in the respective text file
   * Finally closes the ObjectInputStream and moves onto the next object and does the same
   * @throws Exception
   */

  public static void loadGame()throws Exception{
    FileInputStream fisPlayer = new FileInputStream("PlayerSave.txt");
    ObjectInputStream oisPlayer = new ObjectInputStream(fisPlayer);
    Player loadedPlayer = (Player) oisPlayer.readObject();
    oisPlayer.close();

    FileInputStream fisEnemy1 = new FileInputStream("EnemySave1.txt");
    ObjectInputStream oisEnemy1 = new ObjectInputStream(fisEnemy1);
    Enemy loadedEnemy1 = (Enemy) oisEnemy1.readObject();
    oisEnemy1.close();

    FileInputStream fisEnemy2 = new FileInputStream("EnemySave2.txt");
    ObjectInputStream oisEnemy2 = new ObjectInputStream(fisEnemy2);
    Enemy loadedEnemy2 = (Enemy) oisEnemy2.readObject();
    oisEnemy2.close();

    FileInputStream fisEnemy3 = new FileInputStream("EnemySave3.txt");
    ObjectInputStream oisEnemy3 = new ObjectInputStream(fisEnemy3);
    Enemy loadedEnemy3 = (Enemy) oisEnemy3.readObject();
    oisEnemy3.close();

    FileInputStream fisCodes = new FileInputStream("CodesSave.txt");
    ObjectInputStream oisCodes = new ObjectInputStream(fisCodes);
    Codes loadedCodes = (Codes) oisCodes.readObject();
    oisCodes.close();

    FileInputStream fisCollectibles = new FileInputStream("CollectiblesSave.txt");
    ObjectInputStream oisCollectibles = new ObjectInputStream(fisCollectibles);
    Collectibles loadedCollectibles = (Collectibles) oisCollectibles.readObject();
    oisCollectibles.close();
  }
  // ------------------------------------------------GENERAL MAP METHODS-----------------------------------------------
  public static boolean collision(Player a, Enemy e){

  boolean collisionEncountered = false;

    if(Math.abs(a.getX() - e.getX()) < 22 && Math.abs(a.getY() - e.getY()) < 35)
      collisionEncountered = true;

    return collisionEncountered;
  }

  public static void playRepsawn(){
    MediaPlayer mediaPlayer;
    Media respawn = new Media(new File(respawnSound).toURI().toString());
    mediaPlayer = new MediaPlayer(respawn);
    mediaPlayer.play();
    respawnAllItems();
  }

  public static void respawnAllItems(){
    parcelItem.setC(325, 232);
    parcelItem2.setC(500, 250);
    parcelItem3.setC(655, 270);
    parcelItem4.setC(750, 35);
    parcelItem5.setC(50, 25);
    healthbar1.setC(-100, -100);
    healthbar2.setC(-100, -100);
    healthbar3.setC(-100, -100);
    healthbar4.setC(-100, -100);
    healthbar5.setC(-100, -100);
    tool1.setC(742, 506);
    tool2.setC(600, 376);
    tool3.setC(718, 223);
    tool4.setC(531, 0);
    tool5.setC(283, 172);
    tool6.setC(771, 52);

    counter = 0;
    tool_counter = 0;
    setSwitch(0);
    switch_player_coll_counter = 0;
    playerCollidedWithDoor = 0;
    allowBreakingDoors = false;
    Codes.setB(false);
    Codes.setH(false);
    Codes.setI(false);
  }

  public static void removeAllItems(){
    parcelItem.setC(-10000, -10000);
    parcelItem2.setC(-10000, -10000);
    parcelItem3.setC(-10000, -10000);
    parcelItem4.setC(-10000, -10000);
    parcelItem5.setC(-10000, -10000);
    healthbar1.setC(10000, 10000);
    healthbar2.setC(10000, 10000);
    healthbar3.setC(10000, 10000);
    healthbar4.setC(10000, 10000);
    healthbar5.setC(10000, 10000);
    tool1.setC(-10000, -10000);
    tool2.setC(-10000, -10000);
    tool3.setC(-10000, -10000);
    tool4.setC(-10000, -10000);
    tool5.setC(-10000, -10000);
    tool6.setC(-10000, -10000);
    counter = 0;
    tool_counter = 0;
    setSwitch(0);
    switch_player_coll_counter = 0;
    playerCollidedWithDoor = 0;
    allowBreakingDoors = false;
    Codes.setB(false);
    Codes.setH(false);
    Codes.setI(false);
  }

  public static int getSwitch() {
    return switchInventory;
  }

  public static void setSwitch(int s) {
    switchInventory = s;
  }


  public static void playItemCollect(){
    MediaPlayer mediaPlayer2;
    Media itemColl = new Media(new File(itemCollectSound).toURI().toString());
    mediaPlayer2 = new MediaPlayer(itemColl);
    mediaPlayer2.play();
  }


  public static boolean itemCollected(Player a, Collectibles e){
    boolean itemWasCollected = false;

    if((Math.abs(a.getX() - e.getX()) < 22) && (Math.abs(a.getY() - e.getY()) < 35))
      itemWasCollected = true;

    return itemWasCollected;
  }


  // -----------------------------------------------TIMER-----------------------------------------------------
  private static void timerMethod(){
//    Timeline time = new Timeline();
    time.setCycleCount(Timeline.INDEFINITE);
    if(time!=null){
          time.stop();
    }

     KeyFrame frame2 = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){

    @Override
      public void handle(ActionEvent event2){
        if(seconds ==0){
          minutes --;
        }

        if(minutes <0){
          time.stop();
        }

        if (minutes>= 0){
        label1.setText("Time:  " + minutes);
      }
      }
    });

    KeyFrame frame1 = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){
      @Override
      public void handle(ActionEvent event){

        if(seconds == 0){
          seconds = startSeconds;
        }

        seconds--;
        label2.setText(": " + seconds + "");
      }
    });
    time.getKeyFrames().add(frame2);
    time.getKeyFrames().add(frame1);
    time.playFromStart();
  }

// -----------------------------------------------MAIN GAME-----------------------------------------------------
  public static void startGame(Stage theStage) throws FileNotFoundException{

    //setup
    Group root = new Group();
    Scene theScene = new Scene( root );
    theStage.setScene( theScene );
    Canvas canvas = new Canvas(1000, 900);
    root.getChildren().add( canvas );

    // timer Graphics
    label = new Label();
    label.setTextFill(Color.BROWN);
    label.setFont(Font.font(30));
    HBox layout = new HBox(10);
    layout.getChildren().add(label);
    layout.setLayoutX(805);
    layout.setLayoutY(20);

    label1 = new Label();
    label1.setTextFill(Color.BROWN);
    label1.setFont(Font.font(30));
    //HBox layout = new HBox(5);
    layout.getChildren().add(label1);
    layout.setLayoutX(805);


    label2 = new Label();
    label2.setTextFill(Color.BROWN);
    label2.setFont(Font.font(30));
    layout.getChildren().add(label2);

    root.getChildren().add(layout);

    //Generate Random Control points
    guardAI1.generateRandomCpts1();
    guardAI2.generateRandomCpts2();
    guardAI3.generateRandomCpts3();



   // --------------------------------------------- LOADING IMAGES---------------------------------------------------
    GraphicsContext gc = canvas.getGraphicsContext2D();

    //Images
    Image baseMap = new Image( "base.png" );
    Image baseMap2 = new Image( "base2.png" );
    Image parcel = new Image ("parcel.png");
    Image door = new Image("cell_door.png");
    Image corridorDoor = new Image("corridor_door.png");
    Image code1 = new Image( "53.png" );
    Image code2 = new Image( "61.png" );
    Image code3 = new Image( "74.png" );
    Image guard = new Image( "guard.png" );
    Image player = new Image( "player.png" );
    Image end = new Image("end1.png");
    Image inventory = new Image("inventory.png");
    Image dialogue = new Image("dialogue.png");
    Image lightSwitch = new Image ("switch.png");
    Image strength = new Image("strength.png");
    Image health_bar = new Image("health_bar.png");
    Image escape_door = new Image("final_door.png");
    Image doorOut = new Image("finalDoor.png");

    Image tool_1 = new Image("tool1.png");
    Image tool_2 = new Image("tool2.png");
    Image tool_3 = new Image("tool3.png");
    Image tool_4 = new Image("tool4.png");
    Image tool_5 = new Image("tool5.png");
    Image tool_6 = new Image("tool6.png");

    Image codeMessage = new Image("messageCode.png");
    Image keypad = new Image("keypad.png");
    Image encryption = new Image("encryption.png");
    Image nothing = new Image ("nothing.png");
    Image cover = new Image("cover.png");
    Image lose = new Image("lose.png");


  //-----------------------------------------------PLAYER CONTROLS----------------------------------------------------------
    theScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
      public void handle(KeyEvent event){
        switch(event.getCode()){
          case W:
          if (gameOver == false) {
            up = true;
          }
            break;
          case S:
          if (gameOver == false) {
            down = true;
          }
            break;
          case D:
          if (gameOver == false) {
            right = true;
          }
            break;
          case A:
          if (gameOver == false) {
            left = true;
          }
            break;

          case B:
            Codes.setB(true);
            break;
          case H:
            Codes.setH(true);
            break;
          case I:
            Codes.setI(true);
          break;
        }
      }
    });

    theScene.setOnKeyReleased(new EventHandler<KeyEvent>(){
      public void handle(KeyEvent event){
        switch(event.getCode()){
          case W:
            up = false;
            break;
          case S:
            down = false;
            break;
          case D:
            right = false;
            break;
          case A:
            left = false;
            break;
        }
      }
    });

    // -------------------------------- PLAYER AND WALL COLLISIONS-----------------------------------------------------
    AnimationTimer updatePlayer = new AnimationTimer(){
      public void handle(long arg){
        if ((up) && (Walls.didCollide(escapist.getPlayerBoundaryY(-1), getSwitch()) == false)) {
          escapist.moveUp();
        }
        if ((down) && (Walls.didCollide(escapist.getPlayerBoundaryY(1), getSwitch()) == false)) {
          escapist.moveDown();
        }
        if ((right) && (Walls.didCollide(escapist.getPlayerBoundaryX(1), getSwitch()) == false)) {
          escapist.moveRight();
        }
        if ((left) && (Walls.didCollide(escapist.getPlayerBoundaryX(-1), getSwitch()) == false)) {
          escapist.moveLeft();
        }
      }
    };


    //----------------------GUARD WALKING PATTERNS---------------------------------------------------------------------------------
    final long startNanoTime = System.nanoTime();

    AnimationTimer updateGuardAI1 = new AnimationTimer(){
      public void handle(long currentNanoTime){

      guardAI1.setDirectionG1(seconds);

      if(collision(escapist, guardAI1)){
        escapist.setX(500);
        escapist.setY(390);
        playRepsawn();
        gc.drawImage(baseMap2, 0, 0);
        try {
          // thread to sleep for 1000 milliseconds
          Thread.sleep(100);
        } catch (Exception e) {
          System.out.println(e);
       }
      }
      gc.drawImage(guard, guardAI1.getX(), guardAI1.getY());
    }
    };

    AnimationTimer updateGuardAI2 = new AnimationTimer(){
      public void handle(long currentNanoTime){
      guardAI2.setDirectionG2(seconds);

      gc.drawImage(guard, guardAI2.getX(), guardAI2.getY());

      if(collision(escapist, guardAI2)){
        escapist.setX(500);
        escapist.setY(390);
        playRepsawn();
        gc.drawImage(baseMap2, 0, 0);
        try {
          // thread to sleep for 1000 milliseconds
          Thread.sleep(100);
        } catch (Exception e) {
          System.out.println(e);
       }
      }

    }
    };

    AnimationTimer updateGuardAI3 = new AnimationTimer(){
      public void handle(long currentNanoTime){
      guardAI3.setDirectionG3(seconds);

      gc.drawImage(guard, guardAI3.getX(), guardAI3.getY());

      if(collision(escapist, guardAI3)){
        escapist.setX(500);
        escapist.setY(390);
        playRepsawn();
        gc.drawImage(baseMap2, 0, 0);
        try {
          // thread to sleep for 1000 milliseconds
          Thread.sleep(100);
        } catch (Exception e) {
          System.out.println(e);
       }
      }

    }
    };


// ------------------------------------COLLECTIBLES UPDATES-------------------------------------------------------
    AnimationTimer movingParcel = new AnimationTimer(){
      @Override
      public void handle (long currentNanoTime){
        double t = (currentNanoTime - startNanoTime) / 1000000000.0;
        if (minutes >= 0) {
        gc.drawImage(baseMap, 0, 0);
        gc.drawImage(inventory, -10,405);
        gc.drawImage(dialogue, -1, 540);
        gc.drawImage(strength, 800, 60);
        gc.drawImage(doorOut, 0, 488);
        gc.drawImage(lightSwitch, switchItem.getX(), switchItem.getY());
      }

      if((itemCollected(escapist, switchItem)) && (switch_player_coll_counter == 0)){
        setSwitch(1);
        switch_player_coll_counter++;
      }

    // first position:
    // when the escapist is locked in the cell
      if (getSwitch() == 0) {
        gc.drawImage(corridorDoor, 188, 439);
        gc.drawImage(escape_door, 0, 278);
      }

    // Second position:
    // escapist pressed the switch but hasn't entered the code yet
    // (doors need to be updated)
      if (getSwitch() == 1) {
        gc.drawImage(code1, 316, 475);
        gc.drawImage(code2, 491, 425);
        gc.drawImage(code3, 316, 425);
        gc.drawImage(codeMessage, 800, 220);
        gc.drawImage(keypad, 800, 320);
        gc.drawImage(escape_door, 0, 278);
        gc.drawImage(corridorDoor, 188, 439);
        gc.drawImage(encryption, 833, 334);
        gc.drawImage(encryption, 884, 334);
        gc.drawImage(encryption, 940, 334);

    }

      // check if the correct code (bhi) was entered
      if (Codes.getI() == true) {
        setSwitch(2);
      }
      // Third position:
      // escapist has entered the right code, the code and the door disappears
      if (getSwitch() == 2) {
        gc.drawImage(escape_door, 0, 278);
        gc.drawImage(nothing, 800, 200);
      }

      // sets switch to the fourth position if the player has collected all the items and has enough strength
      if((tool_counter == 6) && (counter == 5)) {
        setSwitch(3);
        allowBreakingDoors = true;
      }

      // Fourth position:
      // escapist has collected all the items and has broken the door
      if ((getSwitch() == 3)) {
        if (Walls.LeftDoorCollision(escapist.getPlayerBoundaryY(1)) == true) {
          playerCollidedWithDoor = 1;
        }
      }

      // destroys the door when player collides with it if he has all the tools available in the inventory and has enough strength
      if (playerCollidedWithDoor == 1) {
        gc.drawImage(cover, 0, 278);
      }


     //when you get to final door
      if (Walls.exitDoorCollision(escapist.getPlayerBoundaryY(1)) == true) {
        removeAllItems();
        guardAI1.setX(-100);
        guardAI1.setY(-100);
        guardAI2.setX(-100);
        guardAI2.setY(-100);
        guardAI3.setX(-100);
        guardAI3.setY(-100);
        escapist.setX(-1000);
        escapist.setY(-1000);
        time.stop();
        gameOver = true;
        endScreen.setX(1);
        endScreen.setY(-120);
      }

      if(minutes < 0) {
          removeAllItems();
          guardAI1.setX(-100);
          guardAI1.setY(-100);
          guardAI2.setX(-100);
          guardAI2.setY(-100);
          guardAI3.setX(-100);
          guardAI3.setY(-100);
          escapist.setX(-1000);
          escapist.setY(-1000);
          gameOver = true;
          gc.drawImage(lose, 0, 0);
      }


    // PACKAGES collectible
        gc.drawImage(parcel, parcelItem.getX(), parcelItem.getY());
        gc.drawImage(parcel, parcelItem2.getX(), parcelItem2.getY());
        gc.drawImage(parcel, parcelItem3.getX(), parcelItem3.getY());
        gc.drawImage(parcel, parcelItem4.getX(), parcelItem4.getY());
        gc.drawImage(parcel, parcelItem5.getX(), parcelItem5.getY());
        gc.drawImage(end, endScreen.getX(), endScreen.getY());
        gc.drawImage(health_bar, healthbar1.getX(), healthbar1.getY());
        gc.drawImage(health_bar, healthbar2.getX(), healthbar2.getY());
        gc.drawImage(health_bar, healthbar3.getX(), healthbar3.getY());
        gc.drawImage(health_bar, healthbar4.getX(), healthbar4.getY());
        gc.drawImage(health_bar, healthbar5.getX(), healthbar5.getY());
        gc.drawImage(tool_1, tool1.getX(), tool1.getY());
        gc.drawImage(tool_2, tool2.getX(), tool2.getY());
        gc.drawImage(tool_3, tool3.getX(), tool3.getY());
        gc.drawImage(tool_4, tool4.getX(), tool4.getY());
        gc.drawImage(tool_5, tool5.getX(), tool5.getY());
        gc.drawImage(tool_6, tool5.getX(), tool5.getY());

        // Pizza collisions
        counter = counter + parcelItem.parcelCollection(itemCollected(escapist, parcelItem), parcelItem);
        counter = counter + parcelItem2.parcelCollection(itemCollected(escapist, parcelItem2), parcelItem2);
        counter = counter + parcelItem3.parcelCollection(itemCollected(escapist, parcelItem3), parcelItem3);
        counter = counter + parcelItem4.parcelCollection(itemCollected(escapist, parcelItem4), parcelItem4);
        counter = counter + parcelItem5.parcelCollection(itemCollected(escapist, parcelItem5), parcelItem5);


        // Updates health bars if pizza was collected
        if (counter == 1) {
          healthbar1.setX(810);
          healthbar1.setY(149);
        }

        if (counter == 2) {
          healthbar2.setX(846);
          healthbar2.setY(149);
        }

        if (counter == 3) {
          healthbar3.setX(882);
          healthbar3.setY(149);
        }

        if (counter == 4) {
          healthbar4.setX(918);
          healthbar4.setY(149);
        }

        if (counter == 5){
          healthbar5.setX(954);
          healthbar5.setY(149);
          setSwitch(3);
        }

        // -------------------------TOOLS----------------------
        tool_counter = tool_counter + tool1.toolCollection(itemCollected(escapist, tool1), tool1, 655, 600);
        tool_counter = tool_counter + tool2.toolCollection(itemCollected(escapist, tool2), tool2, 105, 600);
        tool_counter = tool_counter + tool3.toolCollection(itemCollected(escapist, tool3), tool3, 215, 600);
        tool_counter = tool_counter + tool4.toolCollection(itemCollected(escapist, tool4), tool4, 325, 600);
        tool_counter = tool_counter + tool5.toolCollection(itemCollected(escapist, tool5), tool5, 435, 600);
        tool_counter = tool_counter + tool6.toolCollection(itemCollected(escapist, tool6), tool6, 545, 600);

        gc.drawImage(player, escapist.getX(), escapist.getY());
      }
    };

    updatePlayer.start();
    movingParcel.start();
    updateGuardAI1.start();
    updateGuardAI2.start();
    updateGuardAI3.start();
    theStage.show();
    timerMethod();
  }

}
