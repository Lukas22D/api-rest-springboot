package app.web_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import app.web_api.model.Usuario;


public interface UserRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByLogin(String login);
}
