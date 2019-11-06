import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.IOException;
import java.util.Random;

public class Enemy implements Serializable {

    // INSTANCE VARIABLES
    private double x;
    private double y;
    private int h; // height
    private int w; // width

    // enemy specs
    private final double speedAI= 0.1;
    private final long stall = 2;
    private long lastTime = 0;
    private final int cp1x = 300;
    private final int cp1y = 310;



    //Artificial Intelligence specs
    //Control point boundaries
    double x1 = 140;
    double x2 = 500;

    //Define array of control points
    //double cpts[] = new double[10];

    //double cpts[] = {280, 340, 440};
    double cpts1[] = {350, 375, 400, 425, 450};
    double cpts2[] = {140, 210, 320, 410, 500};
    double cpts3[] = {25, 75, 150, 250, 300};

    double randCpts1[] = new double[cpts1.length];
    double randCpts2[] = new double[cpts2.length];
    double randCpts3[] = new double[cpts3.length];

    Random rand = new Random();


    // CONSTRUCTORS
    /**
     * Default constructor
     */
    public Enemy() {
        this.x = 0;
        this.y = 0;
        this.h = 35;
        this.w = 22;
    }

  /**
	 * Constructor that takes in x and y as an argument
	 * @param x
	 * @param y
	 */
    public Enemy(int x, int y){
        this.x = x;
        this.y = y;
        this.h = 35;
        this.w = 22;
      }

    // GETTERS
    /**
     * Getter method that returns value of x coordinate
     *
     * @return
     */
    public double getX() {
        return x;
    }

    /**
     * Getter method that returns value of y coordinate
     *
     * @return
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
  * Method controls movement of the 1st guard
  * @param t
  */

  //Sets randCpts
  public void generateRandomCpts1(){
    for(int i = 0; i < randCpts1.length; i++){
      // Obtain a number between [0 - 4].
      int n = rand.nextInt(5);

      randCpts1[i] = cpts1[n];

    }
  }


  public void generateRandomCpts2(){
    for(int i = 0; i < randCpts2.length; i++){
      // Obtain a number between [0 - 4].
      int n = rand.nextInt(5);
      randCpts2[i] = cpts2[n];
    }
  }

  public void generateRandomCpts3(){
    for(int i = 0; i < randCpts3.length; i++){
      // Obtain a number between [0 - 4].
      int n = rand.nextInt(5);
      randCpts3[i] = cpts3[n];
    }
  }


  /**
* Method controls movement of the 1st guard (spawns at (0, 400))
* @param t
*/

  public void setDirectionG1(double t) {

    if(t < 3){
      if(getY() < cpts1[0]){
        setY(getY() + t*speedAI);
      }
    }
    else if (t > 6 && t < 9){
      if(getY() > cpts1[1]){
        setY(getY() - t*speedAI);
      }
    }
    else if (t > 12 && t < 15){
      if(getY() < cpts1[2]){
        setY(getY() + t*speedAI);
      }
    }
    else if (t > 15 && t < 18){
      if(getY() > cpts1[3]){
        setY(getY() - t*speedAI);
      }
    }
    else if (t > 21 && t < 24){
      if(getY() < cpts1[4]){
        setY(getY() + t*speedAI);
      }
    }
    else if (t > 27 && t < 30){
      if(getY() > cpts1[0]){
        setY(getY() - t*speedAI);
      }
    }
    else if (t > 33 && t < 36){
      if(getY() < cpts1[1]){
        setY(getY() + t*speedAI);
      }
    }
    else if (t > 39 && t < 42){
      if(getY() > cpts1[2]){
        setY(getY() - t*speedAI);
      }
    }
    else if (t > 42 && t < 45){
      if(getY() > cpts1[3]){
        setY(getY() - t*speedAI);
      }
    }
    else if (t > 48 && t < 51){
      if(getY() < cpts1[4]){
        setY(getY() + t*speedAI);
      }
    }


}

/**
* Method controls movement of the 2nd guard (spawns at (140, 310))
* @param t
*/

