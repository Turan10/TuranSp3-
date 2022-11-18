import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Menu {


    static String fileName = "Data/ListOfMovies.txt";
    static String seriesFileName = "Data/ListOfSeries.txt";


    static BufferedReader reader;

    static {
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static BufferedReader readSeries;

    static {
        try {
            readSeries = new BufferedReader(new FileReader(seriesFileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static FileIO fio = new FileIO();
    static List<Movie> movies;

    static {
        try {
            movies = fio.getMoviesFromFile(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static List<Series> series;

    static {
        try {
            series = fio.getSeriesFromFile(readSeries);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void login() throws IOException {
        System.out.println("1.Ny bruger: \n2.Eksisterende brugere");
        Scanner loginscan = new Scanner(System.in);


        switch (loginscan.nextLine()) {
            case "1":
                User.UserCreation();
                System.out.println("Log nu ind med din ny-oprettede bruger");
                User.userlogin();
                break;


            case "2":
                User.userlogin();
                break;
            default:
                System.out.println("ugyldigt valg");
                break;

        }

    }


    public static void runProgram() throws IOException {

        while (true) {
            System.out.println("Hvad kunne du tænke dig?\n 1. Se en liste over alle film.\n 2. Se en liste over alle serier.\n 3. Se gemte film og serier.\n 4.Søg");
            Scanner choice = new Scanner(System.in);


            switch (choice.nextLine()) {
                case "1":


                    for (Movie m : movies) {
                        System.out.println(m.toString());

                    }
                    break;

                case "2":


                    for (Series s : series) {
                        System.out.println(s.toString());
                    }
                    break;

                case "3":
                    System.out.println("Søger du en liste over gemte film eller sete?");
                    switch (choice.nextLine()) {
                        case "gemte film":
                            File file = new File("/Users/turan/Documents/GitHub/SP3/Data/SavedMovieList.txt");
                            //FileInputStream - allows us to read bytes from a file - one byte at a time
                            FileInputStream readFile = new FileInputStream(file);

                            int oneByte;
                            //We can write to System.out 'onebyte' at a time using its write() method.
                            //FileInputStream returns -1 when it reaches the end of the file.
                            while ((oneByte = readFile.read()) != -1) {
                                System.out.print((char) oneByte);
                            }
                            System.out.flush();
                    }
                    break;

                case "4":
                    System.out.println("søger du efter film, eller serie?");

                    switch (choice.nextLine()) {
                        case "film":
                            System.out.println("Hvilken film leder du efter?");
                            String movieSearch = choice.nextLine();

                            boolean found = false;

                            for (Movie m : movies) {
                                if (m.getName().toLowerCase().contains(movieSearch.toLowerCase())) {
                                    System.out.println(m.toString());
                                    found = true;
                                }

                            }
                            if (!found) {
                                System.out.println("Denne film findes ikke i vores bibliotek");
                                break;
                            }


                            break;

                        case "serie":
                            System.out.println("Hvilken serie leder du efter");
                            String seriesSearch = choice.nextLine();
                            found = false;

                            for (Series s : series) {
                                if (s.getName().toLowerCase().contains(seriesSearch.toLowerCase())) {
                                    System.out.println(s.toString());
                                    found = true;
                                }
                            }
                            if (!found) {
                                System.out.println("Denne film findes ikke i vores bibliotek");
                                break;
                            }


                    }


            }
        }
    }
}

