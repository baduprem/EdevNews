package com.example.designmodal.edevnews.Model;

/**
 * Created by compware on 6/17/2018.
 */

public class NewsModel
{
    private String news_id,news_date,news_detail,news_title,news_image,news_video,news_imp,page_views;

    public NewsModel(String image_name,String news_id, String news_date, String news_detail, String news_title,
                     String news_image, String news_video, String news_imp, String page_views) {
        this.news_id = news_id;
        this.news_date = news_date;
        this.news_detail = news_detail;
        this.news_title = news_title;
        this.news_image = news_image;
        this.news_video = news_video;
        this.news_imp = news_imp;
        this.page_views = page_views;
    }

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

    public String getNews_date() {
        return news_date;
    }

    public void setNews_date(String news_date) {
        this.news_date = news_date;
    }

    public String getNews_detail() {
        return news_detail;
    }

    public void setNews_detail(String news_detail) {
        this.news_detail = news_detail;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_image() {
        return news_image;
    }

    public void setNews_image(String news_image) {
        this.news_image = news_image;
    }

    public String getNews_video() {
        return news_video;
    }

    public void setNews_video(String news_video) {
        this.news_video = news_video;
    }

    public String getNews_imp() {
        return news_imp;
    }

    public void setNews_imp(String news_imp) {
        this.news_imp = news_imp;
    }

    public String getPage_views() {
        return page_views;
    }

    public void setPage_views(String page_views) {
        this.page_views = page_views;
    }
}
