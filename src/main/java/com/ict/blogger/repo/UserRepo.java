/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.repo;

import com.ict.blogger.entities.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author tseke
 */
@Repository
public interface UserRepo extends CrudRepository <User, Long> {
    List<User> findAll();
}
