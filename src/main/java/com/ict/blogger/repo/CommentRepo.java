/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.repo;

import com.ict.blogger.entities.Comment;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tseke
 */
@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {
    
//    @Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?0", nativeQuery = true)
//    User findByemailUser(String email);
    
    List<Comment> findByNewsId(Long newsId);
 
}
