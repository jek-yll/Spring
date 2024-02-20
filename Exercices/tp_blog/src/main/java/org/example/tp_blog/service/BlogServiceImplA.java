package org.example.tp_blog.service;

import org.example.tp_blog.dao.ICommentRepository;
import org.example.tp_blog.dao.IPostRepository;
import org.example.tp_blog.mapper.ICommentMapper;
import org.example.tp_blog.mapper.IPostMapper;
import org.example.tp_blog.model.Comment;
import org.example.tp_blog.model.Post;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BlogServiceImplA implements IBlogService{

    private final ICommentRepository commentRepository;
    private final IPostRepository postRepository;
    private final ICommentMapper commentMapper;
    private final IPostMapper postMapper;

    public BlogServiceImplA(ICommentRepository commentRepository, IPostRepository postRepository, ICommentMapper commentMapper, IPostMapper postMapper) {

        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.commentMapper = commentMapper;
        this.postMapper = postMapper;
    }


    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post getPostById(UUID id) {
        Optional<Post> result = postRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Boolean deletePost(UUID id) {
        Boolean result = false;
        if (getPostById(id) == null){

        } else {
            postRepository.deleteById(id);
            result = true;
        };
        return result;
    }

    @Override
    public Boolean editPost(UUID id, Post updatedPost) {
        Boolean result = false;
        if (getPostById(id) == null){

        } else {
            postRepository.save(updatedPost);
            result = true;
        }
        return result;
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Boolean deleteComment(UUID id) {
        postRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Comment> getAllCommentsByPost(UUID id) {
        Post post = getPostById(id);
        return null;
    }

    @Override
    public List<Post> searchPost(String search) {
        return null;
    }
}
