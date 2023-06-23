package ticket;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SessionRepository {

    private final JdbcTemplate jdbcTemplate;

    public SessionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveSession(String sessionId, String username) {
        jdbcTemplate.update("INSERT INTO sessions (id, username) VALUES (?, ?)", sessionId, username);
    }

    public String getUsernameBySessionId(String sessionId) {
        return jdbcTemplate.queryForObject("SELECT username FROM sessions WHERE id = ?", new Object[]{sessionId}, String.class);
    }

    public void deleteSession(String sessionId) {
        jdbcTemplate.update("DELETE FROM sessions WHERE id = ?", sessionId);
    }
}