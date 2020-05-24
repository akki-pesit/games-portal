package com.personal.gamesportal.service;

import com.google.gson.Gson;
import com.personal.gamesportal.model.DevelopersListResponse;
import com.personal.gamesportal.model.GameDeveloper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GamePortalService {
  private Gson gson = new Gson();

  public DevelopersListResponse getDevelopersListResponse (String xRapidAPIHost, String xRapidAPIKey)
      throws IOException {
    OkHttpClient client = new OkHttpClient();

    Request request =
        new Request.Builder()
            .url("https://rawg-video-games-database.p.rapidapi.com/developers")
            .get()
            .addHeader("x-rapidapi-host", "rawg-video-games-database.p.rapidapi.com")
            .addHeader("x-rapidapi-key", "e07e943b44msh8b0b1053db4f03cp131344jsn9a635ce78a38")
            .build();
    ResponseBody responseBody = client.newCall(request).execute().body();

    DevelopersListResponse developersListResponse =
        gson.fromJson(responseBody.string(), DevelopersListResponse.class);
    return developersListResponse;
  }

  public GameDeveloper getGameDeveloperById(
      String id, String xRapidAPIHost, String xRapidAPIKey) throws IOException {
    OkHttpClient client = new OkHttpClient();

    Request request =
        new Request.Builder()
            .url("https://rawg-video-games-database.p.rapidapi.com/developers/" + id)
            .get()
            .addHeader("x-rapidapi-host", "rawg-video-games-database.p.rapidapi.com")
            .addHeader("x-rapidapi-key", "e07e943b44msh8b0b1053db4f03cp131344jsn9a635ce78a38")
            .build();

    ResponseBody responseBody = client.newCall(request).execute().body();
    GameDeveloper gameDeveloper = gson.fromJson(responseBody.string(), GameDeveloper.class);
    return gameDeveloper;
  }
}
