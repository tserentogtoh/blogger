/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.repo;

import com.ict.blogger.entities.News;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tseke
 */
@Repository
public interface NewsRepo extends CrudRepository <News, Long>{
    
 
        
}
