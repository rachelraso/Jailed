/**
* Enemy class
* used to control guards movement 
* 
* 
*/

import java.awt.Rectangle;


public class Enemy{
	
//INSTANCE VARIABLES
  private int x;
  private int y;
  private int h;  //height
  private int w;  //width
  private boolean enemyMove;
  
//CONSTRUCTORS
  /**
   * Default constructor, no arguments
   */
  public Enemy(){
    this.x = 0;
    this.y = 0;
    this.h = 5;
    this.w = 5;
    this.enemyMove = true;

  }

  /**
	 * Constructor that takes in x and y as an argument
	 * @param x
	 * @param y
	 */
  public Enemy(int x, int y){
    this.x = x;
    this.y = y;
    this.h = 5;
    this.w = 5;
    this.enemyMove = true;
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

  /** Getter method that returns if enemy movement is valid
  * @return
  */
  public boolean getEnemyMove(){
    return enemyMove;
  }

  /**
  * Getter method that returns rectangle where Enemy is
  */
  public Rectangle getEnemyBoundary(){
    return new Rectangle(x, y, w, h);
  }


//SETTERS
  /**
  * Setter method that sets Enemy's x coordinate
  * @param x
  */
  public void setX(int x){
    this.x = x;
  }

  /**
  * Setter method that sets Enemy's y coordinate
  * @param y
  */
  public void setY(int y){
    this.y = y;
  }

  /**
  * Setter method that sets enemy's move
  */
  public void setEnemyMove(boolean movement){
    enemyMove = movement;
  }

  /**
  * Setter method that sets Enemy's y coordinate 1 up
  */
  public void moveUp(){
    y += 1;
  }

  /**
  * Setter method that sets Enemy's y coordinate 1 down
  */
  public void moveDown(){
    y -= 1;
  }

  /**
  * Setter method that sets Enemy's x coordinate 1 to the right
  */
  public void moveRight(){
    x += 1;
  }

  /**
  * Setter method that sets Enemy's x coordinate 1 to the left
  */
  public void moveLeft(){
    x -= 1;
  }

}
