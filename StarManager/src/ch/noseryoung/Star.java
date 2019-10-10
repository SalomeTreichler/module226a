package ch.noseryoung;

public class Star {
    private String firstName;
    private String secondName;
    private String lastFilm;

    public Star(String firstName, String secondName, String lastFilm) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastFilm = lastFilm;
    }

    @Override
    public String toString() {
        return firstName + " " + secondName + ", Last Film: " + lastFilm;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastFilm() {
        return lastFilm;
    }
}
