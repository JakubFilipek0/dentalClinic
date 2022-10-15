package com.pbs.dental.controller;

import com.pbs.dental.service.CommentService;
import com.pbs.dental.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(path = "/comment/all")
    List<Comment> getAllComments() {
        return commentService.getComments();
    }

    @GetMapping(path = "/comment/{commentId}")
    ResponseEntity<Comment> getComment(@PathVariable Long commentId) {
        return ResponseEntity.of(commentService.getComment(commentId));
    }

    @PostMapping(path = "/comment/addComment")
    ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        Comment createdComment = commentService.setComment(comment);
        return new ResponseEntity<>(createdComment, HttpStatus.OK);
    }

    @DeleteMapping(path = "/comment/{commentId}")
    ResponseEntity<Comment> deleteComment(@PathVariable Long commentId) {
        return commentService.getComment(commentId).map(p -> {
            commentService.deleteComment(commentId);
            return new ResponseEntity<Comment>(HttpStatus.OK);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
