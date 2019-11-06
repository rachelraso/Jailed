/**
* Player and Location class combined
* It uses keyboard input (WASD) to control player's movement
* Keyboard control is handled in TextApp.java
*/

import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.IOException;

public class Player implements Serializable {

  //INSTANCE VARIABLES
  private int x;
  private int y;
  private int h;  //height
  private int w;  //width
  private boolean status;


//CONSTRUCTORS

  /**
   * Default constructor
   */
  public Player() {
    this.x = 0;
    this.y = 0;
    this.h = 30;
    this.w = 20;
    this.status = true;
  }

  /**
   * Constructor that takes in x and y as an argument
   *
   * @param x
   * @param y
   */
  public Player(int x, int y) {
    this.x = x;
    this.y = y;
    this.h = 30;
    this.w = 20;
    this.status = true;
  }

//GETTERS

  /**
   * Getter method that returns value of x coordinate
   *
   * @return
   */
  public int getX() {
    return x;
  }

  /**
   * Getter method that returns value of y coordinate
   *
   * @return
   */
  public int getY() {
    return y;
  }

  /**
   * Getter method that returns if player is alive
   *
   * @return
   */
  public boolean getStatus() {
    return status;
  }

  /**
   * Getter method that returns rectangle where player is
   */
  public Rectangle getPlayerBoundary() {
    return new Rectangle(x, y, w, h);
  }

  public Rectangle getPlayerBoundaryX(int upd) {
    return new Rectangle(x + upd, y, w, h);
  }

  public Rectangle getPlayerBoundaryY(int upd) {
    return new Rectangle(x, y + upd, w, h);
  }

//SETTERS

  /**
   * Setter method that sets player's x coordinate
   *
   * @param x
   */
  public void setX(int x) {
    this.x = x;
  }


  /**
   * Setter method that sets player's y coordinate
   *
   * @param y
   */
  public void setY(int y) {
    this.y = y;
  }

  /**
   * Setter method that sets the player's life status
   *
   * @param life
   */
  public void setStatus(boolean life) {
    status = life;
  }

//subject to change

  /**
   * Setter method that sets Player's y coordinate 1 up
   */
  public void moveUp() {
    y -= 2;
  }

  /**
   * Setter method that sets Player's y coordinate 1 down
   */
  public void moveDown() {
    y += 2;
  }

  /**
   * Setter method that sets Player's x coordinate 1 to the right
   */
  public void moveRight() {
    x += 2;
  }

  /**
   * Setter method that sets Player's x coordinate 1 to the left
   */
  public void moveLeft() {
    x -= 2;
  }

  /**
   * Player save method that outputs object to "PlayerSave.txt"
   */
  public void savePlayer() {
    try {
      File f = new File("PlayerSave.txt");
      FileOutputStream fos = new FileOutputStream(f);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(this);
      oos.close();
    } catch (IOException ioe) {
      System.out.println(ioe.getMessage());
    }
  }
}

