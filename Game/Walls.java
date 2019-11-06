import java.awt.Rectangle;
import java.util.ArrayList;
import javafx.stage.Stage;

public abstract class Walls extends Map {

/*
* INSTANCE VARIABLES:
* wall rectnagles with x, y corrdinates and width, height parameters
*/

    // cells
  private static final Rectangle cell1 = new Rectangle (188, 481, 13, 58);
  private static final Rectangle cell2 = new Rectangle (275, 481, 13, 60);
  private static final Rectangle cell3 = new Rectangle (363, 481, 13, 60);
  private static final Rectangle cell4 = new Rectangle (450, 481, 13, 60);
  private static final Rectangle cell5 = new Rectangle (538, 481, 13, 60);
  private static final Rectangle cell6 = new Rectangle (625, 363, 13, 177);
  private static final Rectangle cell7 = new Rectangle (538, 380, 13, 60);
  private static final Rectangle cell8 = new Rectangle (450, 380, 13, 60);
  private static final Rectangle cell9 = new Rectangle (363, 380, 13, 60);
  private static final Rectangle cell10 = new Rectangle (275, 375, 13, 60);
  private static final Rectangle cell11 = new Rectangle (188, 380, 13, 60);
  private static final Rectangle cell12 = new Rectangle (188, 363, 450, 17);

  // top left
  private static final Rectangle left1 = new Rectangle (0, 203, 313, 17);
  private static final Rectangle left2 = new Rectangle (313, 59, 17, 160);

  // top right
  private static final Rectangle right1 = new Rectangle (638, 112, 163, 17);
  private static final Rectangle right2 = new Rectangle (638, 42, 17, 143);
  private static final Rectangle right3 = new Rectangle (638, 228, 17, 74);
  private static final Rectangle right4 = new Rectangle (638, 304, 163, 17);

  // top middle ++
  private static final Rectangle m1 = new Rectangle (392, 59, 17, 236);
  private static final Rectangle m2 = new Rectangle (394, 279, 181, 17);
  private static final Rectangle m3 = new Rectangle (559, 0, 17, 281);

  // bottom left
  private static final Rectangle l1 = new Rectangle (37, 278, 100, 16);
  private static final Rectangle l2 = new Rectangle (120, 279, 16, 261);

  // escape door on the left
  private static final Rectangle escDoor = new Rectangle (0, 278, 37, 17);

  // game boundaries
  private static final Rectangle bottom = new Rectangle (0, 540, 800, 25);
  private static final Rectangle top = new Rectangle (0, -25, 800, 25);
  private static final Rectangle left = new Rectangle (-13, 0, 13, 540);
  private static final Rectangle right = new Rectangle (800, 0, 13, 540);

  private static Rectangle cellDoor = new Rectangle (188, 437, 13, 44);

  // final exit and contraints
  private static Rectangle leftWall = new Rectangle (0, 488, 37, 52);
  private static Rectangle exit = new Rectangle (36, 505, 51, 33);
  private static Rectangle rightWall = new Rectangle (88, 488, 33, 52);


/*
* DEFAULT CONSTRUCTOR
* empty because all the variables are final
*/
  public Walls() {
  }

/*
* METHOD that checked whether player's move would collide with the walls
* @param playerBoundary Rectangle with player's x, y, w, h coordinates
* @returns boolean true if the two rectangles indeed intersect (collision); false otherwise
*/
  public static boolean didCollide (Rectangle playerBoundary, int g) {
    boolean f;

    if (g == 2) {
      f = escapeDoorCollision(playerBoundary);
    }
    else if ((g == 0) || (g == 1)) {
      f = cellDoorCollision(playerBoundary);
    }
    else {
      // CASE: player should'n be able to break through the final escape door
      f = noDoorCollision(playerBoundary);
    }
    return f;
  }

