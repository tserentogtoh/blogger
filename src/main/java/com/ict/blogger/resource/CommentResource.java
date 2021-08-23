/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.resource;

import com.ict.blogger.logic.CommentLogic;
import com.ict.blogger.dto.CommentDTO;
import com.ict.blogger.dto.ResponseDTO;
import com.ict.blogger.entities.Comment;
import com.ict.blogger.repo.CommentRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tseke
 */
@RestController
@Api(description = "Comment", tags = "Comment")
@RequestMapping("/comment")
public class CommentResource {

    @Autowired
    private CommentRepo repo;

    @Autowired
    private CommentLogic logic;

    @PostMapping("/")
    @ApiOperation("comment bichih")
    public ResponseDTO Write(@RequestBody CommentDTO dTO, Principal principal, HttpServletRequest request) {
        return logic.wComm(dTO, principal, request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("comment id gaar ustgah")
    public String delComm(@PathVariable Long id) {
        repo.deleteById(id);
        return "amjilttai";
    }

    @GetMapping("/{newsId}")
    @ApiOperation("tuhain medeen deer bichigsen buh commentiig harah")
    public List<Comment> getComm(@PathVariable Long newsId) {
        return logic.getComm(newsId);
    }

}
