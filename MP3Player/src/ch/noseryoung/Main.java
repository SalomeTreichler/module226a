package ch.noseryoung;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MusicManager  manager = MusicManager.getInstance();
        Scanner scan = new Scanner(System.in);

        int input = 0;
        do{
            System.out.println("MP3 Player");
            System.out.println("---------------------------------");
            System.out.println("Menu: ");
            System.out.println("1  play Playlist");
            System.out.println("2  shuffle and play Playlist");
            System.out.println("3  show Playlist and play specific song");
            System.out.println("0  exit");
            System.out.print("Command: ");
            String inputString = scan.nextLine();

            try{
                input = Integer.parseInt(inputString);
                manager.checkMenuChoice(input);
            }catch(NumberFormatException e){
                System.err.println("You entered a wrong command");
            }catch(WrongCommandException e){
                System.err.println(e.getMessage());
            }
        }while(input != 0);




    }
}
