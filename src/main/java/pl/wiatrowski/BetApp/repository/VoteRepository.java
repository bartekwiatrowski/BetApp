package pl.wiatrowski.BetApp.repository;


import pl.wiatrowski.BetApp.model.User;
import pl.wiatrowski.BetApp.model.Vote;
import pl.wiatrowski.BetApp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

}
