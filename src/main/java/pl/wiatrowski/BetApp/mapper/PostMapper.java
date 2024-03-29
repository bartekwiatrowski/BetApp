package pl.wiatrowski.BetApp.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.wiatrowski.BetApp.dto.PostRequest;
import pl.wiatrowski.BetApp.dto.PostResponse;
import pl.wiatrowski.BetApp.model.Category;
import pl.wiatrowski.BetApp.model.Post;
import pl.wiatrowski.BetApp.model.User;


@Mapper(componentModel = "spring")
public abstract interface PostMapper {



    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "description", source = "postRequest.description")

    public abstract Post map(PostRequest postRequest, Category category, User user);
    // Post map(PostRequest postRequest, Category category, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "postName", source = "postName")

    @Mapping(target = "url", source = "url")
    @Mapping(target = "description", source = "description")

    @Mapping(target = "userName", source = "user.username")
    @Mapping(target = "categoryName", source = "category.name")

    //PostResponse mapToDto(Post post);
    public abstract PostResponse mapToDto(Post post);
}
