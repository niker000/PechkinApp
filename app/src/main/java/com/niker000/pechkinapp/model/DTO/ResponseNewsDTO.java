package com.niker000.pechkinapp.model.DTO;

import com.niker000.pechkinapp.model.Article;

import java.util.ArrayList;

public class ResponseNewsDTO {
    private String status;
    private ArrayList<Article> articles;

    public ResponseNewsDTO(String status, ArrayList<Article> articles) {
        this.status = status;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }
}
