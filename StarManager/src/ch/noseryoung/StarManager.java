package ch.noseryoung;

import java.util.ArrayList;
import java.util.Comparator;

public class StarManager {
    private static StarManager instance;
    private static ArrayList<Star> starList;

    private StarManager() {}

    public static StarManager getInstance(){
        if(instance == null && starList == null){
            starList = new ArrayList<Star>();
            instance = new StarManager();
        }
        return instance;
    }

    public void addStar(Star star) {
        starList.add(star);
    }

    public void removeStar(int index) {
        starList.remove(starList.get(index));
    }

    public void printStars() throws StarListEmptyException{
        if(checkStarListEmpty()){
            System.out.println("Star List:\n----------------------");
            starList.sort(Comparator.comparing(Star::getSecondName));
            for (int i = 0; i < starList.size(); i++){
                System.out.println(i+1 + "   " + starList.get(i).toString());
            }
        }else{
            throw new StarListEmptyException("You haven't registered any Stars yet");
        }
    }

    public void sortByMovie(String movie) throws MovieDoesNotExistException{
        System.out.println("\nAll Actors of " + movie + "\n--------------------------------------" );
        int amtMovies = 0;
        for (int i = 0; i < starList.size(); i++) {
            if(starList.get(i).getLastFilm().equalsIgnoreCase(movie)){
                System.out.println(starList.get(i).toString());
                amtMovies++;
            }
            if (amtMovies == 0){
                throw new MovieDoesNotExistException("There is no actor in your List that starred in " + movie);
            }
        }
    }

    public boolean checkStarListEmpty(){
        if(starList.size() == 0){
            return false;
        }else{
            return true;
        }
    }

    public boolean checkStarListFull(){
        if(starList.size() == 3){
            return false;
        }else{
            return true;
        }
    }
}
