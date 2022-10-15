package com.pbs.dental.controller;

import com.pbs.dental.Service.BlogPostService;
import com.pbs.dental.model.BlogPost;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class BlogPostController {

    private BlogPostService blogPostService;

    @Autowired
    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping(path = "/blogPost/all")
    List<BlogPost> getAllBlogPosts() {
        return blogPostService.getBlogPosts();
    }

    @GetMapping(path = "/blogPost/{blogPostId}")
    ResponseEntity<BlogPost> getBlogPost(@PathVariable Long blogPostId) {
        return ResponseEntity.of(blogPostService.getBlogPost(blogPostId));
    }

    @PostMapping(path = "/blogPost/addBlogPost")
    ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost) {
        BlogPost createdBlogPost = blogPostService.setBlogPost(blogPost);
        return new ResponseEntity<>(createdBlogPost, HttpStatus.OK);
    }

    @DeleteMapping(path = "/blogPost/{blogPostId}")
    ResponseEntity<BlogPost> deleteBlogPost(@PathVariable Long blogPostId) {
        return blogPostService.getBlogPost(blogPostId).map(p -> {
            blogPostService.deleteBlogPost(blogPostId);
            return new ResponseEntity<BlogPost>(HttpStatus.OK);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/blogPost/{blogPostId}")
    ResponseEntity<BlogPost> updateBlogPost(@RequestBody BlogPost blogPost) {
        BlogPost updatedBlogPost = blogPostService.setBlogPost(blogPost);
        return new ResponseEntity<>(updatedBlogPost, HttpStatus.OK);
    }
}
