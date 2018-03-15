import java.lang.Math;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

class Game{


  private int grid[][];
  private int size = 4;
  boolean gameOver = false;
  Scanner in = new Scanner(System.in);

  public static void main(String args[])throws IOException{


    Game play24 = new Game();
    play24.initializeGrid();
    play24.printGrid();
    play24.playGame();
    //play24.move(3,2,'l');


  }

  public Game(){
    grid = new int[size][size];
  }


  public void playGame() throws IOException{


    System.out.println("Enter -1 to exit else enter the values for i, j, direction <'u', 'd', 'l', 'r'>");
    int row;
    int col;
    char dir;

    while( !gameOver){

      row = in.nextInt();

      if( row == -1){
        System.exit(0);
      }


      col = in.nextInt();
      dir = (char)(System.in.read());

      move(row, col, dir);
      printGrid();
    }



  }
  public void move(int i, int j, char direction){ //indices of tile to move and the direction to move them

    i = 3;
    j= 2;
    direction = 'l';
    if( grid[i][j] == 0){
      System.out.println("Invalid");
    }

    else{
    //up, down, left, right
    switch(direction){

      case 'u':
        if( i-1 > 0){
          if( grid[i][j] == grid[i-1][j]){
            grid[i-1][j] = grid[i-1][j] * 2;
            if( grid[i-1][j] == 2048)
            gameOver = true;
            grid[i][j] = 0;
          }
        }
        else{
          System.out.println("Invalid, try again");
        }


      break;

      case 'l':
        if( j-1 > 0){
          if( grid[i][j] == grid[i][j-1]){
            grid[i][j-1] = grid[i][j-1] * 2;
            if( grid[i][j-1] == 2048)
            gameOver = true;
            grid[i][j] = 0;
          }
        }
        else{
          System.out.println("Invalid, try again");
        }
      break;

      case 'r':
          if( i+1 < size){
          if( grid[i][j] == grid[i+1][j]){
            grid[i+1][j] = grid[i+1][j] * 2;
            if( grid[i+1][j] == 2048)
            gameOver = true;
            grid[i][j] = 0;
          }
          }
        else{
          System.out.println("Invalid, try again");
        }
      break;

      case 'd':
            if( j+1 < size){
          if( grid[i][j] == grid[i][j+1]){
            grid[i-1][j] = grid[i][j+1] * 2;
            if( grid[i-1][j] == 2048)
            gameOver = true;
            grid[i][j] = 0;

          }
            }
        else{
          System.out.println("Invalid, try again");
        }
      break;


    }
    }

  }

    public void boardIsFull(){

      for( int i=0; i<size; i++){
        for( int j=0; j<size; j++){
          if(grid[i][j] == 0)
          return false;
        }
      }
      return true;
    }
   public void randomSpawn(){
    // initialize random 2 tiles on the grid

    while( grid[i][j] != 0){

    int i = rand.nextInt(4);
    int j = rand.nextInt(4);

  }

    grid[i][j] = choices[rand.nextInt(2)];

    if( boardIsFull)
    gameOver = true;

  }
  public void initializeGrid(){

   Random rand = new Random();
    int choices[] = {2,4};

    // initialise grid to 0
    for( int i=0; i<size; i++){
      for( int j=0; j<size; j++){
        grid[i][j] = 0;
      }
    }

    randomSpawn();
    randomSpawn();


  }


  public void printGrid(){

    for( int i=0; i<size; i++){
      for( int j=0; j<size; j++){
        System.out.print(grid[i][j]);
      }
      System.out.println();
    }
  }

}
