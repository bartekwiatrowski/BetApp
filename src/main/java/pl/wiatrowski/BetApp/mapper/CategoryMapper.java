package pl.wiatrowski.BetApp.mapper;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.wiatrowski.BetApp.dto.CategoryDto;
import pl.wiatrowski.BetApp.model.Category;
import pl.wiatrowski.BetApp.model.Post;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(category.getPosts()))")
    CategoryDto mapCategoryToDto(Category category);

    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Category mapDtoToCategory(CategoryDto categoryDto);
}
