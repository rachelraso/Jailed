import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.Rectangle;

public class PlayerTest {
    /**
     * Tests the default Constructor of the Player Class
     */
    @Test
    public void testDefaultConstructor(){
        //first makes a new player object
        Player p = new Player();
        //then checks to make sure the X is equal to 0
        assertEquals(0, p.getX());
        //checks Y is equal to 0
        assertEquals(0, p.getY());
        //checks status is true
        assertEquals(true, p.getStatus());
    }

    /**
     * Tests the XY Constructor of the Player Class
     */
    @Test
    public void testXAndYConstructor(){
        //first makes a new Player object with X of 10 and Y of 15
        Player p = new Player(10, 15);
        //checks to make sure X is equal to 10
        assertEquals(10, p.getX());
        //checks to make sure Y is equal to 15
        assertEquals(15, p.getY());
        //checks status is true
        assertEquals(true, p.getStatus());
    }

    /**
     * Tests the getPlayerBoundary() method of the Player class
     */
    @Test
    public void testGetPlayerBoundary(){
        //first makes a new Player object
        Player p = new Player();
        //then makes a new Rectangle with x of 0, y of 0, width of 22, and height of 35
        Rectangle r = new Rectangle(0, 0, 20, 30);
        //then checks the Rectangle is equal to what getPlayerBoundary() returns
        assertEquals(r,p.getPlayerBoundary());
    }

    /**
     * Tests the getPlayerBoundaryX() method of the Player class
     */
    @Test
    public void testGetPlayerBoundaryX(){
        //first makes a new Player object
        Player p = new Player();
        //then makes a new Rectangle with x of 1, y of 0, width of 22, and height of 35
        Rectangle r = new Rectangle(1, 0, 20, 30);
        //then checks the Rectangle is equal to what getPlayerBoundaryX(1) returns
        assertEquals(r,p.getPlayerBoundaryX(1));
    }

    /**
     * Tests the getPlayerBoundaryY() method of the Player class
     */
    @Test
    public void testGetPlayerBoundaryY(){
        //first makes a new Player object
        Player p = new Player();
        //then makes a new Rectangle with x of 0, y of 2, width of 22, and height of 35
        Rectangle r = new Rectangle(0, 2, 20, 30);
        //then checks the Rectangle is equal to what getPlayerBoundaryY(2) returns
        assertEquals(r,p.getPlayerBoundaryY(2));
    }

    /**
     * Tests the setX() method of the Player class
     */
    @Test
    public void testSetX(){
        //first makes a new Player object
        Player p = new Player();
        //then attempts to setX coordinate to 10
        p.setX(10);
        //then checks 10 is equal to what getX() returns
        assertEquals(10,p.getX());
    }

    /**
     * Tests the setY() method of the Player class
     */
    @Test
    public void testSetY(){
        //firsts makes a new Player object
        Player p = new Player();
        //then attempts to setY coordinate to 20
        p.setY(20);
        //then checks 20 is equal to what getY() returns
        assertEquals(20,p.getY());
    }

    /**
     * Tests the setStatus() method of the Player class
     */
    @Test
    public void testSetStatus(){
        //first makes a new Player object
        Player p = new Player();
        //then attempts to setStatus to false
        p.setStatus(false);
        //then checks that getStatus() returns false
        assertEquals(false,p.getStatus());
    }

    /**
     * Tests the moveUp() method of the Player class
     */
    @Test
    public void testMoveUp(){
        //first makes a new Player object
        Player p = new Player();
        //then attempts to use moveUp() method on the player object
        p.moveUp();
        //then checks that getY() returns -2
        assertEquals(-2,p.getY());
    }

    /**
     * Tests the moveDown() method of the Player class
     */
    @Test
    public void testMoveDown(){
        //first makes a new Player object
        Player p = new Player();
        //then attempts to use moveDown() method on the player object
        p.moveDown();
        //then checks that getY() returns 2
        assertEquals(2,p.getY());
    }

    /**
     * Tests the moveRight() method of the Player class
     */
    @Test
    public void testMoveRight(){
        //first makes a new Player object
        Player p = new Player();
        //then attempts to use moveRight() method on the player object
        p.moveRight();
        //then checks that getX() returns 2
        assertEquals(2,p.getX());
    }

    /**
     * Tests the moveLeft() method of the Player class
     */
    @Test
    public void testMoveLeft(){
        //first makes a new Player object
        Player p = new Player();
        //then attempts to use moveLeft() method on the player object
        p.moveLeft();
        //then checks that getX() returns -2
        assertEquals(-2,p.getX());
    }
}
