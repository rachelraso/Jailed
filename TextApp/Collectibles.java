/**
* Class for Packages items
* 5 heroin package rectangles are placed in the living area
* Package is collected when the player collides with the item rectangle
* the item is then moved to the Backpack class
*/
import java.util.*;
import java.awt.Rectangle;

public class Collectibles {

//INSTANCE VARIABLES
  private int x;
  private int y;
  private int w; // width of item's rectangle
  private int h; // height of item's rectangle

//CONSTRUCTORS
  // CHANGE WIDTH AND HEIGHT OF RECTANGLES LATER!!!!

  /**
   * Constructor that takes in x and y as an argument
   * (used for constructing package items)
   * @param x
   * @param y
   */
  public Collectibles (int x, int y) {
    this.x = x;
    this.y = y;
    this.w = 10;
    this.h = 10;
  }

  /**
   * Constructor that takes in x, y, width and height as arguments
   * (used for constructing keys and crowbar items)
   * @param x
   * @param y
   * @param w width
   * @param h height
   */
  public Collectibles (int x, int y, int w, int h) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }

// GETTERS
  /**
  * Getter method that returns the item's rectangle boundary
  *
  * @return p Rectangle with the following parameters:
  * (x, y, width, height)
  */
  public Rectangle getItemBoundary() {
    Rectangle p = new Rectangle (this.x, this.y, this.w, this.h);
    return p;
  }
  
  public int getX() {
      return x;
  }
  
  public int getY() {
      return y;
  }

//OTHER
  /**
  * Method that checks if the player collided with the item
  *
  * @param r1 - player's rectangle
  * @param r2 - item's rectangle
  *
  * @return true if the player's rectangle intersected with the item's rectangle
  */
  public boolean collidesWith (Rectangle r1, Rectangle r2) {
    if (r1.intersects(r2))
      return true;
    else
      return false;
  }

}
