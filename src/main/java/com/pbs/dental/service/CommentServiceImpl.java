package com.pbs.dental.service;

import com.pbs.dental.repository.CommentRepository;
import com.pbs.dental.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment setComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Optional<Comment> getComment(Long commentId) {
        return commentRepository.findById(commentId);
    }

    @Override
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
