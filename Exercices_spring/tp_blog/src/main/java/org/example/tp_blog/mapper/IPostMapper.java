package org.example.tp_blog.mapper;


import org.example.tp_blog.dto.PostDTO;
import org.example.tp_blog.model.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPostMapper {

    PostDTO postToPostDto(Post post);

    Post PostDtoToPost(PostDTO postDto);
}
