/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.logic;

import com.ict.blogger.entities.Comment;
import com.ict.blogger.dto.CommentDTO;
import com.ict.blogger.dto.ResponseDTO;
import com.ict.blogger.repo.CommentRepo;
import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tseke
 */
@Service
public class CommentLogic {

    @Autowired
    private CommentRepo repo;

    public ResponseDTO wComm(CommentDTO dTO, Principal principal, HttpServletRequest request) {
        try {
            Comment comment = new Comment();
            comment.setBody(dTO.getBody());
            comment.setNewsId(dTO.getNewsId());
            comment.setIp(GetIP.getRequestIP(request));
            comment.setUserId(Extract.extractUserId(principal));
            repo.save(comment);
            return ResponseDTO.getInstance(true);
        } catch (Exception e) {
            return ResponseDTO.getInstance(false, e.getMessage());
        }
    }

    public List<Comment> getComm(Long newsId) {
        return repo.findByNewsId(newsId);
    }
}
