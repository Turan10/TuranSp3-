import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/turan/Documents/GitHub/SP3/Data/ListOfMovies.txt";

        // Få nyt fil på bufferedReader så den også kan læse serieliste


        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        FileIO fio = new FileIO();


        boolean stopProgram = false;

        User user = new User("Turan", "Password");


        while (!stopProgram) {
            System.out.println("Velkommen" + " " + user.getUserName());
            System.out.println("Hvad kunne du tænke dig?\n 1. Se en liste over alle film.\n 2. Se en liste over alle serier.\n 3. Se gemte film og serier.\n 4.Søg");
            Scanner choice = new Scanner(System.in);

            List<Movie> movies = fio.getMoviesFromFile(reader);
            List<Series> serie = fio.getSeriesFromFile(reader);




            switch (choice.nextLine()) {
                case "1":


                    for (Movie m : movies) {
                        System.out.println(m.toString());

                    }
                    break;

                case "2":

                    for(Series s : serie){
                        System.out.println(s.toString());
                    }
                    break;

                case "4":
                    System.out.println("søger du efter film, eller serie?");

                    switch (choice.nextLine()) {
                        case "film":
                            System.out.println("Hvilken film leder du efter?");
                            String search = choice.nextLine();

                            for (Movie m : movies) {
                                if (m.getName().toLowerCase().contains(search.toLowerCase())) {
                                    System.out.println(m.toString());
                                }

                            }
                            System.out.println("Denne film findes ikke i vores bibliotek");
                            break;

                        case "serie":
                            System.out.println("Hvilken serie leder du efter");
                            String seriesChoice = choice.nextLine();

                            for(Series s : serie){
                                if(s.getName().toLowerCase().contains(seriesChoice.toLowerCase())){
                                    System.out.println(s.toString());
                                }
                            }



                    }




            }

        }
    }
}