  private static boolean escapeDoorCollision (Rectangle playerBoundary) {
    if ( (cell1.intersects(playerBoundary)) || (cell2.intersects(playerBoundary)) || (cell3.intersects(playerBoundary))
    || (cell4.intersects(playerBoundary)) || (cell5.intersects(playerBoundary)) || (cell6.intersects(playerBoundary))
    || (cell7.intersects(playerBoundary)) || (cell8.intersects(playerBoundary)) || (cell9.intersects(playerBoundary))
    || (cell10.intersects(playerBoundary)) || (cell11.intersects(playerBoundary)) || (cell12.intersects(playerBoundary))
    || (left1.intersects(playerBoundary)) || (left2.intersects(playerBoundary)) || (right1.intersects(playerBoundary))
    || (right2.intersects(playerBoundary)) || (right3.intersects(playerBoundary)) || (right4.intersects(playerBoundary))
    || (m1.intersects(playerBoundary)) || (m2.intersects(playerBoundary)) || (m3.intersects(playerBoundary))
    || (l1.intersects(playerBoundary)) || (l2.intersects(playerBoundary)) || (bottom.intersects(playerBoundary))
    || (top.intersects(playerBoundary)) || (left.intersects(playerBoundary)) || (right.intersects(playerBoundary))
    || (escDoor.intersects(playerBoundary)) || (leftWall.intersects(playerBoundary)) || (rightWall.intersects(playerBoundary))) {
      return true;
    }
    else {
        return false;
    }
  }

  private static boolean cellDoorCollision (Rectangle playerBoundary) {
    if ( (cell1.intersects(playerBoundary)) || (cell2.intersects(playerBoundary)) || (cell3.intersects(playerBoundary))
    || (cell4.intersects(playerBoundary)) || (cell5.intersects(playerBoundary)) || (cell6.intersects(playerBoundary))
    || (cell7.intersects(playerBoundary)) || (cell8.intersects(playerBoundary)) || (cell9.intersects(playerBoundary))
    || (cell10.intersects(playerBoundary)) || (cell11.intersects(playerBoundary)) || (cell12.intersects(playerBoundary))
    || (left1.intersects(playerBoundary)) || (left2.intersects(playerBoundary)) || (right1.intersects(playerBoundary))
    || (right2.intersects(playerBoundary)) || (right3.intersects(playerBoundary)) || (right4.intersects(playerBoundary))
    || (m1.intersects(playerBoundary)) || (m2.intersects(playerBoundary)) || (m3.intersects(playerBoundary))
    || (l1.intersects(playerBoundary)) || (l2.intersects(playerBoundary)) || (bottom.intersects(playerBoundary))
    || (top.intersects(playerBoundary)) || (left.intersects(playerBoundary)) || (right.intersects(playerBoundary))
    || (cellDoor.intersects(playerBoundary)) || (escDoor.intersects(playerBoundary))|| (leftWall.intersects(playerBoundary))
    || (rightWall.intersects(playerBoundary))) {
      return true;
    }
    else {
        return false;
    }
  }

  private static boolean noDoorCollision (Rectangle playerBoundary) {
    if ( (cell1.intersects(playerBoundary)) || (cell2.intersects(playerBoundary)) || (cell3.intersects(playerBoundary))
    || (cell4.intersects(playerBoundary)) || (cell5.intersects(playerBoundary)) || (cell6.intersects(playerBoundary))
    || (cell7.intersects(playerBoundary)) || (cell8.intersects(playerBoundary)) || (cell9.intersects(playerBoundary))
    || (cell10.intersects(playerBoundary)) || (cell11.intersects(playerBoundary)) || (cell12.intersects(playerBoundary))
    || (left1.intersects(playerBoundary)) || (left2.intersects(playerBoundary)) || (right1.intersects(playerBoundary))
    || (right2.intersects(playerBoundary)) || (right3.intersects(playerBoundary)) || (right4.intersects(playerBoundary))
    || (m1.intersects(playerBoundary)) || (m2.intersects(playerBoundary)) || (m3.intersects(playerBoundary))
    || (l1.intersects(playerBoundary)) || (l2.intersects(playerBoundary)) || (bottom.intersects(playerBoundary))
    || (top.intersects(playerBoundary)) || (left.intersects(playerBoundary)) || (right.intersects(playerBoundary))
    || (leftWall.intersects(playerBoundary)) || (rightWall.intersects(playerBoundary))) {
      return true;
    }
    else {
        return false;
    }
  }

  public static boolean LeftDoorCollision (Rectangle playerBoundary) {
    if (escDoor.intersects(playerBoundary)) {
      return true;
    }
    else {
      return false;
    }
  }

  public static boolean exitDoorCollision (Rectangle playerBoundary) {
    if (exit.intersects(playerBoundary)) {
      return true;
    }
    else {
      return false;
    }
  }

}
