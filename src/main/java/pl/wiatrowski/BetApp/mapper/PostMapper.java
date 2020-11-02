package pl.wiatrowski.BetApp.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import pl.wiatrowski.BetApp.dto.PostRequest;
import pl.wiatrowski.BetApp.dto.PostResponse;
import pl.wiatrowski.BetApp.model.Post;
import pl.wiatrowski.BetApp.model.Subreddit;
import pl.wiatrowski.BetApp.model.User;
import pl.wiatrowski.BetApp.repository.CommentRepository;
import pl.wiatrowski.BetApp.service.AuthService;

@Mapper(componentModel = "spring")
public interface PostMapper {


    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "subreddit", source = "subreddit")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "description", source = "postRequest.description")
    Post map(PostRequest postRequest, Subreddit subreddit, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "postName", source = "postName")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "url", source = "url")
    @Mapping(target = "subredditName", source = "subreddit.name")
    @Mapping(target = "userName", source = "user.username")
    PostResponse mapToDto(Post post);
}
