package app.web_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Anotaçõa que indica que a classe é um componente de controlador REST
public class WelcomeController {
    @GetMapping("/") // Anotação que indica que o método será chamado quando uma requisição GET for feita para a raiz do projeto
    public String welcome() {
        return "Welcome to the Web API!";
    }
}