  public void setDirectionG2(double t) {


      if(t < 2){
        if(getX() < cpts2[0]){
          setX(getX() + t*speedAI);
        }
      }
      else if (t > 2 && t < 4){
        if(getX() > cpts2[1]){
          setX(getX() - t*speedAI);
        }
      }
      else if (t > 4 && t < 6){
        if(getX() > cpts2[3]){
          setX(getX() - t*speedAI);
        }
      }
      else if (t > 6 && t < 8){
        if(getX() < cpts2[2]){
          setX(getX() + t*speedAI);
        }
      }
      else if (t > 8 && t < 10){
        if(getX() > cpts2[3]){
          setX(getX() - t*speedAI);
        }
      }
      else if (t > 10 && t < 12){
        if(getX() > cpts2[4]){
          setX(getX() - t*speedAI);
        }
      }
      else if (t > 12 && t < 14){
        if(getX() > cpts2[2]){
          setX(getX() - t*speedAI);
        }
      }
      else if (t > 15 && t < 18 ){
        if(getX() < cpts2[4]){
          setX(getX() + t*speedAI);
        }
      }
      else if (t > 18 && t < 21){
        if(getX() > cpts2[0]){
          setX(getX() - t*speedAI);
        }
      }
      else if (t > 21 && t < 24){
        if(getX() < cpts2[1]){
          setX(getX() + t*speedAI);
        }
      }
      else if (t > 24 && t < 26){
        if(getX() > cpts2[2]){
          setX(getX() - t*speedAI);
        }
      }
      else if (t > 26 && t < 28){
        if(getX() > cpts2[3]){
          setX(getX() - t*speedAI);
        }
      }
      else if (t > 28 && t < 30){
        if(getX() < cpts2[4]){
          setX(getX() + t*speedAI);
        }
      }
      else if (t > 30 && t < 33){
        if(getX() < cpts2[3]){
          setX(getX() + t*speedAI);
        }
      }
      else if (t > 33 && t < 35){
        if(getX() < cpts2[2]){
          setX(getX() + t*speedAI);
        }
      }
      else if (t > 36 && t < 39){
        if(getX() < cpts2[0]){
          setX(getX() + t*speedAI);
        }
      }
      else if (t > 39 && t < 42){
        if(getX() < cpts2[3]){
          setX(getX() + t*speedAI);
        }
      }
      else if (t > 42 && t < 45){
        if(getX() < cpts2[4]){
          setX(getX() + t*speedAI);
        }
      }
      else if (t > 45 && t < 48){
        if(getX() < cpts2[1]){
          setX(getX() + t*speedAI);
        }
      }
      else if (t > 48 && t < 51){
        if(getX() < cpts2[3]){
          setX(getX() + t*speedAI);
        }
      }
      else if (t > 52 && t < 54){
        if(getX() < cpts2[0]){
          setX(getX() + t*speedAI);
        }
      }
      else if (t > 54 && t < 56){
        if(getX() < cpts2[4]){
          setX(getX() + t*speedAI);
        }
      }
      else if (t > 56 && t < 58){
        if(getX() < cpts2[3]){
          setX(getX() + t*speedAI);
        }
      }
    }

    /**
    * Method controls movement of the 3rd guard. Spawns at (600, 100);
    * @param t
    */

    public void setDirectionG3(double t) {

      if(t < 3){
        if(getY() < cpts3[0]){
          setY(getY() + t*speedAI);
        }
      }
      else if (t > 3 && t < 6){
        if(getY() > cpts3[1]){
          setY(getY() - t*speedAI);
        }
      }
      else if (t > 6 && t < 9){
        if(getY() > cpts3[2]){
          setY(getY() - t*speedAI);
        }
      }
      else if (t > 9 && t < 12){
        if(getY() > cpts3[3]){
          setY(getY() - t*speedAI);
        }
      }
      else if (t > 12 && t < 15){
        if(getY() < cpts3[2]){
          setY(getY() + t*speedAI);
        }
      }
      else if (t > 15 && t < 18){
        if(getY() > cpts3[3]){
          setY(getY() - t*speedAI);
        }
      }
      else if (t > 21 && t < 24){
        if(getY() < cpts3[4]){
          setY(getY() + t*speedAI);
        }
      }
      else if (t > 24 && t < 27){
        if(getY() > cpts3[3]){
          setY(getY() - t*speedAI);
        }
      }
      else if (t > 27 && t < 30){
        if(getY() > cpts3[2]){
          setY(getY() - t*speedAI);
        }
      }
      else if (t > 30 && t < 33){
        if(getY() > cpts3[0]){
          setY(getY() - t*speedAI);
        }
      }
      else if (t > 33 && t < 36){
        if(getY() < cpts3[1]){
          setY(getY() + t*speedAI);
        }
      }
      else if (t > 39 && t < 42){
        if(getY() > cpts3[2]){
          setY(getY() - t*speedAI);
        }
      }
      else if (t > 42 && t < 45){
        if(getY() > cpts3[3]){
          setY(getY() - t*speedAI);
        }
      }
      else if (t > 48 && t < 51){
        if(getY() < cpts3[4]){
          setY(getY() + t*speedAI);
        }
      }
      else if (t > 51 && t < 54){
        if(getY() > cpts3[3]){
          setY(getY() - t*speedAI);
        }
      }
      else if (t > 54 && t < 57){
        if(getY() > cpts3[1]){
          setY(getY() - t*speedAI);
        }
      }
  }

    /**
     * Save methods that function the exact same just output to different textfiles
     */
  public void saveEnemy1(){
        try {
            File f = new File("EnemySave1.txt");
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
        } catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
  }

  public void saveEnemy2(){
        try{
            File f = new File("EnemySave2.txt");
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
        } catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
  }

  public void saveEnemy3(){
        try{
            File f = new File("EnemySave3.txt");
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
        } catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
  }

  public void saveEnemy4(){
      try{
          File f = new File("EnemySave4.txt");
          FileOutputStream fos = new FileOutputStream(f);
          ObjectOutputStream oos = new ObjectOutputStream(fos);
          oos.writeObject(this);
          oos.close();
      } catch(IOException ioe){
          System.out.println(ioe.getMessage());
      }
  }
}
