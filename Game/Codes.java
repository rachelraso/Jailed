import java.awt.Rectangle;
import java.util.ArrayList;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.IOException;

public abstract class Codes extends Map implements Serializable {

/*
* INSTANCE VARIABLES:
*
*/
private static boolean b;
private static boolean h;
private static boolean i;


/*
* Default Constructor
*/

    public Codes () {
      b = false;
      h = false;
      i = false;
    }

/*
* Getter methods
*/

    public static boolean getB() {
      return b;
    }

    public static boolean getH() {
      return h;
    }

    public static boolean getI() {
      return i;
    }

/*
* Setters
*/

    public static void setB(boolean st) {
      b = st;
    }

    // h is only set to true if b is true
    public static void setH(boolean st) {
      if ((getB() == true) && (st == true)) {
        h = true;
      }
      else {
        h = false;
      }
    }

    // i is only set to true if 2 previously entered characters are correct
    public static void setI(boolean st) {
      if ((getH() == true) && (st == true)) {
        i = true;
      }
      else {
        i = false;
      }
    }

    /**
     * Method that saves Codes object data to CodesSaves.txt
     */
    public static void saveCodes(){
        try{
            File f = new File("CodesSave.txt");
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //oos.writeObject(this);
            oos.close();
        } catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
}
