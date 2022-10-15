package com.pbs.dental.service;

import com.pbs.dental.repository.BlogPostRepository;
import com.pbs.dental.model.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogPostServiceImpl implements BlogPostService {

    private BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostServiceImpl(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @Override
    public BlogPost setBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    @Override
    public Optional<BlogPost> getBlogPost(Long blogPostId) {
        return blogPostRepository.findById(blogPostId);
    }

    @Override
    public List<BlogPost> getBlogPosts() {
        return blogPostRepository.findAll();
    }

    @Override
    public void deleteBlogPost(Long blogPostId) {
        blogPostRepository.deleteById(blogPostId);
    }
}
