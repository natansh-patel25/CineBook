public class Movie {

    private String movieId;
    private String title;
    private String language;
    private String genre;
    private int duration;

    public Movie(String movieId, String title, String language, String genre, int duration) {
        this.movieId = movieId;
        this.title = title;
        this.language = language;
        this.genre = genre;
        this.duration = duration;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public void displayMovie() {
        System.out.println("Movie ID  : " + movieId);
        System.out.println("Title     : " + title);
        System.out.println("Language  : " + language);
        System.out.println("Genre     : " + genre);
        System.out.println("Duration  : " + duration + " minutes");
    }
}