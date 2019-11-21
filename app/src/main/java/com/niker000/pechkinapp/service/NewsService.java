package com.niker000.pechkinapp.service;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.niker000.pechkinapp.model.DTO.ResponseNewsDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NewsService extends AsyncTask<String, Void, ResponseNewsDTO> {
    private final static String NEWS_URL = "https://newsapi.org/v2/top-headlines?country";
    private final static String API_KEY = "&apiKey=dc785648972f4f8db12e3c4b17c725ed";

    @Override
    public ResponseNewsDTO doInBackground(String... strings) {
        ResponseNewsDTO responseNewsDTO = null;
        try {
            URL url = new URL(NEWS_URL + strings[0] + API_KEY);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            Gson gson = new Gson();
            responseNewsDTO = gson.fromJson(content.toString(), ResponseNewsDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return responseNewsDTO;
    }
}
