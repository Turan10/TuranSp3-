package net.codejava;

import com.google.protobuf.compiler.PluginProtos;

import java.io.*;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.sql.Types;
import java.util.Date;
import java.sql.*;
import java.util.*;
public class MovieDB {


    private Connection connection;

    private String url = "jdbc:mysql://localhost:3306/MovieList";
    private String username = "root";
    private String password = "Tingbjerg1!";
    File file = new File("Data/ListOfSeries.txt");
    int listSize = 100;
    String listName = "dbo.SeriesList";

    private void establishConnection()
    {
        // connection
        try
        {
            connection = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    public void run(){

    establishConnection();

    try{

        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        StringBuffer sb = new StringBuffer();
        String line;

        while((line = br.readLine())!= null){
            sb.append(line);
            sb.append("\n");
        }
        fileReader.close();

        try ( InputStream inputStream = new ByteArrayInputStream(sb.toString().getBytes(StandardCharsets.UTF_8))){
            System.out.println("file to be copied to" + listName );

          SQL fileRecord = new SQLS

        }


    }catch (Exception e){
        System.out.println("File does not exist");

    }




    }



}