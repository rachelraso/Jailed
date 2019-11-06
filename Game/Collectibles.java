import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.IOException;
import javafx.stage.Stage;

public class Collectibles extends Map implements Serializable {

  // INSTANCE VARIABLES
  private double x;
  private double y;
  private int h; // height
  private int w; // width

  // CONSTRUCTORS

/**
 * Constructor that takes in x and y as an argument
 * @param x
 * @param y
 */
  public Collectibles (int x, int y){
      this.x = x;
      this.y = y;
      this.h = 35;
      this.w = 22;
    }

  // GETTERS
  /**
   * Getter method that returns value of x coordinate
   * @return x
   */
  public double getX() {
      return x;
  }

  /**
   * Getter method that returns value of y coordinate
   * @return y
   */
    public double getY() {
        return y;
    }


  //SETTERS
/**
* Setter method that sets player's x coordinate
* @param x
*/
  public void setX(double x){
    this.x = x;
  }

/**
* Setter method that sets player's y coordinate
* @param y
*/
  public void setY(double y){
    this.y = y;
  }

/**
* Setter method that sets player's x and y coordinates
* @param y
* @param x
*/
  public void setC(double x, double y){
    this.x = x;
    this.y = y;
  }

  /**
  * Method that makes the pizza disappear if it was collected
  * @param t
  * @param parcel
  */
  public int parcelCollection(boolean t, Collectibles parcel) {
    if (t == true) {
    parcel.setX(-100);
    parcel.setY(-100);
    super.playItemCollect();
    return 1;
    }
    else {
      return 0;
    }
  }

  /**
  * Method that moves the tool to the inventory if it was collected
  * @param t
  * @param parcel
  * @param x
  * @param y
  */

  public int toolCollection(boolean t, Collectibles parcel, int x, int y) {
    if (t == true) {
    parcel.setX(x);
    parcel.setY(y);
    super.playItemCollect();
    return 1;
    }
    else {
      return 0;
    }
  }

  /**
   * Method that saves Object data to CollectiblesSave.txt
   */
  public void saveCollectibles(){
    try{
      File f = new File("CollectiblesSave.txt");
      FileOutputStream fos = new FileOutputStream(f);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(this);
      oos.close();
    } catch(IOException ioe){
      System.out.println(ioe.getMessage());
    }
  }

  public void start(Stage s) {

  }


}
