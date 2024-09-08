package app.web_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import app.web_api.repository.UserRepository;
import app.web_api.model.Usuario;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private  UserRepository userRepository;

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return userRepository.findAll();
    }
    @GetMapping("/usuarios/{id}")
    public Usuario buscarUsuario(@PathVariable("id") Integer id) {
        Usuario resposta = userRepository.findById(id).orElse(null);
        if(resposta == null) {
            throw new RuntimeException("Usuário não encontrado");
        }else {
            return resposta;
        }
    }

    @GetMapping("/usuarios/login/{login}")
    public Usuario buscarUsuarioPorLogin(@PathVariable("login") String login) {
        var user = userRepository.findByLogin(login);
        if(user == null) {
            throw new RuntimeException("Usuário não encontrado");
        }
        return user;
    }   

    @DeleteMapping("/usuarios/{id}")
    public String deletarUsuario(@PathVariable("id") Integer id) {
        Usuario usuario = userRepository.findById(id).orElse(null);
        if(usuario == null) {
            throw new RuntimeException("Usuário não encontrado");
        }
        String login = usuario.getLogin();
        userRepository.deleteById(id);
        return "Usuário " + login + " deletado com sucesso!";
        
    }

    @PostMapping("/usuarios")
    public String salvarUsuario(@RequestBody Usuario usuario) {
        Usuario Usuario = usuario;
       if(Usuario.getLogin() == null || Usuario.getPassword() == null) {
           throw new IllegalArgumentException("Login e senha são obrigatórios");
       }else{
              userRepository.save(usuario);
              return "Usuário salvo com sucesso!";
       }
    }
    
}
