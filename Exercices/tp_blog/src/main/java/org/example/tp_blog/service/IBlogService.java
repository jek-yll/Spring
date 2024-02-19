package org.example.tp_blog.service;

import org.example.tp_blog.model.Comment;
import org.example.tp_blog.model.Post;

import java.util.List;
import java.util.UUID;

public interface IBlogService {

    public Post addPost(Post post);
    public Post getPostById(UUID id);
    public List<Post> getAllPosts();
    public List<Post> searchPost(String search);
    public Boolean deletePost(UUID id);
    public Boolean editPost(UUID id, Post updatedPost);
    public Comment addComment(Comment comment);
    public Boolean deleteComment(UUID id);
    public List<Comment> getAllCommentsByPost(UUID id);


}
