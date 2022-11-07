public class Series extends Amedia{

String season;
String episode;
    public Series(String name, int yearOfReleaseMedia, String genreMedia, double rating, String season, String episode) {
        super(name, yearOfReleaseMedia, genreMedia, rating);
        this.season = season;
        this.episode = episode;
    }

    public Series(){

    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }
}

