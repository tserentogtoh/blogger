/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.logic;

import com.ict.blogger.entities.News;
import com.ict.blogger.dto.NewsDTO;
import com.ict.blogger.dto.ResponseDTO;
import com.ict.blogger.repo.NewsRepo;
import com.ict.blogger.repo.NewsRepository;
import java.io.File;
import java.math.BigInteger;
import java.security.Principal;
import java.util.Base64;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tseke
 */

@Service
public class NewsLogic {
    
    @Autowired
    public NewsRepo repo;
    @Autowired
    public NewsRepository repository;
    @Autowired
    public IdGenerator idG;
    
    public ResponseDTO newsAdd(NewsDTO dTO,  Principal principal){
        
        try{
            News news = new News();
        
            Long extractUserId = Extract.extractUserId(principal);
            idG.userId();
            
            byte[] decodedBytes = Base64.getDecoder().decode(dTO.getImgUrl());
            String path = "C:\\Users\\tseke\\OneDrive\\Desktop\\test app\\blogger\\photo"+ idG.userId() +".jpg";
//            String path = "home\\ubuntu\\photo"+ idG.userId() +".jpg";
            FileUtils.writeByteArrayToFile(new File(path), decodedBytes);

            news.setTitle(dTO.getTitle());
            news.setBody(dTO.getBody());
            news.setUserId(extractUserId);
            news.setImgUrl(path);
            news.setState("EXPECTED");
            repo.save(news);

            return ResponseDTO.getInstance(true);
        }catch(Exception e){
            return ResponseDTO.getInstance(false, e.getMessage());
        }
    }
    
    public BigInteger stateCnt(String state){
        
        return repository.getStateCnt(state);
    }
    
    public List<News> getState(String state){
        
        return repository.getState(state);
    }
    
}
