package pl.wiatrowski.BetApp.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.wiatrowski.BetApp.dto.PostRequest;
import pl.wiatrowski.BetApp.dto.PostResponse;
import pl.wiatrowski.BetApp.exeptions.PostNotFoundException;
import pl.wiatrowski.BetApp.exeptions.CategoryNotFoundException;
import pl.wiatrowski.BetApp.mapper.PostMapper;
import pl.wiatrowski.BetApp.model.Category;
import pl.wiatrowski.BetApp.model.Post;
import pl.wiatrowski.BetApp.model.User;
import pl.wiatrowski.BetApp.repository.PostRepository;
import pl.wiatrowski.BetApp.repository.CategoryRepository;
import pl.wiatrowski.BetApp.repository.UserRepository;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final PostMapper postMapper;


    public void save(PostRequest postRequest) {
        Category category = categoryRepository.findByName(postRequest.getCategoryName())
                .orElseThrow(() -> new CategoryNotFoundException(postRequest.getCategoryName()));
        postRepository.save(postMapper.map(postRequest, category, authService.getCurrentUser()));
    }

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id.toString()));
        return postMapper.mapToDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }



    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId.toString()));
        List<Post> posts = postRepository.findAllByCategory(category);
        return posts.stream().map(postMapper::mapToDto).collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return postRepository.findByUser(user)
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }
}
