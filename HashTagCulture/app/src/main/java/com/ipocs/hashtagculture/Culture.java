package com.ipocs.hashtagculture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dong on 2015-12-01.
 */
public class Culture {

    String title;
    String imgSumnailUrl;
    String startDate;
    String endDate;
    ArrayList<String> hashTag;
    boolean bookMark;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgSumnailUrl() {
        return imgSumnailUrl;
    }

    public void setImgSumnailUrl(String imgSumnailUrl) {
        this.imgSumnailUrl = imgSumnailUrl;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public ArrayList<String> getHashTag() {
        return hashTag;
    }

    public void setHashTag(ArrayList<String> hashTag) {
        this.hashTag = hashTag;
    }

    public boolean isBookMark() {
        return bookMark;
    }

    public void setBookMark(boolean bookMark) {
        this.bookMark = bookMark;
    }

    public Culture() {
    }

    public Culture(String title, String imgSumnailUrl, String startDate, String endDate, ArrayList<String> hashTag, boolean bookMark) {
        this.title = title;
        this.imgSumnailUrl = imgSumnailUrl;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hashTag = hashTag;
        this.bookMark = bookMark;
    }
}
