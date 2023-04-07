package org.example;
import kong.unirest.*;
import org.json.*;

public class Main {
    public static void main(String[] args)
    {

        HttpResponse<String> response = Unirest.get("https://imdb-top-100-movies.p.rapidapi.com/")
                .header("X-RapidAPI-Key", "a0f1259ff8msh4cb3a6d7bde6ed4p1a06aejsn40d58805d75f")
                .header("X-RapidAPI-Host", "imdb-top-100-movies.p.rapidapi.com")
                .asString();


        String jsonResponse = response.getBody();

        JSONArray movies = new JSONArray(jsonResponse);

        /*JSONObject movie = movies.getJSONObject(0);

        int rank = movie.getInt("rank");
        String title = movie.getString("title");
        String thumbnail = movie.getString("thumbnail");
        String rating = movie.getString("rating");
        String id = movie.getString("id");
        int year = movie.getInt("year");
        String image = movie.getString("image");*/

        for(int i = 0; i < 10; i++)
        {
            JSONObject movie = movies.getJSONObject(i);
            String title = movie.getString("title");
            System.out.println("Rank "+(i+1)+": "+title);
        }

    }

}