import java.util.*;

public class Run2048 {
   //Variables
   public static int[] board = new int[16];
   public static Scanner sc = new Scanner(System.in);

   /*________
   0 |1 |2 |3
   4 |5 |6 |7
   8 |9 |10|11
   12|13|14|15
   _________*/
   
   //Main Method------
   public static void main(String[] args) {
      String key = "";
      setArray(board, 0);
      while (!checkEnd(board)) {
      spawn2(board);
      showBoard(board);
      key = getKey(sc);
      if (key.equals("w")) changeArrayUp(board);
      else if (key.equals("a")) changeArrayLeft(board);
      else if (key.equals("s")) changeArrayDown(board);
      else if (key.equals("d")) changeArrayRight(board);
      }
      System.out.println("YOU LOST");
   }
   
   //SETTERS--------
   public static void setArray(int[] arr, int setTo) {
      for (int i = 0; i < arr.length; i++) {
         arr[i] = setTo;
      }
   }
   
   
   //OTHER METHODS--------
   //detect player input
   public static String getKey( Scanner s) {
   System.out.println("\n");
   String moveLetter = s.next().substring(0,1).toLowerCase();
      if (!(moveLetter.equals("s") || moveLetter.equals("a") || moveLetter.equals("w") || moveLetter.equals("d"))) {
         System.out.println("INVALID");
         moveLetter = s.next().substring(0,1).toLowerCase();
      }
   
      return moveLetter.toLowerCase();
   }
   
   //Place a number 2 in an empty spot
   public static void spawn2(int[] b) {
      int ranNum = (int)(Math.random()*b.length);
      while (!(b[ranNum] == 0)) {//while the random index value is not 0 change it
         ranNum = (int)(Math.random()*b.length);
      }
      b[ranNum] = 2;
   }
   
   //Show Board
   public static void showBoard(int[] b) {
      System.out.println("\n\n\n");
      for (int j = 0; j < 4; j++) {//in each COlUMN
         for (int i = 0; i < 4; i++) {//in each ROW
            int number = b[i+4*j];
            if (number < 10) System.out.print(" ");//if the number is 1 digit place a space
            if (number != 0)
               System.out.print(number);
            else System.out.print(" ");
            if (number < 100)
               System.out.print(" ");
            if (i != 3) System.out.print("|");
         }
         if (j != 3) System.out.println("\n---------------");//dont print on last lines
      }
      
   }
   
   //end Game
   public static boolean checkEnd(int[] b) {
      for (int x:b) {
         if (x == 0) return false;
      }
      return true;
   }
   
   //Shift array elements UP
   public static void changeArrayUp(int[] b) {
   int count = 1;
   while (count > 0) {//repeat until nothing else is moved
   count = 0;
      for (int i = 15; i >= 4; i--) {//start at the bottom row and move up
         if (b[i] != 0) {
         if (b[i-4] == b[i]) {//if the item above is the same number
            b[i-4] += b[i-4];
            count++;
            b[i] = 0;
         } else if (b[i-4] == 0) {//if the item above is nothing move there
            b[i-4] = b[i];
            count++;
            b[i] = 0;
         }//item moved is now 0
         }
       }
     }
   }
   //Shift array elements DOWN
   public static void changeArrayDown(int[] b) {
   int count = 1;
   while (count > 0) {//repeat until nothing else is moved
   count = 0;
      for (int i = 0; i < b.length-4; i++) {//start at the top row and move down
         if (b[i] != 0) {
         if (b[i+4] == 0) {//if the item below is nothing move there
            b[i+4] = b[i];
            count++;
            b[i] = 0;
         } else if (b[i+4] == b[i]) {
            b[i+4] += b[i+4];
            count++;
            b[i] = 0;
         }
         }
       }
     }
   }
   //Shift array elements Left
   public static void changeArrayLeft(int[] b) {
   int count = 1;
   while (count > 0) {//repeat until nothing else is moved
   count = 0;
      for (int i = 0; i < b.length; i++) {//start at the left column and move left
      if ((i)%4 != 0 && i != 0 && b[i] != 0) {
         if (b[i-1] == 0) {//if the item in front is nothing move there
            b[i-1] = b[i];
            count++;
            b[i] = 0;
         } else if (b[i-1] == b[i]) {
            b[i-1] += b[i-1];
            count++;
            b[i] = 0;
         }
         }
       }
     }
   }
   //Shift array elements Right
   public static void changeArrayRight(int[] b) {
   int count = 1;
   while (count > 0) {//repeat until nothing else is moved
   count = 0;
      for (int i = 0; i < b.length; i++) {//start at the left column and move right
      if ((i+1)%4 != 0 && b[i] != 0) {
         if (b[i+1] == 0) {//if the item in front is nothing move there
            b[i+1] = b[i];
            count++;
            b[i] = 0;
         } else if (b[i+1] == b[i]) {
            b[i+1] += b[i+1];
            count++;
            b[i] = 0;
         }
         }
       }
     }
   }
   
}