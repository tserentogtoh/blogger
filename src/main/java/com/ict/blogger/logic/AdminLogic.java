/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.logic;

import com.ict.blogger.dto.ChangeStateDTO;
import com.ict.blogger.dto.ResponseDTO;
import com.ict.blogger.entities.News;
import com.ict.blogger.repo.NewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tseke
 */
@Service
public class AdminLogic {
    
    @Autowired
    NewsRepo repo;
    
    public ResponseDTO changeState(Long id, ChangeStateDTO dTO){
        try{
            News news = repo.findById(id).get();
            news.setState(dTO.getState());
            repo.save(news);
            return ResponseDTO.getInstance(true);
        }catch(Exception e){
            return ResponseDTO.getInstance(false, e.getMessage());
        }   
    }    
}
//        fail 
//        success