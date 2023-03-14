import java.util.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String , Jumper> hm = new HashMap<>();
        hm.put("6" , new Jumper(new Coordinates(9,5) , new Coordinates(6,6))); // ladder
        hm.put("99" , new Jumper(new Coordinates(0,1) , new Coordinates(9,9))); // snake
        hm.put("21" , new Jumper(new Coordinates(7,0) , new Coordinates(0,9))); // ladder
        hm.put("64" , new Jumper(new Coordinates(3,3) , new Coordinates(7,4))); // snake

        Board board = new Board(hm);
        System.out.println("How many Players want to Play ?");
        int n = sc.nextInt();
        Player[] p = new Player[n];

        for(int i=0 ; i<n ; i++){
            System.out.println("Enter the Name: ");
            String name = sc.next();
            System.out.println("Enter the Symbol: ");
            String symbol = sc.next();
            p[i] = new Player(name , symbol);
        }

//        Player[] players = new Player[]{new Player("Aman" , "Red") , new Player("Ajinkya" , "Blue")};
        Game game = new Game(board , p);
        game.play();
//        System.out.println(board);


    }


}
