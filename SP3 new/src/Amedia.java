public abstract class Amedia implements Media{
    private String name;
    private int year;
    private String genre;
    private double rating;

    public Amedia(String name, int year, String genre, double rating) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    public Amedia(){
        name = "";
        year = 0;
        genre = "";
        rating = 0;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    @Override
    public String toString(){
        return "Name:" + " " + this.name + "| " + "Year:" + this.year + "|" + "Genre:" + " " + this.genre + "|" +  "Rating:" + " " + this.rating;
    }




}
