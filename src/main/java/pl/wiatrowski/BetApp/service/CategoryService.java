package pl.wiatrowski.BetApp.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wiatrowski.BetApp.dto.CategoryDto;
import pl.wiatrowski.BetApp.exeptions.SpringRedditException;
import pl.wiatrowski.BetApp.mapper.CategoryMapper;
import pl.wiatrowski.BetApp.model.Category;
import pl.wiatrowski.BetApp.repository.CategoryRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Transactional
    public CategoryDto save(CategoryDto categoryDto){
        Category save = categoryRepository.save(categoryMapper.mapDtoToCategory(categoryDto));
        categoryDto.setId(save.getId());
        return categoryDto;
    }


    @Transactional(readOnly = true)
    public List<CategoryDto> getAll() {
       return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::mapCategoryToDto)
                .collect(toList());
    }


    public CategoryDto getCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new SpringRedditException("No category"));
            return categoryMapper.mapCategoryToDto(category);
    }
}
