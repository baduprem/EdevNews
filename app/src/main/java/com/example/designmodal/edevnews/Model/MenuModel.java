package com.example.designmodal.edevnews.Model;

/**
 * Created by compware on 6/15/2018.
 */

public class MenuModel
{
    private String category_id;
    private String category_title;
    private String news_id;

    public MenuModel(String news_id,String category_id, String category_title)
    {
        this.category_id = category_id;
        this.category_title = category_title;
        this.news_id = news_id;
    }

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory_title() {
        return category_title;
    }

    public void setCategory_title(String category_title) {
        this.category_title = category_title;
    }
}


