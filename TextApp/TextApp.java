/**
* This is the driver class which instantiates Map, and Player
* Compile this program to play the game
* At the prompt:
    press 'w' + 'enter' to move up
    press 's' + 'enter' to move down
    press 'a' + 'enter' to move left
    press 'd' + 'enter' to move right
    press any other key to terminate the program.
*/


import java.util.Scanner;

public class TextApp {

    private static Map textMap;
    final private static int dimX = 32;
    final private static int dimY = 32;
    private static boolean isCollected = false;
   // private static Crowbar crowbar;
    private static int locX;
    private static int locY;

    private static Player playerRachel;

    public static void main(String[] args){

        //Create instance of map. Pass dimensions of the map
        textMap = new Map(dimX, dimY);

        initializeMap(textMap, isCollected);

        //Create instance of player. Pass location of spawn
        playerRachel = new Player(24, 24);
  
        addPlayer(playerRachel);   
        
        printMap(textMap);

        //Create instance of crowbar (collectable)
       // crowbar = new Crowbar();
       // locX = crowbar.getX();
       // locY = crowbar.getY();

        textMap.grid[locX][locY] = 'B';

        //Start the game
        play();
        

    }

    //Method to initialize and update the map
    public static void initializeMap(Map m, boolean isCollected){
        //Intialize text-based version of the game
        for(int i = 0; i < dimX; i++){
            for(int j = 0; j < dimY; j++){
                m.grid[i][j] = '.';
            }
        }

        initializeBoundaries(m);

        if(!isCollected){
            textMap.grid[14][5] = 'B';
        }
    }



    //Method to print the map to the console screen
    public static void printMap(Map m){
        for (int i = 0; i < dimX; i++){
            for(int j = 0; j < dimY; j++){
                System.out.print(m.grid[i][j] + " ");
            }
            System.out.println();
        }

    }

    //Method to initialize the boundaries of the map
    public static void initializeBoundaries(Map m){
        //Initialize top boundary
        for(int i = 0; i < dimY; i++){
            m.grid[0][i] = 'o';
        }

        //Initialize left boundary
        for(int i = 0; i < dimX; i++){
            m.grid[i][0] = 'o';
        }

        //Initialize right boundary
        for(int i = 0; i < dimY; i++){
            m.grid[dimX-1][i] = 'o';
        }

        //Initialize bottom boundary
        for(int i = 0; i < dimX; i++){
            m.grid[i][dimY-1] = 'o';
        }

        //Initialize kitchen
        for(int i = 0; i < 16; i++){
            m.grid[10][i] = 'o';
        }

        for(int i = 0; i < 16; i++){
            m.grid[18][i] = 'o';
        }

        // //Initialize prison cells
        for(int i = 0; i < dimX; i++){
            m.grid[27][i] = 'o';
        }

        for(int i = 27; i < dimX; i++){
            m.grid[i][3] = 'o';
        }

        for(int i = 27; i < dimX; i++){
            m.grid[i][6] = 'o';
        }

        for(int i = 27; i < dimX; i++){
            m.grid[i][9] = 'o';
        }

        for(int i = 27; i < dimX; i++){
            m.grid[i][12] = 'o';
        }

        for(int i = 27; i < dimX; i++){
            m.grid[i][15] = 'o';
        }

        for(int i = 27; i < dimX; i++){
            m.grid[i][18] = 'o';
        }

        for(int i = 27; i < dimX; i++){
            m.grid[i][21] = 'o';
        }

        for(int i = 27; i < dimX; i++){
            m.grid[i][24] = 'o';
        }

        for(int i = 27; i < dimX; i++){
            m.grid[i][27] = 'o';
        }

        //Initialize offices
        for(int i = 24; i < dimX; i++){
            m.grid[6][i] = 'o';
        }

        for(int i = 0; i < 6; i++){
            m.grid[i][24] = 'o';
        }

        for(int i = 18; i < dimX; i++){
            m.grid[6][i] = 'o';
        }

        for(int i = 0; i < 6; i++){
            m.grid[i][18] = 'o';
        }

    }

    //Method to add player to the map
    public static void addPlayer(Player p){
        textMap.grid[p.getX()][p.getY()] = 'X';
    }

    //Method to update player's location (it's sthe same as addPlayer for now)
    public static void updatePlayer(Player p){
        textMap.grid[p.getX()][p.getY()] = 'X';
    }

    //Method to start the game engine
    public static void play(){
        System.out.println("Enter a direction, and press return: 'w' for up, 's' for down, 'a' for left, 'd' for right. Press any other key to exit.");
        
        //Read input from the keyboard, until termination condition is met (see default case)
        while(true){
        Scanner input = new Scanner(System.in);
        
        String stroke = input.next();
        
        //Switch statement for keystroke
        switch(stroke){
            case "w":
            if(textMap.isValidMove(playerRachel.getX(), playerRachel.getY(), "w")){
                if(textMap.grid[playerRachel.getX() - 1][playerRachel.getY()] == 'B'){
                    System.out.println("Backpack has been collected!");
                    isCollected = true;
                }
                initializeMap(textMap, isCollected);
                playerRachel.moveUp();
                updatePlayer(playerRachel);
                printMap(textMap);
            }
            else{
                printMap(textMap);
            }
            break;
            case "s":
            if(textMap.isValidMove(playerRachel.getX(), playerRachel.getY(), "s")){
                if(textMap.grid[playerRachel.getX() + 1][playerRachel.getY()] == 'B'){
                    System.out.println("Backpack has been collected!");
                    isCollected = true;
                }
                initializeMap(textMap, isCollected);
                playerRachel.moveDown();
                updatePlayer(playerRachel);
                printMap(textMap);
            }
            else{
                printMap(textMap);
            }
            break;
            case "a":
            if(textMap.isValidMove(playerRachel.getX(), playerRachel.getY(), "a")){
                if(textMap.grid[playerRachel.getX()][playerRachel.getY()-1] == 'B'){
                    System.out.println("Backpack has been collected!");
                    isCollected = true;
                }
                initializeMap(textMap, isCollected);
                playerRachel.moveLeft();
                updatePlayer(playerRachel);
                printMap(textMap);
            }
            else{
                printMap(textMap);
            }
            break;
            case "d":
            if(textMap.isValidMove(playerRachel.getX(), playerRachel.getY(), "d")){
                if(textMap.grid[playerRachel.getX()][playerRachel.getY()+1] == 'B'){
                    System.out.println("Backpack has been collected!");
                    isCollected = true;
                }
                initializeMap(textMap, isCollected);
                playerRachel.moveRight();
                updatePlayer(playerRachel);
                printMap(textMap);
            }
            else{
                printMap(textMap);
            }
            break;
            default:
            System.exit(0);
            break;
        }


        }
    }





    

}
