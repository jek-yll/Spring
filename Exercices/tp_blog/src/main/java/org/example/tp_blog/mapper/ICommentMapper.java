package org.example.tp_blog.mapper;


import org.example.tp_blog.dto.CommentDTO;
import org.example.tp_blog.model.Comment;
import org.example.tp_blog.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ICommentMapper {


    //@Mapping(source = "post", target = "postId", qualifiedByName = "convertPostToPostId")
    CommentDTO commentToCommentDto(Comment comment);

    Comment commentDtoToComment(CommentDTO commentDto);

    @Named("convertPostToPostId")
    public static UUID convertPostToPostId(Post post){
        return post.getId();
    }

}
