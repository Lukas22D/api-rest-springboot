package app.web_api;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import app.web_api.model.Usuario;
import app.web_api.repository.UserRepository;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BancoDadosTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testarBancoDados() {
        Usuario usuario = new Usuario();
        usuario.setLogin("admin");
        usuario.setPassword("admin");
        userRepository.save(usuario);
        System.out.println("Usuário salvo com sucesso!");
    }

    @Test
    public void testarBuscarUsuario() {
        Usuario usuario = userRepository.findByLogin("admin");
        System.out.println("Usuário encontrado: " + usuario);
    }


    
}
