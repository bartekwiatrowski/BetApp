package pl.wiatrowski.BetApp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wiatrowski.BetApp.exeptions.SpringRedditException;
import pl.wiatrowski.BetApp.model.RefreshToken;
import pl.wiatrowski.BetApp.repository.RefreshTokenRepository;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class RefreshTokenService {


        private final RefreshTokenRepository refreshTokenRepository;


        public RefreshToken generateRefreshToken() {
            RefreshToken refreshToken = new RefreshToken();
            refreshToken.setToken(UUID.randomUUID().toString());
            refreshToken.setCreatedDate(Instant.now());

            return refreshTokenRepository.save(refreshToken);
        }

    void validateRefreshToken(String token) {
        refreshTokenRepository.findByToken(token)
                .orElseThrow(() -> new SpringRedditException("Invalid refresh Token"));
    }

    public void deleteRefreshToken(String token) {
        refreshTokenRepository.deleteByToken(token);
    }

}
