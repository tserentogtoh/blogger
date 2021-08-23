/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author tseke
 */

@Entity
public class News {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long newsId;
    
    private Long userId;
    private String title;
    private String body;
    private String state;
    private String rComment;
    private String imgUrl;
    
    
    public News() {
    }

    
    public News(Long newsId, Long userId, String title, String body, String state, String rComment) {
        this.newsId = newsId;
        this.userId = userId;
        this.title = title;
        this.body = body;
        this.state = state;
        this.rComment = rComment;
    } 
 
    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getrComment() {
        return rComment;
    }

    public void setrComment(String rComment) {
        this.rComment = rComment;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    
    
    
}
