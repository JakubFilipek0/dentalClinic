package com.pbs.dental.service;

import com.pbs.dental.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CommentService {
    Comment setComment(Comment comment);
    Optional<Comment> getComment(Long commentId);
    List<Comment> getComments();
    void deleteComment(Long commentId);
}
