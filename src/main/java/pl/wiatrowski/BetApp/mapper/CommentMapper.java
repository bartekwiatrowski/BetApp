package pl.wiatrowski.BetApp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.wiatrowski.BetApp.dto.CommentsDto;
import pl.wiatrowski.BetApp.model.Comment;
import pl.wiatrowski.BetApp.model.Post;
import pl.wiatrowski.BetApp.model.User;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "text", source = "commentsDto.text")
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "post", source = "post")
    @Mapping(target = "user", source = "user")
    Comment map(CommentsDto commentsDto, Post post, User user);

    @Mapping(target = "postId", expression = "java(comment.getPost().getPostId())")
    @Mapping(target = "userName", expression = "java(comment.getUser().getUsername())")
    CommentsDto mapToDto(Comment comment);
}