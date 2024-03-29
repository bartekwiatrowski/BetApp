package pl.wiatrowski.BetApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wiatrowski.BetApp.model.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    void deleteByToken(String token);
}