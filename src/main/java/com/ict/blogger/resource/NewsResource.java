/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.resource;

import com.ict.blogger.entities.News;
import com.ict.blogger.logic.Extract;
import com.ict.blogger.logic.NewsLogic;
import com.ict.blogger.dto.NewsDTO;
import com.ict.blogger.dto.ResponseDTO;
import com.ict.blogger.repo.NewsRepo;
import com.ict.blogger.repo.NewsRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tseke
 */
@RestController
@Api(description = "News", tags = "news")
public class NewsResource {

    @Autowired
    private NewsRepo repo;
    @Autowired
    private NewsRepository repository;
    @Autowired
    private NewsLogic logic;
    
    @PostMapping("/addNews")
    @ApiOperation("shine medee bichih")
    public ResponseDTO addNews(@RequestBody NewsDTO dTO, Principal principal) {
        
        return logic.newsAdd(dTO, principal);
    }

    @GetMapping("/news/all")
    @ApiOperation("buh medeeg butsaah")
    public List<News> allNews(Principal principal) {
        
        Long extractUserId = Extract.extractUserId(principal);

        try {
            return (List<News>) repo.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/news/delete/{id}")
    @ApiOperation("medeenii id gaar ustgah")
    public ResponseDTO delNews(@PathVariable Long id) {
        try {
            repo.deleteById(id);
            return ResponseDTO.getInstance(true);
        } catch (Exception e) {
            return ResponseDTO.getInstance(false, e.getMessage());
        }
    }
    
    @GetMapping("/getNews")
    
    //query zasna
    public List<News> getNews(@RequestParam String state){
        return logic.getState(state);
       
    }
}
