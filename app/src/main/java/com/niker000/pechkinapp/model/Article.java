package com.niker000.pechkinapp.model;

public class Article  {
    private Source source;
    private String title;
    private String description;
    private String url;
    private String content;

    public Article(Source source, String title, String description, String url, String content) {
        this.source = source;
        this.title = title;
        this.description = description;
        this.url = url;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
