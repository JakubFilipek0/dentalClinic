package com.pbs.dental.service;

import com.pbs.dental.model.BlogPost;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BlogPostService {
    BlogPost setBlogPost(BlogPost blogPost);
    Optional<BlogPost> getBlogPost(Long blogPostId);
    List<BlogPost> getBlogPosts();
    void deleteBlogPost(Long blogPostId);
}
