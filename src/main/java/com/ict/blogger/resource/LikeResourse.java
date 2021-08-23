/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.resource;

import com.ict.blogger.dto.ResponseDTO;
import com.ict.blogger.logic.LikeLogic;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigInteger;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tseke
 */
@RestController
@Api(description = "Like", tags = "Like")
public class LikeResourse {
    
    @Autowired
    LikeLogic logic;
    
    @PostMapping("/clickLike/{id}")
    @ApiOperation("like darah")
    public ResponseDTO click(@PathVariable Long id, Principal principal, HttpServletRequest request){
        return logic.clickLike(id, principal, request);
    }
    
    @GetMapping("/countLike/{id}")
    @ApiOperation("tuhain medeenii like iig toolj butsaah")
    public BigInteger count(@PathVariable int id){
      return logic.countLike(id);
    }
}
