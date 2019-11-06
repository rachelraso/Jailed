/**
* Player and Location class combined
* It uses keyboard input (WASD) to control player's movement
* Keyboard control is handled in TextApp.java
*/

import java.util.Scanner;
import java.awt.Rectangle;

public class Player{

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
  public Player(){
    this.x = 0;
    this.y = 0;
    this.h = 35;
    this.w = 22;
    this.status = true;
  }

  public Player(int x, int y, int h, int w){
    this.x = x;
    this.y = y;
    this.h = h;
    this.w = w;
    this.status = true;
  }


  /**
	 * Constructor that takes in x and y as an argument
	 * @param x
	 * @param y
   */
  public Player(int x, int y){
    this.x = x;
    this.y = y;
    this.h = 35;
    this.w = 22;
    this.status = true;
  }


//GETTERS

  /**
  * Getter method that returns value of x coordinate
  * @return
  */
  public int getX(){
    return x;
  }

  /**
  * Getter method that returns value of y coordinate
  * @return
  */
  public int getY(){
    return y;
  }

  /**
  * Getter method that returns if player is alive
  * @return
  */
  public boolean getStatus(){
    return status;
  }

  public int getWidth(){
    return w;
  }
  public int getHeight(){
    return h;
  }
  
  /**
  * Getter method that returns rectangle where player is
  */
  public Rectangle getPlayerBoundary(){
    return new Rectangle(x, y, w, h);
  }


//SETTERS
  /**
  * Setter method that sets player's x coordinate
  * @param x
  */
  public void setX(int x){
    this.x = x;
  }

  /**
  * Setter method that sets player's y coordinate
  * @param y
  */
  public void setY(int y){
    this.y = y;
  }

  /**
  * Setter method that sets the player's life status
  * @param life
  */
  public void setStatus(boolean life){
    status = life;
  }

  public void setWidth(int aWidth){
		w = aWidth;
	}
	public void setHeight(int aHeight){
		h = aHeight;
	}



//subject to change
  /**
  * Setter method that sets Player's y coordinate 1 up
  */
  public void moveUp(){
    x -= 1;
  }

  /**
  * Setter method that sets Player's y coordinate 1 down
  */
  public void moveDown(){
    x += 1;
  }

  /**
  * Setter method that sets Player's x coordinate 1 to the right
  */
  public void moveRight(){
    y += 1;
  }

  /**
  * Setter method that sets Player's x coordinate 1 to the left
  */
  public void moveLeft(){
    y -= 1;
  }

}
