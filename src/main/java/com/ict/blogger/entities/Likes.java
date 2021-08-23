package com.ict.blogger.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Likes {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id; 
    
    private String ip;
    private Long newsId;
    private Long userId;

    public Likes() {
    }
    
    public Likes(Long id, String ip, Long newsId, Long userId) {
        this.id = id;
        this.ip = ip;
        this.newsId = newsId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}