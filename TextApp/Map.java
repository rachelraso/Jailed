public class Map{

public char[][] grid;

public Map(int x, int y){
    grid = new char[x][y];
}

public boolean isValidMove(int x, int y, String dir){

    if(dir.equals("w")){
        if(this.grid[x-1][y] == 'o')
            return false;
    }
    else if(dir.equals("s")){
        if(this.grid[x+1][y] == 'o')
            return false;
    }
    else if(dir.equals("a")){
        if(this.grid[x][y-1] == 'o')
            return false;
    }
    else if(dir.equals("d")){
        if(this.grid[x][y+1] == 'o')
            return false;
    }
    
    return true;
}

}