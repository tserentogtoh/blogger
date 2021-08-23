/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.logic;

import com.ict.blogger.dto.ResponseDTO;
import com.ict.blogger.entities.Likes;
import com.ict.blogger.repo.LikeRepo;
import com.ict.blogger.repo.LikeRepository;
import java.math.BigInteger;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tseke
 */
@Service
public class LikeLogic {
    
    @Autowired
    private LikeRepo repo;
    
    @Autowired
    private LikeRepository repository;
//    private final LikeRepository repository;
//    
//    public LikeLogic(LikeRepository likeR) {
//        this.repository = likeR;
//    }
    
    public ResponseDTO clickLike(Long id, Principal principal, HttpServletRequest request){
        try{
            Likes like = new Likes();
            like.setNewsId(id);
            Long extractUserId = Extract.extractUserId(principal);
            like.setUserId(extractUserId);
            like.setIp(GetIP.getRequestIP(request));
            repo.save(like);
            return ResponseDTO.getInstance(true);
        }catch(Exception e){
            return ResponseDTO.getInstance(true, e.getMessage());
        }
    }
    
    public BigInteger countLike(int id){
        
        return repository.getCount(id);       
    }
}
