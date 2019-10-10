package ch.noseryoung;

import java.util.Scanner;

public class InputHandler {
    private static InputHandler instance;
    StarManager starManager = StarManager.getInstance();
    Scanner scan = new Scanner(System.in);

    private InputHandler() {
    }

    public static InputHandler getInstance() {
        if (instance == null) {
            instance = new InputHandler();
        }
        return instance;
    }

    public void createStar() throws StarListFullException{
        if(starManager.checkStarListFull()){
            System.out.println("Please enter the informations for a new Star:");
            System.out.print("Firste Name:  ");
            String firstName = scan.nextLine();
            System.out.print("Second Name:  ");
            String secondName = scan.nextLine();
            System.out.print("Last movie:   ");
            String lastFilm = scan.nextLine();

            Star star = new Star(firstName, secondName, lastFilm);
            starManager.addStar(star);
        }else{
            throw new StarListFullException("You can't add another Star, the List is full");
        }
    }

    public void removeStar() throws StarListEmptyException {
        if (starManager.checkStarListEmpty()) {
            starManager.printStars();
            System.out.print("Index of Star to remove: ");
            String indexString = scan.nextLine();
            int index;
            try {
                index = Integer.parseInt(indexString);
                starManager.removeStar(index - 1);
            } catch (NumberFormatException e) {
                System.err.println("You haven't entered an index");
            } catch (IndexOutOfBoundsException e) {
                System.err.println("There is no Star with this Index");
            }
        } else {
            throw new StarListEmptyException("You haven't added any Stars yet");
        }
    }

    public void printStarsByMovie() {
        System.out.print("Please enter movie title: ");
        String movie = scan.nextLine();
        try {
            starManager.sortByMovie(movie);
        } catch (MovieDoesNotExistException e) {
            System.err.println(e.getMessage());
        }
    }

    public void printAllStars() {
        try{
            starManager.printStars();
        }catch(StarListEmptyException e){
            System.err.println(e.getMessage());
        }
    }
}
