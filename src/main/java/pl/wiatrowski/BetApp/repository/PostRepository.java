package pl.wiatrowski.BetApp.repository;

import pl.wiatrowski.BetApp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wiatrowski.BetApp.model.Category;
import pl.wiatrowski.BetApp.model.User;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByCategory(Category category);

    List<Post> findByUser(User user);
}